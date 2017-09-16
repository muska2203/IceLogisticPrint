
import file.SomeFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
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
        float xShift = 0;
        float yShift = 0;
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/resourses/configs.properties");
            properties.load(fis);
            fis.close();
            xShift = Float.valueOf(properties.getProperty("xShift"));
            yShift = Float.valueOf(properties.getProperty("yShift"));
        } catch(IOException e) {
            System.err.println("Файл не существует");
        }
        //Printer.printAll(xShift, yShift);
        JFileChooser fileOpen = new JFileChooser();
        int ret = fileOpen.showOpenDialog(null);
        if(ret == JFileChooser.APPROVE_OPTION) {
            excel = new SomeFile(fileOpen.getSelectedFile());
        }
        ImportFromExcel im = new ImportFromExcel();
        List<Info> list = im.getItemList(excel);
        if(!list.isEmpty()) {
//            for(Info info : list) {
//                System.out.println(info.getName()+" || "+info.getCarNumber()+" || "+info.getNumber());
//                Printer printer = new Printer(xShift,yShift,info);
//                printer.printAll();
//            }
Printer printer = new Printer(xShift,yShift,list.get(0));
printer.printAll();
        } else {
            Printer printer = new Printer(xShift,yShift,null);
            printer.printAll();
        }
    }
} 
