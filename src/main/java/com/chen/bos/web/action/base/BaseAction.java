package com.chen.bos.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @ClassName: BaseAction
 * @Description: 业务层代码的复用 
 * @Author: ChenD
 * @CreateDate: 2017-11-9 下午4:43:56
 * @param <T>
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private T model;

	public T getModel() {
		return model;
	}

	public BaseAction() {
		// 读取子类 命名中 泛型类型
		Type type = getClass().getGenericSuperclass();
		Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
		Class modelClass = (Class) trueType;
		try {
			model = (T) modelClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取实例化泛型信息失败...");
		}

	}
}
