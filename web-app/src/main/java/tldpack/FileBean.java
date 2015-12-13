package tldpack;

import java.io.File;

/**
 * Created by dm on 13.12.15.
 */
public class FileBean implements java.io.Serializable {
    private String filename;
    private File file;

    public FileBean() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
