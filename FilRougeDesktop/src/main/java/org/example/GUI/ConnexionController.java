package org.example.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.App;
import org.example.DAL.Employe;
import org.example.DAL.EmployeDAO;

import java.io.IOException;

public class ConnexionController {


    public TextField mail;
    public PasswordField password;
    public CheckBox saveConnexion;

    public void connexion(ActionEvent actionEvent) {
        //Je recupere le texte entré par l'utilisateur
        String login = mail.getText();
        String mdp = password.getText();
        //Si ma fonction de connexion du dao renvoie true, alors je redirige vers la page d'accueil
        if(EmployeDAO.connexion(login, mdp)){
            try {
                //Redirection

                Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
                Scene scene = new Scene(root);
                App.mainStage.setScene(scene);

                System.out.println("tout a bien marche");
                //Si erreur sur la  redirection, je préciens l'utilisateur que sa connexion a reussi, mais pas la redirection
            } catch (IOException e) {
                System.out.println("La connexion a reussi, mais le chargement de la page d'accueil a echoue.");
            }

        }else {
            System.out.println("mot de passe incorrect");
        }

    }

    public void resetPassword(ActionEvent actionEvent) {

    }
}
