package mura.login.mapper;

import java.util.List;

import mura.login.bean.User;

public interface UserMapper {
	/*
	 * 查詢一個用戶訊息
	 * @return 如果查到了會把紀錄封裝成user對象返回
	 * 		         如果沒查到，返回null
	 * */
	User selectByName(String username);
	
	/*
	 * 查詢整個表單的用戶訊息
	 * */
	
	List<User> selectAll();
}
