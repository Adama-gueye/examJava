package com.exam_java.exam_java;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeController implements Initializable {

    DBConnexion db = new DBConnexion();
    IEmploye iEmploye = new EmployeImpl();
    IDepartement iDepartement = new DepartementImpl();
    @FXML
    private Button btnEnregistrer;

    @FXML
    private Button btngenereEmail;

    @FXML
    private ComboBox<Departement> cbbDepartement;

    @FXML
    private TableColumn<Employe, Departement> departement;

    @FXML
    private TableColumn<Employe, String> email;

    @FXML
    private TableColumn<Employe, Integer> id;

    @FXML
    private TableColumn<Employe, String> nom;

    @FXML
    private TableColumn<Employe, String> prenom;

    @FXML
    private TableView<Employe> tabEmploye;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrenom;

    @FXML
    void genereEmail(ActionEvent event) {

        String adresseEmail = txtNom.toString();
        txtEmail.setText(adresseEmail);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtEmail.setDisable(true);
        id.setCellValueFactory(new PropertyValueFactory<>("idE"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nomE"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenomE"));
        email.setCellValueFactory(new PropertyValueFactory<>("emailE"));
        departement.setCellValueFactory(new PropertyValueFactory<>("dept"));
        loadDept();
        load();
    }
    public void loadDept(){
        ObservableList<Departement> departements = FXCollections.observableArrayList();
        List<Departement> classeList = iDepartement.getAll();
        for (Departement d: classeList){
            departements.add(d);
        }
        cbbDepartement.setItems(departements);
    }
    @FXML
    void getData(MouseEvent event) {

        Employe p = tabEmploye.getSelectionModel().getSelectedItem();
       // id.setText(p.getIdE());
        txtNom.setText(p.getNomE());
        txtPrenom.setText(p.getPrenomE());
        txtEmail.setText(p.getEmailE());
        cbbDepartement.setValue(p.getDept());

    }


    @FXML
    void save(ActionEvent event) {

        String sql = "INSERT INTO employe VALUES (NULL, ?,?,?,?)";
        if (!txtNom.getText().equals("") && !txtEmail.getText().equals("") && !txtPrenom.getText().equals("") && !cbbDepartement.getValue().equals("")) {
            try {
                db.initPrepar(sql);
                db.getPstm().setString(1, txtNom.getText());
                db.getPstm().setString(2, txtPrenom.getText());
                db.getPstm().setString(3, txtEmail.getText());
                db.getPstm().setInt(4, cbbDepartement.getValue().getIdD());
                db.executeMaj();
                db.closeConnection();
                Notification.NotifSuccess("Success", "Produit ajouté avec succes!");
                load();
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }else {
            Notification.NotifError("Error","Champ Obligatoire!");
        }
    }

    public void load(){
        ObservableList<Employe> employes = FXCollections.observableArrayList();
        List<Employe> produitList = iEmploye.getAll();
        for (Employe e: produitList){
            employes.add(e);
        }
        tabEmploye.setItems(employes);
    }


}
