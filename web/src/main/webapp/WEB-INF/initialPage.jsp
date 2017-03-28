<%--
  Created by IntelliJ IDEA.
  User: Ника
  Date: 27.03.2017
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    import="internationalization.ResourceProperty"%>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:useBean id="resourceProp" type="internationalization.ResourceProperty" scope="request"/>
<h1>
    Регистрация
</h1>
<form action="/login" method="post">


    <fieldset>
        <label for="email" >${resourceProp.getValue("email")}</label><br />
        <input type="email" name="email"  required/><br /><br />

        <label for="password" >${resourceProp.getValue("email")}</label><br />
        <input  name="password" required  /><br /><br />



        <button type="submit">Зарегестрироваться</button>

        <!--<input type="file" id="fileinput" multiple="multiple" accept="image/*" />-->

    </fieldset>

</form>

<a href="signupEn.html">Switch to English</a>


</body>
</html>
