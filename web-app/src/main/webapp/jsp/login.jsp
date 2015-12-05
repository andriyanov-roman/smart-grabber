<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-7s5uDGW3AHqw6xtJmNNtr+OBRJUlgkNJEo78P4b0yRw= sha512-nNo+yCHEyn0smMxSswnf/OnX6/KwJuZTlNZBjauKhTK0c+zT+q5JOCx0UFhXQ6rJR9jg6Es8gPuD2uZcYDLqSw==" crossorigin="anonymous">
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
        .site-header,
        .site-footer {
            display: block;
            width: 100%;
            height: 100px;
        }
        .site-header{
            background: linear-gradient(to top, #b4ddb4 0%,#83c783 17%,#52b152 33%,#008a00 67%,#005700 83%,#002400 100%);
        }
        .site-footer {
            position: absolute;
            bottom: 0;
            left: 0;
            right: 0;
            text-align: center;
            color: #ffffff;
            line-height:100px;
            background: linear-gradient(to bottom, #b4ddb4 0%,#83c783 17%,#52b152 33%,#008a00 67%,#005700 83%,#002400 100%);
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
    </style>
</head>

<body>
<header class="site-header">
    <h1>Login Page</h1>
</header>
<div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width:100%;height:20px;;"><span class="sr-only">45% Complete</span></div>
<div class="wrapper row">
        <div class="glyphicon glyphicon-lock lock"></div>
        <form class="form-horizontal" action="/main" method="POST">
            <input type="hidden" name="controller_type" value="user_controller">
            <div class="form-group">
                <label for="inputName3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-10">
                    <input type="text" name="user_name" class="form-control" id="inputName3" placeholder="Username" value="admin">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <input type="password" name="password"  class="form-control" id="inputPassword3" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Remember me
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Sign in</button>
                </div>
            </div>
        </form>
</div>
<footer class="site-footer">
    Copyright &copy; 2015 <b>Daemon</b>
</footer>

</body>
</html>