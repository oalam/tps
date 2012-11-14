/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import entity.Route;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.StrTokenizer;

/**
 *
 * @author tom
 */
public class RouteFileParser extends AbstractFileParser<Route> {

    @Override
    public Route createEntity(StrTokenizer tokenizer) {
	try {
	    //route_id,agency_id,route_short_name,route_long_name,route_desc,
	    //route_type,route_url,route_color,route_text_color

	    String routeId = tokenizer.nextToken();
	    // TODO: how to retrieve the Route ?
	    String agencyId = tokenizer.nextToken();
	    String routeShortName = cleanup(tokenizer.nextToken(), true, true);
	    String routeLongName = cleanup(tokenizer.nextToken(), true, true);
	    // not used
	    String routeDesc = tokenizer.nextToken();
	    int routeType = Integer.parseInt(tokenizer.nextToken());
	    
	    

           Route route = new Route(routeId, routeShortName, routeLongName, routeType);
	   route.setParsedAgencyId(agencyId);
	   
	    return route;
	} catch (Exception ex) {
	    Logger.getLogger(RouteFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}
