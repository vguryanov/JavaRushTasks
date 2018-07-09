package com.javarush.task.task35.task3513;

import java.util.ArrayList;

/**
 * Created by User2 on 15.06.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score;
    int maxTile;

    public Model() {
        resetGameTiles();
    }

    public ArrayList<Tile> getEmptyTiles() {
        ArrayList<Tile> result = new ArrayList<>();

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) result.add(gameTiles[i][j]);
            }
        }

        return result;
    }

    void left() {
        boolean fieldChanged = false;

        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i])) fieldChanged = true;
            if (mergeTiles(gameTiles[i])) fieldChanged = true;
        }

        if (fieldChanged) addTile();
    }

    public void addTile() {
        ArrayList<Tile> list = getEmptyTiles();
        list.get((int) (Math.random() * list.size())).value = (Math.random() < 0.9 ? 2 : 4);
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean result = false;

        for (int i = 1; i < tiles.length; i++) {
            if (!tiles[i].isEmpty()) {
                for (int j = i; j > 0; j--) {
                    if (tiles[j - 1].isEmpty()) {
                        tiles[j - 1].value = tiles[j].value;
                        tiles[j].value = 0;
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;

        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty() && !tiles[i + 1].isEmpty()) {
                change = true;
                tiles[i].value *= 2;
                tiles[i + 1] = new Tile();
                maxTile = maxTile > tiles[i].value ? maxTile : tiles[i].value;
                score += tiles[i].value;
                compressTiles(tiles);
            }
        }

        return change;
    }

    void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        score = 0;
        maxTile = 2;

        addTile();
        addTile();
    }
}
