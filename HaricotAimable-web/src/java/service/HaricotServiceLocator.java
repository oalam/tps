/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author tom
 */
public class HaricotServiceLocator {
    public static HaricotService getService(){
	return new EjbHaricotService();
    }
    
}
