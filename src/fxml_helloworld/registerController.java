package fxml_helloworld;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registerController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label label;
    
    @FXML
    private Button daftarButton;

    @FXML
    private Button kembaliButton;

    @FXML
    private TextField usnTextField;

    @FXML
    private TextField pwTextField;
    
    @FXML
    private void kembaliButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void daftarButton(ActionEvent event){
        if (usnTextField.getText().isEmpty() || pwTextField.getText().isEmpty()){
        label.setText("USERNAME DAN PASSWORD TIDAK VALID!");
        } else {
        dataUser data = new dataUser();
        data.setUsername(usnTextField.getText());
        data.setPassword(pwTextField.getText());
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(data);
        FileOutputStream coba = null;
        try {
            coba = new FileOutputStream("dataUser.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            coba.write(bytes);
        } catch (Exception e) {
            System.err.println("Perhatian: " + e.getMessage());
        } finally {
            if (coba != null) {
                try {
                    coba.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        label.setText("REGISTRASI BERHASIL, SILAHKAN KEMBALI");
        }
        

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
