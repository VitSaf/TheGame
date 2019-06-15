package com;

import com.characters.DworfWarrior;
import com.characters.ElfScout;
import com.game.Game;

public class gameField {
    private gameField() {}

    public static void main(String[] args) {
        DworfWarrior p1 = new DworfWarrior();
        ElfScout p2 = new ElfScout();
        Game g1 = new Game(p1, p2);
        g1.theGame();

    }
}
