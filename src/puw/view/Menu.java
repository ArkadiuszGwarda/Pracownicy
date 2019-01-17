package puw.view;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Menu parentMenu;
    private List<MenuItem> items;

    public Menu() {
        this.parentMenu = null;
        items = new ArrayList<>();
    }
    public Menu(Menu parentMenu) {
        this();
        this.parentMenu = parentMenu;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public MenuItem getItem(int index) {
        return items.get(index);
    }

    public void display() {
        for(int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + ". " + items.get(i).getName());
        }
    }
}
