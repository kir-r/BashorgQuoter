package com.epam.bashquoter;

import org.junit.jupiter.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class QuoteGetterTest {
    private static QuoteGetter quoteGetter;

    @Before
    public void initTest() {
        quoteGetter = new QuoteGetter();
    }

    @After
    public void afterTest() {
        quoteGetter = null;
    }

    @Test
    public void getQuote() throws QuoteNotFoundException {
        String expectedString = "xxx: Чак Норрис может майнить биткоины без видеокарты\r\nyyy: в уме";
        String testString = quoteGetter.getQuote("<meta property=\"og:description\" content=\"xxx: Чак Норрис может майнить биткоины без видеокарты&#13;&#10;yyy: в уме\" />\n" +
                "    <meta property=\"og:image\" content=\"/img/url-fb.gif\" />");
        assertEquals(expectedString, testString);
    }

    @Test
    public void getException() throws QuoteNotFoundException {
//        Assertions.assertThrows(QuoteNotFoundException.class, () -> quoteGetter.getQuote(""));
    }

}
