import javafx.scene.image.ImageView;
import java.awt.Color;

public class Rook extends Piece {
    /**
     * img stores the ImageView
     */
//    private ImageView img;
    /**
     * Constructor instantiate the piece
     * @param paramPlayer
     */
    public Rook(Player paramPlayer) {
        super(paramPlayer, "R", "Chess_rdt60.png", "Chess_rlt60.png");
    }
    /**
     * Method get the image
     */
//    public ImageView getImg() {
//        return img;
//    }
    @Override
    public Boolean moveValid(int x1, int y1, int x2, int y2) {

        if (y1 == y2 || x1 == x2) {
            return true;
        }

        return false;
    }

}
