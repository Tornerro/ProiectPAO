package Model;

public class Bautura extends Produs {
    private Float alcoolemie;


    public Bautura(String nume, Integer pret, Float alcoolemie) {
        super(nume, pret);
        this.alcoolemie = alcoolemie;
    }

    public Float getAlcoolemie() {
        return alcoolemie;
    }

    public void setAlcoolemie(Float alcoolemie) {
        this.alcoolemie = alcoolemie;
    }

    @Override
    public String toString() {
        return this.getNume() +
                "(pret=" + this.getPret() +
                ", alcoolemie=" + alcoolemie +")";
    }
}
