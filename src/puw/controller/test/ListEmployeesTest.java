package puw.controller.test;

import puw.controller.Constants;
import puw.controller.Controller;
import puw.model.Business;
import puw.model.Developer;
import puw.model.Employee;
import puw.model.Profession;

import java.util.Scanner;

public class ListEmployeesTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Business business = new Business(Constants.COMPANY_NAME, Constants.NIP, 100000);
        Employee employee = new Employee(Profession.MANAGER);
        employee.readFromConsole(scanner);
        business.hireEmployee(employee);
        Developer developer = new Developer();
        developer.readFromConsole(scanner);
        business.hireEmployee(developer);
        Controller controller = new Controller(business);
        controller.start();
    }
}
