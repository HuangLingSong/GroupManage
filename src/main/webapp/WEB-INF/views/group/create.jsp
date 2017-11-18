<%@ page import="com.glory.entity.User" %>
<%@ page import="com.glory.entity.Group" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="/WEB-INF/views/public.jsp"%>

    <section id="content_wrapper">
        <div id="topbar">
            <div class="topbar-left">
                <ol class="breadcrumb">
                    <li class="crumb-active"><a href="#">创建小组</a></li>
                    <li class="crumb-icon"><a href="/"><span class="glyphicon glyphicon-home"></span></a></li>
                    <li class="crumb-link"><a href="/">首页</a></li>
                    <%--<li class="crumb-trail">创建小组</li>--%>
                </ol>
            </div>
        </div>
        <div id="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="panel">
                        <div class="panel-heading"><span class="panel-title"> <span class="glyphicon glyphicon-file"></span> 创建小组</span>
                        </div>
                        <div class="panel-body">
                            <form class="cmxform" id="altForm">
                                <div class="form-group">
                                    <label class="control-label">要编辑的分组</label>
                                    <select class="form-control" id="editDepart">
                                        <option value=""></option>
                                        <%
                                            List<Group> groupList = (List<Group>) request.getAttribute("groups");
                                            if (groupList != null) {
                                                for (int i = 0; i < groupList.size(); i++) {
                                                    Group groupItem = groupList.get(i);
                                        %>
                                        <option value="<%= groupItem.getId()%>"><%= groupItem.getGroup()%></option>
                                       <% }}%>

                                    </select>

                                </div>
                                <div class="alert alert-danger">不选择编辑的分组则为添加分组!</div>
                                <div class="form-group">
                                    <label class="control-label">小组名称</label>
                                    <input id="name" name="name" type="text" class="form-control" autocomplete="off"
                                           required="">
                                </div>
                                <div class="form-group">
                                    <label class="control-label">组长</label>
                                    <input id="role" name="role" type="text" class="form-control" autocomplete="off"
                                           required="">
                                </div>
                                <div class="form-group">
                                    <input class="submit btn bg-purple pull-right" type="submit" id="subBtn" value="Submit">
                                </div>
                            </form>
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

        Core.init();



    });
</script>

</body>

</html>