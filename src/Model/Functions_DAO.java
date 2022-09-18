package Model;

import View.Screen_GUI;
import javax.swing.JOptionPane;

public class Functions_DAO {
    
    
    public static void meia(String seletor){
     if(seletor.equals("Meia-Meia")){
         View.Screen_GUI.Meia1_cb.setVisible(true);
         View.Screen_GUI.Meia2_cb.setVisible(true);
     }else{
         View.Screen_GUI.Meia1_cb.setVisible(false);
         View.Screen_GUI.Meia2_cb.setVisible(false);
     }
    }
}
