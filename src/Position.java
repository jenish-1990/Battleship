/**
 * This class is a part of the submission for COMP249 Assignment 1.
 * <p>
 * Name(s) and ID(s):
 * - Jenish Pravinbhai Akhed, 40270365
 * - Shruti Hiteshbhai Pavasiya, 40270486
 * <p>
 * Assignment 1
 * <p>
 * Due Date: 16th February 2024
 * <p>
 * &#169; Jenish Pravinbhai Akhed, Shruti Hiteshbhai Pavasiya
 */

/**
 * Represents a position on the Battleship game board. Each position can hold a ship, a grenade,
 * or be empty ("nothing"), and belongs to either the user or the computer. Positions can also be hidden or revealed.
 */
public class Position {
    private String typeOfElement; // "ship", "grenade", or "nothing"
    private String ownerOfElement; // "user" or "computer"
    private boolean positionCalledStatus; // Whether this position has been called
    private boolean hidden; // Whether this position's contents should be shown

    /**
     * Constructs a default {@code Position} object with type "nothing" and marked as hidden.
     */
    public Position(){
        this.typeOfElement = "nothing";
        this.hidden = true;
    }

    /**
     * Constructs a {@code Position} with specified attributes.
     *
     * @param typeOfElement The type of element ("ship", "grenade", or "nothing").
     * @param ownerOfElement The owner of the element ("user" or "computer").
     * @param positionCalledStatus Whether the position has been called.
     */
    public Position(String typeOfElement, String ownerOfElement, boolean positionCalledStatus) {
        this.typeOfElement = typeOfElement;
        this.ownerOfElement = ownerOfElement;
        this.positionCalledStatus = positionCalledStatus;
        this.hidden = true;
    }

    // Getter and setter methods
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

    /**
     * Returns a string representation of this position, showing different symbols based on the position's state
     * and content.
     *
     * @return A single-character string representing the state of the position.
     */
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
