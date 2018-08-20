package mura.login.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mura.login.service.ex.PasswordNotMatchException;
import mura.login.service.ex.UserNotFoundException;
import mura.login.mapper.UserMapper;
import mura.login.bean.User;

@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;

	public User UserLogin(String username, String password) {
		User user = userMapper.selectByName(username);
		if (user == null) {
			throw new UserNotFoundException("帳號不存在");
		} else {
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				throw new PasswordNotMatchException("密碼錯誤");
			}
		}
	}

	public List<User> getUserList() {
		List<User> list = userMapper.selectAll();
		return list;
	}

}
