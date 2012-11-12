/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import entity.StopTime;
import entity.StopTimePK;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.StrTokenizer;

/**
 *
 * @author tom
 */
public class StopTimeFileParser extends AbstractFileParser<StopTime> {

    @Override
    public StopTime createEntity(StrTokenizer tokenizer) {
	try {
	    //trip_id,arrival_time,departure_time,stop_id,stop_sequence,
	    //stop_headsign,pickup_type,drop_off_type,shape_dist_traveled
	    DateFormat df = new SimpleDateFormat("hh:mm:ss");
	    String tripId = tokenizer.nextToken();
	    Date arrivalTime = df.parse(tokenizer.nextToken());
	    Date departureTime = df.parse(tokenizer.nextToken());
	    String stopId = tokenizer.nextToken();
	    int stopSequence = Integer.parseInt(tokenizer.nextToken());
	    // stop_headsign not used
	    tokenizer.nextToken();
	    int pickupType = Integer.parseInt(tokenizer.nextToken());
	    int dropOffType = Integer.parseInt(tokenizer.nextToken());
	    StopTimePK stopTimePK = new StopTimePK(tripId, stopId);


	    return new StopTime(stopTimePK, arrivalTime, departureTime, stopSequence, pickupType, dropOffType);
	} catch (Exception ex) {
	    Logger.getLogger(StopTimeFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}