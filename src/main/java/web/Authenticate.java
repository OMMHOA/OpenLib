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

import static web.utility.Check.checkSessionAndGetUser;
import static web.utility.Check.notValid;
import static web.utility.Navigation.backToIndexJsp;


@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {

    @EJB
    private UserManagerBean userManagerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET received to Authenticate");

        User user = checkSessionAndGetUser(request);
        if (user == null) {
            backToIndexJsp(request, response);
            return;
        }

        authenticate(request, response, user.getUsername(), user.getPassword());
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST received to Authenticate");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        authenticate(request, response, name, password);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response, String name, String password)
            throws ServletException, IOException {

        if (notValid(name, password)) return;

        User user = new User(name, password);
        if (userManagerBean.isAuthCorrect(user)) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("Main").forward(request, response);
            return;
        }

        request.setAttribute("loginFailed", "Invalid username or password");
        backToIndexJsp(request, response);
    }
}
