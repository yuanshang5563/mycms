<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String extPath = request.getContextPath();
String extBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+extPath;
%>
<c:set var="root" value="<%=extBasePath%>"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->    
    <title>mycms</title>
	<link href="${root}/commons/css/bootstrap.min.css" rel="stylesheet">
	<link href="${root}/commons/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	<link href="${root}/commons/css/animate.css" rel="stylesheet">
	<link href="${root}/commons/css/style.css" rel="stylesheet">
	<link type="text/css" href="${root}/commons/css/login.css" rel="stylesheet">
	<!-- 全局js -->
	<script type="text/javascript" src="${root}/commons/js/jquery.min.js?v=2.1.4"></script>
	<script type="text/javascript" src="${root}/commons/js/bootstrap.min.js?v=3.3.6"></script>
	
	<!-- jQuery Validation plugin javascript-->
	<script type="text/javascript" src="${root}/commons/js/ajax-util.js"></script>
	<script type="text/javascript" src="${root}/commons/js/plugins/validate/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${root}/commons/js/plugins/validate/messages_zh.min.js"></script>
	<script type="text/javascript" src="${root}/commons/js/plugins/layer/layer.min.js"></script>    
	<!-- 自定义js -->
	<script type="text/javascript" src="${root}/commons/js/content.js?v=1.0.0"></script>
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>


<script type="text/javascript">
    $(document).ready(function () {
        $("#login").on('click',function(){$("#loginForm").submit();});
        validateRule();
    });

    $.validator.setDefaults({
        submitHandler: function () {
            login();
        }
    });

    function login() {
        $.ajax({
            type: "POST",
            url: "${root}/LoginController/login",
            data: $('#loginForm').serialize(),
            success: function (r) {
                 if (r.code == 0) {
                    var index = layer.load(1, {
                        shade: [0.1,'#fff'] //0.1透明度的白色背景
                    });
                    parent.location.href = '${root}/manager/core/CoreManagerController/main';
                } else {
                    layer.msg(r.msg);
                }
            },
        });
    }

    function validateRule() {
        var icon = "<i class='fa fa-times-circle'></i> ";
        $("#loginForm").validate({
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: icon + "请输入您的用户名",
                },
                password: {
                    required: icon + "请输入您的密码",
                }
            }
        })
    }
</script>
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>mycms</h1>
                </div>
                <div class="m-b"></div>
                <h3>
                   	 欢迎使用 <strong>mycms管理系统</strong>
                </h3>
            </div>
        </div>
        <div class="col-sm-5">
            <form id="loginForm">
                <h3 class="text-center">用户登录</h3>
                <p class="m-t-md text-center">欢迎登录mycms后台管理系统</p>
                <input type="text" name="username" class="form-control uname"/>
                <input type="password" name="password" class="form-control pword m-b"/>
                <a id="login" class="btn btn-login btn-block">登录</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>