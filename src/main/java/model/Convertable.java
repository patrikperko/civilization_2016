package model;

import controller.TileType;

public interface Convertable {

    Building convert();

    boolean canConvert(TileType type);
}
