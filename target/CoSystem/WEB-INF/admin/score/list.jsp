<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp"%>
<title>图片列表</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 图片管理 <span class="c-gray en">&gt;</span> 图片列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="text-c">
        <form action="${pageContext.request.contextPath}/admin/score/list" method="post">
            姓名查找：<input type="text" name="username" id="username"  style="width:200px" class="input-text">
            <button class="btn btn-success" type="submit">
                <i class="Hui-iconfont">&#xe665;</i> 搜索人员
            </button>
        </form>
    </div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
        <a class="btn btn-primary radius" data-title="添加记录" href="${pageContext.request.contextPath}/admin/score/selectAllUser"
           onclick="Hui_admin_tab(this)" >
            <i class="Hui-iconfont">&#xe600;</i> 添加记录
        </a>
		<span class="r">
            共<strong>${data.totalRecordsNum}</strong>页 |
            每页<strong>${data.totalRecordsNum}</strong>条 |
            合计<strong>${data.totalRecordsNum}</strong>条数据
        </span>
    </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="80">编号</th>
					<th width="100">受培养人</th>
					<th width="100">入党状态</th>
					<th width="100">得奖请况</th>
					<th width="100">考勤</th>
					<th width="150">创建时间</th>
					<th width="150">更新时间</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${data.records}" var="score">
				<tr class="text-c">
					<td>${score.id}</td>
					<td>${score.user.username}</td>
					<td>
                        <c:if test="${score.user.politic ==1}">积极分子</c:if>
                        <c:if test="${score.user.politic ==2}">发展对象</c:if>
                        <c:if test="${score.user.politic ==3}">预备党员</c:if>
                        <c:if test="${score.user.politic ==4}">正式党员</c:if>
                    </td>
                    <td>${score.experience}</td>
                    <td>${score.attendance}</td>
                    <td>${score.createTimeStr}</td>
                    <td>${score.updateTimeStr}</td>
					<td class="f-14 td-manage">
                        <a style="text-decoration:none" class="ml-5" onClick="admin_edit('Admin编辑','add.jsp','10001')"
                           href="${pageContext.request.contextPath}/admin/score/updateByScoreId?scoreId=${score.id}"
                           title="编辑">
                            <i class="Hui-iconfont">&#xe6df;</i>
                        </a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<%@include file="../_footer.jsp"%>
<%@include file="../_page.jsp"%>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=assets%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  //{"orderable":false,"aTargets":[0,8]}// 制定列不参与排序
	]
});

/*图片-添加*/
function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-查看*/
function picture_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-审核*/
function picture_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过'], 
		shade: false
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}

/*图片-下架*/
function picture_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*图片-发布*/
function picture_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}

/*图片-申请上线*/
function picture_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}


</script>
</body>
</html>