package puw.model;

import java.util.List;

public class Business {
    private String name;
    private String nip;
    private double balance;
    private List<Employee> employees;

    public Business() {
    }

    public Business(String name, String nip, double balance) {
        this.name = name;
        this.nip = nip;
        this.balance = balance;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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
}
