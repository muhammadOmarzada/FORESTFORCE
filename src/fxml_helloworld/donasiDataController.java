package fxml_helloworld;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class donasiDataController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList data = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox cb;

    private String[] bank = {"BCA","BNI","BRI","BTN","Mandiri","CIMB","BSI","Danamon","OCBC","BTPN"};
    
    @FXML
    private TextField tfNama;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfKontak;

    @FXML
    private TextField tfNominal;

    @FXML
    private Button bt;

    @FXML
    private Button btHapus;

    @FXML
    private Button btBack;

    @FXML
    private TableView tv;

    @FXML
    private TableColumn tcNama;

    @FXML
    private TableColumn tcEmail;

    @FXML
    private TableColumn tcKontak;

    @FXML
    private TableColumn tcNominal;

    @FXML
    private TableColumn tcBank;

    
    @FXML
    private void handleButtonAction(ActionEvent event){
        if (tfNama.getText().isEmpty() || tfEmail.getText().isEmpty() || tfKontak.getText().isEmpty() || tfNominal.getText().isEmpty()){

        } else {
        data.add(new profilClass(tfNama.getText(), tfEmail.getText(), tfKontak.getText(), tfNominal.getText(), (String) cb.getValue()));
        tfNama.clear();
        tfEmail.clear();
        tfKontak.clear();
        tfNominal.clear();
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(data);
        FileOutputStream coba = null;
        try {
            coba = new FileOutputStream("dataDonatur.xml");
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
        }
    }

    @FXML
    private void hapusBT (ActionEvent event) throws FileNotFoundException{
        try {
            int i = 0;
            int j = data.size();
            data.remove(i);
            i++;
            if (data.size() < j){
                XStream xstream = new XStream(new StaxDriver());
                String xml = xstream.toXML(data);
                FileOutputStream coba = null;
                try {
                    coba = new FileOutputStream("dataDonatur.xml");
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

            }
        } catch (Exception e){
            System.out.println("index kosong");
        }

    }

    @FXML
    private void backBT (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcNama.setCellValueFactory(new PropertyValueFactory<profilClass, String>("nama"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<profilClass, String>("email"));
        tcKontak.setCellValueFactory(new PropertyValueFactory<profilClass, String>("kontak"));
        tcNominal.setCellValueFactory(new PropertyValueFactory<profilClass, String>("nominal"));
        tcBank.setCellValueFactory(new PropertyValueFactory<profilClass, String>("bank"));
        tv.setItems(data);
        cb.getItems().addAll(bank);
    }    
    
}
