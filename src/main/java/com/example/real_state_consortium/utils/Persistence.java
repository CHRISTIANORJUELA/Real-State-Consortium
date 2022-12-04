package com.example.real_state_consortium.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Persistence {

    public static final String pathOfTxt = "src/main/java/com/example/real_state_consortium/utils/receipt.txt";
    public static void SaveReceipt(Object receipts){
           ArrayList<String> receiptsConvertAtString = (ArrayList<String>) receipts;
           String content = "";
           for(String r:receiptsConvertAtString){
               content += r;
           }
           saveInformation(pathOfTxt, content, false);
    }

    private static void saveInformation(String pathOfTxt, String content, boolean b) {
        try {
            FileWriter fw = new FileWriter(pathOfTxt,b);
            BufferedWriter bfr = new BufferedWriter(fw);
            bfr.write(content);
            bfr.close();
            fw.close();
        }catch (IOException e){
            PrintMessage.PrintMessageError("Error","Ha ocurrido un errror al cargar los datos");
        }
    }

    public static ArrayList<String> loadReceipt() throws NullPointerException {
        ExecutorService ex = Executors.newFixedThreadPool(3);
        try {
            return CompletableFuture.supplyAsync(Persistence::readInformation,ex).get(9,TimeUnit.SECONDS);
        }catch (TimeoutException | ExecutionException | InterruptedException e){
            PrintMessage.PrintMessageError("Error","No fue posible cargar la base de datos");
        }
        return null;
    }


    public static ArrayList<String> readInformation() {
        try {
            ArrayList<String> content = new ArrayList<>();
            FileReader fileReader = new FileReader(pathOfTxt);
            BufferedReader bfr = new BufferedReader(fileReader);
            String line = "";
            while ((line = bfr.readLine())!= null) {
                content.add(line);
            }
            bfr.close();
            fileReader.close();
            return content;
        }catch (FileNotFoundException e){
           PrintMessage.PrintMessageError("Error","No se pudo encontrar el archivo");
        } catch (IOException e) {
            PrintMessage.PrintMessageError("Error","No se enlazar con la fuente del Archivo");
        }
        return null;
    }
}
