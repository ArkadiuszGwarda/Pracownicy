package puw.model;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable, ConsoleReader {
    private static final long serialVersionUID = -449147914124602859L;
    private String name;
    private String surname;
    private String pesel;
    private Address address;

    public Person() {
        name = "unknown";
        surname = "unkown";
        pesel = "0000000000000";
        address = new Address();
    }

    public Person (String name, String surname, String pesel, Address address)
    {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        if (pesel.length()!=11) {
            return "Podano nieprawidłowy pesel";
        }
        return pesel;
    }

    public Address getAddress() {
        return address;
    }

    public String fullInfo() {
        return new StringBuilder()
                .append("Imię: ").append(name).append('\n')
                .append("Nazwisko: ").append(surname).append('\n')
                .append("Pesel: ").append(pesel).append('\n')
                .append(address.fullInfo())
                .toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", name, surname, address);
    }

    @Override
    public void readFromConsole(Scanner scanner) {
        System.out.println("Wprowadź dane osobowe:");
        System.out.print("Imię: ");
        name = scanner.nextLine();
        System.out.print("Nazwisko: ");
        surname = scanner.nextLine();
        System.out.print("Pesel: ");
        pesel = scanner.nextLine();
        address.readFromConsole(scanner);
    }
}

