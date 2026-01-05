package com.danc.scrabble;

    // public -> anybody can use it
    // final -> can't be subclassed: cant be extended via extends
public final class TileValues {

    // Private constructor prevents creating instances... what does this mean?
        // we tell java no one is allowed to create an instance of this class.
    private TileValues() {}

    // static -> belongs to the class, not the object. What's the significance of this?
    public static int valueOf(char letter) {
        letter = Character.toUpperCase(letter); // converts lowercase to upper case
        return switch (letter) {
            case 'D', 'G' -> 2; // does -> assign value? what does it mean in java? is -> unique to switch statements?
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W','Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 1; // A E I O U N R T L S U
            };
        }
}
// meant to be used by calling int v = TileValues.valueOf('Q'); which should be 10.