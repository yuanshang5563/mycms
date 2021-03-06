<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>menuList</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta charset="utf-8">
	<%@include file="/commons/header.jsp"%>
	<script src="${root}/commons/js/appjs/manager/core_menu/core_menu_list.js"></script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="col-sm-12">
			<div class="ibox">
				<div class="ibox-body">
					<div id="exampleToolbar" role="group" class="t-bar">
						<shiro:hasPermission name="core:coreMenu:addAndEdit">
						<button type="button" class="btn btn-primary" title="在根节点下添加菜单" onclick="add('0','add')">
							<i class="fa fa-plus" aria-hidden="true"></i>添加
						</button>
						</shiro:hasPermission>
						<shiro:hasRole name="super_admin">
						<button type="button" class="btn btn-primary" onclick="reloadPermissions()">
							<i class="fa fa-plus" aria-hidden="true"></i>加载权限
						</button>	
						</shiro:hasRole>					
					</div>
					<table id="menuTable" data-mobile-responsive="true">
					</table>
					<input type="hidden" value="${root}" id="basePathUrl">
				</div>
			</div>
		</div>
		<!--shiro控制bootstraptable行内按钮看见性 来自bootdo的创新方案-->
		<div>
			<script type="text/javascript">
 				var s_add_h = 'hidden';
				var s_edit_h = 'hidden';
				var s_remove_h = 'hidden';
				var s_view_h = 'hidden';
			</script>
		</div>
		<div>
		<shiro:hasPermission name="core:coreMenu:addAndEdit">
			<script type="text/javascript">
				s_add_h = '';
				s_edit_h = '';
			</script>
		</shiro:hasPermission>
		<shiro:hasPermission name="core:coreMenu:del">
			<script type="text/javascript">
				s_remove_h = '';
			</script>
		</shiro:hasPermission>
			<script type="text/javascript">
				s_view_h = '';
			</script>		
		</div>	
	</div>
</body>
</html>