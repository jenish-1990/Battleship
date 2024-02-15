// -----------------------------------------------------
// Assignment 1
// © Jenish Pravinbhai Akhed
// Written by: Jenish Pravinbhai Akhed, 40270365
// -----------------------------------------------------

import java.util.Scanner;

public class Battleship {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the BATTLESHIP");
        System.out.println("--------------------------");
        System.out.println("May Force Be With You -Star Wars\n");

        PlayerInput playerInput = new PlayerInput();
        ComputerInput computerInput = new ComputerInput(playerInput);
        CheckCoordinates checkCoordinates = new CheckCoordinates();

        System.out.println("\nOK, the computer has placed its ships and grenades at random. Let’s play the battleship. \n");

        AssignInputPosition assignInputPosition = new AssignInputPosition(playerInput, computerInput);
        Game game = new Game();

        System.out.println(playerInput);
        System.out.println(computerInput);
        assignInputPosition.printArray();
        System.out.println("\n");

        ComputerInput computerRocketInput = new ComputerInput();
        int currentUser = 0;
        boolean gameOn = true;
        boolean uskip = false;
        boolean cskip = false;

        while (gameOn) {
            String rocketPosition;
            try {
                if (currentUser == 0){
                    System.out.print("Position of user's rocket: ");
                    rocketPosition = scanner.next().toUpperCase();
                    if (checkCoordinates.outsideGridCoordinates(rocketPosition)) {
                        throw new OutsideTheGridCoordinates();
                    } else {
                        game.gameLogic(rocketPosition, assignInputPosition);
                        assignInputPosition.printArray();
                        uskip = game.skip;
                        if (cskip){
                            currentUser = 0;
                            cskip = false;
                            game.skip = false;
                        } else {
                            currentUser = 1;
                        }
                    }
                } else if (currentUser == 1){
                    rocketPosition = computerRocketInput.generateRandomString();
                    System.out.println("Position of computer's rocket: " + rocketPosition);
                    game.gameLogic(rocketPosition, assignInputPosition);
                    assignInputPosition.printArray();
                    cskip = game.skip;
                    if (uskip){
                        currentUser = 1;
                        uskip = false;
                        game.skip = false;
                    } else {
                        currentUser = 0;
                    }
                }
            } catch (OutsideTheGridCoordinates e) {
                System.out.println(e.getMessage());
            }
        }
    }
}