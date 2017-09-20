package main;


import file.FileType;
import file.SomeFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class ImportFromExcel {
    
    private Workbook book;
    
    public List<Info> getItemList(SomeFile file) {
        List<Info> list = new ArrayList<>();
        try {
            InputStream in = new FileInputStream(file.getFile());
            switch(file.getFileType()) {
                case XLSX: this.book = new XSSFWorkbook(in); break;
                case XLS: this.book = new HSSFWorkbook(in); break;
                default : return list;
            }
            in.close();
            Sheet sheet = book.getSheetAt(0);
            int i = 2;
            while(!sheet.getRow(i).getCell(2).getStringCellValue().equals("")) {
                //Проверка строки
                try {
                    Integer.valueOf(sheet.getRow(i).getCell(2).getStringCellValue());
                    break;
                } catch(Exception e) {}
                if(sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("айслогистик")) {
                    list.add(new Info(sheet.getRow(i).getCell(3).getStringCellValue(),sheet.getRow(i).getCell(5).getStringCellValue(),sheet.getRow(i).getCell(7).getNumericCellValue()));
                }
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportFromExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportFromExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
