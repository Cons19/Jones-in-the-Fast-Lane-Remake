package buildings;

import java.util.Scanner;
import static buildings.consoleColors.*;

public class employmentOffice extends buildings.store {
    // is the building where the player find a job depending on the previous work experience and education
    public employmentOffice() {

    }

    public void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nYou are inside --> " + ANSI_RED + "Employment Office" + ANSI_RESET + " <--\n");
        do {
            System.out.println("Welcome to employment office:\n1) Employers list\n2) Resign current job\n3) Exit employment office");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();

            if (user == 1 && player.getSteps()>0) {
                player.setSteps(player.getSteps() - 10);
                employersList();
            }
            else
                if(player.getSteps()<=0)
                    System.out.println("You have no more steps. You must sleep!");
            if (user == 2 && player.getSteps()>0) {
                if (activeWork == 1) {
                    player.setSteps(player.getSteps() - 10);
                    resignCurrentJob();
                } else
                    System.out.println("In order to resign you need to have a job first!\n");
            }
            else
                if(player.getSteps()<=0)
                    System.out.println("You have no more steps. You must sleep!");
            if (user == 3) {
                System.out.println(ANSI_CYAN + "... You left employment office ...\n\n");
                setGoal();
                exitBuildingMessage();
                break;
            }

        } while (true);
    }

    private void employersList(){
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("The list of available employers:");
            System.out.println("0) Done\n1) Monolith Burger\n2) University\n3) Factory\n4) Bank\n5) Rent Office");
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
                System.out.println("Monolith's Jobs Available:\n");
                System.out.println("0) Done\n1) Cook\t\t\t\t\t\t$5/Hr.\n2) Clerk\t\t\t\t\t$6/Hr.\n3) Assistant Manager\t\t$8/Hr.\n4) Manager\t\t\t\t\t$9/Hr.");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.println(ANSI_RED);
                    System.out.printf("%s is not a valid number.\n", input);
                    System.out.println(ANSI_RESET);
                }
                int jobChoice=in.nextInt();
                if(jobChoice==0)
                    System.out.println();

                if(jobChoice==1) {
                    if (activeWork == 0) {
                        System.out.println("Congratulations! You got the job!\n");
                        activeWork=1;
                        monolithCook=1;
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==2) {
                    if (activeWork == 0) {
                        System.out.println("Congratulations! You got the job!\n");
                        activeWork=1;
                        monolithClerk=1;
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==3) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=25) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            monolithAssistantManager = 1;
                            player.setCareer(20);
                            System.out.println("Career set to 20");
                        }
                        else
                            if(player.getWorkExperience()<25)
                                System.out.println("You do not have enough work experience");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==4) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=50 && player.getEducation()>=20) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            monolithManager = 1;
                            player.setCareer(35);
                            System.out.println("Career set to 35");
                        }
                        else
                            if(player.getWorkExperience()<50)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<20)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
            }

            if (user == 2) {
                System.out.println("University Jobs Available:\n");
                System.out.println("0) Done\n1) Janitor\t\t\t$5/Hr.\n2) Teacher\t\t\t$14/Hr.\n3) Professor\t\t$29/Hr.");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.println(ANSI_RED);
                    System.out.printf("%s is not a valid number.\n", input);
                    System.out.println(ANSI_RESET);
                }
                int jobChoice=in.nextInt();
                if(jobChoice==0)
                    System.out.println();
                if(jobChoice==1) {
                    if (activeWork == 0) {
                        System.out.println("Congratulations! You got the job!\n");
                        activeWork=1;
                        universityJanitor=1;
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==2) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=50 && player.getEducation()>=45) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            universityTeacher = 1;
                            player.setCareer(60);
                            System.out.println("Career set to 60");
                        }
                        else
                            if(player.getWorkExperience()<50)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<45)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==3) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=75 && player.getEducation()>=75) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            universityProfessor = 1;
                            player.setCareer(90);
                            System.out.println("Career set to 90");
                        }
                        else
                            if(player.getWorkExperience()<75)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<75)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
            }

            if (user == 3) {
                System.out.println("Factory Jobs Available:\n");
                System.out.println("0) Done\n1) Janitor\t\t\t\t\t\t$10/Hr.\n2) Assembly worker\t\t\t\t$11/Hr.\n3) Secretary\t\t\t\t\t$13/Hr.\n4) Machinist's Helper\t\t\t$15/Hr.\n5) Executive Secretary\t\t\t$27/Hr.\n6) Machinist\t\t\t\t\t$29/Hr.\n7) Department Manager\t\t\t$32/Hr.\n8) Engineer\t\t\t\t\t\t$35/Hr.\n9) General Manager\t\t\t\t$39/Hr.");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.println(ANSI_RED);
                    System.out.printf("%s is not a valid number.\n", input);
                    System.out.println(ANSI_RESET);
                }
                int jobChoice=in.nextInt();
                if(jobChoice==0)
                    System.out.println();
                if(jobChoice==1) {
                    if (activeWork == 0) {
                        System.out.println("Congratulations! You got the job!\n");
                        activeWork=1;
                        factoryJanitor=1;
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==2) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=10) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factoryAssemblyWorker=1;
                            player.setCareer(5);
                            System.out.println("Career set to 5");
                        }
                        else
                            if(player.getWorkExperience()<10)
                                System.out.println("You do not have enough work experience");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==3) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=25) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factorySecretary=1;
                            player.setCareer(15);
                            System.out.println("Career set to 15");
                        }
                        else
                            if(player.getWorkExperience()<25)
                                System.out.println("You do not have enough work experience");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==4) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=35) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factoryMachinistHelper=1;
                            player.setCareer(25);
                            System.out.println("Career set to 25");
                        }
                        else
                            if(player.getWorkExperience()<35)
                                System.out.println("You do not have enough work experience");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==5) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=50 && player.getEducation()>=20) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factoryExecutiveSecretary=1;
                            player.setCareer(40);
                            System.out.println("Career set to 40");
                        }
                        else
                            if(player.getWorkExperience()<50)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<20)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==6) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=60 && player.getEducation()>=35) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factoryMachinist=1;
                            player.setCareer(50);
                            System.out.println("Career set to 50");
                        }
                        else
                            if(player.getWorkExperience()<60)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<35)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==7) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=75 && player.getEducation()>=55) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factoryDepartmentManager=1;
                            player.setCareer(65);
                            System.out.println("Career set to 65");
                        }
                        else
                            if(player.getWorkExperience()<75)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<55)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==8) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=85 && player.getEducation()>=70) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factoryEngineer=1;
                            player.setCareer(85);
                            System.out.println("Career set to 85");
                        }
                        else
                            if(player.getWorkExperience()<85)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<70)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==9) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()==100  && player.getEducation()>=100) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            factoryGeneralManager=1;
                            player.setCareer(100);
                            System.out.println("Career set to 100. You reached the maximum value!");
                        }
                        else
                            if(player.getWorkExperience()<100)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<100)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
            }

            if (user == 4) {
                System.out.println("Bank Jobs Available:\n");
                System.out.println("0) Done\n1) Janitor\t\t\t\t\t$8/Hr.\n2) Teller\t\t\t\t\t$15/Hr.\n3) Assistant Manager\t\t$21/Hr.\n4) Manager\t\t\t\t\t$29/Hr.");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.println(ANSI_RED);
                    System.out.printf("%s is not a valid number.\n", input);
                    System.out.println(ANSI_RESET);
                }
                int jobChoice=in.nextInt();
                if(jobChoice==0)
                    System.out.println();

                if(jobChoice==1) {
                    if (activeWork == 0) {
                        System.out.println("Congratulations! You got the job!\n");
                        activeWork=1;
                        bankJanitor=1;
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==2) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=25) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            bankTeller = 1;
                            player.setCareer(10);
                            System.out.println("Career set to 10");
                        }
                        else
                            if(player.getWorkExperience()<25)
                                System.out.println("You do not have enough work experience");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==3) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=50 && player.getEducation()>=20) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            bankAssistantManager = 1;
                            player.setCareer(30);
                            System.out.println("Career set to 30");
                        }
                        else
                            if(player.getWorkExperience()<50)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<20)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
                if(jobChoice==4) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=75 && player.getEducation()>=55) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            bankManager = 1;
                            player.setCareer(60);
                            System.out.println("Career set to 60");
                        }
                        else
                            if(player.getWorkExperience()<75)
                                System.out.println("You do not have enough work experience");
                        else
                            if(player.getEducation()<55)
                                System.out.println("You do not have enough education");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
            }

            if (user == 5) {
                System.out.println("Rent Office Jobs Available:\n");
                System.out.println("0) Done\n1) Groundskeeper\t\t\t\t$8/Hr.\n2) Apartment Manager\t\t\t$11/Hr.");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.println(ANSI_RED);
                    System.out.printf("%s is not a valid number.\n", input);
                    System.out.println(ANSI_RESET);
                }
                int jobChoice=in.nextInt();
                if(jobChoice==0)
                    System.out.println();

                if(jobChoice==1) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=15) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            groundskeeper = 1;
                            player.setCareer(10);
                            System.out.println("Career set to 10");
                        }
                        else
                            if(player.getWorkExperience()<15)
                                System.out.println("You do not have enough work experience");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }

                if(jobChoice==2) {
                    if (activeWork == 0) {
                        if(player.getWorkExperience()>=50) {
                            System.out.println("Congratulations! You got the job!\n");
                            activeWork = 1;
                            apartmentManager = 1;
                            player.setCareer(25);
                            System.out.println("Career set to 25");
                        }
                        else
                            if(player.getWorkExperience()<50)
                                System.out.println("You do not have enough work experience");
                    }
                    else
                        System.out.println("You already have a job!\n");
                }
            }
        } while(true);
    }

    private void resignCurrentJob(){
        System.out.println("You have successfully resigned your job!");
        player.setCareer(0);
        System.out.println("Career set to 0 ");
        activeWork=0;

        universityProfessor=0;
        universityTeacher=0;
        universityJanitor=0;

        bankManager=0;
        bankAssistantManager=0;
        bankTeller=0;
        bankJanitor=0;

        groundskeeper=0;
        apartmentManager=0;

        monolithCook=0;
        monolithClerk=0;
        monolithAssistantManager=0;
        monolithManager=0;

        factoryJanitor=0;
        factoryAssemblyWorker=0;
        factorySecretary=0;
        factoryMachinistHelper=0;
        factoryExecutiveSecretary=0;
        factoryMachinist=0;
        factoryDepartmentManager=0;
        factoryEngineer=0;
        factoryGeneralManager=0;
    }

}
