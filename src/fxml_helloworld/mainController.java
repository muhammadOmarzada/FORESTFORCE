package fxml_helloworld;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class mainController implements Initializable {

    @FXML
    private BorderPane mainPane;


    @FXML
    private Button donasiBT;

    @FXML
    private Button informasiBT;


    @FXML
    private Button perkembanganBT;

    @FXML
    private Button komunitasBT;

    @FXML
    private void handleInformasi(ActionEvent event) throws IOException {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("informasiPage.fxml");
        mainPane.setCenter(halaman);
    }

    
    @FXML
    private void handleDonasi(ActionEvent event) throws IOException {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("donasiPage.fxml");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void handlePerkembangan(ActionEvent event) throws IOException {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("perkembanganPage.fxml");
        mainPane.setCenter(halaman);

    }

    @FXML
    private void handleKomunitas(ActionEvent event) throws IOException {
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("komunitasPage.fxml");
        mainPane.setCenter(halaman);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
