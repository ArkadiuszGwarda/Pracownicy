package puw.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Developer extends Employee {
    private Map<DeveloperSkill, SkillLevel> skills;

    public Developer(String name, String surname, String pesel, Address address, double salary, int experienceInYears, Proffession proffession) {
        super(name, surname, pesel, address, salary, experienceInYears, proffession);
        skills = new HashMap<>();
    }

    public Developer() {
        super(Proffession.DEVELOPER);
        skills = new HashMap<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString()).append('\n')
                .append("Znajomość technologii: ").append(skills.size());
        if (skills.size() > 0) {
            builder.append("\nTechnologia Poziom")
                    .append("\n------------------");
            for (DeveloperSkill skill : skills.keySet()) {
                builder.append("\n")
                        .append(String.format("%-12s", skill))
                        .append(String.format("%6s", skills.get(skill)));
            }
        }
        return builder.toString();
    }

    public void addSkills(DeveloperSkill developerSkill, SkillLevel skillLevel) {
        skills.put(developerSkill, skillLevel);
    }

    public Map<DeveloperSkill, SkillLevel> getSkills() {
        return skills;
    }

    @Override
    public void readFromConsole(Scanner scanner) {
        super.readFromConsole(scanner);
        System.out.println("Poziom znajomości technologii (0 - brak, 1 - niski, 2 - średni, 3 - wysoki) :");
        for (DeveloperSkill skill : DeveloperSkill.values()) {
            System.out.print(skill + ": ");
            int level = scanner.nextInt();
            scanner.nextLine();
            if (level > 0 && level < 4)
                addSkills(skill, SkillLevel.values()[level - 1]);
        }
    }
}

