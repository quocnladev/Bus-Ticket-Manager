package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.ListBus;

public class ListBusDao extends Dao<ListBus> {

    ListBus listBusDao = new ListBus();
    DriverDao driverDao = new DriverDao();
    RouteDao routeDao = new RouteDao();
    TimeDao timeDao = new TimeDao();

    @Override
    public ArrayList<ListBus> getAll() throws SQLException {
        ArrayList<ListBus> listBuss = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `list_bus`";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ListBus listbus = ListBus.getFromResultSet(rs);
            listbus.setDriver(driverDao.get(listbus.getIdDriver()));
            listbus.setRoute(routeDao.get(listbus.getIdRoute()));
            listbus.setTime(timeDao.get(listbus.getIdTime()));
            listBuss.add(listbus);
        }
        return listBuss;
    }

    @Override
    public ListBus get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `list_bus` WHERE `id` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            ListBus listbus = ListBus.getFromResultSet(rs);
            listbus.setDriver(driverDao.get(listbus.getIdDriver()));
            listbus.setRoute(routeDao.get(listbus.getIdRoute()));
            listbus.setTime(timeDao.get(listbus.getIdTime()));
            return listbus;
        }
        return null;
    }

    @Override
    public void save(ListBus t) throws SQLException {
        if (t == null) {
            throw new SQLException("listbus rỗng");
        }
        String query = "INSERT INTO `list_bus` (`bienxe`, `nhaxe`, `type`, `price`, `number`, `idDriver`, `idRoute`, `idTime`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getBienxe());
        stmt.setNString(2, t.getNhaxe());
        stmt.setNString(3, t.getType().getId());
        stmt.setInt(4, t.getPrice());
        stmt.setInt(5, t.getNumber());
        stmt.setInt(6, t.getIdDriver());
        stmt.setInt(7, t.getIdRoute());
        stmt.setInt(8, t.getIdTime());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(ListBus t) throws SQLException {
        if (t == null) {
            throw new SQLException("listbus rỗng");
        }
        String query = "UPDATE `list_bus` SET `bienxe` = ?, `nhaxe` = ?, `type` = ?, `price` = ?, `number` =?, `idDriver` =?, `idRoute` =?, `idTime` =? WHERE `id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setNString(1, t.getBienxe());
        stmt.setNString(2, t.getNhaxe());
        stmt.setNString(3, t.getType().getId());
        stmt.setInt(4, t.getPrice());
        stmt.setInt(5, t.getNumber());
        stmt.setInt(6, t.getIdDriver());
        stmt.setInt(7, t.getIdRoute());
        stmt.setInt(8, t.getIdTime());
        stmt.setInt(9, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(ListBus t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `list_bus` WHERE `id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `list_bus` WHERE `id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ArrayList<ListBus> getById(int id) throws  SQLException{
        ArrayList<ListBus> listBuses = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT price FROM `list_bus` WHERE `id` = " + id + "DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ListBus lb = ListBus.getFromResultSet(rs);
            lb.setPrice(listBusDao.getPrice());
            listBuses.add(lb);
        }
        return listBuses;
    }

    public ListBus findByName(String bienxe) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `list_bus` WHERE `bienxe` = '" + bienxe + "'";
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            ListBus listbus = ListBus.getFromResultSet(rs);
            return listbus;
        }
        return null;
    }

    public ArrayList<ListBus> searchByKey(String key, String word) throws SQLException {
        ArrayList<ListBus> listBuss = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `list_bus` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            ListBus listbus = ListBus.getFromResultSet(rs);
            listBuss.add(listbus);
        }
        return listBuss;
    }

}
