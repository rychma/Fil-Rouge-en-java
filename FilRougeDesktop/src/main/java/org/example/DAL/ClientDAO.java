package org.example.DAL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {

    public static FilRougeDB filRougeDB = new FilRougeDB();

    public static ObservableList<Client> Toutelaliste() throws SQLException {

        ObservableList<Client> listeclient = FXCollections.observableArrayList();

        PreparedStatement stm = filRougeDB.getCon().prepareStatement("SELECT * FROM `client`");

        ResultSet result = stm.executeQuery();
        while (result.next()) {
            // pour chaque nouveau client, on lui affecte la ligne avec tous les attributs
            Client nouveauclient = new Client(result.getInt("id"), result.getString("ref_client"), result.getString("nom"), result.getString("prenom"),result.getInt("coef_reduc"),result.getInt("type_client"),result.getString("adresse_mail"),result.getString("password"),result.getInt("nombre_points"),result.getInt("id_commercial_attribue"));
            listeclient.add(nouveauclient);
        }
        stm.close();
        result.close();
        return listeclient;
    }

   public static void btn_add_cli(String refcli,String ncli, String precli, int coefcli,int typecli,String emailcli,String mdpcli,int pointscli,int idcom ) {

        try {
            PreparedStatement stm = filRougeDB.getCon().prepareStatement("insert into filrouge.client( filrouge.client.ref_client, filrouge.client.nom, filrouge.client.prenom, filrouge.client.coef_reduc, filrouge.client.type_client, filrouge.client.adresse_mail, filrouge.client.password, filrouge.client.nombre_points, filrouge.client.id_commercial_attribue) values (?,?,?,?,?,?,?,?,?)");

            stm.setString(1, refcli);
            stm.setString(2, ncli);
            stm.setString(3, precli);
            stm.setInt(4, coefcli);
            stm.setInt(5, typecli);
            stm.setString(6, emailcli);
            stm.setString(7, mdpcli);
            stm.setInt(8, pointscli);
            stm.setInt(9, idcom);

            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void btn_delete_cli(int id) {
        try {
            PreparedStatement stm = filRougeDB.getCon().prepareStatement("DELETE FROM `client` WHERE `id`=?");
            stm.setInt(1, id);
            stm.executeUpdate();
            stm.close();
            System.out.println("ok");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("erreur");
        }
}
    public static void btn_update_cli_click(int id,String ref,String n,String p,int coef,int type,String mail, String mdp,int point,int idcom) {
        try {
            PreparedStatement stm = filRougeDB.getCon().prepareStatement("UPDATE `client` SET `ref_client`=?,`nom`=?,`prenom`=?,`coef_reduc`=?,`type_client`=?,`adresse_mail`=?,`password`=?,`nombre_points`=?,`id_commercial_attribue`=? WHERE `id`=?");

            stm.setString(1, ref);
            stm.setString(2,n );
            stm.setString(3, p);
            stm.setInt(4, coef);
            stm.setInt(5, type);
            stm.setString(6, mail);
            stm.setString(7, mdp);
            stm.setInt(8, point);
            stm.setInt(9, idcom);
            stm.setInt(10, id);

            stm.executeUpdate();
            stm.close();
            System.out.println("bien");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("dehors");
        }
    }
}






