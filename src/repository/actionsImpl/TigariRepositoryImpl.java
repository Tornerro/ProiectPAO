package repository.actionsImpl;

import Model.Tigari;
import repository.actions.TigariRepository;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Queries.*;


public class TigariRepositoryImpl implements TigariRepository {
    private DbConnection dbConnection = DbConnection.getInstance();

    @Override
    public List<Tigari> getAllTigari() {
        List<Tigari> tigari = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(GET_ALL_TIGARI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tigari t = new Tigari(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3));
                tigari.add(t);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return tigari;
    }

    @Override
    public void addTigari(Tigari t) {
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_TIGARI);
            preparedStatement.setString(1, t.getNume());
            preparedStatement.setInt(2, t.getPret());
            preparedStatement.setString(3, t.getBrand());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la adaugarea tigarilor");
        }
    }

    @Override
    public void editTigari(Tigari t, int p){
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(EDIT_TIGARI);
            preparedStatement.setInt(1, p);
            preparedStatement.setString(2, t.getNume());
            preparedStatement.setString(3, t.getBrand());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la editarea pretului tigarilor");
        }
    }

    @Override
    public void deleteTigari(Tigari t) {
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(DELETE_TIGARI);
            preparedStatement.setString(1, t.getNume().toLowerCase());
            preparedStatement.setString(2, t.getBrand().toLowerCase());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la stergerea tigarilor");
        }
    }
}
