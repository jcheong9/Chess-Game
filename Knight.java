
public class Knight extends Piece {
    /**
     * pathClear stores the false the piece can not jump
     */
    private Boolean pathClear;
    /**
     * img stores the ImageView
     */
//    private ImageView img;
    /**
     * Constructor instantiate the piece
     * @param paramPlayer
     */
    public Knight(Player paramPlayer) {
        super(paramPlayer, "Kn", "Chess_ndt60.png", "Chess_nlt60.png");
        pathClear = false;

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
 
        return diffX == 1 && diffY == 2 || diffX == 2 && diffY == 1;

    }
    /**
     * Method get the pathClear
     */
    public Boolean getPathClear() {
        return pathClear;
    }


}
