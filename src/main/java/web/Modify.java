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

@WebServlet("/modify")
public class Modify extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book"));
        Book book = bookManagerBean.getById(bookId);
        System.out.println(book.getTitle());
    }
}
