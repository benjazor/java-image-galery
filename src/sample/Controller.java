package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {

    @FXML
    protected TilePane imgGalery;

    @FXML
    public void close() {
        Platform.exit();
    }

    @FXML protected void openPicture(ActionEvent event) {
        // Initialisation de la fenêtre de séléection de fichiers
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");

        // Défini un filtre sur les fichier qu'on veut récupérer (seulement des images)
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG image files (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG image files (*.jpg)", "*.jpg");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        // Ouvre la fenêtre pour choisir une image
        File imgFile = fileChooser.showOpenDialog(new Stage());

        try {
            VBox imgBox = new VBox();
            imgBox.alignmentProperty().setValue(Pos.CENTER);
            imgBox.paddingProperty().setValue(new Insets(10, 5, 10, 5));

            ImageView imgView = new ImageView();
            Image image = new Image(new FileInputStream(imgFile));
            imgView.setImage(image);
            imgView.setFitHeight(100);
            imgView.setPreserveRatio(true);
            imgView.setSmooth(true);
            imgView.setCache(true);

            Label imgText = new Label(imgFile.getName().length() > 15 ? imgFile.getName().substring(0, imgFile.getName().length()-4).substring(0, 15) + "..." : imgFile.getName().substring(0, imgFile.getName().length()-4));

            imgBox.getChildren().add(imgView);
            imgBox.getChildren().add(imgText);
            imgGalery.getChildren().addAll(imgBox);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void createNewImage(ActionEvent event){

    }

}
