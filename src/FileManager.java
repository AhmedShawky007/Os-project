import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {


    public boolean Write(String Query, String FilePath, boolean appendtype) {
        PrintWriter writter = null;
        try {
            writter = new PrintWriter(new FileWriter(new File(FilePath), appendtype));
            writter.print(Query);

            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }
}

