<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选项卡主面板内容</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui核心类库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/default.css">
<script type="text/javascript">
	$(function(){
		//对菜单提那家click事件
		$(".mymenu").click(function(){
			//执行选项卡控件 add 方法
			$(".easyui-tabs").tabs('add',{
				title : $(this).html(),
				closable : true
			});
		});
		
	});
		
</script>

</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'xxx信息管理系统'" style="height:150px;">北部</div>
	<div data-options="region:'west',title:'菜单导航'" style="width:150px;">
		<!-- 折叠菜单 -->
		<div class="easyui-accordion" data-options="fit:true">
			<!-- 每个div就是一个菜单 -->
			<div data-options="title:'基本功能'">
				<a class="mymenu">基本功能菜单一</a>
			</div>
			<div data-options="title:'系统管理'">
				<a class="mymenu">系统管理菜单二</a>
			</div>
			<div data-options="title:'控制面板'">控制面板菜单三</div>
		</div>
	</div>
	<div data-options="region:'center'">
		<!-- 选项卡 -->
		<div class="easyui-tabs" data-options="fit:true,">
			<!-- 每个div 就是一个选项卡 -->
			<div data-options="title:'选项卡一',closable:'true'">选项卡一</div>
			<div data-options="title:'选项卡二',closable:'true'">选项卡二</div>
			<div data-options="title:'选项卡三',closable:'true'">选项卡三</div>
		</div>
	</div>
	<div data-options="region:'south',title:'版权所有'" style="height:100px;">南部</div>
	
	
</body>
</html>