<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp"%>
<link rel="stylesheet" type="text/css" href="<%=assets%>/static/h-ui/css/hasExist.css" />
<title>添加用户</title>
</head>
<body>
<article class="page-container">
	<form action="${pageContext.request.contextPath}/admin/user/add" method="post" class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="username" name="username">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>账号：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="account" name="account">
                <label for="account" id="exit"></label>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="password" name="password">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="radio" class="input-text" value="1" placeholder="" id="male" name="gender"  style="width:5%;" checked> 男
				<input type="radio" class="input-text" value="0" placeholder="" id="female" name="gender"  style="width:5%;">  女
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="tell" name="tell">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>出生日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="birthday" onfocus="WdatePicker({ maxDate:'%y-%M-%d' })"
					   id="logmax" class="input-text Wdate" style="width:120px;">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="email" id="email">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>入党状态：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="politic">
					<option value="" selected>请选择入党状态</option>
					<option value="1">积极分子</option>
					<option value="2">发展对象</option>
					<option value="3">预备党员</option>
					<option value="4">正式党员</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>所属支部：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="branch" id="branch">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>学历：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="education" id="education">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>院系：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="faculty" id="faculty">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>年级：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="junior" id="junior">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>班级：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" placeholder="" name="grades" id="grades">
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>培养联系人：</label>
			<div class="formControls col-xs-8 col-sm-9">
                <select class="select" size="1" name="adminId">
                    <option value="" selected>请选择培养联系人</option>
                    <c:forEach items="${applicationScope.adminList}" var="admin">
                        <option value="${admin.id}">${admin.name}</option>
                    </c:forEach>
                </select>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>老师/学生：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="player">
					<option value="" selected>请选择老师/学生</option>
					<option value="2">老师</option>
					<option value="1">学生</option>
				</select>
				</span> </div>

		</div><div class="row cl">
		<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>人员状态：</label>
		<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select class="select" size="1" name="state">
					<option value="" selected>人员状态</option>
					<option value="1">在校</option>
					<option value="2">休学</option>
					<option value="3">毕业</option>
				</select>
				</span> </div>
	</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="beizhu" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="button" id="btn" onclick="tijiao()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
    $(function () {
        $("#account").blur(function () {
                var label = document.getElementById("exit");
            if (label.innerHTML!=""){
                label.className="";
                label.innerHTML="";
                $("#btn").attr("disabled", false);
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/admin/user/selectByAccount',
                data:{account:$(this).val()},
                type:'post',
                dataType:'json',
                success:function (data) {
                    if (data.msg){
                        label.className+="hasexit";
                        label.innerHTML="账号已存在";
                        $("#btn").attr("disabled", true);
                        return;
                    }else {
                        label.className+="noexit";
                        label.innerHTML="账号可用";
                    }
                }
            });
        });
    });
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