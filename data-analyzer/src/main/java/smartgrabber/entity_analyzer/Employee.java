package smartgrabber.entity_analyzer;

@Table(name = "employee")
public class Employee {

    @PrimaryKey
    @Column(name = "employee_id")
    public Long id;

    @Column(name = "sql_name")
    public String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
