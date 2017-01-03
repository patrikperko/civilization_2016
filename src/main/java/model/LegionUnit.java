package model;

import javafx.scene.image.Image;

class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization owner) {
        super(owner);
        this.setDamage((int) (this.getDamage() * 1.5));
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
        if (!o.isDestroyed() && o instanceof MeleeUnit) {
            damage(((MilitaryUnit) o).getDamage());
        }
    }

    @Override
    public char symbol() {
        return 'L';
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/legion_icon.PNG");
    }

}
