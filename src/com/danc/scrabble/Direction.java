package com.danc.scrabble;

public enum Direction { //Whats an enum??
    HORIZONTAL,
    VERTICAL;

    public static Direction parse(String s) {//What is parse in this context
        if (s == null) throw new IllegalArgumentException("Direction required (H or V)");
        s = s.trim().toUpperCase();

        return switch (s) {
            case "H" -> HORIZONTAL;
            case "V" -> VERTICAL;
            default -> throw new IllegalArgumentException("Direction must be H or V");
        };
    }
}
