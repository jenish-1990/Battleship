import java.util.Objects;

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
 * Provides functionality to check if given coordinates for ships and grenades are already used or outside the game grid.
 */
public class CheckCoordinates {

    /**
     * Checks if the given coordinate is already used for a ship or grenade.
     *
     * @param positionsOfShipsAndGrenade Array containing positions of ships and grenades.
     * @param valueOfShip The coordinate to check.
     * @return {@code true} if the coordinate is already used, {@code false} otherwise.
     */
    protected boolean usedCoordinates(String[] positionsOfShipsAndGrenade, String valueOfShip) {
        for (String s : positionsOfShipsAndGrenade) {
            if (Objects.equals(valueOfShip, s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given coordinate is outside the permissible game grid.
     *
     * @param valueOfShip The coordinate to check.
     * @return {@code true} if the coordinate is outside the grid, {@code false} otherwise.
     */
    protected boolean outsideGridCoordinates(String valueOfShip) {
        if (valueOfShip.charAt(0) < 'A' || valueOfShip.charAt(0) > 'H') {
            return true;
        }
        else if (valueOfShip.charAt(0) >= 'A' || valueOfShip.charAt(0) <= 'H') {
            return integerAfterCharacter(valueOfShip) < 1 || integerAfterCharacter(valueOfShip) > 8;
        } else {
            return false;
        }
    }

    /**
     * Extracts and returns the integer part after the character in a string coordinate.
     *
     * @param valueOfShip The coordinate string.
     * @return The integer part after the character in the coordinate.
     */
    private int integerAfterCharacter(String valueOfShip){
        String str = "";
        for (int j = 1; j < valueOfShip.length(); j++) {
            char ch = valueOfShip.charAt(j);
            str += ch;
        }
        return Integer.parseInt(str);
    }

}

/**
 * Exception thrown when coordinates provided are already in use.
 */
class AlreadyInUseCoordinates extends Exception{
    public AlreadyInUseCoordinates(){
        super("Sorry, coordinates are already in use. Please try again");
    }

    public String getMessage(){
        return super.getMessage();
    }
}

/**
 * Exception thrown when coordinates provided are outside the permissible game grid.
 */
class OutsideTheGridCoordinates extends Exception{
    public OutsideTheGridCoordinates(){
        super("Sorry, coordinates are outside the grid. Please try again");
    }

    public String getMessage(){
        return super.getMessage();
    }
}