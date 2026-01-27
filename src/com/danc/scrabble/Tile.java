package com.danc.scrabble;

public class Tile {
    private final char letter; //Only the tile class can touch these variables (private)
    private final int value; // & once set, they cannot change (final)
    // this is what makes TILE immutable (good OOP)

    // constructor
    // When we create a tile we assign its letter value and numerical value
    // both needed for validating the words played the points gained
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    // sort of remember this concept of getters and setters
    // did it in C++ but is it more intuitive in Java?
    public char getLetter() {
        return letter;
    }

    public int getValue() {
        return value;
    }
}
