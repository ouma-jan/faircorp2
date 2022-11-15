package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;


/**
 * Data Transfer heater that are published back to the client.
 */
public class HeaterDto {

    private Long id;
    private String name;

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    private HeaterStatus heaterStatus;
    private Long power;
    private String roomName;
    private Long roomId;


    public HeaterDto() {
    }
    public HeaterDto(Heater heater) {
        this.id=heater.getId();
        this.name=heater.getName();
        this.heaterStatus=heater.getHeaterStatus();
        this.roomId=heater.getRoom().getId();
        this.roomName=heater.getRoom().getName();
        this.power=heater.getPower();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
