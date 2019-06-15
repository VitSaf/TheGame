package com.records.models;


import javax.persistence.*;

@Entity
@Table(name = "moves")
public class MovesRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "move_id")
    private int moveId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GameRecord game;
    @Column(name = "move_num")
    private int moveNum;
    @Column(name = "player1_move")
    private String player1Move;
    @Column(name = "player2_move")
    private String player2Move;

    public MovesRecord() {
    }

    public MovesRecord(GameRecord game, int moveNum, String player1Move, String player2Move) {
        this.game = game;
        this.moveNum = moveNum;
        this.player1Move = player1Move;
        this.player2Move = player2Move;
    }

    public int getMoveId() {
        return moveId;
    }

    public void setMoveId(int moveId) {
        this.moveId = moveId;
    }

    public GameRecord getGame() {
        return game;
    }

    public void setGame(GameRecord game) {
        this.game = game;
    }

    public int getMoveNum() {
        return moveNum;
    }

    public void setMoveNum(int moveNum) {
        this.moveNum = moveNum;
    }

    public String getPlayer1Move() {
        return player1Move;
    }

    public void setPlayer1Move(String player1Move) {
        this.player1Move = player1Move;
    }

    public String getPlayer2Move() {
        return player2Move;
    }

    public void setPlayer2Move(String player2Move) {
        this.player2Move = player2Move;
    }

    @Override
    public String toString() {
        return "MovesRecord{" +
                "moveId=" + moveId +
                ", game=" + game +
                ", moveNum=" + moveNum +
                ", player1Move='" + player1Move + '\'' +
                ", player2Move='" + player2Move + '\'' +
                '}';
    }
}
