package puw.controller;

import puw.model.*;
import puw.view.Menu;
import puw.view.MenuItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Controller {
    private Menu currentMenu;
    private Menu mainMenu;
    private Menu manageMenu;
    private Menu listMenu;
    private Menu filterMenu;
    private Menu projectsMenu;
    private Menu vatsMenu;
    private Scanner scanner;
    private boolean isTheEnd;
    private Business business;

    public Controller() {
        isTheEnd = false;
        scanner = new Scanner(System.in);
        createMenus();
        currentMenu = mainMenu;
        business = new Business(Constants.COMPANY_NAME, Constants.NIP, 0);
    }

    public Controller(Business business) {
        this();
        this.business = business;
    }

    public void start() {
        System.out.println(Constants.WELCOME_MESSAGE);
        if (Files.exists(Paths.get(Constants.FILE_NAME))) {
            System.out.println("Wczytuję dane z pliku " + Constants.FILE_NAME);
            readFromFile(new File(Constants.FILE_NAME));
        }
        System.out.println();
        while (!isTheEnd) {
            currentMenu.display();
            System.out.print(Constants.CHOICE_MESSAGE);
            int choice = scanner.nextInt() - 1;
            scanner.nextLine();
            System.out.println();
            currentMenu.getItem(choice).doAction();
        }
    }

    private void createMenus() {
        mainMenu = new Menu();
        manageMenu = new Menu();
        listMenu = new Menu();
        filterMenu = new Menu();
        projectsMenu = new Menu();
        vatsMenu = new Menu();

        mainMenu.addItem(new MenuItem.MenuItemBuilder("Zarządzanie pracownikami")
                .addSubMenu(manageMenu).addAction((o) -> currentMenu = manageMenu).build());
        mainMenu.addItem(new MenuItem.MenuItemBuilder("Lista pracowników")
                .addSubMenu(listMenu).addAction((o) -> currentMenu = listMenu).build());
        mainMenu.addItem(new MenuItem.MenuItemBuilder("Projekty").addSubMenu(projectsMenu)
                .addAction((o) -> currentMenu = projectsMenu).build());
        mainMenu.addItem(new MenuItem.MenuItemBuilder("Faktury").addSubMenu(vatsMenu)
                .addAction((o) -> currentMenu = vatsMenu).build());
        mainMenu.addItem(new MenuItem.MenuItemBuilder("Zakończ program")
                .addAction(this::closeApplication).build());


        manageMenu.addItem(new MenuItem.MenuItemBuilder("Zatrudnij")
                .addAction(this::hireNewEmployee).build());
        manageMenu.addItem(new MenuItem.MenuItemBuilder("Zwolnij")
                .addAction(this::fireEmployee).build());
        manageMenu.addItem(new MenuItem.MenuItemBuilder("Dodaj notatkę")
                .addAction(this::addNoteToEmployee).build());
        manageMenu.addItem(new MenuItem.MenuItemBuilder("Zmień pensję")
                .addAction(this::changeEmployeeSalary).build());
        manageMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction((o) -> currentMenu = mainMenu).build());

        listMenu.addItem(new MenuItem.MenuItemBuilder("Kompletna")
                .addAction((o) -> listEmployees(business.getEmployees())).build());
        listMenu.addItem(new MenuItem.MenuItemBuilder("Filtruj").addSubMenu(filterMenu)
                .addAction((o) -> currentMenu = filterMenu).build());
        listMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction((o) -> currentMenu = mainMenu).build());

        filterMenu.addItem(new MenuItem.MenuItemBuilder("Zawód")
                .addAction((o) -> filterEmployeesBy(FilterType.PROFESSION)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Pensja")
                .addAction((o) -> filterEmployeesBy(FilterType.SALARY)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Doświadczenie")
                .addAction((o) -> filterEmployeesBy(FilterType.EXPERIENCE)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Umiejętności programistów")
                .addAction((o) -> filterEmployeesBy(FilterType.SKILLS)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction((o) -> currentMenu = listMenu).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Menu główne")
                .addAction((o) -> currentMenu = mainMenu).build());

        projectsMenu.addItem(new MenuItem.MenuItemBuilder("Nowy")
                .addAction(this::addNewProject).build());
        projectsMenu.addItem(new MenuItem.MenuItemBuilder("Lista")
                .addAction(this::listAllProjects).build());
        projectsMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction((o) -> currentMenu = mainMenu).build());

        vatsMenu.addItem(new MenuItem.MenuItemBuilder("Wystaw")
                .addAction(this::addNewVat).build());
        vatsMenu.addItem(new MenuItem.MenuItemBuilder("Lista")
                .addAction(this::listAllVats).build());
        vatsMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction((o) -> currentMenu = mainMenu).build());
    }

    private void showEmployeesListMenu(List<Employee> employeeList) {
        Menu listMenu = new Menu();
        Employee employee;
        for (int i = 0; i < employeeList.size(); i++) {
            employee = employeeList.get(i);
            listMenu.addItem(new MenuItem.MenuItemBuilder(employee).build());
        }
        listMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz").build());
        listMenu.display();
    }

    private Employee chooseEmployeeFromListMenu(List<Employee> employeeList) {
        if (employeeList.size() > 0) {
            showEmployeesListMenu(employeeList);
            System.out.print(Constants.CHOICE_MESSAGE);
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            if (employeeList.size() >= choice)
                return employeeList.get(--choice);
            else
                return null;
        } else return null;
    }

    private void listAllVats(Object object) {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void addNewVat(Object object) {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void listAllProjects(Object object) {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void addNewProject(Object object) {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void filterEmployeesBy(FilterType type) {
        Predicate<Employee> accept = employee -> false;
        List<Employee> filteredList = business.getEmployees();
        switch (type) {
            case EXPERIENCE:
                IntRange intRange = new IntRange();
                intRange.chooseRange(scanner);
                accept = employee -> employee.getExperienceInYears() >= intRange.getFrom()
                        && employee.getExperienceInYears() <= intRange.getTo();
                break;
            case SALARY:
                DoubleRange doubleRange = new DoubleRange();
                doubleRange.chooseRange(scanner);
                accept = employee -> employee.getSalary() >= doubleRange.getFrom()
                        && employee.getSalary() <= doubleRange.getTo();
                break;
            case SKILLS:
                filteredList = filteredList.stream()
                        .filter(employee -> employee instanceof Developer)
                        .collect(Collectors.toList());
                int skill = chooseSkill();
                switch (skill) {
                    case 1:
                        accept = employee -> ((Developer) employee).getSkills()
                                .keySet().contains(DeveloperSkill.JAVA);
                        break;
                    case 2:
                        accept = employee -> ((Developer) employee).getSkills()
                                .keySet().contains(DeveloperSkill.PYTHON);
                        break;
                    case 3:
                        accept = employee -> ((Developer) employee).getSkills()
                                .keySet().contains(DeveloperSkill.SQL);
                        break;
                    case 4:
                        accept = employee -> ((Developer) employee).getSkills()
                                .keySet().contains(DeveloperSkill.JAVA_SCRIPT);
                        break;
                    case 5:
                        accept = employee -> ((Developer) employee).getSkills()
                                .keySet().contains(DeveloperSkill.MARIA_DB);
                        break;
                    case 6:
                        accept = employee -> ((Developer) employee).getSkills()
                                .keySet().contains(DeveloperSkill.RUBY);
                        break;
                    case 7:
                        accept = employee -> ((Developer) employee).getSkills()
                                .keySet().contains(DeveloperSkill.C);
                        break;
                }
                break;
            case PROFESSION:
                int profession = chooseProfession();
                switch (profession) {
                    case 1:
                        accept = employee -> employee.getProfession() == Profession.ANALYST;
                        break;
                    case 2:
                        accept = employee -> employee.getProfession() == Profession.SOFTWARE_ARCHITECT;
                        break;
                    case 3:
                        accept = employee -> employee.getProfession() == Profession.MANAGER;
                        break;
                    case 4:
                        accept = employee -> employee.getProfession() == Profession.ACCOUNTANT;
                        break;
                    case 5:
                        accept = employee -> employee.getProfession() == Profession.DEVELOPER;
                        break;
                }
                break;
        }

        filteredList = filteredList.stream().filter(accept)
                .collect(Collectors.toList());
        listEmployees(filteredList);
    }


    private void listEmployees(List<Employee> employees) {
        if (employees.size() > 0) {
            Employee employee = chooseEmployeeFromListMenu(employees);
            if (employee != null)
                System.out.println(employee.fullInfo());
        } else
            System.out.println("Żaden pracownik nie spełnia zadanych kryteriów!");
        showContinueMessage();
    }

    private void changeEmployeeSalary(Object object) {
        Employee employee = chooseEmployeeFromListMenu(business.getEmployees());
        if (employee != null) {
            System.out.println("Nowa pensja: ");
            employee.changeSalary(scanner.nextDouble());
            scanner.nextLine();
        }
        showContinueMessage();
    }

    private void addNoteToEmployee(Object object) {
        Employee employee = chooseEmployeeFromListMenu(business.getEmployees());
        if (employee != null) {
            System.out.print("Notatka: ");
            employee.addNote(scanner.nextLine());
        }
        showContinueMessage();
    }

    private void fireEmployee(Object object) {
        Employee employee = chooseEmployeeFromListMenu(business.getEmployees());
        if (employee != null) {
            business.fireEmployee(employee);
        }
        showContinueMessage();
    }

    private int chooseSkill() {
        for (int i = 0; i < DeveloperSkill.values().length; i++)
            System.out.printf("%d. %s%n", i + 1, DeveloperSkill.values()[i]);
        System.out.print(Constants.CHOICE_MESSAGE + ": ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private int chooseProfession() {
        for (int i = 0; i < Profession.values().length; i++)
            System.out.printf("%d. %s%n", i + 1, Profession.values()[i]);
        System.out.println("6. Wstecz");
        System.out.print(Constants.CHOICE_MESSAGE + ": ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private void hireNewEmployee(Object object) {
        int choice = chooseProfession();
        Employee employee;
        switch (choice) {
            case 5:
                employee = new Developer();
                break;
            default:
                employee = new Employee(Profession.values()[--choice]);
        }
        employee.readFromConsole(scanner);
        business.hireEmployee(employee);
        showContinueMessage();
    }

    private void showContinueMessage() {
        System.out.println(Constants.CONTINUE_MESSAGE);
        scanner.nextLine();
    }

    private void closeApplication(Object object) {
        System.out.print(Constants.EXIT_CONFIRMATION + " (t|n): ");
        char choice = scanner.nextLine().charAt(0);
        if (Character.toLowerCase(choice) == 't') {
            writeToFile(new File(Constants.FILE_NAME));
            scanner.close();
            isTheEnd = true;
        }
    }

    private void writeToFile(File file) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(business);
        } catch (IOException e) {
            System.out.println("Błąd wejścia/wyjścia!");
        }
    }

    private void readFromFile(File file) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            business = (Business) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można odnaleźć pliku " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Błąd wejścia/wyjścia!");
        } catch (ClassNotFoundException e) {
            System.out.println("Plik w nieznanym formacie!");
        }
    }
}
