package com.records.service;

import com.records.models.GameRecord;
import com.records.models.MovesRecord;
import com.records.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {
    @Override
    public GameRecord findById(int gameId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(GameRecord.class, gameId);
    }

    @Override
    public List<MovesRecord> findMovesByGameId(int gameId) {
        String query = "from MovesRecord where game_id = " + gameId;
        List<MovesRecord> list = (List<MovesRecord>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(query).list();
        return list;
    }

    @Override
    public void saveGame(GameRecord gameRecord) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(gameRecord);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveMovesForGame(int gameRecordId, MovesRecord movesRecord) {
        GameRecord gameRecord = findById(gameRecordId);
        movesRecord.setGame(gameRecord);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(movesRecord);
        transaction.commit();
        session.close();
    }

    public static void main(String[] args) {
        GameRecord gameRecord = new GameRecord("Bob1", "Bob1", "Bob2", "HumanMage", "ElfScout");
        GameServiceImpl gameService = new GameServiceImpl();
        //gameService.saveGame(gameRecord);
        //gameRecord = gameService.findById(1);
        /*MovesRecord movesRecord1 = new MovesRecord(gameRecord, 1, "rest", "rest");
        MovesRecord movesRecord2 = new MovesRecord(gameRecord, 2, "rest", "rest");
        gameService.saveMovesForGame(1, movesRecord1);
        gameService.saveMovesForGame(1, movesRecord2);*/
        List<MovesRecord> list = gameService.findMovesByGameId(1);
        for (MovesRecord mr : list)
            System.out.println(mr);
    }
}
