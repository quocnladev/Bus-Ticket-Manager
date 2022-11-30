package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.BookTicket;
import utils.BookTicketStatus;

public class BookTicketDao extends Dao<BookTicket> {

    EmployeeDao employeeDao = new EmployeeDao();
    CustomerDao customerDao = new CustomerDao();
    ListBusDao listBusDao = new ListBusDao();

    @Override
    public ArrayList<BookTicket> getAll() throws SQLException {
        ArrayList<BookTicket> tickets = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `book_tickets` ORDER BY `book_tickets`.`orderDate` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            BookTicket t = BookTicket.getFromResultSet(rs);
            t.setEmployee(employeeDao.get(t.getIdEmployee()));
            t.setCustomer(customerDao.get(t.getIdCustomer()));
            t.setCar(listBusDao.get(t.getIdCar()));
            tickets.add(t);
        }
        return tickets;
    }

    public ArrayList<BookTicket> getAll(int idEmployee) throws SQLException {
        ArrayList<BookTicket> tickets = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `book_tickets`  WHERE `idEmployee`= '" + idEmployee + "' ORDER BY `book_tickets`.`orderDate` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            BookTicket t = BookTicket.getFromResultSet(rs);
            t.setEmployee(employeeDao.get(t.getIdEmployee()));
            t.setCustomer(customerDao.get(t.getIdCustomer()));
            t.setCar(listBusDao.get(t.getIdCar()));
            tickets.add(t);
        }
        return tickets;
    }
    public ArrayList<BookTicket> getById(int id) throws SQLException {
        ArrayList<BookTicket> tickets = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `book_tickets`WHERE `id` = " + id + "  ORDER BY `book_tickets`.`id` DESC";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            BookTicket t = BookTicket.getFromResultSet(rs);
            t.setEmployee(employeeDao.get(t.getIdEmployee()));
            t.setCustomer(customerDao.get(t.getIdCustomer()));
            t.setCar(listBusDao.get(t.getIdCar()));
            tickets.add(t);
        }
        return tickets;
    }

    @Override
    public BookTicket get(int id) throws SQLException {
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `book_tickets` WHERE `id` = " + id;
        ResultSet rs = statement.executeQuery(query);
        if (rs.next()) {
            BookTicket t = BookTicket.getFromResultSet(rs);
            t.setEmployee(employeeDao.get(t.getIdEmployee()));
            t.setCustomer(customerDao.get(t.getIdCustomer()));
            t.setCar(listBusDao.get(t.getIdCar()));
            return t;
        }
        return null;
    }

    @Override
    public void save(BookTicket t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "INSERT INTO `book_tickets` (`idEmployee`, `idCustomer`, `idCar`, `type`, `status`, `orderDate`, `payDate`, `paidAmount`, `totalAmount`) VALUES (?, ?,?, ?, ?, current_timestamp(), NULL, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdEmployee());
        stmt.setInt(2, t.getIdCustomer());
        stmt.setInt(3, t.getIdCar());
        stmt.setNString(4, t.getType().getId());
        stmt.setNString(5, t.getStatus().getId());
        stmt.setInt(6, t.getPaidAmount());
        stmt.setInt(7, t.getTotalAmount());
        int row = stmt.executeUpdate();
    }

    @Override
    public void update(BookTicket t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "UPDATE `book_tickets` SET `idEmployee` = ?,`idCustomer` = ?, `idCar` = ?, `type` = ?, `status` = ?, `orderDate` = ?, `payDate` = ?,  `paidAmount` = ?, `totalAmount` = ? WHERE `book_tickets`.`id` = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdEmployee());
        stmt.setInt(2, t.getIdCustomer());
        stmt.setInt(3, t.getIdCar());
        stmt.setNString(4, t.getType().getId());
        stmt.setNString(5, t.getStatus().getId());
        stmt.setTimestamp(6, t.getOrderDate());
        stmt.setTimestamp(7, t.getPayDate());
        stmt.setInt(8, t.getPaidAmount());
        stmt.setInt(9, t.getTotalAmount());
        stmt.setInt(10, t.getId());
        int row = stmt.executeUpdate();
    }

    @Override
    public void delete(BookTicket t) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `book_tickets` WHERE `book_tickets`.`id` = ?");
        stmt.setInt(1, t.getId());
        stmt.executeUpdate();
    }

    @Override
    public void deleteById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `book_tickets` WHERE `book_tickets`.`id` = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }


    public ArrayList<BookTicket> searchByKey(String key, String word) throws SQLException {
        ArrayList<BookTicket> tickets = new ArrayList<>();
        Statement statement = conn.createStatement();
        String query = "SELECT * FROM `book_tickets` WHERE " + key + " LIKE '%" + word + "%';";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            BookTicket t = BookTicket.getFromResultSet(rs);
            t.setEmployee(employeeDao.get(t.getIdEmployee()));
            t.setCar(listBusDao.get(t.getIdCar()));
            t.setCustomer(customerDao.get(t.getIdCustomer()));
            tickets.add(t);
        }
        return tickets;
    }

    public void create(BookTicket t) throws SQLException {
        if (t == null) {
            throw new SQLException("Order rỗng");
        }
        String query = "INSERT INTO `book_tickets` (`idEmployee`, `idCustomer`, `idCar`, `type`, `status`, `orderDate`, `payDate`,  `paidAmount`, `totalAmount`) VALUES (?,?,?,?,?, ?, ?, ?, ?)";
//        `orderDate`, `payDate`,
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, t.getIdEmployee());
        stmt.setInt(2, t.getIdCustomer());
        stmt.setInt(3, t.getIdCar());
        stmt.setNString(4, t.getType().getId());
        stmt.setNString(5, t.getStatus().getId());
        stmt.setTimestamp(6, t.getOrderDate());
        stmt.setTimestamp(7, t.getPayDate());
        stmt.setInt(8, t.getPaidAmount());
        stmt.setInt(9, t.getTotalAmount());
        int row = stmt.executeUpdate();
    }

    public ArrayList<BookTicket> searchByKey(int idEmployee, String key, String word) throws SQLException {
        ArrayList<BookTicket> bookTickets = new ArrayList<>();
        String query = "SELECT * FROM `book_tickets` WHERE " + key + " LIKE ? AND idEmployee = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, String.format("%s%s%s", "%", word, "%"));
        statement.setInt(2, idEmployee);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            BookTicket ticket = BookTicket.getFromResultSet(rs);
            ticket.setEmployee(employeeDao.get(ticket.getIdEmployee()));
            bookTickets.add(ticket);
        }
        return bookTickets;
    }

    public BookTicket getRandom() throws SQLException {
        String query = "SELECT * FROM `book_tickets` WHERE status = ? ORDER BY RAND() LIMIT 1";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setNString(1, BookTicketStatus.UNPAID.getId());
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            BookTicket bookTicket = BookTicket.getFromResultSet(rs);
            bookTicket.setEmployee(employeeDao.get(bookTicket.getIdEmployee()));
            return bookTicket;
        }
        return null;
    }

}
