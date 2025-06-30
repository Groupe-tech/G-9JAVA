/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_de_java;

/**
 *
 * @author drazi
 */
public class Contacts {
    private String nom;
    private String telephone;
    private String mail;
    
    public Contacts(String nom,String telephone,String mail){
        this.nom=nom;
        this.telephone=telephone;
        this.mail=mail;
        
    
    }
    
    public String  getNom(){
        
        return nom;
    
    }
    
    public String getTelephone(){
        
        return telephone;
    
    
    }
    public String getMail(){
        
        return mail;
    
    
    }
    @Override
    public String toString(){
        return "Nom : "+ nom+"\n"+
               "telephone :"  +  telephone +"\n"+
                "mail :" + mail;
    
    
    }
            
    
}
