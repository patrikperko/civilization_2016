package model;

public class QinDynasty extends Civilization {
    private Hills hills = new Hills();

    public QinDynasty() {
        super("Qin Dynasty");
    }

    @Override
    public String explore() {
        int food = hills.hunt().getHealth();
        hills.replenishGame();
        makeFood(food);
        return "You go hunting and get " + food + " food!";
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }

    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }
}
