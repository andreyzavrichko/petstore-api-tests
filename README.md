# petstore-api-tests
## :cherry_blossom:	Содержание
> ➠ [Используемые технологии](#Используемые-технологии)
>
> ➠ [Описание проекта](#Описание-проекта)
>
> ➠ [Список проверок](#список-проверок-реализованных-в-автотестах)
>
> ➠ [Пример ручного выполнения тестов с помощью Postman](#Пример-ручного-выполнения-тестов-с-помощью-Postman)
>
> ➠ [Структура проекта](#Структура-проекта)
>
> ➠ [Запуск автотестов выполняется на сервере Jenkins](#Запуск-автотестов-выполняется-на-сервере-Jenkins)
>
> ➠ [Отчёты о результатах сборок в Allure TestOps](#Отчёты-о-результатах-сборок,-списки-тесткейсов,-аналитические-dashboards-хранятся-в-Allure-TestOps)
>
> ➠ [Оповещения](#Настроено-автоматическое-оповещение-о-результатах-сборки-Jenkins-в-Telegram-бот)

## Используемые технологии
![This is an image](/design/icons/Java.png)![This is an image](/design/icons/Gradle.png)![This is an image](/design/icons/Rest-Assured.png)![This is an image](/design/icons/Intelij_IDEA.png)![This is an image](/design/icons/JUnit5.png)![This is an image](/design/icons/Jenkins.png)![This is an image](/design/icons/Allure_Report.png)![This is an image](/design/icons/AllureTestOps.png)![This is an image](/design/icons/Telegram.png)
## Описание проекта
Дипломный проект реализации автотестирования **Rest Api**.<br/>
>В качестве объекта тестирования выбран сайт https://petstore.swagger.io/ с открытым api.<br/>

![This is an image](/design/images/petstore.png)

Сайт позволяет получать информацию о питомцах, заказах и пользователях, а также создавать их.

#### Особенности реализации тестового проекта
- Модели получаемых данных описаны с помощью библиотеки Lombok.
- Использованы спецификации
- Использованы шаблоны форматирования логов запросов.
- Использованы кастомные шаблоны запросов и ответов

## Список проверок, реализованных в автотестах
- [x] Find by status Sold. Поиск по статусу Sold.
- [x] Create Order. Создание заказа.
- [x] Check Inventory. Проверка инвентаря.
- [x] Find by status Null. Поиск по пустому статусу.
- [x] Find by status Available. Поиск по статусу Available.
- [x] Find order. Поиск заказа.
- [x] Get empty User. Получение пустого пользователя.
- [x] Create User. Создание пользователя.
- [x] Create User with array. Создание пользователя с массивом.
- [x] Get null User. Получение пользователя с null.
- [x] Find by pet ID. Поиск питомца по ID.
- [x] Create User with list. Создание пользователя со списком.
- [x] Create pet. Создание питомца.
- [x] Get User. Получение пользователя.
- [x] Find by status Pending. Поиск по статусу Pending.

## Пример ручного выполнения тестов с помощью Postman
![This is an image](/design/images/postman.png)

## Структура проекта
- [x] data - генерирование тестовых данных
- [x] helpers - подключение кастомных шаблонов для Allure Report
- [x] models - модели данных для тестов
- [x] spec - спецификации, необходимые для тестов
- [x] resources - кастомные шаблоны для Allure Report

![This is an image](/design/images/str.png)

#### Пример запуска из командной строки
```bash
gradle clean test
```
## Запуск автотестов выполняется на сервере Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/10-azavrichko-diplom_api/">Ссылка на проект в Jenkins</a>

![This is an image](/design/images/jenkins.png)

Для запуска тестов необходимо выбрать пункт **"Собрать сейчас"**

## Отчёты о результатах сборок, списки тесткейсов, аналитические dashboards хранятся в Allure TestOps
> <a target="_blank" href="https://allure.autotests.cloud/project/1177/dashboards">Сссылка на проект в AllureTestOps</a> (запрос доступа admin@qa.guru)

### Итоговые dashboard по результатам сборок
![This is an image](/design/images/dashboard_overview.png)
### Список результата выполнения тест-кейсов в Allure TestOps
![This is an image](/design/images/allure_report_features.png)
### Пример автоматически сгенерированными тест-кейсами в Allure TestOps
![This is an image](/design/images/allure_testcases.png)
### Пример выполнения тестов в Allure TestOps
![This is an image](/design/images/launches.png)

### Итоговые dashboard в Allure Report
![This is an image](/design/images/allure_report_dashboard.png)
### Список тест-кейсов в Allure Report
![This is an image](/design/images/testcases.png)
### Графики Dashboards в Allure Report
![This is an image](/design/images/graph.png)
### Графики Dashboards в Allure Report
![This is an image](/design/images/graph2.png)

## Настроено автоматическое оповещение о результатах сборки Jenkins в Telegram-бот
![This is an image](/design/images/bot.png)


:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
