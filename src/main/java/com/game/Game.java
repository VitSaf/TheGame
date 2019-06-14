package com.game;
    import com.characters.Character;

    import java.util.Scanner;

public class Game {
    private int move;
    private final static int LVLS_TO_VICTORY = 20;
    private Character[] players = new Character[2];


        public Game(Character player1, Character player2){
            move = 0;
            if (Math.random() < 0.5){
                players[0] = player2;
                players[1] = player1;
            }else{
                players[0] = player1;
                players[1] = player2;
            }
        }

        public void possibleMoves(Character playerThatMoves){
            Character playerThatStands = null;
            for (Character c : players)
                if (!c.equals(playerThatMoves)) playerThatStands = c;
            playerThatMoves.showCharacteristics();
            System.out.println("Choose move(enter number):");
            Scanner sc;
            if (playerThatMoves.isAbleToMove()) {
                System.out.println("1. Rest");
                System.out.println("2. Descent");
                System.out.println("3. Fast descent");
                System.out.println("4. Special action");
                sc = new Scanner(System.in);
                switch (sc.nextInt()){
                    case 1 : {playerThatMoves.rest(); break;}
                    case 2 : {playerThatMoves.descent(); break;}
                    case 3 : {playerThatMoves.fastDescent(); break;}
                    case 4 : {playerThatMoves.specialAction(playerThatStands); break;}
                    default: {System.out.println("Wrong number"); break;}
                }
            } else {
                System.out.println("1. Rest");
                sc = new Scanner(System.in);
                switch (sc.nextInt()){
                    case 1 : {playerThatMoves.rest(); break;}
                    default: {System.out.println("Wrong number"); break;}
                }
            }
        }

        public void theGame() {
            while (true) {
                for (Character c : players) {
                    System.out.println("It's " + c.getName() + " turn to move");
                    if (c.isAbleToMove()) {
                        possibleMoves(c);
                        //в конце хода проверка на победу
                        if (c.getFloor() == LVLS_TO_VICTORY) {
                            System.out.println(c.getName() + " is winner!!!!!!");
                            return;
                        }
                        //TODO закончить игру
                    } else {//Этот вариант только в случае блока гномом
                        System.out.println("You can't move this turn");
                        c.setAbleToMove(true);
                    }
                }
            }
        }

}
