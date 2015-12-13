import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "main", urlPatterns = {"/*"})
public class AuthFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        servletResponse.setContentType("text/html");
        servletResponse.getWriter().print(getFilterCoud());
        if (!session.isNew()) {
            //session.getAttribute()
        }
        if (filterChain != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    public String getFilterCoud(){
        String html = "<div style='" +
                "width: 120px;" +
                "    color: #ff0;" +
                "    background-color: rgba(148, 0, 173, 0.5);" +
                "    position: absolute;" +
                "    top: 0;" +
                "    right: 0;" +
                "    text-align: center;" +
                "    padding: .5em;" +
                "    border: 10px inset rgba(150, 65, 199, 0.64);" +
                "    border-radius: 50%;" +
                "    cursor: pointer;" +
                "    font-weight: bold;" +
                "    text-shadow: 0 0 2px #000;" +
                "' onclick='alert(\"@WebFilter - AuthFilter is running\")'" +
                " title='@WebFilter - AuthFilter'>Filtering...</div>";
        return html;
    }
}
