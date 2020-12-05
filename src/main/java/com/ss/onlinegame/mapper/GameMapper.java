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

    @Select("select * from game where gameId = #{gameId}")
    Game selectGamerById(int gameId);

    @Select("select * from rank where gameId = #{gameId} order by score DESC")
    List<Rank> gameRank(int gameId);

    @Select("select * from comment where gameId = #{gameId}")
    List<Comment> commentList (int gameId);

    @Insert("insert into comment(username,gameId,comment,grade,date) values (#{username},#{gameId},#{comment},#{grade},#{date})")
    int insertComment(Comment comment);

    @Insert("insert into rank(username,gameId,score,date) values (#{username},#{gameId},#{score},#{date})")
    int insertRank(Rank rank);


}
