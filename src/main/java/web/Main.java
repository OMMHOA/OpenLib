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

import static web.utility.Navigation.backToAuth;
import static web.utility.Navigation.backToMain;

@WebServlet("/Main")
public class Main extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @EJB
    UserManagerBean userManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET received to Main");

        List<Book> books = bookManagerBean.getAll();
        List<User> users = userManagerBean.getAll();
        req.setAttribute("books", books);
        req.setAttribute("users", users);


        backToAuth(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST received to Main");
        String whatToList = (String) req.getAttribute("list");
        if (whatToList == null || whatToList.equals("all")) {
            List<Book> books = bookManagerBean.getAll();
            List<User> users = userManagerBean.getAll();
            req.setAttribute("books", books);
            req.setAttribute("users", users);
            backToMain(req, resp);
        }
    }
}
