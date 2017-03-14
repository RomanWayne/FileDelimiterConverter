package com.github.rromanov.dr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RWPropFile {
    Properties prop = new Properties();

    /*public void writePropFile(){
        try(OutputStream output = new FileOutputStream("src/resource/config.properties")){
            prop.setProperty("SourceDir", "C://temp");
            prop.setProperty("OutputDir", "C://temp//out");
            prop.store(output, null);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }*/

    public Properties getProperty(){
        try(InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")){
            prop.load(input);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return prop;
    }
}
