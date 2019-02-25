import javafx.scene.image.ImageView;

public class Queen extends Piece {
    /**
     * img stores the ImageView
     */
//    private ImageView img;
    /**
     * Constructor instantiate the piece
     * @param paramPlayer
     */
    public Queen(Player paramPlayer) {
        super(paramPlayer, "Q", "Chess_qdt60.png", "Chess_qlt60.png");

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
        
        if(diffX == diffY) {
            return true;
        }
        
        if (y1 == y2 || x1 == x2) {
            return true;
        }
        return false;
    }
    


}
