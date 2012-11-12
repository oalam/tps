/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.text.StrTokenizer;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author tom
 */
public abstract class AbstractFileParser<T> {

    public abstract T createEntity(StrTokenizer line);
    
    public static String cleanup(String str, boolean doRemoveQuote,
	    boolean doInternalWordCapitalization) {

	String result = str;


	// remove "
	if (doRemoveQuote) {
	    result = str.toString().replace("\"", "").replace("\\'", "\'");
	}


	// capitalize first letters of each words
	if (doInternalWordCapitalization) {
	    
	    /*
	    StringBuilder b = new StringBuilder(result.toLowerCase());
	    int i = 0;
	    do {
		b.replace(i, i + 1, b.substring(i, i + 1).toUpperCase());
		i = b.indexOf(" ", i) + 1;
	    } while (i > 0 && i < b.length());

	    result = b.toString();

*/
	    char[] delims = {' ', '\''};
	    result = WordUtils.capitalizeFully(result, delims);
	    
	    String[] specials = {"Via", "De", "En", "La", "Sur", "L\'", "D\'"};
	    for (String replace : specials) {
		result = result.replace(replace, replace.toLowerCase());
	    }
	}




	return result;
    }

    public List<T> parseFile(String filePath) {
	List<T> result = new ArrayList<T>();
	
	InputStreamReader isr = null;
	BufferedReader bsr = null;
	try {
	    isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
	    bsr = new BufferedReader(isr);   
	    
	   // bsr = new BufferedReader(new FileReader(filePath));

	    int nblines = 0;
	    String line;
	    while ((line = bsr.readLine()) != null) {
		// don't parse the first line of csv
		if (nblines != 0) {
		    StrTokenizer tokenizer = new StrTokenizer(line, ",");
		    tokenizer.setIgnoreEmptyTokens(false);
		    T o = createEntity(tokenizer);
		    if (o != null) {
			result.add(o);
		    }
		} else {
		    nblines++;
		}
	    }

	} catch (FileNotFoundException ex) {
	    Logger.getLogger(AbstractFileParser.class.getName()).log(Level.SEVERE, null, ex);
	} catch (IOException ex) {
	    Logger.getLogger(AbstractFileParser.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		bsr.close();
	    } catch (IOException ex) {
		Logger.getLogger(AbstractFileParser.class.getName()).log(Level.SEVERE, null, ex);
	    }

	}
	return result;


    }
}
