<%@ page import="java.util.List" %>
<%@ page import="com.popovich.model.Skill" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>skills</title>
</head>
<body>
<h2>----------------------SKILLS------------------------</h2>
<pre>
    <%
        List<Skill> skills = (List)request.getAttribute("skills");
        if(skills != null){
            out.println("ID" + " - " + "SKILL");
            for(Skill skill : skills){
                out.println(skill.getId() + " - " + skill.getSkillName());
            }
        }
    %>
</pre>
<div>
    <core:forEach items="${skills}" var="skill">
        <tr>
            <td><core:out value="${skill.skillName}"/></td>
            <td>${skill.skillName}</td>
        </tr>
    </core:forEach>
</div>
<a href="../../index.jsp">Back to main menu</a>
</body>
</html>
