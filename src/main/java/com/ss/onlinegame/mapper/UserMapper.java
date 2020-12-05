package com.ss.onlinegame.mapper;

import com.ss.onlinegame.bean.Comment;
import com.ss.onlinegame.bean.Rank;
import com.ss.onlinegame.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User selectUserByName(String username);

    @Insert("insert into user(username,password,email,phone) values (#{username},#{password},#{email},#{phone})")
    int insertUser(User user);

    @Select("select * from rank where username = #{username}")
    List<Rank> selectRanksByUsername(String username);

    @Insert("insert into comment(username,gameId,content,mark,date) values (#{username},#{gameId},#{content},#{mark},#{date})")
    int insertComment(Comment comment);

    @Insert("insert into rank(username,gameId,score,date) values (#{username},#{gameId},#{score},#{date})")
    int insertRank(Rank rank);
}
