package model;

import javafx.scene.image.Image;

class BlackPowderUnit extends SiegeUnit {

    BlackPowderUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public void battle(MapObject o) {
        o.damage(this.getDamage());
    }

    @Override
    public char symbol() {
        return 'B';
    }

    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/"
                + "black_powder_unit_icon.PNG");
    }
}
