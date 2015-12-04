import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by faust on 28.11.15.
 */
@WebServlet(value="/hello")
public class HelloWorld extends HttpServlet {
    public static final String FILE_NAME = "/home/faust/IdeaProjects/smart-grabber/web-app/src/main/resources/login.html";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String result="";
        PrintWriter out = resp.getWriter();
        Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).forEach(out::print);

        //out.print(result);

    }
}
