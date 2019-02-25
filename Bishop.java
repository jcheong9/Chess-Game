
public class Bishop extends Piece {
    /**
     * img stores the ImageView
     */
//    private ImageView img;
    /**
     * Constructor instantiate the piece
     * @param paramPlayer
     */
    public Bishop(Player paramPlayer) {
        super(paramPlayer, "B", "Chess_bdt60.png", "Chess_blt60.png");

    }
    /**
     * Method get the image
     */
//    public ImageView getImg() {
//        return img;
//    }
    @Override
    public Boolean moveValid(int x1, int y1, int x2, int y2) {
        int diffX = Math.abs(x1 - x2);
        int diffY = Math.abs(y1 - y2);

        return diffX == diffY;
 
    }

}
