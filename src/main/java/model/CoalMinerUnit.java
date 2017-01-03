package model;

import controller.TileType;
import javafx.scene.image.Image;

class CoalMinerUnit extends Unit implements Convertable {

    public CoalMinerUnit(Civilization owner) {
        super(owner);
    }

    @Override
    public Building convert() {
        return getOwner().getCoalMine();
    }

    @Override
    public boolean canConvert(TileType type) {
        return type == TileType.MOUNTAIN;
    }

    @Override
    public char symbol() {
        return 'c';
    }

    @Override
    public String toString() {
        return "Coal miners. " + super.toString();
    }
    @Override
    public Image getImage() {
        return new Image(
                "File:./src/main/java/view/Civ_Icon/coal_miner_unit_icon.PNG");
    }
}
