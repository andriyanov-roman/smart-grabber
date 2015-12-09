<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw==" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Architects+Daughter' rel='stylesheet' type='text/css'>
    <style>
        .site-header,
        .site-footer{
            display: block;
            width: 100%;
            min-height: 100px;
            background-color: #000;
            overflow: hidden;
        }
        .logo {
            display: block;
            float: left;
        }
        .content {
            display: block;
            min-height:200px;
            text-align: center;
        }
        .container {
            width: 100%;
            max-width:960px;
            margin: 0 auto;
        }
        .site-footer {
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            text-align: center;
            color: #fff;
        }
        h1 {
            text-transform: uppercase;
            font-family: 'Architects Daughter', cursive;
            color: #fff;
            padding: 1em 0;
        }
        .copy {
            position: absolute;
            top:49%;
            left: 45%;
        }
        .btn-app {
            color: #fff;
            background-color: #D4001A;
            border-color: #D4001A;
        }
    </style>
</head>
<body>
<header class="site-header">
    <div class="container">
        <a href="/" title="home" class="logo">
            <img src="http://sherly.mobile9.com/download/media/210/javaevil_qao3enxd.png" alt="Logo" width="50%">
        </a>
        <h1>Club of anonymous developers</h1>
    </div>
</header>
<div class="content container">
    <h2>Try login to our <a href="/main" class="btn btn-warning btn-app btn-lg" >Application </a> ;)</h2>
</div>
<footer class="site-footer">
    <div class="container">
        <p class="copy">Copyright &copy; 2015 <b>Daemon</b></p>
    </div>
</footer>
</body>
</html>
