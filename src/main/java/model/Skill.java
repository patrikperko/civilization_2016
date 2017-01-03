package model;

import java.util.Random;

enum Skill {
    POTTERY("Pottery"),
    ARGRICULTURE("Agriculture"),
    COMPUTING("Computing"),
    RADIO("Radio"),
    ARCHERY("Archery"),
    PAINTING("Painting"),
    SAILING("Sailing"),
    MINING("Mining"),
    MATHEMATICS("Mathematics"),
    ENGINEERING("Engineering"),
    ASTRONOMY("Astronomy"),
    STEEL("Steel"),
    BANKING("Banking"),
    GUNPOWDER("Gunpowder"),
    CHEMISTRY("Chemistry"),
    ECONOMICS("Economics"),
    DYNAMITE("Dynamite"),
    ELECTRICITY("Electricity"),
    NUCLEAR_FISSION("Nuclear Fission"),
    LASERS("Lasers");

    private String value;

    Skill(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    private static Random rand = new Random();

    //get random Skill enum
    public static Skill getRandomSkill() {
        return Skill.values()[rand.nextInt(20)];
    }
}
