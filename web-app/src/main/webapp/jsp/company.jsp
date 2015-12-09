<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw==" crossorigin="anonymous">
    <style>
        html,
        body {
            margin: 0;
            padding: 0;
        }
        html {
            margin-top:-21px;
        }
        h1 {
            color: #ffffff;
            padding: .5em 0 0 2em;
            font-family: Helvetica,Arial,sans-serif;
            text-shadow: 1px 1px 1px #000;
            text-transform: uppercase;
            font-weight: bold;
        }
        h2{
            width: 30px;
            margin: 0 auto;
            margin-top: 2em;
        }
        .site-header,
        .site-footer {
            display: block;
            width: 100%;
            height: 100px;
            background: linear-gradient(to bottom, rgba(30,87,153,1) 0%,rgba(41,137,216,1) 50%,
            rgba(32,124,202,1) 51%,rgba(125,185,232,1) 100%);
        }
        .site-footer {
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            text-align: center;
            color: #ffffff;
            line-height:100px;
        }
        .wrapper {
            display: table;
            width: 100%;
            max-width: 1024px;
            min-height: 300px;
            margin: 0 auto;
            padding-top:2em;
        }
        form {
            display: table-cell;
            width: 460px;
            height: auto;
            margin: 2em auto;
            text-align: left;
        }
        .lock {
            display: table-cell;
            width: 128px;
            height: 128px;
            font-size:128px;
        }
        .glyphicon-home {
            display: block;
            float: left;
            width: 64px;
            height: 64px;
            font-size: 64px;
            color: #fff;
            margin: 5px 1em 0;
            text-shadow: -1px 1px 12px #000;
        }
        a.glyphicon-home:hover {
            color: #ccc;
            text-decoration: none;
        }
    </style>
</head>

<body>
<header class="site-header">
    <a href="/" title="GO HOME" class="glyphicon glyphicon-home"></a>
    <h1>Add Employee Page</h1>
</header>
<div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0"
     aria-valuemax="100" style="width:100%;height:20px;;"><span class="sr-only">45% Complete</span></div>
<h2>$Company$</h2>
<div class="wrapper row">
    <div class="glyphicon glyphicon-user lock"></div>
    <form class="form-horizontal" action="/" method="post">
        <div class="form-group">
            <label for="inputEmployeeName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmployeeName" placeholder="Name of Employe">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-info">Add Employee</button>
            </div>
        </div>
    </form>
</div>
<footer class="site-footer">
    Copyright &copy; 2015 <b>Daemon</b>
</footer>

</body>
</html>