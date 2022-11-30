package dao;

import models.Route;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RouteDao extends Dao<Route> {

    @Override
    public ArrayList<Route> getAll() throws SQLException {
        ArrayList<Route> routes = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `route` ORDER BY `route`.`id` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Route route = Route.getFromResultSet(rs);
            routes.add(route);
        }
        return routes;
    }


    @Override
    public Route get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `route` WHERE `id` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            Route route = Route.getFromResultSet(rs);
            return route;
        }
        return null;
    }

    @Override
    public void save(Route t) throws SQLException {
        if (t == null) {
            throw new SQLException("Route rỗng");
        }
        String query = "INSERT INTO `route` (`depart`, `destination`, `length`) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getDepart());
        stmt.setNString(2, t.getDestination());
        stmt.setNString(3, t.getLength());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(Route t) throws SQLException {
        if (t == null) {
            throw new SQLException("Route rỗng");
        }
        String query = "UPDATE `route` SET `depart` = ?, `destination` = ?, `length` = ? WHERE `route`.`id` = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getDepart());
        stmt.setNString(2, t.getDestination());
        stmt.setNString(3, t.getLength());
        stmt.setInt(4, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(Route t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `route` WHERE `route`.`id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `route` WHERE `route`.`id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }


    public ArrayList<Route> searchByKey(String key, String word) throws SQLException {
        ArrayList<Route> routes = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `route` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            Route route = Route.getFromResultSet(rs);
            routes.add(route);
        }
        return routes;
    }

    public void create(Route t) throws SQLException {
        if (t == null) {
            throw new SQLException("route rỗng");
        }
        String query = "INSERT INTO `route` (`depart`, `destination`, `length`) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);

        int row = stmt.executeUpdate();
    }
}
