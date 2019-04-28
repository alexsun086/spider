package io;

import model.Business;
import model.Stock;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSource {
    public static FileWriter fWriter=null;
    public static BufferedWriter bWriter=null;

    public static void writeBusiness(String filePath, List<Business> businessList, String title){
        try{

            File dFile = new File(filePath);
            if (!dFile.isFile()) {
                dFile.createNewFile();
            }
            fWriter = new FileWriter(dFile, true);

            bWriter= new BufferedWriter(fWriter);

            if(StringUtils.isNotEmpty(title)){
                bWriter.write(title);
                bWriter.newLine();
            }

            for(Business business : businessList){
                String line= business.getSerial()+","+ business.getBusiness()+","+ business.getBusinessIndex()+","
                        + business.getUpdown()+","+ business.getInFund()+","+ business.getOutFund()+","
                        + business.getNetFund()+","+ business.getCompanyAmount()+","+ business.getLeaderStock()+","
                        + business.getLeaderUpdown()+","+ business.getLeaderPrice();
                bWriter.write(line);
                bWriter.newLine();
            }

            bWriter.flush();
            bWriter.close();

            fWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeStock(String filePath, List<Stock> stockList, String title){
        try{

            File dFile = new File(filePath);
            if (!dFile.isFile()) {
                dFile.createNewFile();
            }
            fWriter = new FileWriter(dFile, true);

            bWriter= new BufferedWriter(fWriter);

            if(StringUtils.isNotEmpty(title)){
                bWriter.write(title);
                bWriter.newLine();
            }

            System.out.println("stocks："+stockList.size());
            for(Stock stock:stockList ){
                String line=stock.getConcept()+","+stock.getSerial()+","+stock.getCode()+","+stock.getName()+","
                        +stock.getPrice()+","+stock.getUpdown()+","+stock.getUpdownPrice()+","
                        +stock.getTurnover()+","+stock.getVolRatio()+","+stock.getAmplitude()+","
                        +stock.getVolRatio()+","+stock.getTradeable()+","+stock.getMarketValue()+","+stock.getPE();

                bWriter.write(line);
                bWriter.newLine();
            }

            bWriter.flush();
            bWriter.close();

            fWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
