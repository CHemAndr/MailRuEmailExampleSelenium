# Autotests
Тест осуществляет процедуру логина на сайт почты mail.ru и
отправляет письмо зерегистрировавшемуся пользователю login@mail.ru, т.е. самому себе.
До запуска теста в файле conf.properties необходимо
в поле login указать свой логин входа на сайт почты mail.ru,
а в поле psw указать пароль.
Тест использует стек java - Selenium - JUnit5
с применением паттерна PageObjects.
