package Service;

import Model.Angajat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditService {
    String pathToCSV = "D:\\Facultate\\PAO\\proiect\\ProiectPAO\\src\\reports\\actiuni.csv";

    private AuditService() {}

    private static class SINGLETON_HOLDER{
        private static final AuditService INSTANCE = new AuditService();
    }

    public static AuditService getInstance() { return SINGLETON_HOLDER.INSTANCE; }

    public void logNewAction(String s){
        StringBuilder reportContent = new StringBuilder();

        reportContent.append('\n');
        reportContent.append(s);
        reportContent.append(',');
        reportContent.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

        try {
            Files.write(Paths.get(pathToCSV), reportContent.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
