package smartgrabber.entity_SQLyzer;

/**
 * Created by mit_OK! on 06.11.2015.
 */
@DataBaseTable("employees")
public class Employee {
    @DataBaseTextColumn("sql_name")
    private String name;

    @DataBaseTextColumn("surname")
    private String surname;

    @DataBaseTextColumn("position")
    private EmployPosition position;

    @DataBaseTextColumn("age")
    private int age;

    @DataBaseTextColumn("maleGender")
    private boolean maleGender;

    public Employee() {
    }

    public Employee(String name, String surname, EmployPosition position, int age, boolean maleGender) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.age = age;
        this.maleGender = maleGender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public EmployPosition getPosition() {
        return position;
    }

    public void setPosition(EmployPosition position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMaleGender() {
        return maleGender;
    }

    public void setMaleGender(boolean maleGender) {
        this.maleGender = maleGender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (maleGender != employee.maleGender) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        return position == employee.position;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (maleGender ? 1 : 0);
        return result;
    }
}
