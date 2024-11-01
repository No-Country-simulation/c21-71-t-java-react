package com.bookstore.api_book.model;

public enum LoanStatus {
    PENDING,  // En el caso de que el libro haya sido prestado pero no ha llegado la fecha limite de retorno
    RETURNED, // El libro ha sido devuelto dentro del plazo
    OVERDUE // El libro no ha sido devuelto a tiempo, y esta en mora
}
