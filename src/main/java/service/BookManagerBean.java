package service;

import dal.BookFacade;
import entity.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BookManagerBean {
    @EJB
    BookFacade bookFacade;

    public void createBook(Book book) {
        bookFacade.create(book);
    }
}
