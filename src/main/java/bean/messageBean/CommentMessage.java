package bean.messageBean;

import bean.Comment;

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

