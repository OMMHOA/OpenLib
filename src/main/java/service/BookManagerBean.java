package service;

import dal.BookFacade;
import entity.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BookManagerBean {
    @EJB
    BookFacade bookFacade;

    public void createBook(Book book) {
        bookFacade.create(book);
    }

    public List<Book> getAll() {
        return bookFacade.findAll();
    }

    public List<Book> getByOwner(String ownerId) {
        return bookFacade.findAllByOwner(ownerId);
    }

    public List<Book> getByTitle(String title) {
        return bookFacade.findAllByTitle(title.toLowerCase());
    }

    public List<Book> getByAuthor(String author) {
        return bookFacade.findAllByAuthor(author.toLowerCase());
    }

    public Book getById(int id) {
        return bookFacade.find(id);
    }

    public void remove(Book book) {
        bookFacade.remove(book);
    }
}
