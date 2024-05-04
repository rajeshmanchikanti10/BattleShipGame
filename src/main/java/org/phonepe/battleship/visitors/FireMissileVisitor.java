package org.phonepe.battleship.visitors;

import org.phonepe.battleship.models.BattleShipGame;
import org.phonepe.battleship.models.Ship;

import java.util.List;

public interface FireMissileVisitor {
    public void RandomFiredVisitor(BattleShipGame game);

    boolean checkHit(int targetX,int targetY,List<Ship> fleet);
    void checkWin(char player,BattleShipGame game);





}
