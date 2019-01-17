package puw.model;

public enum DeveloperSkill {
    JAVA("Java"),
    PYTHON("Python"),
    SQL("Sql"),
    JAVA_SCRIPT("JavaScript"),
    MARIA_DB("Mariadb"),
    RUBY("Ruby on rails"),
    C("C/C++");

    private String developerSkill;

    DeveloperSkill(String developerSkill) {
        this.developerSkill = developerSkill;
    }

    @Override
    public String toString() {
        return developerSkill;
    }
}
