package com.tap.entity;

public class Employee {
    private int employeeId;
    private String name;
    private String designation;
    private double basicSalary;
    private double taxPercentage;
    private String username;
    private String password;
    private double allowances; // Allowances (e.g., HRA, Travel Allowance, Bonuses)
    private double grossSalary; // Gross Salary = Basic Salary + Allowances

    // Constructors
    public Employee() {}

    public Employee(int employeeId, String name, String designation, double basicSalary, double taxPercentage,
                    String username, String password, double allowances) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;
        this.taxPercentage = taxPercentage;
        this.username = username;
        this.password = password;
        this.allowances = allowances;
        this.grossSalary = basicSalary + allowances; // Calculate grossSalary internally
    }

    // Getters and Setters
    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double getTaxPercentage() { return taxPercentage; }
    public void setTaxPercentage(double taxPercentage) { this.taxPercentage = taxPercentage; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public double getAllowances() { return allowances; }
    public void setAllowances(double allowances) { this.allowances = allowances; }

    public double getGrossSalary() { return grossSalary; }
    public void setGrossSalary(double grossSalary) { this.grossSalary = grossSalary; }

    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + ", Designation=" + designation +
               ", Basic Salary=" + basicSalary + ", Tax=" + taxPercentage + "%, Username=" + username +
               ", Allowances=" + allowances + ", Gross Salary=" + grossSalary + "]";
    }
}