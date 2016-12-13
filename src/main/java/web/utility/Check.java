package web.utility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static web.utility.Navigation.backToIndex;

public abstract class Check {
    public static boolean notValid(String... strings) {
        for (String string : strings) {
            if (string == null || string.length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean objectNull(HttpServletRequest request, HttpServletResponse response, Object object)
            throws ServletException, IOException {
        if (object == null) {
            backToIndex(request, response);
            return true;
        }
        return false;
    }
}
