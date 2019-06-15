package com.records.service;

import com.records.models.GameRecord;
import com.records.models.MovesRecord;

import java.util.List;

public interface GameService {
    GameRecord findById(int gameId);
    List<MovesRecord> findMovesByGameId(int gameId);
    void saveGame(GameRecord gameRecord);
    void saveMovesForGame(int gameRecordId, MovesRecord movesRecord);
}
