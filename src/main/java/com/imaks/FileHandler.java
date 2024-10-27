package com.imaks;

import java.io.*;

public class FileHandler {

    private final static String BASE_PATH = "files/";

    public String writeFile(String fileName, String fileContent) {
        try(BufferedWriter fw = new BufferedWriter(new FileWriter(BASE_PATH + fileName + ".txt"))) {

            fw.write(fileContent);
            fw.flush(); //is it required? because close() will be called as we have try(fw), however, the close() throws an exception and data from buffer may be lost???
            return "Success.";

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            int sym;
            StringBuilder sb = new StringBuilder();
            while ((sym = reader.read()) != -1) {
                sb.append((char) sym);
            }
            return sb.toString();
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}