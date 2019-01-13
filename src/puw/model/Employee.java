package puw.model;
import java.util.ArrayList;

public class Employee extends Person {
    private double salary;
    private int experienceInYears;
    private ArrayList <String> noteList;
    private Proffession profession;

    public Employee(String name, String surname, String pesel, Address address, double salary, int experienceInYears, Proffession profession) {
        super(name, surname, pesel, address);
        this.salary = salary;
        this.experienceInYears = experienceInYears;
        this.profession = profession;
        noteList = new ArrayList<>();
    }
    public Employee ()
    {
        super();
        this.salary = 0;
        this.experienceInYears = 0;
        this.profession = null;
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

    @Override
    public String toString() {
        return getName() + " " + getSurname() + ", Pesel: " + getPesel() + getAddress() + " ,pensja: " + salary + " ,doświadczenie (w latach): " + experienceInYears + " ,specjalizacja: " + profession;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public Proffession getProfession() {
        return profession;
    }
}
