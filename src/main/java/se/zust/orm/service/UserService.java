package se.zust.orm.service;

import se.zust.orm.bean.UserFriendsBean;
import se.zust.orm.entity.User;

import java.util.List;

public interface UserService {
    int insertUser(String username,String password,String nickname);
    User selectUserByUsername(String username);
    User selectUserById(Integer id);
    User selectUserByNickName(String nickname);
    List<UserFriendsBean> selectUserFriendsByUserId(Integer id);

}
