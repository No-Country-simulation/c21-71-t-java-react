package com.bookstore.api_book.controller;

import com.bookstore.api_book.dto.LoanDto;
import com.bookstore.api_book.dto.LoanRequest;
import com.bookstore.api_book.dto.LoanResponse;
import com.bookstore.api_book.model.Loan;
import com.bookstore.api_book.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {this.loanService = loanService;}

    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@RequestBody LoanRequest loanRequest) {
        LoanResponse loan = loanService.createLoan(loanRequest);
        return ResponseEntity.ok(loan);
    }

    @PostMapping("/{loanId}/return")
    public ResponseEntity<String> returnLoan(@PathVariable Long loanId) {
        try{
            loanService.returnLoan(loanId);
            return ResponseEntity.ok("Book returned successfully");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanDto>> getLoansByUserId(@PathVariable Long userId) {
        List<LoanDto> loanResponses = loanService.findLoanByUserId(userId);
        if(loanResponses.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(loanResponses);
    }

    @GetMapping
    public ResponseEntity<List<LoanResponse>> getLoans(){
        List<LoanResponse> loans = loanService.getAllLoan();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }


}
