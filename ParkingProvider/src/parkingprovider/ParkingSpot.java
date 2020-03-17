package parkingprovider;

import java.util.Date;

public class ParkingSpot {
	private String Location;
	private boolean vehicleParked;
	private Date parkedDate;
	private Date departedDate;

	public ParkingSpot(String location) {
		super();
		Location = location;
		vehicleParked = false;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public boolean isVehicleParked() {
		return vehicleParked;
	}

	public void setVehicleParked(boolean vehicleParked) {
		this.vehicleParked = vehicleParked;
	}
	
	public void display() {
		System.out.println(Location);
	}

	public Date getParkedDate() {
		return parkedDate;
	}

	public void setParkedDate(Date parkedDate) {
		this.parkedDate = parkedDate;
	}

	public Date getDepartedDate() {
		return departedDate;
	}

	public void setDepartedDate(Date departedDate) {
		this.departedDate = departedDate;
	}
	


	
}
