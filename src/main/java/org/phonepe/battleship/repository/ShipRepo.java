package org.phonepe.battleship.repository;

import org.phonepe.battleship.models.Ship;

public interface ShipRepo {
    public Ship addShip(Ship ship);
    public Ship getShip(String shipId);
}
