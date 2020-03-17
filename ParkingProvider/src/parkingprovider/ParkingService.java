package parkingprovider;

import java.util.ArrayList;


public interface ParkingService {

	public int getAvailableParkingSpotsCount();
	
	public ArrayList<ParkingSpot> AvailableParkingSpots();
	public ArrayList<ParkingSpot> FilledParkingSpots();
	public String getLocationPerkingService();
	public ParkingSpot getParkingSpotToPark();
	
	public ParkingSpot getAnotherParkingSpotToPark();
	
	
}
