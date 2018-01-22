package com.example.amrthaku.feedbackform;

/**
 * Created by amrthaku on 1/17/2018.
 */

public class Employee {
    String first_name,last_name,empId;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String empId) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.empId = empId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}
