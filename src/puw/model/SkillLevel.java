package puw.model;

public enum SkillLevel {
    VERYLOW("  bardzo niski"),
    LOW("  niski"),
    MEDIUM("  średnio-zaawansowany"),
    HIGH("  wysoki"),
    EXPERT("  ekspercki")
    ;
    private String skillLevel;
    SkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }
    public String getSkillLevel() {
        return skillLevel;
    }
    @Override
    public String toString() {
        return skillLevel;
    }
}
