<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String extPath = request.getContextPath();
String extBasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+extPath;
%>
<c:set var="root" value="<%=extBasePath%>"/>
<link type="text/css" href="${root}/commons/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link type="text/css" href="${root}/commons/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link type="text/css" href="${root}/commons/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<link type="text/css" href="${root}/commons/css/plugins/jsTree/style.min.css" rel="stylesheet">
<link type="text/css" href="${root}/commons/css/plugins/jqTreeGrid/jquery.treegrid.css" rel="stylesheet">
<!--summernote css -->
<link type="text/css" href="${root}/commons/css/plugins/summernote/summernote-0.8.8.css" rel="stylesheet">
<link type="text/css" href="${root}/commons/css/animate.css" rel="stylesheet">
<link type="text/css" href="${root}/commons/css/plugins/chosen/chosen.css" rel="stylesheet">
<link type="text/css" href="${root}/commons/css/style.css?v=4.1.0" rel="stylesheet">

<script type="text/javascript" src="${root}/commons/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" src="${root}/commons/js/bootstrap.min.js?v=3.3.6"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/validate/messages_zh.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/jsTree/jstree.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/jqTreeGrid/jquery.treegrid.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/jqTreeGrid/jquery.treegrid.extension.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/jqTreeGrid/jquery.treegrid.bootstrap3.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/chosen/chosen.jquery.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/layer/layer.js"></script>
<script type="text/javascript" src="${root}/commons/js/content.js?v=1.0.0"></script>
<!--summernote-->
<script type="text/javascript" src="${root}/commons/js/plugins/summernote/summernote.js"></script>
<script type="text/javascript" src="${root}/commons/js/plugins/summernote/summernote-zh-CN.min.js"></script>
<script type="text/javascript" src="${root}/commons/js/ajax-util.js"></script>		  
