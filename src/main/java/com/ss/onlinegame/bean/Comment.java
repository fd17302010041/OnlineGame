package com.ss.onlinegame.bean;

public class Comment {
    private int gameId;
    private String username;
    private String comment;
    private int grade;
    private String date;

    public int getGameId() {
        return gameId;
    }

    public int getGrade() {
        return grade;
    }

    public String getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
