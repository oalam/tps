/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import entity.Calendar;
import entity.CalendarPK;
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
public class CalendarDateFileParser extends AbstractFileParser<Calendar> {

    static boolean parseBool(String boolStr) {
	if (Integer.parseInt(boolStr) == 1) {
	    return true;
	} else {
	    return false;
	}

    }

    @Override
    public Calendar createEntity(StrTokenizer tokenizer) {
	try {
	    // service_id, date, exception_type
	    String serviceId = tokenizer.nextToken();
	    DateFormat df = new SimpleDateFormat("yyyyddMM");
	    Date startDate = df.parse(tokenizer.nextToken());
	    Integer exceptionType = Integer.parseInt(tokenizer.nextToken());

	    CalendarPK key = new CalendarPK(serviceId, startDate);
	    Calendar cal = new Calendar(key, false, false, false, false,
		    false, false, false);

	    cal.setExceptionType(exceptionType);

	    return cal;
	} catch (Exception ex) {
	    Logger.getLogger(parser.CalendarFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}