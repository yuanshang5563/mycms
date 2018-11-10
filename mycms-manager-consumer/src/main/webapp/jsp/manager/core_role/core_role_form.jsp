<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/header.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>roleForm</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript" src="${root}/commons/js/appjs/manager/core_role/core_role_form.js"></script> 
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>   </h5>
					</div>
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="coreRoleForm">
							<input id="userId" name="userId" type="hidden"> 
							<input id="menuIds" name="menuIds" type="hidden">
							<div class="form-group">
								<label class="col-sm-3 control-label">角色名：</label>
								<div class="col-sm-8">
									<input id="roleName" name="roleName" class="form-control" type="text" value="${coreRole.roleName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">备注：</label>
								<div class="col-sm-8">
									<input id="remark" name="remark" class="form-control" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单权限：</label>
								<div class="col-sm-8">
									<div id="menuTree"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
								  	<input type="hidden" value="${root}" id="basePathUrl">
								  	<input type="hidden" value="${coreRole.coreRoleId}" name="coreRoleId" id="coreRoleId">
								  	<input type="hidden" value="${viewFlag}" id="viewFlag">								
									<button type="submit" class="btn btn-primary">提交</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
