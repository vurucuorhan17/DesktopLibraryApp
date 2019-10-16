/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarydb;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author orhan
 */
public class DbWrite {
    
    public static final String FILE_NAME = "veritabanı.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    
    public DbWrite(JComboBox cb1,JComboBox cb2,JTextField jtf1,JTextField jtf2,JTextField jtf3,JTextField jtf4,JTextField jtf5,JTextField jtf6,JTextField jtf7,JTextField jtf8,
                   JTextField jtf9,JTextField jtf10,JTextField jtf11,JTextField jtf12)
    {
        workbook = new XSSFWorkbook();
    
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList(LibraryDB.TABLE_TITLES));
        
        /*int x=0;
        while(x<6)
        {
            sheet = workbook.getSheet("LibraryDB");
            row = sheet.createRow(0);
            for(int i=0;i<14;i++)
            {
                cell = row.createCell(i, CellType.STRING);
                cell.setCellValue(list2.get(i));
                
            }
            x++;
        }*/
        
            try {
                workbook = new XSSFWorkbook(new FileInputStream(new File(FILE_NAME)));
            } catch(Throwable th){
                th.printStackTrace();
            }
            
            sheet = workbook.getSheet("LibraryDB");
            row = sheet.createRow(sheet.getLastRowNum()+1);
            
            String üye_cinsiyet = cb2.getSelectedItem().toString();
            String yazar_cinsiyet = cb1.getSelectedItem().toString();
            
            DataFormat format = null;
            CellStyle style = null;
            for(int i = 0;i < list2.size();i++){
                cell = row.createCell(i);
                
                switch(i){
                    case 0:
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(jtf7.getText());
                        break;
                    case 1:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(jtf1.getText());
                        break;
                    case 2:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(jtf2.getText());
                        break;
                    case 3:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(üye_cinsiyet);
                        break;
                    case 4:
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(jtf4.getText());
                        break;
                    case 5:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(jtf5.getText());
                        break;
                    case 6:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(jtf6.getText());
                        break;
                    case 7:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(jtf8.getText());
                        break;
                    case 8:
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(jtf3.getText());
                        break;
                    case 9:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(jtf9.getText());
                        break;
                    case 10:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(jtf10.getText());
                        break;
                    case 11:
                        cell.setCellType(CellType.STRING);
                        cell.setCellValue(yazar_cinsiyet);
                        break;
                    case 12:
                        format = workbook.createDataFormat();
                        style = workbook.createCellStyle();
                        style.setDataFormat(format.getFormat("dd.mm.yyyy"));
                        cell.setCellStyle(style);
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(jtf11.getText());
                        break;
                    case 13:
                        format = workbook.createDataFormat();
                        style = workbook.createCellStyle();
                        style.setDataFormat(format.getFormat("dd.mm.yyyy"));
                        cell.setCellStyle(style);
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(jtf12.getText());
                        break;
                }
            }
        
        try
        {
            workbook.write(new FileOutputStream(new File(FILE_NAME)));
            workbook.close();
        }
        catch(Throwable th)
        {
            th.printStackTrace();
        }
        
    }
    
}
