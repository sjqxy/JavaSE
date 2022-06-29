<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改品牌</title>
</head>
<body>
<h3>修改品牌</h3>
<form action="/update" method="post">
    <input type="hidden" name="id" value="${b.id}">
    品牌名称：<input name="brandName" value="${b.brandName}"><br>
    企业名称：<input name="companyName" value="${b.companyName}"><br>
    排序：<input name="ordered" value="${b.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name="description">
    ${b.description}
</textarea><br>
    状态：
    <input type="radio" name="status" value="0" ${b.status==0?'checked':''}>禁用
    <input type="radio" name="status" value="1" ${b.status==1?'checked':''}>启用<br>

    <input type="submit" value="提交">
</form>
</body>
</html>