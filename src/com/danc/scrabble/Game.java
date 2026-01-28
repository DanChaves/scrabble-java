package com.danc.scrabble;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    private final Board board = new Board();
    private final TileBag bag = new TileBag();
    private final Player[] players = { new Player("P1"), new Player("P2")};
    private int currentPlayerIndex = 0;

    private final Scanner scanner = new Scanner(System.in);

    // Ideally up to 4 players
    public Game() {
        // Fill each player's rack to 7 tiles at the start
        for (Player p : players) {
            p.drawToFullRack(bag);
        }
    }

    // intro printed message
    public void run() {
        System.out.println("=== Termnial Scrabble (MVP) ===");
        System.out.println("Commands:");
        System.out.println("    place <coord> <Horizontal | Vertical>    e.g. place H8 H Hello");
        System.out.println("    pass");
        System.out.println("    quit");

        // game loop
        while (true) {
            Player current = players[currentPlayerIndex];

            // print state :
            System.out.println("---------------------------------------------");
            System.out.println("Turn: " + current.getName() +
                    " | Score: " + current.getScore() +
                    " | Bag: " + bag.size());
            board.print();
            System.out.println(current.getName() + " rack: " + current.rackString());
            System.out.print("> ");

            // waits for players input
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase(Locale.ROOT); //??

            switch (cmd) {
                case "quit" -> {
                    System.out.println("Final scores: ");
                    for (Player p : players) {
                        System.out.println("  " + p.getName() + ": " + p.getScore());
                    }
                    return;
                }
                case "pass" -> {
                    System.out.println(current.getName() + " decides to pass");
                    nextPlayer();
                }
                case "place" -> handlePlace(current, parts);
                default -> System.out.println("Unknown command. Try: place, pass, quit");
            }
        }
    }

    private void handlePlace(Player current, String[] parts) {
        if (parts.length < 4) {
            System.out.println("Usage: place <coord> <Horizontal | Vertical> <WORD>");
            return;
        }

        String coordStr = parts[1];
        String dirStr = parts[2];
        String word = parts[3].toUpperCase(Locale.ROOT);

        try {
            Position start = Position.parse(coordStr);
            Direction dir = Direction.parse(dirStr);

            // Checks rack first

            if (!current.hasLetters(word)) {
                System.out.println(" You don't have the tiles to play: " + word);
                return;
            }

            // Try board placement (conflict/bounds handled by exceptions)
            board.placeWord(start, dir, word);

            // remove tiles used and then refill rack
            current.removeLetters(word);
            current.drawToFullRack(bag);

            // Scores later
            System.out.println(current.getName() + " placed: " + word);

            nextPlayer();
        } catch (Exception e) {
            System.out.println("Move failed: " + e.getMessage());
        }
    }

    private void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    public static void main(String[] args) {
        new Game().run();
    }
}
