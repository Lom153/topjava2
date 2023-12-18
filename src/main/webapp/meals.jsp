<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<jsp:useBean id="mealеto" class="ru.javawebinar.topjava.model.MealTo" />--%>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>


<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<style>
    TABLE {
        /*width: 300px;*/
        border-collapse: collapse;
        margin-left: auto;
        margin-right: auto;
    }
    TD, TH {
        padding: 3px;
        border: 1px solid black;
    }
    TH {
        background: #b0e0e6;
        color: blue;
    }
    .isExcess {
        color: red;
    }
    .isNotExcess {
        color: green;
    }
</style>
<table>
    <th>Дата, время</th>
    <th>Описание</th>
    <th>Калории</th>
    <th colspan="2">Action</th>
    <c:forEach var = "meal" items="${meals}">

        <c:if test = "${meal.isExcess() == true}"><tr class="isExcess"></c:if>
        <c:if test = "${meal.isExcess() != true}"><tr class="isNotExcess"></c:if>
            <%--    <p>${meal.isExcess()}</p>--%>
        <td>
            <fmt:parseDate value="${meal.getDateTime()}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
            <fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${parsedDateTime}" />
        </span>
        </td>
        <td>${meal.getDescription()}</td>
        <td>${meal.getCalories()}</td>
        <td><a href="meals?action=edit&id=${meal.getId()}">edit</a></td>
        <td><a href="meals?action=delete&id=${meal.getId()}">delete</a></td>
    </tr>
    </c:forEach>


</table>
</style>
</body>
</html>