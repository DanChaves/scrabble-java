package com.danc.scrabble;

public class TestTileBag {
    public static void main(String[] args) {
        TileBag bag = new TileBag();

        System.out.println("Starting bag size: " + bag.size());

        for (int i = 0; i < 7; i++) {
            Tile t = bag.draw();
            System.out.println("Drew: " + t.getLetter() + '(' + t.getValue() + ")");
        }

        System.out.println("Ending bag size: " + bag.size());
    }
}
