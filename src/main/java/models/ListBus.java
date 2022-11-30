package models;

import utils.BusTypes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListBus extends Model {

    protected int id, idDriver, idRoute, idTime;
    protected String bienxe, nhaxe;
    private BusTypes type;
    protected int price, number;
    private Driver driver;
    private Route route;
    private Time time;


    public ListBus() {    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  int getIdDriver(){
        return idDriver;
    }

    public void setIdDriver(int idDriver){
        this.idDriver = idDriver;
    }
    public  int getIdRoute(){
        return idRoute;
    }
    public void setIdRoute(int idRoute){
        this.idRoute = idRoute;
    }
    public  int getIdTime(){
        return idTime;
    }
    public void setIdTime(int idTime){
        this.idTime = idTime;
    }
    public String getBienxe() {
        return bienxe;
    }
    public void setBienxe(String bienxe) {
        this.bienxe = bienxe;
    }
    public String getNhaxe() {
        return nhaxe;
    }
    public void setNhaxe(String nhaxe) {
        this.nhaxe = nhaxe;
    }

    public BusTypes getType() {
        return type;
    }

    public void setType(BusTypes type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Driver getDriver(){return driver;}

    public void setDriver(Driver driver){
        this.driver = driver;
        if(driver != null){
            this.idDriver = driver.getId();
        }
    }
    public Route getRoute(){return route;}

    public void setRoute(Route route){
        this.route = route;
        if(route != null){
            this.idRoute = route.getId();
        }
    }
    public Time getTime(){return time;}

    public void setTime(Time time){
        this.time = time;
        if(time != null){
            this.idTime = time.getId();
        }
    }

    @Override
    public String toString() {
        return bienxe;
    }

    public static ListBus getFromResultSet(ResultSet rs) throws SQLException {
        ListBus lb = new ListBus();
        lb.setId(rs.getInt("id"));
        lb.setBienxe(rs.getNString("bienxe"));
        lb.setNhaxe((rs.getNString("nhaxe")));
        lb.setType(BusTypes.getById(rs.getNString("type")));
        lb.setPrice(rs.getInt("price"));
        lb.setNumber(rs.getInt("number"));
        lb.setIdDriver(rs.getInt("idDriver"));
        lb.setIdRoute(rs.getInt("idRoute"));
        lb.setIdTime(rs.getInt("idTime"));
        return lb;
    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
                this.getId(), this.getBienxe(), this.getNhaxe(),
                this.getType().getName(), this.getPrice(), this.getNumber(),
                driver.getName(),
                route.getDepart() + "-" + route.getDestination(),
                time.getStartTime()
        };
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListBus other = (ListBus) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
