package puw.model;

public enum DeveloperSkill {
    JAVA("Java"),
    PYTHON("Python"),
    SQL("Sql"),
    JavaScript("JavaScript"),
    Mariadb("Mariadb"),
    Ruby("Ruby on rails"),
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
