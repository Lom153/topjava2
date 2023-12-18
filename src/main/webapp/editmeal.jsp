<%--
  Created by IntelliJ IDEA.
  User: SVCH
  Date: 14.12.2023
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Edit Meal</title>
</head>
<body>
<ul>
    <li>Довести воду до кипения</li>
    <li>Засыпать ингредиенты</li>
    <li>Варить 10 минут</li>
</ul>
<dl>
    <dt>Гаспачо</dt><dd>лёгкий холодный суп из перетёртых в пюре свежих овощей</dd>
    <dt>Том-ям</dt><dd>кисло-острый суп на основе куриного бульона с креветками, курицей, рыбой или другими морепродуктами</dd>
    <dt>Борщ</dt><dd>разновидность супа на основе свёклы, которая придаёт борщу характерный красный цвет</dd>
</dl>

<form method="POST" action='meals' name="editMealForm">
    id : <input type="text" readonly="readonly" name="id"
                value="${meal.getId()}" /> <br />
    DateTime : <input
        type="datetime-local" name="datetime"
        value="${meal.getDateTime()}" /> <br />
    Description : <input
        type="text" name="description"
        value="${meal.getDescription()}"/> <br />
    Calories : <input
        type="text" name="calories"
        value="<c:out value="${meal.getCalories()}" />" /> <br />

    File : <input
        type="file" name="file"
        value="<c:out value="${meal.getCalories()}" />" /> <br />

    <input type="reset">

 <input type="submit" value="Submit" />
</form>
</body>
</html>
