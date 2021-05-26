package repository.actionsImpl;

import Model.Mancare;
import repository.actions.MancareRepository;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static utils.Queries.*;

public class MancareRepositoryImpl implements MancareRepository {
    private DbConnection dbConnection = DbConnection.getInstance();
    @Override
    public List<Mancare> getAllMancare() {
        List<Mancare> mancaruri = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(GET_ALL_MANCARE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mancare m = new Mancare(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getBoolean(4));
                mancaruri.add(m);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return mancaruri;
    }

    @Override
    public void addMancare(Mancare m) {
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_MANCARE);
            preparedStatement.setString(1, m.getNume());
            preparedStatement.setInt(2, m.getPret());
            preparedStatement.setString(3, m.getCategorie());
            preparedStatement.setBoolean(4, m.getAlergeni());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la adaugarea mancarii");
        }
    }

    @Override
    public void editMancare(Mancare m, int p){
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(EDIT_MANCARE);
            preparedStatement.setInt(1, p);
            preparedStatement.setString(2, m.getNume());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la editarea pretului mancarii");
        }
    }

    @Override
    public void deleteMancare(Mancare m) {
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(DELETE_MANCARE);
            preparedStatement.setString(1, m.getNume().toLowerCase());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la stergerea mancarii");
        }
    }
}
