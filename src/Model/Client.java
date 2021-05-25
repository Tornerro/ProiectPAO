package Model;

import Model.Persoana;

public class Client extends Persoana {

    private String tip_plata;

    public Client(String nume, String prenume, Integer varsta, String tip_plata) {
        super(nume, prenume, varsta);
        this.tip_plata = tip_plata;
    }

    public String getTip_plata() {
        return tip_plata;
    }

    public void setTip_plata(String tip_plata) {
        this.tip_plata = tip_plata;
    }

    @Override
    public String toString() {
        return "Nume client =" +this.getNume() + ' ' + this.getPrenume() +
                ", Tip plata=" + tip_plata;
    }
}
