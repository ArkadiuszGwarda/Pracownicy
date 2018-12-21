package puw.model;

public class Address {
    private String city;
    private String street;
    private String houseAndFlatNumber;
    private String zipCode;

    public Address (String street, String houseAndFlatNumber,String zipCode,  String city)
    {
        this.street = street;
        this.houseAndFlatNumber = houseAndFlatNumber;
        this.zipCode = zipCode;
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

    public String getZipCode() {
        if (zipCode.length()!=5)
            return "Błędny kod pocztowy";
        return zipCode;
    }

    @Override
    public String toString() {
        return ",adres pracownika: "+ street+" " +houseAndFlatNumber+ ", "+getZipCode()+ " "+city;
    }
}

