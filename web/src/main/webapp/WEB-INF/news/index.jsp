<%--
  Created by IntelliJ IDEA.
  User: Ника
  Date: 12.10.2017
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="internationalization.Dictionary"
         import="Model.*"
%>
<%@taglib uri="/WEB-INF/tags.tld" prefix="mytag"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Новые рецепты</title>
</head>

<body style="width: 1000px;">
<header style="min-height: 30px; background-color: aqua;"><h1>
    COOK TOGETHER
</h1></header>
<aside style="float: left; width: 300px; background-color: red; min-height: 200px;">
<a href="/news">    <p><mytag:getword>new</mytag:getword>&nbsp;<mytag:getword>recipes</mytag:getword></p></a>
    <a href="/myRecepices">   <p><mytag:getword>my</mytag:getword>&nbsp;<mytag:getword>recipes</mytag:getword></p></a>
    <a href="/myRecepices">   <mytag:getword>add</mytag:getword>&nbsp;<mytag:getword>recipe</mytag:getword></a>
    <a href="/myRecepices"><p><mytag:getword>favorite</mytag:getword></p></a>
    <a href="/logout"><p><mytag:getword>logout</mytag:getword></p></a>

</aside>
<section style="float: right; width: 700px; background-color: blue; min-height: 500px;">
    <article class="recipe-box" style="background-color: blueviolet; width: 300px; margin: 0 auto;">


    <c:forEach var="recipe" items="${recipeList}">
        <img style="display:block; width: 300px; height: 300px;" src=("drink.gif") alt=${(recipe.getType()).getValue()}>
        <p><mytag:getword>author</mytag:getword>: <a href=""> ${(recipe.getUser()).getFullName()}</a></p>
       <%-- <p><mytag:getword>ingredients</mytag:getword> <a href=""></a></p>--%>
        <p><mytag:getword>date</mytag:getword>
        <p><mytag:getword>dishType</mytag:getword> <a href="">${(recipe.getType()).getValue()}</a></p>
        </article>
    </c:forEach>

    <article class="recipe-box" style="background-color: blueviolet; width: 300px; margin: 0 auto;">
        <img style="display:block; width: 300px; height: 300px;" src="../../../resources/pictures/drink.gif" alt="">
        <p>Автор: <a href=""></a></p>
        <p>Ингридиенты: <a href=""></a></p>
        <p>Дата: <a href=""></a></p>
        <p>Категория: <a href=""></a></p>
    </article>
</section>
<footer style="min-height: 30px; background-color: aqua; clear: both;">

    <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="/news?page=${currentPage - 1}">Previous</a></td>
    </c:if>
        <c:if test="${currentPage lt noOfPages}">
            <td><a href="/news?page=${currentPage + 1}">Next</a></td>
        </c:if>


    <%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
    <%-- Pagination was taken from https://stackoverflow.com/questions/31410007/how-to-do-pagination-in-jsp --%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/news?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
        <%--For displaying Next link --%>


</footer>
</body>
</html>
