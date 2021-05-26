package repository.actionsImpl;


import Model.Bautura;
import repository.actions.BauturaRepository;
import utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Queries.*;

public class BauturaRepositoryImpl implements BauturaRepository {
    private DbConnection dbConnection = DbConnection.getInstance();

    @Override
    public List<Bautura> getAllBautura() {
        List<Bautura> bauturi = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(GET_ALL_BAUTURA);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bautura b = new Bautura(resultSet.getString(1), resultSet.getInt(2), resultSet.getFloat(3));
                bauturi.add(b);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bauturi;
    }

    @Override
    public void addBautura(Bautura b) {
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(INSERT_NEW_BAUTURA);
            preparedStatement.setString(1, b.getNume());
            preparedStatement.setInt(2, b.getPret());
            preparedStatement.setFloat(3, b.getAlcoolemie());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la adaugarea bauturii");
        }
    }

    @Override
    public void editBautura(Bautura b, int p){
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(EDIT_BAUTURA);
            preparedStatement.setInt(1, p);
            preparedStatement.setString(2, b.getNume());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la editarea pretului bauturii");
        }
    }

    @Override
    public void deleteBautura(Bautura b) {
        try{
            PreparedStatement preparedStatement = dbConnection.getDBConnection().prepareStatement(DELETE_BAUTURA);
            preparedStatement.setString(1, b.getNume().toLowerCase());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Eroare la stergerea bauturii");
        }
    }
}
