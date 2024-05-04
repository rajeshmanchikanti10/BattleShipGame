package org.phonepe.battleship.repository;

import org.phonepe.battleship.models.BattleShipGame;

import java.util.HashMap;

public class BattleShipRepoImpl implements  BattleShipRepo {
    private HashMap<String, BattleShipGame> games = new HashMap<>();

    @Override
    public String createGame(BattleShipGame battleShipGame) {
        games.put(battleShipGame.getId(), battleShipGame);
        return battleShipGame.getId();
    }

    @Override
    public BattleShipGame getGame(String id) {
        return games.get(id);
    }

    @Override
    public String updateGame(BattleShipGame game) {
        games.put(game.getId(),game);
        return game.getId();
    }

}
