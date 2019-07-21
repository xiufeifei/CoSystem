<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp"%>
<title>新增图片</title>
<link href="<%=assets%>/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="page-container">
	<form class="form form-horizontal" id="form-article-add" action="${pageContext.request.contextPath}/admin/files/update">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>文件名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="filename" name="filename">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">文件摘要：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="info" id="info" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onKeyUp="$.Huitextarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">点击上传：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div id="fileList"></div>
				<!-- 用于选择文件 -->
				<div id="filePicker">文件上传</div>
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
			</div>
		</div>
	</form>
</div>

<%@include file="../_footer.jsp"%>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=assets%>/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript">
function article_save_submit(){
	$("#form-article-add").submit();
}



// 上传基本配置
var uploader = WebUploader.create({
    swf: "${pageContext.request.contextPath }/static/assets/lib/webuploader/0.1.5/Uploader.swf",
    server: "${pageContext.request.contextPath }/admin/files/fileUploadServlet1",
    pick: "#filePicker",
    auto: true
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

</script>
</body>
</html>