<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta>
    <title>查询员工列表</title>
</head>
<body>

<form name="itemsForm" method="post">

员工列表：
    <table width="100%" border="1">
        <tr>
            <td>选择</td>
            <td>姓名</td>
            <td>性别</td>
            <td>邮箱</td>
            <td>部门</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${empList}" var="item">
        <tr>
            <td><input type="checkbox" name="items_id" value="${item.empId}"></td>
            <td>${item.empName}</td>
            <td>${item.gender}</td>
            <td>${item.email}</td>
            <td>${item.dept.deptName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.empId}">修改</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
