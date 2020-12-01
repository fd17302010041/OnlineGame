package service;

import bean.Comment;
import bean.Rank;
import bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

//    public User selectUserById(int id) {
//        return userMapper.selectUserById(id);
//    }

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public int insertComment(Comment comment){
        return userMapper.insertComment(comment);
    }

    public int insertRank(Rank rank){
        return userMapper.insertRank(rank);
    }

    public List<Rank> selectRanksByUsername(String username){
        return userMapper.selectRanksByUsername(username);
    }
}