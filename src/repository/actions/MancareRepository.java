package repository.actions;

import Model.Mancare;

import java.util.List;

public interface MancareRepository {
    List<Mancare> getAllMancare();
    void addMancare(Mancare m);
    void editMancare(Mancare m, int p);
    void deleteMancare(Mancare m);
}
