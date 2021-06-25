<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2020/5/23
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>小程序后端管理系统</title>
    <meta content="" name="description"/>
    <meta content="" name="author"/>

    <!-- Favicon -->
    <link rel="shortcut icon" href="/assets/images/favicon.png" type="image/x-icon"/>
    <!-- For iPhone -->
    <link rel="apple-touch-icon-precomposed" href="/assets/images/apple-touch-icon-57-precomposed.png">
    <!-- For iPhone 4 Retina display -->
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/images/apple-touch-icon-114-precomposed.png">
    <!-- For iPad -->
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/images/apple-touch-icon-72-precomposed.png">
    <!-- For iPad Retina display -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/images/apple-touch-icon-144-precomposed.png">

    <!-- CORE CSS FRAMEWORK - START -->
    <link href="/assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="https://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link href="/assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/fonts/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/fonts/webfont/cryptocoins.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/plugins/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" type="text/css"/>
    <!-- CORE CSS FRAMEWORK - END -->

    <!-- HEADER SCRIPTS INCLUDED ON THIS PAGE - START -->
    <link href="/assets/plugins/jvectormap/jquery-jvectormap-2.0.1.css" rel="stylesheet" type="text/css" media="screen">
    <link href="/assets/plugins/icheck/skins/all.css" rel="stylesheet" type="text/css" media="screen">
    <!-- HEADER SCRIPTS INCLUDED ON THIS PAGE - END -->

    <!-- CORE CSS TEMPLATE - START -->
    <link href="/assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/css/responsive.css" rel="stylesheet" type="text/css"/>
    <!-- CORE CSS TEMPLATE - END -->

</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class=" ">
<!-- START TOPBAR -->
<div class='page-topbar'>

    <div class='quick-area'>
        <div class='pull-left'>
            <ul class="info-menu left-links list-inline list-unstyled" style="float:left;">
                <li class="sidebar-toggle-wrap">
                    <a href="#" data-toggle="sidebar" class="sidebar_toggle">
                        <i class="fa fa-bars"></i>
                    </a>
                </li>
                <li class="message-toggle-wrapper">
                    <a href="#" data-toggle="dropdown" class="toggle">
                        <i class="fa fa-envelope"></i>
                        <%--                        <span class="badge badge-accent">7</span>--%>
                    </a>
                    <ul class="dropdown-menu messages animated fadeIn" style="left: -20px; top: 20px">

                        <li class="list">

                            <ul class="dropdown-menu-list list-unstyled ps-scrollbar">
                                <li class="unread status-available">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-1.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Clarine Vassar</strong>
                                                    <span class="time small">- 15 mins ago</span>
                                                <span class="profile-status available pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" status-away">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-2.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Brooks Latshaw</strong>
                                                    <span class="time small">- 45 mins ago</span>
                                                <span class="profile-status away pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" status-busy">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-3.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Clementina Brodeur</strong>
                                                    <span class="time small">- 1 hour ago</span>
                                                <span class="profile-status busy pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" status-offline">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-4.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Carri Busey</strong>
                                                    <span class="time small">- 5 hours ago</span>
                                                <span class="profile-status offline pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" status-offline">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-5.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Melissa Dock</strong>
                                                    <span class="time small">- Yesterday</span>
                                                <span class="profile-status offline pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" status-available">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-1.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Verdell Rea</strong>
                                                    <span class="time small">- 14th Mar</span>
                                                <span class="profile-status available pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" status-busy">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-2.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Linette Lheureux</strong>
                                                    <span class="time small">- 16th Mar</span>
                                                <span class="profile-status busy pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" status-away">
                                    <a href="javascript:;">
                                        <div class="user-img">
                                            <img src="/data/profile/avatar-3.png" alt="user-image"
                                                 class="img-circle img-inline">
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Araceli Boatright</strong>
                                                    <span class="time small">- 16th Mar</span>
                                                <span class="profile-status away pull-right"></span>
                                                </span>
                                            <span class="desc small">
                                                    Lorem ipsum dolor sit elit fugiat molest.
                                                </span>
                                        </div>
                                    </a>
                                </li>

                            </ul>

                        </li>

                        <li class="external">
                            <a href="javascript:;">
                                <span>Read All Messages</span>
                            </a>
                        </li>
                    </ul>

                </li>
                <li class="notify-toggle-wrapper">
                    <a href="#" data-toggle="dropdown" class="toggle">
                        <i class="fa fa-bell"></i>
                        <%--                        <span class="badge badge-accent">3</span>--%>
                    </a>
                    <ul class="dropdown-menu notifications animated fadeIn" style="left: -20px; top: 20px;">
                        <li class="total">
                                <span class="small">
                                You have <strong>3</strong> new notifications.
                                <a href="javascript:;" class="pull-right">Mark all as Read</a>
                            </span>
                        </li>
                        <li class="list">

                            <ul class="dropdown-menu-list list-unstyled ps-scrollbar">
                                <li class="unread available">
                                    <!-- available: success, warning, info, error -->
                                    <a href="javascript:;">
                                        <div class="notice-icon">
                                            <i class="fa fa-check"></i>
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>You just sold an item</strong>
                                                    <span class="time small">15 mins ago</span>
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class="unread away">
                                    <!-- available: success, warning, info, error -->
                                    <a href="javascript:;">
                                        <div class="notice-icon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Product on the Bootstrap Market</strong>
                                                    <span class="time small">45 mins ago</span>
                                                </span>
                                        </div>
                                    </a>
                                </li>
                                <li class=" busy">
                                    <!-- available: success, warning, info, error -->
                                    <a href="javascript:;">
                                        <div class="notice-icon">
                                            <i class="fa fa-times"></i>
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Cancelled Order of 200 item</strong>
                                                    <span class="time small">1 hour ago</span>
                                                </span>
                                        </div>
                                    </a>
                                </li>

                                <li class=" available">
                                    <!-- available: success, warning, info, error -->
                                    <a href="javascript:;">
                                        <div class="notice-icon">
                                            <i class="fa fa-check"></i>
                                        </div>
                                        <div>
                                                <span class="name">
                                                    <strong>Great server Speed of 1.34Gh </strong>
                                                    <span class="time small">14th Mar</span>
                                                </span>
                                        </div>
                                    </a>
                                </li>

                            </ul>

                        </li>

                        <li class="external">
                            <a href="javascript:;">
                                <span>Read All Notifications</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <%--<li class="hidden-sm hidden-xs searchform">
                    <form action="#" method="post">
                        <div class="input-group">
                                <span class="input-group-addon">
                                <i class="fa fa-search"></i>
                            </span>
                            <input type="text" class="form-control animated fadeIn" placeholder="Search & Enter">
                        </div>
                        <input type='submit' value="">
                    </form>
                </li>--%>
            </ul>
        </div>
        <div class='pull-right'>
            <ul class="info-menu right-links list-inline list-unstyled">
                <li class="profile">
                    <a href="#" data-toggle="dropdown" class="toggle">
                        <img src="/data/profile/hututu.jpeg" alt="user-image" class="img-circle img-inline">
                        <span>胡图图的小怪猫 <i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul class="dropdown-menu profile animated fadeIn">
                        <li>
                            <a href="account-confirmation.html">
                                <i class="fa fa-wrench"></i> 设置
                            </a>
                        </li>
                        <li>
                            <a href="ui-profile.html">
                                <i class="fa fa-user"></i> 好友
                            </a>
                        </li>
                        <li>
                            <a href="ui-support.html">
                                <i class="fa fa-info"></i> 帮助
                            </a>
                        </li>
                        <li class="last">
                            <a href="ui-login.html">
                                <i class="fa fa-lock"></i> 退出登录
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="chat-toggle-wrapper">
                    <a href="#" data-toggle="chatbar" class="toggle_chat">
                        <i class="fa fa-comments"></i>
                        <span class="badge badge-accent">9</span>
                        <i class="fa fa-times"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>

</div>
<!-- END TOPBAR -->
<!-- START CONTAINER -->
<div class="page-container row-fluid container-fluid">

    <!-- SIDEBAR - START -->

    <div class="page-sidebar fixedscroll">

        <!-- MAIN MENU - START -->
        <div class="page-sidebar-wrapper" id="main-menu-wrapper">

            <ul class='wraplist'>
            <li class='menusection'>目录</li>
            <li class="open">
                <a href="/master">
                    <i class="fa fa-th-large"></i>
                    <span class="title">首页</span>
                </a>
            </li>

            <%--                <li class="">--%>
            <%--                    <a href="javascript:;">--%>
            <%--                        <i class="fa fa-lock"></i>--%>
            <%--                        <span class="title">Access Pages</span>--%>
            <%--                        <span class="arrow "></span>--%>
            <%--                    </a>--%>
            <%--                    <ul class="sub-menu">--%>
            <%--                        <li>--%>
            <%--                            <a class="" href="ui-login.html">Login</a>--%>
            <%--                        </li>--%>
            <%--                        <li>--%>
            <%--                            <a class="" href="ui-register.html">Registration</a>--%>
            <%--                        </li>--%>
            <%--                        <li>--%>
            <%--                            <a class="" href="ui-404.html">404</a>--%>
            <%--                        </li>--%>
            <%--                    </ul>--%>
            <%--                </li>--%>

            <li class='menusection'>至尊芝士咸鱼（老许）</li>

            <li class="">
                <a href="javascript:;">
                    <i class="fa fa-envelope"></i>
                    <span class="title">文章管理</span>
                    <span class="arrow "></span>
                    <%--<span class="label label-accent">4</span>--%>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a class="" href="/selectAllArticle">浏览文章</a>
                    </li>
                    <li>
                        <a class="" href="/insertArticle">添加文章</a>
                    </li>
                    <li>
                        <a class="" href="updateArticle">修改文章</a>
                    </li>
                    <li>
                        <a class="" href="deleteArticle">删除文章</a>
                    </li>
                </ul>
            </li>

            <li class='menusection'>超大号蜜汁咸鱼</li>
            <li class="">
                <a href="javascript:;">
                    <i class="fa fa-bar-chart"></i>
                    <span class="title">商城管理</span>
                    <span class="arrow "></span>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a class="" href="sellerLogin">商家管理</a>
                    </li>
                    <li>
                        <a class="" href="shopAdministration">商品管理</a>
                    </li>
                </ul>
            </li>

            <li class='menusection'>来自发达瓦列斯的大咸鱼</li>

        </ul>

        </div>
        <!-- MAIN MENU - END -->

    </div>
    <!--  SIDEBAR - END -->

    <!-- START CONTENT -->
    <section id="main-content" class="">
        <div class="wrapper main-wrapper row" style="">

            <div class="clearfix"></div>
            <!-- MAIN CONTENT AREA STARTS -->

            <div class="col-lg-12">
                <section class="box nobox marginBottom0">
                    <div class="content-body">
                        <div class="row">

                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                <div class="statistics-box box-c1 flex align-items-center">
                                    <div class="mb-15 box-content-l">

                                        <div class="stats">
                                            <h3 class="bold mb-5">${articleCount}</h3>
                                            <span>已发表文章数</span>
                                        </div>
                                    </div>
                                    <div id="spark1"></div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                <div class="statistics-box box-c2 flex align-items-center">
                                    <div class="mb-15 box-content-l">

                                        <div class="stats">
                                            <h3 class="bold mb-5">236,000</h3>
                                            <span>今日阅读人数</span>
                                        </div>
                                    </div>
                                    <div id="spark2"></div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                <div class="statistics-box box-c3 flex align-items-center">
                                    <div class="mb-15 box-content-l">

                                        <div class="stats">
                                            <h3 class="bold mb-5">246,655</h3>
                                            <span>商城访问人数</span>
                                        </div>
                                    </div>
                                    <div id="spark3"></div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-sm-6 col-xs-12">
                                <div class="statistics-box box-c4 flex align-items-center">
                                    <div class="mb-15 box-content-l">

                                        <div class="stats">
                                            <h3 class="bold mb-5">1,053</h3>
                                            <span>今日收入</span>
                                        </div>
                                    </div>
                                    <div id="spark4"></div>
                                </div>
                            </div>

                        </div>
                        <!-- End .row -->
                    </div>
                </section>
            </div>

            <div class="clearfix"></div>

            <div class="col-lg-6 col-xs-12">
                <section class="box ">
                    <div class="content-body">
                        <div class="row">
                            <div class="col-xs-12">

                                <div class="card-body mt-30">
                                    <div class="wrapper border-bottom flex align-items-center">
                                        <div class="w-60">
                                            <p class="mb-0 text-gray">总发布文章数</p>
                                            <h2 class="mt-5 mb-5 bold">1764</h2>
                                            <%--                                            <p class="mb-15">比 昨 天 高 出 12.87%</p>--%>
                                        </div>
                                        <div>
                                            <p class="text-success mb-5">增长27.22%<i
                                                    class="fa-arrow badge-success fa fa-arrow-up ml-10"></i></p>
                                            <p class="text-greay">更新于3小时前</p>
                                        </div>
                                    </div>
                                    <div class="mt-15 wrapper flex align-items-center">
                                        <div class="w-60">
                                            <p class="mb-0 text-gray">今日发表文章数</p>
                                            <h2 class="mt-5 mb-5 bold">64</h2>
                                            <%--                                            <p class="mb-0">相较于昨日下降46.58%</p>--%>
                                        </div>
                                        <div>
                                            <p class="text-danger mb-5">下降46.58%<i
                                                    class="fa-arrow badge-danger fa fa-arrow-down ml-10"></i></p>
                                            <p class="text-greay">更新于3小时前</p>
                                        </div>
                                    </div>
                                </div>
                                <div id="area-adwords"></div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>

            <div class="col-md-6 col-sm-12 col-xs-12">

                <div class="row mt-15">
                    <div class="col-md-6 col-xs-12 ">
                        <div class="r1_graph1 db_box db_box_large has-shadow2">
                            <div class="pat-info-wrapper">
                                <div class="pat-info text-left">
                                    <h5 class=''>今日阅读人数</h5>
                                    <h6>访问人数</h6>
                                </div>
                                <div class="pat-val relative">
                                    <h4 class="value p-text">23.6K</h4>
                                </div>
                            </div>
                            <span class="sparklinedash2">Loading...</span>
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-12">
                        <div class="r1_graph1 db_box db_box_large has-shadow2">
                            <div class="pat-info-wrapper">
                                <div class="pat-info text-left">
                                    <h5 class=''>阅读量</h5>
                                    <%--<h6 class="red-text">Below the normal</h6>--%>
                                </div>
                                <div class="pat-val relative">
                                    <h4 class="value red-text">33.43K <span>每日</span></h4>
                                </div>
                            </div>
                            <span class="sparklinedash">Loading...</span>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <div class="r1_graph1 db_box db_box_large has-shadow2">
                            <div class="wrapper flex align-items-center">
                                <div class="w-50 text-left">
                                    <p class="mb-0 text-gray">商城访问人数</p>
                                    <h2 class="mt-10 mb-10 boldy">246,655</h2>
                                    <p class="mb-0">女生最开心的三件事就是，买买买。</p>
                                </div>
                                <div>
                                    <span class="db_dynamicbar">Loading...</span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-xs-12">
                        <div class="r1_graph1 db_box db_box_large has-shadow2">
                            <div class="pat-info-wrapper">
                                <div class="pat-info text-left">
                                    <h5 class=''>收入</h5>
                                    <%--                                    <h6>In the normal</h6>--%>
                                </div>
                                <div class="pat-val relative">
                                    <h4 class="value green-text"><i class="complete fa fa-arrow-up"></i>1,053<%--<span>follower</span>--%>
                                    </h4>
                                </div>
                            </div>
                            <span class="sparkline8">Loading...</span>
                        </div>
                    </div>
                    <div class="col-md-6 col-xs-12">
                        <div class="r1_graph1 db_box db_box_large has-shadow2">
                            <div class="pat-info-wrapper">
                                <div class="pat-info text-left">
                                    <h5 class=''>利润</h5>
                                    <%--                                    <h6>In the normal</h6>--%>
                                </div>
                                <div class="pat-val relative">
                                    <h4 class="value blue-text"><i class="cancelled fa fa-arrow-down"></i>124<%--<span>mg/dl</span>--%>
                                    </h4>
                                </div>
                            </div>
                            <span class="sparkline9">Loading...</span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="clearfix"></div>

            <div class="col-lg-12">
                <section class="box">
                    <header class="panel_header">
                        <h2 class="title pull-left">销售火热榜前五</h2>
                        <div class="actions panel_actions pull-right">
                            <a class="box_toggle fa fa-chevron-down"></a>
                            <a class="box_setting fa fa-cog" data-toggle="modal" href="#section-settings"></a>
                            <a class="box_close fa fa-times"></a>
                        </div>
                    </header>
                    <div class="content-body">
                        <div class="row">
                            <div class="col-xs-12">

                                <div class="table-responsive" data-pattern="priority-columns">
                                    <table id="tech-companies-1"
                                           class="table vm table-small-font no-mb table-bordered table-striped">
                                        <thead>
                                        <tr>
                                            <th>商品</th>
                                            <th>商品ID</th>
                                            <th>类型</th>
                                            <th>库存</th>
                                            <th>评分</th>
                                            <th>卖出数量</th>
                                            <th>单价</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                <div class="round img2">
                                                    <span class="colored-block gradient-blue"></span>
                                                </div>
                                                <div class="designer-info">
                                                    <h6>坚果小礼包</h6>
                                                    <small class="text-muted">填饱又低能量的小零食</small>
                                                </div>
                                            </td>
                                            <td>#45202</td>
                                            <td>食品</td>
                                            <td><span class="badge badge-md w-70 round-success">有</span></td>
                                            <td class="doc-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <span>5.0</span>
                                            </td>
                                            <td class="text-center">33</td>
                                            <td>$30</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="round img2">
                                                    <span class="colored-block gradient-pink"></span>
                                                </div>
                                                <div class="designer-info">
                                                    <h6>哈理工充电宝</h6>
                                                    <small class="text-muted">20000W毫安你值得拥有</small>
                                                </div>
                                            </td>
                                            <td>#45204</td>
                                            <td>电子</td>
                                            <td><span class="badge badge-md w-70 round-success">有</span></td>
                                            <td class="doc-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <span>4.7</span>
                                            </td>
                                            <td class="text-center">27</td>
                                            <td>$99</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="round img2">
                                                    <span class="colored-block gradient-green"></span>
                                                </div>
                                                <div class="designer-info">
                                                    <h6>哈理工纪念版U盘</h6>
                                                    <small class="text-muted">好看且纪念性极强的一款U盘</small>
                                                </div>
                                            </td>
                                            <td>#45459</td>
                                            <td>电子</td>
                                            <td><span class="badge badge-md w-70 round-danger">售完</span></td>
                                            <td class="doc-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <span>4.8</span>
                                            </td>
                                            <td class="text-center">25</td>
                                            <td>$59</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="round img2">
                                                    <span class="colored-block gradient-violet"></span>
                                                </div>
                                                <div class="designer-info">
                                                    <h6>哈理工纪念版衬衫</h6>
                                                    <small class="text-muted">防水帅气衬衫</small>
                                                </div>
                                            </td>
                                            <td>#45206</td>
                                            <td>服装</td>
                                            <td><span class="badge badge-md w-70 round-warning">紧张</span></td>
                                            <td class="doc-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <span>4.9</span>
                                            </td>
                                            <td class="text-center">19</td>
                                            <td>$299</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <div class="round img2">
                                                    <span class="colored-block gradient-orange"></span>
                                                </div>
                                                <div class="designer-info">
                                                    <h6>哈理工日历</h6>
                                                    <small class="text-muted">您的每一天都属于校园生活</small>
                                                </div>
                                            </td>
                                            <td> #45406</td>
                                            <td>校园周边</td>
                                            <td><span class="badge badge-md w-70 round-success">有</span></td>
                                            <td class="doc-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <span>4.8</span>
                                            </td>
                                            <td class="text-center">18</td>
                                            <td>$18</td>
                                        </tr>


                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </section>

            </div>

            <div class="clearfix"></div>


            <!-- MAIN CONTENT AREA ENDS -->
        </div>
    </section>
    <!-- END CONTENT -->
    <div class="page-chatapi hideit">

        <div class="search-bar">
            <input type="text" placeholder="Search" class="form-control">
        </div>

        <div class="chat-wrapper">

            <h4 class="group-head">Favourites</h4>
            <ul class="contact-list">

                <li class="user-row " id='chat_user_1' data-user-id='1'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-1.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Joge Lucky</a></h4>
                        <span class="status available" data-status="available"> Available</span>
                    </div>
                    <div class="user-status available">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_2' data-user-id='2'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-2.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Folisise Chosiel</a></h4>
                        <span class="status away" data-status="away"> Away</span>
                    </div>
                    <div class="user-status away">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_3' data-user-id='3'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-3.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Aron Gonzalez</a></h4>
                        <span class="status busy" data-status="busy"> Busy</span>
                    </div>
                    <div class="user-status busy">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>

            </ul>

            <h4 class="group-head">More Contacts</h4>
            <ul class="contact-list">

                <li class="user-row " id='chat_user_4' data-user-id='4'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-4.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Chris Fox</a></h4>
                        <span class="status offline" data-status="offline"> Offline</span>
                    </div>
                    <div class="user-status offline">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_5' data-user-id='5'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-5.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Mogen Polish</a></h4>
                        <span class="status offline" data-status="offline"> Offline</span>
                    </div>
                    <div class="user-status offline">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_6' data-user-id='6'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-1.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Smith Carter</a></h4>
                        <span class="status available" data-status="available"> Available</span>
                    </div>
                    <div class="user-status available">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_7' data-user-id='7'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-2.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Amilia Gozenal</a></h4>
                        <span class="status busy" data-status="busy"> Busy</span>
                    </div>
                    <div class="user-status busy">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_8' data-user-id='8'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-3.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Tahir Jemyship</a></h4>
                        <span class="status away" data-status="away"> Away</span>
                    </div>
                    <div class="user-status away">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_9' data-user-id='9'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-4.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Johanson Wright</a></h4>
                        <span class="status busy" data-status="busy"> Busy</span>
                    </div>
                    <div class="user-status busy">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>apexcharts-tooltip apexcharts-theme-light apexcharts-active
                <li class="user-row " id='chat_user_10' data-user-id='10'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-5.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Loni Tindall</a></h4>
                        <span class="status away" data-status="away"> Away</span>
                    </div>
                    <div class="user-status away">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_11' data-user-id='11'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-1.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Natcho Herlaey</a></h4>
                        <span class="status idle" data-status="idle"> Idle</span>
                    </div>
                    <div class="user-status idle">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_12' data-user-id='12'>
                    <div class="user-img">
                        <a href="#"><img src="/data/profile/avatar-2.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Shakira Swedan</a></h4>
                        <span class="status idle" data-status="idle"> Idle</span>
                    </div>
                    <div class="user-status idle">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>

            </ul>
        </div>

    </div>

    <div class="chatapi-windows ">

    </div>
</div>
<!-- END CONTAINER -->
<!-- LOAD FILES AT PAGE END FOR FASTER LOADING -->

<!-- CORE JS FRAMEWORK - START -->
<script src="https://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="/assets/js/jquery.easing.min.js"></script>
<script src="https://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script src="/assets/plugins/pace/pace.min.js"></script>
<script src="/assets/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="/assets/plugins/viewport/viewportchecker.js"></script>
<script>
    window.jQuery || document.write('<script src="/assets/js/jquery-1.11.2.min.js"><\/script>');
</script>
<!-- CORE JS FRAMEWORK - END -->

<!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - START -->
<script src="/assets/plugins/sparkline-chart/jquery.sparkline.min.js"></script>
<script src="/assets/js/chart-chartjs.js"></script>

<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="/assets/js/dash-scripts.js"></script>
<!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END -->

<!-- CORE TEMPLATE JS - START -->
<script src="/assets/js/scripts.js"></script>
<!-- END CORE TEMPLATE JS - END -->

</body>

</html>