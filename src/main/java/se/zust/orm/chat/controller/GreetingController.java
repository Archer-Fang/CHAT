package se.zust.orm.chat.controller;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import se.zust.orm.chat.model.BaseMessage;
import se.zust.orm.chat.model.ChatMessage;
import se.zust.orm.chat.model.Greeting;
import se.zust.orm.chat.model.HelloMessage;
import se.zust.orm.entity.User;
import se.zust.orm.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class GreetingController {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    UserService userService;
    private Logger logger = Logger.getLogger(this.getClass());



    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        User user=userService.selectUserById(message.getId());
        ChatMessage chatMessage=new ChatMessage();
        chatMessage.setSendTime(simpleDateFormat.format(new Date()));
        chatMessage.setNickname(user.getNickname());
        chatMessage.setContent(message.getName());
        chatMessage.setAvatar(user.getAvatar());
        chatMessage.setUsername(user.getUsername());
        chatMessage.setReceiver("所有人");
        logger.info("chatMessage:"+chatMessage);
        return new Greeting( JSON.toJSONString(chatMessage) );
    }
    @MessageMapping("/chat")
    // 发送的订阅路径为/user/{userId}/message
    // /user/路径是默认的一个，如果想要改变，必须在config 中setUserDestinationPrefix
    public void cheatTo(BaseMessage baseMessage){
        User user=userService.selectUserByUsername(baseMessage.getSender());
        User user2=userService.selectUserByNickName(baseMessage.getReceiver());

        ChatMessage chatMessage=new ChatMessage();
        chatMessage.setSendTime(simpleDateFormat.format(new Date()));
        chatMessage.setNickname(user.getNickname());
        chatMessage.setContent(baseMessage.getContent());
        chatMessage.setAvatar(user.getAvatar());
        chatMessage.setUsername(user.getUsername());
        chatMessage.setReceiver(user.getNickname());


        //方法用于点对点测试
        System.out.println("baseMessage.getContent() = " + baseMessage.getContent());
        System.out.println("baseMessage.getSender() = " + baseMessage.getSender());
        System.out.println("baseMessage.getReceiver() = " + user2.getUsername());
        logger.info("destination:"+"/user/"+baseMessage.getSender()+"/chat");
        logger.info("chatMessage:"+chatMessage);



        messagingTemplate.convertAndSend("/user/"+user2.getUsername()+"/chat",JSON.toJSONString(chatMessage));
    }

}