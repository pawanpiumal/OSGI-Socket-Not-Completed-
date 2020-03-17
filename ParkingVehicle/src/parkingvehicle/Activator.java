package parkingvehicle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import parkingprovider.Handler;
import parkingprovider.ParkingService;
import parkingprovider.ParkingServiceFacotry;
import parkingprovider.ParkingServiceImpl;
import parkingprovider.ParkingSpot;

public class Activator  implements BundleActivator {

	private static final int PORT = 9001;
	ServiceReference serviceReference;
	BufferedReader in;
	PrintWriter out;


	public void start(BundleContext bundleContext) throws Exception {
//		String serverAddress = "localhost";
//		Socket socket = new Socket(serverAddress, 9001);
//		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//		out = new PrintWriter(socket.getOutputStream(), true);
//		while(true) {
//			String lineIn = in.readLine();
//			System.out.println(lineIn);
//		}
		
		serviceReference = bundleContext.getServiceReference(ParkingServiceFacotry.class.getName());
		ParkingServiceFacotry parkingServiceFacotry = (ParkingServiceFacotry) bundleContext.getService(serviceReference);
		
		ParkingService parkingService = parkingServiceFacotry.getParkingService("a2");
		System.out.println(parkingService.getLocationPerkingService());
		
		ServerSocket listener = new ServerSocket(PORT);
		try {
			while (true) {
				Socket socket = listener.accept();
				Thread handlerThread = new Thread(new Handler(socket));
				handlerThread.start();
			}
		} finally {
			listener.close();
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Subs stop");
	}

}
