package puw.view;

import puw.controller.Action;

public class MenuItem {
    private Action action;
    private Menu subMenu;
    private Object name;


    private MenuItem(MenuItemBuilder builder) {
        this.action = builder.action;
        this.subMenu = builder.subMenu;
        this.name = builder.name;
    }

    public boolean hasSubMenu() {
        return subMenu != null;
    }

    public Object getName() {
        return name;
    }

    public void doAction() {
        action.doAction(this);
    }


    public static class MenuItemBuilder {
        private Action action;
        private Menu subMenu;
        private Object name;

        public MenuItemBuilder(Object name) {
            this.name = name;
            this.action = null;
            this.subMenu = null;
        }

        public MenuItemBuilder addAction(Action action) {
            this.action = action;
            return this;
        }

        public MenuItemBuilder addSubMenu(Menu subMenu) {
            this.subMenu = subMenu;
            return this;
        }

        public MenuItem build() {
            return new MenuItem(this);
        }
    }
}
