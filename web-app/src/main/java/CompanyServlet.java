import controller.CommandRequest;
import controller.IComm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/main")
public class CompanyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageURL = "/jsp/login.jsp";
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
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
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp){
        try {
            getServletContext()
                    .getRequestDispatcher(CommandRequest.getInstance().getCommand(req).execute(req, resp))
                    .forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
