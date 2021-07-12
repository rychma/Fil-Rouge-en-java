package org.example.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import org.example.App;

import java.io.IOException;

public class AccueilController {

    public TextField search;

    public void goCatalogue(ActionEvent actionEvent) {
    }

    public void goAddArticle(ActionEvent actionEvent) {
    }

    public void goUpdateArticle(ActionEvent actionEvent) {
    }

    public void disconnect(ActionEvent actionEvent) {
    }

    public void goListClient(ActionEvent actionEvent) throws IOException {

    //    try {
            //Redirection vers la page de recherche d'un client

            Parent root = FXMLLoader.load(getClass().getResource("RechercheClient.fxml"));
            Scene scene = new Scene(root);
            App.mainStage.setScene(scene);

            System.out.println("tout a bien marche");
            //Si erreur sur la  redirection, je préciens l'utilisateur que sa connexion a reussi, mais pas la redirection
      //  } catch (IOException e) {
        //    System.out.println("La connexion a reussi, mais le chargement de la page d'accueil a echoue.");
      //  }


    }

    public void goFicheClient(ActionEvent actionEvent) {
    }
}
