/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tom
 */
public class GtfsParserTest {
    
    public GtfsParserTest() {
    }

    /**
     * Test of createEntity method, of class GTFSParser.
     */
    @Test
    public void testAgencyParser() {
	GtfsParser parser = new GtfsParser();
	parser.parse();
	
	assertEquals(9,parser.getAgencies().size());
	assertEquals(181,parser.getRoutes().size());
	assertEquals(939,parser.getStops().size());
	assertEquals(4082,parser.getCalendars().size());
	assertEquals(201954,parser.getStopTimes().size());
	assertEquals(17647,parser.getTrips().size());
    }
    
  
    
}
