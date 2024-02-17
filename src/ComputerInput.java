import java.util.Objects;
import java.util.Random;

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
 * Generates computer inputs for ship and grenade positions in the Battleship game.
 * It can operate independently or consider player inputs to avoid overlapping positions.
 */
public class ComputerInput{
    private final String[] positionsOfShipsAndGrenade = new String[10];

    public ComputerInput(){
        // Default constructor for generating positions without considering player inputs.
    }

    /**
     * Generates positions for computer's ships and grenades, avoiding overlap with player's positions.
     *
     * @param pInput PlayerInput object to check against for avoiding overlapping positions.
     */
    public ComputerInput(PlayerInput pInput){
        loopingLogic(pInput, positionsOfShipsAndGrenade, 0,6);
        loopingLogic(pInput, positionsOfShipsAndGrenade, 6,10);
    }

    /**
     * Logic to generate and validate positions for ships and grenades.
     *
     * @param pInput PlayerInput object for comparison to avoid overlap.
     * @param positionsOfShipsAndGrenade Array to hold generated positions.
     * @param startOfLoop Starting index for ship or grenade position generation.
     * @param endOfLoop Ending index for ship or grenade position generation.
     */
    private void loopingLogic(PlayerInput pInput, String[] positionsOfShipsAndGrenade, int startOfLoop, int endOfLoop) {
        for (int i = startOfLoop; i < endOfLoop; i++) {
            String valueOfShipGrenade = generateRandomString();
            if (checkUsedCoordinatesForComputer(pInput.getPositionsOfShipsAndGrenade(), positionsOfShipsAndGrenade, valueOfShipGrenade)){
                i--;
            } else {
                positionsOfShipsAndGrenade[i] = valueOfShipGrenade;
            }
        }
    }

    /**
     * Checks if a generated coordinate for the computer overlaps with any previously set positions.
     *
     * @param pInputString Positions set by the player.
     * @param positionsOfShipsAndGrenade Current positions set by the computer.
     * @param valueOfShip The newly generated position to be checked.
     * @return {@code true} if the position overlaps, {@code false} otherwise.
     */
    protected boolean checkUsedCoordinatesForComputer(String[] pInputString, String[] positionsOfShipsAndGrenade, String valueOfShip){
        for (String s : positionsOfShipsAndGrenade) {
            if (Objects.equals(valueOfShip, s)) {
                return true;
            }
        }
        for (String s : pInputString) {
            if (Objects.equals(valueOfShip, s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a random string representing a position on the game board.
     *
     * @return A random valid game board position.
     */
    public String generateRandomString(){
        String[] allowedLetters = new String[]{"ABCDEFGH", "12345678"};
        int length = 2;
        char[] charArray = new char[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedLetters[i].length());
            charArray[i] = allowedLetters[i].charAt(index);
        }
        return new String(charArray);
    }

    /**
     * Returns the positions of ships and grenades set by the computer.
     *
     * @return An array of strings representing the positions.
     */
    public String[] getPositionsOfShipsAndGrenade() {
        return positionsOfShipsAndGrenade;
    }

    /**
     * Returns a string representation of the computer's ship and grenade positions.
     *
     * @return A string listing all positions separated by spaces.
     */
    public String toString(){
        String str = "";
        for(String s: positionsOfShipsAndGrenade){
            str += s + " ";
        }
        return str;
    }
}
