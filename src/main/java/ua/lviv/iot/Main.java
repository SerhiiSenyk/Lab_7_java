package ua.lviv.iot;

import ua.lviv.iot.tools.StringProcessor;

/**
 *
 * @author Serhii-PC
 */
//1)Написати код до завдання з таблиці
//2)При запуску програми потррібнои використовувати домовленості щодо оформлення коду
//3)Перевірка за допомогою тестів
//4)ТАКОЖ реалізувати можливість вичитки тексту з консолі за допомогою методу Scanner,
//використавши main() метод
//5)main метод має викликати метод вичитування даних з консолі .,а також створювати об'єкт,
//метод якого має виконувати роботу  текстом а також метод виводу результату на консоль(showResults)
//6)Виконання опреацій над текстом слід робити за допомогою об'єктів(використання
//статичних методів забороненео ,окрім main методу та readInputText)
//Знайти паролі в тексті (перші 10 символів після слова password:)та замінити ті паролі
//які не містять хоча б одної великої бувкви ,однієї малої букви та однієї цифри ,на текст
//UNSECURED

public class Main {
    public static void main(String[] args) {
       String string = StringProcessor.readInputText();
       StringProcessor processor = new StringProcessor(string);
       processor.findUnsecuredPasswords();
       processor.showResults();
    }
}