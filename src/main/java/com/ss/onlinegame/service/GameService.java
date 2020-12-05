package com.ss.onlinegame.service;

import com.ss.onlinegame.bean.Comment;
import com.ss.onlinegame.bean.Game;
import com.ss.onlinegame.bean.Rank;
import com.ss.onlinegame.mapper.GameMapper;
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

    public int insertComment(Comment comment){
        return gameMapper.insertComment(comment);
    }

    public int insertRank(Rank rank){
        return gameMapper.insertRank(rank);
    }

//    public int insertGame(Game game){
//        return gameMapper.insertGame(game);
//    }
}
