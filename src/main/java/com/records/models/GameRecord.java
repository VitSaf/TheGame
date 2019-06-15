package com.records.models;

import javax.persistence.*;

@Entity
@Table (name = "games")
public class GameRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int gameId;
    @Column(name = "player1_nickname")
    private String player1Nickname;
    @Column(name = "player2_nickname")
    private String player2Nickname;
    @Column(name = "player1_hero")
    private String player1Hero;
    @Column(name = "player2_hero")
    private String player2Hero;

    public GameRecord() {
    }

    public GameRecord(String player1Nickname, String player2Nickname, String player1Hero, String player2Hero) {
        this.player1Nickname = player1Nickname;
        this.player2Nickname = player2Nickname;
        this.player1Hero = player1Hero;
        this.player2Hero = player2Hero;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getPlayer1Nickname() {
        return player1Nickname;
    }

    public void setPlayer1Nickname(String player1Nickname) {
        this.player1Nickname = player1Nickname;
    }

    public String getPlayer2Nickname() {
        return player2Nickname;
    }

    public void setPlayer2Nickname(String player2Nickname) {
        this.player2Nickname = player2Nickname;
    }

    public String getPlayer1Hero() {
        return player1Hero;
    }

    public void setPlayer1Hero(String player1Hero) {
        this.player1Hero = player1Hero;
    }

    public String getPlayer2Hero() {
        return player2Hero;
    }

    public void setPlayer2Hero(String player2Hero) {
        this.player2Hero = player2Hero;
    }

    @Override
    public String toString() {
        return "GameRecord{" +
                "gameId=" + gameId +
                ", player1Nickname='" + player1Nickname + '\'' +
                ", player2Nickname='" + player2Nickname + '\'' +
                ", player1Hero='" + player1Hero + '\'' +
                ", player2Hero='" + player2Hero + '\'' +
                '}';
    }
}
