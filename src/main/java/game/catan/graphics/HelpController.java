package game.catan.graphics;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class HelpController {

    private double xoffSet = 0;
    private double yoffSet = 0;

    @FXML
    void mousePressed(MouseEvent event) {
        xoffSet = event.getSceneX ();
        yoffSet = event.getSceneY ();
    }

    @FXML
    void mouseReleased(MouseEvent event) {
        HelloApplication.helpStage.setOpacity (1.0f);
    }

    @FXML
    void mouseDragged(MouseEvent event) {
        HelloApplication.helpStage.setX(event.getScreenX ()- xoffSet);
        HelloApplication.helpStage.setY (event.getScreenY ()- yoffSet);
        HelloApplication.helpStage.setOpacity (0.8f);
    }

    @FXML
    void onDragDone(MouseEvent event) {
        HelloApplication.helpStage.setOpacity (1.0f);
    }

    @FXML //for top menu x button
    void closeClicked(MouseEvent event) {
        System.out.println("close clicked");
        HelloApplication.helpStage.hide();
    }

    @FXML //for top menu minimize button
    void minimizeClicked(MouseEvent event) {
        HelloApplication.helpStage.setIconified(true);
    }

    @FXML
    void download(ActionEvent event) throws URISyntaxException, IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.setInitialFileName("instructions.pdf");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
        String fileLocationPath = fileChooser.showSaveDialog(HelloApplication.helpStage).getAbsolutePath();
        File fileLocation = new File(HelpController.class.getClassLoader().getResource("game/catan/HelpMenu/instructions.pdf").toURI());
        File fileLocation1 = new File(fileLocationPath);
        FileUtils.copyFile(fileLocation, fileLocation1);
    }
}