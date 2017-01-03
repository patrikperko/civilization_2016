package model;

import javafx.scene.image.Image;

class GreatWall extends Landmark {

    public GreatWall(Civilization owner) {
        super(owner);
    }

    @Override
    public void invest() {
        super.invest();
        getOwner().getStrategy().battle();
    }

    @Override
    public String toString() {
        return "Great Wall " + super.toString();
    }

    @Override
    public Image getImage() {
        return new Image("File:./src/main/java/view/Civ_Icon/"
                + "great_wall_icon.PNG");
    }
}
