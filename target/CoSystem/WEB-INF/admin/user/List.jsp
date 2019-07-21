<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp" %>
<title>管理员列表</title>
</head>
<body>

<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 系统管理
    <span class="c-gray en">&gt;</span> 人员信息列表
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c">
        <form action="${pageContext.request.contextPath}/admin/user/list" method="post">
            <%--<button onclick="removeIframe()" class="btn btn-primary radius">关闭选项卡</button>
            入职日期：
            <input type="text" value="1970-01-01"
                   onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}' })" id="logmin"
                   name="createTimeBefore" class="input-text Wdate" style="width:120px;">
            -
            <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d' })"
                   id="logmax" name="createTimeAfter" class="input-text Wdate" style="width:120px;">--%>
                姓名查找：<input type="text" name="username" id="username"  style="width:200px" class="input-text">
                    入党状态:
                    <select name="politic" style="width:200px" class="input-text">
                        <option value="">请选择入党状态</option>
                        <option value="1" <c:if test="${requestScope.politic==1}">selected</c:if>>积极分子</option>
                        <option value="2" <c:if test="${requestScope.politic==2}">selected</c:if>>发展对象</option>
                        <option value="3" <c:if test="${requestScope.politic==3}">selected</c:if>>预备党员</option>
                        <option value="4" <c:if test="${requestScope.politic==4}">selected</c:if>>正式党员</option>
                    </select>
                    选择学生/老师：
                    <select name="player" style="width:200px" class="input-text">
                        <option value="">请选择老师/学生</option>
                        <option value="1" <c:if test="${requestScope.player==1}">selected</c:if>>学生</option>
                        <option value="2" <c:if test="${requestScope.player==2}">selected</c:if>>老师</option>
                    </select>
            <button class="btn btn-success" type="submit">
                <i class="Hui-iconfont">&#xe665;</i> 搜索人员
            </button>
        </form>
    </div>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <a class="btn btn-primary radius" data-title="添加记录" data-href="<%=admin%>user/add2"
           onclick="Hui_admin_tab(this)" href="javascript:;">
            <i class="Hui-iconfont">&#xe600;</i> 添加记录
        </a>
        <span class="r">
            共<strong>${data.totalRecordsNum}</strong>页 |
            每页<strong>${data.totalRecordsNum}</strong>条 |
            合计<strong>${data.totalRecordsNum}</strong>条数据
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
            <thead>
            <tr class="text-c">
                <th width="20"><input type="checkbox" name="" value=""></th>
                <th width="15">姓名</th>
                <th width="30">账号</th>
                <th width="20">性别</th>
                <th width="30">出生年月</th>
                <th width="20">入党状态</th>
                <th width="20">培养人</th>
                <th width="20">所属支部</th>
                <th width="15">学历</th>
                <th width="15">院系</th>
                <th width="25">年级/班级</th>
                <th width="25">电话号码</th>
                <th width="30">创建时间</th>
                <th width="30">更新时间</th>
                <th width="15">老师/学生</th>
                <th width="15">状态</th>
                <th width="20">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data.records}" var="user">
                <tr class="text-c">
                    <td><input type="checkbox" value="${user.uid}" name=""></td>
                    <td>${user.username}</td>
                    <td>${user.uaccount}</td>
                    <td class="text-l">
                             <c:if test="${user.ugender ==true}">男</c:if>
                             <c:if test="${user.ugender ==false}">女</c:if>
                    </td>
                    <td>${user.birthday}</td
                    <td>

                    </td>
                    <td><c:if test="${user.politic ==1}">积极分子</c:if>
                        <c:if test="${user.politic ==2}">发展对象</c:if>
                        <c:if test="${user.politic ==3}">预备党员</c:if>
                        <c:if test="${user.politic ==4}">正式党员</c:if></td>
                    <td>${user.admin.name}</td>
                    <td>${user.branch} </td>
                    <td>${user.education}</td>
                    <td>${user.faculty}</td>
                    <td>${user.junior}${user.grades}</td>
                    <td>${user.tell}</td>
                    <td>${user.createTimeStr}</td>
                    <td>${user.updateTimeStr}</td>
                    <td><c:if test="${user.player ==1}">学生</c:if>
                        <c:if test="${user.player ==2}">老师</c:if></td>
                    <td>${user.stateStr}</td>
                    <td class="f-14 td-manage">
                        <a style="text-decoration:none" class="ml-5" onClick="admin_edit('Admin编辑','add.jsp','10001')"
                           href="${pageContext.request.contextPath}/admin/user/updateByUserId?userId=${user.uid}"
                           title="编辑">
                            <i class="Hui-iconfont">&#xe6df;</i>
                        </a>
                        <a style="text-decoration:none" class="ml-5" onClick="admin_del(this,'10001')"
                           href="${pageContext.request.contextPath}/admin/user/deleteByUserId?userId=${user.uid}"
                           title="删除">
                            <i class="Hui-iconfont">&#xe6e2;</i>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@include file="../_page.jsp" %>

<%@include file="../_footer.jsp" %>


<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        // 允许分页
        "paging": false,
        //左下角信息
        "info": false,
        "bPaginate": false,  //显示翻页按钮 是否分页。
        "bLengthChange": false, //是否允许用户自定义每页显示条数
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
          //  {"orderable": false, "aTargets": [0, 8]}// 不参与排序的列
        ]
    });

    /*Admin-添加*/
    function admin_add(title, url, w, h) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*Admin-编辑*/
    function admin_edit(title, url, id, w, h) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*Admin-删除*/
    function admin_del(obj, id) {
        confirm('确认要删除吗？');
    }

    /*Admin-批量删除*/
    function admin_dels() {
        var adminids = "";
        $.each($('input:checkbox'), function () {
            if (this.checked) {
                adminids += $(this).val() + ",";
            }
        });
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: 'batchDelete',
                data: "adminids=" + adminids,
                success: function (data) {
                    if (data = "success") {
                        layer.msg('删除成功!' + data, {icon: 6, time: 2000});
                        location.replace(location.href);
                    } else if (data = "error") {
                        layer.msg('删除失败!' + data, {icon: 6, time: 1000});
                    }
                }
            });
        });
    }

    //获取当前时间，格式YYYY-MM-DD
    function getNowFormatDate() {
        var date = new Date();
        var seperator1 = "-";
        var year = date.getFullYear();
        var month = date.getMonth() + 1;
        var strDate = date.getDate();
        if (month >= 1 && month <= 9) {
            month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
            strDate = "0" + strDate;
        }
        var currentdate = year + seperator1 + month + seperator1 + strDate;
        return currentdate;
    }

    window.onload = function () {
        document.getElementById("logmax").value = getNowFormatDate();
    }
</script>
</body>
</html>