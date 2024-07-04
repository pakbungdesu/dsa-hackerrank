
import edu.duke.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.csv.*;


public class HighestTemp {

    public CSVRecord highestTwoRows(CSVRecord highestSoFar, CSVRecord currRow){
            if (highestSoFar == null){
                highestSoFar = currRow;
            } else {
                double currTemp = Double.parseDouble(currRow.get("TemperatureF"));
                double highestAllTemp = Double.parseDouble(highestSoFar.get("TemperatureF"));

                if (currTemp >= highestAllTemp){
                    highestSoFar = currRow;
                }
            }
        return highestSoFar;
    }
    
    public CSVRecord highestOneFile(CSVParser parser){
        CSVRecord largestSoFar = null;

        for (CSVRecord currRow: parser){
            largestSoFar = highestTwoRows(largestSoFar, currRow);

        }
        return largestSoFar;
    }


    public CSVRecord highestManyFiles(){

        DirectoryResource dr = new DirectoryResource();
        CSVRecord highestAllRec = null;

        for (File f: dr.selectedFiles()){
    
            FileResource fr = new FileResource(f);
            CSVParser currParser = fr.getCSVParser();
            CSVRecord highestCurrFile = highestOneFile(currParser);

            if (highestAllRec == null){
                highestAllRec = highestCurrFile;
            } else {
                highestAllRec = highestTwoRows(highestCurrFile, highestAllRec);
            }
        }
        return highestAllRec;
    }

    public void OutputOneRecord(CSVRecord highestRow){

        double highestAllTemp = Double.parseDouble(highestRow.get("TemperatureF"));
        String time;

        try {
            time = highestRow.get("TimeEST");
          }
          catch(Exception e) {
            time = highestRow.get("TimeEDT");
          }

        String date = highestRow.get("DateUTC");

        System.out.println("Highest Temperature " + highestAllTemp + ": Time " + time + ": Date " + date);
    }


    public String findHighestTempAcrossFiles(DirectoryResource dr){

        double highestTemp = 0.0;
        String path = "";
      
        for (File f: dr.selectedFiles()){
          
          FileResource fr = new FileResource(f);
          CSVParser currParser = fr.getCSVParser();
          CSVRecord record = highestOneFile(currParser);
          double temp = Double.parseDouble(record.get("TemperatureF"));
        
            if (temp >= highestTemp) {
              highestTemp = temp;
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

    
    public void OutputManyFiles(String path){

        System.out.println("Highest day was in file " + path);

        String clean = CleanName(path);
        FileResource fr = new FileResource(clean);

        CSVParser pr1 = fr.getCSVParser();
        CSVRecord highestRow = highestOneFile(pr1);
        System.out.println("Highest temperature on the day was " + highestRow.get("TemperatureF"));

        CSVParser pr2 = fr.getCSVParser();
        System.out.println("All the Temperatures on the highest day were:");
        for (CSVRecord rec: pr2){
          
          String temp = rec.get("TemperatureF");
          String time;
          try {
              time = rec.get("TimeEST");
            }
            catch(Exception e) {
              time = rec.get("TimeEDT");
            }

          String date = rec.get("DateUTC");
          System.out.println(date + ": " + time + ": " + temp);
        }
    }

    public static void main(String[] args){

        HighestTemp obj = new HighestTemp();

        // one file
        // FileResource fr = new FileResource();
        // CSVParser pr = fr.getCSVParser();
        // CSVRecord highestRow = obj.highestOneFile(pr);
        // obj.OutputOneRecord(highestRow);


        // many file
        DirectoryResource dr = new DirectoryResource();
        String path = obj.findHighestTempAcrossFiles(dr);
        obj.OutputManyFiles(path);

    }
}
