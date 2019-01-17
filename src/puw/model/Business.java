package puw.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Business implements Serializable {
    private static final long serialVersionUID = 6698304553771718837L;
    private String name;
    private String nip;
    private double balance;
    private List<Employee> employees;

    public Business(String name, String nip, double balance) {
        this.name = name;
        this.nip = nip;
        this.balance = balance;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNip() {
        return nip;
    }

    public double getBalance() {
        return balance;
    }

    public void hireEmployee(Employee employee) {
        if (employee != null) {
            employees.add(employee);
        }
    }

    public void fireEmployee(Employee employee) {
        if (employee != null) {
            employees.remove(employee);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Business{" +
                "name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", balance=" + balance +
                ", employees=" + employees +
                '}';
    }

    public void writeToJson(File file) {

    }
}
