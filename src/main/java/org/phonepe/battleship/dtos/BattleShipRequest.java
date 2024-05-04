package org.phonepe.battleship.dtos;

import org.phonepe.battleship.models.BattleShipGame;
import org.phonepe.battleship.models.Ship;

import java.util.*;

public class BattleShipRequest {
    private Integer battleFieldSize;
    private String[][] battleField ;
    private List<Ship> playerA_fleet;
    private List<Ship> playerB_fleet;
    Set<Integer> firedXCoordinates, firedYCoordinates;
    private char currentPlayer;
    private boolean gameOver;

    public  BattleShipRequest(Integer battleFieldSize){
        this.battleFieldSize  = battleFieldSize;
        this.playerA_fleet = new ArrayList<>();
        this.playerB_fleet = new ArrayList<>();
        this.firedXCoordinates = new HashSet<>();
        this.firedYCoordinates = new HashSet<>();
        this.battleField = new String[battleFieldSize][battleFieldSize];
        this.gameOver = false;
        this.currentPlayer = 'A';
    }

    public BattleShipGame createBattleShipGameDTO(BattleShipRequest battleShipRequest) {
        BattleShipGame battleShipGame = new BattleShipGame();
        battleShipGame.setId(UUID.randomUUID().toString());
        battleShipGame.setBattleShipSize(battleShipRequest.getBattleFieldSize());
        battleShipGame.setBattleField(battleShipRequest.getBattleField());
        battleShipGame.setPlayerA_fleet(battleShipRequest.getPlayerA_fleet());
        battleShipGame.setPlayerB_fleet(battleShipRequest.getPlayerB_fleet());
        battleShipGame.setFiredXCoordinates(battleShipRequest.getFiredXCoordinates());
        battleShipGame.setFiredYCoordinates(battleShipRequest.getFiredYCoordinates());
        battleShipGame.setCurrentPlayer(battleShipRequest.getCurrentPlayer());
        battleShipGame.setGameOver(battleShipGame.isGameOver());

        return battleShipGame;

    }

    public Integer getBattleFieldSize() {
        return battleFieldSize;
    }

    public void setBattleFieldSize(Integer battleFieldSize) {
        this.battleFieldSize = battleFieldSize;
    }

    public List<Ship> getPlayerA_fleet() {
        return playerA_fleet;
    }

    public List<Ship> getPlayerB_fleet() {
        return playerB_fleet;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public Set<Integer> getFiredXCoordinates() {
        return firedXCoordinates;
    }

    public Set<Integer> getFiredYCoordinates() {
        return firedYCoordinates;
    }

    public String[][] getBattleField() {
        return battleField;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
