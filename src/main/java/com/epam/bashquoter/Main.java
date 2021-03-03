package com.epam.bashquoter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Практика
 * Это общее задание для всего раздела Java Standart API. Сначала необходимо изучить всю теорию, после приступать к выполнению задания.
 * Выполнять задание необходимо с использованием всех знаний полученных ранее, правильное деление на классы, создание интерфейсов,
 * правильные package. Использовать maven для сборки и тестирования приложения. Писать в TDD стиле.
 *
 * Задача: Написать приложение, которое будет запускаться в консоли и ожидать на вход число. При вводе числа с клавитуатры приложение
 * выводит цитату с таким номером с сайта https://bash.im/ , например, https://bash.im/quote/454600  после вывода на консоль цитаты,
 * приложение ожидает ввода нового номера. В задании нельзя использовать сторонние библиотеки, кроме JUnit, Mockito, log4j.
 * Парсить страницы необходимо при помощи регулярных выражений. Необходимо добавить логгирование при помощи log4j.
 */

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            URLCompiler compilerURL = new URLCompiler();
            String inputNumber;
//            inputNumber = JOptionPane.showInputDialog("Введите число от 1 до ~464766");
            while (!(inputNumber = reader.readLine()).equals("")) {
                String compiledNumber = compilerURL.numberCompile(inputNumber);
                String compiledRightURL = compilerURL.compileRightURLAddress(compiledNumber);
                String readURL = compilerURL.readURL(compiledRightURL);
                String result = "Quote " + compiledNumber + " does not exist";
                try {
                    result = new QuoteGetter().getQuote(readURL);
                } catch (QuoteNotFoundException e) {
                    logger.error(e);
                }
                logger.info(result);
//            JOptionPane.showMessageDialog(null, result);
//            System.exit(0);
            }
        } catch (IOException e) {
            logger.error(e);
        }
    }
}