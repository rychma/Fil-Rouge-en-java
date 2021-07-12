package org.example.DAL;

import javax.swing.plaf.nimbus.State;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeDAO {
    static FilRougeDB filRougeDB = new FilRougeDB();
    //Fonction de connexion
    public static boolean connexion(String login, String password) {
        //Booléen qui dira si les mot de passes correspondent
        boolean validConnexion = false;
        try {
            //Requete sql pour récupérer les valeurs en base de données correspondantes au login
            PreparedStatement selectEmployee = filRougeDB.getCon().prepareStatement("SELECT * FROM `employe` WHERE `login` = ?");
            //J'assigne la valeur de login au ?
            selectEmployee.setString(1, login);
            //Je récupere le resultat de ma requete
            ResultSet result = selectEmployee.executeQuery();
            //Je selectionne le "premier"(normalement le seul) resultat
            if (result.next()){
                System.out.println("ok");
            }else {
                System.out.println("pas ok");
            }
                    //Si les password correspondent, je met mon booleen a true
            if (password.equals(result.getString("password"))){
                System.out.println(result.getString("password"));
                validConnexion = true;
            }else {
                System.out.println("Loupé");
                System.out.println(result.getString("password"));
                System.out.println(password);
            }
            //Je ferme la connexion
            selectEmployee.close();
        } catch (SQLException throwables) {
            //Message pour identifier une erreur de co a la bdd
            System.out.println("Erreur de connexion a la bdd");
        }
        //Je renvoie le booleen
        return validConnexion;
    }

}
