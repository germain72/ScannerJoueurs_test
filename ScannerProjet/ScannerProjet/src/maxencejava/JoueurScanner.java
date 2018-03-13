/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxencejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Formation
 */
public class JoueurScanner {
 private static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
       try {
           
           int nbJoueurs =0;
           String valeur= "";
           System.out.println(" Saisir un nombre : ");
           List <Joueur> ListeJoueurs = new ArrayList <Joueur> (); 
           while (!sc.hasNextInt()) {
               sc.next();
           }
           valeur = sc.next();
           nbJoueurs = Integer.parseInt(valeur);
           
           // Nombre de joueur OK
           while (ListeJoueurs.size() < nbJoueurs) {
               saisir_joueur(ListeJoueurs);
           }
           
       } catch (Exception e) {
           System.out.println(e.getMessage());
       } 
    }
    /**
     * 
     * @param ListeJoueurs
     * <b>Toutes les exceptions seront gérées dans le main.</b>
     * <i>On saisit toutes les données du joueur et on contrôle la saisie</i>
     * @throws Exception 
     */
    public static void saisir_joueur(List<Joueur> ListeJoueurs) throws Exception
    {
         String temp="";
         int valtemp=0;
           Joueur oj = new Joueur();
           System.out.println(" Saisir le nom : ");
           oj.setNom(setClavier(temp));
           System.out.println(" Saisir le prénom :");
           oj.setPrenom(setClavier(temp));
           System.out.println(" Saisir votre Pseudo :");
           oj.setPseudo(setClavier(temp));
           System.out.println(" Saisir votre mot de passe ");
           temp = setClavier(temp);
           if(temp.length() >2)           
               oj.setMdp(temp);
           else
               throw new Exception("La taille du MTP est inférieure à 2 !");
            System.out.println(" Saisir votre âge ");
           valtemp = setClavier(valtemp);
           if(valtemp > 12)
           {
               oj.setAge(valtemp);
           }
           else
               throw new Exception("L'âge est inférieur à 12 !");
           System.out.println(" Saisir votre Genre : ");
           temp = setClavier(temp);
           if (temp.equalsIgnoreCase("M"))
           {
               oj.setGenre(Genre.M);
           }
           else {
               if (temp.equalsIgnoreCase("F"))  
               {
                   oj.setGenre(Genre.F);
               }
               else
               {
                   throw new Exception("Le genre est invalide !");
               }
           }

           ListeJoueurs.add(oj);
    }
    
    public static String setClavier(String temp)
    {
        temp = sc.next();
        return temp;
    }
     public static int setClavier(int temp)
    {
         if (sc.hasNextInt()) {
               temp = sc.nextInt();
           }

        return temp;
    }
}