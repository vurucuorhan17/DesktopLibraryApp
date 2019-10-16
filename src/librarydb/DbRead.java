/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarydb;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author orhan
 */
public class DbRead 
{
    XSSFWorkbook workbook;
    XSSFRow row;
    Sheet sheet;
    Cell cell;
    private ArrayList<DbItem> items;
    
    public DbRead(){
        try {
            workbook = new XSSFWorkbook(new FileInputStream(new File("veritabanı.xlsx")));
        } catch(Throwable th){
            System.err.println("An error occurred due to read file");
            th.printStackTrace();
            return;
        }
        init();
    }
    
    private void init(){
        
        items = new ArrayList<DbItem>();
        
        //FormulaEvaluator fe = workbook.getCreationHelper().createFormulaEvaluator();
        
        sheet = workbook.getSheet("LibraryDB");
        
            for(int j = 1;j < sheet.getPhysicalNumberOfRows();j++){
                
                Row temp = sheet.getRow(j);
                
                if(temp == null || temp.getCell(0).getStringCellValue().length() < 1){
                    continue;
                }
                
                row = (XSSFRow) temp;
                
                
                DbItem item = new DbItem();
                
                for(int i = 0; i < 14;i++){
                    
                    cell = row.getCell(i);
                    
                    switch(i){
                        case 0:
                            item.uyeno = cell.getStringCellValue();
                            break;
                        case 1:
                            item.uye_adi = cell.getStringCellValue();
                            break;
                        case 2:
                            item.uye_soyadi = cell.getStringCellValue();
                            break;
                        case 3:
                            item.uye_cinsiyeti = cell.getStringCellValue();
                            break;
                        case 4:
                            item.kitapKodu = cell.getStringCellValue();
                            break;
                        case 5:
                            item.kitapAdi = cell.getStringCellValue();
                            break;
                        case 6:
                            item.kitapTuru = cell.getStringCellValue();
                            break;
                        case 7:
                            item.kitap_yayinevi = cell.getStringCellValue();
                            break;
                        case 8:
                            item.yazar_no = cell.getStringCellValue();
                            break;
                        case 9:
                            item.yazar_adi = cell.getStringCellValue();
                            break;
                        case 10:
                            item.yazar_soyadi = cell.getStringCellValue();
                            break;
                        case 11:
                            item.yazar_cinsiyeti = cell.getStringCellValue();
                            break;
                        case 12:
                            item.odunc_tarihi = cell.getStringCellValue();
                            break;
                        case 13:
                            item.teslim_tarihi = cell.getStringCellValue();
                            break;
                    }
                }
                
                items.add(item);
            }
        
    }
    
    public ArrayList<DbItem> getItemList(){
        return items;
    }
    
    public class DbItem {
        public String uyeno;
        public String uye_adi;
        public String uye_soyadi;
        public String uye_cinsiyeti;
        public String kitapKodu;
        public String kitapAdi;
        public String kitapTuru;
        public String kitap_yayinevi;
        public String yazar_no;
        public String yazar_adi;
        public String yazar_soyadi;
        public String yazar_cinsiyeti;
        public String odunc_tarihi;
        public String teslim_tarihi;
    }
    
}
