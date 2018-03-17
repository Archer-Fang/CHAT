package se.zust.orm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import se.zust.orm.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration/*("server.port:8888")*/
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void insertUser() throws Exception {
        userService.insertUser("1","1","1");
    }

    @Test
    public void selectUserByUsername() throws Exception {
        userService.selectUserByUsername("1150299260");
    }

    @Test
    public void selectUserById() throws Exception {
        userService.selectUserById(1);
    }

    @Test
    public void selectUserByNickName() throws Exception {
        userService.selectUserByNickName("fzj");

    }
    @Test
    public void selectUserFriendsByUserId() throws Exception {
        userService.selectUserFriendsByUserId(12);

    }


}