package puw.model;

public enum Proffession {
    MANAGER(" Kierownik projektu"),
    JUNIOR_DEVELOPER(" Młodszy Programista"),
    SENIOR_DEVELOPER(" Starszy Programista"),
    ANALYST(" Analityk"),
    SOFTWARE_ARCHITECT(" Inżynier Oprogramowania"),
    ACCONTANT(" Księgowa");

    private String proffession;

    Proffession(String proffession) {
        this.proffession = proffession;
    }
    public String getProffession() {
        return proffession;
    }
    @Override
    public String toString() {
        return proffession;
    }
}
