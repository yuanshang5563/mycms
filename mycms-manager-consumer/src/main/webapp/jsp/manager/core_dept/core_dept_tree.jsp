<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/header.jsp"%>

<!DOCTYPE html>
<html>
  <head>
    <title>core_dept_tree</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<script type="text/javascript">
		var basePathUrl = "";
		$(document).ready(function() {
			basePathUrl = $("#basePathUrl").val();
			getTreeData()
			
			$('#coreDeptTree').on("changed.jstree", function(e, data) {
				if(data.node.id!=-1){
					parent.loadDept(data.node.id,data.node.text);
					var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
					parent.layer.close(index);
				}
				
			});
		});
		function getTreeData() {
			$.ajax({
				type : "GET",
				url : basePathUrl+"/manager/core/CoreDeptController/coreDeptTreeJson",
				success : function(tree) {
					loadTree(tree);
				}
			});
		}
		function loadTree(tree) {
			$('#coreDeptTree').jstree({
				'core' : {
					'data' : tree
				},
				"plugins" : [ "search" ]
			});
			$('#coreDeptTree').jstree().open_all();
		}
	</script>	
  </head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">

				<div class="ibox-content">
					<div id="coreDeptTree"></div>
				</div>
				<div class="form-group hidden">
					<div class="col-sm-12 col-sm-offset-12">
						<input type="hidden" value="${root}" id="basePathUrl">
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
