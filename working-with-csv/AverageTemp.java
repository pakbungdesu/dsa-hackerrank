
import edu.duke.*;
import org.apache.commons.csv.*;

public class AverageTemp {

    public double averageTemperatureInFile(CSVParser parser){

        double sum = 0.0, avg;
        int count = 0;

        for (CSVRecord rec: parser){
            double temp = Double.parseDouble(rec.get("TemperatureF"));
            sum += temp;
            count += 1;
        }
        avg = sum/count;
        return avg;
    }

    public Integer parseHumidWithoutNA (CSVRecord currRow){

        Integer currHumid;
  
        try {
          currHumid = Integer.valueOf(currRow.get("Humidity"));
        } catch (NumberFormatException e) {
          currHumid = null;
        }
        return currHumid;
      }


    public void AvgTempWithHumidManyFiles(CSVParser parser){
        double sum = 0.0, avgHighHumid;
        int count = 0;

        for (CSVRecord currRecord: parser){
            Integer currHumid = parseHumidWithoutNA(currRecord);

            if (currHumid != null && currHumid >= 80){
                double temp = Double.parseDouble(currRecord.get("TemperatureF"));
                sum += temp;
                count += 1;
            }
        }
        
        if (sum != 0.0){
            avgHighHumid = sum/count;
            System.out.println("Average Temp when high Humidity is " + avgHighHumid);
        } else {
            System.out.println("No temperatures with that humidity");
        }
    }


    public static void main(String[] args) {
        
        AverageTemp obj = new AverageTemp();

        // one file
        FileResource fr = new FileResource();
        CSVParser pr1 = fr.getCSVParser();
        double res = obj.averageTemperatureInFile(pr1);
        System.out.println("The average temperature was " + res);

        // avergae temperature with high humidity
        CSVParser pr2 = fr.getCSVParser();
        obj.AvgTempWithHumidManyFiles(pr2);
    }
}
