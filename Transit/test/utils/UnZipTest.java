/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tom
 */
public class UnZipTest {

    public UnZipTest() {
    }

    /**
     * Test of main method, of class UnZip.
     */
    @Test
    public void testMain() {
    }

    /**
     * Test of unZipIt method, of class UnZip.
     */
    @Test
    public void testUnZipIt() {
	System.out.println("testUnZipIt");
	try {
	    Path temp = Files.createTempDirectory("transit");
	    
	   
	    UnZip.unZipIt("setup/export-TN-GTFS-LAST.zip", temp.toAbsolutePath().toString());
		    
	   
	} catch (IOException ex) {
	    Logger.getLogger(UnZipTest.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
