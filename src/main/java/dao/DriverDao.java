package dao;

import models.Driver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DriverDao extends Dao<Driver> {

    @Override
    public ArrayList<Driver> getAll() throws SQLException {
        ArrayList<Driver> drivers = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `driver`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Driver driver = Driver.getFromResultSet(rs);
            drivers.add(driver);
        }
        return drivers;
    }

    @Override
    public Driver get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `driver` WHERE id = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Driver driver = Driver.getFromResultSet(rs);
            return driver;
        }
        return null;
    }

    @Override
    public void save(Driver d) throws SQLException {
        if (d == null) {
            throw new SQLException("divers rỗng");
        }
        String query = "INSERT INTO `driver` (`name`, `phoneNumber`, `address`, `startDate`, `salary` ) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, d.getName());
        stmt.setNString(2, d.getPhoneNumber());
        stmt.setNString(3, d.getAddress());
        stmt.setTimestamp(4, d.getStartDate());
        stmt.setInt(5, d.getSalary());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Driver d) throws SQLException {
        if (d == null) {
            throw new SQLException("divers rỗng");
        }
        String query = "UPDATE `driver` SET `name` = ?, `phoneNumber` = ?, `address` = ?, `startDate` = ?, `salary` = ? WHERE `id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, d.getName());
        stmt.setNString(2, d.getPhoneNumber());
        stmt.setNString(3, d.getAddress());
        stmt.setTimestamp(4, d.getStartDate());
        stmt.setInt(5, d.getSalary());
        stmt.setInt(6, d.getId());
        int row = stmt.executeUpdate();

    }

    @Override
    public void delete(Driver t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `driver` WHERE `id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();

    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `driver` WHERE `id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<Driver> searchByKey(String key, String word) throws SQLException {
        ArrayList<Driver> drivers = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `driver` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Driver driver = Driver.getFromResultSet(rs);
            drivers.add(driver);
        }
        return drivers;
    }

}
