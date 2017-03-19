package com.github.rromanov.dr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DelimiterReplacer {
    private final List<File> files; //list of File in source directory
    private final String destDir; //target folder

    public DelimiterReplacer(String sourceDir, String destDir) {
        this.files = new ArrayList<>();
        this.destDir = destDir;
        File[] folderEntries = new File(sourceDir).listFiles();
        if (Objects.nonNull(folderEntries)){
            for (File entry : folderEntries){
                if (!entry.isDirectory()){
                    files.add(entry);
                }
            }
        }
    }

    public void replaceDelimiterInAllFiles(String oldDelimiter, String newDelimiter) {
        if (!files.isEmpty()){
            for (File file : files){
                replaceDelimiterInFile(file, oldDelimiter, newDelimiter);
            }
        }else {
            System.out.println("Список файлов пуст!");
        }
    }

    private void replaceDelimiterInFile(File file, String oldDelimiter, String newDelimiter) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destDir + "\\" + file.getName())))
        {
            String line = bufferedReader.readLine();
            String[] splitStr;
            StringBuilder stringBuilder = new StringBuilder();
            while (Objects.nonNull(line)) {
                splitStr = line.split(oldDelimiter);
                for(String unit : splitStr){
                    stringBuilder.append(unit).append(newDelimiter);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1); //delete last delimiter in line
                bw.write(stringBuilder.toString());
                bw.newLine();
                //for next iteration
                stringBuilder.delete(0, stringBuilder.length());
                line = bufferedReader.readLine();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

