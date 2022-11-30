package controllers.popup;

import dao.TimeDao;
import models.Time;
import views.popup.TimePopupView;

import java.sql.Timestamp;
import java.util.Date;

import javax.swing.*;

public class TimePopupController {

    TimeDao timeDao = new TimeDao();
    JFrame previousView;

    public void add(TimePopupView view, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getBtnOK().addActionListener(evt -> {
            try {
                addTime(view);
                view.dispose();
                view.showMessage("Thêm thời gian thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });
    }

    public void edit(TimePopupView view, Time time, SuccessCallback sc, ErrorCallback ec) {
        if (previousView != null && previousView.isDisplayable()) {
            previousView.requestFocus();
            return;
        }
        previousView = view;
        view.setVisible(true);
        view.getBtnCancel().addActionListener(evt -> view.dispose());
        view.getLbTitle().setText("Sửa thời gian - " + time.getId());

        if(time.getStartTime() != null){
            view.getSpnStartTime().setValue((new Date(time.getStartTime().getTime())));
        }else {
            view.getCbUnknownStartTime().setSelected(true);
        }

        if(time.getEndTime() != null){
            view.getSpnEndTime().setValue((new Date(time.getEndTime().getTime())));
        }else {
            view.getCbUnknownEndTime().setSelected(true);
        }

        view.getBtnOK().setText("Cập nhật");
        view.getBtnOK().addActionListener(evt -> {
            try {
                editTime(view, time);
                view.dispose();
                view.showMessage("Sửa thời gian thành công");
                sc.onSuccess();
            } catch (Exception ex) {
                ec.onError(ex);
            }
        });

    }

    public void addTime(TimePopupView view) throws Exception {
//        String startTime = view.getSpnStartTime().getTime(),
//                destination = view.getTxtDestination().getText(),
//                length = view.getTxtLength().getText();

        Time time = new Time();

        if (!view.getCbUnknownStartTime().isSelected()) {
            Date dateUtil = (Date) view.getSpnStartTime().getValue();
            time.setStartTime(new Timestamp(dateUtil.getTime()));
        }

        if (!view.getCbUnknownEndTime().isSelected()) {
            Date dateUtil = (Date) view.getSpnEndTime().getValue();
            time.setEndTime(new Timestamp(dateUtil.getTime()));
        }

        timeDao.save(time);
        return;
    }

    public boolean editTime(TimePopupView view, Time time) throws Exception {

        if (!view.getCbUnknownStartTime().isSelected()) {
            Date dateUtil = (Date) view.getSpnStartTime().getValue();
            time.setStartTime(new Timestamp(dateUtil.getTime()));
        }

        if (!view.getCbUnknownEndTime().isSelected()) {
            Date dateUtil = (Date) view.getSpnEndTime().getValue();
            time.setEndTime(new Timestamp(dateUtil.getTime()));
        }

        timeDao.update(time);
        return true;
    }
}
