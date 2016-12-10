package web;


import service.UserManagerBean;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet
public class Authenticate extends HttpServlet {

    @EJB
    private UserManagerBean userManagerBean;


}
