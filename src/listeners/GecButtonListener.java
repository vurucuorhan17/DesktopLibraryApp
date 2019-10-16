/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Tablo;

/**
 *
 * @author orhan
 */
public class GecButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent ae)
    {
        Tablo tbl = new Tablo();
        tbl.setVisible(true);
    }
}
