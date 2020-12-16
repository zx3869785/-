<%--
  Created by IntelliJ IDEA.
  User: 79281
  Date: 2020/12/4
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增员工信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/empsave" method="post">
        <table>
            <tr>
                <td>员工编号</td>
                <td><input type="text" name="empno" value="8764"></td>
            </tr>
            <tr>
                <td>员工姓名</td>
                <td><input type="text" name="ename" value="老王头"></td>
            </tr>
            <tr>
                <td>入职日期</td>
                <td><input type="date" name="hiredate" value="2021-09-25"></td>
            </tr>
            <tr>
                <td>薪资</td>
                <td><input type="text" name="sal" value="5200"></td>
            </tr>
            <tr>
                <td><input type="submit"value="新增"></td>
                <td><input type="reset" value="重置" ></td>
            </tr>
        </table>
    </form>
</body>
</html>
