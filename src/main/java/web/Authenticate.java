package web;


import entity.User;
import service.UserManagerBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static web.CreateAccount.getUser;

@WebServlet("/main")
public class Authenticate extends HttpServlet {

    @EJB
    private UserManagerBean userManagerBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET received to CreateAccount");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST received to CreateAccount");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = getUser(name, password);
        if (userManagerBean.isAuthCorrect(user)) {
            request.setAttribute("username", name);
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }

        request.setAttribute("loginFailed", "Invalid username or password");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
