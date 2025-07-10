package com.demosourav.model;

public class RoomUsageReport {
	public String roomName;
    public int totalBookings;
    public int totalHours;
    public double utilizationPercentage;
	
    public RoomUsageReport() {
		
	}

	public RoomUsageReport(String roomName, int totalBookings, int totalHours, double utilizationPercentage) {
		super();
		this.roomName = roomName;
		this.totalBookings = totalBookings;
		this.totalHours = totalHours;
		this.utilizationPercentage = utilizationPercentage;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getTotalBookings() {
		return totalBookings;
	}

	public void setTotalBookings(int totalBookings) {
		this.totalBookings = totalBookings;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public double getUtilizationPercentage() {
		return utilizationPercentage;
	}

	public void setUtilizationPercentage(double utilizationPercentage) {
		this.utilizationPercentage = utilizationPercentage;
	}
    
    
    
    

}
