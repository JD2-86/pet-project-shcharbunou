<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lol Club - Регистрация</title>
    <link rel="shortcut icon" href="assets/img/sign-in.png" type="image/png">
    <link rel="stylesheet" href="css/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@700&family=Raleway:wght@600&display=swap"
          rel="stylesheet">
</head>
<body>
<header>
    <div class="logo">
        <p><img src="assets/img/logo.png" width="192px" height="36px" alt="Lol Club"></p>
    </div>
    <nav>
        <div class="menu" id="menu">
            <a href="main">Главная</a>
            <a href="courses">Курсы</a>
            <a href="about">О школе</a>
            <a href="test">Тест</a>
            <a href="blog">Блог</a>
            <a href="contacts">Контакты</a>
        </div>
    </nav>
    <a href="sign-in">
        <div class="sign__in">
            <div class="sign__in__logo">
                <p><img src="assets/img/sign-in.png" width="24px" height="24px" alt="Logo"></p>
            </div>
            <div class="sign__in__text">Войти</div>
        </div>
    </a>
</header>
<div class="sign__in__page__logo">
    <p><img src="assets/img/logo.png" width="246px" height="46px" alt="Lol Club"></p>
</div>
<form class="sign__up__form" action="sign-up" method="post">
    <div>
        <label for="label-email"> </label>
        <input id="label-email" type="text" name="email" placeholder="Email" required
               oninvalid="this.setCustomValidity('Введите email')" oninput="setCustomValidity('')">
    </div>
    <div>
        <label for="label-phone"> </label>
        <input id="label-phone" type="text" name="phone" placeholder="Телефон"
               oninvalid="this.setCustomValidity('Введите телефон')" oninput="setCustomValidity('')">
    </div>
    <div>
        <label for="label-name"> </label>
        <input id="label-name" type="text" name="name" placeholder="Имя"
               oninvalid="this.setCustomValidity('Введите имя')" oninput="setCustomValidity('')">
    </div>
    <div>
        <label for="label-surname"> </label>
        <input id="label-surname" type="text" name="surname" placeholder="Фамилия"
               oninvalid="this.setCustomValidity('Введите фамилию')" oninput="setCustomValidity('')">
    </div>
    <div>
        <label for="label-username"> </label>
        <input id="label-username" type="text" name="username" placeholder="Логин"
               oninvalid="this.setCustomValidity('Введите логин')" oninput="setCustomValidity('')">
    </div>
    <div>
        <label for="label-password"> </label>
        <input id="label-password" type="password" name="password" placeholder="Пароль"
               oninvalid="this.setCustomValidity('Введите пароль')" oninput="setCustomValidity('')">
    </div>
    <div>
        <label for="label-repeated_password"> </label>
        <input id="label-repeated_password" type="password" name="repeated_password" placeholder="Повторите пароль"
               oninvalid="this.setCustomValidity('Подтвердите пароль')" oninput="setCustomValidity('')">
    </div>
    <div class="buttons">
        <button type="submit" class="sign__up__page__button">Регистрация</button>
    </div>
</form>
<div class="sign__up__error__message">
    <c:if test="${requestScope.error != null}">
        <c:out value="${requestScope.error}"/>
    </c:if>
</div>
<div class="student__office__text">Регистрация</div>
<script src="js/script.js"></script>
</body>
</html>
