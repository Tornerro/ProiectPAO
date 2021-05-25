package Service;

import Model.Angajat;
import Model.Bautura;
import Model.Bon;
import Model.Client;
import Model.Mancare;
import Model.Produs;
import Model.Tigari;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private static AngajatService angajatService = AngajatService.getInstance();
    private static List<Bautura> bauturi = new ArrayList<>();
    private static List<Mancare> mancare = new ArrayList<>();
    private static List<Tigari> tigari = new ArrayList<>();
    private static List<Angajat> angajati = angajatService.getAngajati();
    private static List<Bon> bonuri = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void afisareMeniu(){
        System.out.println("Meniu:\nMancare:");
        for(Mancare m : mancare){
            System.out.println(m);
        }
        System.out.println("Bauturi:");
        for (Bautura b : bauturi){
            System.out.println(b);
        }
        System.out.println("Tigari:");
        for (Tigari t: tigari){
            System.out.println(t);
        }
    }

    public void addMancare(Mancare m){
        mancare.add(m);
        System.out.println("Mancare adaugata.");
    }

    public void addBautura(Bautura b){
        bauturi.add(b);
        System.out.println("Bautura adaugata.");
    }

    public void addTigari(Tigari t){
        tigari.add(t);
        System.out.println("Tigari adaugate.");
    }

    public void afiseazaMancare(){
        int k = 0;
        for(Mancare m : mancare){
            System.out.println(k+") "+m);
            k++;
        }
    }

    public void afiseazaBauturi(){
        int k = 0;
        for(Bautura b : bauturi){
            System.out.println(k+") "+b);
            k++;
        }
    }

    public void afiseazaTigari(){
        int k = 0;
        for(Tigari t: tigari){
            System.out.println(k+") "+t);
            k++;
        }
    }

    public void elimMancare(int nr){
        mancare.remove(nr);
        System.out.println("Mancare eliminata din meniu.");
    }

    public void elimBautura(int nr){
        bauturi.remove(nr);
        System.out.println("Bautura eliminata din meniu.");
    }

    public void elimTigari(int nr){
        tigari.remove(nr);
        System.out.println("Tigari eliminate din meniu.");
    }

    public void afisareAngajati(){
        for(Angajat a: angajati){
            System.out.println(a);
        }
    }

    public void addAngajat(Angajat a){
        angajati.add(a);
        angajatService.addAngajat(a);
        System.out.println("Angajat adaugat.");
    }

    public void listaAngajati(){
        int k = 0;
        for(Angajat a: angajati){
            System.out.println(k+") "+a);
            k++;
        }
    }

    public void elimAngajat(int nr){
        angajati.remove(nr);
        try {
            angajatService.updateCSV(angajati);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Angajat eliminat.");
    }

    public void actiuniClient(Client c){
        int ok = 1;
        List<Produs> lista_p = new ArrayList<>();
        int suma_totala = 0;

        while(ok == 1){
            System.out.println("""
                    Optiuni:
                    1) Cumpara produs
                    2) Creeaza bonul""");
            int opt = Integer.parseInt(scanner.nextLine());

            if(opt == 1){
                System.out.println("""
                    Alege tipul:
                    1) Mancare
                    2) Bautura
                    3) Tigari""");
                int tip = Integer.parseInt(scanner.nextLine());
                if(tip == 1){
                    afiseazaMancare();
                    System.out.println("Introdu numarul mancarii alese");
                    int nr = Integer.parseInt(scanner.nextLine());
                    lista_p.add(mancare.get(nr));
                    suma_totala += mancare.get(nr).getPret();
                }
                else if(tip == 2){
                    afiseazaBauturi();
                    System.out.println("Introdu numarul bauturii alese");
                    int nr = Integer.parseInt(scanner.nextLine());
                    lista_p.add(bauturi.get(nr));
                    suma_totala += bauturi.get(nr).getPret();
                }
                else if (tip == 3) {
                    afiseazaTigari();
                    System.out.println("Introdu numarul tigarilor alese");
                    int nr = Integer.parseInt(scanner.nextLine());
                    lista_p.add(tigari.get(nr));
                    suma_totala += tigari.get(nr).getPret();
                } else {
                    System.out.println("Tip invalid!!!");
                }
            }
            else if (opt == 2) {
                Bon b = new Bon(c, lista_p, suma_totala);
                bonuri.add(b);
                System.out.println("Bon adaugat.");
                ok = 0;
            } else {
                System.out.println("Optiune invalida!!!");
            }
        }

    }

    public void afiseazaBonuri(){
        for(Bon b: bonuri){
            System.out.println(b);
        }
    }

    public Bon ceaMaiMareComanda(){
        int k = 0;
        for(int i = 1; i < bonuri.size(); ++i){
            if(bonuri.get(i).getTotal_plata() > bonuri.get(k).getTotal_plata()) k = i;
        }
        return bonuri.get(k);
    }

    public void sumaBonuri(){
        int suma = 0;
        for(Bon b: bonuri){
            suma += b.getTotal_plata();
        }
        System.out.println("Suma bonurilor este " + suma);
    }

}
