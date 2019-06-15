package com.records.service;

import com.records.models.GameRecord;
import com.records.models.MovesRecord;

import java.util.ArrayList;

public interface GameService {
    GameRecord getGameById(int gameId);
    ArrayList<MovesRecord> getMovesByGameId(int gameId);
    void saveGame(GameRecord gameRecord);
    void saveMovesForGame(int gameRecordId);
}
