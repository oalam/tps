/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author adminl
 */
@Singleton
@LocalBean
@WebListener
public class CountSessionBean implements HttpSessionListener {

    private static int counter = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        counter--;
    }
    
    public int getActivesessionCount(){
        return counter;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
