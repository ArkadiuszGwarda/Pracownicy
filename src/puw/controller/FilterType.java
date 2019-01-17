package puw.controller;

public enum FilterType {
    PROFESSION("Zawód"),
    SALARY("Pensja"),
    EXPERIENCE("Doświadczenie"),
    SKILLS("Technologie");

    private String type;

    FilterType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type;
    }
}
