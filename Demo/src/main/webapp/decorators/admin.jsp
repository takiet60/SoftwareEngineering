<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/library/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>Dashboard - Ace Admin</title>

    <meta name="description" content="overview &amp; stats" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="<c:url value="/template/admin/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/template/admin/font-awesome/4.2.0/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/template/admin/fonts/fonts.googleapis.com.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/template/admin/css/ace.min.css"/>" class="ace-main-stylesheet" id="main-ace-style" />

    <link rel="stylesheet" href="<c:url value="/template/admin/css/ace-part2.min.css"/>" class="ace-main-stylesheet" />
    <link rel="stylesheet" href="<c:url value="/template/admin/css/ace-ie.min.css"/>" />
    <![endif]-->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>

</head>

<body class="no-skin">
<%@include file="/library/admin/header.jsp"%>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <%@include file="/library/admin/menu.jsp"%>

    <decorator:body />

    <%@include file="/library/admin/footer.jsp"%>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- ace settings handler -->
<script src="<c:url value="/template/admin/js/ace-extra.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/template/admin/js/html5shiv.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/template/admin/js/respond.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/template/paging/jquery.twbsPagination.js"/>" type="text/javascript"></script>


<script src="<c:url value="/template/admin/js/jquery.2.1.1.min.js"/>"></script>

<script src="<c:url value="/template/admin/js/jquery.1.11.1.min.js"/>"></script>

<script type="text/javascript">
    window.jQuery || document.write("<script src='<c:url value="/template/admin/js/jquery.min.js"/>'>"+"<"+"/script>");
</script>

<script type="text/javascript">
    window.jQuery || document.write("<script src='<c:url value="/template/admin/js/jquery1x.min.js"/>'>"+"<"+"/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='<c:url value="/template/admin/js/jquery.mobile.custom.min.js"/>'>"+"<"+"/script>");
</script>
<script src="<c:url value="/template/admin/js/bootstrap.min.js"/>"></script>

<script src="<c:url value="/template/admin/js/excanvas.min.js"/>"></script>
<![endif]-->
<script src="<c:url value="/template/admin/js/jquery-ui.custom.min.js"/>"></script>
<script src="<c:url value="/template/admin/js/jquery.ui.touch-punch.min.js"/>"></script>
<script src="<c:url value="/template/admin/js/jquery.easypiechart.min.js"/>"></script>
<script src="<c:url value="/template/admin/js/jquery.sparkline.min.js"/>"></script>
<%--<script src="<c:url value="/template/admin/js/jquery.flot.min.js"/>"></script>--%>
<%--<script src="<c:url value="/template/admin/js/jquery.flot.pie.min.js"/>"></script>--%>
<%--<script src="<c:url value="/template/admin/js/jquery.flot.resize.min.js"/>"></script>--%>

<!-- ace scripts -->
<script src="<c:url value="/template/admin/js/ace-elements.min.js"/>"></script>
<script src="<c:url value="/template/admin/js/ace.min.js"/>"></script>

<!-- inline scripts related to this page -->

</body>
</html>
