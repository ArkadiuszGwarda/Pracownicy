package puw.controller;

public class MenuItem {
    private Action action;
    private MenuItem subMenu;
    private String name;

    public MenuItem(Action action, MenuItem subMenu, String name) {
        this.action = action;
        this.subMenu = subMenu;
        this.name = name;
    }

    public boolean hasSubMenu() {
        if (subMenu != null)
            return true;
        else
            return false;
    }

    public String getName() {
        return name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
