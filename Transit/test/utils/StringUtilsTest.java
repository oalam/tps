/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.junit.Test;
import static org.junit.Assert.*;
import parser.AbstractFileParser;

/**
 *
 * @author tom
 */
public class StringUtilsTest {
    
    public StringUtilsTest() {
    }

    /**
     * Test of toUpperFirst method, of class StringUtils.
     */
   @Test
    public void testToUpperFirst() {
	
	String str = "MELUN => MONTEREAU VIA MORET";
	String str2 = "Melun => Montereau via Moret";
	String str3 = AbstractFileParser.cleanup(str,true, true);
	assertEquals(str2, str3);
	
	str  = "Spécial Travaux Creil - Gare de l\'Est";
	str2  = "Spécial Travaux Creil - Gare de l'Est";
	str3 = AbstractFileParser.cleanup(str,true, true);
	assertEquals(str2, str3);
	System.out.println("str3 = " + str3);
    }
}
