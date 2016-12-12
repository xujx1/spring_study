<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>User Application</title>
</head>
<body>
<h1>User Webflow Start</h1>
<table border=5"">

    <tr>
        <th>userName</th>
        <th></th>
    </tr>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userName}</td>
            <td><a href="${flowExecutionUrl}&_eventId=addUser&userName=${user.userName}">ADD</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>