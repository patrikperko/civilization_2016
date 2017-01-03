package model;

import javafx.scene.image.Image;

class Coliseum extends Landmark {

    public Coliseum(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().increaseHappiness(50);
    }


    @Override
    public String toString() {
        return "Coliseum " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/coliseum_icon.PNG");
    }
}
