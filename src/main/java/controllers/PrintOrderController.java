package controllers;

import dao.BookTicketDao;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import models.BookTicket;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class PrintOrderController {

    XWPFDocument document;
    File bookTicketFile;
    String fileName;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public PrintOrderController() {
        document = new XWPFDocument();
        bookTicketFile = new File("D:\\Desktop\\BookTicket\\bookTicket.docx");
    }

    public void print(int id) throws Exception {
        bookTicketFile = new File("D:\\Desktop\\BookTicket\\bookTicket-" + id + ".docx");
        BookTicketDao bookTicketDao = new BookTicketDao();

        BookTicket bookTicket = bookTicketDao.get(id);
        ArrayList<BookTicket> tickets = bookTicketDao.getById(id);
        print(bookTicket, tickets);

    }


    public File getBookTicketFile() {
        return bookTicketFile;
    }

    public void setBookTicketFile(File bookTicketFile) {
        this.bookTicketFile = bookTicketFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void createHeader() {
        XWPFParagraph paragraph;
        XWPFRun run;
        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setText("Hóa Đơn");
        run.setBold(true);
        run.setColor("FF0000");
        run.setFontSize(30);
    }

    public void createHeaderInfo(BookTicket ticket) {
        XWPFParagraph paragraph;
        XWPFRun run;
        int fontSize = 12;
        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);

        run = paragraph.createRun();
        run.setText("Tên nhân viên: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setBold(true);
        run.setText(ticket.getEmployee().getName());
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Thời gian: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setBold(true);
        run.setText(dateFormat.format(new Date(ticket.getOrderDate().getTime())));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();
    }

    public void createBookTicketInfo(ArrayList<BookTicket> tickets) {
        XWPFParagraph paragraph;
        XWPFRun run;
        int fontSize = 14;
        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.LEFT);
        paragraph.setBorderTop(Borders.BIRDS);
        paragraph.setBorderBottom(Borders.BIRDS);
        run = paragraph.createRun();
        run.addBreak();
        for (BookTicket bookTicket : tickets) {
            int price = bookTicket.getCar().getPrice();
            run = paragraph.createRun();
            run.setFontSize(fontSize);
            run.setBold(true);
            run.setText(String.format("%s(%s)   %d(%s)   %dVND", price, bookTicket.getPaidAmount(), bookTicket.getTotalAmount(),
                    bookTicket.getCustomer().getName(), bookTicket.getOrderDate(),
                    bookTicket.getCar().getNhaxe(), bookTicket.getCar().getRoute().getDepart(), bookTicket.getCar().getRoute().getDestination()));
            run.addBreak();
        }
    }

    public void createPaidInfo(BookTicket order) {
        int fontSize = 12;
        XWPFParagraph paragraph;
        XWPFRun run;
        paragraph = document.createParagraph();
//        paragraph.setBorderBottom(Borders.BALLOONS_3_COLORS);
        paragraph.setAlignment(ParagraphAlignment.LEFT);

        run = paragraph.createRun();
        run.setText("Tổng tiển: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(formatter.format(order.getTotalAmount()));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Thanh toán: ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(formatter.format(order.getPaidAmount()));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
        run.addBreak();

        run = paragraph.createRun();
        run.setText("Ngày thanh toán ");
        run.setFontSize(fontSize);
        run = paragraph.createRun();
        run.setText(dateFormat.format(new Date(order.getPayDate().getTime())));
        run.setFontSize(fontSize);
        run.setColor("FF0000");
    }

    public void createFooter() {
        XWPFParagraph paragraph;
        XWPFRun run;
        paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        run = paragraph.createRun();
        run.setText("Cảm ơn quý khách!Hẹn gặp lại!");
        run.setItalic(true);
        run.setFontSize(10);
    }

    public void print(BookTicket bookTicket, ArrayList<BookTicket> tickets) throws Exception {
        FileOutputStream out = new FileOutputStream(bookTicketFile, false);
        createHeader();
        createHeaderInfo(bookTicket);
        createBookTicketInfo(tickets);
        createPaidInfo(bookTicket);
        createFooter();
        document.write(out);
        out.close();
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(bookTicketFile);
        }
    }

}
