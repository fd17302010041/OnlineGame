package com.ss.onlinegame.bean.messageBean;

import com.ss.onlinegame.bean.Comment;

import java.util.List;

public class GameInfoMessage extends Message{
    String gamename;
    int mark;
    List<Comment> comments;

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
