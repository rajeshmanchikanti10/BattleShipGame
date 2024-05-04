package org.phonepe.battleship.dtos;

import org.phonepe.battleship.models.Ship;

public class ShipRequest {
    private int length; //assuming length not exceeds in size
    private int xCoordinate, yCoordinate;
    private int shipNumber;
    private char player;

    public ShipRequest(int length,int xCoordinate,int yCoordinate){
        this.length = length;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public Ship createShipDTO(ShipRequest shipRequest){
        Ship ship = new Ship();
        System.out.println(player);
        ship.setShipId(String.format("%c-SH%d",player,shipNumber));
        ship.setLength(shipRequest.getLength());
        ship.setxCoordinate(shipRequest.getxCoordinate());
        ship.setyCoordinate(shipRequest.getyCoordinate());
        return ship;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public char getPlayer() {
        return player;
    }

    public int getShipNumber() {
        return shipNumber;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    public void setShipNumber(int shipNumber) {
        this.shipNumber = shipNumber;
    }
}
