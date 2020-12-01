package controller;

import bean.Comment;
import bean.Rank;
import bean.messageBean.RankMessage;
import bean.User;
import bean.messageBean.InformationMessage;
import bean.messageBean.LoginMessage;
import bean.messageBean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/data/user/register",method = RequestMethod.POST)
    public Message register(@RequestParam(value = "userName",required = false) String username,
                            @RequestParam(value = "password",required = false) String password,
                            @RequestParam(value = "phone",required = false) String phone,
                            @RequestParam(value = "email") String email){
        Message message = new Message();
        if(username == null || password == null || "".equals(username) || "".equals(password)){
            message.setResult(false);
            message.setMessage("用户名和密码不能为空。");
            return message;
        }
        if(userService.selectUserByName(username)!=null){
            message.setResult(false);
            message.setMessage("用户名已被使用。");
            return message;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        if(userService.insertUser(user)!=0){
            message.setResult(true);
            return message;
        }
        message.setResult(false);
        return message;
    }

    @RequestMapping(value = "/data/user/login",method = RequestMethod.GET)
    public Message login(@RequestParam(value = "userName",required = false) String name,
                         @RequestParam(value = "password",required = false) String password,
                         HttpSession session){
        Message message = new Message();
        if(name == null && password == null){
            message.setResult(false);
            message.setMessage("用户名和密码不能为空。");
            return message;
        }
        if(userService.selectUserByName(name)==null){
            message.setResult(false);
            message.setMessage("用户不存在。");
            return message;
        }
        User user = userService.selectUserByName(name);
        if(user.getPassword().equals(password)){

            //用session保存了登录的用户
            session.setAttribute("username",user.getUsername());
            LoginMessage loginMessage = new LoginMessage();
            loginMessage.setResult(true);
            loginMessage.setUsername(user.getUsername());
            return loginMessage;
        }
        message.setResult(false);
        message.setMessage("用户名或密码错误。");
        return message;
    }

    @RequestMapping(value = "/data/user/logout",method = RequestMethod.GET)
    public Message logout(HttpSession session){
        Message message = new Message();
        if(session.getAttribute("username")!=null){
            session.removeAttribute("username");
            message.setResult(true);
            return message;
        }
        message.setResult(false);
        message.setMessage("用户未登录。");
        return message;
    }

    @RequestMapping(value = "/data/user/information",method = RequestMethod.GET)
    public Message information(HttpSession session){
        if(session.getAttribute("username")!=null){
            String username = (String)session.getAttribute("username");
            User user = userService.selectUserByName(username);
            InformationMessage informationMessage = new InformationMessage();
            informationMessage.setResult(true);
            informationMessage.setUserName(user.getUsername());
            informationMessage.setEmail(user.getEmail());
            informationMessage.setPhone(user.getPhone());
            return informationMessage;
        }
        Message message = new Message();
        message.setResult(false);
        message.setMessage("用户未登录。");
        return message;
    }

    @RequestMapping(value = "/data/user/rank",method = RequestMethod.POST)
    public Message rank(HttpSession session,
                          @RequestParam(value = "gameId") int gameId,
                          @RequestParam(value = "date") String date,
                          @RequestParam(value = "score") int score){
        if(session.getAttribute("username") == null){
            Message message = new Message();
            message.setResult(false);
            message.setMessage("用户未登录。");
            return message;
        }else {
            String username = (String) session.getAttribute("username");
            Rank rank = new Rank();

            rank.setUsername(username);
            rank.setGameId(gameId);
            rank.setDate(date);
            rank.setScore(score);

            Message message = new Message();
            if(userService.insertRank(rank) != 0){
                message.setResult(true);
                return message;
            }
            message.setResult(false);
            return message;
        }
    }

    @RequestMapping(value = "/data/user/rank",method = RequestMethod.GET)
    public Message rank(HttpSession session){
        if(session.getAttribute("username") == null){
            Message message = new Message();
            message.setResult(false);
            message.setMessage("用户未登录。");
            return message;
        }else {
            String username = (String) session.getAttribute("username");
            List<Rank> ranks = userService.selectRanksByUsername(username);
            RankMessage rankMessage = new RankMessage();
            rankMessage.setRanks(ranks);
            rankMessage.setResult(true);
            return rankMessage;
        }
    }

    @RequestMapping(value = "/data/user/comment",method = RequestMethod.POST)
    public Message comment(HttpSession session,
                        @RequestParam(value = "gameId") int gameId,
                        @RequestParam(value = "date") String date,
                        @RequestParam(value = "content") String content,
                        @RequestParam(value = "mark") int mark){
        if(session.getAttribute("username") == null){
            Message message = new Message();
            message.setResult(false);
            message.setMessage("用户未登录。");
            return message;
        }else {
            String username = (String) session.getAttribute("username");
            Comment comment = new Comment();

            comment.setUsername(username);
            comment.setGameid(gameId);
            comment.setDate(date);
            comment.setContent(content);
            comment.setMark(mark);

            Message message = new Message();
            if(userService.insertComment(comment) != 0){
                message.setResult(true);
                return message;
            }
            message.setResult(false);
            return message;
        }
    }
}
