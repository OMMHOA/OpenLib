package web;

import service.BookManagerBean;
import service.UserManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static web.utility.AttributeKeys.BOOKS;
import static web.utility.AttributeKeys.USERS;
import static web.utility.Navigation.backToNologinJsp;

@WebServlet("/guest")
public class Guest extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @EJB
    UserManagerBean userManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET received to guest");
        req.getSession().setAttribute(BOOKS, bookManagerBean.getAll());
        req.getSession().setAttribute(USERS, userManagerBean.getAll());
        backToNologinJsp(req, resp);
    }
}
