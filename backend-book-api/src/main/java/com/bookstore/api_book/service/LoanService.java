package com.bookstore.api_book.service;

import com.bookstore.api_book.dto.LoanDto;
import com.bookstore.api_book.dto.LoanRequest;
import com.bookstore.api_book.dto.LoanResponse;
import com.bookstore.api_book.model.Loan;

import java.util.List;

public interface LoanService {

    LoanResponse createLoan(LoanRequest loanRequest);

    Loan returnLoan(Long loanId);

    List<LoanResponse> getAllLoan();

    List<LoanDto> findLoanByUserId(Long userId);

    Loan getLoanById(Long id);

    void deleteLoanById(Long id);
}
