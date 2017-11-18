<%@ page import="com.glory.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.glory.entity.Group" %>
<%@ page import="java.security.Guard" %>
<%@ page import="com.glory.entity.Role" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    User user = (User) session.getAttribute("User");
//    if (user==null) {
//        request.getRequestDispatcher("/Passport/Login").forward(request,response);
//    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>人员列表</title>
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
        .navbar-brand-char {
            font-size: 14px;
            font-weight: bold;
            position: fixed;
            top: 20px;
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
        border: 2px rgba(255, 255, 255, .38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style>
</head>

<body class="dashboard-page mobile-view">

<!-- Start: Header -->
<header class="navbar navbar-fixed-top">
    <div class="navbar-branding">
        <span id="toggle_sidemenu_l" class="glyphicons glyphicons-show_lines"></span>
        <a class="navbar-brand-char" href="/">分组管理系统</a></div>

</header>

<!-- Start: Main -->
<div id="main">
    <!-- Start: Sidebar -->
    <aside id="sidebar_left">

        <div class="user-info">
            <div class="media">
                <a class="pull-left" href="#">
                    <div class="media-object border border-purple br64 bw2 p2">
                        <img class="br64" src="/resources/images/portrait.jpg" alt="...">
                    </div>
                </a>
                <div class="mobile-link"><span class="glyphicons glyphicons-show_big_thumbnails"></span></div>
                <div class="media-body">
                    <h5 class="media-heading mt5 mbn fw700 cursor"><% if (user != null) {%> <%= user.getUsername()%> <%}%><span
                            class="caret ml5"></span></h5>
                    <div class="media-links fs11" style="margin-top: 10px;"><a href="#">菜单</a>　<i
                            class="fa fa-circle text-muted fs3 p8 va-m"></i><a href="/Passport/Logout">退出</a></div>
                </div>
            </div>
        </div>

        <div class="user-divider"></div>
        <div class="user-menu" id="collapseOne">
            <div class="row text-center mb15">
                <div class="col-xs-4"><a href="#"> <span class="glyphicons glyphicons-home fs22 text-blue2"></span>
                    <h5 class="fs11">Home</h5>
                </a></div>
                <div class="col-xs-4"><a href="#"> <span class="glyphicons glyphicons-inbox fs22 text-orange2"></span>
                    <h5 class="fs11">Inbox</h5>
                </a></div>
                <div class="col-xs-4"><a href="#"> <span class="glyphicons glyphicons-bell fs22 text-purple2"></span>
                    <h5 class="fs11">Data</h5>
                </a></div>
            </div>
            <div class="row text-center">
                <div class="col-xs-4 text-center"><a href="#"> <span
                        class="glyphicons glyphicons-imac fs22 text-grey3"></span>
                    <h5 class="fs11">Views</h5>
                </a></div>
                <div class="col-xs-4"><a href="#"> <span class="glyphicons glyphicons-settings fs22 text-green2"></span>
                    <h5 class="fs11">Settings</h5>
                </a></div>
                <div class="col-xs-4"><a href="#"> <span class="glyphicons glyphicons-restart fs22 text-light6"></span>
                    <h5 class="fs11">Refresh</h5>
                </a></div>
            </div>
        </div>

        <div class="sidebar-menu">
            <ul class="nav">

                <li><a class="accordion-toggle" href="#sideAccount"><span
                        class="glyphicons glyphicons-keys"></span><span class="sidebar-title">系统管理</span><span
                        class="caret"></span></a>
                    <ul id="sideAccount" class="nav sub-nav" style="">
                        <li><a class="ajax-disable" href="/User/List"><span class="glyphicons glyphicons-keys"></span>
                            人员列表 </a></li>
                        <li class="divider"></li>
                        <li><a class="ajax-disable" href="/Group/List"><span class="glyphicons glyphicons-keys"></span>
                            人员分组 </a></li>
                        <li class="divider"></li>
                        <%--<li><a class="ajax-disable" href="/account/groupaccess"><span--%>
                        <%--class="glyphicons glyphicons-keys"></span> 人员权限 </a></li>--%>
                    </ul>
                </li>
                <li><a class="accordion-toggle" href="#sideAccount1"><span
                        class="glyphicons glyphicons-keys"></span><span class="sidebar-title">我的小组</span><span
                        class="caret"></span></a>
                    <ul id="sideAccount1" class="nav sub-nav" style="">
                        <li><a class="ajax-disable" href="/account/list"><span
                                class="glyphicons glyphicons-keys"></span> 小组成员 </a></li>
                        <li class="divider"></li>
                        <li><a class="ajax-disable" href="/Group/Create"><span
                                class="glyphicons glyphicons-keys"></span> 创建小组 </a></li>
                        <li class="divider"></li>
                        <li><a class="ajax-disable" href="/account/group"><span
                                class="glyphicons glyphicons-keys"></span> 添加/删除成员 </a></li>
                        <li class="divider"></li>
                    </ul>
                </li>

            </ul>
        </div>
    </aside>  <!-- Start: Content -->

    <%--<?php echo $this->getContent(); ?>--%>
    <section id="content_wrapper">
        <div id="topbar">
            <div class="topbar-left">
                <ol class="breadcrumb">
                    <li class="crumb-active"><a href="#">人员列表</a></li>
                    <li class="crumb-icon"><a href="/"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li class="crumb-link"><a href="/">首页</a></li>
                </ol>
            </div>
        </div>
        <div id="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading"><span class="panel-title"> <span
                                class="glyphicons glyphicons-keys"></span> 人员列表 </span></div>
                        <div class="panel-body">
                            <table class="table table-hover">
                                <thead>
                                <th style="width:1%" nowrap=""></th>
                                <th style="width:1%" nowrap="">ID</th>
                                <th style="width:1%" nowrap="">呢称</th>
                                <th style="text-align: left;width:1%" nowrap="">Email</th>
                                <th style="width:1%" nowrap="">分组</th>
                                <th style="width:1%" nowrap="">角色</th>
                                <%--<th style="width:1%" nowrap="">审批项目管理员账号</th>--%>
                                <th style="width:1%" nowrap="">创建时间</th>
                                <th style="width:1%" nowrap="">操作</th>
                                </thead>

                                <tbody>
                                <%
                                    List<User> userList = (List<User>) request.getAttribute("users");
                                    List<Group> groupList = (List<Group>) request.getAttribute("groups");
                                    List<Role> roleList = (List<Role>) request.getAttribute("roles");
                                    if (userList != null) {
                                        for (int i = 0; i < userList.size(); i++) {
                                            User userItem = userList.get(i);

                                %>

                                <tr>
                                    <td nowrap="" class="small"><%= i + 1%><img src="" width="50"/></td>
                                    <td nowrap="" class="small"><%= userItem.getId() %><img src="" width="50"/></td>
                                    <td class="small"><%= userItem.getUsername() %>
                                    </td>
                                    <td class="small"><%= userItem.getEamil()%>
                                    </td>
                                    <td nowrap="">
                                        <select class="multiselect" id="group_<%= userItem.getId()%>">
                                            <%if (userItem.getGroupId()==0) {%> <option value='0' selected="selected"> 没有加入小组 </option>  <%}%>
                                        <% if (groupList != null) {
                                            for (int j = 0; j < groupList.size(); j++) {
                                                Group groupItem = groupList.get(j); %>
                                        <option value="<%= groupItem.getId()%>" <% if (userItem.getGroupId() == groupItem.getId()) {%> selected="selected" <%}%> ><%= groupItem.getGroup() %></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select></td>
                                    <td nowrap>
                                        <select class="multiselect" id="role_<%= userItem.getId()%>">
                                            <% if (roleList != null) {
                                                for (int j = 0; j < roleList.size(); j++) {
                                                    Role roleTtem = roleList.get(j); %>

                                            <option value="<%= roleTtem.getId()%>" <% if (userItem.getRoleId() == roleTtem.getId()) {%>
                                                    selected="selected" <%}%> ><%= roleTtem.getRole() %>
                                            </option>

                                            <%
                                                    }
                                                }
                                            %>
                                        </select>
                                    </td>

                                    <td nowrap class="small"><%= userItem.getCreateAt()%>
                                    </td>
                                    <td nowrap>
                                        <button type="button" class="btn btn-default btn-xs editBtn"
                                                data-id="<%= userItem.getId()%>">编辑
                                        </button>
                                        <button type="button" class="btn btn-default btn-xs deleteBtn"
                                                data-id="<%= userItem.getId()%>">删除
                                        </button>
                                    </td>
                                </tr>

                                <%
                                        }
                                    }
                                %>

                                </tbody>
                            </table>

                            <div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>


</div>
<!-- End #Main -->
<!-- jQuery -->
<script src="/resources/jquery/jquery-3.2.1.js"></script>
<script src="/resources/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="/resources/bootstrap-3.3.7/js/bootstrap.js"></script>


<!-- Page Plugins -->
<script src="/resources/js/main.js"></script>


<script type="text/javascript">
    jQuery(document).ready(function () {

        $('.editBtn').click(function () {

                $('.btn').attr('disabled','disabled');
                var id = $(this).attr("data-id");
                var groupId = $('#group_' + id).val();
                var roleId = $('#role_' + id).val();
                    if (confirm("确定编辑人员")){
                        $.ajax('/User/EditForm', {
                            data: {
                                id: id,
                                groupId: groupId,
                                roleId: roleId
                            },
                            type: 'post',
                            datype: 'JSON',
                            success: function (data) {
                                if (data.code == 0) {
                                    alert("编辑成功")
                                    location.replace("/User/List")
                                } else {
                                    alert("编辑失败")
                                }
                            },
                            error: function () {

                            }

                        })
                    }

            })



    $('.deleteBtn').click(function () {

        var id = $(this).attr("data-id");

        $.ajax('/User/DeleteForm', {
            data: {
                id: id,
            },
            type: 'post',
            datype: 'json',
            success: function (data) {
                if (data.code == 0) {

                    location.replace("/User/List")
                } else {
                    alert("删除失败")
                }
            },
            error: function () {
                alert("删除失败")
            }

        });
    });
    Core.init();
    });
</script>

</body>

</html>