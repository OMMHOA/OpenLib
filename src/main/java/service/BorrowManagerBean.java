package service;

import dal.BorrowFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BorrowManagerBean {
    @EJB
    BorrowFacade borrowFacade;


}
