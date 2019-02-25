import java.io.Serializable;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
/**
 * Class creates a Board
 * @author SmallYellowFace
 * @version 1
 */
public class Board extends GridPane implements Serializable{
    /**
     * squaList stores the 2d array.
     */
    private final Square[][] squaList;
    /**
     * turn stores the next player turn
     */
    private String turn;
    /**
     * Constructor that assign the board.
     */
    public Board() {
        squaList = new Square[8][8];
        turn = "Black";
    }
    
    /**
     * Initialize the grid pattern building.
     * @param gui
     */
    public void init(ClickEvent clickEvent) {
        
        for (int i = 0; i < squaList.length; i++) {
            for (int j = 0; j < squaList[i].length; j++) {
                squaList[i][j] = new Square(i, j);
                Color color;
                if ((i + j) % 2 == 0) {
                    color = Color.WHITE;
                } else {
                    color = Color.GREY;
                }
                squaList[i][j].setFill(color);
                squaList[i][j].setOnMousePressed(clickEvent);
                add(squaList[i][j], i, j);

            }
        }
    }
    /*
     * Method get the square at given coorX and coorY;
     */
    public Square getSquareAt(int coorX, int coorY) {
        return squaList[coorX][coorY];
    }
    /*
     * Method set the square at given coorX and coorY
     */
    public void setSquareAt(Square square,int coorX, int coorY) {
        squaList[coorX][coorY] = square;
    }
    /*
     * Method remove the image to the board.
     */
    public void removeImg(int x, int y) {
        
        ObservableList<Node> childrens = getChildren();
        for(Node node : childrens) {
            if(node instanceof ImageView && getRowIndex(node) == y && getColumnIndex(node) == x) {
                ImageView imageView = (ImageView) node; // use what you want to remove
                getChildren().remove(imageView);
                break;
            }
          } 
    }
    /**
     * Method add the image to the board.
     * @param img
     * @param x
     * @param y
     */
    public void addImg(ImageView img, int x, int y) {
        setHalignment(img, HPos.CENTER); 
        add(img, x, y);
    }
    /**
     * Method returns last player's turn.
     * @return
     */
    public String getTurn() {
        return turn;
    }
    /**
     * Method set the player's turn
     * @param str
     */
    public void setTurn(String str) {
        turn = str;
    }
}
