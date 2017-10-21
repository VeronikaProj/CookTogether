<%--
  Created by IntelliJ IDEA.
  User: Ника
  Date: 27.03.2017
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="internationalization.Dictionary"
         %>
<%@taglib uri="/WEB-INF/tags.tld" prefix="mytag"%>
<html>
<head>
    <title></title>
</head>
<body>


<%--<jsp:useBean id="dictionary" type="internationalization.Dictionary" scope="application"/>--%>
<%--<jsp:useBean id="language" type="java.lang.String" scope="session"/>--%>

<body style="width: 1000px;">
<header style="min-height: 30px; background-color: aqua;"><h1>
    COOK TOGETHER!
</h1></header>
<aside style="float: left; width: 300px; background-color: red; min-height: 200px;">
    <form action="/login" method="post">


        <fieldset>


            <%--<label for="email" >${dictionary.getValue("en","email")}</label><br />--%>
            <%--<input type="email" name="email"  required/><br /><br />--%>
            <label for="email" ><mytag:getword>email</mytag:getword></label><br />
            <input type="email" name="email"  required/><br /><br />
            <label for="password" ><mytag:getword>password</mytag:getword></label><br />
            <input  name="password" required  /><br /><br />


            <button type="submit"><mytag:getword>login</mytag:getword></button>

            <!--<input type="file" id="fileinput" multiple="multiple" accept="image/*" />-->

        </fieldset>

    </form>
</aside>
<section style="float: right; width: 700px; background-color: blue; min-height: 500px;">
    <article class="recipe-box" style="background-color: blueviolet; width: 300px; margin: 0 auto;">
        <img style="display:block; width: 300px; height: 300px;" src="pictures/drink.gif" alt="">
        <p><mytag:getword>author</mytag:getword> <a href=""></a></p>
        <p><mytag:getword>ingredients</mytag:getword> <a href=""></a></p>
        <p><mytag:getword>date</mytag:getword> <a href=""></a></p>
        <p><mytag:getword>dishType</mytag:getword> <a href=""></a></p>
    </article>
    <article class="recipe-box" style="background-color: blueviolet; width: 300px; margin: 0 auto;">
        <img style="display:block; width: 300px; height: 300px;" src="../../../resources/pictures/drink.gif" alt="">
        <p>Автор: <a href=""></a></p>
        <p>Ингридиенты: <a href=""></a></p>
        <p>Дата: <a href=""></a></p>
        <p>Категория: <a href=""></a></p>
    </article>
</section>
<footer style="min-height: 30px; background-color: aqua; clear: both;">
    <a href="/changeLanguage"><mytag:getword>changeLanguage</mytag:getword></a>

    </footer>





</body>
</html>
