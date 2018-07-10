import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Hilight extends JLabel {

	BufferedImage hImage;
	
	public Hilight(String pic1) throws IOException {
		hImage = ImageIO.read(new File(pic1));
		setIcon(new ImageIcon(hImage));
		this.setInvisible();
	}
	
	public void setVisible() {
		show();
	}
	
	public void setInvisible() {
		hide();
	}
}
