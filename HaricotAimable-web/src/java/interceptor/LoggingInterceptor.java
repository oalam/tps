/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

    private static final Logger logger = Logger.getLogger("com.oalam");

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
	//System.out.println("enter logmethod");
	logger.log(Level.INFO, "enter " + ic.getTarget().toString() + "." +
		ic.getMethod().getName());
	try {
	    return ic.proceed();
	} finally {
	    logger.log(Level.INFO, "exit " + ic.getTarget().toString()+ "." +
		    ic.getMethod().getName());

	}
    }
}