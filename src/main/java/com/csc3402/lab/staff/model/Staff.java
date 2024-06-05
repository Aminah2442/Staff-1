package com.csc3402.lab.staff.model;

import jakarta.persistence.*;

// Our Java object
@Entity
public class Staff {

    // Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;
    @Column(name = "first_name")
    private String fname;
    @Column(name = "last_name")
    private String lname;
    @Column(name = "salary")
    private Integer salary;

    // Foreign key
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    // Constructors
    public Staff() {
    }

    public Staff(String fname, String lname, Integer salary) {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
    }

    // Getter and Setters
    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
