package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;

/**
 * commons-csv 由两大核心对象组成 CSVParser（解析），CSVPrinter（写csv）下面附上工具类，以及测试类
 */
public class CSVUtils {

    public static CSVParser getCSVParser(String fileName) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
        return new CSVParser(isr, csvFormat);
    }

    public static CSVPrinter getCSVPrinter(String filePath) throws IOException {
        CSVFormat format = CSVFormat.DEFAULT.withRecordSeparator("\n");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
        return new CSVPrinter(osw, format);
    }
}
