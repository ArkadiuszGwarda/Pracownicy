package puw.model;

public enum DeveloperSkill {
    JAVA("Java SE, Java EE, Spring "),
    PYTHON("Python "),
    SQL("Sql i aplikacje baz danych "),
    JavaScript("JavaScript, front-end "),
    Mariadb("Mariadb "),
    Ruby("Ruby on rails "),
    C("C i C++ ");

    private String developerSkill;

    public String getDeveloperSkill() {
        return developerSkill;
    }

    DeveloperSkill(String developerSkill) {
        this.developerSkill = developerSkill;
    }

    @Override
    public String toString() {
        return developerSkill;
    }

}
