package game;

import java.awt.Color;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BelowPanel extends JPanel {

	public ImageIcon image = new ImageIcon("Images//panel.png");
	public ImageIcon h1 = new ImageIcon("Images//h1.png");
	public ImageIcon h2 = new ImageIcon("Images//h2.png");
	public ImageIcon h3 = new ImageIcon("Images//h3.png");
	
	public static ImageIcon ghost1 = new ImageIcon("Images//enemy1Left.png");
	public static ImageIcon ghost2 = new ImageIcon("Images//enemy2Left.png");
	public static ImageIcon ghost3 = new ImageIcon("Images//enemy3Left.png");
	public static ImageIcon ghost4 = new ImageIcon("Images//enemy4Left.png");
	public static ImageIcon deadGhost = new ImageIcon("Images//weakLeft.png");
	
	public ImageIcon gift = new ImageIcon("Images//gift.png");
	
	public BelowPanel() {
		setSize(1805 , 2);
		setBackground(Color.BLACK);
		setLayout(null);
		setLocation(0, 500);
		
	}

	
	public static ImageIcon getGhost1() {
		return ghost1;
	}
	public static void setGhost1(ImageIcon ghost) {
		ghost1 = ghost;
	}
	public static ImageIcon getGhost2() {
		return ghost2;
	}
	public static void setGhost2(ImageIcon ghost) {
		ghost2 = ghost;
	}
	public static ImageIcon getGhost3() {
		return ghost3;
	}
	public static void setGhost3(ImageIcon ghost) {
		ghost3 = ghost;
	}
	public static ImageIcon getGhost4() {
		return ghost4;
	}
	public void setGhost4(ImageIcon ghost4) {
		this.ghost4 = ghost4;
	}

	@Override
	protected void processComponentEvent(ComponentEvent arg0) {
		
		if(arg0.getID() == Messages.RESET_IMAGE){
			ghost1 = new ImageIcon("Images//enemy1Left.png");
			ghost2 = new ImageIcon("Images//enemy2Left.png");
			ghost3 = new ImageIcon("Images//enemy3Left.png");
			ghost4 = new ImageIcon("Images//enemy4Left.png");
		}
		
		super.processComponentEvent(arg0);
	}
	
}
