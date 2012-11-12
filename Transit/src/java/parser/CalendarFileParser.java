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
public class CalendarFileParser extends AbstractFileParser<Calendar> {

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
	    // service_id,monday,tuesday,wednesday,thursday,friday,saturday,sunday,start_date,end_date
	    String serviceId = tokenizer.nextToken();
	    boolean monday = parseBool(tokenizer.nextToken());
	    boolean tuesday = parseBool(tokenizer.nextToken());
	    boolean wednerday = parseBool(tokenizer.nextToken());
	    boolean thursday = parseBool(tokenizer.nextToken());
	    boolean friday = parseBool(tokenizer.nextToken());
	    boolean saturday = parseBool(tokenizer.nextToken());
	    boolean sunday = parseBool(tokenizer.nextToken());

	    DateFormat df = new SimpleDateFormat("yyyyddMM");
	    Date startDate = df.parse(tokenizer.nextToken());
	    Date endDate = df.parse(tokenizer.nextToken());

	    CalendarPK key = new CalendarPK(serviceId, startDate);
	    Calendar cal = new Calendar(key, monday, tuesday, wednerday, thursday,
		    friday, saturday, sunday);
	    cal.setEndDate(endDate);
	    
	    return cal;
	} catch (Exception ex) {
	    Logger.getLogger(CalendarFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    return null;
	}
    }
}