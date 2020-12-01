package bean;

public class Comment {
    private int gameid;
    private String username;
    private String content;
    private int mark;
    private String date;

    public int getGameid() {
        return gameid;
    }

    public int getMark() {
        return mark;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getUsername() {
        return username;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
