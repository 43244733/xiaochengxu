<%--
  Created by IntelliJ IDEA.
  User: 86131
  Date: 2020/5/26
  Time: 23:06
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
    <script src="../seller/js/echarts.min.js"></script>
</head>

<body data-type="index">


<header class="am-topbar am-topbar-inverse admin-header">
    <%-- <div class="am-topbar-brand">
         <a href="javascript:;" class="tpl-logo">
 &lt;%&ndash;            <img src="../seller/img/logo.png" alt="">&ndash;%&gt;
         </a>
     </div>--%>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right" style="margin-left: 25px">

    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
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
                    <a href="sellerIndex" class="nav-link active">
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
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>我的商品</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu">
                        <li>
                            <a href="selectUserGoods">
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
            今 日 销 售 数 据
        </div>
        <ol class="am-breadcrumb">
            <li><a href="sellerIndex" class="am-icon-home">首页</a></li>
        </ol>
        <div class="tpl-content-scope">
            <div class="note note-info">
                <h3> 咸鱼的野望
                    <span class="close" data-close="note"></span>
                </h3>
                <p> 相信用不了多久我就会升职加薪当上总经理,出任CEO,迎娶白富美,走向人生巅峰。想想,还有点小激动。 </p>
                <p><span class="label label-danger">PS:</span> 天崖落叶未归根,人生一切是浮尘
                </p>
            </div>
        </div>

        <div class="row">
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat blue">
                    <div class="visual">
                        <i class="am-icon-comments-o"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 1349</div>
                        <div class="desc"> 新消息</div>
                    </div>
                    <a class="more" href="#"> 查看更多
                        <i class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat red">
                    <div class="visual">
                        <i class="am-icon-bar-chart-o"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 99%</div>
                        <div class="desc"> 评价</div>
                    </div>
                    <a class="more" href="#"> 查看更多
                        <i class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat green">
                    <div class="visual">
                        <i class="am-icon-apple"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 653</div>
                        <div class="desc"> IOS交易数量</div>
                    </div>
                    <a class="more" href="#"> 查看更多
                        <i class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>
            <div class="am-u-lg-3 am-u-md-6 am-u-sm-12">
                <div class="dashboard-stat purple">
                    <div class="visual">
                        <i class="am-icon-android"></i>
                    </div>
                    <div class="details">
                        <div class="number"> 786</div>
                        <div class="desc"> Android交易数量</div>
                    </div>
                    <a class="more" href="#"> 查看更多
                        <i class="m-icon-swapright m-icon-white"></i>
                    </a>
                </div>
            </div>


        </div>

        <div class="row">
            <div class="am-u-md-6 am-u-sm-12 row-mb">
                <div class="tpl-portlet">
                    <div class="tpl-portlet-title">
                        <div class="tpl-caption font-green ">
                            <i class="am-icon-cloud-download"></i>
                            <span> 交易数据统计</span>
                        </div>
                        <div class="actions">
                            <ul class="actions-btn">
                                <li class="red-on">今天</li>
                                <li class="green">昨天</li>
                                <li class="blue">本周</li>
                            </ul>
                        </div>
                    </div>

                    <!--此部分数据请在 js文件夹下中的 app.js 中的 “百度图表A” 处修改数据 插件使用的是 百度echarts-->
                    <div class="tpl-echarts" id="tpl-echarts-A">

                    </div>
                </div>
            </div>
            <div class="am-u-md-6 am-u-sm-12 row-mb">
                <div class="tpl-portlet">
                    <div class="tpl-portlet-title">
                        <div class="tpl-caption font-red ">
                            <i class="am-icon-bar-chart"></i>
                            <span>销售量前六商品</span>
                        </div>
                        <div class="actions">
                            <ul class="actions-btn">
                                <li class="purple-on">昨天</li>
                                <li class="green">前天</li>
                                <li class="dark">本周</li>
                            </ul>
                        </div>
                    </div>
                    <div class="tpl-scrollable">
                        <div class="number-stats">
                            <div class="stat-number am-fl am-u-md-6">
                                <div class="title am-text-right"> 预估成交额</div>
                                <div class="number am-text-right am-text-warning"> 2460</div>
                            </div>
                            <div class="stat-number am-fr am-u-md-6">
                                <div class="title"> 实际成交额</div>
                                <div class="number am-text-success"> 3150</div>
                            </div>

                        </div>

                        <table class="am-table tpl-table">
                            <thead>
                            <tr class="tpl-table-uppercase">
                                <th>名称</th>
                                <th>价格</th>
                                <th>交易次数</th>
                                <th>评价</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    <%--                                    <img src="../seller/img/user01.png" alt="" class="user-pic">--%>
                                    <a class="user-name" href="###">坚果小礼包</a>
                                </td>
                                <td>￥30</td>
                                <td>651</td>
                                <td class="font-green bold">99%</td>
                            </tr>
                            <tr>
                                <td>
                                    <%--                                    <img src="../seller/img/user02.png" alt="" class="user-pic">--%>
                                    <a class="user-name" href="###">哈理工充电宝</a>
                                </td>
                                <td>￥120</td>
                                <td>347</td>
                                <td class="font-green bold">98%</td>
                            </tr>
                            <tr>
                                <td>
                                    <%--                                    <img src="../seller/img/user03.png" alt="" class="user-pic">--%>
                                    <a class="user-name" href="###">哈理工纪念版U盘</a>
                                </td>
                                <td>￥69</td>
                                <td>336</td>
                                <td class="font-green bold">100%</td>
                            </tr>
                            <tr>
                                <td>
                                    <%--                                    <img src="../seller/img/user04.png" alt="" class="user-pic">--%>
                                    <a class="user-name" href="###">哈理工纪念版衬衫</a>
                                </td>
                                <td>￥99</td>
                                <td>229</td>
                                <td class="font-green bold">97%</td>
                            </tr>
                            <tr>
                                <td>
                                    <%--                                    <img src="../seller/img/user05.png" alt="" class="user-pic">--%>
                                    <a class="user-name" href="###">哈理工日历</a>
                                </td>
                                <td>￥29</td>
                                <td>179</td>
                                <td class="font-green bold">98%</td>
                            </tr>
                            <tr>
                                <td>
                                    <%--                                    <img src="../seller/img/user06.png" alt="" class="user-pic">--%>
                                    <a class="user-name" href="###">校运会纪念手办</a>
                                </td>
                                <td>￥400</td>
                                <td>65</td>
                                <td class="font-green bold">99%</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="am-u-md-6 am-u-sm-12 row-mb">

                <div class="tpl-portlet">
                    <div class="tpl-portlet-title">
                        <div class="tpl-caption font-green ">
                            <span>客户留言</span>
                            <span class="caption-helper">8 条</span>
                        </div>
                        <div class="tpl-portlet-input">
                            <div class="portlet-input input-small input-inline">
                                <div class="input-icon right">
                                    <i class="am-icon-search"></i>
                                    <input type="text" class="form-control form-control-solid" placeholder="搜索...">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="wrapper" class="wrapper">
                        <div id="scroller" class="scroller">
                            <ul class="tpl-task-list">
                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp">U盘很好用，非常有纪念意义的图案</span>
                                        <span class="label label-sm label-success">小花</span>
                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 用户给予了五星好评 </span>
                                        <span class="label label-sm label-danger">小红</span>

                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 日历很好看，可惜有个角折了 </span>
                                        <span class="label label-sm label-warning">小黄</span>

                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 衬衫防汗效果特别好，推荐！！！</span>
                                        <span class="label label-sm label-danger">天天</span>

                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 希望可以推出校园伞~</span>
                                        <span class="label label-sm label-success">小吕</span>
                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>


                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 小零食特别好吃，好想给我女朋友买好多好多</span>
                                        <span class="label label-sm label-danger">胡图图的小怪猫</span>
                                        <span class="task-bell">
                                            <i class="am-icon-bell-o"></i>
                                        </span>
                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp"> 用户给予了五星好评</span>
                                        <span class="label label-sm label-warning">小乔</span>

                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <div class="task-checkbox">
                                        <input type="hidden" value="1" name="test">
                                        <input type="checkbox" class="liChild" value="2" name="test"></div>
                                    <div class="task-title">
                                        <span class="task-title-sp">我想堆雪人</span>
                                        <span class="label label-sm label-default">已废弃</span>

                                    </div>
                                    <div class="task-config">
                                        <div class="am-dropdown tpl-task-list-dropdown" data-am-dropdown>
                                            <a href="###" class="am-dropdown-toggle tpl-task-list-hover "
                                               data-am-dropdown-toggle>
                                                <i class="am-icon-cog"></i> <span class="am-icon-caret-down"></span>
                                            </a>
                                            <ul class="am-dropdown-content tpl-task-list-dropdown-ul">
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-check"></i> 保存 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-pencil"></i> 编辑 </a>
                                                </li>
                                                <li>
                                                    <a href="javascript:;">
                                                        <i class="am-icon-trash-o"></i> 删除 </a>
                                                </li>
                                            </ul>


                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="am-u-md-6 am-u-sm-12 row-mb">
                <div class="tpl-portlet">
                    <div class="tpl-portlet-title">
                        <div class="tpl-caption font-green ">
                            <span>进货信息</span>
                        </div>

                    </div>

                    <div class="am-tabs tpl-index-tabs" data-am-tabs>
                        <ul class="am-tabs-nav am-nav am-nav-tabs">
                            <li class="am-active"><a href="#tab1">进行中</a></li>
                            <li><a href="#tab2">已完成</a></li>
                        </ul>

                        <div class="am-tabs-bd">
                            <div class="am-tab-panel am-fade am-in am-active" id="tab1">
                                <div id="wrapperA" class="wrapper">
                                    <div id="scroller" class="scroller">
                                        <ul class="tpl-task-list tpl-task-remind">
                                            <li>
                                                <div class="cosB">
                                                    12分钟前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco">
                        <i class="am-icon-bell-o"></i>
                      </span>

                                                    <span> 注意：校运会纪念手办已到达杭州

                                                        </span></span>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="cosB">
                                                    36分钟前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco label-danger">
                        <i class="am-icon-bolt"></i>
                      </span>

                                                    <span> 哈理工日历已发货 </span>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="cosB">2小时前</div>
                                                <div class="cosA">
                                                    <span class="cosIco label-info">
                                                      <i class="am-icon-bullhorn"></i>
                                                    </span>
                                                    <span> 哈理工纪念版衬衫已开始配送 快递员：刘某（13521541206）</span>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="cosB">1天前</div>
                                                <div class="cosA">
                                                        <span class="cosIco label-warning"><i class="am-icon-plus"></i></span>
                                                    <span> 坚果小礼包正在揽件，请稍后</span>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="cosB">2天前</div>
                                                <div class="cosA">
                                                    <span class="cosIco">
                                                     <i class="am-icon-bell-o"></i>
                                                  </span>
                                                    <span> 注意：校运会纪念手办中转广州站</span>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="cosB">3天前</div>
                                                <div class="cosA">
                                                    <span class="cosIco label-danger">
                                                       <i class="am-icon-bolt"></i>
                                               </span>
                                                    <span>哈理工充电宝已到达哈尔滨站</span>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="cosB">3天前</div>
                                                <div class="cosA">
                                                        <span class="cosIco label-info">
                                                            i class="am-icon-bullhorn"></i>
                                                 </span>
                                                    <span> 哈理工日历一开始配送 快递员：刘某（13521541206）</span>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="cosB">5天前</div>
                                                <div class="cosA">
                                                    <span class="cosIco label-warning">
                                                        <i class="am-icon-plus"></i>
                                                 </span>
                                                    <span> 校运会纪念手办正在揽件，请稍后</span>
                                                </div>
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="am-tab-panel am-fade" id="tab2">
                                <div id="wrapperB" class="wrapper">
                                    <div id="scroller" class="scroller">
                                        <ul class="tpl-task-list tpl-task-remind">
                                            <li>
                                                <div class="cosB">
                                                    12分钟前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco">
                        <i class="am-icon-bell-o"></i>
                      </span>

                                                    <span> 注意：Chrome 和 Firefox 下， display: inline-block; 或 display: block; 的元素才会应用旋转动画。<span
                                                            class="tpl-label-info"> 提取文件
                                                            <i class="am-icon-share"></i>
                                                        </span></span>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="cosB">
                                                    36分钟前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco label-danger">
                        <i class="am-icon-bolt"></i>
                      </span>

                                                    <span> FontAwesome 在绘制图标的时候不同图标宽度有差异， 添加 .am-icon-fw 将图标设置为固定的宽度，解决宽度不一致问题（v2.3 新增）。</span>
                                                </div>

                                            </li>

                                            <li>
                                                <div class="cosB">
                                                    2小时前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco label-info">
                        <i class="am-icon-bullhorn"></i>
                      </span>

                                                    <span> 使用 flexbox 实现，只兼容 IE 10+ 及其他现代浏览器。</span>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="cosB">
                                                    1天前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco label-warning">
                        <i class="am-icon-plus"></i>
                      </span>

                                                    <span> 部分用户反应在过长的 Tabs 中滚动页面时会意外触发 Tab 切换事件，用户可以选择禁用触控操作。</span>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="cosB">
                                                    12分钟前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco">
                        <i class="am-icon-bell-o"></i>
                      </span>

                                                    <span> 注意：Chrome 和 Firefox 下， display: inline-block; 或 display: block; 的元素才会应用旋转动画。<span
                                                            class="tpl-label-info"> 提取文件
                                                            <i class="am-icon-share"></i>
                                                        </span></span>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="cosB">
                                                    36分钟前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco label-danger">
                        <i class="am-icon-bolt"></i>
                      </span>

                                                    <span> FontAwesome 在绘制图标的时候不同图标宽度有差异， 添加 .am-icon-fw 将图标设置为固定的宽度，解决宽度不一致问题（v2.3 新增）。</span>
                                                </div>

                                            </li>

                                            <li>
                                                <div class="cosB">
                                                    2小时前
                                                </div>
                                                <div class="cosA">
                                                        <span class="cosIco label-info">
                        <i class="am-icon-bullhorn"></i>
                      </span>

                                                    <span> 使用 flexbox 实现，只兼容 IE 10+ 及其他现代浏览器。</span>
                                                </div>

                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>


    </div>

</div>


<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
<script src="../seller/js/amazeui.min.js"></script>
<script src="../seller/js/iscroll.js"></script>
<script src="../seller/js/app.js"></script>
</body>

</html>