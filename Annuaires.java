/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_de_java;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author drazi
 */
public class Annuaires {
     private ArrayList<Contacts> listecontact ;
     
     public Annuaires(){
       listecontact =new ArrayList<>();
     
     }
     boolean existe;
     public void ajouter(Contacts c){
         for (Contacts d: listecontact){
         if(d.getNom().equalsIgnoreCase(c.getNom())){
             JOptionPane.showMessageDialog(null,"le contact existe deja ");
             existe=true;
             break;
         }}
         if(!existe){
         listecontact.add(c);
         }
   
         
     }
     
     
    public boolean supprimer(String nom) {
        for (int i = 0; i <  listecontact.size(); i++) {
            if ( listecontact.get(i).getNom().equalsIgnoreCase(nom)) {
                 listecontact.remove(i);
                JOptionPane.showMessageDialog(null, "✅ Contact supprimé : " + nom);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "❌ Contact introuvable : " + nom);
        return false;
    }
     
     
      public  Contacts rechercher(String nom ){
          for (Contacts c : listecontact){
              if(c.getNom().equalsIgnoreCase(nom)){
                  return c;
          }
          }
          return null;
          
          
      }
     
     public void getTousContacts(){
         for(Contacts c :listecontact){
              System.out.println(c);
         }
     }
}
    
    

