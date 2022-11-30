package controllers.popup;

import dao.DriverDao;
import models.Driver;
import views.popup.DriverPopupView;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.*;


public class DriverPopupController {

    DriverDao driverDao = new DriverDao();
    JFrame previousView;

    public void add(DriverPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getBtnOK().addActionListener(evt -> {
            try {
                addDriver(view);
                view.dispose();
                view.showMessage("Thêm tài xế thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }

    public void edit(DriverPopupView view, Driver driver, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getLbTitle().setText("Sửa tài xế - " + driver.getId());
        view.getTxtName().setText(driver.getName());
        view.getTxtPhoneNumber().setText(driver.getPhoneNumber());
        view.getTxtAddress().setText(driver.getAddress());
        view.getSpnSalary().setValue(driver.getSalary());
        if (driver.getStartDate() != null) {
            view.getCbUnknownStartDate().setSelected(false);
            view.getSpnStartDate().setValue(new Date(driver.getStartDate().getTime()));
        } else {
            view.getCbUnknownStartDate().setSelected(true);
        }
        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                editDriver(view, driver);
                view.dispose();
                view.showMessage("Sửa thông tin tài xế thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public void addDriver(DriverPopupView view) throws Exception {
        String name = view.getTxtName().getText(),
                phoneNumber = view.getTxtPhoneNumber().getText(),
                address = view.getTxtAddress().getText();

        int salary = (int) view.getSpnSalary().getValue();
        if (phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        if (salary < 0) {
            throw new Exception("Lương không thể âm");
        }
        Driver d = new Driver();

        d.setName(name);
        d.setPhoneNumber(phoneNumber);
        d.setAddress(address);
        d.setSalary(salary);
        if (!view.getCbUnknownStartDate().isSelected()) {
            Date dateUtil = (Date) view.getSpnStartDate().getValue();
            d.setStartDate(new Timestamp(dateUtil.getTime()));
        }
        driverDao.save(d);
        return;
    }

    public boolean editDriver(DriverPopupView view, Driver d) throws Exception {
        String name = view.getTxtName().getText(),
                phoneNumber = view.getTxtPhoneNumber().getText(),
                address = view.getTxtAddress().getText();

        int salary = (int) view.getSpnSalary().getValue();
        if (phoneNumber.isEmpty()) {
            throw new Exception("Vui lòng điền đầy đủ thông tin");
        }
        if (salary < 0) {
            throw new Exception("Lương không thể âm");
        }

        d.setName(name);
        d.setPhoneNumber(phoneNumber);
        d.setAddress(address);
        d.setSalary(salary);
        if (!view.getCbUnknownStartDate().isSelected()) {
            Date dateUtil = (Date) view.getSpnStartDate().getValue();
            d.setStartDate(new Timestamp(dateUtil.getTime()));
        }
        driverDao.update(d);
        return true;
    }
}
