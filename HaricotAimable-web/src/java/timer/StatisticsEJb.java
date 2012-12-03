/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

//@Stateless
public class StatisticsEJb {

    @Schedule(dayOfMonth = "1", hour = "5", minute = "30")
    public void statisticsItemsSold() {
	// ...
    }

    @Schedules({
	@Schedule(hour = "2"),
	@Schedule(hour = "14", dayOfWeek = "Wed")
    })
    public void generateReport() {
// ...
    }

    @Schedule(minute = "*/1", hour = "*", persistent = false)
    public void refreshCache() {
	System.out.println("refresh = " );
// ... 
    }
    
}