package parkingprovider;

import java.util.ArrayList;

public class ParkingServiceImpl implements ParkingService {

	private String locationPerkingService;
	private ArrayList<ParkingSpot> parkingSpotsInThePark;
	private double pricePerHour;


	private ArrayList<ParkingSpot> parkingSpotsProvidedToVehicle;
	
	

	@Override
	public String getLocationPerkingService() {
		
		return locationPerkingService.toLowerCase();
	}

	public ParkingServiceImpl(String location, ArrayList<ParkingSpot> parkingSpotList, double pricePerHour) {
		locationPerkingService = location;
		parkingSpotsInThePark = parkingSpotList;
		this.pricePerHour = pricePerHour;
	}

	@Override
	public int getAvailableParkingSpotsCount() {
		int count = 0;
		for (ParkingSpot parkingspot : parkingSpotsInThePark) {
			if (!parkingspot.isVehicleParked()) {
				count = count + 1;
			}
		}
		return count;
	}

	@Override
	public ArrayList<ParkingSpot> AvailableParkingSpots() {
		ArrayList<ParkingSpot> availableParkingSpots = new ArrayList<ParkingSpot>();
		for (ParkingSpot parkingSpot : parkingSpotsInThePark) {
			if (!parkingSpot.isVehicleParked()) {
				availableParkingSpots.add(parkingSpot);
			}
		}
		return availableParkingSpots;
	}

	@Override
	public ArrayList<ParkingSpot> FilledParkingSpots() {
		ArrayList<ParkingSpot> filledParkingSpots = new ArrayList<ParkingSpot>();
		for (ParkingSpot parkingSpot : parkingSpotsInThePark) {
			if (!parkingSpot.isVehicleParked()) {
				filledParkingSpots.add(parkingSpot);
			}
		}
		return filledParkingSpots;
	}

	@Override
	public ParkingSpot getParkingSpotToPark() {
		if (getAvailableParkingSpotsCount() > 0) {
			parkingSpotsProvidedToVehicle = AvailableParkingSpots();
			ParkingSpot returnedToUser = parkingSpotsProvidedToVehicle.get(0);
			parkingSpotsProvidedToVehicle.remove(returnedToUser);
			return returnedToUser;
		} else {
			return null;
		}
	}

	@Override
	public ParkingSpot getAnotherParkingSpotToPark() {
		if (parkingSpotsProvidedToVehicle.size() > 0) {
			return getParkingSpotToPark();
		} else {
			return AvailableParkingSpots().get(0);
		}
	}

}
