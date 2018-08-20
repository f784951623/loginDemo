package mura.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mura.login.bean.User;
import mura.login.mapper.UserMapper;

public class testuser {
	Scanner scn = new Scanner(System.in);
	@Test
	public void testLogin(){
		AbstractApplicationContext ac=
				new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		
		
		
		User user = new User();
		System.out.println("輸入帳號");
		user.setUsername(scn.nextLine());
		System.out.println("輸入密碼");
		user.setPassword(scn.nextLine());
		if(um.selectByName(scn.nextLine())!=null){
			System.out.println("登入成功");
		}else{
			
		}
		ac.close();
	}
	@Test
	public void testGetAll(){
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = ac.getBean("userMapper",UserMapper.class);
		List<User> list = um.selectAll();
		
		for (User user : list) {
			System.out.println(user);
		}
		ac.close();
	}
}
