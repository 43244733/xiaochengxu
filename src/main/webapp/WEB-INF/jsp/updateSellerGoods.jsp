<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2020/5/27
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="../seller/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../seller/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="../seller/css/amazeui.min.css" />
    <link rel="stylesheet" href="../seller/css/admin.css">
    <link rel="stylesheet" href="../seller/css/app.css">
</head>

<body data-type="generalComponents">


<header class="am-topbar am-topbar-inverse admin-header">
    <%-- <div class="am-topbar-brand">
         <a href="javascript:;" class="tpl-logo">
 &lt;%&ndash;            <img src="../seller/img/logo.png" alt="">&ndash;%&gt;
         </a>
     </div>--%>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right" style="margin-left: 25px; margin-top: 29px">

    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">2</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span> 您的库存已经不足，请进货</a>
                        <span class="tpl-dropdown-list-fr">3小时前</span>
                    </li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 您的库存准备不足</a>
                        <span class="tpl-dropdown-list-fr">2天前</span>
                    </li>

                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-comment-o"></span> 消息 <span class="am-badge tpl-badge-danger am-round">9</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-danger">9</span> 条新消息</h3><a href="###">全部</a></li>
                    <li>
                        <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="../seller/img/user02.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> 禁言小张 </span>
                                <span class="tpl-dropdown-content-time">10分钟前 </span>
                                </span>
                            <span class="tpl-dropdown-content-font"> Amaze UI 的诞生，依托于 GitHub 及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。 </span>
                        </a>
                        <a href="#" class="tpl-dropdown-content-message">
                                <span class="tpl-dropdown-content-photo">
                      <img src="../seller/img/user03.png" alt=""> </span>
                            <span class="tpl-dropdown-content-subject">
                      <span class="tpl-dropdown-content-from"> Steam </span>
                                <span class="tpl-dropdown-content-time">18分钟前</span>
                                </span>
                            <span class="tpl-dropdown-content-font"> 为了能最准确的传达所描述的问题， 建议你在反馈时附上演示，方便我们理解。 </span>
                        </a>
                    </li>

                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-calendar"></span> 进度 <span class="am-badge tpl-badge-primary am-round">1</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-primary">1</span> 个任务进度</h3></li>
                    <li>
                        <a href="javascript:;" class="tpl-dropdown-content-progress">
                                <span class="task">
                        <span class="desc">销量占比 </span>
                                <span class="percent">45%</span>
                                </span>
                            <span class="progress">
                        <div class="am-progress tpl-progress am-progress-striped"><div class="am-progress-bar am-progress-bar-success" style="width:45%"></div></div>
                    </span>
                        </a>
                    </li>

                </ul>
            </li>

            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" style="padding-top: 24px" href="javascript:;">
                    <span class="tpl-header-list-user-nick">${userLogin.name}</span><span class="tpl-header-list-user-ico">
                    <img src="/seller/img/hututu.jpeg"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a style="padding-top: 29px" href="###" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
        </ul>
    </div>
</header>




<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
            功能模块
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="sellerIndex" class="nav-link">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>
                <li class="tpl-left-nav-item">
                    <a href="dataShow" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-bar-chart"></i>
                        <span>交易数据表</span>
                        <%-- <i class="tpl-left-nav-content tpl-badge-danger">
                             12
                         </i>--%>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>我的商品</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <a href="selectUserGoods" class="active">
                                <i class="am-icon-angle-right"></i>
                                <span>商品管理</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>





    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title">
            商 品 修 改
        </div>
        <ol class="am-breadcrumb">
            <li><a href="sellerIndex" class="am-icon-home">首页</a></li>
            <li><a href="selectUserGoods">商品管理</a></li>
            <li class="am-active">商品修改</li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 商品修改
                </div>

            </div>
            <div class="tpl-block ">

                <div class="am-g tpl-amazeui-form">


                    <div class="am-u-sm-12 am-u-md-9">
                        <form class="am-form am-form-horizontal" action="doUpdateSellerGoods" method="get">
                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">商品名称 </label>
                                <div class="am-u-sm-9">
                                    <input type="text" name="name" value="${shop.name}">
                                    <input type="hidden" name="id" value="${shop.id}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">商品价格 </label>
                                <div class="am-u-sm-9">
                                    <input type="number" pattern="[0-9]*" name="price" value="${shop.price}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-phone" class="am-u-sm-3 am-form-label">类别 </label>
                                <div class="am-u-sm-9">
                                    <input type="tel" id="user-phone"  name="type" value="${shop.type}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">上架时间</label>
                                <div class="am-u-sm-9">
                                    <input type="tel" id="user-phone" name="time" value="${shop.time}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">描述 </label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="user-weibo" name="description" value="${shop.description}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="user-weibo" class="am-u-sm-3 am-form-label">库存数量 </label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="user-weibo"  name="number" value="${shop.number}">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <input type="submit" class="am-btn am-btn-secondary" value="确认修改"></input>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>


<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
<script src="../seller/js/amazeui.min.js"></script>
<script src="../seller/js/app.js"></script>
</body>

</html>