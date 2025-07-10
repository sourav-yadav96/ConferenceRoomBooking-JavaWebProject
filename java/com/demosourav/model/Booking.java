package com.demosourav.model;

public class Booking {
	
	public int id;
	public int userId;
	public int roomId;
	public String startTime;   // Format: "YYYY-MM-DD HH:MM:SS"
	public String endTime;     // Format: "YYYY-MM-DD HH:MM:SS"
	public String booking_date;
	public String booking_time;
	public int capacity;
	public String equipment;
	public String purpose;
	public String specialRequests;
	public String status;      // Pending, Approved, Cancelled, Rescheduled
	
	
	public Booking() {
	
	}


	public Booking(int id, int userId, int roomId, String startTime, String endTime, String booking_date,
			String booking_time, int capacity, String equipment, String purpose, String specialRequests,
			String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.roomId = roomId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.booking_date = booking_date;
		this.booking_time = booking_time;
		this.capacity = capacity;
		this.equipment = equipment;
		this.purpose = purpose;
		this.specialRequests = specialRequests;
		this.status = status;
	}


	public Booking(int id, int roomId, String booking_date, String startTime, String endTime, String status) {
		super();
		this.id = id;
		this.roomId = roomId;
		this.booking_date=booking_date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRoomId() {
		return roomId;
	}


	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getBooking_date() {
		return booking_date;
	}


	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}


	public String getBooking_time() {
		return booking_time;
	}


	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public String getEquipment() {
		return equipment;
	}


	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public String getSpecialRequests() {
		return specialRequests;
	}


	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
