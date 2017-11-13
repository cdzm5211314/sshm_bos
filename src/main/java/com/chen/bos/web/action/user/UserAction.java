package com.chen.bos.web.action.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.chen.bos.domain.User;
import com.chen.bos.service.user.UserService;
import com.chen.bos.utils.BOSContext;
import com.chen.bos.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction<User> {
	
	//属性驱动
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	
	//注入service
	@Resource(name="userService")
	private UserService userService;
	
	//用户密码修改
	public String editPassword(){
		//获取当前登录的用户
		User user = BOSContext.getCurrentUser();
		//model中封装了只有新修改的密码
		//将新密码保存到当前的登录用户中 
		user.setPassword(getModel().getPassword());
		//调用业务层
		Map<String,Object> resultMap = new HashMap<String, Object>();
		try {
			userService.editPassword(user);
			//修改密码成功
			resultMap.put("result","success");
			resultMap.put("msg",this.getText("editpasswordSUCCESSMSG"));
		} catch (Exception e) {
			e.printStackTrace();
			//修改密码失败
			resultMap.put("result","failure");
			resultMap.put("msg",this.getText("editpasswordFAILMSG"));
		}
		//将resultsMap转换成json数据
		
		ActionContext.getContext().getValueStack().push(resultMap);	
		
		return "editPasswordSUCCESS";
	}
	
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
