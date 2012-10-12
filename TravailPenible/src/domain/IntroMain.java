/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author tom
 */
public class IntroMain {
    
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        String nom = "Bailet";
        String prenom = "Thomas";
        int indiceBrut = 650;
        boolean diurne = true;
        int nbja = 10;
        int nbVJ = 2;
        int nbVJWe = 3;
        int nbVN = 4;
        int nbVNWe = 5;

        
        Class cP = Class.forName("employee." + "Permanent");
        Object oP = cP.newInstance();
        
        Field[] mP2 = cP.getSuperclass().getDeclaredFields();
        for (Field field : mP2) {
            String fieldName = field.getName();
            System.out.println("fieldName = " + fieldName);
        }
    
        Field[] mP = cP.getDeclaredFields();
        for (Field field : mP) {
            field.setAccessible(true);
            String fieldName = field.getName();
            System.out.println("fieldName = " + fieldName);
            switch(fieldName){
                case "nom":
                    field.set(oP, nom);
                    break;
                case "indiceBrut":
                    field.setInt(oP, indiceBrut);
                    break;
                    
            }
        }
        
        Class[] types = new Class[] {};
        Method method = cP.getMethod("indemniteTravailPenible", types);
        Double result = (Double) method.invoke(oP, (Object[]) null);
        System.out.println("result = " + result);
        
        
    }
}
