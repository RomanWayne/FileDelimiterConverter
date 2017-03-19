package com.github.rromanov.dr;

import java.io.InputStream;
import java.util.Properties;


public class PropertyFile {
    private final Properties prop;

    public PropertyFile() {
        prop = new Properties();
    }

    public Properties getProperty(){
        try(InputStream input = getClass().getResourceAsStream("/config.properties")){
            prop.load(input);
        }catch(Exception ex){
            System.out.println("Конфигурационный файл не найден");
        }
        return prop;
    }
}


