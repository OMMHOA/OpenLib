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
import static web.CreateAccount.notValid;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {

    @EJB
    private UserManagerBean userManagerBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET received to Authenticate");

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        authenticate(request, response, user.getUsername(), user.getPassword());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST received to Authenticate");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        authenticate(request, response, name, password);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response, String name, String password) throws ServletException, IOException {
        if (notValid(name, password)) return;

        User user = getUser(name, password);
        if (userManagerBean.isAuthCorrect(user)) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("main.jsp").forward(request, response);
            return;
        }

        request.setAttribute("loginFailed", "Invalid username or password");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
