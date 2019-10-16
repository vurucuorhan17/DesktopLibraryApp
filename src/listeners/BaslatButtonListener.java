/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import librarydb.DbWrite;


/**
 *
 * @author orhan
 */
public class BaslatButtonListener implements ActionListener
{
    JTextField jtf1;
    JTextField jtf2;
    JTextField jtf3;
    JTextField jtf4;
    JTextField jtf5;
    JTextField jtf6;
    JTextField jtf7;
    JTextField jtf8;
    JTextField jtf9;
    JTextField jtf10;
    JTextField jtf11;
    JTextField jtf12;
    JComboBox üye_cinsiyet;
    JComboBox yazar_cinsiyet;
    public BaslatButtonListener(JComboBox cb1,JComboBox cb2,JTextField jtf1,JTextField jtf2,JTextField jtf3,JTextField jtf4,JTextField jtf5,JTextField jtf6,JTextField jtf7,JTextField jtf8,
                                JTextField jtf9,JTextField jtf10,JTextField jtf11,JTextField jtf12)
    {
        this.jtf1 = jtf1;
        this.jtf2 = jtf2;
        this.jtf3 = jtf3;
        this.jtf4 = jtf4;
        this.jtf5 = jtf5;
        this.jtf6 = jtf6;
        this.jtf7 = jtf7;
        this.jtf8 = jtf8;
        this.jtf9 = jtf9;
        this.jtf10 = jtf10;
        this.jtf11 = jtf11;
        this.jtf12 = jtf12;
        this.üye_cinsiyet = cb2;
        this.yazar_cinsiyet = cb1;
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        DbWrite dw = new DbWrite(yazar_cinsiyet,üye_cinsiyet,jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12);
        
    }
    
    
}
