package dal;

import entity.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public List<Book> findAllByOwner(String ownerId) {
        CriteriaBuilder cb = em().getCriteriaBuilder();
        CriteriaQuery<Book> cq= cb.createQuery(Book.class);
        Root<Book> b = cq.from(Book.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        cq.select(b).where(cb.equal(b.get("owner").get("username"), p));
        TypedQuery<Book> query = em().createQuery(cq);
        query.setParameter(p, ownerId);
        return query.getResultList();
    }

    public List<Book> findAllByTitle(String title) {
        CriteriaBuilder cb = em().getCriteriaBuilder();
        CriteriaQuery<Book> cq= cb.createQuery(Book.class);
        Root<Book> b = cq.from(Book.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        cq.select(b).where(
                cb.like(
                        cb.lower(
                                b.<String>get("title")
                        ), p
                )
        );
        TypedQuery<Book> query = em().createQuery(cq);
        String t = "%" + title.toLowerCase() + "%";
        query.setParameter(p, t);
        return query.getResultList();
    }

    public List<Book> findAllByAuthor(String author) {
        CriteriaBuilder cb = em().getCriteriaBuilder();
        CriteriaQuery<Book> cq= cb.createQuery(Book.class);
        Root<Book> b = cq.from(Book.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        cq.select(b).where(
                cb.like(
                        cb.lower(
                                b.<String>get("author")
                        ), p
                )
        );
        TypedQuery<Book> query = em().createQuery(cq);
        String a = "%" + author.toLowerCase() + "%";
        query.setParameter(p, a);
        return query.getResultList();
    }
}
