package buildings;

import java.util.Scanner;
import static buildings.consoleColors.*;

public class bank extends buildings.store {
    // is the building where the player can deposit or withdraw money or even work
    public static buildings.consoleColors cc = new buildings.consoleColors();
    public double deposit=0; // used for save the money that the player deposit
    public int workActiveMessage=1;// used in case of the player have a job in the local building. If the player choose not to work and to use the building
    // options than the work option is no more available until the player exit and entry again in the building
    public bank() {

    }

    public void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nYou are inside --> " + ANSI_RED + "The Bank" + ANSI_RESET + " <--\n");
        do {
            System.out.println("Welcome to the bank:\n");
            if(workActiveMessage==1 && activeWork==1) {
                while (player.getSteps() > 0) {
                    System.out.println("0) Work\n1) Bank options/Exit");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    int workChoiceInput = in.nextInt();
                    if (workChoiceInput == 0) {
                        if (bankJanitor == 1) {
                            System.out.println(" + 8$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 8);
                            player.setWorkExperience(player.getWorkExperience() + 1);

                        }
                        if (bankTeller == 1) {
                            System.out.println(" + 15$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 15);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (bankAssistantManager == 1) {
                            System.out.println(" + 21$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 21);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (bankManager == 1) {
                            System.out.println(" + 29$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 29);
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
            System.out.println("1) Deposit money\n2) Withdraw money\n3) Exit the bank");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
             int user = in.nextInt();

             if (user == 1 && player.getSteps()>0) {
                 player.setSteps(player.getSteps() - 10);
                 depositMoney();
             }
             else
                if(player.getSteps()<=0)
                    System.out.println("You have no more steps. You must sleep!");
             if (user == 2 && player.getSteps()>0) {
                 player.setSteps(player.getSteps() - 10);
                 withdrawMoney();
             }
             else
                if(player.getSteps()<=0)
                    System.out.println("You have no more steps. You must sleep!");
             if (user == 3) {
                 System.out.println(ANSI_CYAN + "... You left the bank ...\n\n");
                 setGoal();
                 exitBuildingMessage();
                 workActiveMessage=1;
                 break;
             }

        } while (true);

    }
    //the function is used to store  the money of the player in the bank building
    private void depositMoney(){
        Scanner in = new Scanner(System.in);
        double moneyToDeposit=0; // user input
        if(player.getMoney()>=100) {
            System.out.println("How much money do you want to deposit?");
            while (!in.hasNextDouble()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            moneyToDeposit = in.nextDouble();
            if(moneyToDeposit>player.getMoney())
                System.out.println("You can not deposit more money than you have!");
            else {
                deposit = deposit + moneyToDeposit;
                player.setMoney(player.getMoney()-moneyToDeposit);
                System.out.println("You deposit " + moneyToDeposit + "$.");
                System.out.println("You now have " + deposit + "$ in your deposit.");
            }
        }
        else
            System.out.println("You must have a minimum of 100$ to put in a deposit.");
    }
    // the function is used to get the stored money from the bank back to the player
    private void withdrawMoney(){
        Scanner in = new Scanner(System.in);
        double moneyToWithdraw=0; // user input
        if(deposit>0){
            System.out.println("How much money do you want to withdraw?");
            while (!in.hasNextDouble()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            moneyToWithdraw = in.nextDouble();
            if(moneyToWithdraw>deposit)
                System.out.println("You can not withdraw more money than you have in your deposit!");
            else {
                deposit = deposit - moneyToWithdraw;
                player.setMoney(player.getMoney()+moneyToWithdraw);
                System.out.println("You withdraw " + moneyToWithdraw + "$.");
                System.out.println("You now have " + deposit + "$ in your deposit.");
            }
        }
        else
            System.out.println("You have no money in the deposit!");
    }
}