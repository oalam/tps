/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Employe;
import domain.EmployePermanent;
import domain.EmployeTemporaire;
import java.util.StringTokenizer;

/**
 *
 * @author tom
 */
public class EmployeFactory {

    private static Employe createTemporaire(StringTokenizer tokenizer) {
	String nom = tokenizer.nextToken();
	String prenom = tokenizer.nextToken();
	int indiceBrut = Integer.parseInt(tokenizer.nextToken());
	int nbVJ = Integer.parseInt(tokenizer.nextToken());
	int nbVJWe = Integer.parseInt(tokenizer.nextToken());
	int nbVN = Integer.parseInt(tokenizer.nextToken());
	int nbVNWe = Integer.parseInt(tokenizer.nextToken());

	return createEmploye(nom, prenom, indiceBrut,
		nbVJ, nbVJWe, nbVN, nbVNWe);
    }

    private static Employe createPermanent(StringTokenizer tokenizer) {
	String nom = tokenizer.nextToken();
	String prenom = tokenizer.nextToken();
	int indiceBrut = Integer.parseInt(tokenizer.nextToken());
	boolean diurne = tokenizer.nextToken().contains("diurne");
	int nbja = Integer.parseInt(tokenizer.nextToken());

	return createEmploye(nom, prenom, indiceBrut, diurne, nbja);
    }

    public static Employe createEmploye(String description) {
	StringTokenizer tokenizer = new StringTokenizer(description);
	String empType = tokenizer.nextToken();

	if (empType.equals("T")) {
	    return createTemporaire(tokenizer);
	} else {
	    return createPermanent(tokenizer);
	}
    }
    
    
    public static Employe createEmploye(String nom, String prenom, int indiceBrut,
            boolean diurne, int nbja){
	
	return new EmployePermanent(nom, prenom, indiceBrut, diurne, nbja);
    }
    
    public static Employe createEmploye(String nom, String prenom, int indiceBrut, int nbVJ, 
                               int nbVJWe, int nbVN, int nbVNWe){
	return new EmployeTemporaire(nom, prenom, indiceBrut, nbVJ, 
		nbVJWe, nbVN, nbVNWe);
    }
}
