package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

public interface RoomDaoCustom {

    Room findByName(String name);
}
