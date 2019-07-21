<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp"%>
<title>资讯列表</title>
</head>
<body>

<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> notice管理 <span class="c-gray en">&gt;</span>notice列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>


<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		<a class="btn btn-primary radius" title="添加文章" href="<%=admin%>/notice/noticeAdd">
		 <%--  onclick="Hui_admin_tab(this)" href="javascript:;">--%>
				<i class="Hui-iconfont">&#xe600;</i> 添加文章
			</a>
		<span class="r"><%--共有数据：<strong>${noticesSize}</strong> 条--%></span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="80">编号</th>
					<th>标题</th>
					<th width="80">备注</th>
					<th width="120">创建时间</th>
					<th width="120">更新时间</th>
					<th width="75">文章来源</th>
					<th width="60">管理员id</th>
					<th width="80">简介</th>
					<th width="120">操作</th>
				</tr>
			</thead>


			<tbody>
			<c:forEach items="${data.records}" var="notice">
				<tr class="text-c">
					<td><input type="checkbox" value="" name=""></td>
					<td>${notice.id}</td>
					<td>${notice.title}</td>
					<td>${notice.remarks}</td>
					<td>${notice.createTimeStr}</td>
					<td>${notice.updateTimeStr}</td>
					<td>${notice.origin}</td>
					<td>${notice.adminId}</td>
					<td>${notice.ninfo}</td>
					<td class="f-14 td-manage">
						<a style="text-decoration:none" class="ml-5" onClick="article_del(this,'10001')" href="${pageContext.request.contextPath}/admin/notice/deleteByNoticeId?noticeId=${notice.id}" title="删除">
							<i class="Hui-iconfont">&#xe6e2;</i>
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>


		</table>
	</div>
</div>

<%@include file="../_footer.jsp"%>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=assets%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"pading":false,
	"aoColumnDefs": [
	  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
	  {"orderable":false,"aTargets":[0,8]}// 不参与排序的列
	]
});

/!*新闻-添加*!/
function article_add(title,url,w,h){
    var index = layer.open({
        type: 2,
        title: title,
        content: url
    });
    layer.full(index);
}
/*新闻-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*新闻-删除*/
function article_del(obj,id){
	confirm('确认要删除吗？');
}

/*新闻-审核*/
function article_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过','取消'], 
		shade: false,
		closeBtn: 0
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="article_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}
/*新闻-下架*/
function article_stop(obj,id){
	layer.confirm('确认撤销已发布文章吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已撤销</span>');
		$(obj).remove();
		layer.msg('已撤销!',{icon: 5,time:1000});
	});
}

/*新闻-发布*/
function article_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="article_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}
/*新闻-申请上线*/
function article_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

</script> 
</body>
</html>