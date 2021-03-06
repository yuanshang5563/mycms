<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  	<%@include file="/commons/header.jsp"%>
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
							<shiro:hasPermission name="core:coreDept:addAndEdit">
							<button type="button" class="btn btn-primary" title="在根节点下添加部门" onclick="add('0','add')">
								<i class="fa fa-plus" aria-hidden="true"></i>添加
							</button>
							</shiro:hasPermission>
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
 				var s_add_h = 'hidden';
				var s_edit_h = 'hidden';
				var s_remove_h = 'hidden';
				var s_view_h = 'hidden';
			</script>
		</div>
		<div>
		<shiro:hasPermission name="core:coreDept:addAndEdit">
			<script type="text/javascript">
				s_add_h = '';
				s_edit_h = '';
			</script>
		</shiro:hasPermission>
		<shiro:hasPermission name="core:coreDept:del">
			<script type="text/javascript">
				s_remove_h = '';
			</script>
		</shiro:hasPermission>
			<script type="text/javascript">
				s_view_h = '';
			</script>		
		</div>	
	</div>
</body>
</html>