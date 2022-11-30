package controllers.popup;

import dao.DriverDao;
import dao.ListBusDao;
import dao.RouteDao;
import dao.TimeDao;

import javax.swing.JFrame;

import models.ListBus;

import utils.BusTypes;

import views.popup.ListBusPopupView;
import views.popup.SelectDriverPopupView;
import views.popup.SelectRoutePopupView;
import views.popup.SelectTimePopupView;

public class ListBusPopupController {

    ListBusDao listBusDao = new ListBusDao();
    DriverDao driverDao = new DriverDao();
    RouteDao routeDao = new RouteDao();
    TimeDao timeDao = new TimeDao();
    JFrame previousView;

    public void add(ListBusPopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        ListBus listBus = new ListBus();

        for(BusTypes busType : BusTypes.values()){
            view.getCboType().addItem(busType.getName());
        }

        //driver
        view.getBtnSelectDriver().addActionListener(evt -> {
            SelectDriverPopupController selectDriverPopupController = new SelectDriverPopupController();
            selectDriverPopupController.select( new SelectDriverPopupView(), (driver -> {
                listBus.setDriver(driver);
                view.getLbDriverName().setText(driver.getName());
            }));
        });
        //route
        view.getBtnSelectRoute().addActionListener(evt -> {
            SelectRoutePopupController selectRoutePopupController = new SelectRoutePopupController();
            selectRoutePopupController.select( new SelectRoutePopupView(), (route -> {
                listBus.setRoute(route);
                view.getLbRoute().setText(route.getDepart() + " - " + route.getDestination());
            }));
        });
        //time
        view.getBtnSelectTime().addActionListener(evt -> {
            SelectTimePopupController selectTimePopupController = new SelectTimePopupController();
            selectTimePopupController.select( new SelectTimePopupView(), (time -> {
                listBus.setTime(time);
                view.getLbTime().setText(time.getStartTime().toString());
            }));
        });


        view.getBtnOK().addActionListener(evt -> {
            try {
                addListBus(view);
                view.dispose();
                view.showMessage("Thêm ds xe thành công!");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }

    public void edit(ListBusPopupView view, ListBus listBus, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());

        for(BusTypes busType : BusTypes.values()){
            view.getCboType().addItem(busType.getName());
        }

        try{
            view.getLbTitle().setText("Sửa ds xe - " + listBus.getId());

            if (view.getLbDriverName() != null){
                view.getLbDriverName().setText(listBus.getDriver().getName());
            }else{
                view.getLbDriverName().setText("Chưa chọn tài xế");
            }

            view.getTxtBienso().setText(listBus.getBienxe());
            view.getTxtNhaxe().setText(listBus.getNhaxe());
            view.getSpnPrice().setValue(listBus.getPrice());
            view.getSpnNumber().setValue(listBus.getNumber());
            view.getCboType().setSelectedItem(listBus.getType().getName());

            //driver
            view.getBtnSelectDriver().addActionListener(evt -> {
                SelectDriverPopupController selectDriverPopupController = new SelectDriverPopupController();
                selectDriverPopupController.select( new SelectDriverPopupView(), (driver -> {
                    listBus.setDriver(driver);
                    view.getLbDriverName().setText(driver.getName());
                }));
            });
            //route
            view.getBtnSelectRoute().addActionListener(evt -> {
                SelectRoutePopupController selectRoutePopupController = new SelectRoutePopupController();
                selectRoutePopupController.select( new SelectRoutePopupView(), (route -> {
                    listBus.setRoute((route));
                    view.getLbRoute().setText(route.getDepart() + " - " + route.getDestination());
                }));
            });
            //time
            view.getBtnSelectTime().addActionListener(evt -> {
                SelectTimePopupController selectTimePopupController = new SelectTimePopupController();
                selectTimePopupController.select( new SelectTimePopupView(), (time -> {
                    listBus.setTime((time));
                    view.getLbTime().setText(time.getStartTime().toString());
                }));
            });

            view.getBtnOK().setText("Cập nhật");
            view.getBtnOK().addActionListener(evt -> {
                try{
                    editListBus(view, listBus);
                    view.dispose();
                        view.showMessage("Sửa ds xe thành công!");
                        sc.onSuccess();
                    } catch (Exception ex) {
                        ec.onError(ex);
                }
            });
        } catch (Exception ex) {
                    ec.onError(ex);
            view.dispose();
        }
    }

    public boolean addListBus(ListBusPopupView view) throws Exception {
        String bienso = view.getTxtBienso().getText(),
                nhaxe = view.getTxtNhaxe().getText();
        int price = (int) view.getSpnPrice().getValue();
        int number = (int) view.getSpnNumber().getValue();

        if (bienso.isEmpty() || nhaxe.isEmpty()) {
            throw new Exception("Vui lòng điền đủ thông tin");
        }
        if (price < 0 || number < 0) {
            throw new Exception("Giá vé không thể âm");
        }
        if (listBusDao.findByName(bienso) != null) {
            throw new Exception("Biển số đã tồn tại");
        }

        ListBus lb = new ListBus();
        lb.setBienxe(bienso);
        lb.setNhaxe(nhaxe);
        lb.setPrice(price);
        lb.setNumber(number);
        lb.setType(BusTypes.getByName(view.getCboType().getSelectedItem().toString()));
        lb.setDriver(driverDao.getAll().get(0));
        lb.setRoute(routeDao.getAll().get(0));
        lb.setTime(timeDao.getAll().get(0));

        listBusDao.save(lb);
        return true;
    }

    public void editListBus(ListBusPopupView view, ListBus lb) throws Exception {
//        String bienso = view.getTxtBienso().getText(),
//                nhaxe = view.getTxtNhaxe().getText();
//        int price = (int) view.getSpnPrice().getValue();
//        int number = (int) view.getSpnNumber().getValue();
//
//        if (bienso.isEmpty() || nhaxe.isEmpty()) {
//            throw new Exception("Vui lòng điền đủ thông tin");
//        }
//        if (price < 0 || number < 0) {
//            throw new Exception("Giá tiền không thể âm");
//        }
//        if (listBusDao.findByName(bienso) != null) {
//            throw new Exception("Biển số đã tồn tại");
//        }
//        ListBus lb = new ListBus();
        lb.setBienxe(view.getTxtBienso().getText());
        lb.setNhaxe(view.getTxtNhaxe().getText());
        lb.setPrice((int) view.getSpnPrice().getValue());
        lb.setNumber((int) view.getSpnNumber().getValue());
        lb.setType(BusTypes.getByName(view.getCboType().getSelectedItem().toString()));

        listBusDao.update(lb);
        return;
    }
}