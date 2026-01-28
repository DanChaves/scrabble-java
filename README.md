# Terminal Scrabble (Java)

A terminal-based Scrabble game implemented in Java using OOP principles.

This is still a work in progress.

## Features
- Two-player turn-based gameplay
- 15×15 Scrabble board rendered in ASCII
- Tile bag with standard Scrabble letter distribution
- Player racks with tile draw, usage, and refill logic
- Word placement using human-readable coordinates (e.g. H8)
- Horizontal and vertical word placement
- Overlap validation and conflict detection
- Robust input validation and error handling

## How to Run
1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run `Game.java`

## Commands
place <coord> <H|V> <WORD>
pass
quit
## Example:
place H8 H HELLO


## Project Structure
- `Tile`, `TileBag`, `TileValues` – tile representation and scoring
- `Player` – rack management and turn logic
- `Board` – grid representation and placement validation
- `Position`, `Direction` – coordinate parsing and movement logic
- `Game` – terminal game loop and user input handling

## Future Improvements
- Word scoring and bonuses (DL, TL, DW, TW)
- Dictionary validation
- First-move and adjacency rules
- Blank tiles
- Graphical user interface

## Author
Daniel Chaves
