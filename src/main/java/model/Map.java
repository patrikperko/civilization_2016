package model;

import controller.TileType;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class Map {

    private static TerrainTile[][] map;

    public Map(int rows, int columns) {
        // TileType[] types = TileType.values();
        map = new TerrainTile[rows][columns];

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                map[r][c] = new TerrainTile(null, r, c);
            }
        }

        //Populate the map with different Terrain types
        populateMap();
    }

    //this will also populate the map hopefully
    private void populateMap() {
        TileType[][] tiles = new TileType[10][10];

        Random rand = new Random();
        for (int r = 0; r < 10; r++) {
            TileType[] row = new TileType[10];
            for (int c = 0; c < 10; c++) {
                int seed = rand.nextInt(2);
                int value = seed + r + c;
                TileType type = TileType.PLAINS;
                if (value < 5) {
                    type = TileType.WATER;
                }
                if (value > 8 && value < 14 && c < 5 && r > 5) {
                    type = TileType.DESERT;
                } else if (value > 10 && value < 16) {
                    type = TileType.FOREST;
                }
                if (value > 14 && value < 18) {
                    type = TileType.MOUNTAIN;
                } else if (value >= 18) {
                    type = TileType.ICE;
                }
                map[r][c].setType(type);
                row[c] = type;
            }
            tiles[r] = row;
        }
    }

    public static void putSettlement(String name, Civilization civ,
                                     int r, int c) {
        map[r][c].setOccupant(civ.getSettlement(name));
        civ.incrementNumSettlements();
    }

    public static void addEnemies(Bandit bandit, int numEnemies) {
        for (int i = 0; i < numEnemies; i++) {
            int r = new Random().nextInt(10);
            int c = new Random().nextInt(10);
            putSettlement("Bandit Hideout", bandit, 9, 0);
            while (!map[r][c].isEmpty()) {
                //try to get new coords
                r = new Random().nextInt(10);
                c = new Random().nextInt(10);
            }
            map[r][c].setOccupant(bandit.getMeleeUnit());
        }
    }

    public TerrainTile getTile(int r, int c) {
        return map[r][c];
    }

    public boolean isEmpty(int r, int c) {
        return map[r][c].getOccupant() == null;
    }

    public int getRows() {
        return map.length;
    }

    /**
     * This will result in a java.lang.ArrayIndexOutOfBoundsException in the
     * event that the Map has no tiles.
     */

    public int getColumns() {
        return map[0].length;
    }

    public TerrainTile getNearestNonBandit(int r, int c) {
        return bfs(r, c);
    }

    private TerrainTile bfs(int r, int c) {
        Queue<TerrainTile> queue = new LinkedList<TerrainTile>();
        Set<TerrainTile> closed = new HashSet<TerrainTile>();
        TerrainTile current;
        queue.add(map[r][c]);
        closed.add(map[r][c]);
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (!current.isEmpty()
                    && (current.getOccupant().isFriendly())) {
                return current;
            } else {
                for (int dr = current.getRow() - 1; dr <= current.getRow() + 1;
                     dr++) {
                    for (int dc = current.getCol() - 1;
                         dc <= current.getCol() + 1; dc++) {
                        if  (dr >= 0 && dr < 10 && dc >= 0 && dc < 10) {
                            if (!closed.contains(map[dr][dc])) {
                                queue.add(map[dr][dc]);
                                closed.add(map[dr][dc]);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static int getDirectedRow(TerrainTile start, TerrainTile end) {
        return normalizeComponent(end.getRow() - start.getRow());
    }

    public static int getDirectedCol(TerrainTile start, TerrainTile end) {
        return normalizeComponent(end.getCol() - start.getCol());
    }

    private static int normalizeComponent(int value) {
        if (value < 0) {
            return -1;
        } else if (value > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
