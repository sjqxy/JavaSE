<%--
  Created by IntelliJ IDEA.
  User: zxq
  Date: 2022/5/19
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${u!=null}">
        <div style="color: aqua;font-size: 35px">
            欢迎您: ${u}
        </div>
    </c:if>
    <c:if test="${u==null}">
        <div style="color: aqua;font-size: 35px">
            您还没有登录,点击<a href="http://www.itheima.com">登录</a>
        </div>
    </c:if>
<hr>
${st==1?'启用':'禁用'}
<hr>

<h1>以下代码使用foreach遍历集合的内容展示的</h1>
<hr>

<c:forEach items="${li}" var="e" varStatus="st">
    当前是第${st.count}次循环,是否是第1次:${st.first},是否是最后1次:${st.last},
    得到的元素是:${e};<br>
</c:forEach>

</body>
</html>
