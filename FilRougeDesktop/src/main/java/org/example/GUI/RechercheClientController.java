package org.example.GUI;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAL.Client;
import org.example.DAL.ClientDAO;

import java.sql.SQLException;

public class RechercheClientController {
    public TextField search;
    public TableView<Client> tab_cli;
    public Button btn_add_cli;
    public Button btn_update_cli;
    public Button btn_delete_cli;
    public Label lbl_title;
    public Button btn_quitter;
    public TableColumn<Client, Integer> col_id_cli;
    public TableColumn<Client, String> col_ref;
    public TableColumn<Client, String> col_nom;
    public TableColumn<Client, String> col_prenom;
    public TableColumn<Client, Integer> col_coef;
    public TableColumn<Client, Integer> col_type;
    public TableColumn<Client, String> col_email;
    public TableColumn<Client, String> col_mdp;
    public TableColumn<Client, Integer> col_point;
    public TableColumn<Client, Integer> col_id_com;
    public TextField txt_id;
    public TextField txt_ref_cli;
    public TextField txt_nom;
    public TextField txt_type;
    public TextField txt_email;
    public TextField txt_mdp;
    public TextField txt_prenom;
    public TextField txt_point;
    public TextField txt_id_com;
    public TextField txt_coef;
    private Client actuelClient = new Client(0, "", "", "", 0, 0, "", "", 0, 0);


    public void initialize() throws SQLException {

        tab_cli.setEditable(false);

        col_id_cli.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_ref.setCellValueFactory(new PropertyValueFactory<>("ref_client"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_coef.setCellValueFactory(new PropertyValueFactory<>("coef_reduc"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type_client"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("adresse_mail"));
        col_mdp.setCellValueFactory(new PropertyValueFactory<>("password"));
        col_point.setCellValueFactory(new PropertyValueFactory<>("nombre_points"));
        col_id_com.setCellValueFactory(new PropertyValueFactory<>("id_commercial_attribue"));

        tab_cli.setItems(ClientDAO.Toutelaliste());

        tab_cli.getSelectionModel().selectedItemProperty().addListener(evt -> {
            actuelClient = (Client) tab_cli.getSelectionModel().getSelectedItem();
            //System.out.println(actuelClient.getId());

            txt_ref_cli.setText(actuelClient.getRef_client());
            txt_nom.setText(actuelClient.getNom());
            txt_prenom.setText(actuelClient.getPrenom());
            txt_coef.setText(String.valueOf(actuelClient.getCoef_reduc()));
            txt_type.setText(String.valueOf(actuelClient.getType_client()));
            txt_email.setText(actuelClient.getAdresse_mail());
            txt_mdp.setText(actuelClient.getPassword());
            txt_point.setText(String.valueOf(actuelClient.getNombre_points()));
            txt_id_com.setText(String.valueOf(actuelClient.getId_commercial_attribue()));

        });

    }

    public void btn_add_cli_click(ActionEvent actionEvent) throws SQLException {

        String refclient = txt_ref_cli.getText();
        String nomclient = txt_nom.getText();
        String prenomclient = txt_prenom.getText();
        String emailclient = txt_email.getText();
        String motdepasse = txt_mdp.getText();

        int coefclient = Integer.parseInt(txt_coef.getText());
        int typeclient = Integer.parseInt(txt_type.getText());
        int pointclient = Integer.parseInt(txt_point.getText());
        int idcommercial = Integer.parseInt(txt_id_com.getText());

        System.out.println("ref" + refclient);
        System.out.println("coef" + coefclient);
        System.out.println("type" + typeclient);
        System.out.println("point" + pointclient);
        System.out.println("com" + idcommercial);
        System.out.println("nom" + nomclient);
        System.out.println("pre" + prenomclient);
        System.out.println("mail" + emailclient);
        System.out.println("mdp" + motdepasse);

        if (refclient.equals("") || coefclient == 0 || typeclient == 0 || pointclient == 0 || idcommercial == 0 || nomclient.equals("") || prenomclient.equals("") || emailclient.equals("") || motdepasse.equals("")) {
            System.out.println("erreur1");
            System.out.println("mauvaise condition d'acces");
        } else {
            try {
                // Sinon,passe à l'étape suivante de la condition en appelant le clientDAO avec les valeurs obtenues dans les champs text
                // Ce dernier client viendra s'ajouter à la liste des autres clients déjà présents dans la liste Tableview
                // Après son insertion, on reinitialise les champs enfin de pouvoir passer à une autre insertion
                ClientDAO.btn_add_cli(refclient, prenomclient, nomclient, coefclient, typeclient, emailclient, motdepasse, pointclient, idcommercial);
                tab_cli.setItems(ClientDAO.Toutelaliste());

                txt_ref_cli.clear();
                txt_nom.clear();
                txt_prenom.clear();
                txt_coef.clear();
                txt_type.clear();
                txt_email.clear();
                txt_mdp.clear();
                txt_point.clear();
                txt_id_com.clear();

                System.out.println("ça marche");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur de requete iinsert client");
            }
        }

    }

    public void btn_quitter_click(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void btn_delete_cli_click(ActionEvent actionEvent) throws SQLException {
        // recupération de la valeur du membre id de l'objet actuelclient ( correspondant au dernier client selectionné)
        int actuelId = actuelClient.getId();
        if (actuelId != 0) {
            ClientDAO.btn_delete_cli(actuelId);
            tab_cli.setItems(ClientDAO.Toutelaliste());

            txt_ref_cli.clear();
            txt_nom.clear();
            txt_prenom.clear();
            txt_type.clear();
            txt_coef.clear();
            txt_email.clear();
            txt_mdp.clear();
            txt_point.clear();
            txt_id_com.clear();

            //System.out.println(actuelId);
           // System.out.println("pas moyen de supprimer le client");
        } else {
            System.out.println(actuelId);
            System.out.println("pas moyen de supprimer le client");
        }
    }

    public void btn_update_cli_click(ActionEvent actionEvent) throws SQLException {
        // recupération de la valeur du membre cli_id de l'objet actuelclient ( correspondant au dernier client selectionné)
        int actuelId = actuelClient.getId();
        if (actuelId != 0) {
            String actuelrefcli = txt_ref_cli.getText();
            String actuelnom = txt_nom.getText();
            String actuelprenom = txt_prenom.getText();
            int actueltype = Integer.valueOf(txt_type.getText());
            int actuelcoef = Integer.valueOf(txt_coef.getText());
            String actuelemail = txt_email.getText();
            String actuelmotdepasse = txt_mdp.getText();
            int actuelpoint = Integer.valueOf(txt_point.getText());
            int actuelidcom = Integer.valueOf(txt_id_com.getText());

            ClientDAO.btn_update_cli_click(actuelId, actuelrefcli, actuelnom, actuelprenom, actuelcoef, actueltype, actuelemail, actuelmotdepasse, actuelpoint, actuelidcom);
            tab_cli.setItems(ClientDAO.Toutelaliste());

            txt_id.clear();
            txt_ref_cli.clear();
            txt_nom.clear();
            txt_prenom.clear();
            txt_type.clear();
            txt_coef.clear();
            txt_email.clear();
            txt_mdp.clear();
            txt_point.clear();
            txt_id_com.clear();
        } else {
            System.out.println("impossible de modifier le client");
            }
    }
    }