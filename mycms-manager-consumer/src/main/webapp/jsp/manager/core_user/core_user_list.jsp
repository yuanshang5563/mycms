<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
    <title>userList</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript" src="${root}/commons/js/appjs/manager/core_user/core_user_list.js"></script> 
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="row">
			<div class="col-sm-3">
				<div class="ibox ibox-body">
					<div class="ibox-title">
						<h5>选择部门</h5>
					</div>
					<div class="ibox-content">
						<div id="jstree"></div>
					</div>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="ibox">
					<div class="ibox-body">
						<div class="fixed-table-toolbar">
							<div class="columns pull-left">
								<shiro:hasPermission name="core:coreUser:addAndEdit">
								<button type="button" class="btn  btn-primary" onclick="add()">
									<i class="fa fa-plus hidden" aria-hidden="true"></i>添加
								</button>
								</shiro:hasPermission>
							</div>
							<div class="columns pull-right">
								<button class="btn btn-success" onclick="reLoad()">查询</button>
							</div>

							<div class="columns pull-right col-md-2 nopadding">
								<input id="userName" name="userName" type="text" class="form-control" placeholder="姓名">
							</div>
						</div>
						<table id="coreUserTable" data-mobile-responsive="true"></table>
					</div>
					<input type="hidden" value="${root}" id="basePathUrl">
				</div>
			</div>
		</div>
		<!--shiro控制bootstraptable行内按钮看见性 来自bootdo的创新方案 -->
		<div>
			<script type="text/javascript">
 				var s_edit_h = 'hidden';
				var s_remove_h = 'hidden';
				var s_resetPwd_h = 'hidden';
				var s_view_h = 'hidden';
			</script>
		</div>
		<div>
		<shiro:hasPermission name="core:coreUser:addAndEdit">
			<script type="text/javascript">
				s_edit_h = '';
			</script>
		</shiro:hasPermission>
		<shiro:hasPermission name="core:coreUser:del">
			<script type="text/javascript">
				s_remove_h = '';
			</script>
		</shiro:hasPermission>
		<shiro:hasPermission name="core:coreUser:resetPwd">
			<script type="text/javascript">
				s_resetPwd_h = '';
			</script>
		</shiro:hasPermission>
			<script type="text/javascript">
				s_view_h = '';
			</script>		
		</div>
	</div>
</body>
</html>