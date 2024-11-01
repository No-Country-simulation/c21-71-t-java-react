package com.bookstore.api_book.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
@Getter
@Setter
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LoanStatus status;

    private LocalDate loanDate;

    private LocalDate returnDate;

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user.getName() +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
