package Produs;

public abstract class Produs {
    private String nume;
    private Integer pret;

    public Produs(String nume, Integer pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "nume='" + nume + '\'' +
                ", pret=" + pret +
                '}';
    }
}
