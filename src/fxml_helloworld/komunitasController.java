package fxml_helloworld;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class komunitasController implements Initializable {
    
    @FXML
    private TextField tf;

    @FXML
    private TextArea ta;

    @FXML
    private Button bt;
    
    @FXML
    private void handleBT(ActionEvent event){
        ta.setText(tf.getText());
        tf.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
