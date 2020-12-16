<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 79281
  Date: 2020/12/2
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>

    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        table{
            border: solid 1px black;
            border-radius: 5px;
            z-index: 10;
            position: relative;
            left: 200px;
            top: 0;
        }
        th{
            z-index: 20;
            padding: 5px;
            border: solid 1px black;
            width: 120px;
            height: 30px;
            text-align: center;
        }
        tr{
            border: solid 1px black;
            box-sizing: border-box;
            z-index: 20;
        }
        td{
            z-index: 20;
            padding: 5px;
            border: solid 1px black;
            width: 120px;
            height: 30px;
            text-align: center;
        }
        td:hover{
            box-shadow: 3px 3px 5px lightblue;
        }
        tr:nth-child(even){
            background-color: pink;
        }
        a{
            color: black;
            border-radius: 3px;
        }
    </style>
</head>
<body>
<table id="empsInfo" class="striped table-hover">
	<thread>
        <th class="success">empno</th>
        <th class="success">ename</th>
        <th class="success">hiredate</th>
        <th class="success">sal</th>
        <th class="warning">operation</th>
	</thread>
    <!--jstl+el表达式解决在jsp页面里不需要写java代码-->
    <c:forEach items="${empsFromServer}" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td><a href="${pageContext.request.contextPath}/empById?empno=${emp.empno}">修改</a><a href="${pageContext.request.contextPath}/empdelete?empno=${emp.empno}" id="deleteBtn" onclick="return confirm('hellomotherfuckwasmyname')">删除</a></td>
        </tr>
    </c:forEach>
    <hr>
</table>
    <hr>
    <a href="${pageContext.request.contextPath}/newemp.jsp">新增</a>
<hr>
    <form action="${pageContext.request.contextPath}/empById" method="post">
        EMPNO:<input type="text" name="empno" placeholder="输入员工编号">
        <input type="submit" name="精确查询">
    </form>
<hr>
    <form action="${pageContext.request.contextPath}/empByName" method="post">
        ENAME:<input type="text" name="ename" placeholder="输入员工姓名">
        <input type="submit" name="模糊查询">
    </form>
<script src="https://cdn.bootcss.com/jquery/1.12.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

