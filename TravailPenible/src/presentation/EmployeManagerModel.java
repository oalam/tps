/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.EmployeManager;
import domain.Employe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author adminl
 */
public class EmployeManagerModel implements TableModel, ListModel, Serializable {

    private final EmployeManager manager = new EmployeManager();
    private final String[] columns = {"Nom", "Prénom", "Indice brut", "Indemnité"};
    private String fileName = "d:\\temp.txt";

    public EmployeManagerModel() {
        load();
        System.out.println("loaded " + this.getRowCount());
    }

    public double getIndemnites() {
        return manager.getTotalIndemnites();
    }

    public double getIndemnitesBruit() {
        return manager.geTotalIndemnitesBruit();
    }

    @Override
    public int getRowCount() {
        return manager.getAllEmployes().size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employe employe = manager.getAllEmployes().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employe.getNom();
            case 1:
                return employe.getPrenom();
            case 2:
                return employe.getIndiceBrut();
            case 3:
                return employe.indemniteTravailPenible();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Employe employe = manager.getAllEmployes().get(rowIndex);
        switch (columnIndex) {
            case 0:
                employe.setNom((String) aValue);
                break;
            case 1:
                employe.setPrenom((String) aValue);
                break;
            case 2:
                employe.setIndiceBrut(Integer.parseInt((String)aValue));
                break;
        }
        for (ListDataListener listDataListener : listListeners) {
            listDataListener.contentsChanged(new ListDataEvent(aValue, rowIndex, rowIndex, rowIndex));
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSize() {
        return this.getRowCount();
    }

    @Override
    public Object getElementAt(int index) {
        return manager.getAllEmployes().get(index);
    }
    List<ListDataListener> listListeners = new ArrayList<>();

    @Override
    public void addListDataListener(ListDataListener l) {
        listListeners.add(l);

    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    public void save() {
        manager.enregistrer(fileName);
    }

    public void load() {
        manager.charger(fileName);
    }

    public void setFileName(String file) {
        fileName = file;
    }

    void addRow() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
