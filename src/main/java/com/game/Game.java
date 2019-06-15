package com.game;
    import com.characters.Character;
    import com.records.models.GameRecord;
    import com.records.models.MovesRecord;
    import com.records.service.GameService;
    import com.records.service.GameServiceImpl;

    import java.util.Scanner;

public class Game {
    private int move;
    private final static int LVLS_TO_VICTORY = 20;
    private Character[] players = new Character[2];
    private GameRecord gameRecord;

    /**
     * создание игры и запись в бд
     * @param player1
     * @param player2
     */
        public Game(Character player1, Character player2){
            move = 0;
            if (Math.random() < 0.5){
                players[0] = player2;
                players[1] = player1;
            }else{
                players[0] = player1;
                players[1] = player2;
            }
            String hero1 = players[0].getClass().toString().split(" ")[1].split("\\.")[2];
            String hero2 = players[1].getClass().toString().split(" ")[1].split("\\.")[2];
            gameRecord = new GameRecord(players[0].getName(),players[1].getName(), hero1, hero2);
            new GameServiceImpl().saveGame(gameRecord);//запись об игре в бд
        }

    /**
     * Предоставляет игроку выбор возможных ходов
     * @param playerThatMoves
     * @return название выбранного хода для сохранения в бд
     */
        public String possibleMoves(Character playerThatMoves){
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
                    case 1 : {playerThatMoves.rest(); return "rest";}
                    case 2 : {playerThatMoves.descent(); return "descent";}
                    case 3 : {playerThatMoves.fastDescent(); return "fastDescent";}
                    case 4 : {playerThatMoves.specialAction(playerThatStands); return "specialAction";}
                    default: {System.out.println("Wrong number"); return  "Wrong move";}
                }
            } else {
                System.out.println("1. Rest");
                sc = new Scanner(System.in);
                switch (sc.nextInt()){
                    case 1 : {playerThatMoves.rest(); return "rest";}
                    default: {System.out.println("Wrong number"); return "Wrong move";}
                }
            }
        }

    /**
     * В этой функции и идёт игра
     * Каждый ход сохраняется в бд
     * Её ход можно воспроизвести при помощи ф-ии showReplay()
     * из класса GameReplay
     */
        public void theGame() {
            int moveCounter = 0;
            int playerCounter = 0;
            GameService gameService = new GameServiceImpl();
            String[] playerMovesOnThisTurn = new String[2];
            while (true) {
                for (Character c : players) {
                    System.out.println("It's " + c.getName() + " turn to move");
                    if (c.isAbleToMove()) {
                        playerMovesOnThisTurn[playerCounter] = possibleMoves(c);
                        //в конце хода проверка на победу
                        if (c.getFloor() == LVLS_TO_VICTORY) {
                            System.out.println(c.getName() + " is winner!!!!!!");
                            return;
                        }
                    } else {//Этот вариант только в случае блока гномом
                        System.out.println("You can't move this turn");
                        c.setAbleToMove(true);
                    }
                    playerCounter++;
                }
                //сохраняем ход
                gameService.saveMovesForGame(gameRecord.getGameId(), new MovesRecord(gameRecord, moveCounter, playerMovesOnThisTurn[0], playerMovesOnThisTurn[1]));
                playerCounter = 0;
                moveCounter++;
            }
        }

}
