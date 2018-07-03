import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

//import Game.Square;

public class ClickListener extends MouseAdapter {

        private Country ob;

        public ClickListener(Country newCountry) {
            ob = newCountry;
        }

        public void mouseClicked(MouseEvent e) {
        	if(!ob.revealed) {
        		String s = (String)JOptionPane.showInputDialog(null, "Enter the image's name.");
        		if(s.equals(ob.name)) {ob.setVisible();}
        		else {JOptionPane.showMessageDialog(null, "Incorrect");}
        	}
        }

    }