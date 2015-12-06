package servlet;

import controllers.UserController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet (urlPatterns = "/main")
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/jsp/login.jsp");
          rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    private void processRequest (HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        // Rewrite for CommandRequest.java
        UserController userController = new UserController();
         String pageUrl = "";
             try {
                      pageUrl = userController.execute(req, resp);
                 } catch (ServletException e) {
                       e.printStackTrace();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              RequestDispatcher rd = getServletContext().getRequestDispatcher(pageUrl);
                rd.forward(req,resp);
         }
}
