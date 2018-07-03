import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import Game.ClickListener;

public class Country extends JLabel {

        String name;
        private BufferedImage myPic1, myPic2;
        boolean revealed = false;

        public Country(String pic1, String pic2, String name) throws IOException {
            this.name = name;

            myPic1 = ImageIO.read(new File(pic1));
            myPic2 = ImageIO.read(new File(pic2));
            
            //set image to pic2, which is a blank image
            setIcon(new ImageIcon(myPic2));
            addMouseListener(new ClickListener(this));

        }
        
        public Country(String pic1) throws IOException {
        	myPic1 = ImageIO.read(new File(pic1));
        	setIcon(new ImageIcon(myPic1));
        }

        public String getName() {
            return this.name;
        }

        public void setVisible() {
        	//set image to pic1, which is the country's name
        	setIcon(new ImageIcon(myPic1));
        	revealed = true;
        }
    }