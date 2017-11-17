<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FreeHTML5.co"/>
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive"/>


    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content=""/>
    <meta name="twitter:image" content=""/>
    <meta name="twitter:url" content=""/>
    <meta name="twitter:card" content=""/>

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="/resources/favicon.ico">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>


    <link rel="stylesheet" type="text/css" href="/resources/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/resources/Animate/animate.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">


</head>
<body class="style-2">

<div class="container">
    <div class="row">
        <div class="col-md-12 text-center">
            <ul class="menu">
                <li class="notice"></li>

            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4">


            <!-- Start login Form -->
            <form action="javascript:void(null);" class="fh5co-form animate-box" data-animate-effect="fadeInLeft" id="form-signin">
                <h2>Login</h2>
                <div class="form-group">
                    <div class="form-notice">
                        <!--<div class="alert alert-success" role="alert">Your info has been saved.</div>-->
                        <!--<div class="alert alert-info" role="alert">Your info has been saved.</div>-->
                        <!--<div class="alert alert-warning" role="alert">Your info has been saved.</div>-->
                        <!--<div class="alert alert-danger" role="alert">Your info has been saved.</div>-->
                    </div>
                </div>
                <div class="form-group">
                    <label for="username" class="sr-only">User Name</label>
                    <input type="text" class="form-control" id="username" placeholder="username" autocomplete="off" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" autocomplete="off" name="password" required>
                </div>
                <div class="form-group">
                    <label for="remember"><input type="checkbox" id="remember"> Remember Me</label>
                </div>

                <div class="form-group">
                    <p>Not registered? <a href="/Passport/register">Register</a> | <a href="#">Forgot Password?</a></p>
                </div>

                <div class="form-group">
                    <input type="submit" value="LOGIN" class="btn btn-primary">
                </div>
            </form>
            <!-- END Sign In Form -->



        </div>
    </div>
    <div class="row" style="padding-top: 60px; clear: both;">
        <div class="col-md-12 text-center">
            <p>
                <a href="https://gitee.com/GuangZongYaoZu/GroupManage"><small>&copy; 光宗耀组</small></a>
            </p>
        </div>
    </div>
</div>

</body>
</html>

<script src="/resources/jquery/jquery-3.2.1.js"></script>
<script src="/resources/plugins/backstretch/jquery.backstretch.min.js"></script>
<script>
    $(function () {
        $.backstretch("https://signposs1.oss-cn-shenzhen.aliyuncs.com/client/img/stock/splash/2.jpg");
        var fromSignin = $('#form-signin');
        var check = true;
        var username;

        $('#username').blur(function () {
            username = $.trim($('#username').val());
            if (username.length > 0) {
                $.ajax('/passport/checkUser', {
                    data: {
                        username: username,
                    },
                    type: 'post',
                    dataType: 'json',
                    success: function (data) {
                        if (data.code == 102 || data.data == null) {
                            $('.form-notice').html('<div class="alert alert-danger" role="alert">没有该用户</div>');
                            check = false;
                        }  else {
                            $('.form-notice').html('');
                            check = true;
                        }
                    },
                    error: function () {
                    }
                });
            }
        });

        fromSignin.submit(function (event) {
            username = $.trim($('#username').val());
            var password = $.trim($('#password').val());
            if (check) {
                $.ajax('/passport/login', {
                    data: {
                        username: username,
                        password: password,
                    },
                    type: 'post',
                    dataType: 'json',
                    success: function (data) {
                        if (data.code == 0) {
                            $('.form-notice').html('<div class="alert alert-success" role="alert">登录成功.</div>');
                            location.replace('/');
                        }else {
                            $('.form-notice').html('<div class="alert alert-danger" role="alert">登录失败.</div>');
                        }
                    },
                    error: function () {
                        $('.form-notice').html('<div class="alert alert-danger" role="alert">登录失败.</div>');
                    }
                });
            }

        });

    })
</script>
