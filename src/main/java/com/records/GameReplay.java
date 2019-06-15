package com.records;

import com.characters.Character;
import com.characters.DworfWarrior;
import com.characters.ElfScout;
import com.characters.HumanMage;
import com.records.models.GameRecord;
import com.records.models.MovesRecord;
import com.records.service.GameService;
import com.records.service.GameServiceImpl;

import java.util.List;

public class GameReplay {
    private Character[] players = new Character[2];
    private long countOfMoves;
    private int gameId;

    public GameReplay(GameRecord gameRecord){
        Character player1, player2;
        gameId = gameRecord.getGameId();
        countOfMoves = new GameServiceImpl().findCountOfMovesInGame(gameRecord.getGameId());//тут логичнее было бы использовать просто размер
                                                                                            //листа с ходами, но коль уж написал отдельную функцию для этого
                                                                                            //то почему бы не использовать её?
        switch (gameRecord.getPlayer1Hero()){
            case "DworfWarrior" : {player1 = new DworfWarrior(gameRecord.getPlayer1Nickname()); break;}
            case "ElfScout"     : {player1 = new ElfScout(gameRecord.getPlayer1Nickname()); break;}
            case "HumanMage"    : {player1 = new HumanMage(gameRecord.getPlayer1Nickname()); break;}
            default             : {player1 = null; break;}
        }
        switch (gameRecord.getPlayer2Hero()){
            case "DworfWarrior" : {player2 = new DworfWarrior(gameRecord.getPlayer2Nickname()); break;}
            case "ElfScout"     : {player2 = new ElfScout(gameRecord.getPlayer2Nickname()); break;}
            case "HumanMage"    : {player2 = new HumanMage(gameRecord.getPlayer2Nickname()); break;}
            default             : {player2 = null; break;}
        }
        players[0] = player1;
        players[1] = player2;
    }

    /**
     *
     * @param playerThatMoves для этого игрока будет разыгрываться действие
     * @param playerThatStands нужен на случай special action
     * @param moveName ход, который был разыгран
     */
    public void whatMoveToPlay(Character playerThatMoves, Character playerThatStands ,String moveName){
        switch (moveName){
            case "rest"          : {playerThatMoves.rest(); break;}
            case "descent"       : {playerThatMoves.descent(); break;}
            case "fastDescent"   : {playerThatMoves.fastDescent(); break;}
            case "specialAction" : {playerThatMoves.specialAction(playerThatStands); break;}
            default              : {System.out.println("Wrong move " + moveName); break;}
        }
    }

    public void playMoves(MovesRecord movesRecord){
        whatMoveToPlay(players[0], players[1], movesRecord.getPlayer1Move());
        whatMoveToPlay(players[1], players[0], movesRecord.getPlayer2Move());
    }
    public void showReplay(){
        List<MovesRecord> moves = new GameServiceImpl().findMovesByGameId(gameId);
        for(int i = 0; i < countOfMoves; i++)
            playMoves(moves.get(i));
    }

}
