package web;

import entity.Book;
import entity.User;
import service.BookManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static web.utility.Check.checkSessionAndGetUser;
import static web.utility.Check.notValid;
import static web.utility.Navigation.backToMain;
import static web.utility.Navigation.backToModifyJsp;

@WebServlet("/modify")
public class Modify extends HttpServlet {

    @EJB
    BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET received to modify");

        User user = checkSessionAndGetUser(req);
        if (user == null) {
            backToMain(req, resp);
            return;
        }

        Book book = getBookFromRequest(req);
        if (book == null) {
            backToMain(req, resp);
            return;
        }
        req.setAttribute("book", book);
        backToModifyJsp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST received to modify");

        System.out.println(req.getParameter("book"));

        Book book = getBookFromRequest(req);
        if (book == null) {
            System.out.println("Book is null.");
            backToMain(req, resp);
            return;
        }

        String title = req.getParameter("modifyBookTitle");
        String author = req.getParameter("modifyBookAuthor");
        String genre = req.getParameter("modifyBookGenre");

        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);

        bookManagerBean.update(book);

        backToMain(req, resp);
    }

    private Book getBookFromRequest(HttpServletRequest req) {
        String bookIdString = req.getParameter("book");
        if (notValid(bookIdString)) return null;
        int bookId = Integer.parseInt(bookIdString);
        return bookManagerBean.getById(bookId);
    }
}
