package Service;

import Model.Angajat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class AngajatService {
    private static List<Angajat> angajati = new ArrayList<>();
    String pathToCSV = "D:\\Facultate\\PAO\\proiect\\ProiectPAO\\src\\reports\\angajati.cvs";

    private AngajatService() {
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(pathToCSV));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            csvReader.readLine();
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                Angajat a = new Angajat(data[0], data[1], Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]));
                angajati.add(a);
            }
            csvReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static class SINGLETON_HOLDER{
        private static final AngajatService INSTANCE = new AngajatService();
    }

    public static AngajatService getInstance() { return SINGLETON_HOLDER.INSTANCE;}

    public List<Angajat> getAngajati(){
        return angajati;
    }

    public void addAngajat(Angajat a){
        StringBuilder reportContent = new StringBuilder();

        reportContent.append("\n");
        reportContent.append(a.getNume());
        reportContent.append(",");
        reportContent.append(a.getPrenume());
        reportContent.append(",");
        reportContent.append(a.getVarsta());
        reportContent.append(",");
        reportContent.append(a.getPost());
        reportContent.append(",");
        reportContent.append(a.getSalariu());

        try {
            Files.write(Paths.get(pathToCSV), reportContent.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void updateCSV(List<Angajat> a) throws FileNotFoundException {
        StringBuilder reportContent = new StringBuilder();

        //build report header
        reportContent.append("NUME");
        reportContent.append(",");
        reportContent.append("PRENUME");
        reportContent.append(",");
        reportContent.append("VARSTA");
        reportContent.append(",");
        reportContent.append("POST");
        reportContent.append(",");
        reportContent.append("SALARIU");

        a.forEach(ang -> {
            reportContent.append("\n");
            reportContent.append(ang.getNume());
            reportContent.append(",");
            reportContent.append(ang.getPrenume());
            reportContent.append(",");
            reportContent.append(ang.getVarsta());
            reportContent.append(",");
            reportContent.append(ang.getPost());
            reportContent.append(",");
            reportContent.append(ang.getSalariu());
        });

        try {
            Files.write(Paths.get(pathToCSV), reportContent.toString().getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
