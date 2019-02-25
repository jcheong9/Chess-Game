import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * GUI displays the objects on the screen.
 * 
 * @author SmallYellowFace
 * @version 1
 */
public class GUI extends Application {
    /**
     * onePlayer stores the player object.
     */
    private final Player onePlayer = new Player("White",true);
    /**
     * onePlayer stores the player object.
     */
    private final Player twoPlayer = new Player("Black",false);
    /**
     * root stores the Board object.
     */
    
    private Board root = new Board();
    private ClickEvent clickEvent= new ClickEvent(this);

    /**
     * Initialized the board creation and the initial pieces.
     */
    public void init() {
//        clickEvent = new ClickEvent(this);
        root.init(clickEvent); 
        initPieces();
    }

    /**
     * Method sets the pieces on the board.
     */
    public void initPieces() {
        setPiece(0, 0, new Rook(onePlayer));
        setPiece(1, 0, new Knight(onePlayer));
        setPiece(2, 0, new Bishop(onePlayer));
        setPiece(3, 0, new King(onePlayer));
        setPiece(4, 0, new Queen(onePlayer));
        setPiece(5, 0, new Bishop(onePlayer));
        setPiece(6, 0, new Knight(onePlayer));
        setPiece(7, 0, new Rook(onePlayer));

        for (int i = 0; i < 8; i++) {
            setPiece(i, 1, new Pawn(onePlayer));
        }

        setPiece(0, 7, new Rook(twoPlayer));
        setPiece(1, 7, new Knight(twoPlayer));
        setPiece(2, 7, new Bishop(twoPlayer));
        setPiece(3, 7, new King(twoPlayer));
        setPiece(4, 7, new Queen(twoPlayer));
        setPiece(5, 7, new Bishop(twoPlayer));
        setPiece(6, 7, new Knight(twoPlayer));
        setPiece(7, 7, new Rook(twoPlayer));

        for (int i = 0; i < 8; i++) {
            setPiece(i, 6, new Pawn(twoPlayer));
        }

    }

    /**
     * Method set the piece at the coordinations.
     * @param coorX
     * @param coorY
     * @param paramPiece piece will be set
     */
    private void setPiece(int coorX, int coorY, Piece paramPiece) {
        Square squareAt = root.getSquareAt(coorX, coorY);
        squareAt.setPiece(paramPiece);
        ImageView img= new ImageView(squareAt.getPiece().getImg());
        img.setMouseTransparent(true);
        if (squareAt.getPiece() != null)
            root.addImg(img, coorX, coorY);
    }

    /**
     * Method swap the pieces.
     * @param x1 first piece
     * @param y1 first piece
     * @param x2 second piece
     * @param y2 second piece
     */
    public void swapSquare(int x1, int y1, int x2, int y2) {
        Piece temp;
        Square squareAtOne = root.getSquareAt(x1, y1);
        Square squareAtTwo = root.getSquareAt(x2, y2);

        temp = root.getSquareAt(x1, y1).getPiece();
        squareAtOne.setPiece(squareAtTwo.getPiece());
        squareAtTwo.setPiece(temp);

        if (root.getSquareAt(x2, y2).getPiece() != null) {
            root.removeImg(x1, y1);
            ImageView img= new ImageView(squareAtTwo.getPiece().getImg());
            root.addImg(img, x2, y2);
        }

    }
    /**
     * Method checks the path is clear.
     * @param x1 first selection
     * @param y1 first selection
     * @param x2 second selection
     * @param y2 second selection
     * @return boolean
     */
    public Boolean checkClearPath(int x1, int y1, int x2, int y2) {
        if (root.getSquareAt(x1, y1).getPiece().getPathClear()) {
            if (x1 < x2 && y1 == y2) { //east
                for (int i = x1 + 1; i < x2; i++) {
                    if (root.getSquareAt(i, y1).getPiece() != null)
                        return false;
                }
            } else if (x1 > x2 && y1 == y2) { //west
                for (int i = x1 - 1; i > x2; i--) {
                    if (root.getSquareAt(i, y1).getPiece() != null)
                        return false;
                }
            } else if (x1 == x2 && y1 > y2) {
                for (int i = y1 - 1; i > y2; i--) { //north
                    if (root.getSquareAt(x1, i).getPiece() != null)
                        return false;
                }
            } else if (x1 == x2 && y1 < y2) {
                for (int i = y1 + 1; i < y2; i++) { //south
                    if (root.getSquareAt(x1, i).getPiece() != null)
                        return false;
                }
            } else if (x1 > x2 && y1 < y2) { //southwest
                for (int i = x1 - x2; i > 0; i--) {
                    if (root.getSquareAt(x1 - i, y1 + i).getPiece() != null)
                        return false;
                }
            } else if (x1 < x2 && y1 < y2) { //southeast
                for (int i = x2 - x1; i > 0; i--) {
                    if (root.getSquareAt(x1 + i, y1 + i).getPiece() != null)
                        return false;

                }
            } else if (x1 > x2 && y1 > y2) { //northwest
                for (int i = x1 - x2; i > 0; i--) {
                    if (root.getSquareAt(x1 - i, y1 - i).getPiece() != null)
                        return false;

                }
            } else if (x1 < x2 && y1 > y2) { //northeast
                for (int i = x2 - x1; i > 0; i--) {
                    if (root.getSquareAt(x1 + i, y1 - i).getPiece() != null)
                        return false;

                }
            }
        }
        return true;
    }
    /**
     * Method set the board
     * @param newBoard
     */
    public void setBoard(Board newBoard) {
        root = newBoard;
    }
    /**
     * Method get the board
     * @param onePlayer
     */
    public Board getBoard() {
        return root;
    }
    /**
     * Method update the board.
     * @param b
     */
    public void updateBoard(Board board) {
        Square oldSquare;
        Square newSquare;
  
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newSquare = board.getSquareAt(i, j);
                oldSquare = root.getSquareAt(i, j);

                oldSquare.setPiece(newSquare.getPiece());
                newSquare.setOnMousePressed(clickEvent);
                root.add(newSquare, i, j);
                root.removeImg(i, j);
              if (newSquare.getPiece() != null) {
                  ImageView img= new ImageView(newSquare.getPiece().getImg());
                  img.setMouseTransparent(true);
                  root.addImg(img, i, j);
              }

            }
        }
        

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuBar menuBar = new MenuBar();
        SaveMenu miFile = new SaveMenu("File", primaryStage, this);
        menuBar.getMenus().add(miFile);
        VBox root1 = new VBox(menuBar);
        // Show open file dialog

        root1.getChildren().add(root);
        primaryStage.setScene(new Scene(root1, 800, 825));
        primaryStage.show();
    }

    /**
     * Run javaFX
     * @param args
     */
    public static void main(String[] args) {
        launch();

    }

}
