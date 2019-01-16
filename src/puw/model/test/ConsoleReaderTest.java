package puw.model.test;

import puw.model.Developer;
import puw.model.Employee;
import puw.model.Profession;

import java.util.Scanner;

public class ConsoleReaderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee(Profession.MANAGER);
        employee.addNote("Do zwolnienia");
        employee.readFromConsole(scanner);
        System.out.println();
        System.out.println(employee.fullInfo());

        Developer developer = new Developer();
        developer.addNote("Solidny dać podwyżkę :)");
        developer.readFromConsole(scanner);
        System.out.println();
        System.out.println(developer.fullInfo());
    }
}
