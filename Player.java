import java.io.Serializable;

/**
 * Player Class
 * @author SmallYellowFace
 * 
 */
public class Player implements Serializable{
    /**
     * colour stores the colour
     */
    public final String colour;
    /**
     * myTurn stores boolean
     */
    public boolean myTurn;
    /**
     * Constructor assignt the values.
     */
    public Player(String paramColor, boolean paramMyTurn) {
        colour = paramColor;
        this.myTurn = paramMyTurn;
    }
    /**
     * Method gets the player colour value
     */
    public String getPlayerColor() {
        return colour;
    }
    /**
     * Method get the myTurn boolean value
     * @param turn
     */
    public boolean getMyTurn() {
        return myTurn;
    }
    /**
     * Method set the myTurn boolean value
     * @param turn
     */
    public void setMyTurn(boolean turn) {
        myTurn = turn;
    }
}
