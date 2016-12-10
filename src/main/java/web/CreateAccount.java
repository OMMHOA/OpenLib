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

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {

    @EJB
    private UserManagerBean userManagerBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET received to CreateAccount");

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        out.println("hello");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST received to CreateAccount");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (notValid(request, response, password, name)) return;

        User user = getUser(name, password);
        if (userManagerBean.isUserAlreadyExists(user)) {
            request.setAttribute("userAlreadyExists", "User already exists!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        userManagerBean.createUser(user);

        request.setAttribute("username", name);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    private boolean notValid(HttpServletRequest request, HttpServletResponse response,
                             String password, String name) throws ServletException, IOException {
        if (password.length() == 0 || name.length() == 0) {
            request.setAttribute("userAlreadyExists", "Password and username field can not be empty!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return true;
        }
        return false;
    }

    static User getUser(String name, String password) {
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        return user;
    }
}