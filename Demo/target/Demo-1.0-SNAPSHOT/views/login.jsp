<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/library/taglib.jsp"%>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<div id="logreg-forms">
    <c:if test="${not empty message}">
        <div class="alert alert-${alert}">
                ${message}
        </div>
    </c:if>
    <form class="form-signin" action="login" method="post">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
        <div class="social-login">
            <button class="btn facebook-btn social-btn" type="button"><span><i class="fab fa-facebook-f"></i> Sign in with Facebook</span> </button>
            <button class="btn google-btn social-btn" type="button"><span><i class="fab fa-google-plus-g"></i> Sign in with Google+</span> </button>
        </div>
        <p style="text-align:center"> OR  </p>
        <input type="text" id="username" class="form-control" placeholder="Nhập tài khoản" required="" name="userName">
        <input type="password" id="password" class="form-control" placeholder="Password" required="" name="password">
        <input type="hidden" value="login" name="action">
        <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>

          </form>
</div>
<p style="text-align:center">
    <a href="http://bit.ly/2RjWFMfunction toggleResetPswd(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle() // display:block or none
    $('#logreg-forms .form-reset').toggle() // display:block or none
}

function toggleSignUp(e){
    e.preventDefault();
    $('#logreg-forms .form-signin').toggle(); // display:block or none
    $('#logreg-forms .form-signup').toggle(); // display:block or none
}

$(()=>{
    // Login Register Form
    $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
    $('#logreg-forms #cancel_reset').click(toggleResetPswd);
    $('#logreg-forms #btn-signup').click(toggleSignUp);
    $('#logreg-forms #cancel_signup').click(toggleSignUp);
})g" target="_blank" style="color:black">By Artin</a>
</p>
</body>
</html>
