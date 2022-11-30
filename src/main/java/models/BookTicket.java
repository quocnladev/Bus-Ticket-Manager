package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import utils.BookTicketStatus;
import utils.BookTicketType;
import java.sql.Timestamp;

public class BookTicket extends Model {

    private int id, idEmployee, idCustomer, idCar;
    private BookTicketType type;
    private BookTicketStatus status;
    private Timestamp orderDate, payDate;
    private int paidAmount, totalAmount;
    private Employee employee;
    private Customer customer;
    private ListBus car;

    public BookTicket() {
        status = BookTicketStatus.UNPAID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }


    public BookTicketType getType() {
        return type;
    }

    public void setType(BookTicketType type) {
        this.type = type;
    }

    public BookTicketStatus getStatus() {
        return status;
    }

    public void setStatus(BookTicketStatus status) {
        this.status = status;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee( Employee employee) {
        this.employee = employee;
        this.idEmployee = employee.getId();
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        if (customer != null) {
            this.idCustomer = customer.getId();
        }
    }
    public ListBus getCar() {
        return car;
    }

    public void setCar(ListBus car) {
        this.car = car;
        if(car != null) {
            this.idCar = car.getId();
        }
    }


    public int getFinalAmount() {
        return totalAmount;
    }

    public static BookTicket getFromResultSet(ResultSet rs) throws SQLException {
        BookTicket o = new BookTicket();
        o.setId(rs.getInt("id"));
        o.setIdEmployee(rs.getInt("idEmployee"));
        o.setIdCustomer(rs.getInt("idCustomer"));
        o.setIdCar(rs.getInt("idCar"));
        o.setType(BookTicketType.getById(rs.getNString("type")));
        o.setStatus(BookTicketStatus.getById(rs.getNString("status")));
        o.setOrderDate(rs.getTimestamp("orderDate"));
        o.setPayDate(rs.getTimestamp("payDate"));
        o.setPaidAmount(rs.getInt("paidAmount"));
        o.setTotalAmount(rs.getInt("totalAmount"));

        return o;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", idEmployee=" + idEmployee + ", idCustomer=" + idCustomer+ ", idCar=" + idCar
                + ", type=" + type + ", status=" + status  + ", orderDate=" + orderDate + ", payDate=" + payDate
                + ", paidAmount=" + paidAmount + ", totalAmount=" + totalAmount + '}';

    }

    @Override
    public Object[] toRowTable() {
        return new Object[]{
            this.getId(), employee.getName(),
                customer.getName(),
                car.getNhaxe(), car.getRoute().getDepart() + "-" + car.getRoute().getDestination() , car.getPrice(),
                this.getType().getName(), this.getStatus().getName(),
                this.getOrderDate(), this.getPayDate(),
            String.format("%d/%d", this.getPaidAmount(), this.getFinalAmount())
        };
    }

}
