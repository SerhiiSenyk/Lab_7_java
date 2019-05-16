/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Знайти паролі в тексті (перші 10 символів після слова password:)та замінити ті паролі
//які не містять хоча б одної великої бувкви однієї малої букви та однієї цифри ,на текст
//UNSECURED
package ua.lviv.iot.tools;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Serhii-PC
 */
public class StringProcessor {
    private String string;
    private List<String> passwordsList = new LinkedList<>();

    public StringProcessor(String string) {
        this.string = string;
    }

    public StringProcessor() {

    }

    public String findUnsecuredPasswords() {
        String replaceStr = "UNSECURED";
        StringBuilder stringBuilder = new StringBuilder("");
        Pattern password = Pattern.compile("(?<=password:)\\S{1,10}");
        String notDigit = "(?!.*\\d).{1,10}";
        String notLow = "(?!.*[a-z]).{1,10}";
        String notUpper = "(?!.*[A-Z]).{1,10}";
        passwordsList.clear();
        Matcher matcher = password.matcher(string);
        while (matcher.find()) {
            passwordsList.add(matcher.group());
        }
        for (int i = 0; i < passwordsList.size(); ++i) {
            if (Pattern.matches(notDigit, passwordsList.get(i))
                    || Pattern.matches(notLow, passwordsList.get(i))
                    || Pattern.matches(notUpper, passwordsList.get(i))) {
                passwordsList.set(i, replaceStr);
            }
            if (i < passwordsList.size() - 1) {
                stringBuilder.append("password:").append(passwordsList.get(i)).append(" ");
            } else {
                stringBuilder.append("password:").append(passwordsList.get(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String readInputText() {
        System.out.println("Enter text : ");
        Scanner consoleScanner = new Scanner(System.in, "UTF-8");
        return consoleScanner.nextLine();

    }

    public void showResults() {
        if (passwordsList.isEmpty()) {
            System.out.println("Not was found passwords in input string");
            return;
        }
        System.out.println("founded passwords:");
        passwordsList.forEach((password) -> {
            System.out.print("password:" + password + " ");
        });
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<String> getPasswordsList() {
        return passwordsList;
    }

    public void setPasswordsList(List<String> passwordsList) {
        this.passwordsList = passwordsList;
    }
}
