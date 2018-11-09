<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/header.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>deptList</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta charset="utf-8">
	<script src="${root}/commons/js/appjs/manager/core_dept/core_dept_list.js"></script>
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="col-sm-12">
			<div class="ibox">
				<div class="ibox-body">
					<div class="fixed-table-toolbar">
						<div id="deptTableToolbar" class="columns pull-left">
							<button type="button" class="btn btn-primary" title="在根节点下添加部门" onclick="add('0','add')">
								<i class="fa fa-plus" aria-hidden="true"></i>添加
							</button>
						</div>
	                    <div class="columns pull-right">
	                        <button class="btn btn-success" onclick="queryTable()">查询</button>
	                    </div>
	                    <div class="columns pull-right col-md-2 nopadding">
	                        <input id="deptName" name="deptName" type="text" class="form-control" placeholder="部门名称">
	                    </div>   
                    </div>                 					
					<table id="deptTable" data-mobile-responsive="true">
					</table>
					<input type="hidden" value="${root}" id="basePathUrl">
				</div>
			</div>
		</div>
		<!--shiro控制bootstraptable行内按钮看见性 来自bootdo的创新方案-->
		<div>
			<script type="text/javascript">
/* 				var s_add_h = 'hidden';
				var s_edit_h = 'hidden';
				var s_remove_h = 'hidden'; */
				var s_add_h = '';
				var s_edit_h = '';
				var s_remove_h = '';
			</script>
		</div>
		<!--
		<div shiro:hasPermission="sys:dept:add">
			<script type="text/javascript">
				s_add_h = '';
			</script>
		</div>
		<div shiro:hasPermission="sys:user:edit">
			<script type="text/javascript">
				s_edit_h = '';
			</script>
		</div>
		<div shiro:hasPermission="sys:user:remove">
			<script type="text/javascript">
				var s_remove_h = '';
			</script>
		</div>	
		 -->	
	</div>
</body>
</html>