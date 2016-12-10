package dal;

import entity.Borrow;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BorrowFacade extends AbstractFacade<Borrow> {
    @PersistenceContext
    private EntityManager em;

    public BorrowFacade() {
        super(Borrow.class);
    }

    @Override
    protected EntityManager em() {
        return em;
    }
}
