package entity;

import enums.ProductTypes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
public class Company {
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;
    @Transient
    private List<Employee> employees;
    @Transient
    private List<Product> products;

    public Company() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
