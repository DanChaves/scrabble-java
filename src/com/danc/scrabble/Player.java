package com.danc.scrabble;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private final String name; // What does immutable mean again? -> once set, value cannot be changed
    private int score;
    private final List<Tile> rack; //A list comprised of our Tile objects?

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.rack = new ArrayList<>();
    }

    // draw 7 tiles until rack has 7 tile / objects in length
    public void drawToFullRack(TileBag bag) {
        while (rack.size() < 7 && !bag.isEmpty()) {
            rack.add(bag.draw());
        }

    }

    public String rackString() {
        StringBuilder sb = new StringBuilder();
        for (Tile t : rack) { // So I take it sb is an object that can add chars to it to form strings like a list
            sb.append(t.getLetter());
        }
        return sb.toString();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean hasLetters(String letters) {
        Map<Character, Integer> counts = new HashMap<>();

        // Count what is in our rack
        // What's going on here?
        for (Tile t: rack) {
            char ch = t.getLetter();
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            // I think this puts each char in each rack into the hashmap and also assigns a value to map to?
        }

        // Spend letters we need
        // What is this?
        for (char ch : letters.toUpperCase().toCharArray()) {
            int have = counts.getOrDefault(ch, 0);
            if (have <= 0) {
                return false;
            }
            counts.put(ch, have - 1);
        }
        return true;
    }

    //Remove letters from player's rack
    public void removeLetters(String letters) {
        for (char ch : letters.toUpperCase().toCharArray()) {
            // remove one matching tile from the rack
            for (int i = 0; i < rack.size(); i++) {
                if (rack.get(i).getLetter() == ch) {
                    rack.remove(i);
                    break; // stop after removing occurrence
                }
            }
        }
    }

}
