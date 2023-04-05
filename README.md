# Документы

1. [План автоматизации тестирования сервиса](https://github.com/konstantinDukov423/AQA_diplom/blob/main/docs/Plan.md)
1. [Отчет по итогам тестирования](https://github.com/konstantinDukov423/AQA_diplom/blob/main/docs/Report.md)
1. [Отчет по итогам автоматизации](https://github.com/konstantinDukov423/AQA_diplom/blob/main/docs/Summary.md)

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