package com.ss.onlinegame.bean.messageBean;

import com.ss.onlinegame.bean.Comment;

import java.util.List;

public class CommentMessage extends Message{
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

