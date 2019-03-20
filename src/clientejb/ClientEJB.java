/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejb;

import ejb.ControleurRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author gai
 */
public class ClientEJB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {

        // Attention : on utilise ici le chemin JNDI par défaut :
        // nom de package + nom d’interface
        // si ce chemin est modifié dans le fichier xml de configuration, il faut
        // donner le <jndi-name> défini dans ce fichier, par exemple
        // "ejb/regis/Calcul"
        //chemin = SessionCalculLocal.class.getName();
        //   System.out.println(chemin);
        try {

            String chemin;

           

            boolean succes = true;

            //rechercher le proxy
            Context ctx = new InitialContext();
            System.out.println("Context");
            // Attention : on récupère toujours l’interface « remote »
            // et jamais l’EJB session lui-même
            ControleurRemote leProxy = (ControleurRemote) ctx.lookup("ejb.ControleurRemote");
            
            //System.out.println( leProxy.convertir("Yen", "Livre", 1110) );
         
            //utiliser
            String result;
            result = leProxy.hello();
            System.out.println("result=" + result);
                   
            
            boolean continu = false;
            double operande1 ;
            double operande2 ;
            char operateur ;
            double resultat=0;
            
            
            
            do {
                
                   
                operande1 = Dialogue.lireDouble("Rentrez l'opérande1");
                operateur = Dialogue.LireOperateur("Rentrez l'opérateur");
                operande2 = Dialogue.lireDouble("Rentrez l'opérande2");

                switch (operateur) {
                    case '*':
                        resultat = leProxy.multiplie(operande1, operande2);
                    
                        break;
                    case '+':
                        resultat = leProxy.plus(operande1, operande2);
                  
                        break;
                    case '-':
                        resultat = leProxy.moins(operande1, operande2);
                        
                        break;
                    case '/':
                        if (operande2 != 0) {
                            resultat = leProxy.divise(operande1, operande2);;
                           
                        } else {
                            succes = false;
                            resultat=0;
                        }
                        break;
                }
                
                        System.out.println("Le résultat du calcul est: "+resultat);
                        System.out.println(resultat+"  Yen valent "+ leProxy.convertir("Yen", "Livre", resultat)+" Livre");
                        
                        continu = Dialogue.veutContinuer();
                }while (continu);
            
        
        } catch (NamingException ex) {
            System.out.println(ex.toString());
        }
    }

}
