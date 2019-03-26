package customerpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	ServiceRegistration publicServiceRegistration ;

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Starting Customer Management Service");
		publicServiceRegistration = bundleContext.registerService(CustomerPublish.class.getName(),new CustomerPublisherImpl(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		//Activator.context = null;
		System.out.println("Stop Customer Management Service");
		publicServiceRegistration.unregister();
	}

}
