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

import static web.CreateAccount.notValid;
import static web.utility.Navigation.backToAuth;
import static web.utility.Navigation.backToIndexOrMain;
import static web.utility.Navigation.backToMain;

@WebServlet("/upload")
public class Upload extends HttpServlet {

    @EJB
    private BookManagerBean bookManagerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET received to upload");

        backToIndexOrMain(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST received to upload");

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("Authenticate").forward(request, response);
        }

        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");

        if (notValid(title, author, genre)) {
            backToAuth(request, response);
        }

        Book book = new Book(title, author, genre, user);
        bookManagerBean.createBook(book);

        backToMain(request, response);
    }
}
