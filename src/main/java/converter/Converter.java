package converter;
import com.csvreader.CsvWriter;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


/**
 * @Author:Gao
 * @Date:2019-12-14 17:17
 */
public class Converter {
    public void txtToCsv() {
        String path = "C:\\MyRepository\\Java\\Gmax\\src\\main\\java\\output\\";
        String readFile = path + "part-r-00000";
        String writeFile = path + "result.csv";
        File file = new File(readFile);
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        try {
            CsvWriter csvWriter = new CsvWriter(writeFile, ',', StandardCharsets.UTF_8);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] s = string.split(" | +");
                csvWriter.writeRecord(s);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
