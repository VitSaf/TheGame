package com.records.service;

import com.records.models.GameRecord;
import com.records.models.MovesRecord;
import com.records.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class GameServiceImpl implements GameService {
    @Override
    public GameRecord findById(int gameId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(GameRecord.class, gameId);
    }

    @Override
    public List<MovesRecord> findMovesByGameId(int gameId) {
        String query = "from MovesRecord where game_id = " + gameId;//хоть идея и ругается, но это рабочий вариант
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

    /**
     * Возращает количество ходов в игре
     * @param gameId
     * @return
     */
    @Override
    public long findCountOfMovesInGame(int gameId) {
        String query = "select count(move_num) from MovesRecord where game_id =" + gameId;
        List<Long> list = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(query).list();
        return list.get(0);
    }

}
