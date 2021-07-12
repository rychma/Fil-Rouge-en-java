package org.example.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FilRougeDB {

    //final car ce sont des constantes, donc nom en MAJUSCULES
    private final String URL_FILROUGE = "jdbc:mysql://localhost:3306/filrouge";
    private final String USER_FILROUGE = "root";
    private final String PASSWORD_FILROUGE = "";
    //Objet Connection dont je vais avoir besoin dans ma fonction de connexion
    public Connection con;



    //Fonction qui retourne une connexion a ma bdd
    public  Connection getCon() throws SQLException {
        //Je fais ma co avec les valeurs de mes constantes (pratique car si je change le mdp, je ne dois le modifier qu'ici, et plus un peu partout a chaque co...)
        con = DriverManager.getConnection(URL_FILROUGE, USER_FILROUGE, PASSWORD_FILROUGE);
        //Je renvoie cette connexion
        return con;
    }
}
