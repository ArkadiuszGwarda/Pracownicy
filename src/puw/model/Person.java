package puw.model;

import java.io.Serializable;

public class Person implements Serializable
{
    private static final long serialVersionUID = 0;
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
}

