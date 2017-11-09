package com.chen.bos.web.action.user;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.chen.bos.domain.User;
import com.chen.bos.service.user.UserService;
import com.chen.bos.web.action.base.BaseAction;

public class UserAction extends BaseAction<User> {

	//注入service
	@Resource(name="userService")
	private UserService userService;
	
	public String login(){
		
		User user = userService.login(getModel());
		if (user == null) {
			//登录失败
			this.addActionError(this.getText("loginfail"));
			return "loginINPUT";
		}else {
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSUCCESS";
		}
	}
	
}
