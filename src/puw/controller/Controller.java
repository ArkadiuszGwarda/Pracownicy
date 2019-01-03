package puw.controller;

import puw.view.Menu;
import puw.view.MenuItem;

import java.util.Scanner;

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

    private static final String CHOICE_MESSAGE = "Wybierz opcję: ";
    private static final String CONTINUE_MESSAGE = "Aby kontynuować wciśnij enter...";
    private static final String WELCOME_MESSAGE = "Aplikacja do zarządzania firmą IT";

    public Controller() {
        isTheEnd = false;
        scanner = new Scanner(System.in);
        createMenus();
        currentMenu = mainMenu;
    }

    public void start() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println();
        while (!isTheEnd) {
            currentMenu.display();
            System.out.print(CHOICE_MESSAGE);
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            currentMenu.getItem(--choice).doAction();

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
                .addSubMenu(manageMenu).addAction(() -> currentMenu = manageMenu).build());
        mainMenu.addItem(new MenuItem.MenuItemBuilder("Lista pracowników")
                .addSubMenu(listMenu).addAction(() -> currentMenu = listMenu).build());
        mainMenu.addItem(new MenuItem.MenuItemBuilder("Projekty").addSubMenu(projectsMenu)
                .addAction(() -> currentMenu = projectsMenu).build());
        mainMenu.addItem(new MenuItem.MenuItemBuilder("Faktury").addSubMenu(vatsMenu)
                .addAction(() -> currentMenu = vatsMenu).build());
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
                .addAction(() -> currentMenu = mainMenu).build());

        listMenu.addItem(new MenuItem.MenuItemBuilder("Kompletna")
                .addAction(this::listEmployees).build());
        listMenu.addItem(new MenuItem.MenuItemBuilder("Filtruj").addSubMenu(filterMenu)
                .addAction(() -> currentMenu = filterMenu).build());
        listMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction(() -> currentMenu = mainMenu).build());

        filterMenu.addItem(new MenuItem.MenuItemBuilder("Zawód")
                .addAction(() -> filterEmployeesBy(0)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Pensja")
                .addAction(() -> filterEmployeesBy(1)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Doświadczenie")
                .addAction(() -> filterEmployeesBy(2)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Umiejętności programistów")
                .addAction(() -> filterEmployeesBy(3)).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction(() -> currentMenu = listMenu).build());
        filterMenu.addItem(new MenuItem.MenuItemBuilder("Menu główne")
                .addAction(() -> currentMenu = mainMenu).build());

        projectsMenu.addItem(new MenuItem.MenuItemBuilder("Nowy")
                .addAction(this::addNewProject).build());
        projectsMenu.addItem(new MenuItem.MenuItemBuilder("Lista")
                .addAction(this::listAllProjects).build());
        projectsMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction(() -> currentMenu = mainMenu).build());

        vatsMenu.addItem(new MenuItem.MenuItemBuilder("Wystaw")
                .addAction(this::addNewVat).build());
        vatsMenu.addItem(new MenuItem.MenuItemBuilder("Lista")
                .addAction(this::listAllVats).build());
        vatsMenu.addItem(new MenuItem.MenuItemBuilder("Wstecz")
                .addAction(() -> currentMenu = mainMenu).build());
    }

    private void listAllVats() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void addNewVat() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void listAllProjects() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void addNewProject() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void filterEmployeesBy(int by) {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void listEmployees() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void changeEmployeeSalary() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void addNoteToEmployee() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void fireEmployee() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void hireNewEmployee() {
        System.out.println("Do zaimplementowania");
        showContinueMessage();
    }

    private void showContinueMessage() {
        System.out.println(CONTINUE_MESSAGE);
        scanner.nextLine();
    }

    private void closeApplication() {
        System.out.println("Do zaimplementowania");
        isTheEnd = true;
    }
}
