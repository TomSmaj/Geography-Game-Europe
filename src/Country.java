import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import Game.ClickListener;

public class Country extends JLabel {

        String name;
        private BufferedImage nameImage, blank;
        boolean revealed = false;
        
        Hilight hob;

        public Country(String pic1, String pic2, String name, Hilight hob) throws IOException {
            this.name = name;

            nameImage = ImageIO.read(new File(pic1));
            blank = ImageIO.read(new File(pic2));
            
            this.hob = hob;
            
            //set image to pic2, which is a blank image
            setIcon(new ImageIcon(blank));
            addMouseListener(new ClickListener(this, this.hob));

        }
        
        public Country(String pic1) throws IOException {
        	nameImage = ImageIO.read(new File(pic1));
        	setIcon(new ImageIcon(nameImage));
        }

        public String getName() {
            return this.name;
        }

        public void setVisible() {
        	//set image to pic1, which is the country's name
        	setIcon(new ImageIcon(nameImage));
        	revealed = true;
        }
        

    }