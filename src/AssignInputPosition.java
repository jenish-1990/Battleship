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
 * The {@code AssignInputPosition} class is responsible for assigning positions of ships and grenades on the game board
 * for both the player and the computer. It initializes the game board with these positions based on the inputs provided.
 *
 * This class plays a crucial role in the setup phase of the Battleship game, ensuring that both player and computer
 * have their ships and grenades positioned on the board before the game begins.
 */
public class AssignInputPosition {
    protected Position[][] convertInitialInputToArray = new Position[8][8];

    /**
     * Constructs an {@code AssignInputPosition} object and initializes the game board with ships and grenades
     * based on player and computer inputs.
     *
     * @param pInput The player input containing positions for ships and grenades.
     * @param cInput The computer input containing positions for ships and grenades.
     */
    public AssignInputPosition(PlayerInput pInput, ComputerInput cInput){
        setConvertInitialInputToArray(convertInitialInputToArray);
        assignPositionToArray(pInput.getPositionsOfShipsAndGrenade(), "user");
        assignPositionToArray(cInput.getPositionsOfShipsAndGrenade(), "computer");
    }

    public AssignInputPosition() {
        // Default constructor for creating an instance without initializing positions immediately.
    }

    /**
     * Assigns ships and grenades to specified positions on the game board.
     *
     * @param valueOfShipsAndGrenades Array of strings representing positions of ships and grenades.
     * @param owner Specifies whether the positions belong to the user or computer.
     */
    private void assignPositionToArray(String[] valueOfShipsAndGrenades, String owner){
        for (int k = 0; k < 10; k++) {
            int[] indexes = getIndexOf2DArray(valueOfShipsAndGrenades[k].toCharArray());
            int j = indexes[0];
            int i = indexes[1];
            if (k < 6) {
                convertInitialInputToArray[i][j] = new Position("ship", owner, false);
            } else {
                convertInitialInputToArray[i][j] = new Position("grenade", owner, false);
            }
        }
    }

    /**
     * Converts character inputs into array indexes for positioning on the game board.
     *
     * @param dataPoints Character array representing input positions (e.g., A1, B2).
     * @return Array of integers representing indexes on the game board.
     */
    protected int[] getIndexOf2DArray(char[] dataPoints){
        int[] tempArray = new int[2];
        switch (dataPoints[0]){
            case 'A':
                tempArray[0] = 0;
                break;
            case 'B':
                tempArray[0] = 1;
                break;
            case 'C':
                tempArray[0] = 2;
                break;
            case 'D':
                tempArray[0] = 3;
                break;
            case 'E':
                tempArray[0] = 4;
                break;
            case 'F':
                tempArray[0] = 5;
                break;
            case 'G':
                tempArray[0] = 6;
                break;
            case 'H':
                tempArray[0] = 7;
                break;
        }
        tempArray[1] = Integer.parseInt(String.valueOf(dataPoints[1])) - 1;
        return tempArray;
    }

    /**
     * Initializes the game board with default {@code Position} objects.
     *
     * @param convertInitialInputToArray The game board to be initialized.
     */
    public void setConvertInitialInputToArray(Position[][] convertInitialInputToArray) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                convertInitialInputToArray[i][j] = new Position();
            }
        }
    }

    /**
     * Retrieves the current state of the game board.
     *
     * @return The game board array of {@code Position} objects.
     */
    public Position[][] getConvertInitialInputToArray() {
        return convertInitialInputToArray;
    }

    /**
     * Prints the current state of the game board to the console.
     */
    public void printArray(){
        System.out.println("   A B C D E F G H");
        for (int i = 0; i < 8; i++) {
            System.out.print(i+1 + "  " + convertInitialInputToArray[i][0]);
            for (int j = 1; j < 8; j++) {
                System.out.print(" " + convertInitialInputToArray[i][j]);
            }
            System.out.println("");
        }
    }
}
