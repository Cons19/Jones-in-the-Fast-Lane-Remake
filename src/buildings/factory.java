package buildings;

import java.util.Scanner;
import static buildings.consoleColors.*;

public class factory extends buildings.store {
    // is the building where the player can work or find useful information about factories
    Scanner in = new Scanner(System.in);

    public int workActiveMessage=1; // used in case of the player have a job in the local building. If the player choose not to work and to use the building
    // options than the work option is no more available until the player exit and entry again in the building

    public factory() {

    }

    public void menu() {
        System.out.println("\nYou are inside --> " + ANSI_RED + "The Factory" + ANSI_RESET + " <--\n");
        do {
            System.out.println("Welcome to the factory:\n");
            if(workActiveMessage==1 && activeWork==1) {
                while (player.getSteps() > 0) {
                    System.out.println("0) Work\n1) Exit");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    int workChoiceInput = in.nextInt();
                    if (workChoiceInput == 0) {
                        if (factoryJanitor== 1) {
                            System.out.println(" + 10$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 10);
                            player.setWorkExperience(player.getWorkExperience() + 1);

                        }
                        if (factoryAssemblyWorker== 1) {
                            System.out.println(" + 11$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 11);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (factorySecretary == 1) {
                            System.out.println(" + 13$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 13);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (factoryMachinistHelper == 1) {
                            System.out.println(" + 15$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 15);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (factoryExecutiveSecretary == 1) {
                            System.out.println(" + 27$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 27);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (factoryMachinist == 1) {
                            System.out.println(" + 29$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 29);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (factoryDepartmentManager == 1) {
                            System.out.println(" + 32$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 32);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (factoryEngineer== 1) {
                            System.out.println(" + 35$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 35);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (factoryGeneralManager == 1) {
                            System.out.println(" + 39$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 39);
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
            System.out.println("1) Informations about factories\n2) Exit the factory");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();

            if (user == 1) {
                System.out.println(ANSI_ITALIC+"A factory (previously manufactory) or manufacturing plant is an industrial site, usually consisting of buildings and machinery, or more commonly a complex having several buildings, where workers manufacture goods or operate machines processing one product into another.\n" +
                        "Factories arose with the introduction of machinery during the Industrial Revolution when the capital and space requirements became too great for cottage industry or workshops. Early factories that contained small amounts of machinery, such as one or two spinning mules, and fewer than a dozen workers have been called \"glorified workshops\"."+ANSI_RESET);
            }
            if (user == 2) {
                System.out.println(ANSI_CYAN + "... You left the factory ...\n\n");
                setGoal();
                exitBuildingMessage();
                workActiveMessage=1;
                break;
            }

        } while (true);

    }

}

