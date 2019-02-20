package buildings;

import java.util.Scanner;
import static buildings.consoleColors.*;

public class university extends buildings.store {
    // is the building where the player can increase the education in order to get a higher job and career. The player can only start an degree at once
    public  buildings.consoleColors cc = new buildings.consoleColors();
    public int enroll=0; // variable used to verify if the player paid the fee for studying
    public int study1=1; // variable used to verify which degree is available. study1 is used for tradeSchool degree and if it is 1 that mean that is active
    public int study2=1; // variable used to verify which degree is available. study2 is used for juniorCollege degree and if it is 1 that mean that is active
    public int studyFinish1=0; // varible used to verify if the player finished the tradeSchool degree and to show the next two courses
    public int studyFinish2=0; // varible used to verify if the player finished the juniorCollege degree and to show the next two courses
    public int tradeSchool1=0; // variable used for electronics degree to verify if it is active than the engineering degree is not available until the current course is finished
    public int tradeSchool2=0; // variable used for enginerring degree to verify if it is active than the electronics degree is not available until the current course is finished
    public int juniorCollege1=0; // variable used for bussinessadmin degree to verify if it is active than the academic degree is not available until the current course is finished
    public int juniorCollege2=0; // variable used for academic degree to verify if it is active than the bussiness degree is not available until the current course is finished
    public int isActive1=0; // variable used to verify if the player finished the first degree trade school and it stop the appearance of the congrats message
    public int isActive2=0; // variable used to verify if the player finished the seconds degree junior college and it stop the appearance of the congrats message
    public int juniorCollegeActive=0; // variable used to verify, after junior college degree finished if one of the bussinessadmin or academic degrees have been chosen than electronics or engineering degrees are not available until the current course is finished
    public int tradeSchoolActive=0; // variable used to verify, after trade school degree finished if one of the electronics or engineering degrees have been chosen than bussinessadmin or academic degrees are not available until the current course is finished
    public int electronicsfinish=0; // variable used to verify if the player finished the electronic degree. If it is finished it is no longer possible to take the course again
    public int engineeringfinish=0; // variable used to verify if the player finished the engineering degree. If it is finished it is no longer possible to take the course again
    public int businessadminsfinish=0; // variable used to verify if the player finished the bussinessadmin degree. If it is finished it is no longer possible to take the course again
    public int academicfinish=0; // variable used to verify if the player finished the academic degree. If it is finished it is no longer possible to take the course again

    // next variables are used to count the number of times the player have to study in order to finish one of the degrees
    public int tradeSchool=10;
    public int juniorCollege=10;
    public int electronics=10;
    public int engineering=10;
    public int businessadmin=10;
    public int academic=10;

    public int workActiveMessage=1;// used in case of the player have a job in the local building. If the player choose not to work and to use the building
    // options than the work option is no more available until the player exit and entry again in the building

    public university() {

    }

    public  void menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nYou are inside --> " + ANSI_RED +  "The University" + ANSI_RESET +" <--\n");

        do {
            System.out.println("Welcome to the university:\n");
            if(workActiveMessage==1 && activeWork==1) {
                while (player.getSteps() > 0) {
                    System.out.println("0) Work\n1) Study/Exit");
                    while (!in.hasNextInt()) {
                        String input = in.next();
                        System.out.println(ANSI_RED);
                        System.out.printf("%s is not a valid number.\n", input);
                        System.out.println(ANSI_RESET);
                    }
                    int workChoiceInput = in.nextInt();
                    if (workChoiceInput == 0) {
                        if (universityJanitor == 1) {
                            System.out.println(" + 5$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 5);
                            player.setWorkExperience(player.getWorkExperience() + 1);

                        }
                        if (universityTeacher == 1) {
                            System.out.println(" + 14$! Good job! Keep going!");
                            player.setSteps(player.getSteps() - 10);
                            player.setMoney(player.getMoney() + 14);
                            player.setWorkExperience(player.getWorkExperience() + 1);
                        }
                        if (universityProfessor == 1) {
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

            if(studyFinish1==0 && studyFinish2==0) // there are 4 types of menu depending on the typeof study finished
                System.out.println("1) Enroll \n2) Trade School\n3) Junior College \n4) Exit the university");
            else
                if(studyFinish1==1 && studyFinish2==1) {
                    study1 = 1;
                    study2 = 1;
                    System.out.println("1) Enroll \n2) Electronics / Engineering\n3) Business Admin / Academic \n4) Exit the university");
                }
            else
                if(studyFinish1==1 && studyFinish2==0) {
                    study2=1;
                    System.out.println("1) Enroll \n2) Electronics / Engineering\n3) Junior College \n4) Exit the university");
                }
            else
                if(studyFinish2==1 && studyFinish1==0) {
                    study1 = 1;
                    System.out.println("1) Enroll \n2) Trade School\n3) Business Admin / Academic \n4) Exit the university");
                }

            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();

            if (user == 1)
                if(enroll==1)
                    System.out.println("You have already paid the enroll!");
                else
                    if(enroll==0)
                        enroll();
            if (user == 2 )
                if(enroll==1) {
                    if(study1==1) {
                        if(tradeSchoolActive==0) {
                            juniorCollegeActive=1;
                            tradeSchool();
                        }
                        else
                            System.out.println("You have to finish your current education first!");
                    }
                    else{
                        System.out.println("You have to finish the Junior College program first!");
                    }
                }
                else
                    if(enroll==0)
                        System.out.println("You must pay the enroll first!");
            if (user == 3 )
                if(enroll==1) {

                    if(study2==1) {
                        if(juniorCollegeActive==0) {
                            tradeSchoolActive=1;
                            juniorCollege();
                        }
                        else
                            System.out.println("You have to finish your current education first!");
                    }
                    else {
                        System.out.println("You have to finish the Trade School program first!");
                    }
                }
                else
                    if(enroll==0)
                        System.out.println("You must pay the enroll first!");
            if (user == 4) {
                System.out.println("... You left the university ...\n\n");
                setGoal();
                exitBuildingMessage();
                workActiveMessage=1;
                break;
            }

        } while (true);

    }

    private  void enroll() { // the method where the player pay the fee for each new start study course
        Scanner in = new Scanner(System.in);
        if(player.getMoney()>=100) {
            System.out.println("You have to pay 100$ to enroll to the college study.");
            System.out.println("Pay 100$?\n1) Yes\n2) No");
            while (!in.hasNextInt()) {
                String input = in.next();
                System.out.println(ANSI_RED);
                System.out.printf("%s is not a valid number.\n", input);
                System.out.println(ANSI_RESET);
            }
            int user = in.nextInt();
            if (user == 1) {
                System.out.println("Congratulations! You are now enrolled to the college study!");
                player.setMoney(player.getMoney()-100);
                enroll = 1;
            }

            if (user == 2) {
                System.out.println("Sorry, without paying you are not allowed to start the college study!");
            }
        }
        else
            System.out.println("You have not the minimum of 100$ to pay the enroll.");

    }

    private  void tradeSchool() { // method with tradeschool program and subprograms electronics and engineering where education can increase
        Scanner in = new Scanner(System.in);

        if(studyFinish1==1 && player.getSteps()>0) {
            do {
                System.out.println("1) Electronics\n2) Engineering\n3) Back");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.println(ANSI_RED);
                    System.out.printf("%s is not a valid number.\n", input);
                    System.out.println(ANSI_RESET);
                }
                int user = in.nextInt();
                if (user == 1) {
                    if (electronics > 1 && tradeSchool2==0 && enroll==1 && electronicsfinish==0) {
                        tradeSchool1=1;
                        electronics = electronics - 1;
                        player.setSteps(player.getSteps()-10);
                        System.out.println("Electronics hours left: " + electronics);
                    }
                    else if(electronicsfinish!=0) {
                        System.out.println("You have already finished Electronic degree");
                    }
                    else if(electronics==1){
                        System.out.println("Congratulations! You have earned a electronics degree!");
                        electronicsfinish=1;
                        player.setHappiness(player.getHappiness()+5);
                        player.setEducation(player.getEducation()+15);
                        enroll = 0;
                        tradeSchool1=0;
                        juniorCollegeActive=0;
                    }
                    else if(tradeSchool2==1){
                        System.out.println("You have to finish the Engineering program first!");
                    }
                    else if(enroll!=1) {
                        System.out.println("You must pay the enroll first!");
                    }


                }
                if (user == 2) {
                    if (engineering > 1 && tradeSchool1==0 && enroll==1 && engineeringfinish==0) {
                        tradeSchool2=1;
                        engineering = engineering - 1;
                        player.setSteps(player.getSteps()-10);
                        System.out.println("Engineering hours left: " + engineering);
                    }
                    else if(engineeringfinish!=0) {
                        System.out.println("You have already finished Engineering degree");
                    }
                    else if(engineering==1){
                        System.out.println("Congratulations! You have earned a Engineering degree!");
                        engineeringfinish=1;
                        player.setHappiness(player.getHappiness()+5);
                        player.setEducation(player.getEducation()+15);
                        enroll = 0;
                        tradeSchool2=0;
                        juniorCollegeActive=0;
                    }
                    else if(tradeSchool1==1) {
                        System.out.println("You have to finish the Electronics program first!");
                    }
                    else if(enroll!=1) {
                        System.out.println("You must pay the enroll first!");
                    }
                }
                if (user == 3) {
                    break;
                }
            }while(true);
        }
        else
            if(player.getSteps()<=0)
                System.out.println("You have no more steps. You must sleep!");



        if(isActive1==0 && player.getSteps()>0) {
            if (study1 == 1) {
                study2=0;
                if (tradeSchool > 1) {
                    tradeSchool = tradeSchool - 1;
                    player.setSteps(player.getSteps()-10);
                    System.out.println("Trade School hours left: " + tradeSchool);
                } else {
                    studyFinish1 = 1;
                    enroll = 0;
                    System.out.println("Congratulations! You have earned a trade school degree!");
                    player.setHappiness(player.getHappiness()+5);
                    player.setEducation(player.getEducation()+20);
                    isActive1=1;
                    juniorCollegeActive=0;
                }
            }
        }
        else
            if(player.getSteps()<=0)
                System.out.println("You have no more steps. You must sleep!");

    }
    private void juniorCollege() {// method juniorCollege program and subprograms bussinessadmin and academic where education can increase
        Scanner in = new Scanner(System.in);

        if(studyFinish2==1 && player.getSteps()>0) {
            do {
                System.out.println("1) Business Admin\n2) Academic\n3) Back");
                while (!in.hasNextInt()) {
                    String input = in.next();
                    System.out.println(ANSI_RED);
                    System.out.printf("%s is not a valid number.\n", input);
                    System.out.println(ANSI_RESET);
                }
                int user = in.nextInt();
                if (user == 1) {
                    if (businessadmin > 1 && juniorCollege2==0 && enroll==1 && businessadminsfinish==0) {
                        juniorCollege1=1;
                        businessadmin = businessadmin - 1;
                        player.setSteps(player.getSteps()-10);
                        System.out.println("Business Admin hours left: " + businessadmin);
                    }
                    else if(businessadminsfinish!=0) {
                        System.out.println("You have already finished Business Admin degree");
                    }
                    else if(businessadmin==1) {
                        System.out.println("Congratulations! You have earned a Business Admin degree!");
                        businessadminsfinish=1;
                        player.setHappiness(player.getHappiness()+5);
                        player.setEducation(player.getEducation()+15);
                        enroll = 0;
                        juniorCollege1 = 0;
                        tradeSchoolActive=0;
                    }
                    else if(juniorCollege2==1) {
                        System.out.println("You have to finish the Academic program first!");
                    }
                    else if(enroll!=1) {
                        System.out.println("You must pay the enroll first!");
                    }

                }
                if (user == 2) {
                    if (academic > 1 && juniorCollege1==0 && enroll==1 && academicfinish==0) {
                        juniorCollege2=1;
                        academic = academic - 1;
                        player.setSteps(player.getSteps()-10);
                        System.out.println("Academic hours left: " + academic);
                    }
                    else if(academicfinish!=0) {
                        System.out.println("You have already finished Academic degree");
                    }
                    else if(academic==1){
                        System.out.println("Congratulations! You have earned a Academic degree!");
                        academicfinish=1;
                        player.setHappiness(player.getHappiness()+5);
                        player.setEducation(player.getEducation()+15);
                        enroll = 0;
                        juniorCollege2 = 0;
                        tradeSchoolActive=0;
                    }
                    else if(juniorCollege1==1) {
                        System.out.println("You have to finish the Business Admin program first!");
                    }
                    else if(enroll!=1) {
                        System.out.println("You must pay the enroll first!");
                    }

                }
                if (user == 3) {
                    break;
                }
            }while(true);
        }
        else
            if(player.getSteps()<=0)
                System.out.println("You have no more steps. You must sleep!");

        if(isActive2==0 && player.getSteps()>0) {
            study1=0;
            if (study2 == 1) {
                if (juniorCollege > 1) {
                    juniorCollege = juniorCollege - 1;
                    player.setSteps(player.getSteps()-10);
                    System.out.println("Junior College hours left: " + juniorCollege);
                } else {
                    studyFinish2 = 1;
                    enroll = 0;
                    System.out.println("Congratulations! You have earned a junior college degree!");
                    player.setHappiness(player.getHappiness()+5);
                    player.setEducation(player.getEducation()+20);
                    isActive2=1;
                    tradeSchoolActive=0;
                }
            }
        }
        else
            if(player.getSteps()<=0)
                System.out.println("You have no more steps. You must sleep!");
    }

}