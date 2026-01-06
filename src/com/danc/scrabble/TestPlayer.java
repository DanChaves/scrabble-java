package com.danc.scrabble;

public class TestPlayer {
    public static void main(String[] args) {
        TileBag bag = new TileBag(); //initialize our objects
        Player p = new Player("Alice");

        p.drawToFullRack(bag);

        System.out.println(p.getName() + "rack: " + p.rackString());
        System.out.println("Bag size after draw: " + bag.size());

    }
}
