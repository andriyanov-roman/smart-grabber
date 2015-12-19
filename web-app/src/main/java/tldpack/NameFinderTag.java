package tldpack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by faust on 13.12.15.
 */
public class NameFinderTag extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter writer = getJspContext().getOut();
        writer.print(getJspContext().getAttribute("value"));
    }


}
