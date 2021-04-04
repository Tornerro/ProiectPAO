package Bon;

import Client.Client;
import Produs.Produs;
import java.util.Date;
import java.util.List;

public class Bon {
    private Client client;
    private List<Produs> produse_cumparate;
    private Integer total_plata;

    public Bon(Client client, List<Produs> produse_cumparate,
            int total_plata) {
        this.client = client;
        this.produse_cumparate = produse_cumparate;
        this.total_plata = total_plata;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produs> getProduse_cumparate() {
        return produse_cumparate;
    }

    public void setProduse_cumparate(List<Produs> produse_cumparate) {
        this.produse_cumparate = produse_cumparate;
    }

    public Integer getTotal_plata() {
        return total_plata;
    }

    public void setTotal_plata(Integer total_plata) {
        this.total_plata = total_plata;
    }

    @Override
    public String toString() {
        return "Bon{" +
                "client=" + client +
                ", produse_cumparate=" + produse_cumparate +
                ", total_plata=" + total_plata +
                '}';
    }
}
