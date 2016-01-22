package controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vlas on 05.12.15.
 */
public class UserController implements ICommand {
    public static final String VALID_USER_NAME = "admin";
    public static final String VALID_USER_PASSWORD = "1234";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if (!session.isNew()){
            if (cookies.length>0) {
                for (Cookie c : cookies){
                    if (c.getName().equals("logged") && c.getValue().equals("true")){
                        return "/jsp/company.jsp";
                    }
                }
            }

        }
        String login = request.getParameter("user_name");
        if (login.equals(VALID_USER_NAME)) {
            String pass = request.getParameter("password");
            if (pass.equals(VALID_USER_PASSWORD)) {
                Cookie cookieLogged = new Cookie("logged", "true");
                cookieLogged.setMaxAge(24*60*60);
                response.addCookie(cookieLogged);
                return "/jsp/company.jsp";
            }
        }
        return "/jsp/login.jsp";
    }

}
