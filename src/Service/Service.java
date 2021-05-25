package Service;

import Model.Angajat;
import Model.Bautura;
import Model.Bon;
import Model.Client;
import Model.Mancare;
import Model.Produs;
import Model.Tigari;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private static Bautura[] bauturi = new Bautura[0];
    private static Mancare[] mancare = new Mancare[0];
    private static Tigari[] tigari = new Tigari[0];
    private static Angajat[] angajati = new Angajat[0];
    private static Bon[] bonuri = new Bon[0];

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
        Mancare[] temp = new Mancare[mancare.length + 1];
        System.arraycopy(mancare, 0, temp, 0, mancare.length);
        temp[mancare.length] = m;
        mancare = temp;
        System.out.println("Mancare adaugata.");
    }

    public void addBautura(Bautura b){
        Bautura[] temp = new Bautura[bauturi.length + 1];
        System.arraycopy(bauturi, 0, temp, 0, bauturi.length);
        temp[bauturi.length] = b;
        bauturi = temp;
        System.out.println("Bautura adaugata.");
    }

    public void addTigari(Tigari t){
        Tigari[] temp = new Tigari[tigari.length + 1];
        System.arraycopy(tigari, 0, temp, 0, tigari.length);
        temp[tigari.length] = t;
        tigari = temp;
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
        Mancare[] temp = new Mancare[mancare.length - 1];
        int k = 0;
        for(Mancare m : mancare){
            if(k < nr)temp[k] = m;
            else if(k>nr)temp[k-1] = m;
            k ++;
        }
        mancare = temp;
        System.out.println("Mancare eliminata din meniu.");
    }

    public void elimBautura(int nr){
        Bautura[] temp = new Bautura[bauturi.length - 1];
        int k = 0;
        for(Bautura b : bauturi){
            if(k < nr)temp[k] = b;
            else if(k>nr)temp[k-1] = b;
            k ++;
        }
        bauturi = temp;
        System.out.println("Bautura eliminata din meniu.");
    }

    public void elimTigari(int nr){
        Tigari[] temp = new Tigari[tigari.length - 1];
        int k = 0;
        for(Tigari t : tigari){
            if(k < nr)temp[k] = t;
            else if(k>nr)temp[k-1] = t;
            k ++;
        }
        tigari = temp;
        System.out.println("Tigari eliminate din meniu.");
    }

    public void afisareAngajati(){
        for(Angajat a: angajati){
            System.out.println(a);
        }
    }

    public void addAngajat(Angajat a){
        Angajat[] temp = new Angajat[angajati.length + 1];
        System.arraycopy(angajati, 0, temp, 0, angajati.length);
        temp[angajati.length] = a;
        angajati = temp;
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
        Angajat[] temp = new Angajat[angajati.length - 1];
        int k = 0;
        for(Angajat a : angajati){
            if(k < nr)temp[k] = a;
            else if(k>nr)temp[k-1] = a;
            k ++;
        }
        angajati = temp;
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
                    lista_p.add(mancare[nr]);
                    suma_totala += mancare[nr].getPret();
                }
                else if(tip == 2){
                    afiseazaBauturi();
                    System.out.println("Introdu numarul bauturii alese");
                    int nr = Integer.parseInt(scanner.nextLine());
                    lista_p.add(bauturi[nr]);
                    suma_totala += bauturi[nr].getPret();
                }
                else if (tip == 3) {
                    afiseazaTigari();
                    System.out.println("Introdu numarul tigarilor alese");
                    int nr = Integer.parseInt(scanner.nextLine());
                    lista_p.add(tigari[nr]);
                    suma_totala += tigari[nr].getPret();
                } else {
                    System.out.println("Tip invalid!!!");
                }
            }
            else if (opt == 2) {
                Bon b = new Bon(c, lista_p, suma_totala);
                Bon[] temp = new Bon[bonuri.length + 1];
                System.arraycopy(bonuri, 0, temp, 0, bonuri.length);
                temp[bonuri.length] = b;
                bonuri = temp;
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
        for(int i = 1; i < bonuri.length; ++i){
            if(bonuri[i].getTotal_plata() > bonuri[k].getTotal_plata())k = i;
        }
        return bonuri[k];
    }

    public void sumaBonuri(){
        int suma = 0;
        for(Bon b: bonuri){
            suma += b.getTotal_plata();
        }
        System.out.println("Suma bonurilor este " + suma);
    }

}
