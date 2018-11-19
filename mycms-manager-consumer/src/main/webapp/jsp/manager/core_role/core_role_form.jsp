<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
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
							<div class="form-group">
								<label class="col-sm-3 control-label">角色名：</label>
								<div class="col-sm-8">
									<input id="roleName" name="roleName" class="form-control" type="text" value="${coreRole.roleName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">角色：</label>
								<div class="col-sm-8">
									<input id="role" name="role" class="form-control" type="text" value="${coreRole.role}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单权限：</label>
								<div class="col-sm-8">
									<div id="coreMenuTree"></div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<input id="coreMenuIds" name="coreMenuIds" type="hidden">
								  	<input type="hidden" value="${root}" id="basePathUrl">
								  	<input type="hidden" value="${coreRole.coreRoleId}" name="coreRoleId" id="coreRoleId">
								  	<input type="hidden" value="${actionType}" id="actionType">							
									<button type="button" class="btn btn-primary" onclick="coreRoleFormSave()">提交</button>
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
