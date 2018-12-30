package puw.model;
import java.util.ArrayList;

public class Employee extends Person {
    private double salary;
    private int experienceInYears;
    private ArrayList <String> noteList;



    public Employee(String name, String surname, String pesel, Address address, double salary, int experienceInYears ) {
        super(name, surname, pesel, address);
        this.salary = salary;
        this.experienceInYears = experienceInYears;
        noteList = new ArrayList<>();
    }
    
    public void addNote (String note)
    {
        noteList.add(note);
    }
    public void showNotes ()
    {
        System.out.println(noteList);
    }
    public void raiseSalary (double bonus)
    {
        salary+=bonus;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }
}
