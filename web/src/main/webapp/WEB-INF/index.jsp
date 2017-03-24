<%--
  Created by IntelliJ IDEA.
  User: Ника
  Date: 23.03.2017
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="Controllers.InitPageController,
                 Model.Recipe,
                 java.util.Collection" %>
<html>
<head>
    <title>${requestScope.get(WelcomeController.WELCOME_KEY)} Welcome to CookTogether!</title>
</head>
<body>

<%
    Collection<Recipe> recipes = (Collection<Recipe>) request.getAttribute(InitPageController.ALL_RECIPES_KEY);
%>

Лцчшие рецепты:
<table>
    <tr>
        <th>Название</th>

        <th>Добавлено</th>
        <th>Категория</th>
    </tr>
    <%
        for (Recipe recipe : recipes) {
    %>
    <tr>
        <td><%=recipe.getName()%></td>

        <td><%=recipe.getUser().getFirstName()%></td>
        <td><%=recipe.getType()%></td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
