<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp"%>

<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<title>添加管理员</title>
</head>
<body>

<div class="page-container">
	<form action="${pageContext.request.contextPath}/admin/add" method="post" class="form form-horizontal" id="form-admin-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">用户昵称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="wanger" placeholder="" id="nickname" name="nickname">
            </div>
        </div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>账户名：
            </label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="wanger" placeholder="" id="account" name="account">
			</div>
		</div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" name="password1" id="password1" placeholder="密码" value="123456" class="input-text" style=" width:25%">
                <input type="text" name="password2" id="password2" placeholder="确认密码" value="123456" class="input-text" style=" width:25%">
             </div>
        </div>


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">管理员头相：</label>
            <div id="upload" class="formControls col-xs-8 col-sm-9">
                <!-- 用于显示文件列表 -->
                <span id="fileList"></span>
                <!-- 用于选择文件 -->
                <span id="filePicker">文件上传</span>
            </div>
        </div>


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">性别：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="radio" class="input-text" value="0" placeholder="" id="male" name="gender"  style="width:5%;" checked> 男
                <input type="radio" class="input-text" value="1" placeholder="" id="female" name="gender"  style="width:5%;">  女
                <input type="radio" class="input-text" value="" placeholder="" id="other" name="gender"  style="width:5%;"> 未知
            </div>
        </div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">QQ：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="" id="qq" name="qq" value="369950806">
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">电话：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="" id="tel" name="tel" value="123456789">
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">电子邮箱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="" id="email" name="email" value="369950806@qq.com">
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">管理员状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="radio" class="input-text" value="0" placeholder="" id="normal" name="state" style="width:8%;" checked>正常
				<input type="radio" class="input-text" value="1" placeholder="" id="deleted" name="state" style="width:8%;">删除
				<input type="radio" class="input-text" value="2" placeholder="" id="confine" name="state" style="width:8%;">禁闭
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">管理员简介：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script id="editor" type="text/plain" style="width:100%;height:400px;">这是一个大好人</script>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
				<button onClick="article_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<script type="text/javascript" src="<%=assets%>/lib/webuploader/0.1.5/webuploader.js"></script>
<link rel="stylesheet" type="text/css" href="<%=assets%>/lib/webuploader/0.1.5/webuploader.css">

<script type="text/javascript" src="<%=assets%>/lib/ueditor/1.4.3/ueditor.config.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/ueditor/1.4.3/ueditor.all.min.js"> </script>
<script type="text/javascript" src="<%=assets%>/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
$(function(){
    //有效性验证
    $("#form-admin-add").validate({
        rules: {
            nickname: {
                required: true,
                minlength: 3,
                maxlength:8
            },
            password1: {
                required: true,
                minlength: 6,
                maxlength:16
            },
            password2: {
                required: true,
                minlength: 6,
                maxlength:16,
                equalTo:"#password1"
            },
            tel:{
                required: true
            },
            email:{
                required: true,
                email:true
            }
        },
        messages: {
            nickname: {
                required: "请输入用户昵称",
                minlength: "用户昵称长度大于3个字符小于8个字符"
            },
            password1: {
                required: "请输入密码",
                minlength: "密码长度长度大于6个字符小于16个字符"
            },
            password2: {
                required: "请输入确认密码",
                minlength: "密码长度长度大于6个字符小于16个字符",
                equalTo: "两次密码输入不一致"
            },
            email: "请输入一个正确的邮箱"
        }
    });



	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
    // 上传基本配置
    var uploader = WebUploader.create({
        swf: "${pageContext.request.contextPath }/js/webuploader-0.1.5/Uploader.swf",
        server: "${pageContext.request.contextPath }/admin/imgUpload",
        pick: "#filePicker",
        auto: true,
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/jpg,image/jpeg,image/png'
        }
    });
    // 生成缩略图和上传进度
    uploader.on("fileQueued", function (file) {
            // 把文件信息追加到fileList的div中
            $("#fileList").append("<div id='" + file.id + "'><img/><span>" + file.name + "</span><div><span class='percentage'><span></div></div>")
            // 生成缩略图
            uploader.makeThumb(file, function (error, src) {      // src:代表生成缩略图的地址
                if (error) { // error：不是图片
                    $("#" + file.id).find("img").replaceWith("<span>无法预览 </span>");
                } else {
                    $("#" + file.id).find("img").attr("src", src);
                }
            });
        }
    );
    // 监控上传进度
    uploader.on("uploadProgress", function (file, percentage) {   // percentage:代表上传文件的百分比
        $("#" + file.id).find("span.percentage").text(Math.round(percentage * 100) + "%");
    });

	var ue = UE.getEditor('editor');
});
</script>
</body>
</html>