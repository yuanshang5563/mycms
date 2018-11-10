var basePathUrl = "";
var prefix = ""
var coreMenuIds;
$(function() {
	basePathUrl = $("#basePathUrl").val();
	prefix = basePathUrl + "/manager/core/CoreRoleController";
	getMenuTreeData();
});

function getAllSelectNodes() {
	var ref = $('#coreMenuTree').jstree(true); // 获得整个树

	coreMenuIds = ref.get_selected(); // 获得所有选中节点的，返回值为数组

	$("#coreMenuTree").find(".jstree-undetermined").each(function(i, element) {
		coreMenuIds.push($(element).closest('.jstree-node').attr("id"));
	});
}

function getMenuTreeData() {
	var actionType = $("#actionType").val();
	var queryUrl = basePathUrl+"/manager/core/CoreMenuController/coreMenuTreeJson";
	if(actionType == 'edit'){
		var coreRoleId = $("#coreRoleId").val();
		queryUrl = basePathUrl+"/manager/core/CoreMenuController/coreMenuTreeJsonByRoleId?coreRoleId="+coreRoleId;
	}
	$.ajax({
		type : "GET",
		url : queryUrl,
		success : function(menuTree) {
			loadMenuTree(menuTree);
		}
	});
}

function loadMenuTree(menuTree) {
	$('#coreMenuTree').jstree({
		'core' : {
			'data' : menuTree
		},
		"checkbox" : {
			"three_state" : true,
		},
		"plugins" : [ "wholerow", "checkbox" ]
	});
	$('#coreMenuTree').jstree("open_all");

}

function coreRoleFormSave() {
	if(validateRoleForm()){
		getAllSelectNodes();
		$('#coreMenuIds').val(coreMenuIds);
		$.ajax({
			cache : true,
			type : "POST",
			url : prefix + "/saveCoreRoleForm",
			data : $('#coreRoleForm').serialize(),
			async : false,
			error : function(request) {
				laryer.alert("连接错误");
			},
			success : function(data) {
				if (data.success == 1) {
					parent.layer.msg(data.msg);
					parent.reLoad();
					var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
					parent.layer.close(index);

				} else {
					layer.alert(data.msg)
				}
			}
		});		
	}
}

function validateRoleForm() {
	var roleName = $("#roleName").val();
	if(roleName == ''){
		alert("角色名称必填！");
		$("#roleName").focus();
		return false;
	}
	var role = $("#role").val();
	if(role == ''){
		alert("角色必填！");
		$("#role").focus();
		return false;
	}
	return true;
}
