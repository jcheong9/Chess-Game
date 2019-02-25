import java.io.Serializable;


public abstract class Piece implements Serializable{
    /**
     * pieceType stores the piece type
     */
    private final String pieceType;
    /**
     * owner stores the player
     */
    private final Player owner;
    /**
     * square stores the square object
     */
    private Square square;
    /**
     * img stores the ImageView object
     */
    private String img;
    /**
     * pathClear stores the false the piece can not jump
     */
    private Boolean pathClear = true;
    /**
     * Constructor instantiate the plate and the string of type
     * @param paramPlayer
     * @param paramString
     */
    public Piece(Player paramPlayer, String paramString, String imgBlackPiece, String imgWhitePiece) {
        owner = paramPlayer;
        pieceType = paramString;
        
        if (paramPlayer.getPlayerColor() == "Black") {
            img = imgBlackPiece;

        } else {
            img = imgWhitePiece;

        }
    }
    /**
     * Method get the pieceType
     */
    public String getPieceType() {
        return pieceType;
    }
    /**
     * Method get the owner
     */
    public Player getOwner() {
        return owner;
    }
    /**
     * Method set the square
     */
    public void setSquare(Square paramSquare) {
        square = paramSquare;
    }
    /**
     * Method get the square
     */
    public Square getSquare() {
        return square;
    }
    /**
     * Method get the ImageView
     */
    public String getImg() {
        return img;
    }
    /**
     * Method get the pathClear
     */
    public Boolean getPathClear() {
        return pathClear;
    }
    /**
     * Method checks is it a valid move
     * @return
     */
    public abstract Boolean moveValid(int x1, int y1, int x2, int y2);
    


}