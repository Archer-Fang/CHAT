package se.zust.orm.controller;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.zust.orm.bean.UserBean;
import se.zust.orm.bean.UserFriendsBean;
import se.zust.orm.entity.User;
import se.zust.orm.service.RelationService;
import se.zust.orm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static se.zust.orm.util.BASE64.decryptBASE64;


@Controller
public class PageController {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");

	private static final Map<Long,HttpSession> userSessionMap = new HashMap<>();

	@Autowired
	UserService userService;
	@Autowired
	RelationService relationService;

	private Logger logger = Logger.getLogger(this.getClass());




	@GetMapping(value = "/")
	public String index(HttpSession session,Model model) {

		session.getAttribute("userBean");

		return "index";
	}

	@GetMapping(value = "/chat")
	public String chat(Model model,HttpSession session) {
		UserBean userBean=(UserBean) session.getAttribute("userBean");
		List<UserFriendsBean> userFriendsBeanList=userService.selectUserFriendsByUserId(userBean.getId());
		logger.info("userFriendsBeanList:"+ JSON.toJSONString(userFriendsBeanList));
		logger.info("userFriendsBeanList:"+ JSON.toJSONString(userFriendsBeanList.get(0).getJoinTime()));

		model.addAttribute("userFriendsBeanList", userFriendsBeanList);
		model.addAttribute("userBean",userBean);

		return "chat";
	}

	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}


	@PostMapping(value = "/login")
	public String chatPage(HttpServletRequest request, HttpSession session,Model model) throws Exception {
		String username=request.getParameter("username");
		String password=request.getParameter("password");



		User user=userService.selectUserByUsername(username);

		try {
			logger.info("password:" + new String(decryptBASE64(password)));
		} catch (Exception e) {
			e.printStackTrace();
		}



			if(password.equals(new String(decryptBASE64(user.getPassword())))){

				UserBean userBean=new UserBean(user.getId(),user.getUsername(),user.getPassword(),user.getNickname(),user.getAvatar(),simpleDateFormat.format(new Date()));
				session.setAttribute("userBean",userBean);
				session.setMaxInactiveInterval(86400);  //把session的时长设为1天
				userSessionMap.put(Long.valueOf(user.getId()),session); //把当前登录用户的userId和session放入userSessionMap
				logger.info("userBean.getId():"+userBean.getId());
				logger.info("userBean.getJoinTime:"+userBean.getJoinTime());
				logger.info("用户" + userBean.getUsername() + "登录");




				return "redirect:/chat";

			}
			else {
				return "redirect:/login";
			}


	}

	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}
	@PostMapping(value = "/register")
	public String register(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");

		// TODO 参数校验
		userService.insertUser(username,password,nickname);
		int userId=userService.selectUserByUsername(username).getId();
		relationService.insertRelationship(userId,1);

		return "login";
	}

	@PostMapping("/chat/add")
	public String add(HttpSession session,HttpServletRequest request) {
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		int userId=userBean.getId();
		logger.info("userId:"+userId);
		String friend=request.getParameter("friend");
		User user=userService.selectUserByUsername(friend);
		int friendId=user.getId();
		logger.info("friendId:"+friendId);
		relationService.insertRelationship(userId,friendId);

		return null;
	}


	@PostMapping("/chat/delete")
	public String delete(HttpSession session,HttpServletRequest request) {
		UserBean userBean=(UserBean)session.getAttribute("userBean");
		int userId=userBean.getId();
		logger.info("userId:"+userId);
		String friend=request.getParameter("friend");
		User user=userService.selectUserByUsername(friend);
		int friendId=user.getId();
		logger.info("friendId:"+friendId);
		relationService.delectRelationship(userId,friendId);

		return null;
	}


	@GetMapping("/logout")
	public String logout(HttpSession session){
		UserBean userBean =(UserBean) session.getAttribute("userBean");
		if(userBean != null){
			Long userId = Long.valueOf(userBean.getId());
			userSessionMap.get(userId).invalidate();
			userSessionMap.remove(userId);
			logger.info("用户" + userBean.getUsername() + "退出登录");
		}
		return "redirect:/login";
	}

}
