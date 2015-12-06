import controller.CommandRequest;
import controller.ICommand;
import controller.UserController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class CompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageURL = "/jsp/login.jsp";
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        if (!session.isNew()){
            if (cookies.length>0){
                for (Cookie c : cookies){
                    if (c.getName().equals("logged") && c.getValue().equals("true")){
                        pageURL = "/jsp/company.jsp";
                        break;
                    }
                }
            }
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageURL);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    private void processRequest (HttpServletRequest req, HttpServletResponse resp){
        ICommand userController = CommandRequest.getInstance().getCommand(req);
        String pageUrl = "";
        try {
            pageUrl = userController.execute(req, resp);
            getServletContext().getRequestDispatcher(pageUrl).forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
