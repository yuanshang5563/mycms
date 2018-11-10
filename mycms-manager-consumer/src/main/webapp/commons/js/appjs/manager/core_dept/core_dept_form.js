var basePathUrl = "";
var prefix = "";
$(function() {
	basePathUrl = $("#basePathUrl").val();
	prefix = basePathUrl+"/manager/core/CoreDeptController";
});

function coreDeptFormSave() {
	if(validateDeptForm()){
		$.ajax({
			cache : true,
			type : "POST",
			url : prefix + "/saveCoreDeptForm",
			data : $('#coreDeptForm').serialize(),
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

function validateDeptForm() {
	var deptName = $("#deptName").val();
	if(deptName == ''){
		alert("部门名称必填！");
		$("#deptName").fcous();
		return false;
	}
	var deptCode = $("#deptCode").val();
	if(deptCode == ''){
		alert("部门代码必填！");
		$("#deptCode").fcous();
		return false;
	}
	return true;
}