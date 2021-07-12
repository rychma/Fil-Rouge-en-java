package org.example.DAL;

public class Employe {
    private int id;
    private String login;
    private String password;
    private String droits;

    public Employe(){

    }

    public Employe(int id, String login, String password, String droits){
        this.id = id;
        this.login = login;
        this.password = password;
        this.droits = droits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDroits() {
        return droits;
    }

    public void setDroits(String droits) {
        this.droits = droits;
    }
}
