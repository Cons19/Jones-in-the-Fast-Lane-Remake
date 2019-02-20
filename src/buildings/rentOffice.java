package buildings;

import java.util.Scanner;
import java.util.Random;
import static buildings.consoleColors.*;

public class rentOffice extends buildings.store{
    // is the building where the player have to pay his monthly rent in order to relax at home. For the security apartment player have a high happiness
    // increase. The costs for the apartments are random and they change daily;
    Random random = new Random();
    Scanner in = new Scanner(System.in);
    public int monthlyRent=300;
    public int lowCostApartment=0;
    public int securityApartment=0;
    public int lowCostApartmentMin=250;
    public int lowCostApartmentMax=350;
    public int securityApartmentMin=500;
    public int securityApartmentMax=750;

    public int workActiveMessage=1; // used in case of the player have a job in the local building. If the player choose not to work and to use the building
    // options than the work option is no more available until the player exit and entry again in the building
    public rentOffice() {

    }

    public void menu() {
        lowCostApartment = random.nextInt((lowCostApartmentMax - lowCostApartmentMin) + 1) + lowCostApartmentMin;
        securityApartment = random.nextInt((securityApartmentMax - securityApartmentMin) + 1) + securityApartmentMin;
        System.out.println("\nYou are inside --> " + ANSI_RED + "Rent Office" + ANSI_RESET + " <--\n");
        do {
            System.out.println("Welcome to rent office:\n");
            if(workActiveMessage==1 && activeWork==1) {
                while (player.getSteps() > 0) {
                    System.out.println("0) Work\n1) Rent office options/Exit");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    int workChoiceInput = in.nextInt();
                    if (workChoiceInput == 0) {
                        if (groundskeeper == 1) {
                            System.out.println(" + 8$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 8);
                            player.setWorkExperience(player.getWorkExperience() + 1);

                        }
                        if (apartmentManager == 1) {
                            System.out.println(" + 11$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 11);
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
            System.out.println("1) Pay monthly rent\t\t" + monthlyRent + "$\n2) Rent apartment\n3) Exit rent office");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();

            if (user == 1)
                if(paidRent==0)
                    PayMonthlyRent();
                else
                    System.out.println("You have already paid the rent for this month!");
            if (user == 2)
                RentApartment();
            if (user == 3) {
                System.out.println(ANSI_CYAN + "... You left rent office ...\n\n");
                setGoal();
                exitBuildingMessage();
                workActiveMessage=1;
                break;
            }

        } while (true);

    }

    public void PayMonthlyRent() {
        if(player.getMoney()>monthlyRent) {
            player.setMoney(player.getMoney() - monthlyRent);
            paidRent = 1;
            System.out.println("You have successfully paid your rent!");
        }
        else
            System.out.println("You do not have enough money to pay the rent");
    }

    public void RentApartment() {
        do {
            System.out.println("0) Done\n1) Rent low-cost apartment\t\t" + lowCostApartment + "$\n2) Rent security apartment\t\t" + securityApartment + "$");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();
            if (user == 0)
                break;
            if (user == 1) {
                if(player.getMoney()>lowCostApartment) { // verify if the player have enough money for the chosen apartment
                    System.out.println("You rent the low-cost apartment!");
                    player.setMoney(player.getMoney() - lowCostApartment);
                    monthlyRent=lowCostApartment; // set monthly rent to the new chosen price
                }
                else
                    System.out.println("You do not have enough money to pay the rent");
            }
            if(user==2) {
                if(player.getMoney()>securityApartment) { // verify if the player have enough money for the chosen apartment
                    System.out.println("You rent the security apartment!");
                    player.setMoney(player.getMoney() - securityApartment);
                    monthlyRent = securityApartment; // set monthly rent to the new chosen price
                    if(player.getHappiness()<player.getHappinessGoalInput()) { // the happiness increase only if it is lower than the set happiness goal
                        player.setHappiness(player.getHappiness() + 10);
                        System.out.println("Happiness goal +10");
                    }
                    else
                        System.out.println("You have already completed the happiness goal!");
                }
                else
                    System.out.println("You do not have enough money to pay the rent");
            }
        } while(true);
    }

}
