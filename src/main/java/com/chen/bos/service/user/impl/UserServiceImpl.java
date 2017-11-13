package com.chen.bos.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.chen.bos.dao.GenericDAO;
import com.chen.bos.domain.User;
import com.chen.bos.service.base.BaseService;
import com.chen.bos.service.user.UserService;

public class UserServiceImpl extends BaseService implements UserService {

	// 注入DAO
	@Resource(name = "userDAO")
	private GenericDAO<User, String> userDAO;

	@Transactional(readOnly = true)
	public User login(User user) {
		List<User> list = userDAO.findByNamedQuery("User.login", user.getUsername(), user.getPassword());
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	@Transactional(readOnly = false)
	public void editPassword(User user) {
		userDAO.update(user);
	}

}
