<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
    <title>coreParameterForm</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script type="text/javascript" src="${root}/commons/js/appjs/manager/core_parameter/core_parameter_form.js"></script> 
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
						<form class="form-horizontal m-t" id="coreParameterForm">
							<div class="form-group">
								<label class="col-sm-3 control-label">参数名：</label>
								<div class="col-sm-8">
									<input id="paramName" name="paramName" class="form-control" type="text" value="${coreParameter.paramName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">参数类型：</label>
								<div class="col-sm-8">
									<label class="radio-inline"> 
										<input type="radio" name="paramType" value="sys"> 系统参数</input>
									</label> 
									<label class="radio-inline"> 
										<input type="radio" name="paramType" value="usr"> 用户参数</input>
									</label> 																		
									<script>$("input[name='paramType'][value='${coreParameter.paramType}']").attr("checked",true); </script>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">参数代码：</label>
								<div class="col-sm-8">
									<input id="paramCode" name="paramCode" class="form-control" type="text" value="${coreParameter.paramCode}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">参数值：</label>
								<div class="col-sm-8">
									<input id="paramValue" name="paramValue" class="form-control" type="text" value="${coreParameter.paramValue}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">参数说明：</label>
								<div class="col-sm-8">
									<textarea id="paramDesc" name="paramDesc" rows="5" cols="63" class="form-control">${coreParameter.paramDesc}</textarea>
								</div>
							</div>																					
							<c:if test="${actionType =='view'}">
							<div class="form-group">
								<label class="col-sm-3 control-label">创建时间：</label>
								<div class="col-sm-8">
									<input class="form-control" type="text" value='<fmt:formatDate value="${coreParameter.createdTime}" pattern="yyyy-MM-dd HH:mm:ss"/> '>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">修改时间：</label>
								<div class="col-sm-8">
									<input class="form-control" type="text" value='<fmt:formatDate value="${coreParameter.modifiedTime}" pattern="yyyy-MM-dd HH:mm:ss"/> '>
								</div>
							</div>							
							</c:if>							
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
								  	<input type="hidden" value="${root}" id="basePathUrl">
								  	<input type="hidden" value="${coreParameter.coreParamId}" name="coreParamId" id="coreParamId">
								  	<input type="hidden" value="${actionType}" id="actionType">		
								  	<c:if test="${actionType !='view'}">					
										<button type="button" id="coreParameterBtn" class="btn btn-primary">提交</button>
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
