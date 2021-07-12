package org.example.GUI;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.DAL.ClientDAO;

public class AjoutClientController {
    public Button btn_add_cli;
    public Button btn_update_cli;
    public Button btn_delete_cli;
    public Button btn_quitter;
    public Label lbl_title;
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

    public void btn_add_cli_click(ActionEvent actionEvent)  {
        String refclient = txt_ref_cli.getText();
        String nomclient = txt_nom.getText();
        String prenomclient = txt_prenom.getText();
        String emailclient = txt_email.getText();
        String motdepasse = txt_mdp.getText();

        int coefclient = Integer.parseInt(txt_coef.getText());
        int typeclient = Integer.parseInt(txt_type.getText());
        int pointclient = Integer.parseInt(txt_point.getText());
        int idcommercial = Integer.parseInt(txt_id_com.getText());


        if (refclient.equals("") || coefclient == 0 || typeclient == 0 || pointclient == 0 || idcommercial == 0 || nomclient.equals("") || prenomclient.equals("") || emailclient.equals("") || motdepasse.equals("")) {
            System.out.println("erreur1");
            System.out.println("mauvaise condition d'acces");
        } else {
            // Sinon,passe à l'étape suivante de la condition en appelant le clientDAO avec les valeurs obtenues dans les champs text
            // Ce dernier client viendra s'ajouter à la liste des autres clients déjà présents dans la liste Tableview
            // Après son insertion, on reinitialise les champs enfin de pouvoir passer à une autre insertion
            ClientDAO.btn_add_cli(refclient, prenomclient, nomclient, coefclient, typeclient, emailclient, motdepasse, pointclient, idcommercial);
            //tab_cli.setItems(ClientDAO.Toutelaliste());

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
        }
    }

    public void btn_update_cli_click(ActionEvent actionEvent) {
    }

    public void btn_delete_cli_click(ActionEvent actionEvent) {
    }

    public void btn_quitter_click(ActionEvent actionEvent) {
        System.exit(0);
    }
}
