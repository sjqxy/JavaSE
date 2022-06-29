<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h1 style="color: #5a88c8">欢迎你:${user.username}</h1>

<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/findBrandById?id=${brand.id}">修改</a> <a href="JavaScript:queRen('${brand.id}','${brand.brandName}')">删除</a></td>
        </tr>

    </c:forEach>

</table>

<script>
    document.getElementById("add").onclick = function (){
        // 带/ 表示从webapp下直接找addBrand.jsp,如果不带/ 表示从当前brand.jsp页面的文件夹中相对路径找addBrand.jsp
        location.href = "/addBrand.jsp";
    }
    function queRen(id,n){
        let f=confirm("亲,确定要删除 "+n+" 吗?");
        if(f){
            location.href ="/delById?id="+id;
        }
    }

</script>
</body>
</html>