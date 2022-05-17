<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lol Club - Администрирование ДЗ</title>
    <link rel="shortcut icon" href="<c:url value="/assets/img/sign-in.png"/>" type="image/png">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@700&family=Raleway:wght@600&display=swap"
          rel="stylesheet">
</head>
<body>
<header>
    <div class="admin__logo">
        <p>AdmPanel</p>
    </div>
    <nav>
        <div class="menu" id="menu">
            <a href="<c:url value="/admin/user/control"/>">Пользователи</a>
            <a href="<c:url value="/admin/group/control"/>">Группы</a>
            <a href="<c:url value="/admin/homework/control"/>"><span class="current__link">Домашка</span></a>
            <a href="<c:url value="/admin/blog/control"/>">Блог</a>
            <a href="<c:url value="/admin/photo/control"/>">Фото</a>
            <a href="<c:url value="/admin/other/control"/>">Прочее</a>
        </div>
    </nav>
    <a href="<c:url value="/admin"/>">
        <div class="sign__in">
            <div class="sign__in__logo">
                <p><img src="<c:url value="/assets/img/sign-in.png"/>" width="24px" height="24px" alt="Logo"></p>
            </div>
            <div class="sign__in__text">
                <c:out value="${sessionScope.user.username}"/>
            </div>
        </div>
    </a>
</header>
<form class="admin__service__buttons" id="form" method="post" action=<c:url value="/admin/homework/control/${group}/${page}/themes"/>>
    <label>
        <input class="admin__service__buttons__each" type="text" id="theme" name="theme" placeholder="Тема">
    </label>
    <label>
        <input class="admin__service__buttons__each" type="date" id="date" name="date" placeholder="Дата">
    </label>
    <label>
        <input class="admin__service__buttons__each" type="text" id="subTheme[]" name="subTheme[]" placeholder="Подтема">
    </label>
    <button type="button" class="admin__service__buttons__each" onclick="add_field()">Добавить подтему</button>
    <button type="submit" class="admin__service__buttons__each">Добавить</button>
</form>
<script src="<c:url value="/js/script.js"/>"></script>
</body>
</html>