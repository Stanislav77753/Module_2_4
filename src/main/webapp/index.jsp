<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>database of developers</title>
</head>
<body>
<h2>Hello! You are in database of developers</h2>
<div>
    <form action="skills" method="POST">
        <input type="submit"  name="showSkills" value="Show all skills">
    </form>
    <a href="<c:url value="/skills"/>" target="_blank">add skill</a>
</div>
</body>
</html>
