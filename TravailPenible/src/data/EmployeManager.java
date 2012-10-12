/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Employe;
import domain.EmployePermanent;
import domain.EmployeTemporaire;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tom
 */
public class EmployeManager {

    private List<Employe> employes = new ArrayList<>();
    private EmployeDao dao = new FileEmployeDao();

    public List<Employe> getPermanents() {
	List<Employe> permanents = new ArrayList<>();
	for (Employe employe : employes) {
	    if (employe instanceof EmployePermanent) {
		permanents.add(employe);
	    }
	}
	return permanents;
    }

    public List<Employe> getTemporaires() {
	List<Employe> temporaires = new ArrayList<>();

	for (Employe employe : employes) {
	    if (employe instanceof EmployeTemporaire) {
		temporaires.add(employe);
	    }
	}
	return temporaires;
    }

    public List<Employe> getAllEmployes() {
	return new ArrayList<>(employes);
    }

    public double getTotalIndemnites() {
	double total = 0.0;
	for (Employe employe : employes) {
	    total += employe.indemniteTravailPenible();
	}
	return total;
    }

    public double geTotalIndemnitesBruit() {
	double total = 0.0;
	for (Employe employe : employes) {
	    if (employe instanceof EmployePermanent) {
		EmployePermanent temp = (EmployePermanent) employe;
		total += temp.indemniteBruit();
	    }
	}
	return total;
    }

    public void add(Employe emp) {
	employes.add(emp);
    }

    public void remove(String nom) {
	for (Employe employe : employes) {
	    if (employe.getNom().equals(nom)) {
		employes.remove(employe);
		return;
	    }
	}
    }

    public void charger(String nomfichier) {
	employes = dao.charger(nomfichier);
    }

    public void enregistrer(String nomfichier) {
	dao.enregistrer(nomfichier, employes);
    }

    public void clear() {
	employes.clear();
    }
}
