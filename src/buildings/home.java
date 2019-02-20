package buildings;

import java.util.Scanner;
import static buildings.consoleColors.*;

public class home extends buildings.store {
    // is the building where the game starts. The user can relax and increase happiness goal, or can sleep and to restore the numbers of steps, but also increase
    // the number of days and maybe weeks.
    public static buildings.consoleColors cc = new buildings.consoleColors();
    Scanner in = new Scanner(System.in);
    public home() {

    }

    public void menu() {
        System.out.println("\nYou are inside --> " + ANSI_RED + "Home" + ANSI_RESET + " <--\n");
        do {
            System.out.println("Welcome to your home:\n1) Relax \n2) Sleep \n3) Exit home");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();
            if(player.getWeeks()==4) {// verify when the player hve to pay the monthly rent
                paidRent=0;
                System.out.println("You have to pay the rent!");
            }
            if (paidRent == 1) { // the player can relaxonly if the rent is paid
                if (user == 1) {
                    relax();
                    if(player.getHappiness()<player.getHappinessGoalInput()) // the happiness increase only if it is lower than the set happiness goal
                        player.setHappiness(player.getHappiness()+1);
                    else
                        System.out.println("You have already completed the happiness goal!");
                }
            }
            else
                if(paidRent==0)
                    System.out.println("You must pay the rent if you want to relax!");
            if (user == 2) { // the player restore steps,increase days and weeks
                if(player.getSteps()==0) {
                    player.setDays(player.getDays() + 1);
                    if (player.getDays() > 7) {
                        player.setDays(1);
                        player.setWeeks(player.getWeeks() + 1);
                    }
                    sleep();
                }
                else
                    System.out.println("You can't sleep! The day is not over yet!");
            }
            if (player.getSteps() > 0) {
                if(user == 3) {
                    System.out.println("... You left home ...\n\n");
                    setGoal();
                    exitBuildingMessage();
                    break;
                }
            }
            else
                if(player.getSteps()<=0)
                    System.out.println("You have no more steps. You must sleep!");
        } while (true);
    }

    private void relax() {
        if(player.getSteps()>0) {
            System.out.println("You have a good rest.");
            player.setSteps(player.getSteps()-10);
        }
        else
            System.out.println("You can't relax. You have no more steps left. You must sleep!");
    }

    private void sleep() {
        System.out.println("You are now fully restored.");
        player.setSteps(player.getDefaultsteps());
    }

}
