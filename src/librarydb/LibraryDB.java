/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarydb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import views.Kayit;
import views.Tablo;


/**
 *
 * @author orhan
 */
public class LibraryDB {
    
    public static class TarihThread implements Runnable
    {
        public void run()
        {
            try {
                fonk();
                ZamanYonetici zy = new ZamanYonetici();
            } catch (ParseException ex) {
                Logger.getLogger(LibraryDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static class KayitThread implements Runnable
    {
        public void run()
        {
            Kayit kyt = new Kayit();
            kyt.setVisible(true); 
        }
    }

    
    public static Object[][] oa;
    public static void fonk()
    {
        DbRead db = new DbRead();
        ArrayList<DbRead.DbItem> items = db.getItemList();
        if(items == null){
            oa = new Object[1][];
            Object[] arr = new Object[DbRead.DbItem.class.getFields().length];
            oa[0] = arr;
            return;
        }
        oa = new Object[items.size()][];
        for(int i = 0;i < items.size();i++){
            DbRead.DbItem read = items.get(i);
            Object[] arr = new Object[DbRead.DbItem.class.getFields().length];
            arr[0] = read.uyeno;
            arr[1] = read.uye_adi;
            arr[2] = read.uye_soyadi;
            arr[3] = read.uye_cinsiyeti;
            arr[4] = read.kitapKodu;
            arr[5] = read.kitapAdi;
            arr[6] = read.kitapTuru;
            arr[7] = read.kitap_yayinevi;
            arr[8] = read.yazar_no;
            arr[9] = read.yazar_adi;
            arr[10] = read.yazar_soyadi;
            arr[11] = read.yazar_cinsiyeti;
            arr[12] = read.odunc_tarihi;
            arr[13] = read.teslim_tarihi;
            oa[i] = arr;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        KayitThread kt = new KayitThread();
        Thread tk = new Thread(kt);
        tk.start();
        
        TarihThread tt = new TarihThread();
        Thread th = new Thread(tt);
        th.start();
        
        /*KayitThread kt = new KayitThread();
        Thread tk = new Thread(kt);
        tk.start();*/
        
    }
    
    public static String[] TABLE_TITLES = new String [] {
        "ÜYE NO", "ÜYE ADI", "ÜYE SOYADI","ÜYE CİNSİYETİ", "KİTAP KODU", 
        "KİTAP ADI", "KİTAP TÜRÜ", "KİTAP YAYINEVİ", "YAZAR NO",
        "YAZAR ADI","YAZAR SOYADI","YAZAR CİNSİYETİ","ÖDÜNÇ TARİHİ","TESLİM TARİHİ"
    };
    
    public static class ZamanYonetici
    {
        public ZamanYonetici() throws ParseException 
        {
            DbRead db = new DbRead();
            ArrayList<DbRead.DbItem> items = db.getItemList();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date date1 = new Date();
            Date date2 = new Date();
            Date date3 = new Date();
            long threeDay = 1000*60*60*24*3;
            date3.setTime(threeDay);
            for(int i=0;i<items.size();i++)
            {
                //System.out.println(a[i][7]);
                date2 = sdf.parse((String)oa[i][13]);
                if(date2.getTime()-date1.getTime()<=date3.getTime()&&date2.getTime()-date1.getTime()>0)
                {
                    JOptionPane optionPane = new JOptionPane("Üye No: "+oa[i][0]+"\nÜye Adı: "+oa[i][1]+"\n"+"Üye Soyadı: "+oa[i][2]+
                            "\nolan kişinin "+oa[i][12]+" tarihinde ödünç aldığı Kitap Kodu: " +oa[i][4]+" olan kitabı teslim etmesine 3 günden az kaldı.",
                            JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Uyarı");
                    dialog.setVisible(true);
                
                }
            }
               
        }
    } 
    
}