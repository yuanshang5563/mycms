<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
    <title>menuForm</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<script src="${root}/commons/js/appjs/manager/core_menu/core_menu_form.js"></script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-content">
						<form class="form-horizontal m-t" id="coreMenuForm">
							<div class="form-group">
								<label class="col-sm-3 control-label">上级菜单：</label>
								<div class="col-sm-8">
									<input class="form-control" type="text" value="${parentMenuName}" readonly>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单类型：</label>
								<div class="col-sm-8">
									<label class="radio-inline"> 
										<input type="radio" name="menuType" value="0"> 目录</input>
									</label> 
									<label class="radio-inline"> 
										<input type="radio" name="menuType" value="1"> 菜单</input>
									</label> 
									<label class="radio-inline"> 
										<input type="radio" name="menuType" value="2"> 按钮</input>
									</label>
									<script>$("input[name='menuType'][value='${coreMenu.menuType}']").attr("checked",true); </script>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">菜单名称：</label>
								<div class="col-sm-8">
									<input id="menuName" name="menuName" class="form-control" type="text" value="${coreMenu.menuName}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">链接地址：</label>
								<div class="col-sm-8">
									<input id="menuUrl" name="menuUrl" class="form-control" type="text" value="${coreMenu.menuUrl}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">权限标识：</label>
								<div class="col-sm-8">
									<input id="permission" name="permission" class="form-control" type="text" value="${coreMenu.permission}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">排序号：</label>
								<div class="col-sm-8">
									<input id="orderNum" name="orderNum" class="form-control" type="text" value="${coreMenu.orderNum}">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label">图标：</label>
								<div class="col-sm-6">
									<input id="icon" name="icon" class="form-control" type="text" placeholder="例如：fa fa-circle-o" value="${coreMenu.icon}">
								</div>
								<input id="ico-btn" class="btn btn-warning" type="button" value="选择图标" onclick="openIco()" />
							</div>

							<input type="hidden" value="${coreMenu.coreMenuId}" id="coreMenuId" name="coreMenuId" >
							<input type="hidden" value="${coreMenu.parentCoreMenuId}" id="parentCoreMenuId" name="parentCoreMenuId">
							<input type="hidden" value="${root}" id="basePathUrl">
							<input type="hidden" value="${actionType}" id="actionType">		
							<div class="form-group">
								<div class="col-sm-8 col-sm-offset-3">
									<c:if test="${actionType !='view'}">
										<button id="coreMenuBtn" type="button" class="btn btn-primary">提交</button>
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