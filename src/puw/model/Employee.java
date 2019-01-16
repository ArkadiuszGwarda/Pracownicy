package puw.model;
import java.util.ArrayList;
import java.util.Scanner;

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
        StringBuilder builder = new StringBuilder(super.toString()).append('\n')
                .append("Stanowisko: ").append(profession).append('\n')
                .append("Doświadczenie: ").append(experienceInYears).append(" ")
                .append(experienceInYears > 1 ? "lat" : "rok").append('\n')
                .append("Notatki: ");
        if (noteList.isEmpty())
            builder.append("brak");
        else {
            builder.append(noteList.size());
            for (int i = 0; i < noteList.size(); i++)
                builder.append("\n\t").append(i + 1).append(" ").append(noteList.get(i));
        }
        return builder.toString();
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

    @Override
    public void readFromConsole(Scanner scanner) {
        super.readFromConsole(scanner);
        System.out.println("Podaj dane o pracowniku:");
        System.out.print("Wynagrodzenie: ");
        salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Doświadczenie: ");
        experienceInYears = scanner.nextInt();
        scanner.nextLine();
    }
}
