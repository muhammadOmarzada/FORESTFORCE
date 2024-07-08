package fxml_helloworld;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLDocumentController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    @FXML
    private TextField tf;

    @FXML
    private PasswordField pw;

    @FXML
    private Button loginBt;

    @FXML
    private Button regBt;

    @FXML
    private Label lb;

    @FXML
    private void loginBT(ActionEvent event) throws IOException{
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.processAnnotations(dataUser.class);

        FileReader reader = new FileReader("dataUser.xml");
        dataUser myData = (dataUser) xstream.fromXML(reader);

        if(tf.getText().equals(myData.getUsername()) && pw.getText().equals(myData.getPassword())){
            root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
        } else {
            error();
        }
    }

    @FXML
    private void regBT(ActionEvent event) throws IOException{
            root = FXMLLoader.load(getClass().getResource("registerDocument.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    public void error(){
        lb.setText("PASSWORD SALAH, ULANGI LAGI!");
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
