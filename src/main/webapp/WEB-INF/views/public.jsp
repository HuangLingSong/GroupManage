<%@ page import="com.glory.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    User user= (User) session.getAttribute("User");
//    if (user==null) {
//        request.getRequestDispatcher("/Passport/Login").forward(request,response);
//    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme">
    <meta name="description" content="Fusion - A Responsive HTML5 Admin UI Template Theme">
    <meta name="author" content="AdminDesigns">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap-3.3.7/css/bootstrap.css">
    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="/resources/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/theme.css">


    <!-- Favicon -->
    <link rel="stylesheet" type="text/css" href="/resources/logo.png">
    <style>
        .navbar-brand-char{
            font-size: 14px;
            font-weight: bold;
            position: fixed;
            top :20px;
            overflow: hidden;
            width: 140px;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
    </style>
    <style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
    .en-markup-crop-options {
        top: 18px !important;
        left: 50% !important;
        margin-left: -100px !important;
        width: 200px !important;
        border: 2px rgba(255,255,255,.38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style></head>

<body class="dashboard-page mobile-view">

<!-- Start: Header -->
<header class="navbar navbar-fixed-top">
    <div class="navbar-branding">
        <span id="toggle_sidemenu_l" class="glyphicons glyphicons-show_lines"></span>
        <a class="navbar-brand-char" href="/">分组管理系统</a> </div>

</header>

<!-- Start: Main -->
<div id="main">
    <!-- Start: Sidebar -->
    <aside id="sidebar_left">

        <div class="user-info">
            <div class="media">
                <a class="pull-left" href="#">
                    <div class="media-object border border-purple br64 bw2 p2">
                        <img class="br64"  src="/resources/images/portrait.jpg" alt="...">
                    </div>
                </a>
                <div class="mobile-link"> <span class="glyphicons glyphicons-show_big_thumbnails"></span> </div>
                <div class="media-body">
                    <h5 class="media-heading mt5 mbn fw700 cursor"><% if (user!=null ) {%> <%= user.getUsername()%> <%}%><span class="caret ml5"></span></h5>
                    <div class="media-links fs11" style="margin-top: 10px;"><a   href="#">菜单</a>　<i class="fa fa-circle text-muted fs3 p8 va-m"></i><a href="/Passport/Logout">退出</a></div>
                </div>
            </div>
        </div>

        <div class="user-divider"></div>
        <div class="user-menu" id="collapseOne">
            <div class="row text-center mb15">
                <div class="col-xs-4"> <a href="#"> <span class="glyphicons glyphicons-home fs22 text-blue2"></span>
                    <h5 class="fs11">Home</h5>
                </a> </div>
                <div class="col-xs-4"> <a href="#"> <span class="glyphicons glyphicons-inbox fs22 text-orange2"></span>
                    <h5 class="fs11">Inbox</h5>
                </a> </div>
                <div class="col-xs-4"> <a href="#"> <span class="glyphicons glyphicons-bell fs22 text-purple2"></span>
                    <h5 class="fs11">Data</h5>
                </a> </div>
            </div>
            <div class="row text-center">
                <div class="col-xs-4 text-center"> <a href="#"> <span class="glyphicons glyphicons-imac fs22 text-grey3"></span>
                    <h5 class="fs11">Views</h5>
                </a> </div>
                <div class="col-xs-4"> <a href="#"> <span class="glyphicons glyphicons-settings fs22 text-green2"></span>
                    <h5 class="fs11">Settings</h5>
                </a> </div>
                <div class="col-xs-4"> <a href="#"> <span class="glyphicons glyphicons-restart fs22 text-light6"></span>
                    <h5 class="fs11">Refresh</h5>
                </a> </div>
            </div>
        </div>

        <div class="sidebar-menu">
            <ul class="nav">

                <li> <a class="accordion-toggle" href="#sideAccount"><span class="glyphicons glyphicons-keys"></span><span class="sidebar-title">系统管理</span><span class="caret"></span></a>
                    <ul id="sideAccount" class="nav sub-nav" style="">
                        <li><a class="ajax-disable" href="/User/List"><span class="glyphicons glyphicons-keys"></span> 人员列表 </a></li>                    <li class="divider"></li>
                        <li><a class="ajax-disable" href="/Group/List"><span class="glyphicons glyphicons-keys"></span> 人员分组 </a></li>                      <li class="divider"></li>
                        <%--<li><a class="ajax-disable" href="/account/groupaccess"><span class="glyphicons glyphicons-keys"></span> 人员权限 </a></li>          --%>
                    </ul>
                </li>
                <li> <a class="accordion-toggle" href="#sideAccount1"><span class="glyphicons glyphicons-keys"></span><span class="sidebar-title">我的小组</span><span class="caret"></span></a>
                    <ul id="sideAccount1" class="nav sub-nav" style="">
                        <li><a class="ajax-disable" href="/account/list"><span class="glyphicons glyphicons-keys"></span> 小组成员 </a></li>                    <li class="divider"></li>
                        <li><a class="ajax-disable" href="/Group/Create"><span class="glyphicons glyphicons-keys"></span> 创建小组 </a></li>                      <li class="divider"></li>
                        <li><a class="ajax-disable" href="/account/group"><span class="glyphicons glyphicons-keys"></span> 添加/删除成员 </a></li>                      <li class="divider"></li>
                    </ul>
                </li>

            </ul>
        </div>
    </aside>  <!-- Start: Content -->