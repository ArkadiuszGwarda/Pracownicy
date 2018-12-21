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
            return "Błąd: Podano nieprawidłowy pesel";
        }
        return pesel;
    }

    @Override
    public String toString() {
        return name + " "+surname+", Pesel: "+getPesel()+" "+address;
    }
}

