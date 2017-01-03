package model;

import controller.TileType;
import javafx.scene.image.Image;

public class FarmerUnit extends Unit implements Convertable {

    public FarmerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getFarm();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }

    @Override
    public char symbol() {
        return 'f';
    }

    @Override
    public String toString() {
        return "Farmers. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image(
            "File:./src/main/java/view/Civ_Icon/farmer_unit_icon.PNG");
    }
}
