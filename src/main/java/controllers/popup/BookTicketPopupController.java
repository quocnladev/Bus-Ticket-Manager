package controllers.popup;

import controllers.PrintOrderController;

import dao.CustomerDao;
import dao.EmployeeDao;
import dao.BookTicketDao;
import dao.ListBusDao;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import javax.swing.*;

import main.SessionManager;

import models.Employee;
import models.BookTicket;

import utils.BookTicketStatus;
import utils.BookTicketType;

import views.popup.AddOrderPopupView;
import views.popup.SelectCustomerPopupView;
import views.popup.SelectCarPopupView;
import views.popup.EditOrderPopupView;

public class BookTicketPopupController {

    BookTicketDao bookTicketDao = new BookTicketDao();

    EmployeeDao employeeDao = new EmployeeDao();
    CustomerDao customerDao = new CustomerDao();
    ListBusDao listBusDao = new ListBusDao();

    PrintOrderController printOrderController = new PrintOrderController();
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    JFrame previousView;

    public void updateAmount(EditOrderPopupView view, BookTicket bookTicket) {
        int ve =  (Integer) view.getSpnNumber().getValue();
        int price = bookTicket.getCar().getPrice();
        bookTicket.setTotalAmount(ve * price);

        view.getLbStatus().setText(bookTicket.getStatus().getName());
        view.getLbPaidAmount().setText(formatter.format(bookTicket.getPaidAmount()));
//        view.getLbFinalAmount().setText(formatter.format(bookTicket.getFinalAmount()));
       view.getLbTotalAmount().setText(formatter.format(bookTicket.getTotalAmount()));
    }

    public void add(AddOrderPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        BookTicket bookTicket = new BookTicket();

        for(BookTicketType bookTicketType : BookTicketType.values()){
            view.getCboType().addItem(bookTicketType.getName());
        }

        //customer
        view.getBtnSelectCustomer().addActionListener(evt -> {
            SelectCustomerPopupController selectCustomerPopupController = new SelectCustomerPopupController();
            selectCustomerPopupController.select( new SelectCustomerPopupView(), (customer -> {
                bookTicket.setCustomer(customer);
                view.getLbCustomerName().setText(customer.getName());
            }));
        });
        //car
        view.getBtnSelectCar().addActionListener(evt -> {
            SelectCarPopupController selectCarPopupController = new SelectCarPopupController();
            selectCarPopupController.select( new SelectCarPopupView(), (car -> {
                bookTicket.setCar(car);
                view.getLbCar().setText(car.getNhaxe() + "-" + car.getRoute().getDepart()+ "-" + car.getRoute().getDestination() + "-" + car.getPrice());
            }));
        });

        view.getBtnOK().addActionListener(evt -> {
            try {
                addOrder(view);
                view.dispose();
                view.showMessage("T???o h??a ????n th??nh c??ng!");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public boolean addOrder(AddOrderPopupView view) throws Exception {
        Employee employee = SessionManager.getSession().getEmployee();
        BookTicketType type = BookTicketType.getByName(view.getCboType().getSelectedItem().toString());
        BookTicketStatus status = BookTicketStatus.UNPAID;

        if (employee ==null ) {
            throw new Exception("B???n ch??a ????ng nh???p");
        }

        BookTicket t = new BookTicket();
        t.setEmployee(employee);
//      //bookTicket.setEmployee(employeeDao.getAll().get(0));
        t.setType(type);
        t.setCustomer(customerDao.getAll().get(1));
        t.setCar(listBusDao.getAll().get(0));
        t.setOrderDate(Timestamp.valueOf(LocalDateTime.now()));
        t.setStatus(status);

        bookTicketDao.save(t);
        return true;
    }

    public void editOrder(EditOrderPopupView view, BookTicket t) throws Exception {
        if (t.getEmployee() == null) {
            throw new Exception("Ch???n nh??n vi??n");
        }
        if (t.getPaidAmount() == t.getTotalAmount()) {
            t.setStatus(BookTicketStatus.PAID);
        }

        if (t.getPaidAmount() <= 0 || t.getTotalAmount() < t.getPaidAmount()) {// Ch??a thanh to??n
            t.setStatus(BookTicketStatus.UNPAID);
        } else if (t.getStatus() == BookTicketStatus.UNPAID) {
            // Thanh to??n
            t.setStatus(BookTicketStatus.PAID);
        }

        bookTicketDao.update(t);
//        return true;
    }

    public void edit(EditOrderPopupView view, BookTicket ticket, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        Employee currentLogin = SessionManager.getSession().getEmployee();
        if (ticket.getEmployee() == null) {
            ticket.setEmployee(currentLogin);
        }
        if (!ticket.getEmployee().equals(currentLogin) && ticket.getEmployee().getPermission().compare(currentLogin.getPermission()) > 0) {
            ec.onError(new Exception("B???n kh??ng c?? quy???n s???a h??a ????n n??y"));
            view.dispose();
            return;
        }
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        if (ticket.getEmployee() != null) {
            view.getLbEmployeeName().setText(ticket.getEmployee().getName());
        }
        view.getLbIdOrder().setText(ticket.getId() + "");
        try {

            for (BookTicketType ot : BookTicketType.values()) { // Hi???n th??? lo???i h??a ????n
                view.getCboType().addItem(ot.getName());
            }
            view.getCboType().setSelectedItem(ticket.getType().getName());

            for(BookTicketStatus bookTicketStatus : BookTicketStatus.values()){
                view.getCboStatus().addItem(bookTicketStatus.getName());
            }
            view.getCboStatus().setSelectedItem(ticket.getType().getName());

            //customer
            view.getBtnSelectCustomer().addActionListener(evt -> {
                SelectCustomerPopupController selectCustomerPopupController = new SelectCustomerPopupController();
                selectCustomerPopupController.select( new SelectCustomerPopupView(), (customer -> {
                    ticket.setCustomer(customer);
                    view.getLbCustomerName().setText(customer.getName());
                }));
            });
            //car
            view.getBtnSelectCar().addActionListener(evt -> {
                SelectCarPopupController selectCarPopupController = new SelectCarPopupController();
                selectCarPopupController.select( new SelectCarPopupView(), (car -> {
                    ticket.setCar(car);
                    view.getLbCar().setText(car.getNhaxe() + "-" + car.getRoute().getDepart()+ "-" + car.getRoute().getDestination() + "-" + car.getPrice());
                }));
            });

        } catch (Exception e) {
            view.dispose();
            ec.onError(e);
            return;
        }
        updateAmount(view, ticket);
        view.getBtnOK().setText("C???p nh???t");
        view.getCboType().addActionListener(evt -> {
            ticket.setType(BookTicketType.getByName(view.getCboType().getSelectedItem().toString()));
        });
        view.getCboStatus().addActionListener(evt -> {
            ticket.setStatus(BookTicketStatus.getByName(view.getCboStatus().getSelectedItem().toString()));
        });

        view.getBtnOK().addActionListener(evt -> {
            try {
                editOrder(view, ticket);
//                view.dispose();
                view.showMessage("S???a h??a ????n th??nh c??ng!");
                updateAmount(view, ticket);
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

        view.getBtnPaid().addActionListener(evt -> {
            try {
                String rawInput = JOptionPane.showInputDialog(null, "Nh???p s??? ti???n thanh to??n!", ticket.getPaidAmount());
                if (rawInput == null) {
                    return;
                }
                int paidAmount = Integer.parseInt(rawInput);
                if (ticket.getPaidAmount() > paidAmount) {
                    JOptionPane.showMessageDialog(null, "B???n c??n ph???i thanh to??n " + formatter.format(ticket.getPaidAmount() - paidAmount) + " VND");
                } else {
                    JOptionPane.showMessageDialog(null, "B???n ???? thanh to??n xong");
                }
                ticket.setPaidAmount(paidAmount);
                updateAmount(view, ticket);
            } catch (Exception e) {
                ec.onError(e);
            }
        });

        view.getBtnPrintOrder().addActionListener(evt -> {
            try {
                printOrderController.print(ticket.getId());
            } catch (Exception e) {
                view.showError("Kh??ng th??? in h??a ????n");
            }
        });

        view.getBtnCancelOrder().addActionListener(evt -> {
            try {
                int value = JOptionPane.showConfirmDialog(null, "B???n c?? ch???c mu???n h???y h??a ????n?");
                if (value != JOptionPane.YES_OPTION) {
                    return;
                }
                ticket.setStatus(BookTicketStatus.CANCEL);
                bookTicketDao.update(ticket);
                view.dispose();
                sc.onSuccess();
            } catch (Exception e) {
                view.showError(e);
            }
        });

    }
}
