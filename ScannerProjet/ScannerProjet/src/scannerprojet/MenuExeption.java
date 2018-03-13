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
public class MenuExeption extends Exception{

    @Override
    public String getMessage() {
        return "Erreur la saisie et incorrect" + super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
