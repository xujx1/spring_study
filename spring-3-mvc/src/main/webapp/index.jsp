<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%--关键，引入操作的对象--%>
<jsp:useBean id="user" class="com.pojo.User" scope="request"/>
<html>
<body>
<h2>Hello World!</h2>
SpringMvc JSP视图解析器 测试
<sf:form method="post" action="/hello/user" commandName="user">

    <table>
        <tr>
            <td><sf:label path="userName">userName</sf:label></td>
            <td><sf:input path="userName"/></td>
        </tr>
        <tr>
            <td><sf:label path="age">Age</sf:label></td>
            <td><sf:input path="age"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</sf:form>

</body>
</html>
