
public class King extends Piece {
    /**
     * img stores the ImageView
     */
//    private ImageView img;
    /**
     * Constructor instantiate the piece
     * @param paramPlayer
     */
    public King(Player paramPlayer) {
        super(paramPlayer, "K", "Chess_kdt60.png", "Chess_klt60.png");

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
    
       return diffX == 1 && diffY == 1 
               || diffY == 1 && diffX == 0 || diffX == 1 && diffY == 0;


    }



}
