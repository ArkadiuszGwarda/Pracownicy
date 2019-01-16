package puw.model;

public enum Profession {
    ANALYST("Analityk"),
    SOFTWARE_ARCHITECT("Inżynier Oprogramowania"),
    MANAGER("Kierownik projektu"),
    ACCOUNTANT("Księgowa"),
    DEVELOPER("Programista");

    private String profession;

    Profession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return profession;
    }
}
