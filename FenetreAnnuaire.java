/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_de_java;


import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
public class FenetreAnnuaire extends JFrame  {
    private Annuaires annuaire;
    private JTextField nomField, telField,emailField,rechercheField; 
    private JButton ajouterButton, rechercherButton, supprimerButton;
    JTable contactsTable, DefaultTableModel ,tableModel;
    
    
    

    public FenetreAnnuaire(){
        annuaire=new Annuaires();
        
        setTitle("Annuaire Telephonique");
        setSize(700,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//pour fermer automatiquement la fenetre 
        setLayout(new BorderLayout());
        setResizable(true);  //redimentionner ou pas la fenetre 
        setLocationRelativeTo(null); // pour centrer la fenetre au centre 
        setVisible(true);
        
          JPanel panel =new JPanel();
          
          //layout verticale
          panel.setLayout( new BoxLayout(panel,BoxLayout.Y_AXIS));
          JPanel fromPanel = new JPanel(new GridBagLayout());
          GridBagConstraints gbc = new GridBagConstraints();
          gbc.insets = new Insets(5,5,5,5);
          gbc.fill = GridBagConstraints.HORIZONTAL;
          gbc.gridx = 0; gbc.gridy = 0;
          
          //creation de label
           JLabel noms =new JLabel("nom");
           JLabel numeros =new JLabel("numero");
           JLabel mails =new JLabel("mail");
           JLabel recherche=new JLabel("recherche");
           
          
          
          
          //champs de texte 
         
          nomField=new JTextField(30);
          telField=new JTextField(30);
          emailField =new JTextField(30);
          rechercheField=new JTextField(30);
           
           
           
           //limite de la largeur du champ de texte
           nomField.setMaximumSize(nomField.getPreferredSize());
           telField.setMaximumSize(telField.getPreferredSize());
           emailField.setMaximumSize(emailField.getPreferredSize());
             rechercheField.setMaximumSize(  rechercheField.getPreferredSize());
           
           
           noms.setAlignmentX(Component.CENTER_ALIGNMENT);
           nomField.setAlignmentX(Component.CENTER_ALIGNMENT);
           
           
          
          //creations de bouton
           ajouterButton=new JButton("ajouter");
           rechercherButton =new JButton("rechercher");
           supprimerButton=new JButton("supprimer");
           
           //ajout des element dans le  panel
           panel.add(noms);
           panel.add( nomField);
           
           panel.add(numeros);
           panel.add( telField);
           
           
           panel.add(mails);
           panel.add( emailField);
           
           panel.add(recherche);
           panel.add(rechercheField);
           
           panel.add( ajouterButton);
           panel.add(rechercherButton);
           panel.add(supprimerButton );
           //ajout du panel dans la fenetre
           add(panel);
           
            DefaultTableModel tableModel =new  DefaultTableModel(new Object []{"Nom","Numero","mail"},0
            
            
            );
           JTable contactsTable =new JTable( tableModel);
           
           
           
           JScrollPane scrollpane = new  JScrollPane(contactsTable);
           panel.add(scrollpane);
           
           
           
           
           
           ajouterButton.addActionListener(e -> {
    String nom = nomField.getText().trim();
    String numero = telField.getText().trim();
    String mail = emailField.getText().trim();

    if (!nom.isEmpty() && !numero.isEmpty() && !mail.isEmpty()) {
        // Vérifie si le contact existe déjà
        Contacts existant = annuaire.rechercher(nom);
        if (existant != null) {
            JOptionPane.showMessageDialog(this, "⚠️ Le contact avec ce nom existe déjà.");
            return; // on arrête ici, pas d'ajout
        }

        // Si pas existant, on l'ajoute
        Contacts c = new Contacts(nom, numero, mail);
        annuaire.ajouter(c);
        tableModel.addRow(new Object[]{nom, numero, mail});

        // Nettoyer les champs
        nomField.setText("");
        telField.setText("");
        emailField.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Merci de remplir tous les champs.");
    }
});

             
               rechercherButton.addActionListener(e->{
                   String recherches = rechercheField.getText().trim();
                                  Contacts c= annuaire.rechercher(recherches);
                                  if (c!=null){
                                   JOptionPane.showMessageDialog(null,
                                              "Nom /n"+c.getNom()+"\n"+
                                              "Numero"+c.getTelephone()+"\n"+
                                              "Mail"+c.getMail()+"\n");
                                  } else  {
                                      JOptionPane.showMessageDialog(null, "le contact n'existe pas  ");
                                  }}
                                
               
               
               
               );
               
               
               
            supprimerButton.addActionListener(e -> {
    String nom = nomField.getText().trim();
    if (nom.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Veuillez entrer un nom");
        return;
    }
    // Supprimer dans l'annuaire
     boolean supprimé = annuaire.supprimer(nom);

    if (supprimé) {
        // Supprimer dans la JTable
        boolean ligneTrouvee = false;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nomTable = tableModel.getValueAt(i, 0).toString();
            if (nomTable.equalsIgnoreCase(nom)) {
                tableModel.removeRow(i);
                ligneTrouvee = true;
                break;
            }
        }
        if (!ligneTrouvee) {
            JOptionPane.showMessageDialog(this, "Le contact a été supprimé de l'annuaire, mais il n'était pas affiché dans la table.");
        } else {
            JOptionPane.showMessageDialog(this, "Contact supprimé.");
        }
        nomField.setText("");
        telField.setText("");
        emailField.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Le contact n'existe pas.");
    }
});

             
      
          
         
          
           
           
        
           
           
           
                   
           
           
           
           
           
          
          
          
                  
                  
          
          
         
        
        
          
    }
          
         
    
 


    
}
