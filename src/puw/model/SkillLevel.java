package puw.model;

public enum SkillLevel {
    LOW("niski"),
    MEDIUM("średni"),
    HIGH("wysoki");

    private String skillLevel;
    SkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return skillLevel;
    }
}
