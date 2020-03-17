package parkingprovider;


import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ParkingServiceFacotry{
	private ArrayList<ParkingService> ParkingServiceList ;
	
	public ParkingServiceFacotry(){
		ArrayList<ParkingSpot> parkingSpotList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ParkingSpot parkingSpot = new ParkingSpot("spot" + i);
			parkingSpotList.add(parkingSpot);
		}
		ParkingServiceList= new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			ParkingService parkingService = new ParkingServiceImpl("a" + i, parkingSpotList, 100.0);
			
			ParkingServiceList.add(parkingService);
		}
	}

	public ParkingService getParkingService(String location) {
		for(ParkingService parkingService:ParkingServiceList) {
			if(parkingService.getLocationPerkingService().equals(location.toLowerCase())) {
				return parkingService;
			}
		}
		return null;
	}
}
