package puw.model;

public class Address {
    private String city;
    private String street;
    private String houseAndFlatNumber;
    private String Zipcode;

    public Address (String street, String houseAndFlatNumber, String Zipcode, String city)
    {
        this.street = street;
        this.houseAndFlatNumber = houseAndFlatNumber;
        this.Zipcode = Zipcode;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseAndFlatNumber() {
        return houseAndFlatNumber;
    }

    public String getZipcode() {
        return Zipcode;
    }

    @Override
    public String toString() {
        return "Adres pracownika: "+ street+" " +houseAndFlatNumber+ ", "+Zipcode+ " "+city;
    }
}

