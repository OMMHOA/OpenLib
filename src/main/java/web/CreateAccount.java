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

import static web.utility.Check.notValid;
import static web.utility.Navigation.backToAuth;
import static web.utility.Navigation.backToIndex;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {

    @EJB
    private UserManagerBean userManagerBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET received to CreateAccount");

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        out.println("hello");

        backToAuth(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST received to CreateAccount");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (notValid(name, password)) {
            request.setAttribute("userAlreadyExists", "Password and username field can not be empty!");
            backToIndex(request, response);
            return;
        }

        User user = new User(name, password);
        if (userManagerBean.isUserAlreadyExists(user)) {
            request.setAttribute("userAlreadyExists", "User already exists!");
            backToIndex(request, response);
            return;
        }
        userManagerBean.createUser(user);

        backToAuth(request, response);
    }
}
