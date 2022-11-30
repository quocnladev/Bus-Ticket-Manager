package dao;

import models.Time;
import org.apache.poi.ss.formula.functions.T;

import java.sql.*;
import java.util.ArrayList;

public class TimeDao extends Dao<Time> {

    @Override
    public ArrayList<Time> getAll() throws SQLException {
        ArrayList<Time> times = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `time`  ORDER BY `time`.`startTime` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Time time = Time.getFromResultSet(rs);
            times.add(time);
        }
        return times;
    }

    @Override
    public Time get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `time` WHERE `id` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Time time = Time.getFromResultSet(rs);
            return time;
        }
        return null;
    }

    public ArrayList<Time> getSession(int id) throws SQLException {
        ArrayList<Time> times = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `time` ORDER BY `time`.`startTime` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Time time = Time.getFromResultSet(rs);
            times.add(time);
        }
        return times;
    }

    @Override
    public void save(Time t) throws SQLException {
        if (t == null) {
            throw new SQLException("Time rỗng");
        }
        String query = "INSERT INTO `time` (`startTime`, `endTime`) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setTimestamp(1, t.getStartTime());
        stmt.setTimestamp(2, t.getEndTime());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Time t) throws SQLException {
        if (t == null) {
            throw new SQLException("Time rỗng");
        }
        String query = "UPDATE `time` SET `startTime` = ?, `endTime` = ? WHERE `time`.`id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setTimestamp(1, t.getStartTime());
        stmt.setTimestamp(2, t.getEndTime());
        stmt.setInt(3, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(Time t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `time` WHERE `time`.`id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<Time> searchByKey(String key, String word) throws SQLException {
        ArrayList<Time> times = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `time` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Time time = Time.getFromResultSet(rs);
            times.add(time);
        }
        return times;
    }
//    public ArrayList<Time> getAll(Timestamp start, Timestamp end) throws SQLException {
//        ArrayList<Time> times = new ArrayList<>();
//        String query = "SELECT * FROM `time` WHERE  DATE(startTime) >= DATE(?) AND DATE(startTime) <= DATE(?) ORDER BY `time`.`startTime` DESC";
//        PreparedStatement statement = conn.prepareStatement(query);
//        statement.setNString(1, "logout");
//        statement.setTimestamp(2, start);
//        statement.setTimestamp(3, end);
//        ResultSet rs = statement.executeQuery();
//        while (rs.next()) {
//            Time time = Time.getFromResultSet(rs);
//            times.add(time);
//        }
//        return times;
//    }

}
