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
		Hilight[] hil = new Hilight[38]; //object arrary for the 38 hilighted images
		
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
		//array of image highlight links (lacking 38th element, no map)
		String[] hlist = {
				"images\\albania-3.png", "images\\austria-3.png", "images\\belarus-3.png",
				"images\\belgium-3.png", "images\\bosn-herze-3.png", "images\\bulgaria-3.png",
				"images\\croatia-3.png", "images\\czech-3.png",
				"images\\denmark-3.png", "images\\estonia-3.png", "images\\finland-3.png",
				"images\\france-3.png", "images\\germany-3.png", "images\\greece-3.png",
				"images\\hungary-3.png", "images\\iceland-3.png", "images\\ireland-3.png",
				"images\\italy-3.png", "images\\latvia-3.png", "images\\lithuania-3.png",
				"images\\lux-3.png", "images\\macedonia-3.png", "images\\moldova-3.png",
				"images\\montenegro-3.png", "images\\netherlands-3.png", "images\\norway-3.png",
				"images\\poland-3.png", "images\\portugal-3.png", "images\\romania-3.png",
				"images\\russia-3.png", "images\\serbia-3.png", "images\\slovakia-3.png",
				"images\\slovenia-3.png", "images\\spain-3.png", "images\\sweden-3.png",
				"images\\switzerland-3.png", "images\\ukraine-3.png", "images\\united-kingdom-3.png",
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
		//array of coords for hilighted image
		int[][] hcoords = {  
				{494, 565}, {371, 440}, {542, 296}, {295, 370}, //Albania, Austria, Belarus, Belgium
				{445, 511}, {537, 528}, {418, 491}, {408, 400}, //Bosn-Herze, Bulgaria, Croatia, Czech-Rep
				{377, 266}, {542, 231}, {511, 33}, {194, 375}, //Denmark, Estonia, Finland, France
				{330, 318}, {508, 579}, {457, 447}, {166, 1},  //Germany, Greece, Hungary, Iceland
				{156, 261}, {325, 471}, {516, 263}, {518, 294}, //Ireland, Italy, Latvia, Lithuania
				{329, 403}, {512, 570}, {594, 446}, {482, 545}, //Luxembourg, Macedonia, Moldova, Montenegro
				{307, 340}, {362, 12}, {436, 329}, {65, 492},  //Netherlands, Norway, Poland, Portugal
				{511, 451}, {505, 0}, {490, 492}, {462, 428}, //Romania, Russia, Serbia, Slovakia
				{414, 476}, {86, 466}, {420, 57}, {320, 453}, //Slovenia, Spain, Sweden, Switzerland
				{535, 358}, {194, 213}, {0,0}					//Ukraine, U.K., map 
};
        
		public GamePane() throws IOException {
        	initialize();
        }

        private void initialize() throws IOException {    
        	setLayout(layout);
        	
        	//loops through coun (list of Country objects), creates object using respective image links and coordinates
        	//39th spot of each array contains the map. map uses overloaded constructor that only takes one image
        	for(int i = 0; i < clist.length; i++) {
//        		System.out.println(clist[i]);
        		if(clist[i] == "map") {
            		coun[i] = new Country(llist[i]);        			
        		} 
        		else{
        			hil[i] = new Hilight(hlist[i]);
        			coun[i] = new Country(llist[i], blank, clist[i], hil[i]);
        			}
        		add(coun[i]);
        		place(coun[i], coords[i][0], coords[i][1]);
        		setComponentZOrder(coun[i], i);        		
        	}
        	
        	for(int j = 0; j < hlist.length; j++) {        	
        		place(hil[j], hcoords[j][0], hcoords[j][1]);
        		setComponentZOrder(hil[j], j + 38);
        	}
        	
        	
        }

        public void place(Country c, int x, int y) {
        	layout.putConstraint(SpringLayout.WEST, c, x, SpringLayout.WEST, this);
        	layout.putConstraint(SpringLayout.NORTH, c, y, SpringLayout.NORTH, this);        	
        }
        
        public void place(Hilight h, int x, int y) {
        	layout.putConstraint(SpringLayout.WEST, h, x, SpringLayout.WEST, this);
        	layout.putConstraint(SpringLayout.NORTH, h, y, SpringLayout.NORTH, this);        	
        }
        
    }