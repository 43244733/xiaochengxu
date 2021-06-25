<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2020/5/27
  Time: 17:30
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

<body data-type="generalComponents">


<header class="am-topbar am-topbar-inverse admin-header">
    <%-- <div class="am-topbar-brand">
         <a href="javascript:;" class="tpl-logo">
 &lt;%&ndash;            <img src="../seller/img/logo.png" alt="">&ndash;%&gt;
         </a>
     </div>--%>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right" style="margin-left: 25px">

    </div>

    <button class="am-topbar-am-icon-list tpl-header-nav-hover-ico am-fl am-margin-rightbtn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-bell-o"></span> 提醒 <span
                        class="am-badge tpl-badge-success am-round">2</span></span>
                </a>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    <li class="tpl-dropdown-content-external">
                        <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span
                            class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span>
                        您的库存已经不足，请进货</a>
                        <span class="tpl-dropdown-list-fr">3小时前</span>
                    </li>
                    <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span
                            class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span>
                        您的库存准备不足</a>
                        <span class="tpl-dropdown-list-fr">2天前</span>
                    </li>

                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="am-icon-comment-o"></span> 消息 <span
                        class="am-badge tpl-badge-danger am-round">9</span></span>
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
                    <span class="am-icon-calendar"></span> 进度 <span
                        class="am-badge tpl-badge-primary am-round">1</span></span>
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
                        <div class="am-progress tpl-progress am-progress-striped"><div
                                class="am-progress-bar am-progress-bar-success" style="width:45%"></div></div>
                    </span>
                        </a>
                    </li>

                </ul>
            </li>

            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick">${userLogin.name}</span><span
                        class="tpl-header-list-user-ico">
                    <img src="/seller/img/hututu.jpeg"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li><a href="###" class="tpl-header-list-link"><span
                    class="am-icon-sign-out tpl-header-list-ico-out-size"></span></a></li>
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
            商 品 管 理
        </div>
        <ol class="am-breadcrumb">
            <li><a href="sellerIndex" class="am-icon-home">首页</a></li>
            <li><a href="selectUserGoods">商品管理</a></li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 商品管理
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                            <i class="am-icon-search"></i>
                            <input type="text" class="form-control form-control-solid" placeholder="搜索..."></div>
                    </div>
                </div>


            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <a type="button" class="am-btn am-btn-default am-btn-success"
                                   href="insertSellerGoods"><span
                                        class="am-icon-plus"></span> 新增
                                </a>
                                <a type="button" class="am-btn am-btn-default am-btn-secondary"
                                   href="updateSellerGoods"><span
                                        class="am-icon-archive"></span> 修改
                                </a>
                                <button type="button" class="am-btn am-btn-default am-btn-danger"><span
                                        class="am-icon-trash-o"></span> 删除
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-form-group">
                            <select data-am-selected="{btnSize: 'sm'}">
                                <option value="option1">所有类别</option>
                                <option value="option2">生活用品</option>
                                <option value="option3">书籍</option>
                                <option value="option3">体育用品</option>
                                <option value="option3">学习资料</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                            <input type="text" class="am-form-field">
                            <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                    type="button"></button>
          </span>
                        </div>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-check"><input type="checkbox" class="tpl-table-fz-check"></th>
                                    <th class="table-type">商品图片</th>
                                    <th class="table-type">商品名称</th>
                                    <th class="table-id">价格</th>
                                    <th class="table-type">类别</th>
                                    <th class="table-date am-hide-sm-only">上架时间</th>
                                    <th class="table-type">库存</th>
                                    <th class="table-set">操作</th>
                                    <th class="table-type">评价</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${shops}" var="shop">
                                    <tr>
                                        <td><input type="checkbox"></td>
                                        <c:if test="${shop.url == null}">
                                            <td><a href="/file?id=${shop.id}">上传图片</a></td>
                                        </c:if>
                                        <c:if test="${shop.url != null}">
                                            <td><a href="/file?id=${shop.id}">重新上传</a></td>
                                        </c:if>
                                        <td>${shop.name}</td>
                                        <td>${shop.price}</td>
                                        <td>${shop.type}</td>
                                        <td class="am-hide-sm-only">${shop.time}</td>
                                        <td class="am-hide-sm-only">${shop.number}</td>
                                        <td>
                                            <div class="am-btn-toolbar">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <a class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                       href="updateSellerGoods?id=${shop.id}">
                                                        <span class="am-icon-pencil-square-o"></span> 修改
                                                    </a>
                                                    <a class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                       href="deleteSellerGoods?id=${shop.id}">
                                                        <span class="am-icon-trash-o"></span> 删除
                                                    </a>
                                                </div>
                                            </div>
                                        </td>
                                        <td><a href="/selectMessage?gId=${shop.id}">评价</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <li class="am-disabled"><a href="#">«</a></li>
                                        <li class="am-active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">»</a></li>
                                    </ul>
                                </div>
                            </div>
                            <hr>

                        </form>
                    </div>

                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>
    </div>
</div>

<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
<script src="../seller/js/amazeui.min.js"></script>
<script src="../seller/js/app.js"></script>
</body>

</html>
