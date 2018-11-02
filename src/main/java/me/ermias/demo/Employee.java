package me.ermias.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fName;
    private String lName;
    private String jobTitle;

    @OneToMany(mappedBy =  "employee", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    public Set<Department> departments;

    public Employee(String fName, String lName, String jobTitle,
                    Set<Department> departments) {
        this.fName = fName;
        this.lName = lName;
        this.jobTitle = jobTitle;
        this.departments = departments;
    }

    public Employee() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}
