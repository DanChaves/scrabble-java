package com.danc.scrabble;

public class TestPlayerHasLetters {
    public static void main(String[] args) {
        TileBag bag = new TileBag();
        Player p = new Player("Alice");
        p.drawToFullRack(bag);

        System.out.println("Rack: " + p.rackString());

        System.out.println("Has 'A'? " + p.hasLetters("A"));
        System.out.println("Has 'HELLO'? " + p.hasLetters("HELLO"));
        System.out.println("Has 'ZZ'? " + p.hasLetters("ZZ"));
    }
}
