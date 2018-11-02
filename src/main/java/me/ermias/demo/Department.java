package me.ermias.demo;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String depOne;
    private String depTwo;
    private String depThree;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Department(String depOne, String depTwo,
                      String depThree, Employee employee) {
        this.depOne = depOne;
        this.depTwo = depTwo;
        this.depThree = depThree;
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

    public String getDepTwo() {
        return depTwo;
    }

    public void setDepTwo(String depTwo) {
        this.depTwo = depTwo;
    }

    public String getDepThree() {
        return depThree;
    }

    public void setDepThree(String depThree) {
        this.depThree = depThree;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
