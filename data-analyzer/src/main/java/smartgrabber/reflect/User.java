package smartgrabber.reflect;


public class User {
    @NameValidation(nameLength = 10)
    private String name;

    private NameValidation nameValidation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
