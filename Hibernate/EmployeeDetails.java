package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

 //This tells hibernate where the table is located and the name of teh table
 @Entity (name="EMPLOYEE_DETAILS")
 public class EmployeeDetails implements Serializable {
    
    // this tells hibernate that this is the prmary key
    //and the name of the column in the database 
    @Id
    @Column (name="EMPLOYEE_ID") // this can be placed on top of the getter
    private int employeeId;
    @Column (name="EMPLOYEE_NAME") // this can be placed on top of the getter
    private String employeeName;
    @Column (name="EMPLOYEE_SENIORITY") // this can be placed on top of the getter
    private int employeeSeniority;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeSeniority() {
        return employeeSeniority;
    }

    public void setEmployeeSeniority(int employeeSeniority) {
        this.employeeSeniority = employeeSeniority;
    }

    
    
     
}
