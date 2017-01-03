package model;

import controller.TileType;
import javafx.scene.image.Image;

public class AnglerUnit extends Unit implements Convertable {

    AnglerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getFishingShack();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.WATER;
    }

    @Override
    public char symbol() {
        return 'a';
    }

    @Override
    public String toString() {
        return "Anglers. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/angler_unit_icon.PNG");
    }
}
