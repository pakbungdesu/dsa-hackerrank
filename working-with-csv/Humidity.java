
import edu.duke.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.csv.*;


public class Humidity {

    public Integer parseIntWithoutNA (CSVRecord currRow){

      Integer currHumid;

      try {
        currHumid = Integer.valueOf(currRow.get("Humidity"));
      } catch (NumberFormatException e) {
        currHumid = null;
      }
      return currHumid;
    }

    public CSVRecord lowestTwoRows(CSVRecord lowestSoFar, CSVRecord currRow) {
        if (lowestSoFar == null){
            lowestSoFar = currRow;
        } else {
            Integer currHumid = parseIntWithoutNA(currRow);
            Integer lowestHumid = parseIntWithoutNA(lowestSoFar);

            try {
              if (currHumid <= lowestHumid){
                lowestSoFar = currRow;
              }
            } catch (NullPointerException e){
                // pass
            }

        }
        return lowestSoFar;
    }

    
    public CSVRecord lowestOneFile(CSVParser parser){
        CSVRecord lowestForAll = null;

        for (CSVRecord currRow: parser){
            lowestForAll = lowestTwoRows(lowestForAll, currRow);

        }
        return lowestForAll;
        }


    public CSVRecord lowestManyFiles() {

        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestForAll = null;

        for (File f: dr.selectedFiles()){

            FileResource fr = new FileResource(f);
            CSVParser currParser = fr.getCSVParser();
            CSVRecord humidFile = lowestOneFile(currParser);

            if (lowestForAll == null){
                lowestForAll = humidFile;
            } else {
                lowestForAll = lowestTwoRows(lowestForAll, humidFile);
            }
        }
        return lowestForAll;
        }


    public void OutputOneRecord(CSVRecord lowestRow){

        Integer lowestHumid = parseIntWithoutNA(lowestRow);
        String time;

        try {
            time = lowestRow.get("TimeEST");
            }
            catch(Exception e) {
            time = lowestRow.get("TimeEDT");
            }

        String date = lowestRow.get("DateUTC");
        System.out.println("Lowest Humidity " + lowestHumid + ": Time " + time + ": Date " + date);
    }


    public String findLowestHumidAcrossFiles(DirectoryResource dr){

        Integer allHumid = Integer.MAX_VALUE; 
        String path = "";
      
        for (File f: dr.selectedFiles()){
          
          FileResource fr = new FileResource(f);
          CSVParser currParser = fr.getCSVParser();
          int humid = parseIntWithoutNA(lowestOneFile(currParser));
      
          if (humid <= allHumid) {
            allHumid = humid;
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


    public void OutputManyFiles(String path) {

        System.out.println("Lowest humidity was in file " + path);

        String cleanPath = CleanName(path);
        FileResource fr = new FileResource(cleanPath);

        CSVParser pr1 = fr.getCSVParser();
        CSVRecord lowestRow = lowestOneFile(pr1);
        System.out.println("Lowest humidity on the day was " + lowestRow.get("Humidity"));

        CSVParser pr2 = fr.getCSVParser();
        System.out.println("All the Humidity on the highest day were:");
        for (CSVRecord rec: pr2){
          
          String humidity = rec.get("Humidity");
          String date = rec.get("DateUTC");
          String time;
          try {
              time = rec.get("TimeEST");
            }
            catch(Exception e) {
              time = rec.get("TimeEDT");
            }

          System.out.println(date + ": " + time + ": " + humidity);
        }
    }


    public static void main(String[] args) {

      Humidity obj = new Humidity();

      // one file
      FileResource fr = new FileResource();
      CSVParser pr = fr.getCSVParser();
      CSVRecord lowestHumid = obj.lowestOneFile(pr);
      obj.OutputOneRecord(lowestHumid);

      
      // many files
      DirectoryResource dr = new DirectoryResource();
      String path = obj.findLowestHumidAcrossFiles(dr);
      obj.OutputManyFiles(path);
        
    }
    }

    
