package org.phonepe.battleship.service;

import org.phonepe.battleship.dtos.BattleShipRequest;
import org.phonepe.battleship.dtos.ShipRequest;
import org.phonepe.battleship.exceptions.AddShipException;
import org.phonepe.battleship.exceptions.GameNotFoundException;
import org.phonepe.battleship.models.BattleShipGame;
import org.phonepe.battleship.models.Ship;
import org.phonepe.battleship.repository.BattleShipRepo;
import org.phonepe.battleship.repository.ShipRepo;
import org.phonepe.battleship.visitors.FireMissileVisitor;
import org.phonepe.battleship.visitors.RandomFireMissileVisitorImpl;

import static java.util.Objects.isNull;

public class BattleShipService {
    BattleShipRepo battleShipRepo;
    ShipRepo shipRepo;
    public  BattleShipService(BattleShipRepo battleShipRepo,ShipRepo shipRepo) {
        this.battleShipRepo = battleShipRepo;
        this.shipRepo = shipRepo;
    }
    private  boolean isNullSquare(ShipRequest shipRequest,String[][] grid){
        int size= shipRequest.getLength();
        int xCoordinate = shipRequest.getxCoordinate();
        int yCoordinate = shipRequest.getyCoordinate();
        for(int x=xCoordinate;x<(xCoordinate+size);x++){
            for(int y=yCoordinate;y<(yCoordinate+size);y++){
                if(grid[x][y]!=null)
                        return false;
            }
        }
        return true;
    }
    private void placeShip(ShipRequest shipRequest,String[][] grid,String id){
        int size= shipRequest.getLength();
        int xCoordinate = shipRequest.getxCoordinate();
        int yCoordinate = shipRequest.getyCoordinate();
        for(int x=xCoordinate;x<xCoordinate+size;x++){
            for(int y=yCoordinate;y<yCoordinate+size;y++){
                grid[x][y] = id;
            }
        }
    }

    private void updateFieldWithShip(BattleShipGame battleShipGame,ShipRequest shipRequest,String shipId) throws AddShipException {
        char player = shipRequest.getPlayer();
        int startColumn,endColumn;
        int fieldLength = battleShipGame.getBattleShipSize();
        int shipSize = shipRequest.getLength();

        int shipStartX = shipRequest.getxCoordinate();
        int shipEndX = shipRequest.getxCoordinate() + shipSize-1;
        int shipStartY = shipRequest.getyCoordinate();
        int shipEndY = shipRequest.getyCoordinate() + shipSize-1;

        if(player=='A'){
            startColumn = 0;
            endColumn = fieldLength%2!=0? fieldLength/2: fieldLength/2-1;
        }
        else{
            startColumn = fieldLength%2!=0? fieldLength/2+1: fieldLength/2;;
            endColumn = fieldLength-1;
        }

        //if ship goes out of bound
        if(shipStartX<0 || shipEndX > fieldLength || shipStartY < startColumn || shipEndY > endColumn)
            throw  new AddShipException("Ship doesn't fit in the battle field");


        if(isNullSquare(shipRequest,battleShipGame.getBattleField())){
            placeShip(shipRequest,battleShipGame.getBattleField(),shipId);
        }
            else{
                throw new AddShipException("Already ship exists at given coordinates");
        }

    }



    public String initGame(BattleShipRequest battleShipRequest){
        if(isNull(battleShipRequest)){
            return "Invalid Data";

        }
        BattleShipGame battleShipGame = battleShipRequest.createBattleShipGameDTO(battleShipRequest);
        String battleShipGameId = battleShipRepo.createGame(battleShipGame);
        return String.format("Game %s created", battleShipGameId);
    }
    public BattleShipGame getGame(String id) throws GameNotFoundException {
       BattleShipGame battleShipGame = battleShipRepo.getGame(id);
       if(isNull(battleShipGame))
           throw  new GameNotFoundException(id);
       return battleShipGame;
    }

    public String addShip(String gameId,ShipRequest shipRequest) throws AddShipException, GameNotFoundException {
        if(isNull(shipRequest)){
            return "Invalid Data";
        }
        if(battleShipRepo.getGame(gameId)==null)
            throw new GameNotFoundException(gameId);

        Ship ship = shipRequest.createShipDTO(shipRequest);
        Ship insertedShip = shipRepo.addShip(ship);
        BattleShipGame battleShipGame = battleShipRepo.getGame(gameId);
        if(shipRequest.getPlayer()=='A')
            battleShipGame.getPlayerA_fleet().add(insertedShip);
        else
            battleShipGame.getPlayerB_fleet().add(insertedShip);

        updateFieldWithShip(battleShipGame,shipRequest,ship.getShipId());
        battleShipRepo.updateGame(battleShipGame);
        return  String.format("Added  %s ship successfully", insertedShip.getShipId());
    }
    public void startGame(String id) throws GameNotFoundException {
        BattleShipGame game= getGame(id);
        FireMissileVisitor randomFireVistor = new RandomFireMissileVisitorImpl();
        while(!game.isGameOver())
            randomFireVistor.RandomFiredVisitor(game);



    }
    public void viewBattleField(BattleShipGame battleShipGame){
        for(int i=0;i<battleShipGame.getBattleShipSize();i++){
            for(int j=0;j<battleShipGame.getBattleShipSize();j++){
                System.out.print(battleShipGame.getBattleField()[i][j]+" ");
            }
            System.out.println();
        }
    }

}
