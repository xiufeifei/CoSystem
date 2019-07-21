<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String admin = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";
    String assets = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/static/assets";
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <!--[if lt IE 9]>
    <script type="text/javascript" src="<%=assets%>/lib/html5shiv.js"></script>
    <script type="text/javascript" src="<%=assets%>/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="<%=assets%>/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=assets%>/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=assets%>/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=assets%>/static/h-ui.admin/skin/default/skin.css" id="skin" />

    <link href="<%=assets%>/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="<%=assets%>/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="<%=assets%>/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=assets%>/lib/layer/2.4/layer.js"></script>
    <script type="text/javascript" src="<%=assets%>/static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript" src="<%=assets%>/static/h-ui.admin/js/H-ui.admin.js"></script>

    <script type="text/javascript" src="<%=assets%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=assets%>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=assets%>/lib/laypage/1.2/laypage.js"></script>

    <!--[if IE 6]>
    <script type="text/javascript" src="<%=assets%>/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->

    <meta name="keywords" content="网站后台模版,后台模版,后台管理系统模版,HTML后台模版">
    <meta name="description" content="新闻管理后台">