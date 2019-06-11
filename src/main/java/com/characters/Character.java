package com.characters;

import java.util.Scanner;

public abstract class Character {
    protected String name;
    protected int actualStamina;
    protected int maxStamina;
    protected int fastDescentCost;
    protected int specialActionCost;
    protected int floor = 0; // хоть персонажи и "опускаются", но нумерация идёт вверх т.к. это номера уровней
    private final static int DESCENT_COST = 5;
    protected boolean ableToMove = true;

    public abstract void specialAction(Character character2);

    public void rest(){
        actualStamina += 3;
        if(actualStamina > maxStamina) actualStamina = maxStamina;
        System.out.println(name + " Now you are on " + floor + " floor and you have " + actualStamina + " stamina");
    }
    public void descent(){
        if(actualStamina >= DESCENT_COST){
            actualStamina -= 5;
            floor ++;
            System.out.println(name + " Now you are on " + floor + " floor and you have " + actualStamina + " stamina");
        } else System.out.println("Not enough stamina.You have to rest");
    }
    public void fastDescent() {
        if(actualStamina > fastDescentCost){
            floor += 2;
            actualStamina -= fastDescentCost;
            System.out.println(name + " Now you are on " + floor + " floor and you have " + actualStamina + " stamina");
        } else System.out.println("Not enough stamina.You have to rest");
    }
    public String enterName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your nickname");
        return sc.nextLine();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isAbleToMove() {
        return ableToMove;
    }

    public void setAbleToMove(boolean ableToMove) {
        this.ableToMove = ableToMove;
    }
}
