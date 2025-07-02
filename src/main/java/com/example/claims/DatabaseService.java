package com.example.claims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseService {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DatabaseService(Connection connection) {
        this.connection = connection;
    }

    public boolean readClaimData(String tripControlNumber) throws SQLException {
        String query = "SELECT * FROM claims WHERE trip_control_number = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, tripControlNumber);
        resultSet = preparedStatement.executeQuery();
        return processResultSet();
    }

    private boolean processResultSet() throws SQLException {
        while (resultSet.next()) {
            String reclaimCode = resultSet.getString("CHP05_RECLAIM_CODE_EXT");
            if (isEndOfFile(reclaimCode)) {
                return false;
            }
            // Additional processing logic can be added here
        }
        return true;
    }

    private boolean isEndOfFile(String reclaimCode) {
        return reclaimCode == null || reclaimCode.isEmpty();
    }

    public void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}