package dal;

import entity.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookFacade extends AbstractFacade<Book>{

    @PersistenceContext
    private EntityManager em;

    public BookFacade() {
        super(Book.class);
    }

    @Override
    protected EntityManager em() {
        return em;
    }
}
