<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <script type="text/javascript" src="static/js/jquery-3.1.1.min.js"></script>
    <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript"  src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:forward page="/emp/getEmpList"></jsp:forward>
</body>
</html>