import java.awt.Container;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class GamePane extends JPanel {

		SpringLayout layout = new SpringLayout();
		Country[] coun = new Country[39]; //object array of 39 country objects (38 country objects and the map)
		
		//austria(2).png being used as the blank image for each country object
		String blank = "images\\\\Austria(2).png";
		
		//array of country names (the answer the user has to type in)
		String[] clist = {
				"albania", "austria", "belarus", "belgium", "bosnia and herzegovina", "bulgaria", "croatia", "czech republic", 
				"denmark", "estonia", "finland", "france", "germany", "greece", "hungary", "iceland", "ireland",
				"italy", "latvia", "lithuania", "luxembourg", "macedonia", "moldova", "montenegro", "netherlands",
				"norway", "poland", "portugal", "romania", "russia", "serbia", "slovakia", "slovenia", "spain",
				"sweden", "switzerland", "ukraine", "united kingdom", "map"
				};
		//array of country image links
		String[] llist = {
				"images\\Albania.png", "images\\Austria.png", "images\\Belarus.png",
				"images\\Belgium.png", "images\\Bosn-Herze.png", "images\\Bulgaria.png",
				"images\\Croatia.png", "images\\Czech-Rep.png",
				"images\\Denmark.png", "images\\Estonia.png", "images\\Finland.png",
				"images\\France.png", "images\\Germany.png", "images\\Greece.png",
				"images\\Hungary.png", "images\\Iceland.png", "images\\Ireland.png",
				"images\\Italy.png", "images\\Latvia.png", "images\\Lithuania.png",
				"images\\Lux.png", "images\\Macedonia.png", "images\\Moldova.png",
				"images\\Montenegro.png", "images\\Netherlands.png", "images\\Norway.png",
				"images\\Poland.png", "images\\Portugal.png", "images\\Romania.png",
				"images\\Russia.png", "images\\Serbia.png", "images\\Slovakia.png",
				"images\\Slovenia.png", "images\\Spain.png", "images\\Sweden.png",
				"images\\Switzerland.png", "images\\Ukraine.png", "images\\United-Kingdom.png",
				"images\\Map-of-Europe-Trace.png"
		};
		//array of coordinates
		int[][] coords = {  
							{490, 595}, {409, 465}, {570, 355}, {295, 390}, //Albania, Austria, Belarus, Belgium
							{463, 523}, {552, 555}, {450, 503}, {420, 424}, //Bosn-Herze, Bulgaria, Croatia, Czech-Rep
							{372, 300}, {542, 248}, {526, 180}, {260, 455}, //Denmark, Estonia, Finland, France
							{360, 390}, {515, 615}, {467, 475}, {185, 46},  //Germany, Greece, Hungary, Iceland
							{166, 295}, {385, 545}, {547, 283}, {520, 313}, //Ireland, Italy, Latvia, Lithuania
							{326, 405}, {507, 580}, {594, 464}, {465, 557}, //Luxembourg, Macedonia, Moldova, Montenegro
							{294, 355}, {361, 203}, {477, 377}, {62, 536},  //Netherlands, Norway, Poland, Portugal
							{546, 496}, {730, 256}, {502, 530}, {473, 445}, //Romania, Russia, Serbia, Slovakia
							{412, 488}, {129, 549}, {422, 230}, {311, 467}, //Slovenia, Spain, Sweden, Switzerland
							{630, 420}, {226, 329}, {0,0}					//Ukraine, U.K., map 
			};
				
        public GamePane() throws IOException {
        	initialize();
        }

        private void initialize() throws IOException {    
        	setLayout(layout);
        	
        	//loops through coun (list of Country objects), creates object using respective image links and coordinates
        	//39th spot of each array contains the map. map uses overloaded constructor that only takes one image
        	for(int i = 0; i < clist.length; i++) {
        		if(clist[i] == "map") {
            		coun[i] = new Country(llist[i]);        			
        		} else{coun[i] = new Country(llist[i], blank, clist[i]);}
        		add(coun[i]);
        		place(coun[i], coords[i][0], coords[i][1]);
        		setComponentZOrder(coun[i], i);        		
        	}
        	
        }

        public void place(Country c, int x, int y) {
        	layout.putConstraint(SpringLayout.WEST, c, x, SpringLayout.WEST, this);
        	layout.putConstraint(SpringLayout.NORTH, c, y, SpringLayout.NORTH, this);        	
        }
        
    }