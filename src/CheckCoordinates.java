import java.util.Objects;

public class CheckCoordinates {
    public boolean usedCoordinates(String[] positionsOfShipsAndGrenade, String valueOfShip) {
        for (String s : positionsOfShipsAndGrenade) {
            if (Objects.equals(valueOfShip, s)) {
                return true;
            }
        }
        return false;
    }

    public boolean outsideGridCoordinates(String valueOfShip) {
        if (valueOfShip.charAt(0) < 'A' || valueOfShip.charAt(0) > 'H') {
            return true;
        }
        else if (valueOfShip.charAt(0) >= 'A' || valueOfShip.charAt(0) <= 'H') {
            return integerAfterCharacter(valueOfShip) < 1 || integerAfterCharacter(valueOfShip) > 8;
        } else {
            return false;
        }
    }

    private int integerAfterCharacter(String valueOfShip){
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