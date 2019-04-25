package io;

import model.Concept;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSource {
    public static FileWriter fWriter=null;
    public static BufferedWriter bWriter=null;

     public static void writeContent(String filePath, List<Concept> conceptList, String title){
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

            for(Concept concept:conceptList ){
                String line=concept.getSerial()+","+concept.getConcept()+","+concept.getConceptIndex()+","
                        +concept.getUpdown()+","+concept.getInFund()+","+concept.getOutFund()+","
                        +concept.getNetFund()+","+concept.getCompanyAmount()+","+concept.getLeaderStock()+","
                        +concept.getLeaderUpdown()+","+concept.getLeaderPrice();
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
