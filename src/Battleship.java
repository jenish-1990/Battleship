// -----------------------------------------------------
// Assignment 1
// © Jenish Pravinbhai Akhed
// Written by: Jenish Pravinbhai Akhed, 40270365
// -----------------------------------------------------

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Objects;
import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the BATTLESHIP");
        System.out.println("--------------------------");
        System.out.println("May Force Be With You -Star Wars\n");

        String[] positionsOfShipsAndGrenade = new String[10];

        for (int i = 0; i < 6; i++) {
            boolean flag= true;
            while (flag){
                try {
                    System.out.format("Enter the coordinates of your ship #%d: ", i+1);
                    String valueOfShipGrenade = scanner.next().toUpperCase();
                    if (usedCoordinates(positionsOfShipsAndGrenade, valueOfShipGrenade)){
                        throw new AlreadyInUseCoordinates();
                    } else if (outsideGridCoordinates(valueOfShipGrenade)) {
                        throw new OutsideTheGridCoordinates();
                    } else {
                        positionsOfShipsAndGrenade[i] = valueOfShipGrenade;
                        flag = false;
                    }
                } catch (AlreadyInUseCoordinates e){
                    System.out.println(e.getMessage());
                } catch (OutsideTheGridCoordinates e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println("");

        int count = 0;
        for (int i = 6; i < 10; i++) {
            count++;
            boolean flag= true;
            while (flag){
                try {
                    System.out.format("Enter the coordinates of your grenade #%d: ", count);
                    String valueOfShipGrenade = scanner.next().toUpperCase();
                    if (usedCoordinates(positionsOfShipsAndGrenade, valueOfShipGrenade)){
                        throw new AlreadyInUseCoordinates();
                    } else if (outsideGridCoordinates(valueOfShipGrenade)) {
                        throw new OutsideTheGridCoordinates();
                    } else {
                        positionsOfShipsAndGrenade[i] = valueOfShipGrenade;
                        flag = false;
                    }
                } catch (AlreadyInUseCoordinates e){
                    System.out.println(e.getMessage());
                } catch (OutsideTheGridCoordinates e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        for (String s: positionsOfShipsAndGrenade){
            System.out.println(s);
        }
    }

    public static boolean usedCoordinates(String[] positionsOfShipsAndGrenade, String valueOfShip) {
        for (String s : positionsOfShipsAndGrenade) {
            if (Objects.equals(valueOfShip, s)) {
                return true;
            }
        }
        return false;
    }

    public static boolean outsideGridCoordinates(String valueOfShip) {
        if (valueOfShip.charAt(0) < 'A' || valueOfShip.charAt(0) > 'H') {
            return true;
        }
        else if (valueOfShip.charAt(0) >= 'A' || valueOfShip.charAt(0) <= 'H') {
            return integerAfterCharacter(valueOfShip) < 1 || integerAfterCharacter(valueOfShip) > 8;
        } else {
            return false;
        }
    }

    public static int integerAfterCharacter(String valueOfShip){
        String str = "";
        for (int j = 1; j < valueOfShip.length(); j++) {
            char ch = valueOfShip.charAt(j);
            str += ch;
        }
        return Integer.parseInt(str);
    }

}

class AlreadyInUseCoordinates extends Exception{
    public AlreadyInUseCoordinates(){
        super("Sorry, coordinates are already in use. Please try again");
    }

    public String getMessage(){
        return super.getMessage();
    }
}

class OutsideTheGridCoordinates extends Exception{
    public OutsideTheGridCoordinates(){
        super("Sorry, coordinates are outside the grid. Please try again");
    }

    public String getMessage(){
        return super.getMessage();
    }
}