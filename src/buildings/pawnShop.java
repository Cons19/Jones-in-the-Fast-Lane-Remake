package buildings;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import static buildings.consoleColors.*;
import static buildings.player.inventoryList;

public class pawnShop extends buildings.store {
    // is the building where the player can buy new items and increase the wealth but also the happiness and the player can also get money by selling
    // his own items and he can buy them back at a higher price(25% higher)
    Scanner in = new Scanner(System.in);
    public static List<buildings.items> pawnShopList = new ArrayList<buildings.items>(); // array list with the available items on the pawnshop


    public pawnShop(){

    }

    public void menu() {
        setPawnShopInventory(); // populate the pawnshop array list
        System.out.println("\nYou are inside --> " + ANSI_RED + "The Pawn Shop" + ANSI_RESET + " <--\n");
        do {
            System.out.println("Welcome to the pawn shop:\n1) Buy\n2) Sell\n3) Exit pawn shop");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();

            if (user == 1) {
                buyItem();
            }
            if (user == 2) {
                sellItem();
            }
            if (user == 3) {
                System.out.println(ANSI_CYAN + "... You left the pawn shop ...\n\n");
                setGoal();
                exitBuildingMessage();
                break;
            }
        } while (true);
    }

    public void setPawnShopInventory() { // add to the pawnshop list the available items
        buildings.items item1 = new buildings.items("Clothes",250);
        buildings.items item2 = new buildings.items("Computer",3500);
        buildings.items item3 = new buildings.items("Microwave",500);
        buildings.items item4 = new buildings.items("Fridge", 800);
        buildings.items item5 = new buildings.items("Smartphone", 2000);
        buildings.items item6 = new buildings.items("Stereo", 400);
        buildings.items item7 = new buildings.items("Tablet", 1000);
        buildings.items item8 = new buildings.items("Laptop",2500);
        buildings.items item9 = new buildings.items("TV",1500);

        pawnShopList.add(item1);
        pawnShopList.add(item2);
        pawnShopList.add(item3);
        pawnShopList.add(item4);
        pawnShopList.add(item5);
        pawnShopList.add(item6);
        pawnShopList.add(item7);
        pawnShopList.add(item8);
        pawnShopList.add(item9);

    }

    public void buyItem() {
        for (int i = 0; i < pawnShopList.size(); i++)
        {
            System.out.println(i +") "+pawnShopList.get(i).itemName +"..................\t$"+ pawnShopList.get(i).itemPrice ); // search and show the pawn shop inventory list
        }
        while (!in.hasNextInt()) {
            String input = in.next();
            System.out.println(ANSI_RED);
            System.out.printf("%s is not a valid number.\n", input);
            System.out.println(ANSI_RESET);
        }
        int itemNumber=in.nextInt();
        if(itemNumber>=0 && itemNumber<pawnShopList.size()) { // verify the user input range
            if (player.getMoney() - pawnShopList.get(itemNumber).itemPrice > 0) {
                player.setMoney(player.getMoney() - (pawnShopList.get(itemNumber).itemPrice + pawnShopList.get(itemNumber).itemPrice * 0.25));
                inventoryList.add(pawnShopList.get(itemNumber)); // add the item to the inventory list
                pawnShopList.remove(itemNumber); // remove the item from the pawn shop list
                if(player.getHappiness()<player.getHappinessGoalInput()) { // the happiness increase only if it is lower than the set happiness goal
                    player.setHappiness(player.getHappiness() + 1);
                    System.out.println("Happiness goal +1");
                }
                else
                    System.out.println("You have already completed the happiness goal!");
                if(player.getWealth()<player.getWealthGoalInput()) { // the wealth increase only if it is lower than the set wealth goal
                    player.setWealth(player.getWealth() + 10);
                    System.out.println("Wealth goal +10");
                }
                else
                    System.out.println("You have already completed the wealth goal!");
            } else
                System.out.println("You do not have enough money!");
        }
        else
            System.out.println("Wrong input!");
    }

    public void sellItem() {
        for (int i = 0; i < inventoryList.size(); i++)
        {
            System.out.println(i +") "+inventoryList.get(i).itemName +"..................\t$"+ inventoryList.get(i).itemPrice); // search and show the player inventory list
        }
        while (!in.hasNextInt()) {
            String input = in.next();
            System.out.println(ANSI_RED);
            System.out.printf("%s is not a valid number.\n", input);
            System.out.println(ANSI_RESET);
        }
        int itemNumber=in.nextInt();
        if(itemNumber>=0 && itemNumber<inventoryList.size()) { // verify the user input range
            player.setMoney(player.getMoney() + inventoryList.get(itemNumber).itemPrice); // increase the money ith the value of the sold item
            pawnShopList.add(inventoryList.get(itemNumber)); // add a item from the player inventory to pawn shop list
            pawnShopList.get(pawnShopList.size() - 1).itemPrice += pawnShopList.get(pawnShopList.size() - 1).itemPrice * 0.25; // increase the price of the new pawnshop list item
            inventoryList.remove(itemNumber); // remove the item from the player inventory list
            if(player.getHappiness()>0) { // decrease happines if possible
                player.setHappiness(player.getHappiness() - 1);
                System.out.println("Happiness goal -1");
            }
            else
                System.out.println("You have already the minimum goal of happiness!");
            if(player.getWealth()>0) { // decrease wealth if possible
                player.setWealth(player.getWealth() - 10);
                System.out.println("Wealth goal -10");
            }
            else
                System.out.println("You have already the minimum goal of wealth");
        }
        else
            System.out.println("Wrong input!");

    }

}
