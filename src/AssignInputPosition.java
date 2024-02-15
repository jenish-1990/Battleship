public class AssignInputPosition {
    protected String[][] convertInitialInputToArray = new String[8][8];

    public AssignInputPosition(PlayerInput pInput, ComputerInput cInput){
        setConvertInitialInputToArray(convertInitialInputToArray);
        assignPositionToArray(pInput.getPositionsOfShipsAndGrenade(), 's', 'g');
        assignPositionToArray(cInput.getPositionsOfShipsAndGrenade(), 'S', 'G');
    }

    private void assignPositionToArray(String[] valueOfShipsAndGrenades, char ship, char grenade){
        for (int k = 0; k < 10; k++) {
            int[] indexes = getIndexOf2DArray(valueOfShipsAndGrenades[k].toCharArray());
            int j = indexes[0];
            int i = indexes[1];
            if (k < 6) {
                convertInitialInputToArray[i][j] = String.valueOf(ship);
            } else {
                convertInitialInputToArray[i][j] = String.valueOf(grenade);
            }
        }
    }

    private int[] getIndexOf2DArray(char[] dataPoints){
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

    public void setConvertInitialInputToArray(String[][] convertInitialInputToArray) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                convertInitialInputToArray[i][j] = "*";
            }
        }
    }

    public String[][] getConvertInitialInputToArray() {
        return convertInitialInputToArray;
    }

    public void printArray(){
        for (int i = 0; i < 8; i++) {
            System.out.print(convertInitialInputToArray[i][0]);
            for (int j = 1; j < 8; j++) {
                System.out.print(" " + convertInitialInputToArray[i][j]);
            }
            System.out.println("");
        }
    }
}
