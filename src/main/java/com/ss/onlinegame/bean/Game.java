package com.ss.onlinegame.bean;

import java.util.ArrayList;

public class Game {
    private int gameid;
    private String gamename;
    private int grade;
    private ArrayList<Comment> comments;

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int mark) {
        this.grade = mark;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
}
