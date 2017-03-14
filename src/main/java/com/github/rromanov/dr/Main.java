package com.github.rromanov.dr;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        //получение настроек из конфигфайла
        RWPropFile rwPropFile = new RWPropFile();
        Properties prop = rwPropFile.getProperty();
        DelimeterReplacer delimeterReplacer = new DelimeterReplacer(prop.getProperty("SourceDir"), prop.getProperty("OutputDir"));
        delimeterReplacer.replaceDelimeterInAllFiles((char) 9 , (char) 59);
    }
}
