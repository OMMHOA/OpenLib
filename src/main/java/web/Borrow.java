package web;

import entity.Book;
import service.BookManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static web.utility.Check.checkBookAndGetBook;
import static web.utility.Navigation.backToMain;

@WebServlet("/borrow")
public class Borrow extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET received to borrow");

        Book book = checkBookAndGetBook(req,  bookManagerBean);
        if (book == null) {
            backToMain(req, resp);
        }

        backToMain(req, resp);
    }
}
