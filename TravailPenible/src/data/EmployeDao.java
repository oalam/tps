package data;


import domain.Employe;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tom
 */
public interface EmployeDao {

    /**
     * Création d'une liste d'employés depuis un fichier texte.
     *
     * @param fileName le nom du fichier texte.
     * @return une liste d'employés
     */
    List<Employe> charger(String fileName);

    /**
     * Enregistre une liste d'employés dans un fichier texte.
     * L'enregistrement se fait à raison d'un employé par ligne.
     *
     * @param fileName le nom du fichier texte à créer.
     * @param employes la liste des employés à enregistrer.
     *
     */
    void enregistrer(String fileName, List<Employe> employes);
    
}
