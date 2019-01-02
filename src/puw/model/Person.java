package puw.model;

public class Person
{
    private String name;
    private String surname;
    private String pesel;
    private Address address;

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

    public String getAddress() {
        return address.getAddress();
    }

}

