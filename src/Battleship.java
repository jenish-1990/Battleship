/**
 * This class is a part of the submission for COMP249 Assignment 1.
 * <p>
 * Name(s) and ID(s):
 * @auhtor Jenish Pravinbhai Akhed, 40270365
 * @author Shruti Hiteshbhai Pavasiya, 40270486
 * <p>
 * Assignment 1
 * <p>
 * Due Date: 16th February 2024
 * <p>
 * &#169; Jenish Pravinbhai Akhed, Shruti Hiteshbhai Pavasiya
 */

/**
 * Main class for the Battleship game. It initiates the game and controls the game flow.
 * <p>
 * This program simulates a simplified version of the classic game Battleship. It welcomes the player,
 * displays a thematic message, and then enters the main game loop managed by the {@link GameEngine} class.
 * The game continues until a player wins, at which point the game exits the loop and ends.
 * </p>
 *
 * Main steps in the program:
 * 1. Print welcome and thematic messages to the console.
 * 2. Instantiate the {@link GameEngine} to manage game logic.
 * 3. Enter a loop that continues the game turns until a win condition is met.
 */

public class Battleship {
    public static void main(String[] args){
        System.out.println("Welcome to the BATTLESHIP");
        System.out.println("--------------------------");
        System.out.println("May Force Be With You -Star Wars\n");

        GameEngine gameEngine = new GameEngine();
        boolean gameOn = true;

        while (gameOn) {
            gameOn = gameEngine.playTurn();
        }
    }
}