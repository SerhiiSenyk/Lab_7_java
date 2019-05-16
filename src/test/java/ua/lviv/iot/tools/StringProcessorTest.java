/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.tools;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Serhii-PC
 */
public class StringProcessorTest {

    public StringProcessorTest() {
    }
    private final StringProcessor processor = new StringProcessor();

    @Test
    public void testUpperSymbolsInPasswords() {
        String string = "password:qwerty12345hvhgvWWEFWEFU password:Qpass123>8";
        String expectedString = "password:UNSECURED password:Qpass123>8";
        processor.setString(string);
        String result = processor.findUnsecuredPasswords();
        assertEquals(result, expectedString);
    }

    @Test
    public void testLowSymbolsInPasswords() {
        String string = "sdvshdv password:passWo12 password:QWE###1234RR";
        String expectedString = "password:passWo12 password:UNSECURED";
        processor.setString(string);
        String result = processor.findUnsecuredPasswords();
        assertEquals(result, expectedString);

    }

    @Test
    public void testDigitsInPasswords() {
        String string = "password:passWoeeA password:QWE###1234RR password:A1q";
        String expectedString = "password:UNSECURED password:UNSECURED password:A1q";
        processor.setString(string);
        String result = processor.findUnsecuredPasswords();
        assertEquals(result, expectedString);

    }
}
