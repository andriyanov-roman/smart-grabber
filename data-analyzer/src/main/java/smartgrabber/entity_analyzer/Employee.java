package smartgrabber.entity_analyzer;

@Table(name = "employee")
public class Employee {

    @PrimaryKey
    @Column(name = "employee_id")
    public Long id;
}
