package com;

import com.characters.DworfWarrior;
import com.characters.ElfScout;

public class gameField {
    private gameField() {}

    public static void main(String[] args) {
        DworfWarrior p1 = new DworfWarrior();
        ElfScout p2 = new ElfScout();
        p1.fastDescent();
        p1.fastDescent();
        p2.fastDescent();
        p2.fastDescent();
        p2.fastDescent();
        p2.fastDescent();
        p2.rest();
        p2.rest();
        p2.rest();
        p2.rest();
        p2.rest();
        p2.fastDescent();

    }
}
