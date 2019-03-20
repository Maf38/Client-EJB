package clientejb;


public class Tools {

	public static boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} 
		catch (NumberFormatException e){
			return false;
		}
		return true;		
    }

	
	public static boolean Calcul(double operande1, double operande2,char operateur, Reel res)
	{
		boolean succes=true;
		double resultat=0;
		
		switch (operateur) {                              
		case '*':
			resultat=operande1*operande2;
		break;
		case '+':
			resultat=operande1+operande2;
		break;
		case '-':
			resultat=operande1-operande2;
		break;
		case '/':
			if (operande2!=0) {
				resultat=operande1/operande2;
			}
			else {
				succes=false;
			}
		break;
		}
		
		res.setVal(resultat);
		return succes;
	}
	
	
	public static boolean estUnDouble(String chaine ){
		try{
			Double.parseDouble(chaine);
		}
		catch (NumberFormatException e){
			return false;
		}
		return true;
	}

	public static boolean estUnOperateur(char texteSaisie) {
		if (texteSaisie=='/' || texteSaisie=='-' || texteSaisie=='+' || texteSaisie=='*' ){
			return true;			
		}
		else {
			return false;		
		}
	}

}