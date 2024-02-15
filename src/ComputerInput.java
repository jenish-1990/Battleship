import java.util.Objects;
import java.util.Random;

public class ComputerInput{
    private final String[] positionsOfShipsAndGrenade = new String[10];

    public ComputerInput(PlayerInput pInput){
        loopingLogic(pInput, positionsOfShipsAndGrenade, 0,6);
        loopingLogic(pInput, positionsOfShipsAndGrenade, 6,10);
    }

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

    protected String generateRandomString(){
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

    public String toString(){
        String str = "";
        for(String s: positionsOfShipsAndGrenade){
            str += s + "\n";
        }
        return str;
    }
}
