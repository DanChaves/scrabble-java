package com.danc.scrabble;

public class TestPlaceWord {
    public static void main(String[] args) {
        Board board = new Board();

        board.placeWord(Position.parse("H8"), Direction.parse("H"), "SCRABBLE");
        board.print();

        // Overlap test (valid if letters match)
        board.placeWord(Position.parse("L8"), Direction.parse("V"), "BELL");
        board.print();
    }
}
