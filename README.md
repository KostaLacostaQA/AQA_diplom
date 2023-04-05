# Название проекта 

Веб-сервис **Путешувствие дня** для покупки и просмотра туров. Оформить можно как в покупкой картой, так и в кредит.

## Начало работы

Для того чтобы запустить данные тесты у себя на локальном ПК, необходимо:

* Установить **Java**
* Среду разработки **IntelliJ IDEA**
* Установить **Docker**
* Установить **Git**

## Установка и запуск

* Склонировать репозиторий `git clone`
* В открытом проекте в терминале **IntelliJ IDEA** ввести `docker-compose up` для запуска контейнера с **MySQL**
* Для запуска SUT ввести в терминал `java -jar artifacts/aqa-shop.jar`
* Для запуска тестов ввести команду `./gradlew clean test`
* Для генерании отчёта **Allure** ввести команду `./gradlew allureServe`