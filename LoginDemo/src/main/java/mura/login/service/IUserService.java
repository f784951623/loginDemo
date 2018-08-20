package mura.login.service;

import java.util.List;

import mura.login.bean.User;

public interface IUserService {
	User UserLogin(String username,String password);
	
	List<User> getUserList();
}
