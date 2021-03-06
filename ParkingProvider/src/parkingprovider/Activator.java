package parkingprovider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;


public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Parking Service Started");
		ParkingServiceFacotry parkingServiceFacotry = new ParkingServiceFacotry();
		serviceRegistration = bundleContext.registerService(ParkingServiceFacotry.class.getName(), parkingServiceFacotry, null);
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Parking Service Stopped");
		serviceRegistration.unregister();
	}
}
