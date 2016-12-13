package web.utility;

import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class Check {
    public static boolean notValid(String... strings) {
        for (String string : strings) {
            if (string == null || string.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static User checkSessionAndGetUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }

        return (User) request.getSession().getAttribute("user");
    }
}
