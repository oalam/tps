/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import entity.Stop;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.StrTokenizer;

/**
 *
 * @author tom
 */
public class StopFileParser extends AbstractFileParser<Stop> {

    @Override
    public Stop createEntity(StrTokenizer tokenizer) {
	try {
	    //stop_id,stop_name,stop_desc,stop_lat,stop_lon,zone_id,stop_url,location_type,parent_station

	    String stopId = tokenizer.nextToken();
	    String stopName = cleanup(tokenizer.nextToken(), true, true);
	    // desc not used
	    tokenizer.nextToken();
	    BigDecimal stopLat = new BigDecimal(tokenizer.nextToken());
	    BigDecimal stopLon = new BigDecimal(tokenizer.nextToken());

	    return new Stop(stopId, stopName, stopLat, stopLon);
	} catch (Exception ex) {
	    Logger.getLogger(StopFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}
