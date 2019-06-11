package com.characters;

public class HumanMage extends Character {

    public HumanMage(){
        name = enterName();
        maxStamina = 30;
        fastDescentCost = 13;
        specialActionCost = 15;
        actualStamina = maxStamina;
    }

    /**
     * Если второй игрок на уровень ниже, то наш персонаж опускается, а враг поднимается
     * Если условие не выполнено, то выносливость уменьшается, но позиция не меняется
     * @param character2 второй игрок
     */
    public void specialAction(Character character2) {
        if (actualStamina >= specialActionCost) {
            if ((character2.floor - this.floor) == 1) {
                character2.floor--;
                this.floor++;
                actualStamina -= specialActionCost;
                System.out.println(name + " Now you are on " + floor + " floor and you have " + actualStamina + " stamina");
            } else {
                actualStamina -= specialActionCost;
                System.out.println("Nothing changed but you lost " + specialActionCost + " of your stamina");
            }
        }else System.out.println("Not enough stamina.You have to rest");
    }
}
