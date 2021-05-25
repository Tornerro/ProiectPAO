package Angajat;

import Persoana.Persoana;

public class Angajat extends Persoana {
    private String post;
    private Integer salariu;

    public Angajat(String nume, String prenume, Integer varsta, String post, Integer salariu) {
        super(nume, prenume, varsta);
        this.post = post;
        this.salariu = salariu;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getSalariu() {
        return salariu;
    }

    public void setSalariu(Integer salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return this.getNume() + ' ' + this.getPrenume() +
                ", post=" + post +
                ", salariu=" + salariu;
    }
}
