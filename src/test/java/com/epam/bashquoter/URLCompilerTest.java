package com.epam.bashquoter;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class URLCompilerTest {
    private static URLCompiler urlCompiler;

    @BeforeClass
    public static void initTest() {
        urlCompiler = new URLCompiler();
    }

    @AfterAll
    static void afterTest() {
        urlCompiler = null;
    }

    @Test
    public void numberCompile() {
        assertEquals(urlCompiler.numberCompile("1"), "000001");
    }

    @Test
    public void compileRightURLAddress() {
        Pattern pattern = Pattern.compile("https://bash.im/quote/[0-9]{6}/");
        Matcher matcher = pattern.matcher(urlCompiler.compileRightURLAddress("000001"));
        assertTrue(matcher.matches());

    }

    @Test
    public void readURL() {
    }

}
