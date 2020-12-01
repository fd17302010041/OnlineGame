package controller;

import bean.Comment;
import bean.Game;
import bean.Rank;
import bean.messageBean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GameService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class GameController {
    private GameService gameService;
    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @RequestMapping(value = "/data/game/information",method = RequestMethod.GET)
    public Message information(HttpSession session,
                               @RequestParam(value = "gameId") int gameId){
        if(session.getAttribute("username")!=null){
            Game game = gameService.selectGamerById(gameId);
            GameInfoMessage gameInfoMessage = new GameInfoMessage();
            gameInfoMessage.setResult(true);
            gameInfoMessage.setGamename(game.getGamename());
            gameInfoMessage.setComments(game.getComments());
            gameInfoMessage.setMark(game.getMark());

            return gameInfoMessage;
        }
        Message message = new Message();
        message.setResult(false);
        message.setMessage("用户未登录。");
        return message;
    }

    @RequestMapping(value = "/data/game/ranks",method = RequestMethod.GET)
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

    @RequestMapping(value = "/data/game/comments",method = RequestMethod.GET)
    public Message comments(HttpSession session,
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

}
