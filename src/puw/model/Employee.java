package puw.model;
import java.util.ArrayList;

public class Employee extends Person {
    private double salary;
    private int experienceInYears;
    private ArrayList <String> noteList;
    private Proffession proffession;



    public Employee(String name, String surname, String pesel, Address address, double salary, int experienceInYears, Proffession proffession ) {
        super(name, surname, pesel, address);
        this.salary = salary;
        this.experienceInYears = experienceInYears;
        this.proffession = proffession;
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

    public Proffession getProffession() {
        return proffession;
    }

    @Override
    public String toString() { return getName()+ " "+ getSurname()+ ", Pesel: "+getPesel()+ getAddress()+" ,pensja: "+ salary+ " ,doświadczenie (w latach): "+experienceInYears+ " ,specjalizacja: "+proffession;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }
    public enum Proffession {Manager, JuniorDeveloper, SeniorDeveloper, Analyst, SoftwareArchitect, Accountant}

    public static void main(String[] args) {
        Employee employee = new Employee("Andrzej", "Chujmietki", "45896578451", new Address("Kaprysowa", "3/75", "20-843", "Lublin"), 3000, 2, Proffession.JuniorDeveloper);
        System.out.println(employee);
    }
}
