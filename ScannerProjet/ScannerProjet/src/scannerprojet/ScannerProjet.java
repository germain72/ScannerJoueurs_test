/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scannerprojet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Formation
 */
public class ScannerProjet {

    private static ArrayList<Joueur> lesJoueurs;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // nombre de joueur
        
        lesJoueurs = new ArrayList<Joueur>();
        Menu();
        
    }
    public static void Menu() {
        
        
        Scanner sc = new Scanner(System.in);
        
        String scRead = "";
        
        boolean isDoContinu = true;
        
        do {            
            
            bannierre("Menu");

            System.out.println(" Choisissez l'option");
            System.out.println(" ---------------------------------");
            System.out.println(" 1. Nombre de Jouers");
            System.out.println(" 2. Ajout de Joueurs");
            System.out.println(" q. Quitter ");
            System.out.print("\n Menu:");
            scRead = sc.next();
            System.out.println();

            int test = scRead.compareTo("q");
            try {
                if(scRead.compareTo("q") == 0 || scRead.compareTo("Q") == 0 )
                {
                    System.out.println("Exit Programme");
                    isDoContinu = false;
                    continue;
                }
                int select = Integer.parseInt(scRead);

                switch(select)
                {
                    case 1:
                        // Nombre de Jouers
                        nbJoueur();
                        break;
                    case 2:
                        // Ajout de Joueurs
                        AjouterJoueur();
                        break;
                    default:
                        break;
                        //throw new MenuExeption();

                }

//            } catch (MenuExeption e) {
//                e.printStackTrace();
//                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        
        } while (isDoContinu);
    }
    public static void nbJoueur()
    {
        System.out.println("Il y a " + lesJoueurs.size() + " Joueur");
        System.out.println();
    }
    public static  void AjouterJoueur() throws Exception
    {
        final int AGEMIN = 12;
        final String PASSWORD_PATTERN
            = "().{2,}",
                GENRE_PATTERN = "(?=.*[hfHF]).{1}";
        
        Pattern patternMDP ,patternGENRE;
        Matcher matcher ;
        
        
        try {
            patternGENRE = Pattern.compile(GENRE_PATTERN);
            patternMDP = Pattern.compile(PASSWORD_PATTERN);
            
            Joueur newJoueur = new Joueur();
            String champS;
            int champI;
            

            bannierre("Ajout Joueur");
            
            System.out.println("Ecrire \"exit\" pour retourner aux menu");
            System.out.println();
            
            System.out.print("Nom :");
            champS = kyeScanString();
            newJoueur.setNom(champS);
            //System.out.println();

            System.out.print("Prenom :");
            champS = kyeScanString();
            newJoueur.setPrenom(champS);
            //System.out.println();

            System.out.print("Pseudo :");
            champS = kyeScanString();
            newJoueur.setPseudo(champS);
            //System.out.println();

//            System.out.print("Genre :");
//            champS = kyeScanString();
//            newJoueur.setGenre(champS);
            //System.out.println();
            
            System.out.print("Genre :");
            champS = kyeScanString();
            do {              
                matcher = patternGENRE.matcher(champS);
                if (!matcher.matches()) {
                    System.out.println("Le Genre doie étre \"H\" ou \"F\"");
                    
                    System.out.print("Genre :");
                    champS = kyeScanString();
                }
            } while (!matcher.matches() );
            newJoueur.setGenre(champS);
            
            

            System.out.print("Age :");
            champI = kyeScanInt();
            int tentative = 3;
            do {                
                
                if(champI < AGEMIN )
                {
                    System.out.println("l'age ne dois pas étre inférieur à 12 ans");
                    System.out.print("Age :");
                    champI = kyeScanInt();
                    tentative--;
                }
                if(tentative == 0) throw new Exception("l'age ne dois pas étre inférieur à 12 ans !");
            } while (champI < AGEMIN );
            newJoueur.setAge(champI);
            //System.out.println();
            
            // Tentative de gérée l'erreur
            

            System.out.print("Mots de pass :");
            champS = kyeScanString();
            tentative = 3;
            do {              
                matcher = patternMDP.matcher(champS);
                if (!matcher.matches()) {
                    System.out.println("Le Mot de passe doit être superieur à 2 charactéres !");
                    
                    System.out.print("Mot de passe :");
                    champS = kyeScanString();
                }
                if(tentative == 0) throw new Exception("Le Mot de passe doit être superieur à 2 charactéres !");
            } while (!matcher.matches() );
            newJoueur.setPassWord(champS);
            //System.out.println();
            
            
            
            System.out.println("Le joueur " + newJoueur.getPseudo() + " à étée ajouter\n");
            lesJoueurs.add(newJoueur);
            
            
        }
        catch(ExitException e){
            
            System.out.println("\nSaisie de Joueur anuller \n");
        }
       
            
    }
    /***
     * Retourne une chaine de caractére saisie aux clavier
     * @return
     * @throws ExitException 
     */
    public static String kyeScanString() throws ExitException
    {
        Scanner sc = new Scanner(System.in);
        
        String scRead = sc.next();
        
        if("exit".equals(scRead))
        {
            throw new ExitException();
        }
        
        return scRead;
    }
    /***
     * retourne un entier saisie aux clavier
     * @return
     * @throws ExitException 
     */
    
    public static int kyeScanInt() throws ExitException
    {
        return Integer.parseInt(kyeScanString());
//        try {
//                
//            }
//            catch (NumberFormatException e) {
//                
//            }
//            catch (Exception e) {
//                System.out.println("Erreur inconue \n");
//                e.printStackTrace();
//                System.out.println("" + e.getMessage());
//            }
    }
    
    public static void bannierre(String msg)
    {
        String caract ="";
        for(int i=0;i<msg.length();i++)
        {
            caract += "═";
        }
        System.out.printf("\t╔%s╗\n",caract);
        
        
            System.out.printf("\t║ %s ║\n",msg);
            System.out.printf("\t╚%s╝\n",caract);
    }
}
