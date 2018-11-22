<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
    <title>deptForm</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script src="${root}/commons/js/appjs/manager/core_dept/core_dept_form.js"></script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="coreDeptForm">
							<div class="form-group">
								<label class="col-sm-3 control-label">上级部门：</label>
								<div class="col-sm-8">
									<input class="form-control" type="text" value="${parentDeptName}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门名称：</label>
								<div class="col-sm-8">
									<input id="deptName" name="deptName" class="form-control" type="text" value="${coreDept.deptName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门代码：</label>
								<div class="col-sm-8">
									<input id="deptCode" name="deptCode" class="form-control" type="text" value="${coreDept.deptCode}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">排序号：</label>
								<div class="col-sm-8">
									<input id="orderNum" name="orderNum" class="form-control" type="text" value="${coreDept.orderNum}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">部门说明：</label>
								<div class="col-sm-8">
									<textarea id="deptDesc" name="deptDesc" rows="5" cols="63" class="form-control">${coreDept.deptDesc}</textarea>
								</div>
							</div>							

							<input type="hidden" value="${coreDept.coreDeptId}" id="coreDeptId" name="coreDeptId" >
							<input type="hidden" value="${coreDept.parentCoreDeptId}" id="parentCoreDeptId" name="parentCoreDeptId">
							<input type="hidden" value="${coreDept.delFlag}" id="delFlag" name="delFlag" >
							<input type="hidden" value="${root}" id="basePathUrl">
							<input type="hidden" value="${actionType}" id="actionType">		
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<c:if test="${actionType !='view'}">
										<button type="button" class="btn btn-primary" id="coreDeptBtn">提交</button>
									</c:if>
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