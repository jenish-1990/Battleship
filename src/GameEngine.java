import java.util.Scanner;

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
 * The {@code GameEngine} class manages the gameplay logic for the Battleship game. It keeps track of
 * the total ships each player has, handles the turn-based gameplay, and checks for game over conditions.
 * <p>
 * This class uses instances of {@link PlayerInput}, {@link ComputerInput}, {@link AssignInputPosition},
 * and {@link CheckCoordinates} to manage the game's state, including ship and grenade positions, and to
 * handle user and computer turns.
 * </p>
 *
 * Main steps in the gameplay loop:
 * 1. Initialize the game with player and computer inputs.
 * 2. Loop through turns, allowing the user and computer to fire rockets in turn.
 * 3. Check for hits, misses, or grenade explosions and update the game state accordingly.
 * 4. Switch turns between the user and computer, considering special conditions like grenade explosions.
 * 5. Check if the game is over by determining if any player has lost all their ships.
 */

public class GameEngine{
    public static int userTotalShips = 6;
    public static int computerTotalShips = 6;
    private PlayerInput playerInput;
    private ComputerInput computerInput;
    private AssignInputPosition assignInputPosition;
    private CheckCoordinates checkCoordinates;
    private ComputerInput computerRocketInput;
    private int currentUser = 0;
    private boolean userSkip = false;
    private boolean computerSkip = false;
    Scanner scanner = new Scanner(System.in);

    /**
     * Initializes the game engine, including setting up player and computer inputs and positions.
     */
    public GameEngine() {
        playerInput = new PlayerInput();
        computerInput = new ComputerInput(playerInput);
        checkCoordinates = new CheckCoordinates();

        System.out.println("\nOK, the computer has placed its ships and grenades at random. Lets play the battleship. \n");

        assignInputPosition = new AssignInputPosition(playerInput, computerInput);
        computerRocketInput = new ComputerInput();
        System.out.println(playerInput);
        System.out.println(computerInput);
        System.out.println("");
    }

    /**
     * Executes a single turn of gameplay, alternating between user and computer.
     *
     * @return {@code true} if the game should continue, {@code false} if the game is over.
     */
    public boolean playTurn() {
        String rocketPosition;
        try {
            if (currentUser == 0) {
                System.out.print("Position of user's rocket: ");
                rocketPosition = scanner.next().toUpperCase();
                if (checkCoordinates.outsideGridCoordinates(rocketPosition)) {
                    throw new OutsideTheGridCoordinates();
                } else {
                    processTurn(rocketPosition, "user");
                    switchPlayer();
                }
            } else {
                rocketPosition = computerRocketInput.generateRandomString();
                System.out.println("Position of computer's rocket: " + rocketPosition);
                processTurn(rocketPosition, "computer");
                switchPlayer();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
        return checkGameOver();
    }

    /**
     * Processes the outcome of a turn, including updating the game state based on the position targeted.
     *
     * @param position The position targeted in this turn.
     * @param playerType The type of player ("user" or "computer") taking the turn.
     */
    private void processTurn(String position, String playerType) {
        int[] indexes = assignInputPosition.getIndexOf2DArray(position.toCharArray());
        int j = indexes[0];
        int i = indexes[1];

        Position[][] positionMatrix = assignInputPosition.convertInitialInputToArray;
        Position a = positionMatrix[i][j];

        if (!a.isPositionCalledStatus()) {
            a.setPositionCalledStatus(true);
            a.setHidden(false);
            switch (a.getTypeOfElement()) {
                case "nothing":
                    System.out.println("Rocket hit nothing.");
                    break;
                case "ship":
                    if ("user".equals(a.getOwnerOfElement())) {
                        userTotalShips--;
                        if (userTotalShips == 0) {
                            System.out.println("All user's ships have been sunk. Computer Won!");
                        } else {
                            System.out.println("Rocket hit the user's ship.");
                        }
                    } else {
                        computerTotalShips--;
                        if (computerTotalShips == 0) {
                            System.out.println("All computer's ships have been sunk. User Won!");
                        } else {
                            System.out.println("Rocket hit the computer's ship.");
                        }
                    }
                    break;
                case "grenade":
                    System.out.println("Boom! A grenade exploded.");
                    if ("user".equals(playerType)) {
                        userSkip = true;
                    } else {
                        computerSkip = true;
                    }
                    if (userSkip && computerSkip) {
                        if ("user".equals(playerType)) {
                            userSkip = true;
                            computerSkip = false;
                        } else {
                            computerSkip = true;
                            userSkip = false;
                        }
                    }
                    break;
            }
        } else {
            System.out.println("Position has been already called.");
        }
        assignInputPosition.printArray();
    }

    /**
     * Switches the current player turn, considering any skips due to grenade explosions.
     */
    private void switchPlayer() {
        if (currentUser == 0 && !computerSkip) {
            currentUser = 1;
        } else if (currentUser == 1 && !userSkip) {
            currentUser = 0;
        } else {
            userSkip = false;
            computerSkip = false;
        }
    }

    /**
     * Checks if the game is over by evaluating if any player has lost all their ships.
     *
     * @return {@code true} if the game should continue, {@code false} if the game is over.
     */
    private boolean checkGameOver() {
        if (userTotalShips == 0 || computerTotalShips == 0) {
            return false;
        }
        return true;
    }
}
