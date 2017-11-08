<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ztree 树形菜单,完成选项卡的联动</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui核心类库 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<link id="easyuiTheme" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/default.css">
<!-- 导入 ztree  -->
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.all-3.5.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/ztree/zTreeStyle.css">

<script type="text/javascript">
	$(function(){
		//配置ztree 属性
		var setting = {
			data : {
				simpleData : {
					//启用简单数据格式
					enable : true
				}
			},
			callback : {
				onClick: function(event, treeId, treeNode, clickFlag){
					// 打印page属性 
					// 只针对有page属性节点 进行操作
					if(treeNode.page != null){
						// 判断选项卡是否存在，不存在添加 
						if($(".easyui-tabs").tabs('exists',treeNode.name)){
							// 选项卡存在，切换到选项卡
							$(".easyui-tabs").tabs('select',treeNode.name);
						}else{
							// 选项卡不存在
							// 添加新的选项卡 
							$(".easyui-tabs").tabs('add', {
								title : treeNode.name,
								content : '<div style="width:100%;height:100%;overflow:hidden;">'
									+ '<iframe src="'
									+ treeNode.page
									+ '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>',
								closable:true
							});
						}
						
					}
				}
			}
		};
		//准备节点数据
		var zNodes = [
			{name:"基本数据",id:1,pId:0},              
			{name:"百度",id:11,pId:1,page:"http://www.baidu.com"},              
			{name:"友情链接",id:12,pId:1,page:"${pageContext.request.contextPath}/easyuidemo/test.jsp"},  
			
			{name:"系统管理",id:2,pId:0},              
			{name:"管理一",id:21,pId:2},              
			{name:"管理二",id:22,pId:2},  
			
			{name:"系统应用",id:3,pId:0},    
			{name:"应用一",id:31,pId:3},
		];
		
		//初始化ztree
		$.fn.zTree.init($("#menu"), setting, zNodes);
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
				<ul id="menu" class="ztree"></ul>
			</div>
			<div data-options="title:'系统管理'">
				系统管理菜单二
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