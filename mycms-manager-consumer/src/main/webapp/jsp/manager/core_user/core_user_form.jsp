<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/header.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>user_form</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<link rel="stylesheet" type="text/css" href="${root}/commons/resources/css/commonsIcons.css"/> 
	<script type="text/javascript" src="${root}/commons/jslib/manager/core_user/core_user_form.js"></script> 
	<script type="text/javascript" src="/js/appjs/sys/user/add.js"></script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="signupForm">
							<input id="userId" name="userId" type="hidden">
							<div class="form-group">
								<label class="col-sm-3 control-label">姓名：</label>
								<div class="col-sm-8">
									<input id="name" name="name" class="form-control" type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">用户名：</label>
								<div class="col-sm-8">
									<input id="username" name="username" class="form-control"
										type="text">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">密码：</label>
								<div class="col-sm-8">
									<input id="password" name="password" class="form-control"
										type="password">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门：</label>
								<div class="col-sm-8">
									<input id="deptId" name="deptId" class="hidden"> <input
										id="deptName" name="deptName" class="form-control" type="text"
										style="cursor: pointer;" onclick="openDept()"
										readonly="readonly" placeholder="所属部门">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">E-mail：</label>
								<div class="col-sm-8">
									<input id="email" name="email" class="form-control"
										type="email">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">状态:</label>
								<div class="col-sm-8">
									<label class="radio-inline"> <input type="radio"
										name="status" value="1" /> 正常
									</label> <label class="radio-inline"> <input type="radio"
										name="status" value="0" /> 禁用
									</label>
								</div>
							</div>
							<input type="hidden" name="roleIds" id="roleIds">
							<div class="form-group">
								<label class="col-sm-3 control-label">角色</label>
								<div class="col-sm-8">
									<label th:each="role:${roles}" class="checkbox-inline">
										<input name="role" type="checkbox" th:value="${role.roleId}"
										th:text="${role.roleName}">
									</label>
								</div>
							</div>
							  <input type="hidden" value="${root}" id="basePathUrl">
							  <input type="hidden" value="${coreUserId}" id="coreUserId">
							  <input type="hidden" value="${viewFlag}" id="viewFlag">
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
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