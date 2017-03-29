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


<jsp:useBean id="dictionary" type="internationalization.Dictionary" scope="application"/>
<jsp:useBean id="language" type="java.lang.String" scope="session"/>
<h1>
    Регистрация
</h1>
<form action="/login" method="post">


    <fieldset>
        <mytag:getword>email</mytag:getword>
        ${dictionary.getValue(lang,"recipe")}
        <%--<label for="email" >${dictionary.getValue("en","email")}</label><br />--%>
        <%--<input type="email" name="email"  required/><br /><br />--%>

        <%--<label for="password" >${resourceProp.getValue("password")}</label><br />--%>
        <%--<input  name="password" required  /><br /><br />--%>



        <%--<button type="submit">Зарегестрироваться</button>--%>

        <!--<input type="file" id="fileinput" multiple="multiple" accept="image/*" />-->

    </fieldset>

</form>

<a href="signupEn.html">Switch to English</a>


</body>
</html>
