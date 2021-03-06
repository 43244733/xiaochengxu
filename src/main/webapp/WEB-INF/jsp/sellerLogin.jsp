<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2020/5/26
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../seller/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../seller/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="../seller/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../seller/css/admin.css">
    <link rel="stylesheet" href="../seller/css/app.css">
</head>

<body data-type="login">

<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                <span> 登 录 系 统 </span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>

        <div class="login-font">
            <i>登 录</i> 或 <a href="insertUser"><span>注 册</span></a>

        </div>

        <div class="am-u-sm-10 login-am-center">
            <form class="am-form" action="/doSellerLogin" method="get">
                <fieldset>
                    <div class="am-form-group">
                        <input type="text" class="" id="doc-ipt-email-1" placeholder="输入账号" name="name">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="" id="doc-ipt-pwd-1" placeholder="输入密码" name="password">
                    </div>
                    <p>
                        <button type="submit" class="am-btn am-btn-default">登录</button>
                    </p>

                </fieldset>
            </form>
        </div>
    </div>
</div>

<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
<script src="../seller/js/amazeui.min.js"></script>
<script src="../seller/js/app.js"></script>
</body>

</html>