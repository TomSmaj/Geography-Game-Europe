import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

//import Game.Square;

public class ClickListener extends MouseAdapter {

        private Country ob;
        private Hilight ob2;

        public ClickListener(Country newCountry, Hilight newHilight) {
            ob = newCountry;
            ob2 = newHilight;
        }

        public void mouseClicked(MouseEvent e) {
        	if(!ob.revealed) {
        		String s = (String)JOptionPane.showInputDialog(null, "Enter the image's name.");
        		if(s.equals(ob.name)) {ob.setVisible();}
        		else {JOptionPane.showMessageDialog(null, "Incorrect");}
        	}
        }
        
        public void mouseEntered(MouseEvent e) {
        	if(!ob.revealed) {ob2.setVisible();}
        }
        
        public void mouseExited(MouseEvent e) {
        	ob2.setInvisible();
        }

    }