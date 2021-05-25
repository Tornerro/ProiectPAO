package Main;

import Model.Angajat;
import Model.Bautura;
import Model.Client;
import Model.Mancare;
import Service.Service;
import Model.Tigari;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        String meniu = """
                Optiuni:
                0) Opreste programul
                1) Afisare meniu
                2) Adauga un produs in meniu
                3) Elimina un produs din meniu
                4) Adauga angajat
                5) Adauga client
                6) Afiseaza toti angajatii
                7) Elimina un angajat
                8) Afiseaza toate bonurile
                9) Afiseaza cea mai mare comanda
                10) Afiseaza suma totala a bonurilor""";


        while(true){
            System.out.println(meniu);
            int optiune = Integer.parseInt(scanner.nextLine());

            switch(optiune){
                case 1 -> service.afisareMeniu();
                case 2 -> {
                    System.out.println("""
                            Alegeti tipul de produs:
                            1) Mancare
                            2) Bautura
                            3) Tigari""");
                    int tip = Integer.parseInt(scanner.nextLine());
                    if(tip == 1){
                        System.out.println("Introdu numele, pretul, categoria si daca mancarea are alergeni(true sau false)");
                        String dataMancare = scanner.nextLine();
                        String[] fragments = dataMancare.split(" ");
                        Mancare mancare = new Mancare(
                                fragments[0],
                                Integer.parseInt(fragments[1]),
                                fragments[2],
                                Boolean.parseBoolean(fragments[3])
                        );
                        service.addMancare(mancare);
                    }
                    else if(tip == 2) {
                        System.out.println("Introdu numele, pretul si alcoolemia bauturii");
                        String dataBautura = scanner.nextLine();
                        String[] fragments = dataBautura.split(" ");
                        Bautura bautura = new Bautura(
                                fragments[0],
                                Integer.parseInt(fragments[1]),
                                Float.parseFloat(fragments[2])
                        );
                        service.addBautura(bautura);
                    }
                    else if (tip == 3) {
                        System.out.println("Introdu numele, pretul si brandul tigarilor");
                        String dataTigari = scanner.nextLine();
                        String[] fragments = dataTigari.split(" ");
                        Tigari tigari = new Tigari(
                                fragments[0],
                                Integer.parseInt(fragments[1]),
                                fragments[2]
                        );
                        service.addTigari(tigari);
                    }
                    else {
                        System.out.println("Optiune invalida!!!");
                    }
                }
                case 3 -> {
                    System.out.println("""
                            Alegeti tipul de produs:
                            1) Mancare
                            2) Bautura
                            3) Tigari""");
                    int tip = Integer.parseInt(scanner.nextLine());
                    if(tip == 1){
                        service.afiseazaMancare();
                        System.out.println("Introdu numarul mancarii eliminate");
                        int nr = Integer.parseInt(scanner.nextLine());
                        service.elimMancare(nr);
                    }
                    else if(tip == 2){
                        service.afiseazaBauturi();
                        System.out.println("Introdu numarul bauturii eliminate");
                        int nr = Integer.parseInt(scanner.nextLine());
                        service.elimBautura(nr);
                    }
                    else if (tip == 3){
                        service.afiseazaTigari();
                        System.out.println("Introdu numarul tigarilor eliminate");
                        int nr = Integer.parseInt(scanner.nextLine());
                        service.elimTigari(nr);
                    }
                    else{
                        System.out.println("Tip invalid!");
                    }
                }
                case 4 -> {
                    System.out.println("Introdu numele, prenumele si varsta, postul si salariul angajatului:");
                    String dataAngajat = scanner.nextLine();
                    String[] fragments = dataAngajat.split(" ");
                    Angajat angajat = new Angajat(
                            fragments[0],
                            fragments[1],
                            Integer.parseInt(fragments[2]),
                            fragments[3],
                            Integer.parseInt(fragments[4])
                    );
                    service.addAngajat(angajat);
                }
                case 5 -> {
                    System.out.println(
                            "Introdu numele, prenumele, varsta si tipul de plata a clientului(cash sau card):");
                    String dataClient = scanner.nextLine();
                    String[] fragments = dataClient.split(" ");
                    Client client = new Client(
                            fragments[0],
                            fragments[1],
                            Integer.parseInt(fragments[2]),
                            fragments[3]
                    );

                    service.actiuniClient(client);

                }
                case 6 -> {
                    service.afisareAngajati();
                }
                case 7 -> {
                    service.listaAngajati();
                    System.out.println("Introdu numarul angajatului eliminat");
                    int nr = Integer.parseInt(scanner.nextLine());
                    service.elimAngajat(nr);
                }
                case 8 -> service.afiseazaBonuri();
                case 9 -> System.out.println(service.ceaMaiMareComanda());
                case 10 -> service.sumaBonuri();
                case 0 -> {
                    System.out.println("Oprire program...");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Optiune invalida! Alege alta optiune!");
                }
            }
        }
    }

}
