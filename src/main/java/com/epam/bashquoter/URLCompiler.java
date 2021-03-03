package com.epam.bashquoter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLCompiler {
    private final static Logger logger = LogManager.getLogger(URLCompiler.class);

    public String numberCompile(String inputUserData) {
        try {
            Integer.parseInt(inputUserData);
        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Неверный номер");
            logger.error(e);
        }

        StringBuilder stringBuilder = new StringBuilder(inputUserData);
        while (stringBuilder.length() < 6) {
            stringBuilder.insert(0, "0");
        }
        return stringBuilder.toString();
    }

    public String compileRightURLAddress (String inputUserData) {
        return "https://bash.im/quote/" + inputUserData + "/";
    }

    public String readURL(String compiledURLAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL bashorg = new URL(compiledURLAddress);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(bashorg.openStream()));
            String inputLine;
            while ((inputLine = inputStream.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            inputStream.close();
        } catch (IOException e) {
            logger.error(e);
        }
        return stringBuilder.toString();
    }
}
