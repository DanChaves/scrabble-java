package com.danc.scrabble;

public class TestBoard {

    public static void main(String[] args) {
        Board board = new Board();

        board.placeTile(7, 7, new Tile('S', 1));
        board.placeTile(7, 8, new Tile('C', 3));
        board.placeTile(7, 9, new Tile('R', 1));
        board.placeTile(7, 10, new Tile('A', 1));
        board.placeTile(7, 11, new Tile('B', 3));
        board.placeTile(7, 12, new Tile('B', 3));
        board.placeTile(7, 13, new Tile('L', 1));
        board.placeTile(7, 14, new Tile('E', 1));

        board.print();
    }
}
