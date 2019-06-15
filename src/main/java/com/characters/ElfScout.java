package com.characters;

public class ElfScout extends Character {
    public ElfScout(){
        name = enterName();
        maxStamina = 40;
        fastDescentCost = 12;
        specialActionCost = 24;
        actualStamina = maxStamina;
    }
    public ElfScout(String nickname){
        name = nickname;
        maxStamina = 40;
        fastDescentCost = 12;
        specialActionCost = 24;
        actualStamina = maxStamina;
    }
    public void specialAction(Character character2) {
        if (actualStamina >= specialActionCost) {
            this.floor += 3;
            actualStamina -= specialActionCost;
            System.out.println(name + " Now you are on " + floor + " floor and you have " + actualStamina + " stamina");
        } else System.out.println("Not enough stamina.You have to rest");
    }
}
