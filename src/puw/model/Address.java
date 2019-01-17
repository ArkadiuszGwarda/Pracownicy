package puw.model;

import java.io.Serializable;
import java.util.Scanner;

public class Address implements Serializable, ConsoleReader {
    private static final long serialVersionUID = -334226053089611966L;
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

    public String fullInfo() {
        return new StringBuilder()
                .append("Ulica: ").append(street).append('\n')
                .append("Numer domu/mieszkania: ").append(houseAndFlatNumber).append('\n')
                .append("Kod pocztowy: ").append(zipCode).append('\n')
                .append("Miasto: ").append(city)
                .toString();
    }

    @Override
    public String toString() {
        return city;
    }

    @Override
    public void readFromConsole(Scanner scanner) {
        System.out.println("Wprowadź adres:");
        System.out.print("Ulica: ");
        street = scanner.nextLine();
        System.out.print("Numer domu/mieszkania: ");
        houseAndFlatNumber = scanner.nextLine();
        System.out.print("Kod pocztowy: ");
        zipCode = scanner.nextLine();
        System.out.print("Miasto: ");
        city = scanner.nextLine();
    }
}

