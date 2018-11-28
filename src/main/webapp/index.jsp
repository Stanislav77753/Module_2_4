<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>database of developers</title>
</head>
<body>
<h2>Hello! You are in database of developers</h2>
<div>
    <form action="skills" method="GET">
        <input type="submit"  name="showSkills" value="Show all skills">
        <input type="submit"  name="addSkill" value="Add skill">
        <input type="submit"  name="deleteSkill" value="Delete skill">
    </form>
    <form action="developers" method="GET">
        <input type="submit"  name="showDevelopers" value="Show all developers">
        <input type="submit"  name="addDeveloper" value="Add developer">
        <input type="submit"  name="deleteDeveloper" value="Delete developer">
    </form>
</div>
</body>
</html>
