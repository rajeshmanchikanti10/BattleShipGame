package org.phonepe.battleship.visitors;

import org.phonepe.battleship.models.BattleShipGame;
import org.phonepe.battleship.models.Ship;

import java.util.List;

public abstract class AFireMissile implements FireMissileVisitor {
    public boolean checkHit(int targetX, int targetY, List<Ship> fleet) {
        for (Ship ship : fleet) {
            int x = ship.getxCoordinate();
            int y = ship.getyCoordinate();
            if (x <= targetX && targetX < x + ship.getLength() && y <= targetY && targetY < y + ship.getLength()) {
                fleet.remove(ship);
                return true;
            }
        }
        return false;
    }

    public void checkWin(char player, BattleShipGame game) {
        if (player == 'A' && game.getPlayerB_fleet().isEmpty()) {
            System.out.println("Player A wins");
            game.setGameOver(true);
        } else if (player == 'B' && game.getPlayerA_fleet().isEmpty()) {
            System.out.println("Player B wins");
            game.setGameOver(true);
        }
    }
}
