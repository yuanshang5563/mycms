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
	<script type="text/javascript" src="${root}/commons/js/appjs/manager/core_user/core_user_reset_pwd.js"></script> 
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
							<div class="form-group">
								<label class="col-sm-3 control-label">密码：</label>
								<div class="col-sm-8">
									<input id="password" name="password" class="form-control" type="password">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">密码确认：</label>
								<div class="col-sm-8">
									<input id="comfirmPassword" name="comfirmPassword" class="form-control" type="password">
								</div>
							</div>	

						  	<input type="hidden" value="${root}" id="basePathUrl">
						  	<input type="hidden" value="${coreUserId}" name="coreUserId" id="coreUserId">
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<button type="button" id="coreUserBtn" class="btn btn-primary">提交</button>
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