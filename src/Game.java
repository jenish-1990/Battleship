public class Game extends AssignInputPosition{
    public static int userTotalShips = 6;
    public static int computerTotalShips = 6;
    public boolean skip = false;

    public Game(){
        super();
    }

    public void gameLogic(String rocketPosition, AssignInputPosition aIP) {
        int[] indexes = super.getIndexOf2DArray(rocketPosition.toCharArray());
        int j = indexes[0];
        int i = indexes[1];

        Position[][] positionMatrix = aIP.convertInitialInputToArray;
        Position a = positionMatrix[i][j];

        if (!a.isPositionCalledStatus() && a.getTypeOfElement() == "nothing"){
            a.setHidden(false);
            a.setPositionCalledStatus(true);
            System.out.println("Rocket hit nothing.");
        } else if (!a.isPositionCalledStatus() && a.getTypeOfElement() == "ship" && a.getOwnerOfElement() == "user") {
            a.setHidden(false);
            a.setPositionCalledStatus(true);
            userTotalShips--;
            if (userTotalShips == 0){
                System.out.println("Rocket hit the user's ship. You Won!");
                aIP.printArray();
                System.exit(0);
            } else {
                System.out.println("Rocket hit the user's ship.");
            }
        } else if (!a.isPositionCalledStatus() && a.getTypeOfElement() == "grenade" && a.getOwnerOfElement() == "user") {
            a.setHidden(false);
            a.setPositionCalledStatus(true);
            System.out.println("Boom! blew the user's grenade.");
            skip = true;
        } else if (!a.isPositionCalledStatus() && a.getTypeOfElement() == "ship" && a.getOwnerOfElement() == "computer") {
            a.setHidden(false);
            a.setPositionCalledStatus(true);
            computerTotalShips--;
            if (computerTotalShips == 0){
                System.out.println("Rocket hit the computer's ship. You Won!");
                aIP.printArray();
                System.exit(0);
            } else {
                System.out.println("Rocket hit the computer's ship.");
            }
        } else if (!a.isPositionCalledStatus() && a.getTypeOfElement() == "grenade" && a.getOwnerOfElement() == "computer") {
            a.setHidden(false);
            a.setPositionCalledStatus(true);
            System.out.println("Boom! blew the computer's grenade.");
            skip = true;
        } else if (a.isPositionCalledStatus()) {
            System.out.println("Position has been already called.");
        }
    }

    public static int getUserTotalShips() {
        return userTotalShips;
    }

    public static int getComputerTotalShips() {
        return computerTotalShips;
    }
}
