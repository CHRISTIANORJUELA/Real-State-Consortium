package com.example.real_state_consortium.utils;

import com.example.real_state_consortium.exeptions.ElementIsNullException;
import com.example.real_state_consortium.models.Receipt;

import java.io.*;
import java.util.ArrayList;

public class Persistence {

    public static final String pathOfTxt = "src/main/java/com/example/real_state_consortium/utils/receipt.txt";
    public static void SaveReceipt(ArrayList<Receipt> receipts){
            String content = "";
            for (Receipt r:receipts){
                content += "\n"+r.getNameAgent()+" | "+r.getNameBuyer();
                if (r.getElementsAdded() != null){
                    for (Data3 rec:r.getElementsAdded()){
                        content += " | "+rec.getNameElement()+" | "+rec.getStockElement()+"|"+rec.getValue();
                    }
                }
                if (r.getStructure() != null){
                    content += " | "+r.getStructure().getTypeStructure()+" | "+r.getStructure().getFront()+" | "+r.getStructure().getBackground()+" | "+r.getStructure().getFloors()+" | "+r.getStructure().getSquareMeters()+" | "+r.getStructure().getPricePerMeter2()+" | "+r.getStructure().getExtractStructure()+" | "+r.getStructure();
                }
                content += r.getDaySell()+" | "+r.getPriceSell();
                saveInformation(pathOfTxt,content,false);
            }
    }

    private static void saveInformation(String pathOfTxt, String content, boolean b) {
        try {
            FileWriter fw = new FileWriter(pathOfTxt,b);
            BufferedWriter bfr = new BufferedWriter(fw);
            bfr.write(content);
            bfr.close();
            fw.close();
        }catch (IOException e){

        }
    }

    public static void loadReceipt() throws NullPointerException {
         LambdaCheckNotNullContent receipFinal = ()->{
                 try {
                     if (readInformation()==null){
                         throw new ElementIsNullException("Error Receipt is not full");
                     }else {
                         return readInformation();
                     }
                 }catch (ElementIsNullException e){
                    PrintMessage.printMessageWarning("Prceso fallido",e.getMessage());
                 }
                 return null;
         };
         receipFinal.checkContent();
    }

    public static ArrayList<String> readInformation() {
        try {
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
            content.forEach(System.out::println);
            return content;
        }catch (FileNotFoundException e){

        } catch (IOException e) {
            
        }
        return null;
    }
}
