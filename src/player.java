package buildings;

import java.util.List;
import java.util.ArrayList;

public class player {
    public static List<buildings.items> inventoryList = new ArrayList<buildings.items>();

    public double money;
    public int steps;
    public int defaultsteps;
    public double personalGoal;
    public int workExperience;
    public int weeks;
    public int days;

    public int happiness;
    public int wealth;
    public int education;
    public int career;

    //goals input
    public int happinessGoalInput;
    public int wealthGoalInput;
    public int educationGoalInput;
    public int careerGoalInput;
    public double personalGoalInput; // average of the goals input
    // setter getters
    public player(){

    }

    public void setInventory() { // the default player inventory
        buildings.items item1 = new buildings.items("Freezer",500);

        inventoryList.add(item1);

        setWealth(getWealth()+10);
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return this.money;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return this.steps;
    }

    public void setPersonalGoal(double personalGoal) {
        this.personalGoal = personalGoal;
    }

    public double getPersonalGoal() {
        return this.personalGoal;
    }

    public void setDefaultsteps(int defaultsteps) {
        this.defaultsteps = defaultsteps;
    }

    public int getDefaultsteps() {
        return this.defaultsteps;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getWorkExperience() {
        return this.workExperience;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getWeeks() {
        return this.weeks;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getEducation() {
        return this.education;
    }

    public void setWealth(int wealth) {
        this.wealth = wealth;
    }

    public int getWealth() {
        return this.wealth;
    }

    public void setCareer(int career) {
        this.career = career;
    }

    public int getCareer() {
        return this.career;
    }

    public void setCareerGoalInput(int careerGoalInput) {
        this.careerGoalInput = careerGoalInput;
    }

    public int getCareerGoalInput() {
        return this.careerGoalInput;
    }

    public void setEducationGoalInput(int educationGoalInput) {
        this.educationGoalInput = educationGoalInput;
    }

    public int getEducationGoalInput() {
        return this.educationGoalInput;
    }

    public void setHappinessGoalInput(int happinessGoalInput) {
        this.happinessGoalInput = happinessGoalInput;
    }

    public int getHappinessGoalInput() {
        return this.happinessGoalInput;
    }

    public void setWealthGoalInput(int wealthGoalInput) {
        this.wealthGoalInput = wealthGoalInput;
    }

    public int getWealthGoalInput() {
        return this.wealthGoalInput;
    }

    public void setPersonalGoalInput(double personalGoalInput) {
        this.personalGoalInput = personalGoalInput;
    }

    public double getPersonalGoalInput() {
        return this.personalGoalInput;
    }


}


