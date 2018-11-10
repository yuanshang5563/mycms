<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/header.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>roleList</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<script type="text/javascript" src="${root}/commons/js/appjs/manager/core_role/core_role_list.js"></script> 
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="col-sm-12">
			<div class="ibox">
				<div class="ibox-body">
					<div class="fixed-table-toolbar">
						<div class="columns pull-left">
							<button type="button" class="btn  btn-primary" onclick="add()">
								<i class="fa fa-plus hidden" aria-hidden="true"></i>添加
							</button>
						</div>
						<div class="columns pull-right">
							<button class="btn btn-success" onclick="reLoad()">查询</button>
						</div>

						<div class="columns pull-right col-md-2 nopadding">
							<input id="roleName" name="roleName" type="text" class="form-control" placeholder="角色名">
						</div>
					</div>									
					<table id="coreRoleTable" data-mobile-responsive="true"></table>
					<input type="hidden" value="${root}" id="basePathUrl">
				</div>
			</div>
		</div>
		<!--shiro控制bootstraptable行内按钮看见性 来自bootdo的创新方案 -->
		<div>
			<script type="text/javascript">
				//var s_edit_h = 'hidden';
				//var s_remove_h = 'hidden';
				var s_edit_h = '';
				var s_remove_h = '';
			</script>
		</div>
		<!-- 
		<div shiro:hasPermission="sys:role:edit">
			<script type="text/javascript">
				s_edit_h = '';
			</script>
		</div>
		<div shiro:hasPermission="sys:role:remove">
			<script type="text/javascript">
				var s_remove_h = '';
			</script>
		</div>
		 -->
	</div>
</body>

</html>