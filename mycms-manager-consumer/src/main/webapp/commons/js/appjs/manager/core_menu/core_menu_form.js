var basePathUrl = "";
var prefix = "";
$(function() {
	basePathUrl = $("#basePathUrl").val();
	prefix = basePathUrl+"/manager/core/CoreMenuController";
});

function coreMenuFormSave() {
	if(validateMenuForm()){
		$.ajax({
			cache : true,
			type : "POST",
			url : prefix + "/saveCoreMenuForm",
			data : $('#coreMenuForm').serialize(),
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

function validateMenuForm() {
	var menuName = $("#menuName").val();
	if(menuName == ''){
		alert("菜单名称必填！");
		$("#menuName").focus();
		return false;
	}
	var menuType = $("input[name='menuType']:checked").val(); 
	if(menuType == '' || undefined == menuType){
		alert("菜单类型必填！");
		return false;
	}
	return true;
}

function openIco(){
    layer.open({
        type: 2,
		title:'图标列表',
        content: basePathUrl+'/commons/fontIcoList.jsp',
        area: ['480px', '90%'],
        success: function(layero, index){
            //var body = layer.getChildFrame('.ico-list', index);
            //console.log(layero, index);
        }
    });
}