package com.svsa.dashboard.dao;

import com.svsa.dashboard.dao.database.DatabaseConnection;
import com.svsa.dashboard.entities.Unit;
import com.svsa.dashboard.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UnitDAO {

    public List<Unit> getActiveUnits() throws SQLException {

        List<Unit> units = new ArrayList<>();
        String sql = "SELECT * FROM unidade WHERE tenant_id = 1 AND codigo NOT IN (1, 8, 9, 12, 19, 20)";

        try{
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next())
                throw new EntityNotFoundException("Nenhuma unidade ativa encontrada.");

            do {
                units.add(new Unit(
                        resultSet.getLong("codigo"),
                        resultSet.getString("nome")
                ));
            } while (resultSet.next());

        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }

        return units;
    }
}
