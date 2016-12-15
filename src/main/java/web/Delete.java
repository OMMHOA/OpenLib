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

import static web.utility.Navigation.backToMain;

@WebServlet("/delete")
public class Delete extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET received to delete");

        int bookId = Integer.parseInt(req.getParameter("book"));
        Book book = bookManagerBean.getById(bookId);
        if (book == null) {
            System.out.println("Book not found to delete");
        } else {
            bookManagerBean.remove(book);
        }

        backToMain(req, resp);
    }
}
