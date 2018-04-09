package csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.Iterator;

public class CSVTest {

    public static void main(String[] args) throws IOException {
        CSVParser parser = CSVUtils.getCSVParser("D://demo01.csv");
        CSVPrinter printer=CSVUtils.getCSVPrinter("D://demo02.csv");
        Iterator<CSVRecord> iterator = parser.iterator();
        printer.printRecord(parser.getHeaderMap().keySet());//写CSV第一行
        while(iterator.hasNext())
        {
            printer.printRecord(iterator.next());
        }
        parser.close();
        printer.close();
    }
}
