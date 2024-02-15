// -----------------------------------------------------
// Assignment 1
// © Jenish Pravinbhai Akhed
// Written by: Jenish Pravinbhai Akhed, 40270365
// -----------------------------------------------------

public class Battleship {
    public static void main(String[] args) {
        System.out.println("Welcome to the BATTLESHIP");
        System.out.println("--------------------------");
        System.out.println("May Force Be With You -Star Wars\n");

        PlayerInput playerInput = new PlayerInput();
        ComputerInput computerInput = new ComputerInput(playerInput);
        AssignInputPosition assignInputPosition = new AssignInputPosition(playerInput, computerInput);

        System.out.println(playerInput);
        System.out.println(computerInput);
        assignInputPosition.printArray();
    }
}