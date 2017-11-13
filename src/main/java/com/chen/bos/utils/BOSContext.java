package com.chen.bos.utils;

import org.apache.struts2.ServletActionContext;

import com.chen.bos.domain.User;

/**
 * 
 * @ClassName: BOSContext
 * @Description: 系统框架 上下文 
 * @Author: ChenD
 * @CreateDate: 2017-11-13 下午3:36:06
 */
public class BOSContext {
	
	/**
	 * 
	 * @方法的名称: getCurrentUser
	 * @Description: 获取当前登录的用户
	 * @Author: chenD
	 * @CreateDate: 2017-11-13 下午3:37:30
	 * @return User
	 */
	public static User getCurrentUser(){
		return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
	}
}
