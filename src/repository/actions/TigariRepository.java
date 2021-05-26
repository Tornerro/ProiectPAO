package repository.actions;

import Model.Tigari;

import java.util.List;

public interface TigariRepository {
    List<Tigari> getAllTigari();
    void addTigari(Tigari t);
    void editTigari(Tigari t, int p);
    void deleteTigari(Tigari t);
}
