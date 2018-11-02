package me.ermias.demo;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String depOne;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Department(long id, String depOne, Employee employee) {
        this.id = id;
        this.depOne = depOne;
        this.employee = employee;
    }

    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepOne() {
        return depOne;
    }

    public void setDepOne(String depOne) {
        this.depOne = depOne;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
