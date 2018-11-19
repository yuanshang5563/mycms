<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
    <title>user_form</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<link type="text/css" href="${root}/commons/css/plugins/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<script type="text/javascript" src="${root}/commons/js/plugins/datetimepicker/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript" src="${root}/commons/js/plugins/datetimepicker/local/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="${root}/commons/js/appjs/manager/core_user/core_user_form.js"></script> 
	<script type="text/javascript">

	</script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="coreUserForm">
							<input id="userId" name="userId" type="hidden">
							<div class="form-group">
								<label class="col-sm-3 control-label">姓名：</label>
								<div class="col-sm-8">
									<input id="realName" name="realName" class="form-control" type="text" value="${coreUser.realName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">用户名：</label>
								<div class="col-sm-8">
									<input id="userName" name="userName" class="form-control" type="text" value="${coreUser.userName}">
								</div>
							</div>
							<c:if test="${actionType == 'add'}">
							<div class="form-group">
								<label class="col-sm-3 control-label">密码：</label>
								<div class="col-sm-8">
									<input id="password" name="password" class="form-control" type="password">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">密码确认：</label>
								<div class="col-sm-8">
									<input id="comfirmPassword" class="form-control" type="password">
								</div>
							</div>	
							</c:if>	
							<div class="form-group">
								<label class="col-sm-3 control-label">性别:</label>
								<div class="col-sm-8">
									<label class="radio-inline"> 
										<input type="radio" name="sex" value="sex.0"> 未知</input>
									</label> 
									<label class="radio-inline"> 
										<input type="radio" name="sex" value="sex.1"> 男</input>
									</label>
									<label class="radio-inline"> 
										<input type="radio" name="sex" value="sex.2"> 女</input>
									</label>	
									<script>$("input[name='sex'][value='${coreUser.sex}']").attr("checked",true); </script>								
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">生日：</label>
								<div class="col-sm-8">
									<input id="birthday" name="birthday" class="form-control" type="text" readonly="readonly" 
									value='<fmt:formatDate value="${coreUser.birthday}" pattern="yyyy-MM-dd"/>'>
								</div>
							</div>																			
							<div class="form-group">
								<label class="col-sm-3 control-label">部门：</label>
								<div class="col-sm-8">
									<input id="coreDeptId" name="coreDeptId" class="hidden" value="${coreUser.coreDeptId}"> 
									<input id="deptName" name="deptName" class="form-control" type="text"
									style="cursor: pointer;" onclick="openDept()"
									readonly="readonly" value="${deptName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">手机：</label>
								<div class="col-sm-8">
									<input id="mobile" name="mobile" class="form-control" type="text" value="${coreUser.mobile}">
								</div>
							</div>							
							<div class="form-group">
								<label class="col-sm-3 control-label">E-mail：</label>
								<div class="col-sm-8">
									<input id="email" name="email" class="form-control" type="email" value="${coreUser.email}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">状态:</label>
								<div class="col-sm-8">
									<label class="radio-inline"> 
										<input type="radio" name="status" value="1"> 正常</input>
									</label> 
									<label class="radio-inline"> 
										<input type="radio" name="status" value="0"> 禁用</input>
									</label>
									<script>$("input[name='status'][value='${coreUser.status}']").attr("checked",true); </script>
								</div>
							</div>
							<input type="hidden" name="coreRoleIds" id="coreRoleIds">
							<div class="form-group">
								<label class="col-sm-3 control-label">角色</label>
								<div class="col-sm-8">
									<c:forEach items="${coreRoles}" var="role">
									<label class="checkbox-inline">
										<input name="coreRole" type="checkbox" value="${role.coreRoleId}">${role.roleName}</input>
									</label>
									</c:forEach>
								</div>
							</div>
						  	<input type="hidden" value="${root}" id="basePathUrl">
						  	<input type="hidden" value="${coreUser.coreUserId}" name="coreUserId" id="coreUserId">
						  	<input type="hidden" value="${viewFlag}" id="viewFlag">
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<button type="button" class="btn btn-primary" onclick="coreUserFormSave()">提交</button>
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