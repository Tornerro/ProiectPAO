package utils;

public class Queries {
    public static final String GET_ALL_MANCARE = "select * from pao.mancare order by 3";
    public static final String INSERT_NEW_MANCARE = "INSERT INTO pao.mancare(nume, pret, categorie, alergeni) values (?,?,?,?)";
    public static final String EDIT_MANCARE = "update pao.mancare set pret = ? where LOWER(nume) like ?";
    public static final String DELETE_MANCARE = "delete from pao.mancare where LOWER(nume) like ?";

    public static final String GET_ALL_BAUTURA = "select * from pao.bautura";
    public static final String INSERT_NEW_BAUTURA = "INSERT INTO pao.bautura(nume, pret, alcoolemie) values (?,?,?)";
    public static final String EDIT_BAUTURA = "update pao.bautura set pret = ? where LOWER(nume) like ?";
    public static final String DELETE_BAUTURA = "delete from pao.bautura where LOWER(nume) like ?";

    public static final String GET_ALL_TIGARI = "select * from pao.tigari";
    public static final String INSERT_NEW_TIGARI = "INSERT INTO pao.tigari(nume, pret, brand) values (?,?,?)";
    public static final String EDIT_TIGARI = "update pao.tigari set pret = ? where LOWER(nume) like ? and LOWER(brand) like ?";
    public static final String DELETE_TIGARI = "delete from pao.tigari where LOWER(nume) like ? and LOWER(brand) like ?";
}
