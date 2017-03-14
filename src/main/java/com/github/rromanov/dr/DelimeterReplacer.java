package com.github.rromanov.dr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DelimeterReplacer {
    private List<File> listFiles = new ArrayList(); //список файлов в папке с исходными файлами
    private String destDir; //target папка

    public DelimeterReplacer(String sourceDir, String destDir){
        this.destDir = destDir;
        File folder = new File(sourceDir);
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries){
            if (!entry.isDirectory())
                listFiles.add(entry);
        }
    }

    //замена во всех файлах oldDelimetr на newDelimetr
    public void replaceDelimeterInAllFiles(char oldDelimeter, char newDelimeter){
        if (!listFiles.isEmpty()){
            for (File file:listFiles){
                replaceDelimeterInFile(file, oldDelimeter, newDelimeter);
            }
        }else {
            System.out.println("Список файлов пуст!");
        }
    }

    private void replaceDelimeterInFile(File file, char oldDelimeter, char newDelimeter){
        int nextSymbol;
        System.out.println(destDir + "\\" + file.getName());
        try(InputStream input = new FileInputStream(file); OutputStream output = new FileOutputStream(destDir + "\\" + file.getName())){
            nextSymbol = input.read();
            {
                if (nextSymbol == (int) oldDelimeter){
                    output.write((int) newDelimeter);
                } else {
                    output.write(nextSymbol);
                }
                nextSymbol = input.read();
            } while (nextSymbol != -1);
            System.out.println("конец");
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
