import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ClickEvent implements EventHandler<MouseEvent> {
    /**
     * x1 stores the x values of first selection
     */
    private int x1;
    /**
     * y1 stores the y values of first selection
     */
    private int y1;
    /**
     * x2 stores the x values of first selection
     */
    private int x2;
    /**
     * y2 stores the y values of first selection
     */
    private int y2;
    /**
     * selectedPiece stores Piece
     */
    private Piece selectedPiece = null;
    /**
     * playerColor stores selected player Color
     */
    private String playerColor;
    /**
     * playerFirst stores the player first
     */
    private String lastWent;
    /**
     * gui stores the GUI object
     */
    private GUI gui;

    /**
     * Constructor initialized the gui.
     * 
     * @param gui
     */
    public ClickEvent(GUI gui) {
        this.gui = gui;
        lastWent = gui.getBoard().getTurn();
    }

    /**
     * Method handle the click event
     */
    @Override
    public void handle(MouseEvent click) {
        Square selectSquare = (Square) click.getSource();
  
        // checks the first selection there is a piece
        if (selectSquare.getPiece() != null) {
            selectedPiece = selectSquare.getPiece();
            playerColor = selectSquare.getPiece().getOwner().getPlayerColor();
            x1 = selectSquare.getRow();
            y1 = selectSquare.getCol();
        }
        
        // tracks the last selected piece
        lastWent = gui.getBoard().getTurn();

        // check selection selection meet the criteria
        if (selectedPiece != null && selectSquare.getPiece()
                == null && playerColor != lastWent) {
            x2 = selectSquare.getRow();
            y2 = selectSquare.getCol();

            if (selectedPiece.moveValid(x1, y1, x2, y2) 
                    && gui.checkClearPath(x1, y1, x2, y2)) {
                lastWent = selectedPiece.getOwner().getPlayerColor();
                gui.getBoard().setTurn(lastWent);
                gui.swapSquare(x1, y1, x2, y2);
                x1 = y1 = x2 = y2 = 0;
                selectedPiece = null;
            }
        }
    }
}
