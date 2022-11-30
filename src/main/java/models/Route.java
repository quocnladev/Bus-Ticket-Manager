package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Route extends Model {

    private int id;
    private String depart, destination, length;

    public Route() {    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getDepart(){return depart;}

    public void setDepart(String depart){this.depart = depart;}

    public String getDestination(){return destination;}

    public void setDestination(String destination){this.destination = destination;}

    public String getLength(){return length;}

    public void setLength(String length){this.length = length;}

    public static Route getFromResultSet(ResultSet rs) throws SQLException {
        Route r = new Route();
        r.setId(rs.getInt("id"));
        r.setDepart(rs.getNString("depart"));
        r.setDestination(rs.getNString("destination"));
        r.setLength(rs.getNString("length"));
        return r;
    }

    @Override
    public String toString() {
        return "Route{" + "id=" + id + "depart=" + depart + ", destination=" + destination + ", length=" + length + '}';
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
                this.getId(), this.getDepart(), this.getDestination(), this.getLength()
        };
    }

}