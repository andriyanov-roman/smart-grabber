package dto;

/**
 * Created by faust on 13.12.15.
 */
public class EmployeeDTO {
    private String name;
    private String surname;
    private double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static String retrieveEmployee (String emplName) {
        if (emplName.equals("Ivan")){
            return "Ivan Ivanov 3200$";
        } else if (emplName.equals("Petro")){
            return "Petro Petrov 700$";
        }
        return "Employee with name \""+emplName+"\" not faund :(";
    }
}
