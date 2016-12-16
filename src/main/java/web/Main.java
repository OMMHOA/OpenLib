package web;

import entity.Book;
import entity.User;
import service.BookManagerBean;
import service.UserManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static web.utility.AttributeKeys.*;
import static web.utility.Check.checkSessionAndGetUser;
import static web.utility.Check.notValid;
import static web.utility.Navigation.backToMainJsp;
import static web.utility.Navigation.backToNologinJsp;

@WebServlet("/Main")
public class Main extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @EJB
    UserManagerBean userManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET received to Main");

        req.getSession().setAttribute(BOOKS, bookManagerBean.getAll());
        req.getSession().setAttribute(USERS, userManagerBean.getAll());

        if (isUserAuthentic(req)) {
            backToMainJsp(req, resp);
        } else {
            backToNologinJsp(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST received to Main");

        List<User> users = userManagerBean.getAll();
        req.getSession().setAttribute(USERS, users);

        List<Book> books;

        String title = req.getParameter(TITLE);
        String author = req.getParameter(AUTHOR);
        String owner = req.getParameter(OWNER);
        if (!notValid(title)) {
            books = bookManagerBean.getByTitle(title);
        } else if (!notValid(author)) {
            books = bookManagerBean.getByAuthor(author);
        } else if (owner == null || owner.equals("all")) {
            books = bookManagerBean.getAll();
        } else {
            books = bookManagerBean.getByOwner(owner);
        }
        req.getSession().setAttribute(BOOKS, books);
        if (isUserAuthentic(req)) {
            backToMainJsp(req, resp);
        } else {
            backToNologinJsp(req, resp);
        }
    }

    private boolean isUserAuthentic(HttpServletRequest request) {
        User user = checkSessionAndGetUser(request);
        return user != null && !notValid(user.getUsername(), user.getPassword())
                && userManagerBean.isAuthCorrect(user);
    }
}
