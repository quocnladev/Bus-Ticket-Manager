package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


public class Driver extends Model {

    protected int id;
    protected String phoneNumber, name, address;

    protected Timestamp startDate;
    protected int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = Math.max(0, salary);
    }

    @Override
    public String toString() {
        return name + "\nSDT: " + phoneNumber + "\nĐC: " + address;
    }

    public static Driver getFromResultSet(ResultSet rs) throws SQLException {
        Driver d = new Driver();
        d.setId(rs.getInt("id"));
        d.setName(rs.getNString("name"));
        d.setPhoneNumber(rs.getString("phoneNumber"));
        d.setAddress(rs.getString("address"));
        d.setStartDate(rs.getTimestamp("startDate"));
        d.setSalary(rs.getInt("salary"));
        return d;
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
                id, name,
                phoneNumber, address, startDate,
                salary
        };
    }

}
