package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.LoanDto;
import com.bookstore.api_book.dto.LoanRequest;
import com.bookstore.api_book.dto.LoanResponse;
import com.bookstore.api_book.model.Book;
import com.bookstore.api_book.model.Loan;
import com.bookstore.api_book.model.LoanStatus;
import com.bookstore.api_book.model.User;
import com.bookstore.api_book.repository.BookRepository;
import com.bookstore.api_book.repository.LoanRepository;
import com.bookstore.api_book.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    private final BookRepository bookRepository;

    private final UserRepository userRepository;

    public LoanServiceImpl(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LoanResponse createLoan(LoanRequest loanRequest) {

        Book book = bookRepository.findById(loanRequest.bookId()).orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.hasStock()){
            throw new RuntimeException("Book has no stock");
        }

        User user = userRepository.findByEmail(loanRequest.email()).orElseThrow(() -> new RuntimeException("User not found"));

        LocalDate loanDate = LocalDate.now();
        LocalDate returnDate = loanDate.plusMonths(1);

        book.reduceStock();
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setUser(user);
        loan.setLoanDate(loanDate);
        loan.setReturnDate(returnDate);
        loan.setStatus(LoanStatus.PENDING);
        return mapToLoanResponse(loanRepository.save(loan));
    }

    @Override
    public Loan returnLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
        if (LocalDate.now().isAfter(loan.getReturnDate())){
            loan.setStatus(LoanStatus.OVERDUE);
        } else{
            loan.setStatus(LoanStatus.RETURNED);
        }
        Book book = loan.getBook();
        book.increaseStock();
        bookRepository.save(book);
        return loan;
    }

    @Override
    public List<LoanResponse> getAllLoan() {
        return loanRepository.findAll().stream()
                .map(this::mapToLoanResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<LoanDto> findLoanByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return loanRepository.findByUserId(userId)
                .stream().map(this::mapToLoanDto)
                .collect(Collectors.toList());
    }

    @Override
    public Loan getLoanById(Long id) {
        if (loanRepository.existsById(id)){
            Optional<Loan> loan = loanRepository.findById(id);
            if (loan.isPresent()){
                return loan.get();
            }
        }
        return null;
    }

    @Override
    public void deleteLoanById(Long id) {
        if(!loanRepository.existsById(id)){
            throw new RuntimeException("Loan not found");
        }
        loanRepository.deleteById(id);
    }

    private LoanDto mapToLoanDto(Loan loan){
        return new LoanDto(
                loan.getId(),
                loan.getBook().getId(),
                loan.getLoanDate(),
                loan.getReturnDate()
        );
    }

    private LoanResponse mapToLoanResponse(Loan loan) {
        return new LoanResponse(
                loan.getUser().getName(),
                loan.getBook().getTitle(),
                loan.getLoanDate(),
                loan.getReturnDate()
        );
    }
}
