<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <link href="../../assets1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/3.2.1/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../assets1/css/ace.min.css"/>
    <link rel="stylesheet" href="../../assets1/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="../../assets1/css/ace-skins.min.css"/>
    <script src="../../assets1/js/ace-extra.min.js"></script>

    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>小程序后端管理系统</title>
    <meta content="" name="description"/>
    <meta content="" name="author"/>

    <!-- Favicon -->
    <link rel="shortcut icon" href="../assets/images/favicon.png" type="image/x-icon"/>
    <!-- For iPhone -->
    <link rel="apple-touch-icon-precomposed" href="../assets/images/apple-touch-icon-57-precomposed.png">
    <!-- For iPhone 4 Retina display -->
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="../assets/images/apple-touch-icon-114-precomposed.png">
    <!-- For iPad -->
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/images/apple-touch-icon-72-precomposed.png">
    <!-- For iPad Retina display -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="../assets/images/apple-touch-icon-144-precomposed.png">

    <!-- CORE CSS FRAMEWORK - START -->
    <link href="../assets/plugins/pace/pace-theme-flash.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="https://www.jq22.com/jquery/bootstrap-3.3.4.css">
    <link href="../assets/plugins/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/fonts/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/css/animate.min.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/plugins/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" type="text/css"/>
    <!-- CORE CSS FRAMEWORK - END -->

    <!-- HEADER SCRIPTS INCLUDED ON THIS PAGE - START -->

    <link href="../assets/plugins/bootstrap3-wysihtml5/css/bootstrap3-wysihtml5.min.css" rel="stylesheet"
          type="text/css" media="screen"/>
    <link href="../assets/plugins/tagsinput/css/bootstrap-tagsinput.css" rel="stylesheet" type="text/css"
          media="screen"/>

    <!-- HEADER SCRIPTS INCLUDED ON THIS PAGE - END -->

    <!-- CORE CSS TEMPLATE - START -->
    <link href="../assets/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../assets/css/responsive.css" rel="stylesheet" type="text/css"/>
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
                <li class="open">
                    <a href="javascript:;">
                        <i class="fa fa-bar-chart"></i>
                        <span class="title">商城管理</span>
                        <span class="arrow open"></span>
                    </a>
                    <ul class="sub-menu">
                        <li>
                            <a class="" href="sellerLogin">商家管理</a>
                        </li>
                        <li>
                            <a class="active" href="shopAdministration">商品管理</a>
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
        <div class="wrapper main-wrapper row" style=''>

            <div class='col-xs-12'>
                <div class="page-title">

                    <div class="pull-left">
                        <!-- PAGE HEADING TAG - START -->
                        <h1 class="title">商店里的味道总是那么清新，商店总能燃烧起你的欲望，苛求你不曾知道你需要的东西。</h1>
                        <!-- PAGE HEADING TAG - END -->
                    </div>

                    <div class="pull-right hidden-xs">
                        <ol class="breadcrumb">
                            <li>
                                <a href="index-dashboard.html"><i class="fa fa-home"></i>主页</a>
                            </li>

                            <li class="active">
                                <strong>商品管理</strong>
                            </li>
                        </ol>
                    </div>

                </div>
            </div>
            <div class="clearfix"></div>
            <!-- MAIN CONTENT AREA STARTS -->

            <div class="main-container" id="main-container">

                <script type="text/javascript">

                    try {
                        ace.settings.check('main-container', 'fixed')
                    } catch (e) {
                    }

                </script>

                <div class="main-container-inner">
                    <div class="main-content" style="margin-left: 20px; margin-right: 20px;">
                        <div class="page-content">
                            <div class="row">
                                <div class="col-xs-12">
                                    <!-- PAGE CONTENT BEGINS -->
                                    <div class="row">

                                        <div class="col-xs-12">
                                            <h3 class="header smaller lighter blue">商品管理</h3>
                                            <div class="table-header">女生最开心的三件事就是，买买买。</div>
                                            <div class="table-responsive">
                                                <table class="table table-striped table-bordered table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th class="center">
                                                            <label>
                                                                <input type="checkbox" class="ace"/>
                                                                <span class="lbl"></span>
                                                            </label>
                                                        </th>
                                                        <th>商品名称</th>
                                                        <th>价格</th>
                                                        <th class="hidden-480">类型</th>
                                                        <th>
                                                            <i class="icon-time bigger-110 hidden-480"></i>上架时间
                                                        </th>
                                                        <th class="hidden-480">库存</th>
                                                        <th>
                                                          <%--  <a class="btn btn-primary btn-xs" type="button" href="/insertGoods">
                                                                添加
                                                            </a>
                                                            <a class="blue" href="/insertGoods" style="float: right">
                                                                <i class="icon-zoom-in bigger-130"></i>
                                                            </a>--%>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${shops}" var="shop">
                                                        <tr>
                                                            <td class="center">
                                                                <label>
                                                                    <input type="checkbox" class="ace"/>
                                                                    <span class="lbl"></span>
                                                                </label>
                                                            </td>
                                                            <td>
                                                                <a href="#">${shop.name}</a>
                                                            </td>
                                                            <td>$${shop.price}</td>
                                                            <td class="hidden-480">${shop.type}</td>
                                                            <td>${shop.time}</td>
                                                            <c:if test="${shop.number >= 20}">
                                                                <td class="hidden-480">
                                                                    <span class="label label-sm label-success">充足</span>
                                                                </td>
                                                            </c:if>
                                                            <c:if test="${shop.number > 0 && shop.number < 20}">
                                                                <td class="hidden-480">
                                                                    <span class="label label-sm label-warning">紧张</span>
                                                                </td>
                                                            </c:if>
                                                            <c:if test="${shop.number == 0}">
                                                                <td class="hidden-480">
                                                                    <span class="label label-sm label-inverse arrowed-in">售完</span>
                                                                </td>
                                                            </c:if>
                                                            <td>
                                                                <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
                                                                   <%-- <a class="green" href="updateGoods?id=${shop.id}">
                                                                        <i class="icon-pencil bigger-130"></i>
                                                                    </a>--%>
                                                                    <a class="red" href="deleteGoods?id=${shop.id}">
                                                                        <i class="icon-trash bigger-130"></i>
                                                                    </a>
                                                                </div>
                                                                <div class="visible-xs visible-sm hidden-md hidden-lg">
                                                                    <div class="inline position-relative">
                                                                        <button class="btn btn-minier btn-yellow dropdown-toggle"
                                                                                data-toggle="dropdown">
                                                                            <i class="icon-caret-down icon-only bigger-120"></i>
                                                                        </button>
                                                                        <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
                                                                            <li>
                                                                                <a href="#" class="tooltip-info"
                                                                                   data-rel="tooltip" title="View">
           																			<span class="blue">
           																				<i class="icon-zoom-in bigger-120"></i>
           																			</span>
                                                                                </a>
                                                                            </li>
                                                                            <li>
                                                                                <a href="#" class="tooltip-success"
                                                                                   data-rel="tooltip" title="Edit">
           																			<span class="green">
           																				<i class="icon-edit bigger-120"></i>
           																			</span>
                                                                                </a>
                                                                            </li>
                                                                            <li>
                                                                                <a href="#" class="tooltip-error"
                                                                                   data-rel="tooltip" title="Delete">
           																			<span class="red">
           																				<i class="icon-trash bigger-120"></i>
           																			</span>
                                                                                </a>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>

                                                </table>

                                            </div>

                                        </div>

                                    </div>


                                    <div id="modal-table" class="modal fade" tabindex="-1">

                                        <div class="modal-dialog">

                                            <div class="modal-content">

                                                <div class="modal-header no-padding">

                                                    <div class="table-header">

                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-hidden="true">

                                                            <span class="white">&times;</span>

                                                        </button>

                                                        1111111111111111111111111 for "Latest Registered Domains

                                                    </div>

                                                </div>


                                                <div class="modal-body no-padding">

                                                    <table class="table table-striped table-bordered table-hover no-margin-bottom no-border-top">

                                                        <thead>

                                                        <tr>

                                                            <th>Domain</th>

                                                            <th>Price</th>

                                                            <th>Clicks</th>


                                                            <th>

                                                                <i class="icon-time bigger-110"></i>

                                                                Update

                                                            </th>

                                                        </tr>

                                                        </thead>


                                                        <tbody>

                                                        <tr>

                                                            <td>

                                                                <a href="#">ace.com</a>

                                                            </td>

                                                            <td>$45</td>

                                                            <td>3,330</td>

                                                            <td>Feb 12</td>

                                                        </tr>


                                                        <tr>

                                                            <td>

                                                                <a href="#">base.com</a>

                                                            </td>

                                                            <td>$35</td>

                                                            <td>2,595</td>

                                                            <td>Feb 18</td>

                                                        </tr>


                                                        <tr>

                                                            <td>

                                                                <a href="#">max.com</a>

                                                            </td>

                                                            <td>$60</td>

                                                            <td>4,400</td>

                                                            <td>Mar 11</td>

                                                        </tr>


                                                        <tr>

                                                            <td>

                                                                <a href="#">best.com</a>

                                                            </td>

                                                            <td>$75</td>

                                                            <td>6,500</td>

                                                            <td>Apr 03</td>

                                                        </tr>


                                                        <tr>

                                                            <td>

                                                                <a href="#">pro.com</a>

                                                            </td>

                                                            <td>$55</td>

                                                            <td>4,250</td>

                                                            <td>Jan 21</td>

                                                        </tr>

                                                        </tbody>

                                                    </table>

                                                </div>


                                                <div class="modal-footer no-margin-top">

                                                    <button class="btn btn-sm btn-danger pull-left"
                                                            data-dismiss="modal">

                                                        <i class="icon-remove"></i>

                                                        Close

                                                    </button>


                                                    <ul class="pagination pull-right no-margin">

                                                        <li class="prev disabled">

                                                            <a href="#">

                                                                <i class="icon-double-angle-left"></i>

                                                            </a>

                                                        </li>


                                                        <li class="active">

                                                            <a href="#">1</a>

                                                        </li>


                                                        <li>

                                                            <a href="#">2</a>

                                                        </li>


                                                        <li>

                                                            <a href="#">3</a>

                                                        </li>


                                                        <li class="next">

                                                            <a href="#">

                                                                <i class="icon-double-angle-right"></i>

                                                            </a>

                                                        </li>

                                                    </ul>

                                                </div>

                                            </div><!-- /.modal-content -->

                                        </div><!-- /.modal-dialog -->

                                    </div><!-- PAGE CONTENT ENDS -->

                                </div><!-- /.col -->

                            </div><!-- /.row -->

                        </div><!-- /.page-content -->

                    </div><!-- /.main-content -->


                    <div class="ace-settings-container" id="ace-settings-container">

                        <div class="ace-settings-box" id="ace-settings-box">

                            <div>

                                <div class="pull-left">

                                    <select id="skin-colorpicker" class="hide">

                                        <option data-skin="default" value="#438EB9">#438EB9</option>

                                        <option data-skin="skin-1" value="#222A2D">#222A2D</option>

                                        <option data-skin="skin-2" value="#C6487E">#C6487E</option>

                                        <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>

                                    </select>

                                </div>

                                <span>&nbsp; Choose Skin</span>

                            </div>


                            <div>

                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar"/>

                                <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>

                            </div>


                            <div>

                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar"/>

                                <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>

                            </div>


                            <div>

                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs"/>

                                <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>

                            </div>


                            <div>

                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"/>

                                <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>

                            </div>


                            <div>

                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container"/>

                                <label class="lbl" for="ace-settings-add-container">

                                    Inside

                                    <b>.container</b>

                                </label>

                            </div>

                        </div>

                    </div><!-- /#ace-settings-container -->

                </div><!-- /.main-container-inner -->


            </div><!-- /.main-container -->


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
                        <a href="#"><img src="data/profile/avatar-1.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-2.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-3.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-4.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-5.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-1.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-2.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-3.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-4.png" alt=""></a>
                    </div>
                    <div class="user-info">
                        <h4><a href="#">Johanson Wright</a></h4>
                        <span class="status busy" data-status="busy"> Busy</span>
                    </div>
                    <div class="user-status busy">
                        <i class="fa fa-circle"></i>
                    </div>
                </li>
                <li class="user-row " id='chat_user_10' data-user-id='10'>
                    <div class="user-img">
                        <a href="#"><img src="data/profile/avatar-5.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-1.png" alt=""></a>
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
                        <a href="#"><img src="data/profile/avatar-2.png" alt=""></a>
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
<script src="../assets/js/jquery.easing.min.js"></script>
<script src="https://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script src="../assets/plugins/pace/pace.min.js"></script>
<script src="../assets/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script src="../assets/plugins/viewport/viewportchecker.js"></script>
<script>
    window.jQuery || document.write('<script src="../assets/js/jquery-1.11.2.min.js"><\/script>');
</script>
<!-- CORE JS FRAMEWORK - END -->

<!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - START -->

<script src="../assets/plugins/autosize/autosize.min.js"></script>
<script src="../assets/plugins/tagsinput/js/bootstrap-tagsinput.min.js"></script>
<script src="../assets/plugins/bootstrap3-wysihtml5/js/bootstrap3-wysihtml5.all.min.js"></script>
<!-- OTHER SCRIPTS INCLUDED ON THIS PAGE - END -->

<!-- CORE TEMPLATE JS - START -->
<script src="../assets/js/scripts.js"></script>
<!-- END CORE TEMPLATE JS - END -->

<%--<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
<script type="text/javascript">
    window.jQuery || document.write("<script src='../../assets1/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='../../assets1/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>

<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script src="../../assets1/js/typeahead-bs2.min.js"></script>

<script src="../../assets1/js/jquery.dataTables.min.js"></script>
<script src="../../assets1/js/jquery.dataTables.bootstrap.js"></script>

<script src="../../assets1/js/ace-elements.min.js"></script>
<script src="../../assets1/js/ace.min.js"></script>

<script type="text/javascript">
    jQuery(function($) {
        var oTable1 = $('#sample-table-2').dataTable( {
            "aoColumns": [
                { "bSortable": false },
                null, null,null, null, null,
                { "bSortable": false }
            ] } );

        $('table th input:checkbox').on('click' , function(){
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });
        });

        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();
            var off2 = $source.offset();
            var w2 = $source.width();
            if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
            return 'left';
        }
    })
</script>--%>

</body>

</html>
