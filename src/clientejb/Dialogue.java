package clientejb;

import java.util.Scanner;

public class Dialogue {

		public static boolean veutContinuer(){
			
			//D�claration des variables et init
			String texteSaisie;
			char caractSaisie;//caract�re saisie
			boolean testOK=false; //test de r�ponse correcte
			boolean continu=false;// relance de la boite de dialogue
			
			//programme
			Scanner sc= new Scanner(System.in);
			do {													//Poser la la question tant qu'on a pas saisi une reponse valable
				System.out.println("Voulez vous continuer (O ou N)?");
				texteSaisie=sc.nextLine();
				
					if(texteSaisie.length()==1){// si on a la bonne longueur de chaine
						caractSaisie=texteSaisie.charAt(0);
						switch(caractSaisie){
						case 'o':
						case 'O':
							testOK=true;
							continu=true;
						break;
						case 'n':
						case 'N':
							testOK=true;
							continu=false;
						break;
						}
					}								
			} while(!testOK);
			
			//sc.close();
			return(continu);	
		}
					
		 public static char LireOperateur(String msg){
			 
			 Scanner sc= new Scanner(System.in);
			 String texteSaisie; 
			 char operateur='z';
			 boolean fini=false;
			 
			 			 
			 do{													
					System.out.println(msg);
					
					texteSaisie=sc.nextLine();
					if (texteSaisie.length()==1){
						
						fini=Tools.estUnOperateur(texteSaisie.charAt(0));
						
						if(fini){
							operateur=texteSaisie.charAt(0);						
						}				
					}
										
				} while(!fini);
			 
			 //sc.close();
			 return operateur;
			 
		 }
		
		 public static double lireDouble (String msg)
			{
				Scanner sc= new Scanner(System.in);
				String texteSaisie ; 
				double nombre=0;
				boolean fini=false;
				
				do
				{
					System.out.println(msg);
					texteSaisie  = sc.nextLine();
					if ( Tools.estUnDouble(texteSaisie) )
					{
						nombre = Double.parseDouble(texteSaisie);
						fini=true;
						
					}
				}
				while (!fini);
				
				//sc.close();
				return (nombre);
				
		}
		 public static void AfficherDouble(String msg,double nb)
		 {
			 System.out.println(msg+Double.toString(nb));
		 }
		 
		 
		 public static int lireEntier (String msg)
			{
				Scanner sc= new Scanner(System.in);
				String texteSaisie ; 
				int nombre=0;
				do
				{
					System.out.println(msg);
					texteSaisie  = sc.nextLine();
					if ( Tools.estUnEntier(texteSaisie) )
					{
						nombre = Integer.parseInt(texteSaisie);				
					}
				}
				while (nombre <= 0);
				sc.close();
				return (nombre);
			}	

}
