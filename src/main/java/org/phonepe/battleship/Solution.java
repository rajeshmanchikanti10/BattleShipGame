package org.phonepe.battleship;

import org.phonepe.battleship.dtos.BattleShipRequest;
import org.phonepe.battleship.dtos.ShipRequest;
import org.phonepe.battleship.repository.BattleShipRepoImpl;
import org.phonepe.battleship.repository.ShipRepoImpl;
import org.phonepe.battleship.service.BattleShipService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Solution {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        BattleShipService  battleShipService = new BattleShipService(new BattleShipRepoImpl(),new ShipRepoImpl());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while(flag){
            try{
                System.out.println("Select One Of The following");
                System.out.println("1.Create Game");
                System.out.println("2. Add ship");
                System.out.println("3 start Game");
                System.out.println("4 view Battle field");
                Integer choice = Integer.parseInt(br.readLine());
                String[] inputs;
                switch (choice){
                    case 1: {
                        System.out.println("Enter battleField size");
                        Integer battleFieldLength = Integer.parseInt(br.readLine());
                        BattleShipRequest battleShipRequest = new BattleShipRequest(battleFieldLength);
                        System.out.println(battleShipService.initGame(battleShipRequest));
                        break;
                    }

                    case 2: {
                        System.out.println("Enter gameId");
                        String gameId = br.readLine().trim();
                        System.out.println("Enter ship length,and ship coordinates");
                        inputs = br.readLine().split(",");

                        ShipRequest shipRequest = new ShipRequest(Integer.parseInt(inputs[0].trim()), Integer.parseInt(inputs[1].trim()), Integer.parseInt(inputs[2].trim()));
                        System.out.println("Enter ship number and player");
                        inputs = br.readLine().split(",");
                        shipRequest.setPlayer( inputs[1].trim().toCharArray()[0]);
                        shipRequest.setShipNumber(Integer.parseInt(inputs[0].trim()));
                        System.out.println(battleShipService.addShip(gameId, shipRequest));
                        break;
                    }
                    case 3:
                        System.out.println("Enter GameId");
                        String input = br.readLine();
                        battleShipService.startGame(input.trim());

                       break;
                    case 4:{
                        System.out.println("Enter battleId");
                        input = br.readLine();
                        battleShipService.viewBattleField(battleShipService.getGame(input.trim()));
                        break;
                    }
                    case 5:
                        flag= false;
                        break;
                    default:
                        System.out.println("Wrong choice enter again");

                }


            }
            catch (Exception e){
                System.out.println("Something went wrong please try again."+e.getMessage());
            }
        }

    }
}