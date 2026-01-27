package com.danc.scrabble;

public class Board {

    private static final int SIZE = 15; //Capitalized because it's a constant, also static and final
    private final Tile[][] grid;

    public Board() {
        grid = new Tile[SIZE][SIZE];
    }

    //Used to check if numbers are in possible range of rows and cols
    private boolean inBounds(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    // Used to check if a square is empty/null
    private boolean isEmpty(int row, int col) {
        if (!inBounds(row, col)) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        return grid[row][col] == null;

    }

    public void placeTile(int row, int col, Tile tile) {
        if (!inBounds(row, col)) {
            throw new IllegalArgumentException("Position out of bounds");
        }
        if (grid[row][col] != null) {
            throw new IllegalArgumentException("Square already occupied");
        }
        grid[row][col] = tile;
    }

    // Print the board in ASCII
    public void print() {
        // Column headers
        System.out.print("  ");
        for (int c = 0; c < SIZE; c++) {
            System.out.print((char) ('A' + c) + " ");
        }
        System.out.println();

        //board itself
        for (int r = 0; r < SIZE; r++) {
            System.out.printf("%2d", r + 1);
            for (int c = 0; c < SIZE; c++) {
                if (grid[r][c] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(grid[r][c].getLetter() + " ");
                }
            }
            System.out.println();
        }
    }

    // updated via placeWord
    public void placeWord(Position start, Direction dir, String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be empty");
        }

        word = word.toUpperCase();

        int r = start.getRow();
        int c = start.getCol();

        for (int i = 0; i < word.length(); i++) {
            if (!inBounds(r, c)) {
                throw new IllegalArgumentException("Word goes out of bounds");

            }

            Tile existing = grid[r][c];
            char placing = word.charAt(i);

            if (existing != null && existing.getLetter() != placing) {
                throw new IllegalArgumentException(
                        "Conflict at " + Position.toCoord(r, c) + ": board has '" + existing.getLetter() + "', tried '" + placing + "'."
                );
            }
            if (dir == Direction.HORIZONTAL) c++;
            else r++;
        }

        // Second pass: actually place tiles:
        r = start.getRow();
        c = start.getCol();

        for (int i = 0; i < word.length(); i++) {
            if (grid[r][c] == null) {
            char ch = word.charAt(i);
            grid[r][c] = new Tile(ch, TileValues.valueOf(ch));
        }

        if (dir == Direction.HORIZONTAL) c++;
        else r++;

        }

    }
}
