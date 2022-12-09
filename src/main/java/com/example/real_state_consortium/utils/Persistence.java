package com.example.real_state_consortium.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;
public class Persistence {
    public static final String pathOfTxt = "src/main/java/com/example/real_state_consortium/utils/receipt.txt";
    public static void SaveReceipt(Object receipts){
           // Paso los datos del receiptConverted a receiptsConvertAtString para luego pasarlo a una cadena de String
           ArrayList<String> receiptsConvertAtString = (ArrayList<String>) receipts;
           String content = "";
           for(String r:receiptsConvertAtString){
               content += r;
           }
           saveInformation(pathOfTxt, content, false);
    }

    private static void saveInformation(String pathOfTxt, String content, boolean b) {
        //Guardo la imformacion de tipo String en el archivo txt
        try {
            FileWriter fw = new FileWriter(pathOfTxt,b);
            BufferedWriter bfr = new BufferedWriter(fw);
            bfr.write(content);
            bfr.close();
            fw.close();
        }catch (IOException e){
            PrintMessage.PrintMessageError("Error","Ha ocurrido un error al guardar los datos");
        }
    }

    public static ArrayList<String> loadReceipt(){
        ExecutorService ex = Executors.newFixedThreadPool(3);
        try {
            // Mando a hacer la tarea de leer la información   cuando esta tarea finalize retornara una lista de tipo String  y es la que va a llenar al ReceiptConvert del FinallySellImpl
            return CompletableFuture.supplyAsync(Persistence::readInformation,ex).get(9,TimeUnit.SECONDS);
        }catch (ExecutionException | InterruptedException | TimeoutException e){
            PrintMessage.PrintMessageError("Error", String.valueOf(e));
        }
        return null;
    }


    public static ArrayList<String> readInformation() {
        try {
            // la lista content la lleno con los datos del archivo txt
            ArrayList<String> content = new ArrayList<>();
            FileReader fileReader = new FileReader(pathOfTxt);
            BufferedReader bfr = new BufferedReader(fileReader);
            String line = "";
            int cont = 0;
            while ((line = bfr.readLine())!= null) {
                content.add(cont,line);
                cont++;
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
