package com.epam.bashquoter;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.*;

public class QuoteGetter {
    Pattern pattern;
    Matcher matcher;

    public String getQuote(String fullURLContent) throws QuoteNotFoundException {
        String result;
        pattern = Pattern.compile("description\" content=\"(.+?)\"");

        matcher = pattern.matcher(fullURLContent);

        if (matcher.find()) {
            result = matcher.group(1);

            result = result.replaceAll("&lt;", "<")
                    .replaceAll("(&quot;|\\/>)", "")
                    .replaceAll("&gt;", ">")
                    .replaceAll("(<br|&#10;)", "\n")
                    .replaceAll("/>", "")
                    .replaceAll("&#13;", "\r");

        } else {
//            JOptionPane.showMessageDialog(null, "Такой цитаты нет");
            throw new QuoteNotFoundException("I am very sorry to inform you that this quote probably does not exist");
        }
        return result;
    }
}
