<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp"%>
<title>添加用户</title>
</head>
<body>
<article class="page-container">
	<form action="${pageContext.request.contextPath}/admin/score/add" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>学生：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="userId">
					<option value="" selected>请选择入学生</option>
					<c:forEach items="${data}" var="user">
                        <option value="${user.uid}">${user.username}</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>考勤次数：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="attendance" id="attendance">
			</div>
		</div>

		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">奖惩记录：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="experience" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="button" onclick="tijiao()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</article>

<%@include file="../_footer.jsp"%>

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="<%=assets%>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    function tijiao(){
        $("#form-member-add").submit();
    }
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			sex:{
				required:true,
			},
			mobile:{
				required:true,
				isMobile:true,
			},
			email:{
				required:true,
				email:true,
			},
			uploadfile:{
				required:true,
			},
			
		},

	});
});
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>