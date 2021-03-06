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
	<script type="text/javascript" src="${root}/commons/js/appjs/manager/core_dictionaries/core_dictionaries_form.js"></script> 
	<script type="text/javascript">

	</script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="coreDictionariesForm">
							<div class="form-group">
								<label class="col-sm-3 control-label">字典码：</label>
								<div class="col-sm-8">
									<input id="dictCode" name="dictCode" class="form-control" type="text" value="${coreDictionaries.dictCode}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">字典值：</label>
								<div class="col-sm-8">
									<input id="dictValue" name="dictValue" class="form-control" type="text" value="${coreDictionaries.dictValue}">
								</div>
							</div>													
							<div class="form-group">
								<label class="col-sm-3 control-label">字典组：</label>
								<div class="col-sm-8">
									<input id="coreDictGroupId" name="coreDictGroupId" class="hidden" value="${coreDictionaries.coreDictGroupId}"> 
									<input id="dictGroupName" name="dictGroupName" class="form-control" type="text"
									style="cursor: pointer;" onclick="openGroup()"
									readonly="readonly" value="${dictGroupName}">
								</div>
							</div>
						  	<input type="hidden" value="${root}" id="basePathUrl">
						  	<input type="hidden" value="${coreDictionaries.coreDictId}" name="coreDictId" id="coreDictId">
						  	<input type="hidden" value="${actionType}" id="actionType">
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<c:if test="${actionType !='view'}">
										<button type="button" id="coreDictionariesBtn" class="btn btn-primary">提交</button>
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