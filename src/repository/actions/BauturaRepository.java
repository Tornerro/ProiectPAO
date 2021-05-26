package repository.actions;

import Model.Bautura;

import java.util.List;

public interface BauturaRepository {
    List<Bautura> getAllBautura();
    void addBautura(Bautura b);
    void editBautura(Bautura b, int p);
    void deleteBautura(Bautura b);
}
