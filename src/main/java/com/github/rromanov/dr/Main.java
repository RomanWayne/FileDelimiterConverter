package com.github.rromanov.dr;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        //getting settings from .properties file
        Properties property = new PropertyFile().getProperty();
        //replacement delimiter
        DelimiterReplacer delimiterReplacer = new DelimiterReplacer(property.getProperty("SourceDir"), property.getProperty("OutputDir"));
        delimiterReplacer.replaceDelimiterInAllFiles(property.getProperty("OldDelimiter"), property.getProperty("NewDelimiter"));

    }

}