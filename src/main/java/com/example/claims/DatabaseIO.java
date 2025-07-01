package com.example.claims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseIO {
    private Connection connection;

    public DatabaseIO(String dbUrl, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, password);
    }

    public ResultSet readClaimData(String claimId) {
        if (claimId == null || claimId.isEmpty()) {
            throw new IllegalArgumentException("Claim ID cannot be null or empty");
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM claims WHERE claim_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, claimId);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            handleException(e);
        }
        return resultSet;
    }

    public ResultSet readClaimData(String claimId, String status) {
        if (claimId == null || claimId.isEmpty() || status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Claim ID and status cannot be null or empty");
        }
        ResultSet resultSet = null;
        String query = "SELECT * FROM claims WHERE claim_id = ? AND status = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, claimId);
            preparedStatement.setString(2, status);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            handleException(e);
        }
        return resultSet;
    }

    private void handleException(SQLException e) {
        System.err.println("Database operation failed: " + e.getMessage());
        throw new RuntimeException("Database operation failed", e);
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                handleException(e);
            }
        }
    }
}