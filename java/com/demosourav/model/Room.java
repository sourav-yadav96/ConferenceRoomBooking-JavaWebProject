package com.demosourav.model;

public class Room {
	
	public int id;
	public String name;
    public int capacity;
    public String features; // e.g., "Projector,Whiteboard"
    public String status;   // Available / Unavailable
    public boolean projector;
    public boolean whiteboard;
	
    public Room() {
    	
	}

	public Room(int id, String name, int capacity, String features) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.features = features;
	}



	public Room(int id, String name, int capacity, String features, String status, boolean projector,
			boolean whiteboard) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.features = features;
		this.status = status;
		this.projector = projector;
		this.whiteboard = whiteboard;
	}

	public Room(int id, String name, int capacity, boolean projector, boolean whiteboard) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.projector = projector;
		this.whiteboard = whiteboard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	public boolean isWhiteboard() {
		return whiteboard;
	}

	public void setWhiteboard(boolean whiteboard) {
		this.whiteboard = whiteboard;
	}
    

}
