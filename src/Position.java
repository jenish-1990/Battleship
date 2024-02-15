public class Position {
    private String typeOfElement;
    private String ownerOfElement;
    private boolean positionCalledStatus;
    private boolean hidden;

    public Position(){
        this.typeOfElement = "nothing";
        this.hidden = true;
    }

    public Position(String typeOfElement, String ownerOfElement, boolean positionCalledStatus) {
        this.typeOfElement = typeOfElement;
        this.ownerOfElement = ownerOfElement;
        this.positionCalledStatus = positionCalledStatus;
        this.hidden = true;
    }

    public String getTypeOfElement() {
        return typeOfElement;
    }

    public String getOwnerOfElement() {
        return ownerOfElement;
    }

    public boolean isPositionCalledStatus() {
        return positionCalledStatus;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setPositionCalledStatus(boolean positionCalledStatus) {
        this.positionCalledStatus = positionCalledStatus;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getHidden() {
        return "_";
    }

    public String getHitNothing() {
        return "*";
    }

    public String getPlayerShip() {
        return "s";
    }

    public String getComputerShip() {
        return "S";
    }

    public String getPlayerGrenade() {
        return "g";
    }

    public String getComputerGrenade() {
        return "G";
    }

    public String toString(){
        String str = "";
        if (!isHidden()){
            if (getTypeOfElement() == "ship" && getOwnerOfElement() == "user"){
                str = getPlayerShip();
            } else if (getTypeOfElement() == "grenade" && getOwnerOfElement() == "user") {
                str = getPlayerGrenade();
            } else if (getTypeOfElement() == "ship" && getOwnerOfElement() == "computer") {
                str = getComputerShip();
            } else if (getTypeOfElement() == "grenade" && getOwnerOfElement() == "computer") {
                str = getComputerGrenade();
            } else if (getTypeOfElement() == "nothing") {
                str = getHitNothing();
            }
        } else {
            str = getHidden();
        }
        return str;
    }
}
