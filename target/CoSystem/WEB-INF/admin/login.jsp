<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="_header.jsp"%>
<title>后台登录</title>
</head>
<body>

<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal"  method="post">

      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="account" name="account" type="text" placeholder="账户" class="input-text size-L" value="12345">
        </div>
      </div>

      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L" value="12345">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="checkCode" id="checkCode" class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <img alt="验证码" src="${pageContext.request.contextPath}/servlet/checkCodeServlet" mce_src="authImg" id="authImg" align="absmiddle">
          <a  href="javascript:void(0);" onclick="refresh()">看不清，换一张</a>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" id="submit" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright SB公司</div>
<script type="text/javascript" src="<%=assets%>lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=assets%>static/h-ui/js/H-ui.min.js"></script>

<script type="text/javascript">

  function refresh(){
      document.getElementById("authImg").src="${pageContext.request.contextPath}/servlet/checkCodeServlet?now="+new Date();//使用时间作为参数避免浏览器从缓存取图片

  }
    $(function () {
        $("#submit").click(function () {
            var account = document.getElementById("account").value;
            var password = document.getElementById("password").value;
            var checkCode = document.getElementById("checkCode").value;
            if(account == '' || account == 'undefined'){
                alert("请填写用户名！");
                return;
            }
            if(password == '' || password == 'undefined') {
                alert("请填写密码！");
                return;
            }
            $.ajax({
                url:'${pageContext.request.contextPath}/admin/denglu',
                data:{account:account,password:password,checkCode:checkCode},
                type:'post',
                dataType:'json',
                success:function(data) {
                    if (data.type=='success') {
                        window.parent.location = '${pageContext.request.contextPath}/admin/index';
                    }else {
                        alert(data.msg);
                        refresh();
                    }
                }
            });
        });

    });

</script>

</body>
</html>