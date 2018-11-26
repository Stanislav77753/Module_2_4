<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>skills</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h2>----------------------SKILLS------------------------</h2>
<c:forEach items="${skills}" var="skill">
    <tr>
        <td>${skill.id}</td>
        <td>${skill.skillName}</td>
    </tr>
</c:forEach>
<ul>
    <c:if test="${!empty skills}">
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Skill</th>

            </tr>
            <c:forEach items="${skills}" var="skill">
                <tr>
                    <td>${skill.id}</td>
                    <td>${skill.skillName}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</ul>

</body>
</html>
