package com.characters;

public class DworfWarrior extends Character {
    public DworfWarrior(){
        name = enterName();
        maxStamina = 50;
        fastDescentCost = 15;
        specialActionCost = 20;
        actualStamina = maxStamina;
    }
    public DworfWarrior(String nickname){
        name = nickname;
        maxStamina = 50;
        fastDescentCost = 15;
        specialActionCost = 20;
        actualStamina = maxStamina;
    }

    /**
     * Опускает
     * @param character2
     */
    public void specialAction(Character character2) {
        if (actualStamina >= specialActionCost) {
            this.floor ++;
            if((character2.floor == (this.floor - 1)) || (character2.floor == this.floor)) character2.ableToMove = false;
            actualStamina -= specialActionCost;
            System.out.println(name + " Now you are on " + floor + " floor and you have " + actualStamina + " stamina");
        } else System.out.println("Not enough stamina.You have to rest");
    }
}
