package model;

import javafx.scene.image.Image;

public abstract class MilitaryUnit extends Unit {

    private int damage;

    public MilitaryUnit(int health, Civilization owner, int baseEndurance,
        int pay, int initialGoldCost, int initialFoodCost,
        int initialResourceCost, int damage) {
        super(health, owner, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        this.damage = damage;
    }

    @Override
    public void tick() {
        super.tick();
        setCanAttack(true);
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void attack(MapObject o) {
        getOwner().getStrategy().battle();
        battle(o);
        setCanAttack(false);
    }

    /**
     * Inflicts damage to another MapObject, and allows that MapObject to
     * execute a counterattack if possible.
     */

    public abstract void battle(MapObject o);


    @Override
    public String toString() {
        return "Military Unit. " + super.toString();
    }

    @Override
    public String getStatusString() {
        return super.getStatusString()
                + ("\nCan" + (getCanAttack() ? "" : "'t") + " attack");
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/military_unit_icon.PNG");
    }
}
