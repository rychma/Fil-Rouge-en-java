package org.example.DAL;

public class Client {
    int id;
    String ref_client;
    String nom;
    String prenom;
    int coef_reduc;
    int type_client;
    String adresse_mail;
    String password;
    int nombre_points;
    int id_commercial_attribue;
    // Constructeur avec les 10 paramètres
    public  Client(int id, String ref_client, String nom, String prenom, int coef_reduc, int type_client, String adresse_mail, String password, int nombre_points, int id_commercial_attribue) {
                      this.id = id;
                      this.ref_client = ref_client;
                      this.nom = nom;
                      this.prenom =prenom;
                      this.coef_reduc = coef_reduc;
                      this.type_client = type_client;
                      this.adresse_mail = adresse_mail;
                      this.password = password;
                      this.nombre_points =nombre_points;
                      this.id_commercial_attribue =id_commercial_attribue;
    }

    public Client(int id) {
        id = id;

    }

    public Client(String ref_client,String nom,String prenom,Integer coef_reduc,Integer type_client,String adresse_mail,String password,Integer nombre_points,Integer id_commercial_attribue){
        ref_client = ref_client;
        nom = nom;
        prenom = prenom;
        coef_reduc = coef_reduc;
        type_client = type_client;
        adresse_mail = adresse_mail;
        password = password;
        nombre_points = nombre_points;
        id_commercial_attribue = id_commercial_attribue;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef_client() {
        return ref_client;
    }

    public void setRef_client(String ref_client) {
        this.ref_client = ref_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCoef_reduc() {
        return coef_reduc;
    }

    public void setCoef_reduc(int coef_reduc) {
        this.coef_reduc = coef_reduc;
    }

    public int getType_client() {
        return type_client;
    }

    public void setType_client(int type_client) {
        this.type_client = type_client;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNombre_points() {
        return nombre_points;
    }

    public void setNombre_points(int nombre_points) {
        this.nombre_points = nombre_points;
    }

    public int getId_commercial_attribue() {
        return id_commercial_attribue;
    }

    public void setId_commercial_attribue(int id_commercial_attribue) {
        this.id_commercial_attribue = id_commercial_attribue;
    }
}
