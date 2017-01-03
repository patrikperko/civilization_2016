package model;

import javafx.scene.image.Image;

class Pyramid extends Landmark {

    public Pyramid(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getTechnology().philosophize();
    }

    @Override
    public String toString() {
        return "Pyramid " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/pyramid_icon.PNG");
    }
}
