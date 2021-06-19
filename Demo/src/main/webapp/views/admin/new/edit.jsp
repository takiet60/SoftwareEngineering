<%@include file="/library/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="APIurl" value="/admin-add-lesson" />
<c:url var="NewURL" value="/admin-new"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                   <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul>
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}">
                            ${message}
                        </div>
                    </c:if>
                    <form id="formSubmit">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-9">
                                <div class="form-group">
                                    <select class="form-control" id="categoryCode" name="categoryCode">
                                        <c:if test="${empty model.categoryCode}">
                                            <option value="">Chọn chủ đề</option>
                                            <c:forEach var="item" items="${categories}">
                                                <option value="${item.code}">${item.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.categoryCode}">
                                            <c:forEach var="item" items="${categories}">
                                                <c:if test="${item.code == model.categoryCode}">

                                                </c:if>
                                                selected="selected"
                                                <option value="${item.code}" name="categoryCode"<c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>
                                                >
                                                        ${item.name}</option>
                                            </c:forEach>
                                            <option value="">Chọn chủ đề</option>
                                        </c:if>

                                    </select>
                                </div>
                            </div>
                        </div>
                        <br />
                        <br />
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Hình ảnh</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="image" name="image" value="${model.title}" />
                            </div>
                        </div>
                        <br />
                        <br />
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Âm thanh</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="sound" name="sound" value="${model.title}" />
                            </div>
                        </div>
                        <br />
                        <br />


                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-9">
                                <textarea rows="" cols="" style="width: 820px; height: 175px" id="content" name="content">${model.content}</textarea>
                            </div>
                        </div>
                        <br />
                        <br />
                        <div class="form-group">
                            <div class="col-sm-12">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới bài viết" id="btnAddOrUpdateNew">
                            </div>
                        </div>
                        <input type="hidden" value="${model.id}" id="id" name="id"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    let editor = '';
    $(document).ready(function (){
        editor = CKEDITOR.replace('content')
    })

    $('#btnAddOrUpdateNew').click(function(e){
        e.preventDefault();
        let data = {};
        let formData = $('#formSubmit').serializeArray();
        $.each(formData, function(v, v){
            data["" + v.name +""] = v.value;
        });
        data['content'] = editor.getData();
        addNew(data)
    });
    function addNew(data){
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result){
                window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1";
            },
            error: function (error){
                console.log(error)
            }
        });
    }

    function updateNew(data){
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result){
                console.log(result)
            },
            error: function (error){
                console.log(error)
            }
        });
    }
</script>
</body>
</html>
