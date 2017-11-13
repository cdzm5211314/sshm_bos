package com.chen.bos.web.action.user;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.chen.bos.domain.User;
import com.chen.bos.service.user.UserService;
import com.chen.bos.web.action.base.BaseAction;

public class UserAction extends BaseAction<User> {
	
	//属性驱动
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	//注入service
	@Resource(name="userService")
	private UserService userService;
	
	//用户退出
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "logoutSUCCESS";
	}
	
	// 用户登录
	public String login(){
		//校验验证码是否正确
		String key = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		if (key == null || !key.equals(checkcode)) {
			//验证失败
			this.addActionError(this.getText("checkcodefail"));
			return "loginINPUT";
		}
		
		//调用业务层
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
