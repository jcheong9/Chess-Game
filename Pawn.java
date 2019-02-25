
public class Pawn extends Piece {
    /**
     * startFirst stores the boolean
     */
    private boolean startFirst = true;

    /**
     * Constructor instantiate the piece
     * 
     * @param paramPlayer
     */

    public Pawn(Player paramPlayer) {
        super(paramPlayer, "P", "Chess_pdt60.png", "Chess_plt60.png");

    }

    @Override
    public Boolean moveValid(int x1, int y1, int x2, int y2) {

        if (y1 == 6 || y1 == 1) {
            if (super.getOwner().getPlayerColor().equals("Black")) {
                return (y1 - y2) == 1 && (x1 - x2) == 0 
                        || (y1 - y2) == 2 && (x1 - x2) == 0;
            } else {
            return (y1 - y2) == -1 && (x1 - x2) == 0
                    || (y1 - y2) == -2 && (x1 - x2) == 0;
            }
        }

        startFirst = false;
        if (super.getOwner().getPlayerColor().equals("Black")) {
            return (y1 - y2) == 1 && (x1 - x2) == 0;
        } else {
            return (y1 - y2) == -1 && (x1 - x2) == 0;
        }
    }
}
