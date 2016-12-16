package web.utility;

import entity.Book;
import entity.User;
import service.BookManagerBean;

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

    public static Book checkBookAndGetBook(HttpServletRequest req, BookManagerBean bookManagerBean) {
        String bookIdString = req.getParameter("book");
        if (notValid(bookIdString)) return null;
        int bookId = Integer.parseInt(bookIdString);
        return bookManagerBean.getById(bookId);
    }
}
