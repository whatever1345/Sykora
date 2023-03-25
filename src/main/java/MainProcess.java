import org.apache.poi.ss.formula.functions.Columns;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainProcess {
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello World");
        String inputFile = args[0];

        //System.out.println(isPrimeBruteForce(113));
        FileInputStream file = new FileInputStream(new File(inputFile));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        //Iterate through rows
        for (Row r : sheet){
            if (r.getRowNum() == 0)
                continue;

            // Get B Column
            Cell c = r.getCell(1);
            int val = convertToInt(c.getStringCellValue());

                // Ignore non-positive value
            if (val < 1)
                continue;

                // Output if Prime
            if (isPrimeSieve(val))
                System.out.println(val);
        }
    }

    public static int convertToInt(String n){
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            return 0; // if return 0 then we ignore it
        }
    }

    // Brute force implementation O(n)
    public static boolean isPrimeBruteForce(int num){
        if (num == 1)
            return false;

        for (int i = 2; i < num; i++){
            if (num % i == 0)
                return false;
        }

        return true;
    }

    // Sieve implementation O(sqrt(n))
    public static boolean isPrimeSieve(int num){
        if (num == 1)
            return false;

        for (int i = 2; i * i < num; i++){
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
