package puw.model;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 0;
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
    public Address ()
    {
        this.street = "unknown";
        this.houseAndFlatNumber = "unknown";
        this.zipCode = "unknown";
        this.city = "unknown";
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
        if (zipCode.length()!=6)
            return "Błędny kod pocztowy";
        return zipCode;
    }


    public String getAddress() {
        return ",adres pracownika: "+ street+" " +houseAndFlatNumber+ ", "+getZipCode()+ " "+city;
    }
}

