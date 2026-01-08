package com.danc.scrabble;

public class Position {
    private final int row; //0 based
    private final int col;

    public Position(int row,int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    //Example: "H8" -> col = 7, row = 7
    public static Position parse(String coord) { //what is parse in this function?
        if (coord == null || coord.length() < 2) {
            throw new IllegalArgumentException("Bad coordinate. Example: H8");
        }

        coord = coord.trim().toUpperCase(); //converts input to uppercase, what's trim()?

        char colChar = coord.charAt(0);
        if (colChar < 'A' || colChar > 'O') {
            throw new IllegalArgumentException("Column must be A-O for 15x15 board");
        }
        int col = colChar - 'A';

        String rowPart = coord.substring(1); // What is substring?
        int rowNum;
        try {// What does try & catch mean again in java?
            rowNum = Integer.parseInt(rowPart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Row must be a number. Example: H8");
        }

        if (rowNum < 1 || rowNum > 15) {
            throw new IllegalArgumentException("Row must be 1-15");
        }
        int row = rowNum - 1;

        return new Position(row, col);
    }

    public static String toCoord(int row, int col) {
        return "" + (char)('A' + col) + (row + 1);
    }
}
