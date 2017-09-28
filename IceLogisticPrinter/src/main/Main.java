package main;

import file.SomeFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Main {

    public static void main(String... args) {
        SomeFile excel = null;
        String json = "";
        Property property = new Property(Constants.CONFIGS_URL);
        JFileChooser fileOpen = new JFileChooser();
        int ret = fileOpen.showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            excel = new SomeFile(fileOpen.getSelectedFile());
        }
        ImportFromExcel im = new ImportFromExcel();
        List<Info> list = im.getItemList(excel, property.getCarMap());
        if (!list.isEmpty()) {
            for (Info info : list) {
                System.out.println(info.getName() + " || " + info.getCarNumber() + " || " + info.getCar() + " || " + info.getNumber());
                Printer printer = new Printer(property.getxShift(), property.getyShift(), info);
                printer.printAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            Printer printer = new Printer(property.getxShift(), property.getyShift(), null);
            printer.printAll();
        }
    }
}
