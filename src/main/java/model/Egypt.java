package model;

public class Egypt extends Civilization {
    private Desert desert = new Desert();

    public Egypt() {
        super("Egypt");
    }

    @Override
    public String explore() {
        int gold = desert.findTreasure();
        getTreasury().earn(gold);
        return "You explore the desert and find " + gold + " gold!";
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariotUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }
}
