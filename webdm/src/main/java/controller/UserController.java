package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vlas on 05.12.15.
 */
public class UserController implements ICommand {
    public static final String VALID_USER_NAME = "admin@gmail.com";
    public static final String VALID_USER_PASSWORD = "1234";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("user_name");
        if (login.equals(VALID_USER_NAME)) {
            String pass = request.getParameter("password");
            if (pass.equals(VALID_USER_PASSWORD)) {
                return "/jsp/company.jsp";
            }
        }
        return"/jsp/login.jsp";
    }

}
