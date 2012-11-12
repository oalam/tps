/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author tom
 */
public class TransitServiceFactory {

    private static TransitService service = new JpaTransitService();

    public static TransitService getService() {
	return service;
    }

    public static void main(String[] args) {


	service.importGtfsArchive("setup/export-TN-GTFS-LAST.zip");
    }
}
