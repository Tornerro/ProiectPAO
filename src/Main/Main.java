package Main;

import Model.Angajat;
import Model.Bautura;
import Model.Client;
import Model.Mancare;
import Service.Service;
import Service.AuditService;
import Model.Tigari;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AuditService auditService = AuditService.getInstance();
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        String meniu = """
                Optiuni:
                0) Opreste programul
                1) Afisare meniu
                2) Adauga un produs in meniu
                3) Modifica pretul unui produs
                4) Elimina un produs din meniu
                5) Adauga angajat
                6) Adauga client
                7) Afiseaza toti angajatii
                8) Elimina un angajat
                9) Afiseaza toate bonurile
                10) Afiseaza cea mai mare comanda
                11) Afiseaza suma totala a bonurilor""";

        auditService.logNewAction("Pornire program");

        while(true){
            System.out.println(meniu);
            int optiune = Integer.parseInt(scanner.nextLine());

            switch(optiune){
                case 1 -> {
                    service.afisareMeniu();
                    auditService.logNewAction("Afisare meniu");
                }
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
                    auditService.logNewAction("Produs adaugat in meniu");
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
                        System.out.println("Introdu numarul mancarii careia vrei sa-i modifici pretul");
                        int nr = Integer.parseInt(scanner.nextLine());
                        System.out.println("Seteaza noul pret");
                        int p = Integer.parseInt(scanner.nextLine());
                        service.modifMancare(nr, p);
                    }
                    else if(tip == 2){
                        service.afiseazaBauturi();
                        System.out.println("Introdu numarul bauturii careia vrei sa-i modifici pretul");
                        int nr = Integer.parseInt(scanner.nextLine());
                        System.out.println("Seteaza noul pret");
                        int p = Integer.parseInt(scanner.nextLine());
                        service.modifBautura(nr, p);
                    }
                    else if (tip == 3){
                        service.afiseazaTigari();
                        System.out.println("Introdu numarul tigarilor carora vrei sa le modifici pretul");
                        int nr = Integer.parseInt(scanner.nextLine());
                        System.out.println("Seteaza noul pret");
                        int p = Integer.parseInt(scanner.nextLine());
                        service.modifTigari(nr, p);
                    }
                    else{
                        System.out.println("Tip invalid!");
                    }
                    auditService.logNewAction("Produs eliminat din meniu");
                }
                case 4 -> {
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
                    auditService.logNewAction("Produs eliminat din meniu");
                }
                case 5 -> {
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
                    auditService.logNewAction("Angajat adaugat");
                }
                case 6 -> {
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
                    auditService.logNewAction("Client adaugat");

                }
                case 7 -> {
                    service.afisareAngajati();
                    auditService.logNewAction("Afisare angajati");
                }
                case 8 -> {
                    service.listaAngajati();
                    System.out.println("Introdu numarul angajatului eliminat");
                    int nr = Integer.parseInt(scanner.nextLine());
                    service.elimAngajat(nr);
                    auditService.logNewAction("Angajat eliminat");
                }
                case 9 -> {
                    service.afiseazaBonuri();
                    auditService.logNewAction("Afisare bonuri");
                }
                case 10 -> {
                    System.out.println(service.ceaMaiMareComanda());
                    auditService.logNewAction("Afisare cea mai mare comanda");
                }
                case 11 -> {
                    service.sumaBonuri();
                    auditService.logNewAction("Afisare suma bonuri");
                }
                case 0 -> {
                    System.out.println("Oprire program...");
                    auditService.logNewAction("Oprire program");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Optiune invalida! Alege alta optiune!");
                    auditService.logNewAction("Optiune invalida");
                }
            }
        }
    }

}
