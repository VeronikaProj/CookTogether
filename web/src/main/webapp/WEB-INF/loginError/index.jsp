<%--
  Created by IntelliJ IDEA.
  User: Ника
  Date: 28.03.2017
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/WEB-INF/tags.tld" prefix="mytag"%>
<html>
<head>
    <title>LoginError</title>
</head>
<body>
<header style="min-height: 30px; background-color: aqua;">CookTogether</header>
<mytag:getword>accessDenied</mytag:getword>
<a href="/"><mytag:getword>comeIn</mytag:getword></a>
<mytag:getword>or</mytag:getword>
<a href="/signup"><mytag:getword>signUp</mytag:getword></a>

<footer style="min-height: 30px; background-color: aqua;"><a href="/"><mytag:getword>changeLanguage</mytag:getword></a>
</footer>
</body>
</html>
