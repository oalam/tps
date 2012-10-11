/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author adminl
 */
public class IdGenerator {

    private static int count = 0;

    public static int getNextId() {

        return count++;
    }
}
