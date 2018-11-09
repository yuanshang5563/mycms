<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/header.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>user_form</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	<link rel="stylesheet" type="text/css" href="${root}/commons/resources/css/commonsIcons.css"/> 
	<script type="text/javascript" src="${root}/commons/jslib/manager/core_user/core_user_form.js"></script> 
  </head>
  <body>
  <input type="hidden" value="${root}" id="basePathUrl">
  <input type="hidden" value="${coreUserId}" id="coreUserId">
  <input type="hidden" value="${viewFlag}" id="viewFlag">
  </body>
</html>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head th:include="include :: header"></head>
<body class="gray-bg">
	<div class="wrapper wrapper-content ">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox-content">
					<div id="jsTree"></div>
				</div>
				<div class="form-group ">
					<div class="col-sm-12 col-sm-offset-12">
						<button type="submit" onclick="loadUser()" class="btn btn-primary">提交</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div th:include="include :: footer"></div>
	<script type="text/javascript">
		$(document).ready(function() {
			getTreeData()
		});
		function getTreeData() {
			$.ajax({
				type : "GET",
				url : "/sys/user/tree",
				success : function(tree) {
					loadTree(tree);
				}
			});
		}
		function loadTree(tree) {
			$('#jsTree').jstree({
				'core' : {
					'data' : tree
				},
				"plugins" : [ "checkbox" ]
			});
			$('#jsTree').jstree().open_all();
		}
		function loadUser(){
			var userNames,userIds;
			var ref = $('#jsTree').jstree(true); // 获得整个树
			userIds = ref.get_bottom_selected();
			users = ref.get_bottom_checked('true');
			var txt="";
			for(var user in users){
				if(users[user].state.mType=="user"){
					txt=txt+users[user].text+",";
				}
			}
			parent.loadUser(userIds,txt);
			var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
			parent.layer.close(index);
		}
	</script>
</body>
</html>