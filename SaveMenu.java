import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class SaveMenu extends Menu{

    /**
     * Constructor creates the menu file.
     * @param str
     * @param primaryStage
     * @param gui
     */
    public SaveMenu(String str, Stage primaryStage, GUI gui) {
        super(str);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("TEXT files (*.ser)", "*.ser");
        fileChooser.getExtensionFilters().add(extFilter);
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem openMenuItem = new MenuItem("Open");
        
        this.getItems().add(saveMenuItem);
        this.getItems().add(openMenuItem);

        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                File selectedFile = fileChooser.showSaveDialog(primaryStage);
                
                String outputPath;
                if (selectedFile != null) {
                    outputPath = selectedFile.getPath();
                    try {
                        writeToFile(gui.getBoard(), outputPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        
        openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                File chosenFile = fileChooser.showOpenDialog(primaryStage);
                String path;
                if(chosenFile != null) {
                    path = chosenFile.getPath();
                    try {
                        readFile(gui,path);
                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    //default return value
                    path = null;
                }

            }
        });
    }
    /**
     * Method writes the serialize file
     * @param b
     * @param fileName
     * @throws IOException
     */
    public static void writeToFile(Board b, String fileName) throws IOException{

        ObjectOutputStream out1 = new ObjectOutputStream(
                new FileOutputStream(fileName));
        
        out1.writeObject(b);
        out1.flush();
        out1.close();
        System.out.println("File Saved");
    }
    /**
     * Method read serialize file.
     * @param gui
     * @param fileName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readFile(GUI gui,String fileName) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName));
        Board board = (Board) in.readObject();
        in.close();

        System.out.println("turns state "+board.getTurn());
        gui.getBoard().setTurn(board.getTurn());
        gui.updateBoard(board);
        System.out.println("File Loaded");
    }

}
