package puw.model;

public enum Proffession {
    ANALYST("Analityk"),
    SOFTWARE_ARCHITECT("Inżynier Oprogramowania"),
    MANAGER("Kierownik projektu"),
    ACCONTANT("Księgowa"),
    SENIOR_DEVELOPER("Programista");

    private String proffession;

    Proffession(String proffession) {
        this.proffession = proffession;
    }

    @Override
    public String toString() {
        return proffession;
    }
}
