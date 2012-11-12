/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import entity.Agency;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.StrTokenizer;

/**
 *
 * @author tom
 */
public class AgencyFileParser extends AbstractFileParser<Agency> {

    @Override
    public Agency createEntity(StrTokenizer tokenizer) {
	try {
	    //agency_id,agency_name,agency_url,agency_timezone,agency_lang
	    String agencyId = tokenizer.nextToken();
	    String agencyName = cleanup(tokenizer.nextToken(), true, true);
	    String agencyUrl = tokenizer.nextToken();
	    String agencyTimezone = tokenizer.nextToken();
	    String agencyLang = tokenizer.nextToken();

	    return new Agency(agencyId, agencyName, agencyUrl, agencyTimezone, agencyLang);
	} catch (Exception ex) {
	    Logger.getLogger(AgencyFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}
