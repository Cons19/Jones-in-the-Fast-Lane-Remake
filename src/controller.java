import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static buildings.consoleColors.*;
import buildings.*;

public class controller {
    buildings.player player = new buildings.player();
    Scanner in = new Scanner(System.in);
    private static List<buildings.store> mapListShow = new ArrayList<buildings.store>(); // array list with all the buildings

    // the next variables are used to verify which buildings is active. if one building is active the variable become 1 and when you leave the building it become 0
    private int isHome=0;
    private int isUniversity=0;
    private int isFactory=0;
    private int isEmploymentOffice=0;
    private int isBank=0;
    private int isRentOffice=0;
    private int isPawnShop=0;
    private int isMonolithBurger=0;

    private int goalInput=-1; // the user input for the goals at the start of the game
    public int rentPriceFluctuation=0; // variable user for rent office which is accessed only one time each day, starting from the second day of game
    public controller(){
        playerDefault();
        // add the objects of buildings to the arraylist
        mapListShow.add(new home());
        mapListShow.add(new employmentOffice());
        mapListShow.add(new monolithBurger());
        mapListShow.add(new pawnShop());
        mapListShow.add(new factory());
        mapListShow.add(new university());
        mapListShow.add(new rentOffice());
        mapListShow.add(new bank());
        // make access of the player function for all the buildings from store
        for(buildings.store building : mapListShow)
        {
            building.setPlayer(player);
        }
        menu();
    }
    public void playerDefault() { // the initial characteristics of the player at the start of the game
        player.setMoney(500);
        player.setSteps(240);
        player.setDefaultsteps(240);
        player.setWorkExperience(0);
        player.setWeeks(1);
        player.setDays(1);
        player.setHappiness(0);
        player.setWealth(0);
        player.setEducation(0);
        player.setCareer(0);
        player.setPersonalGoal((player.getHappiness()+player.getWealth()+player.getEducation()+player.getCareer())/4.0);
        player.setInventory();
    }
    public void menu() {
        do {
            System.out.println(ANSI_BOLD + ANSI_YELLOW + "Welcome to Jones in the Fast Lane Remake!\n" + "Menu:\n1) Start\n2) World overview\n3) Exit\n" + ANSI_RESET);
            while (!in.hasNextInt()) { // verify input to be integer
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n",input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();
            if (user == 1) {
                System.out.println("SET YOUR GOALS:"); // set the goals by input
                do {
                    System.out.print("\nHappiness(0-100): ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    goalInput = in.nextInt();
                    if (goalInput > 0 && goalInput <= 100) {
                        player.setHappinessGoalInput(goalInput);
                        break;
                    }
                    else {
                        System.out.println("You must choose a goal between 0 and 100");
                    }
                }while(goalInput<=0 || goalInput>100);
                do {
                    System.out.print("\nWealth(10-100): ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    goalInput = in.nextInt();
                    if (goalInput > 10 && goalInput <= 100)
                        player.setWealthGoalInput(goalInput);
                    else
                        System.out.println("You must choose a goal between 10 and 100");
                }while(goalInput<=10 || goalInput>100);
                do {
                    System.out.print("\nEducation(0-100): ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    goalInput = in.nextInt();
                    if (goalInput > 0 && goalInput <= 100)
                        player.setEducationGoalInput(goalInput);
                    else
                        System.out.println("You must choose a goal between 0 and 100");
                }while(goalInput<=0 || goalInput>100);
                do {
                    System.out.print("\nCareer(0-100): ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    goalInput = in.nextInt();
                    if (goalInput > 0 && goalInput <= 100)
                        player.setCareerGoalInput(goalInput);
                    else
                        System.out.println("You must choose a goal between 0 and 100");
                }while(goalInput<=0 || goalInput>100);
                // personal goal input function is the average between the 4 goals. It is essential for winning the game, because in order to win the game, the
                // personal goal of the player during the game must be equal to the personal goal input
                player.setPersonalGoalInput((player.getHappinessGoalInput()+player.getWealthGoalInput()+player.getEducationGoalInput()+player.getCareerGoalInput())/4.0);
                System.out.println("Personal goal set to: "+player.getPersonalGoalInput());
                printMaps();
            }
            if (user == 2) {
                System.out.print(mapOverview());
            }
            if (user == 3) {
                System.out.println(ANSI_RED + "The program is closing..." + ANSI_RESET);
                break;
            }

        } while (true);
    }

    public static String mapOverview() { // map of the buildings location and possible ways between them
        return
                "\t\t\t\t\t\t\t\t\t\tWORLD OVERVIEW\n\n" +
                        " ┏━━━━━━━━━━━━━━━┓            ┏━━━━━━━━━━━━┓                  ┏━━━━━━━━━━━━━━━━━━━━━━┓           \n" +
                        " ┃               ┃            ┃            ┃                  ┃                      ┃           \n" +
                        " ┃ 1) University ┃┅┅┅┅┅┅┅┅┅┅┅┅┃ 2) Factory ┃┅┅┅┅┅┅┅┅┅┅┅┅┅┅┅┅┅┅┃ 3) Employment Office ┃╲          \n" +
                        " ┃               ┃            ┃            ┃                  ┃                      ┃ ╲         \n" +
                        " ┗━━━━━━━━━━━━━━━┛            ┗━━━━━━━━━━━━┛                  ┗━━━━━━━━━━━━━━━━━━━━━━┛  ╲        \n" +
                        "      ┇    ╲                   ╱       ╲                       ╱      ╲                  ╲        \n" +
                        "      ┇     ╲                 ╱         ╲                     ╱        ╲                  ┏━━━━━━━━━┓       \n" +
                        "      ┇      ╲               ╱           ╲                   ╱          ╲                 ┃         ┃       \n" +
                        "      ┇       ╲             ╱             ╲                 ╱            ╲                ┃ 8) Home ┃       \n" +
                        "      ┇        ╲           ╱               ╲               ╱              ╲               ┃         ┃       \n" +
                        "      ┇         ╲         ╱                 ╲             ╱                ╲              ┗━━━━━━━━━┛       \n" +
                        "      ┇          ╲       ╱                   ╲           ╱                  ╲             ╱                  \n" +
                        "      ┇           ╲     ╱                     ╲         ╱                    ╲           ╱         \n" +
                        "      ┇            ╲   ╱                       ╲       ╱                      ╲         ╱          \n" +
                        " ┏━━━━━━━━━┓      ┏━━━━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━━┓       ┏━━━━━━━━━━━━━━━━━━━━┓╱           \n" +
                        " ┃         ┃      ┃                ┃      ┃              ┃       ┃                    ┃            \n" +
                        " ┃ 4) Bank ┃┅┅┅┅┅┅┃ 5) Rent Office ┃┅┅┅┅┅┅┃ 6) Pawn Shop ┃┅┅┅┅┅┅┅┃ 7) Monolith Burger ┃            \n" +
                        " ┃         ┃      ┃                ┃      ┃              ┃       ┃                    ┃            \n" +
                        " ┗━━━━━━━━━┛      ┗━━━━━━━━━━━━━━━━┛      ┗━━━━━━━━━━━━━━┛       ┗━━━━━━━━━━━━━━━━━━━━┛            \n" +
                        "\n";
    }
    public void printMaps() {
        isHome = 1;
        do {
            if (isHome == 1) {
                isHome = 0;
                getHome().menu();
                if(player.getPersonalGoal()>=player.getPersonalGoalInput()) { // winning message
                    System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                    resetBuildings();
                    playerDefault();
                    break;
                }
                checkSteps();
                System.out.println("You can go to these different locations:");
                System.out.println("1) The Employment Office");
                System.out.println("2) Monolith burger\n\nChoose your location <nr>: ");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.printf("%s is not a valid number.\n", input);
                }
                int user = in.nextInt();
                player.setSteps(player.getSteps() - 10);
                if (user == 1) {
                    isEmploymentOffice = 1;
                }
                if (user == 2) {
                    isMonolithBurger = 1;
                }

            }
            if (isHome == 0) {
                if (isEmploymentOffice == 1) {
                    isEmploymentOffice = 0;
                    getEmploymentOffice().menu();
                    if(player.getPersonalGoal()>=player.getPersonalGoalInput()) {
                        System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                        resetBuildings();
                        playerDefault();
                        break;
                    }
                    checkSteps();
                    System.out.println("You can go to these different locations:");
                    System.out.println("1) Home");
                    System.out.println("2) Monolith burger");
                    System.out.println("3) The Pawn Shop");
                    System.out.println("4) Factory\n\nChoose your location <nr>: ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.printf("%s is not a valid number.\n", input);
                    }
                    int user = in.nextInt();
                    player.setSteps(player.getSteps()-10);
                    if (user == 1) {
                        isHome = 1;
                    }
                    if (user == 2) {
                        isMonolithBurger = 1;
                    }
                    if (user == 3) {
                        isPawnShop = 1;
                    }
                    if (user == 4) {
                        isFactory = 1;
                    }

                }

                if (isMonolithBurger == 1) {
                    isMonolithBurger = 0;
                    getMonolithBurger().menu();
                    if(player.getPersonalGoal()>=player.getPersonalGoalInput()) {
                        System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                        resetBuildings();
                        playerDefault();
                        break;
                    }
                    checkSteps();
                    System.out.println("You can go to these different locations:");
                    System.out.println("1) Home");
                    System.out.println("2) The Employment Office");
                    System.out.println("3) The Pawn Shop\n\nChoose your location <nr>: ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.printf("%s is not a valid number.\n", input);
                    }
                    int user = in.nextInt();
                    player.setSteps(player.getSteps()-10);
                    if (user == 1) {
                        isHome = 1;
                    }
                    if (user == 2) {
                        isEmploymentOffice = 1;
                    }
                    if (user == 3) {
                        isPawnShop = 1;
                    }
                }

                if (isPawnShop == 1) {
                    isPawnShop = 0;
                    getPawnShop().menu();
                    if(player.getPersonalGoal()>=player.getPersonalGoalInput()) {
                        System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                        resetBuildings();
                        playerDefault();
                        break;
                    }
                    checkSteps();
                    System.out.println("You can go to these different locations:");
                    System.out.println("1) Monolith burger");
                    System.out.println("2) The Employment Office");
                    System.out.println("3) The Factory");
                    System.out.println("4) Rent Office\n\nChoose your location <nr>: ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.printf("%s is not a valid number.\n", input);
                    }
                    int user = in.nextInt();
                    player.setSteps(player.getSteps()-10);
                    if (user == 1)
                        isMonolithBurger = 1;
                    if (user == 2)
                        isEmploymentOffice = 1;
                    if (user == 3)
                        isFactory = 1;
                    if (user == 4)
                        isRentOffice = 1;
                }

                if (isFactory == 1) {
                    isFactory = 0;
                    getFactory().menu();
                    if(player.getPersonalGoal()>=player.getPersonalGoalInput()) {
                        System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                        resetBuildings();
                        playerDefault();
                        break;
                    }
                    checkSteps();
                    System.out.println("You can go to these different locations:");
                    System.out.println("1) The Employment Office");
                    System.out.println("2) Pawn Shop");
                    System.out.println("3) Rent Office");
                    System.out.println("4) University\n\nChoose your location <nr>: ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.printf("%s is not a valid number.\n", input);
                    }
                    int user = in.nextInt();
                    player.setSteps(player.getSteps()-10);
                    if (user == 1)
                        isEmploymentOffice = 1;
                    if (user == 2)
                        isPawnShop = 1;
                    if (user == 3)
                        isRentOffice = 1;
                    if (user == 4)
                        isUniversity = 1;
                }

                if (isUniversity == 1) {
                    isUniversity = 0;
                    getUniversity().menu();
                    if(player.getPersonalGoal()>=player.getPersonalGoalInput()) {
                        System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                        resetBuildings();
                        playerDefault();
                        break;
                    }
                    checkSteps();
                    System.out.println("You can go to these different locations:");
                    System.out.println("1) Factory");
                    System.out.println("2) Rent Office");
                    System.out.println("3) Bank\n\nChoose your location <nr>: ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.printf("%s is not a valid number.\n", input);
                    }
                    int user = in.nextInt();
                    player.setSteps(player.getSteps()-10);
                    if (user == 1)
                        isFactory = 1;
                    if (user == 2)
                        isRentOffice = 1;
                    if (user == 3)
                        isBank = 1;
                }

                if (isRentOffice == 1) {
                    isRentOffice = 0;
                    if(rentPriceFluctuation==1) {
                        rentPriceFluctuation=0;
                        getRentOffice().menu();
                    }
                    else
                        System.out.println("The rent office is closed now.");
                    if(player.getPersonalGoal()>=player.getPersonalGoalInput()) {
                        System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                        resetBuildings();
                        playerDefault();
                        break;
                    }
                    checkSteps();
                    System.out.println("You can go to these different locations:");
                    System.out.println("1) Pawn Shop");
                    System.out.println("2) Factory");
                    System.out.println("3) University");
                    System.out.println("4) Bank\n\nChoose your location <nr>: ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.printf("%s is not a valid number.\n", input);
                    }
                    int user = in.nextInt();
                    player.setSteps(player.getSteps()-10);
                    if (user == 1)
                        isPawnShop = 1;
                    if (user == 2)
                        isFactory = 1;
                    if (user == 3)
                        isUniversity = 1;
                    if (user == 4)
                        isBank = 1;
                }

                if (isBank == 1) {
                    isBank = 0;
                    getBank().menu();
                    if(player.getPersonalGoal()>=player.getPersonalGoalInput()) {
                        System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
                        resetBuildings();
                        playerDefault();
                        break;
                    }
                    checkSteps();
                    System.out.println("You can go to these different locations:");
                    System.out.println("1) University");
                    System.out.println("2) Rent Office\n\nChoose your location <nr>: ");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.printf("%s is not a valid number.\n", input);
                    }
                    int user = in.nextInt();
                    player.setSteps(player.getSteps()-10);
                    if (user == 1) {
                        isUniversity = 1;
                    }
                    if (user == 2) {
                        isRentOffice = 1;
                    }
                }

            }
        } while (player.getPersonalGoal()<player.getPersonalGoalInput());

        if(player.getPersonalGoal()>=player.getPersonalGoalInput()) { // winning message. You win the game if the personal goal is the same or bigger as(than) the personal goal input
            System.out.println(ANSI_BLUE+"Congratulations! You won the game!\n"+ANSI_RESET);
            playerDefault();
        }
    }

    public void resetBuildings(){ // the buildings reset to the initialized value
        isHome=0;
        isUniversity=0;
        isFactory=0;
        isEmploymentOffice=0;
        isBank=0;
        isRentOffice=0;
        isPawnShop=0;
        isMonolithBurger=0;
    }

    public void checkSteps() { // function used to check if there are steps left
        if (player.getSteps() <= 0) {
            rentPriceFluctuation=1;
            resetBuildings();
            isHome=1;
            System.out.println(ANSI_RED+ANSI_BOLD+"You have no more steps. You must sleep!"+ANSI_RESET);
            getHome().menu();
            printMaps();
        }
    }

    // next functions give access to each building
    public store getHome() {
        return mapListShow.get(0);
    }

    public store getEmploymentOffice() {
        return mapListShow.get(1);
    }

    public store getMonolithBurger() {
        return mapListShow.get(2);
    }

    public store getPawnShop() {
        return mapListShow.get(3);
    }

    public store getFactory() {
        return mapListShow.get(4);
    }

    public store getUniversity() {
        return mapListShow.get(5);
    }

    public store getRentOffice() {
        return mapListShow.get(6);
    }

    public store getBank() {
        return mapListShow.get(7);
    }
}

