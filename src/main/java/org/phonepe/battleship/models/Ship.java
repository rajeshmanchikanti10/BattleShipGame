package org.phonepe.battleship.models;

public class Ship {
    private String shipId;
    private int length; //assuming length not exceeds in size
    private int xCoordinate, yCoordinate;

    public int getLength() {
        return length;
    }

    public String getShipId() {
        return shipId;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

}
