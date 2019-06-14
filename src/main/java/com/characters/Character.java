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

    public void showCharacteristics(){
        System.out.println("Your max stamina: " + maxStamina);
        System.out.println("Your actual stamina: " + actualStamina);
        System.out.println("You are on " + floor + " level");
        System.out.println("Descent cost = 5");
        System.out.println("Fast descent cost = " + fastDescentCost);
        System.out.println("Special action cost = " + specialActionCost);
        if(ableToMove) System.out.println("You can move");
        else System.out.println("you can't move this turn");

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Character character = (Character) o;

        if (actualStamina != character.actualStamina) return false;
        if (maxStamina != character.maxStamina) return false;
        if (fastDescentCost != character.fastDescentCost) return false;
        if (specialActionCost != character.specialActionCost) return false;
        if (floor != character.floor) return false;
        if (ableToMove != character.ableToMove) return false;
        return name != null ? name.equals(character.name) : character.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + actualStamina;
        result = 31 * result + maxStamina;
        result = 31 * result + fastDescentCost;
        result = 31 * result + specialActionCost;
        result = 31 * result + floor;
        result = 31 * result + (ableToMove ? 1 : 0);
        return result;
    }
}
