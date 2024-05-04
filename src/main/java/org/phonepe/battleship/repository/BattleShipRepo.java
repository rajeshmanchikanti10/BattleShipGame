package org.phonepe.battleship.repository;

import org.phonepe.battleship.models.BattleShipGame;

public interface BattleShipRepo {
    public String createGame(BattleShipGame game);
    public BattleShipGame getGame(String gameId);
    public String updateGame(BattleShipGame game);

}
