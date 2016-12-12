<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>
<form action="/hello/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/> <input type="submit" value="Submit"/>
</form>

</body>
</html>
