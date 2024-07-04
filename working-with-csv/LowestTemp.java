
import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.csv.*;

public class LowestTemp{

    public CSVRecord LowestTempTwoRows(CSVRecord LowestTempSoFar, CSVRecord currRow){
            if (LowestTempSoFar == null){
                LowestTempSoFar = currRow;
            } else {
                double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
                double LowestTempTemp = Double.parseDouble(LowestTempSoFar.get("TemperatureF"));

                if (currTemp <= LowestTempTemp && currTemp > -126.8){ // prevent incorrect data
                    LowestTempSoFar = currRow;
                }
            }
        return LowestTempSoFar;
    }
    
    public CSVRecord LowestTempOneFile(CSVParser parser){
        CSVRecord LowestTempForAll = null;

        for (CSVRecord currRow: parser){
            LowestTempForAll = LowestTempTwoRows(LowestTempForAll, currRow);

        }
        return LowestTempForAll;
    }


    public CSVRecord LowestTempManyFiles(){

        DirectoryResource dr = new DirectoryResource();
        CSVRecord LowestTempForAll = null;

        for (File f: dr.selectedFiles()){

            FileResource fr = new FileResource(f);
            CSVParser currParser = fr.getCSVParser();
            CSVRecord LowestTempCurrFile = LowestTempOneFile(currParser);

            if (LowestTempForAll == null){
                LowestTempForAll = LowestTempCurrFile;
            } else {
                LowestTempForAll = LowestTempTwoRows(LowestTempForAll, LowestTempCurrFile);
            }
        }
        return LowestTempForAll;
    }

    public void OutputOneRecord(CSVRecord LowestTempRow){

        double LowestTemp = Double.parseDouble(LowestTempRow.get("TemperatureF"));
        String time;

        try {
            time = LowestTempRow.get("TimeEST");
          }
          catch(Exception e) {
            time = LowestTempRow.get("TimeEDT");
          }

        String date = LowestTempRow.get("DateUTC");

        System.out.println("Lowest Temperature " + LowestTemp + ": Time " + time + ": Date " + date);
    }


    public String findLowestTempAcrossFiles(DirectoryResource dr) {
      double lowestTemp = Double.MAX_VALUE;
      String path = "";
    
      for (File f : dr.selectedFiles()) {

        FileResource fr = new FileResource(f);
        CSVParser parser = fr.getCSVParser();
        CSVRecord record = LowestTempOneFile(parser);
        double temp = Double.parseDouble(record.get("TemperatureF"));
    
        if (temp <= lowestTemp) {
          lowestTemp = temp;
          path = f.getName();
        }
      }
    
      return path;
    }
      


    public String CleanName(String pathNotClean){

      Pattern mypattern = Pattern.compile("[0-9]{4}");

      Matcher match = mypattern.matcher(pathNotClean);
      if (match.find()){
        return ((match.group()).concat("/")).concat(pathNotClean);
      } else {
        return "";
      }
    }


    public void OutputManyFiles(DirectoryResource dr){
        String path = findLowestTempAcrossFiles(dr);
        System.out.println("Lowest day was in file " + path);

        String clean = CleanName(path);
        FileResource fr = new FileResource(clean);

        CSVParser pr1 = fr.getCSVParser();
        CSVRecord LowestTempRow = LowestTempOneFile(pr1);
        System.out.println("Lowest temperature on the day was " + LowestTempRow.get("TemperatureF"));

        CSVParser pr2 = fr.getCSVParser();
        System.out.println("All the Temperatures on the highest day were:");
        for (CSVRecord rec: pr2){
          
          String temp = rec.get("TemperatureF");
          String date = rec.get("DateUTC");
          String time;
          try {
              time = rec.get("TimeEST");
            }
            catch(Exception e) {
              time = rec.get("TimeEDT");
            }

          System.out.println(date + ": " + time + ": " + temp);
        }
    }



    public static void main(String[] args) {

      LowestTemp obj = new LowestTemp();

      // one file
      FileResource fr = new FileResource();
      CSVParser pr = fr.getCSVParser();
      CSVRecord LowestTempRow = obj.LowestTempOneFile(pr);
      obj.OutputOneRecord(LowestTempRow);

      // many files
      DirectoryResource dr = new DirectoryResource();
      obj.OutputManyFiles(dr);

    }
}