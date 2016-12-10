package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable{

    @Id
    private String username;
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Book> ownedBooks;

    @OneToMany(mappedBy = "borrower")
    private List<Borrow> myBorrows;

    @OneToMany(mappedBy = "lender")
    private List<Borrow> myLends;

    public User() {
    }

    public List<Borrow> getMyLends() {
        return myLends;
    }

    public void setMyLends(List<Borrow> myLends) {
        this.myLends = myLends;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getOwnedBooks() {
        return ownedBooks;
    }

    public void setOwnedBooks(List<Book> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }

    public List<Borrow> getMyBorrows() {
        return myBorrows;
    }

    public void setMyBorrows(List<Borrow> myBorrows) {
        this.myBorrows = myBorrows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return username.equals(user.username);

    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
