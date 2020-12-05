package com.ss.onlinegame.mapper;

import com.ss.onlinegame.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GameMapper {

    @Select("select * from game where gamename = #{gamename}")
    Game selectGamerByName(String name);

    @Select("select * from game where gameid = #{gameid}")
    Game selectGamerById(int gameid);

    @Select("select * from rank where gameid = #{gameid}")
    List<Rank> gameRank(int gameid);

    @Select("select * from comment where gameid = #{gameid}")
    List<Comment> commentList (int gameid);

    @Insert("insert into comment(username,gameId,comment,grade,date) values (#{username},#{gameId},#{comment},#{grade},#{date)")
    int insertComment(Comment comment);

    @Insert("insert into comment(username,gameId,comment,grade,date) values (#{username},#{gameId},#{comment},#{grade},#{date)")
    int insertRank(Rank rank);




//    @Insert("insert into game(gamename,mark) values (#{gamename},#{mark})")
//    int insertGame(Game mygame);
}
