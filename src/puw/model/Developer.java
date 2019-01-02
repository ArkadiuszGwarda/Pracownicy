package puw.model;
import java.util.HashMap;
import java.util.Map;

public class Developer extends Employee {
    private Map<DeveloperSkill, SkillLevel> skills;

    public Developer(String name, String surname, String pesel, Address address, double salary, int experienceInYears, Proffession proffession) {
        super(name, surname, pesel, address, salary, experienceInYears, proffession);
        skills = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Deweloper: " + getName() + " " + getSurname() + ", Pesel: " + getPesel() + getAddress() + " ,pensja: " + getSalary() + " ,doświadczenie (w latach): " + getExperienceInYears() + " ,specjalizacja: " + getProffession()+", język i poziom zaawansowania: "+ getSkills();
    }

    public enum DeveloperSkill {Java, NetTechnologies, Php, Python,  Sql, JavaScript, Mariadb, Ruby, C}

    public enum SkillLevel {VeryLow, Low, Medium, High, VeryHigh, Expert}

    public void addSkills(DeveloperSkill developerSkill, SkillLevel skillLevel)
    {
        skills.put(developerSkill, skillLevel);
    }

    public Map<DeveloperSkill, SkillLevel> getSkills() {
        return skills;
    }
}

