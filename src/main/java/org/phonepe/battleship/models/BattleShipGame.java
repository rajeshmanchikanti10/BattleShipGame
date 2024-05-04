package org.phonepe.battleship.models;

import lombok.Data;
import org.phonepe.battleship.visitors.FireMissileVisitor;

import java.util.List;
import java.util.Set;
@Data
public class BattleShipGame {
    private String id;
    private Integer battleFieldSize;
    private String[][] battleField;
    private List<Ship> playerA_fleet;
    private List<Ship> playerB_fleet;
    Set<Integer> firedXCoordinates, firedYCoordinates;
    private char currentPlayer;
    private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getId() {
        return this.id;
    }

    public String[][] getBattleField() {
        return this.battleField;
    }

    public Integer getBattleShipSize() {
        return this.battleFieldSize;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBattleShipSize(Integer n) {
        this.battleFieldSize = n;
    }

    public void setBattleField(String[][] battleField) {
        this.battleField = battleField;
    }

    public Set<Integer> getFiredYCoordinates() {
        return firedYCoordinates;
    }

    public Set<Integer> getFiredXCoordinates() {
        return firedXCoordinates;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Ship> getPlayerA_fleet() {
        return playerA_fleet;
    }

    public List<Ship> getPlayerB_fleet() {
        return playerB_fleet;
    }

    public void setPlayerA_fleet(List<Ship> playerA_fleet) {
        this.playerA_fleet = playerA_fleet;
    }

    public void setPlayerB_fleet(List<Ship> playerB_fleet) {
        this.playerB_fleet = playerB_fleet;
    }

    public void setFiredXCoordinates(Set<Integer> firedXCoordinates) {
        this.firedXCoordinates = firedXCoordinates;
    }

    public void setFiredYCoordinates(Set<Integer> firedYCoordinates) {
        this.firedYCoordinates = firedYCoordinates;
    }

    public void fireMissle(FireMissileVisitor fireMissileVisitor, BattleShipGame battleShipGame){
        fireMissileVisitor.RandomFiredVisitor(this);
    }
}

