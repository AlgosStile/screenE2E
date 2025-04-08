# End-to-End Test Automation Framework with Screenplay Pattern

[![Java](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk)](https://openjdk.org/)
[![Playwright](https://img.shields.io/badge/Playwright-1.50.0-blue?logo=playwright)](https://playwright.dev/)
[![JUnit](https://img.shields.io/badge/JUnit-5-green?logo=junit5)](https://junit.org/junit5/)
[![Maven](https://img.shields.io/badge/Maven-3.9.x-red?logo=apachemaven)](https://maven.apache.org/)
[![Allure](https://img.shields.io/badge/Allure-Report-ff69b4?logo=allure)](https://docs.qameta.io/allure/)

Профессиональный фреймворк для автоматизации E2E-тестирования веб-приложений, реализующий паттерн **Screenplay** с использованием современного стека технологий.

---

## Содержание
1. [Ключевые особенности](#ключевые-особенности)
2. [Технологический стек](#технологический-стек)
3. [Быстрый старт](#быстрый-старт)
4. [Структура проекта](#структура-проекта)
5. [Пример теста](#пример-теста)
6. [Генерация отчетов](#генерация-отчетов)

---

## Ключевые особенности

✅ **Реализация Screenplay Pattern**
- Четкое разделение на: Акторы (Actor), Задачи (Task), Вопросы (Question)
- Поддержка композитных задач и переиспользуемых компонентов

✅ **Полная интеграция с Playwright**
- Быстрые и стабильные тесты благодаря современному движку
- Поддержка автоматических ожиданий элементов

✅ **Профессиональная отчетность**
- Детализированные Allure-отчеты с шагами теста
- Автоматические скриншоты при падении тестов

✅ **Гибкая архитектура**
- Легко расширяемые Page Objects
- Поддержка кастомных способностей (Abilities)

---

## Технологический стек

| Компонент       | Версия | Назначение                          |
|-----------------|--------|-------------------------------------|
| Java            | 17     | Базовый язык разработки             |
| Playwright      | 1.50.0 | Автоматизация браузера              |
| JUnit 5         | 5.11.4 | Структура тестов и ассерты          |
| Maven           | 3.9.6  | Сборка и управление зависимостями   |
| Allure Framework| 2.27.0   | Генерация отчетов                   |

---

## Быстрый старт

### Требования
- JDK 17+
- Maven 3.9.6
- Playwright 1.50.0 
- JUnit 5.11.4
- Allure 2.27.0
- Другие зависимости...

### Установка
1. Клонировать репозиторий:
   `
   git clone https://github.com/your-repo/e2e-screenplay-framework.git
2. Собрать проект:
`
mvn clean install
`

### Запуск тестов

`
mvn test
`
### Структура проекта

```
src/main/java  
├── core  
│   ├── Actor.java                      # Основной класс актора  
│   ├── abilities  
│   │   └── BrowseTheWeb.java           # Способность работать с браузером  
│   ├── interactions  
│   │   ├── Clear.java                  # Очистка поля  
│   │   ├── Click.java                  # Клик по элементу  
│   │   ├── ClickPagination.java        # Клик по пагинации  
│   │   ├── Enter.java                  # Ввод текста  
│   │   ├── ResetFilters.java           # Сброс фильтров  
│   │   ├── Scroll.java                 # Прокрутка страницы  
│   │   ├── Select.java                 # Выбор опции  
│   │   ├── SelectColorAndApply.java    # Выбор цвета + применение  
│   │   ├── Task.java                   # Интерфейс задачи  
│   │   ├── Wait.java                   # Ожидания  
│   │   ├── WaitForUrl.java             # Ожидание URL  
│   │   └── Другие задачи...  
│   ├── questions  
│   │   ├── Question.java               # Интерфейс вопроса  
│   │   ├── Text.java                   # Получение текста элемента  
│   │   ├── Verify.java                 # Проверка условия  
│   │   └── VerifyText.java             # Проверка текста  
│   └── ui  
│       └── Target.java                 # Описание элементов интерфейса  
├── helper  
│   ├── BaseTest.java                   # Базовый класс для тестов  
│   └── TakeScreenshot.java             # Создание скриншотов  
└── pages                               # Page-объекты (описание элементов)  
    ├── CartPage.java  
    ├── CatalogPage.java  
    ├── HeaderPage.java  
    ├── OrderPage.java  
    ├── ProductPage.java  
    ├── UrlPage.java  
    └── Другие классы...  

src/test/java  
└── tests  
    └── FullE2ETest.java                # E2E-тесты
```
### Пример теста

```
public class FullE2ETest extends BaseTest {
    @Test
    @DisplayName("Полный цикл покупки")
    void fullPurchaseTest() {
        executeStage("Настройка фильтров", () -> 
            actor.attemptsTo(
                Enter.theText("1000").into(CatalogPage.PRICE_FROM),
                Select.option(CatalogPage.CATEGORY_SELECT, "Телефоны")
            ));
        
        // ... остальные этапы ...
        
        executeStage("Подтверждение заказа", () ->
            actor.attemptsTo(
                Verify.that(VerifyText.of(OrderConfirmationPage.HEADER, "Заказ оформлен"))
            ));
    }
}
```

### Генерация отчетов
Запустить Allure Server:

`
allure serve target/allure-results
`
Отчет будет доступен по адресу: http://localhost:8080
