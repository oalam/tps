package presentation;

import data.EmployeFactory;
import data.EmployeManager;
import domain.Employe;
import java.util.List;

/**
 * GestionEmployes.java
 *
 * Programme de gestion d'une liste d'employés. Ce programme offre les
 * fonctionnzlités suivantes :<BR> <UL> <LI>afficher tous les employes
 * <LI>afficher tous les employes permanents <LI>afficher tous les employes
 * temporaires <LI>afficher le montant total des indemnites <LI>afficher le
 * montant total des primes de bruits <LI>ajouter un employé <LI>supprimer un
 * employe <LI>charger la liste depuis un fichier <LI>enregistrer la liste dans
 * un fichier <LI>vider la liste </UL>
 *
 * @version
 */
public class GestionEmployesFacade {

    EmployeManager manager = new EmployeManager();

    /**
     * affiche un menu proposant les différentes opérations possibles sur la
     * liste des employés
     */
    private void affMenu() {
	System.out.println("-----------------------------------------------");
	System.out.println("1 : afficher tous les employes ");
	System.out.println("2 : afficher tous les employes permanents ");
	System.out.println("3 : afficher tous les employes temporaires ");
	System.out.println("4 : afficher le montant total des indemnites ");
	System.out.println("5 : afficher le montant total des primes de bruits ");
	System.out.println("6 : ajouter un employé ");
	System.out.println("7 : supprimer un employe ");
	System.out.println("8 : charger la liste depuis un fichier ");
	System.out.println("9 : enregistrer la liste dans un fichier ");
	System.out.println("10: vider la liste");
	System.out.println("0 : quitter l'application ");

	System.out.print("\nVotre choix : ");
    }

    /**
     * affiche tous les employés
     */
    private void employes() {
	for (Employe employe : manager.getAllEmployes()) {
	    System.out.println("--------------------------------------");
	    employe.afficher();
	}
    }

    /**
     * affiche que les employés permanents
     */
    private void permanents() {
	for (Employe employe : manager.getPermanents()) {
	    System.out.println("--------------------------------------");
	    employe.afficher();
	}
    }

    /**
     * affiche que les employes temporaires
     */
    private void temporaires() {
	for (Employe employe : manager.getTemporaires()) {
	    System.out.println("--------------------------------------");
	    employe.afficher();
	}
    }

    /**
     * affiche le montant total des indemnités
     */
    private void totalIndemnites() {
	double total = manager.getTotalIndemnites();
	System.out.println("--------------------------------------");
	System.out.println("montant total des indemnités " + total);
    }

    /**
     * affiche le montant total des indemnités de bruit
     */
    private void totalIndemnitesBruit() {
	double total = manager.geTotalIndemnitesBruit();
	System.out.println("--------------------------------------");
	System.out.println("montant total des indemnités de bruit" + total);
    }

    /**
     * ajoute un employé é la liste
     */
    private void ajouterEmploye() {
	Employe emp = null;
	System.out.print("nom : ");
	String nom = LectureClavier.lireChaine();
	System.out.print("prénom : ");
	String prenom = LectureClavier.lireChaine();
	System.out.print("indice : ");
	int indice = LectureClavier.lireEntier();
	System.out.print("Permanent O/N ? : ");
	boolean permanent = LectureClavier.lireOuiNon();
	if (permanent) {
	    System.out.print("travailleur diurne (O/N) ? : ");
	    boolean diurne = LectureClavier.lireOuiNon();
	    System.out.print("nombre de jours de travail sur abraseuse ? : ");
	    int nbjA = LectureClavier.lireEntier();
	    emp = EmployeFactory.createEmploye(nom, prenom, indice, diurne, nbjA);
	} else {
	    System.out.print("nombre total de vacations de jour ? : ");
	    int nbVacJ = LectureClavier.lireEntier();
	    System.out.print("nombre de vacations de jour le week-end ? : ");
	    int nbVacJWe = LectureClavier.lireEntier();
	    System.out.print("nombre total de vacations de nuit ? : ");
	    int nbVacN = LectureClavier.lireEntier();
	    System.out.print("nombre de vacations de nuit le week-end ? : ");
	    int nbVacNWe = LectureClavier.lireEntier();
	    emp = EmployeFactory.createEmploye(nom, prenom, indice, nbVacJ, nbVacJWe, nbVacN, nbVacNWe);
	}
	manager.add(emp);
    }

    /**
     * supprime un employé de la liste
     */
    private void supprimerEmploye() {
	System.out.print("nom : ");
	String nom = LectureClavier.lireChaine();
	manager.remove(nom);
    }

    /**
     * charge la liste des employés é partir d'un fichier
     */
    private void chargerListeEmployes() {
	System.out.print("nom du fichier é charger : ");
	String nomfichier = LectureClavier.lireChaine();
	manager.charger(nomfichier);
    }

    /**
     * enregistre la liste des employés dans un fichier
     */
    private void enregistrerListeEmployes() {
	System.out.print("nom du fichier é créer ");
	String nomfichier = LectureClavier.lireChaine();

	manager.enregistrer(nomfichier);
    }

    private void supprimerTous() {
	System.out.print("suppression de la liste d'employes");
	System.out.print("Voulez vous vraimment vider la liste d'employes O/N ");
	boolean really = LectureClavier.lireOuiNon();
	if(really){
	    manager.clear();
	}
	
    }

    /**
     * le programme principal
     */
    public static void main(String[] args) {

	GestionEmployesFacade facade = new GestionEmployesFacade();


	boolean encore = true;
	do {
	    facade.affMenu();
	    int rep = LectureClavier.lireEntier();

	    switch (rep) {
		case 0:
		    System.out.print("Voulez vous vraimment quitter l'application O/N ");
		    encore = !LectureClavier.lireOuiNon();
		    break;
		case 1:
		    facade.employes();
		    break;
		case 2:
		    facade.permanents();
		    break;
		case 3:
		    facade.temporaires();
		    break;
		case 4:
		    facade.totalIndemnites();
		    break;
		case 5:
		    facade.totalIndemnitesBruit();
		    break;
		case 6:
		    facade.ajouterEmploye();
		    break;
		case 7:
		    facade.supprimerEmploye();
		    break;
		case 8:
		    facade.chargerListeEmployes();
		    break;
		case 9:
		    facade.enregistrerListeEmployes();
		    break;
		case 10:
		    facade.supprimerTous();
		    break;
		default:
		    System.out.println("Mauvais numéro de commande");
		    break;
	    } // fin du switch
	} while (encore);
    }
}// GestionEmployes
