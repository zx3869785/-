<%--
  Created by IntelliJ IDEA.
  User: 79281
  Date: 2020/12/4
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新员工</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/empupdate" method="post">
    <table>
        <tr>
            <td>员工编号</td>
            <td>${emp.empno}<input type="hidden" name="empno" value="${emp.empno}"></td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename" value="${emp.ename}"></td>
        </tr>
        <tr>
            <td>入职日期</td>
            <td><input type="date" name="hiredate" value="${emp.hiredate}"></td>
        </tr>
        <tr>
            <td>薪资</td>
            <td><input type="text" name="sal" value="${emp.sal}"></td>
        </tr>
        <tr>
            <td><input type="submit"value="修改"></td>
            <td><input type="reset" value="重置" ></td>
        </tr>
    </table>
</form>
</body>
</html>
