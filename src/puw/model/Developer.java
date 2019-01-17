package puw.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Developer extends Employee {
    private static final long serialVersionUID = 7712559785710012176L;
    private Map<DeveloperSkill, SkillLevel> skills;

    public Developer(String name, String surname, String pesel, Address address, double salary, int experienceInYears, Profession profession) {
        super(name, surname, pesel, address, salary, experienceInYears, profession);
        skills = new HashMap<>();
    }

    public Developer() {
        super(Profession.DEVELOPER);
        skills = new HashMap<>();
    }

    @Override
    public String fullInfo() {
        StringBuilder builder = new StringBuilder(super.fullInfo()).append('\n')
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

    @Override
    public String toString() {
        return super.toString();
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

