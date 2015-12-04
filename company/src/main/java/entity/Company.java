package entity;

import enums.ProductTypes;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue
    @Column(name="company_id")
    private Long id;
    private String companyName;
    @OneToMany(mappedBy="company")
    private List<Employee> employees;
    @Transient
    private List<Product> products;

    public Company() {
        employees = new ArrayList<Employee>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != null ? !id.equals(company.id) : company.id != null) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (employees != null ? !employees.equals(company.employees) : company.employees != null) return false;
        return !(products != null ? !products.equals(company.products) : company.products != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", employees=" + employees +
                ", products=" + products +
                '}';
    }

    public void addEmployee(Employee employee) {
        if (!getEmployees().contains(employee)) {
            getEmployees().add(employee);
            /*if (employee.getCompany() != null) {
                employee.getCompany().getEmployees().remove(employee);
            }*/
            employee.setCompany(this);
        }
    }

    public Long getId() {
        return id;
    }
}
