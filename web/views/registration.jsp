<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 30.11.2020
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <form method="post">
        <label>Логин:
            <input type="text" name="name"><br />
        </label>

        <label>Пароль:
            <input type="password" name="password1"><br />
        </label>

        <label>Повторите пароль:
            <input type="password" name="password2"><br />
        </label>

        <button type="submit">Подтвердить</button>
    </form>
</body>
</html>
