package se.zust.orm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.zust.orm.bean.UserFriendsBean;
import se.zust.orm.dao.UserMapper;
import se.zust.orm.entity.User;
import se.zust.orm.entity.UserExample;
import se.zust.orm.service.UserService;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import static se.zust.orm.util.BASE64.encryptBASE64;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional    public int insertUser(String username,String password,String nickname) {
        User user=  new User();

        user.setUsername(username);

        try {
            user.setPassword(encryptBASE64(password.getBytes(Charset.defaultCharset())));
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setNickname(nickname);
            user.setAvatar("/image/avatar/avatar" + new Random().nextInt(10) + ".jpg");



            return  userMapper.insert(user);
    }

    @Override
    public User selectUserByUsername(String username) {
        UserExample userExample=new UserExample();
        userExample.or().andUsernameEqualTo(username);
        List<User> list=userMapper.selectByExample(userExample);
        return list.get(0);
    }
    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectUserByNickName(String nickname) {
        UserExample userExample=new UserExample();
        userExample.or().andNicknameEqualTo(nickname);
        return (userMapper.selectByExample(userExample)).get(0);
    }

    @Override
    public List<UserFriendsBean> selectUserFriendsByUserId(Integer id) {
        return userMapper.selectFriends(id);
    }
}
