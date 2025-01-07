# Приложение для поиска информации по BIN

Приложение предоставляет информацию по BIN (Bank Identification Number) банковских карт и сохраняет историю запросов.

---

## Функционал

### Первый экран: Информация о BIN
- **Ввод BIN номера** 
- **Детали BIN:** Отображается информация о введенном BIN:
  - Страна (название и координаты)
  - Тип карты (например, Visa, MasterCard)
  - Информация о банке (название, URL, номер телефона, город)
- **Интерактивные ссылки:**
  - Нажатие на **Website** открывает сайт банка в браузере.
  - Нажатие на **Call Banck** открывает экран вызова с номером банка.
  - Нажатие на **Open in maps** открывает местоположение в приложении карт.

### Второй экран: История запросов
- **Сохранение истории:** Список всех предыдущих запросов BIN **с повторениями**.
- **Детализированный просмотр:** Раскрытие записи для отображения подробной информации.
- **Персистентность:** История сохраняется и доступна даже после перезапуска.

---

## Стек технологий

- **Язык программирования:** Kotlin
- **Архитектура:** MVVM (Model-View-ViewModel)
- **Dependency Injection:** Koin
- **UI:** Jetpack Compose
- **Асинхронность:** Kotlin Coroutines
- **Сетевое взаимодействие:** Retrofit
- **Принципы разработки:** Clean Architecture

---

## Скриншоты
![Settings Window](https://raw.github.com/gurx0/bank-info-search/blob/assets/screenshots/p1.jpg)
https://github.com/gurx0/bank-info-search/assets/screenshots/p1.jpg
![alt text](https://raw.githubusercontent.com/gurx0/bank-info-search/blob/assets/screenshots/p1.jpg)
![alt text](https://raw.githubusercontent.com/gurh0/bank-info-search/caf5ae68/p2.png)
---

## Установка и запуск
1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/your-repo/bin-info-search.git
## Установка и запуск

1. **Откройте проект** в Android Studio.
2. **Убедитесь**, что на вашем устройстве включен доступ к интернету.
3. **Запустите приложение** на эмуляторе или физическом устройстве.

---

## Требования

- **Минимальная версия Android:** API 28 
- **Инструменты разработки:** Android Studio 

---

## Структура проекта

Проект следует принципам **Clean Architecture**, разделяя код на уровни:

### 1. Data
- **Источники данных:** API, локальная база данных
- **Модели данных:** DTO и сущности базы данных

### 2. Domain
- **Логика приложения**
- **Работа с сетью**

### 3. Presentation
- **UI-компоненты, экраны**
- **ViewModel:** Взаимодействие между UI и бизнес-логикой
