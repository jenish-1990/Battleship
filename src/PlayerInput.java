import java.util.Scanner;

// -----------------------------------------------------
// Assignment 1
// &#169; Jenish Pravinbhai Akhed, Shruti Hiteshbhai Pavasiya
// Written by: Jenish Pravinbhai Akhed (40270365), Shruti Hiteshbhai Pavasiya (40270486)
// -----------------------------------------------------

/**
 * Handles the player's input for positioning ships and grenades on the game board.
 * Inherits from {@link CheckCoordinates} to validate coordinates against game rules.
 */
public class PlayerInput extends CheckCoordinates{
    private final String[] positionsOfShipsAndGrenade = new String[10];

    /**
     * Constructs a {@code PlayerInput} object, prompts the player to enter coordinates for ships and grenades,
     * and validates the input using inherited methods.
     */
    public PlayerInput(){
        Scanner scanner = new Scanner(System.in);
        loopingLogic(scanner, positionsOfShipsAndGrenade, "Enter the coordinates of your ship #%d: ",0,0,6);
        System.out.println("");
        loopingLogic(scanner, positionsOfShipsAndGrenade, "Enter the coordinates of your grenade #%d: ",0,6,10);
    }

    /**
     * Loops through the input process for ships or grenades, handling validation and re-prompting as necessary.
     *
     * @param scanner The scanner object for reading player input.
     * @param positionsOfShipsAndGrenade Array to store valid coordinates.
     * @param userPrompt Format string for prompting the user.
     * @param count Counter for the number of inputs taken.
     * @param startOfLoop Starting index for the loop.
     * @param endOfLoop Ending index for the loop.
     */
    private void loopingLogic(Scanner scanner, String[] positionsOfShipsAndGrenade, String userPrompt, int count, int startOfLoop, int endOfLoop) {
        for (int i = startOfLoop; i < endOfLoop; i++) {
            count++;
            boolean flag= true;
            while (flag){
                try {
                    System.out.format(userPrompt, count);
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
    }

    /**
     * Returns an array of strings containing the validated positions of ships and grenades entered by the player.
     *
     * @return Array of ship and grenade positions.
     */
    public String[] getPositionsOfShipsAndGrenade() {
        return positionsOfShipsAndGrenade;
    }

    /**
     * Returns a string representation of the positions of ships and grenades.
     *
     * @return A string containing all positions separated by spaces.
     */
    public String toString(){
        String str = "";
        for(String s: positionsOfShipsAndGrenade){
            str += s + " ";
        }
        return str;
    }
}
