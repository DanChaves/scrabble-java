package com.danc.scrabble;

public class TestTile {
    public static void main(String[] args) {
        Tile t = new Tile('K',5);
        System.out.println(t);
        System.out.println("letter: " + t.getLetter());
        System.out.println("Value: " + t.getValue());
    }
}
