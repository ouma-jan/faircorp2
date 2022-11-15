package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;


/**
 * Data Transfer room that are published back to the client.
 */
public class RoomDto {

    private Long id;


    private int floor;

    private String name;

    private Double currentTemperature;
    private Double targetTemperature;
    private Long buildingId;



    public RoomDto() {
    }

    public RoomDto(Room room){
        this.id=room.getId();
        this.name=room.getName();
        this.floor=room.getFloor();
        this.currentTemperature=room.getCurrentTemperature();
        this.targetTemperature=room.getTargetTemperature();
        this.buildingId=room.getBuilding().getId();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
}
