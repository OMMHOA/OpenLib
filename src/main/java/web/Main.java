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
import java.util.List;

import static web.utility.Navigation.backToMain;

@WebServlet("/Main")
public class Main extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET received to Main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST received to Main");
        String whatToList = (String) req.getAttribute("list");
        if (whatToList == null || whatToList.equals("all")) {
            List<Book> books = bookManagerBean.getAll();
            req.setAttribute("books", books);
            backToMain(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
