import java.util.Scanner;

public class PlayerInput extends CheckCoordinates{
    private final String[] positionsOfShipsAndGrenade = new String[10];

    public PlayerInput(){
        Scanner scanner = new Scanner(System.in);
        loopingLogic(scanner, positionsOfShipsAndGrenade, "Enter the coordinates of your ship #%d: ",0,0,6);
        System.out.println("");
        loopingLogic(scanner, positionsOfShipsAndGrenade, "Enter the coordinates of your grenade #%d: ",0,6,10);
    }

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

    public String[] getPositionsOfShipsAndGrenade() {
        return positionsOfShipsAndGrenade;
    }

    public String toString(){
        String str = "";
        for(String s: positionsOfShipsAndGrenade){
            str += s + "\n";
        }
        return str;
    }
}
