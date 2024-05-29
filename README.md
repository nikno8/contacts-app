# Контакты

Консольное приложение для управления контактами, реализованное с использованием Spring Framework.

## Оглавление

- [Функциональность](#функциональность)
- [Установка и запуск](#установка-и-запуск)
  - [Предварительные условия](#предварительные-условия)
  - [Сборка и запуск приложения](#сборка-и-запуск-приложения)
  - [Запуск с профилем init](#запуск-с-профилем-init)
- [Настройки приложения](#настройки-приложения)
- [Команды пользователя](#команды-пользователя)

## Функциональность

Приложение позволяет:

1. **Просматривать все контакты** в формате `Ф. И. О. | Номер телефона | Адрес электронной почты`.
2. **Добавлять новый контакт** в список контактов.
3. **Удалять контакт по email** из списка.
4. **Сохранять контакты в файл**.
5. **Инициализировать контакты из файла** при запуске с профилем `init`.

## Установка и запуск

### Предварительные условия

- Java Development Kit (JDK) версии 11 или выше
- Apache Maven для управления зависимостями

### Сборка и запуск приложения

1. **Клонировать репозиторий:**

    ```bash
    git clone <URL>
    cd contacts-app
    ```

2. **Собрать приложение с помощью Maven:**

    ```bash
    mvn clean install
    ```

3. **Запуск приложения:**

    ```bash
    java -jar target/contacts-app-1.0-SNAPSHOT.jar
    ```

### Запуск с профилем `init`

Чтобы загрузить контакты из файла при инициализации, запустите приложение с профилем `init`:

```bash
java -jar -Dspring.profiles.active=init target/contacts-app-1.0-SNAPSHOT.jar
```

## Настройки приложения
Настройки приложения находятся в файле application.properties в директории src/main/resources.

## Команды пользователя

Приложение поддерживает следующие команды:

1. **Просмотр всех контактов**:

    ```plaintext
    list
    ```

    Выводит все контакты в формате:
    
    ```
    Ф. И. О. | Номер телефона | Адрес электронной почты
    ```

2. **Добавление нового контакта**:

    ```plaintext
    add <Ф. И. О.>; <номер телефона>; <адрес электронной почты>
    ```

    Пример:

    ```plaintext
    add Иванов Иван Иванович; +79012345678; ivanov@example.com
    ```

3. **Удаление контакта по email**:

    ```plaintext
    remove <адрес электронной почты>
    ```

    Пример:

    ```plaintext
    remove ivanov@example.com
    ```

4. **Сохранение контактов в файл**:

    ```plaintext
    save
    ```

    Сохраняет все текущие контакты в файл, указанный в настройках приложения.


