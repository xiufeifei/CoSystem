<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../_header.jsp"%>
<title>新闻 - 资讯管理</title>
</head>
<body>

<article class="page-container">
	<form action="${pageContext.request.contextPath}/category/insert" class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">类别名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="articletitle2" name="categoryName">
			</div>
		</div>


		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="" id="author" name="categoryState">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">简介：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="0" placeholder="" id="sources" name="categoryInfo">
			</div>
		</div>
		<div>
			<input type="submit" value="保存">
		</div>
	</form>

</body>
</html>