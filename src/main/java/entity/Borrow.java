package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Borrow implements Serializable{

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @NotNull
    private User lender;

    @ManyToOne
    @NotNull
    private User borrower;

    @ManyToOne
    @NotNull
    private Book book;

    public Borrow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
