<%--
  Created by IntelliJ IDEA.
  User: zxq
  Date: 2022/5/20
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv">
    <h1 style="color: red">${msg}</h1>
    <form action="/login" method="post" id="form">
        <h1 id="loginMsg">LOGIN IN</h1>
        <p>Username:<input id="username" name="username" type="text"></p>

        <p>Password:<input id="password" name="password" type="password" value="${cookie.mm.value}"></p>
        <br>
        <input type="checkbox" name="r" value="ok"   ${cookie.mz.value != null?'checked':''}  >记住我1小时
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.html">没有账号？点击注册</a>
        </div>
    </form>
</div>

<script>
    // ${cookie.mz.value}  除了 mz是我们在servlet中创建cookie对象的时候,起的名字,剩下的都是固定的!!!
    let v=decodeURI('${cookie.mz.value}');
    //alert(v);
    document.getElementById("username").value=v;
</script>
</body>
</html>
