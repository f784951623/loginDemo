package mura.login.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mura.login.bean.ResponseResult;
import mura.login.bean.User;
import mura.login.service.ex.PasswordNotMatchException;
import mura.login.service.ex.UserNotFoundException;
import mura.login.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/index.do")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/success.do")
	public String showSuccess(){
		return "success";
	}
	
	@RequestMapping("/getUserList.do")
	@ResponseBody
	public ResponseResult<List<User>> getList(){
		ResponseResult<List<User>> rr =null;
		try {
			List<User> list  = userService.getUserList();
			rr = new ResponseResult<List<User>>(1,"成功");
			//獲取list資料綁進rr
			rr.setData(list);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return rr;
	}
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username,String password,HttpSession session) throws UserNotFoundException, PasswordNotMatchException{
		//1.聲明rr對象
		ResponseResult<Void> rr =null;
		try{
			//2.調用業務層方法:login();
			User user = userService.UserLogin(username, password);
			//3.rr設置state:1 message:登錄成功
			rr= new ResponseResult<Void>(1,"登錄成功");
			//4.把user對象綁訂到session
			session.setAttribute("user", user);
		}catch (RuntimeException e){
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
}
