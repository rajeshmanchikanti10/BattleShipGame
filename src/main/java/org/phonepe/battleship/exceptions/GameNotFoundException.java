package org.phonepe.battleship.exceptions;

public class GameNotFoundException extends  Exception{
    private String gameId;
    public GameNotFoundException(String gameId){
        super("Game Not Found:"+gameId);
       this.gameId = gameId;
    }
    public String getGameId(){
        return this.gameId;
    }
    @Override
    public String toString() {
        return "AssetNotFoundException: Asset not found - " + gameId;
    }
}
