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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class perkembanganController implements Initializable {

    ObservableList data = FXCollections.observableArrayList();


    @FXML
    private Button btTambah;

    @FXML
    private Button btHapus;

    @FXML
    private TextField tfProyek;

    @FXML
    private TextField tfProgress;

    @FXML
    private TextField tfMasalah;
    

    @FXML
    private TableView tv;

    @FXML
    private TableColumn tcProyek;

    @FXML
    private TableColumn tcProgress;

    @FXML
    private TableColumn tcMasalah;

    
    @FXML
    private void handleTambah(ActionEvent event) throws FileNotFoundException{
        if (tfProyek.getText().isEmpty() || tfProgress.getText().isEmpty() || tfMasalah.getText().isEmpty()){

        } else {
        data.add(new proyekClass(tfProyek.getText(), tfProgress.getText(), tfMasalah.getText()));
        tfProyek.clear();
        tfProgress.clear();
        tfMasalah.clear();
        XStream xstream = new XStream(new StaxDriver());
        String xml = xstream.toXML(data);
        FileOutputStream coba = null;
        try {
            coba = new FileOutputStream("dataProyek.xml");
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
    private void handleHapus(ActionEvent event){
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
                    coba = new FileOutputStream("dataProyek.xml");
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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcProyek.setCellValueFactory(new PropertyValueFactory<profilClass, String>("proyek"));
        tcProgress.setCellValueFactory(new PropertyValueFactory<profilClass, String>("progress"));
        tcMasalah.setCellValueFactory(new PropertyValueFactory<profilClass, String>("masalah"));
        tv.setItems(data);
    }    
    
}
