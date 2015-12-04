package smartgrabber.concurrency.eighth_simafor;

/**
 * Created by randriyanov on 26.08.15.
 */
public class ResourceException extends Exception {

    public ResourceException() {
        super();
    }

    public ResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
}
