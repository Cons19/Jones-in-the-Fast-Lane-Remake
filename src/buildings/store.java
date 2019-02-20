package buildings;


import static buildings.consoleColors.*;
public class store {

    public int paidRent=1; // varible used to verify if the rent is paid or not. First month the rent is paid.


    // variables are used for working in different location. At first the player has no job. When the player gets a job from the employment office the work
    // variable becomes 1. This is also used for the buildings menu. If the player has no job, the work menu does not appear.
    public static int activeWork=0; // variable which verify if the player have a job or not

    public static int universityJanitor=0;
    public static int universityTeacher=0;
    public static int universityProfessor=0;

    public static int bankJanitor=0;
    public static int bankTeller=0;
    public static int bankAssistantManager=0;
    public static int bankManager=0;

    public static int groundskeeper=0;
    public static int apartmentManager=0;

    public static int monolithCook=0;
    public static int monolithClerk=0;
    public static int monolithAssistantManager=0;
    public static int monolithManager=0;

    public static int factoryJanitor=0;
    public static int factoryAssemblyWorker=0;
    public static int factorySecretary=0;
    public static int factoryMachinistHelper=0;
    public static int factoryExecutiveSecretary=0;
    public static int factoryMachinist=0;
    public static int factoryDepartmentManager=0;
    public static int factoryEngineer=0;
    public static int factoryGeneralManager=0;

    buildings.player player = null;
    public store() {

    }
    // setplayer set access to the player functions to all buildings
    public void setPlayer (buildings.player newPlayer)
    {
        player = newPlayer;
    }

    public void menu() {

    }

    public void exitBuildingMessage() {// message after exiting a building
        System.out.println(ANSI_CYAN + "Personal status: " + ANSI_RESET);
        System.out.println("------------------------------------");
        System.out.println(ANSI_CYAN + "Day\t\t" + "#\t"+ player.getDays());
        System.out.println("Week\t" + "#\t"+ player.getWeeks());
        System.out.printf("Money: %.2f$" + " dollars", player.getMoney());
        System.out.println("\nSteps left: " + player.getSteps() + " steps");
        System.out.println("Personal Goal: " + player.getPersonalGoal() + "% done" + ANSI_RESET);
        System.out.println("------------------------------------\n\n");
    }

    public void noStepsMessage() { // message for no steps left
        if(player.getSteps() <= 0) {
            System.out.println(ANSI_RED+ANSI_BOLD+"You have no more steps. You must sleep!"+ANSI_RESET);
        }
    }

    // calculate the personal goal at the exit of each building
    public void setGoal() {
        player.setPersonalGoal((player.getHappiness()+player.getWealth()+player.getEducation()+player.getCareer())/4.0);
    }

}
