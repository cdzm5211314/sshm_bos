package com.chen.bos.service.user;

import com.chen.bos.domain.User;


public interface UserService {
	
	//用户登录操作
	public User login(User user);
	
	//用户修改密码
	public void editPassword(User user);
	
}
