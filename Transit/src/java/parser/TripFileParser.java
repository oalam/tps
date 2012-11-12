/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import entity.Trip;
import entity.TripPK;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.StrTokenizer;

/**
 *
 * @author tom
 */
public class TripFileParser extends AbstractFileParser<Trip> {

    @Override
    public Trip createEntity(StrTokenizer tokenizer) {
	try {
	    //route_id,service_id,trip_id,trip_headsign,direction_id,block_id,shape_id
	    String routeId = tokenizer.nextToken();
	    String serviceId = tokenizer.nextToken();
	    String tripId = tokenizer.nextToken();
	    String tripHeadsign = cleanup(tokenizer.nextToken(),true,false);
	    Integer directionId = Integer.parseInt(tokenizer.nextToken());
	    
	    TripPK key = new TripPK(tripId, serviceId);
	    Trip t =  new Trip(key);
	    
	    t.setTripHeadsign(tripHeadsign);
	    t.setDirectionId(directionId);
	    t.setParsedRouteId(routeId);
		  
	    return t;
	} catch (Exception ex) {
	    Logger.getLogger(TripFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}