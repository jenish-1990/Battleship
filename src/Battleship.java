// -----------------------------------------------------
// Assignment 1
// © Jenish Pravinbhai Akhed
// Written by: Jenish Pravinbhai Akhed, 40270365
// -----------------------------------------------------

import java.util.Objects;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the BATTLESHIP");
        System.out.println("--------------------------");
        System.out.println("May Force Be With You -Star Wars");

        String[] positionsOfShipsAndGrenade = new String[10];

        for (int i = 0; i < 6; i++) {
            try {
                System.out.format("Enter the coordinates of your ship #%d: ", i+1);
                positionsOfShipsAndGrenade[i] = scanner.next();
                if (usedCoordinates(positionsOfShipsAndGrenade, i)){
                    throw new AlreadyInUseCoordinates();
                } else if (outsideGridCoordinates(positionsOfShipsAndGrenade, i)) {
                    throw new OutsideTheGridCoordinates();
                }
            } catch (AlreadyInUseCoordinates | OutsideTheGridCoordinates e){
                System.out.println(e);
            }
        }
    }

    public static boolean usedCoordinates(String[] positionsOfShipsAndGrenade, int i) {
        for (String s : positionsOfShipsAndGrenade) {
            if (Objects.equals(positionsOfShipsAndGrenade[i], s)) {
                return true;
            }
        }
        return false;
    }

//    public static boolean outsideGridCoordinates(String[] positionsOfShipsAndGrenade, int i) {
//        return positionsOfShipsAndGrenade[i].toLowerCase().charAt(0) < 'a' || positionsOfShipsAndGrenade[i].toLowerCase().charAt(0) > 'h' || Integer.parseInt(String.valueOf(positionsOfShipsAndGrenade[i].charAt(1))) < 1 || Integer.parseInt(String.valueOf(positionsOfShipsAndGrenade[i].charAt(1))) > 8;
//    }
//}

    public static boolean outsideGridCoordinates(String[] positionsOfShipsAndGrenade, int i) {
        if (positionsOfShipsAndGrenade[i].toLowerCase().charAt(i) < 'a' || positionsOfShipsAndGrenade[i].toLowerCase().charAt(i) > 'h')
            return true;
        if (positionsOfShipsAndGrenade[i].toLowerCase().charAt(i) > 'a' || positionsOfShipsAndGrenade[i].toLowerCase().charAt(i) < 'h') {
            if (integerAfterCharacter(positionsOfShipsAndGrenade[i]) < 1 || integerAfterCharacter(positionsOfShipsAndGrenade[i]) > 8) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public static int integerAfterCharacter(String positionsOfShipsAndGrenade){
        String str = null;
        for (int j = 1; j < positionsOfShipsAndGrenade.length(); j++) {
            char ch = positionsOfShipsAndGrenade.charAt(j);
            str = str + ch;
        }
        int temp = Integer.parseInt(str);
        return temp;
    }

}

class AlreadyInUseCoordinates extends Exception{
    public AlreadyInUseCoordinates(){
        super("Sorry, coordinates are already in use. Please try again");
    }
}

class OutsideTheGridCoordinates extends Exception{
    public OutsideTheGridCoordinates(){
        super("Sorry, coordinates are outside the grid. Please try again");
    }
}