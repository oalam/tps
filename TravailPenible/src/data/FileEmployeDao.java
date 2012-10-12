/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.Employe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tom
 */
public class FileEmployeDao implements EmployeDao {

    @Override
    public List<Employe> charger(String fileName) {
	List<Employe> result = new ArrayList<>();
	FileReader fr = null;
	try {

	    fr = new FileReader(fileName);
	    BufferedReader bfr = new BufferedReader(fr);


	    String line;
	    while ((line = bfr.readLine()) != null) {
		Employe newEmploye = EmployeFactory.createEmploye(line);
		if (newEmploye != null) {
		    result.add(newEmploye);
		}
	    }

	} catch (FileNotFoundException ex) {
	    Logger.getLogger(FileEmployeDao.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(FileEmployeDao.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		fr.close();
	    } catch (IOException ex) {
		Logger.getLogger(FileEmployeDao.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}
	return result;
    }

    @Override
    public void enregistrer(String fileName, List<Employe> employes) {

	FileWriter fw = null;
	try {

	    fw = new FileWriter(fileName);
	    BufferedWriter bfw = new BufferedWriter(fw);

	    for (Employe employe : employes) {
		bfw.write(employe.exporter());
		bfw.newLine();
	    }
	    bfw.flush();
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(FileEmployeDao.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(FileEmployeDao.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {

		fw.close();
	    } catch (IOException ex) {
		Logger.getLogger(FileEmployeDao.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}
    }
}
