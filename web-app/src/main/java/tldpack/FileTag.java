package tldpack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Formatter;

/**
 * Created by dm on 13.12.15.
 */
public class FileTag extends SimpleTagSupport {
    private String filename;
    private  FileBean fileBean;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileBean getFileBean() {
        return fileBean;
    }

    public void setFileBean(FileBean fileBean) {
        this.fileBean = fileBean;
    }

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            if(filename!=null) {
                out.write("there is filename");
                out.write(this.filename);
            }else{
                out.write("there is no filename");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
