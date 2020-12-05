package com.ss.onlinegame.bean;

public class Rank {
    private int gameId;
    private String username;
    private int score;
    private String date;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameid) {
        this.gameId = gameid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
