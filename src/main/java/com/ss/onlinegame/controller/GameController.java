package com.ss.onlinegame.controller;

import com.ss.onlinegame.bean.Comment;
import com.ss.onlinegame.bean.Game;
import com.ss.onlinegame.bean.Rank;
import com.ss.onlinegame.bean.messageBean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ss.onlinegame.service.GameService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class GameController {
    private GameService gameService;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @RequestMapping(value = "/data/game/information",method = RequestMethod.POST)
    public Message information(HttpSession session,
                               @RequestParam(value = "gameId") int gameId){
        if(session.getAttribute("username")!=null){
            Game game = gameService.selectGamerById(gameId);
            GameInfoMessage gameInfoMessage = new GameInfoMessage();
            gameInfoMessage.setResult(true);
            gameInfoMessage.setGamename(game.getGamename());
            gameInfoMessage.setComments(game.getComments());
            gameInfoMessage.setMark(game.getGrade());

            return gameInfoMessage;
        }
        Message message = new Message();
        message.setResult(false);
        message.setMessage("用户未登录。");
        return message;
    }

    @RequestMapping(value = "/game/rank",method = RequestMethod.POST)
    public Message ranks(HttpSession session,
                               @RequestParam(value = "gameId") int gameId){
        if(session.getAttribute("username") == null){
            Message message = new Message();
            message.setResult(false);
            message.setMessage("用户未登录。");
            return message;
        }else {
            List<Rank> ranks = gameService.selectRanksByGameId(gameId);
            RankMessage rankMessage = new RankMessage();
            rankMessage.setRanks(ranks);
            rankMessage.setResult(true);
            return rankMessage;
        }
    }

    @RequestMapping(value = "/game/score",method = RequestMethod.POST)
    public Message score(HttpSession session,
                         @RequestParam(value = "gameId") int gameId,
                         @RequestParam(value = "score") int score){
        if(session.getAttribute("username") == null){
            Message message = new Message();
            message.setResult(false);
            message.setMessage("用户未登录。");
            return message;
        }else {
            String username = (String) session.getAttribute("username");
            Rank rank = new Rank();
            rank.setScore(score);
            rank.setGameId(gameId);
            rank.setUsername(username);
            rank.setDate(df.format(new Date()));

            Message message = new Message();
            if(gameService.insertRank(rank) != 0){
                message.setResult(true);
                return message;
            }
            message.setResult(false);
            return message;
        }
    }

    @RequestMapping(value = "/game/comment",method = RequestMethod.POST)
    public Message comment(HttpSession session,
                        @RequestParam(value = "gameId") int gameId){
        if(session.getAttribute("username") == null){
            Message message = new Message();
            message.setResult(false);
            message.setMessage("用户未登录。");
            return message;
        }else {
            CommentMessage commentMessage = new CommentMessage();
            commentMessage.setComments(gameService.selectCommentsByGameId(gameId));
            commentMessage.setResult(true);
            return commentMessage;
        }
    }

    @RequestMapping(value = "/game/writeComment",method = RequestMethod.POST)
    public Message writeComments(HttpSession session,
                           @RequestParam(value = "gameId") int gameId,
                           @RequestParam(value = "comment") String commentContent,
                           @RequestParam(value = "grade") int grade){
        if(session.getAttribute("username") == null){
            Message message = new Message();
            message.setResult(false);
            message.setMessage("用户未登录。");
            return message;
        }else {
            String username = (String) session.getAttribute("username");
            Comment comment = new Comment();

            comment.setUsername(username);
            comment.setGameId(gameId);
            comment.setDate(df.format(new Date()));
            comment.setComment(commentContent);
            comment.setGrade(grade);

            Message message = new Message();
            if(gameService.insertComment(comment) != 0){
                message.setResult(true);
                return message;
            }
            message.setResult(false);
            return message;
        }
    }
}
