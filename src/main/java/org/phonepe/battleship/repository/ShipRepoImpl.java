package org.phonepe.battleship.repository;

import org.phonepe.battleship.models.Ship;

import java.util.HashMap;

public class ShipRepoImpl implements  ShipRepo{
    HashMap<String,Ship> ships = new HashMap<>();
    @Override
    public Ship addShip(Ship ship) {
       ships.put(ship.getShipId(),ship);
       return ships.get(ship.getShipId());
    }

    @Override
    public Ship getShip(String shipId) {
       return ships.get(shipId);
    }
}
