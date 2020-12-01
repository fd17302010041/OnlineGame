package service;

import bean.Comment;
import bean.Game;
import bean.Rank;
import mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private GameMapper gameMapper;

    @Autowired
    public GameService(GameMapper gameMapper){
        this.gameMapper = gameMapper;
    }

    public Game selectGamerByName(String name){
        return this.gameMapper.selectGamerByName(name);
    }

    public Game selectGamerById (int gameId){
        return this.gameMapper.selectGamerById(gameId);
    }

    public List<Rank> selectRanksByGameId(int gameId){
        return gameMapper.gameRank(gameId);
    }

    public List<Comment> selectCommentsByGameId(int gameId){
        return gameMapper.commentList(gameId);
    }

    public int insertGame(Game game){
        return gameMapper.insertGame(game);
    }
}
