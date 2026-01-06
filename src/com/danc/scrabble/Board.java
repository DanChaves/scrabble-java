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


}
