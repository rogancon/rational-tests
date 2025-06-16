# Rational – JUnit 4 Test Suite

Учебный проект: **юнит-тесты к классу `Rational`**
(рациональные дроби) из репозитория
[https://github.com/ra2ra/Rational](https://github.com/ra2ra/Rational).

> **Задание № 1 («Основы автоматизации тестирования», 10 баллов)**
> Клонировать репозиторий, не менять код класса и покрыть его
> оптимальным набором JUnit-4 тестов, соблюдая принципы FIRST.

---

## Структура репозитория

```
pom.xml
readme.md          ← этот файл
src/
 ├─ main/java/Rational.java        исходный класс (НЕ менялся)
 └─ test/java/                     13 тестов
     ├─ RationalConstructorTest.java   – создание / нормализация
     ├─ RationalArithmeticTest.java    – + − × ÷, деление на ноль
     └─ RationalComparisonTest.java    – equals, less, lessOrEqual
```

### Покрытие

| Группа      | Проверки                                                                            |
| ----------- | ----------------------------------------------------------------------------------- |
| Конструктор | 0/1 по умолчанию · сокращение · корректный знак · `den = 0` → `ArithmeticException` |
| Арифметика  | `plus`, `minus`, `multiply`, `divide`, деление на ноль → `ArithmeticException`      |
| Сравнение   | `equals`, `less`, `lessOrEqual`                                                     |

Всего **13** независимых тестов — достаточно, но не избыточно.

---

## Запуск тестов

```bash
mvn clean test
```

> Требуются Maven 3 и JDK 8+ (проверено на OpenJDK 17 и 24).

---

## Обнаруженный дефект исходного класса

Два теста (`lessReturnsTrueForSmallerFraction`
и `lessOrEqualWorksForEqualAndLess`) падают из-за опечатки
в методе `less()`:

```java
// исходный код
return this.numerator * rational.getDenominator()
       < getNumerator() * this.denominator;
```

Правильная версия:

```java
return this.numerator * rational.getDenominator()
       < rational.getNumerator() * this.denominator;
```

После исправления **все 13 тестов зелёные**.
По условию задания реализацию класса не изменяем, поэтому фикс
описан только здесь.

---

## FIRST-анализ

| Принцип         | Выполнение                                            |
| --------------- | ----------------------------------------------------- |
| Fast            | только вычисления, < 2 ms на тест                     |
| Independent     | без shared-state; каждый `@Test` создаёт свои объекты |
| Repeatable      | не зависит от времени, локали, случайных чисел        |
| Self-Validating | `assert…`; результат однозначно зелёный / красный     |
| Timely          | тесты написаны до изменения логики; баг выявляется    |

---

## Проверяющим

* Репозиторий приватный; доступ предоставлен через *Settings → Collaborators*.
* SHA последнего коммита с тестами укажу в ответе на задание.
© 2025 rogancon — учебная работа
