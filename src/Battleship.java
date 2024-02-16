// -----------------------------------------------------
// Assignment 1
// © Jenish Pravinbhai Akhed
// Written by: Jenish Pravinbhai Akhed, 40270365
// -----------------------------------------------------

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