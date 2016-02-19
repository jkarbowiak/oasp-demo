package org.zosia.oasp.to;

public class BookLoanResultTo {
    private final BookLoanStatus status;

    public BookLoanResultTo(BookLoanStatus status) {
        this.status = status;
    }

    public BookLoanStatus getStatus() {
        return status;
    }

}
