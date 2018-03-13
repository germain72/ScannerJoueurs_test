/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerprojet;

/**
 *
 * @author Formation
 */
public class Joueur {
    private String nom , prenom , pseudo , passWord , genre;
    private int age;

    public Joueur() {
    }

    public Joueur(String nom, String prenom, String pseudo, String passWord, String genre, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.passWord = passWord;
        this.genre = genre;
        this.age = age;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
