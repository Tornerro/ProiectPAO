package Mancare;

import Produs.Produs;

public class Mancare extends Produs {
    private String categorie;
    private Boolean alergeni;


    public Mancare(String nume, Integer pret, String categorie,
            Boolean alergeni) {
        super(nume, pret);
        this.categorie = categorie;
        this.alergeni = alergeni;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Boolean getAlergeni() {
        return alergeni;
    }

    public void setAlergeni(Boolean alergeni) {
        this.alergeni = alergeni;
    }

    @Override
    public String toString() {
        return this.getNume()+
                "(pret=" + this.getPret().intValue() +
                ", categorie=" + categorie.toString() +
                ", alergeni=" + alergeni +")";
    }
}
