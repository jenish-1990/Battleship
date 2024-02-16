import java.util.Scanner;

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

    public GameEngine() {
        playerInput = new PlayerInput();
        computerInput = new ComputerInput(playerInput);
        checkCoordinates = new CheckCoordinates();

        System.out.println("\nOK, the computer has placed its ships and grenades at random. Let’s play the battleship. \n");

        assignInputPosition = new AssignInputPosition(playerInput, computerInput);
        computerRocketInput = new ComputerInput();
        System.out.println(playerInput);
        System.out.println(computerInput);
        System.out.println("");
    }

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

    private boolean checkGameOver() {
        if (userTotalShips == 0 || computerTotalShips == 0) {
            return false;
        }
        return true;
    }
}
