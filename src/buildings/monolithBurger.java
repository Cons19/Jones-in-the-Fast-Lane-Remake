package buildings;

import java.util.Scanner;
import static buildings.consoleColors.*;

public class monolithBurger extends buildings.store{
    // is the building where the player can eat and drink, activities that increase the happiness. Also the player can work here
    Scanner in = new Scanner(System.in);
    FoodAndDrinks price = new FoodAndDrinks();

    public int workActiveMessage=1; // used in case of the player have a job in the local building. If the player choose not to work and to use the building
    // options than the work option is no more available until the player exit and entry again in the building

    public monolithBurger() {

    }

    public void menu() {
        System.out.println("\nYou are inside --> " + ANSI_RED + "Monolith Burger" + ANSI_RESET + " <--\n");
        do {
            System.out.println("Welcome to monolith burger:\n");
            if(workActiveMessage==1 && activeWork==1) {
                while (player.getSteps() > 0) {
                    System.out.println("0) Work\n1) Monolith burger options/Exit");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    int workChoiceInput = in.nextInt();
                    if (workChoiceInput == 0) {
                        if (monolithCook == 1) {
                            System.out.println(" + 5$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 5);
                            player.setWorkExperience(player.getWorkExperience() + 1);

                        }
                        if (monolithClerk == 1) {
                            System.out.println(" + 6$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 6);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (monolithAssistantManager == 1) {
                            System.out.println(" + 8$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 8);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (monolithManager == 1) {
                            System.out.println(" + 9$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 9);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                    }
                    if (workChoiceInput == 1) {
                        workActiveMessage = 0;
                        break;
                    }
                }
            }
            noStepsMessage();
            System.out.println("1) Food and Drinks Menu\n2) Exit monolith burger");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();

            if (user == 1)
                FoodDrinksMenu();
            if (user == 2) {
                System.out.println(ANSI_CYAN + "... You left monolith burger ...\n\n");
                setGoal();
                exitBuildingMessage();
                workActiveMessage=1;
                break;
            }

        } while (true);

    }

    public void defaultPrices() {
        price.setHamBurgersPrice(91);
        price.setCheeseBurgersPrice(103);
        price.setAstroChickenPrice(143);
        price.setFriesPrice(74);
        price.setShakesPrice(117);
        price.setColasPrice(80);
    }

    public void FoodDrinksMenu() {
        defaultPrices();
        do {
            System.out.println("The food & drinks menu:");
            System.out.println("0) Done\n1) Hamburgers...............\t$"+price.getHamBurgersPrice()+"\n2) Cheeseburgers............\t$"+price.getCheeseBurgersPrice()+"\n3) Astro Chicken............\t$"+price.getAstroChickenPrice()+"\n4) Fries....................\t$"+price.getFriesPrice()+"\n5) Shakes...................\t$"+price.getShakesPrice()+"\n6) Colas....................\t$"+price.getColasPrice());
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();

            if (user == 0)
                break;
            if(player.getSteps()>0) {
                if (player.getMoney() > 75) {
                    if (user == 1) {
                        System.out.println("You have successfully bought a hamburger!");
                        player.setMoney(player.getMoney()-price.getHamBurgersPrice());
                        player.setSteps(player.getSteps()-10);
                        if(player.getHappiness()<player.getHappinessGoalInput()) // the happiness increase only if it is lower than the set happiness goal
                            player.setHappiness(player.getHappiness()+1);
                        else
                            System.out.println("You have already completed the happiness goal!");
                    }
                    if (user == 2) {
                        System.out.println("You have successfully bought a cheeseburger!");
                        player.setMoney(player.getMoney()-price.getCheeseBurgersPrice());
                        player.setSteps(player.getSteps()-10);
                        if(player.getHappiness()<player.getHappinessGoalInput())
                            player.setHappiness(player.getHappiness()+1);
                        else
                            System.out.println("You have already completed the happiness goal!");
                    }
                    if (user == 3) {
                        System.out.println("You have successfully bought an astro chicken!");
                        player.setMoney(player.getMoney()-price.getAstroChickenPrice());
                        player.setSteps(player.getSteps()-10);
                        if(player.getHappiness()<player.getHappinessGoalInput())
                            player.setHappiness(player.getHappiness()+1);
                        else
                            System.out.println("You have already completed the happiness goal!");
                    }
                    if (user == 4) {
                        System.out.println("You have successfully bought fries!");
                        player.setMoney(player.getMoney()-price.getFriesPrice());
                        player.setSteps(player.getSteps()-10);
                        if(player.getHappiness()<player.getHappinessGoalInput())
                            player.setHappiness(player.getHappiness()+1);
                        else
                            System.out.println("You have already completed the happiness goal!");
                    }
                    if (user == 5) {
                        System.out.println("You have successfully bought a shake!");
                        player.setMoney(player.getMoney()-price.getShakesPrice());
                        player.setSteps(player.getSteps()-10);
                        if(player.getHappiness()<player.getHappinessGoalInput())
                            player.setHappiness(player.getHappiness()+1);
                        else
                            System.out.println("You have already completed the happiness goal!");
                    }
                    if (user == 6) {
                        System.out.println("You have successfully bought a cola!");
                        player.setMoney(player.getMoney()-price.getColasPrice());
                        player.setSteps(player.getSteps()-10);
                        if(player.getHappiness()<player.getHappinessGoalInput())
                            player.setHappiness(player.getHappiness()+1);
                        else
                            System.out.println("You have already completed the happiness goal!");
                    }
                } else
                    System.out.println("You do not have enough money to buy food or drinks!");
            }
            else
                System.out.println("You have no more steps. You must sleep!");
        }while(true);
    }


}

class FoodAndDrinks { // controller used to get and to set the prices of the food
    int hamBurgersPrice;
    int cheeseBurgersPrice;
    int astroChickenPrice;
    int friesPrice;
    int shakesPrice;
    int colasPrice;

    // setters & getters
    public void setHamBurgersPrice(int hamBurgersPrice) {
        this.hamBurgersPrice = hamBurgersPrice;
    }

    public int getHamBurgersPrice() {
        return this.hamBurgersPrice;
    }

    public void setCheeseBurgersPrice(int cheeseBurgersPrice) {
        this.cheeseBurgersPrice = cheeseBurgersPrice;
    }

    public int getCheeseBurgersPrice() {
        return this.cheeseBurgersPrice;
    }

    public void setAstroChickenPrice(int astroChickenPrice) {
        this.astroChickenPrice = astroChickenPrice;
    }

    public int getAstroChickenPrice() {
        return this.astroChickenPrice;
    }

    public void setFriesPrice(int friesPrice) {
        this.friesPrice = friesPrice;
    }

    public int getFriesPrice() {
        return this.friesPrice;
    }

    public void setShakesPrice(int shakesPrice) {
        this.shakesPrice = shakesPrice;
    }

    public int getShakesPrice() {
        return this.shakesPrice;
    }

    public void setColasPrice(int colasPrice) {
        this.colasPrice = colasPrice;
    }

    public int getColasPrice() {
        return this.colasPrice;
    }
}
