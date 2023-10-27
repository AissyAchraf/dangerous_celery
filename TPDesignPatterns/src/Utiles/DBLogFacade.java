package Utiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DBLogFacade {

    public static void writeLog(String log) {

        try {
            String filePath = "./db.log";
            FileWriter file = new FileWriter(filePath, true);

            BufferedWriter buffer = new BufferedWriter(file);

            buffer.newLine();
            buffer.write(log);
            buffer.newLine();

            buffer.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
