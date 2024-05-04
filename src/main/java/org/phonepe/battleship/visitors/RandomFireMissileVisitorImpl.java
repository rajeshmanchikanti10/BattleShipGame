package org.phonepe.battleship.visitors;

import org.phonepe.battleship.models.BattleShipGame;

import java.util.Random;

public class RandomFireMissileVisitorImpl extends AFireMissile implements  FireMissileVisitor{

    @Override
    public void RandomFiredVisitor( BattleShipGame battleShipGame) {

        Random random = new Random();
        int targetX, targetY;
        if (battleShipGame.getCurrentPlayer() == 'A') {
            do {
                targetX = random.nextInt(battleShipGame.getBattleFieldSize());
                targetY = random.nextInt(battleShipGame.getBattleFieldSize() / 2) + battleShipGame.getBattleFieldSize() / 2;
            } while (battleShipGame.getFiredXCoordinates().contains(targetX) && battleShipGame.getFiredYCoordinates().contains(targetY));
            if (checkHit(targetX, targetY, battleShipGame.getPlayerB_fleet())) {
                System.out.println(battleShipGame.getPlayerB_fleet().size());
                System.out.println(String.format("Player A hit at %d,%d", targetX, targetY));
                checkWin('A', battleShipGame);
            } else {
                System.out.println(String.format("Player A miss at %d,%d", targetX, targetY));
            }
            battleShipGame.setCurrentPlayer('B');

        } else {
            do {
                targetX = random.nextInt(battleShipGame.getBattleFieldSize());
                targetY = random.nextInt(battleShipGame.getBattleFieldSize() / 2);

            } while (battleShipGame.getFiredXCoordinates().contains(targetX) && battleShipGame.getFiredYCoordinates().contains(targetY));
            if (checkHit(targetX, targetY, battleShipGame.getPlayerA_fleet())) {
                System.out.println(battleShipGame.getPlayerA_fleet().size());
                System.out.println(String.format("Player B hit at %d,%d", targetX, targetY));
                checkWin('B', battleShipGame);
            } else {
                System.out.println(String.format("Player B miss at %d,%d", targetX, targetY));
            }
            battleShipGame.setCurrentPlayer('A');
        }
        battleShipGame.getFiredXCoordinates().add(targetX);
        battleShipGame.getFiredYCoordinates().add(targetY);

    }
}
