<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
    <title>coreDictionariesGroupForm</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script src="${root}/commons/js/appjs/manager/core_dictionaries_group/core_dictionaries_group_form.js"></script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="groupForm">
							<div class="form-group">
								<label class="col-sm-3 control-label">上级字典组：</label>
								<div class="col-sm-8">
									<input class="form-control" type="text" value="${parentGroupName}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">字典组名称：</label>
								<div class="col-sm-8">
									<input id="dictGroupName" name="dictGroupName" class="form-control" type="text" value="${coreDictionariesGroup.dictGroupName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">字典组代码：</label>
								<div class="col-sm-8">
									<input id="dictGroupCode" name="dictGroupCode" class="form-control" type="text" value="${coreDictionariesGroup.dictGroupCode}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">字典组说明：</label>
								<div class="col-sm-8">
									<textarea id="dictGroupDesc" name="dictGroupDesc" rows="5" cols="63" class="form-control">${coreDictionariesGroup.dictGroupDesc}</textarea>
								</div>
							</div>							

							<input type="hidden" value="${coreDictionariesGroup.coreDictGroupId}" id="coreDictGroupId" name="coreDictGroupId" >
							<input type="hidden" value="${coreDictionariesGroup.parentCoreDictGroupId}" id="parentCoreDictGroupId" name="parentCoreDictGroupId">
							<input type="hidden" value="${root}" id="basePathUrl">
							<input type="hidden" value="${actionType}" id="actionType">		
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<c:if test="${actionType !='view'}">
										<button type="button" class="btn btn-primary" id="groupBtn">提交</button>
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