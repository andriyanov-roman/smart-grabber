package tldpack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by alisa on 13/12/15.
 */
public class PassTag extends SimpleTagSupport {
    private RandomPassGenerator password;
    @Override
    public void doTag() throws JspException, IOException {
       password = new RandomPassGenerator();
        JspWriter writer = getJspContext().getOut();
       writer.write(password.get());
       // writer.write("Hello");
    }
}
