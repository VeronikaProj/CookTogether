<%--
  Created by IntelliJ IDEA.
  User: Ника
  Date: 27.03.2017
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>
    Регистрация
</h1>
<form action="/SessionController" method="post">


    <fieldset>
        <label for="first_name" >Имя</label><br />
        <input  name="firstName"  required/><br /><br />

        <label for="first_name" >Фамилия</label><br />
        <input  name="lastName" required  /><br /><br />

        <label for="gender" >Пол</label><br />
        <input type="radio" name="is_fem" value="true"> женский<Br>
        <input type="radio" name="is_fem" value="opera"> мужской<Br> <br />



        <label for="password"> Дата рождения </label>
        <br /> <input  type="date" name="password"   required /><br /><br />

        <label for="password">Пароль(не менее 6 символов) </label>
        <br /> <input  name="password"  pattern=".{6,20}" required /><br /><br />

        <label for="email">email</label><br />
        <input type="email" name="email" required /><br /><br />



        <button type="submit">Зарегестрироваться</button>

        <!--<input type="file" id="fileinput" multiple="multiple" accept="image/*" />-->

    </fieldset>

</form>

<a href="signupEn.html">Switch to English</a>


</body>
</html>
