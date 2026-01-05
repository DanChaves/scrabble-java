package com.danc.scrabble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class TileBag {
    // initialize our variables privately, they are only used by this class
    private final List<Tile> tiles;
    private final Random rng;

    // public functions can be used outside class...
    public TileBag() {
        this.tiles = new ArrayList<>();
        this.rng = new Random();

        // TODO: add ALL tiles to the bag
        // small set just to test drawing
        addTiles('E', 12);

        addTiles('A', 9);
        addTiles('I', 9);

        addTiles('O', 8);

        addTiles('N', 6);
        addTiles('R', 6);
        addTiles('T', 6);

        addTiles('D', 4);

        addTiles('L', 4);
        addTiles('S', 4);
        addTiles('U', 4);

        addTiles('G', 3);

        addTiles('B', 2);
        addTiles('C', 2);
        addTiles('M', 2);
        addTiles('P', 2);

        addTiles('F', 2);
        addTiles('H', 2);
        addTiles('V', 2);
        addTiles('W', 2);
        addTiles('Y', 2);

        addTiles('K',1);

        addTiles('J', 1);
        addTiles('X', 1);


        addTiles('Z', 1); //oops
        addTiles('Q', 1);

        shuffle();

    }

    //adds 'count' copies of a tile with the given letter and value
    private void addTiles(char letter, int count) {
        int value = TileValues.valueOf(letter);

        for (int i = 0; i < count; i++) {
            tiles.add(new Tile(letter, value));
        }
    }
    // Collections.shuffle takes in a list and then uses our random number generator.
    // In C I remember randomizing values was a longer process than this,
    // I'm not entirely sure how it works in java. What data type does Random() create?
    public void shuffle() {
        Collections.shuffle(tiles, rng);
    }

    public int size() {
        return tiles.size();
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }

    public Tile draw() {
        if (tiles.isEmpty()) {
            throw new IllegalStateException("Tile Bag is empty");
        }
        // remove from the end (fast for arraylist)
        return tiles.remove(tiles.size() - 1);//Why do we remove from the end?

    }

}
