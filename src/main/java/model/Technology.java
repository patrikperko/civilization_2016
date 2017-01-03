package model;

public class Technology {

    private int techPoints;

    public Technology() {
        techPoints = 0;
    }

    public void gainATech() {
        techPoints++;
    }

    public int getTechPoints() {
        return techPoints;
    }

    public boolean hasTechnologyWin() {
        return techPoints >= 800;
    }

    public int getUnderstanding() {
        return getTechPoints();
    }

    public int getBuildExperience() {
        return getTechPoints();
    }

    public void increaseBuildExperience() {
        for (int i = 0; i < 25; i++) {
            gainATech();
        }
    }

    public void increaseBuildExperience(int i) {
        for (int j = 0; j < i; j++) {
            gainATech();
        }
    }

    public boolean builtWonderOfTheWorld() {
        return techPoints >= 800;
    }

    public void increaseUnderstanding(int i) {
        for (int j = 0; j < i; j++) {
            gainATech();
        }
    }

    public void philosophize() {
        for (int i = 0; i < 25; i++) {
            gainATech();
        }
    }

    public void improveWriting() {
        for (int i = 0; i < 10; i++) {
            gainATech();
        }
    }
}
