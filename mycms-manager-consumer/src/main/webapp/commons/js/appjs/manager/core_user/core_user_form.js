var basePathUrl = "";
var prefix = ""
$(function() {
	basePathUrl = $("#basePathUrl").val();
	prefix = basePathUrl+"/manager/core/CoreUserController";	
	
	$("#birthday").datetimepicker({
		format: 'yyyy-mm-dd',
		language: 'zh-CN',
		weekStart: 1,
		todayBtn: 1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2, 
		clearBtn:true,
		forceParse: 0
	});
});

function getCheckedRoles() {
	var adIds = "";
	$("input:checkbox[name=coreRole]:checked").each(function(i) {
		if (0 == i) {
			adIds = $(this).val();
		} else {
			adIds += ("," + $(this).val());
		}
	});
	return adIds;
}

function coreUserFormSave() {
	if(validateUserForm()){
		$("#coreRoleIds").val(getCheckedRoles());
		$.ajax({
			cache : true,
			type : "POST",
			url : prefix + "/saveCoreUserForm",
			data : $('#coreUserForm').serialize(),
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

function validateUserForm() {
	var realName = $("#realName").val();
	if(realName == ''){
		alert("姓名必填！");
		$("#realName").fcous();
		return false;
	}
	var userName = $("#userName").val();
	if(userName == ''){
		alert("用户名必填！");
		$("#userName").fcous();
		return false;
	}
	if($("#password").length > 0){
		var password = $("#password").val();
		if(password == ''){
			alert("密码必填！");
			$("#password").fcous();
			return false;
		}
		var comfirmPassword = $("#comfirmPassword").val();
		if(comfirmPassword == ''){
			alert("确认密码必填！");
			$("#comfirmPassword").fcous();
			return false;
		}	
		if(password != comfirmPassword){
			alert("两次密码不一至，请核对！");
			return false;			
		}
	}
	var sex = $("input[name='sex']:checked").val(); 
	if(sex == '' || undefined == sex){
		alert("性别必选！");
		return false;
	}	
	var mobile = $("#mobile").val();
	if(mobile == ''){
		alert("手机必填！");
		$("#mobile").fcous();
		return false;
	}
	var email = $("#email").val();
	if(email == ''){
		alert("email必填！");
		$("#email").fcous();
		return false;
	}
	var coreDeptId = $("#coreDeptId").val();
	if(coreDeptId == ''){
		alert("部门必选！");
		$("#coreDeptId").fcous();
		return false;
	}
	var status = $("input[name='status']:checked").val(); 
	if(status == '' || undefined == status){
		alert("状态必选！");
		return false;
	}
	return true;
}

var openDept = function(){
	layer.open({
		type:2,
		title:"选择部门",
		area : [ '300px', '450px' ],
		content:basePathUrl+"/manager/core/CoreDeptController/coreDeptTree"
	})
}
function loadDept(deptId,deptName){
	//if(deptCode.length == 6){
		$("#coreDeptId").val(deptId);
		$("#deptName").val(deptName);
	//}else{
	//	alert("请选择区县");
	//	$("#coreDeptId").val('');
	//	$("#deptName").val('');		
	//}
}