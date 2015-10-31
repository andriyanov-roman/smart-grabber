package lesson2.immutable_objects;

/**
 * Created by R-Tem on 26.10.2015.
 */
public final class ImmutableStudent {

    private final String Name;

    public String getName() {
        return Name;
    }
//    public void setName(String name) {
//        Name = name;
//    }

    public ImmutableStudent(String name) {
        Name = name;
    }
}
