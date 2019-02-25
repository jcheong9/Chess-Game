import java.io.Serializable;

import javafx.scene.shape.Rectangle;
/**
 * Square class is a rectangle holds the piece, row and column.
 * @author SmallYellowFace
 *
 */
public class Square extends Rectangle implements Serializable{
    /**
     * row stores the x coordinates 
     */
    private final int row;
    /**
     * col stores the y coordinates 
     */
    private final int col;
    /**
     * piece stores the piece object
     */
    private Piece piece;
    /**
     * Constructor stores the row and col parameters
     * @param paramInt1
     * @param paramInt2
     */
    public Square(int rowNum, int colNum) {
        super(100, 100);
        row = rowNum;
        col = colNum;

    }
    /**
     * Method set the piece
     * @param p
     */
    public void setPiece(Piece p) {
        piece = p;
    }
    /**
     * Method get the piece
     * @param p
     */
    public Piece getPiece() {
        return piece;
    }
    /**
     * Method get the piece
     * @param p
     */
    public int getRow() {
        return row;
    }
    /**
     * Method get the column
     * @param p
     */
    public int getCol() {
        return col;
    }

}