package com.chen.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 
 * @ClassName: LoginInterceptor
 * @Description: 自定义拦截器
 * @Author: ChenD
 * @CreateDate: 2017-11-13 上午10:27:37
 */
public class LoginInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断用户是否登录,如果没有登录,跳转到登录页面,如果登录允许访问
		if (ServletActionContext.getRequest().getSession().getAttribute("user") == null) {
			//没有登陆(先获取这个action对象,ActionSupport类型)
			ActionSupport action = (ActionSupport) invocation.getAction();
			//国际化信息
			action.addActionError(action.getText("nologin"));
			//跳转到登录
			return "login";
		}else {
			//已经登陆,往下执行
			return invocation.invoke();
		}
	}
}
