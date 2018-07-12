package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Location extends JPanel {

	public static final int size = 20 ;
	private ImageIcon image; 
	private boolean isBlock;
	private Rectangle rect;
	private int x , y ;
	private boolean isfood = false;
	private boolean isEnemy = false;
	
	

	//Constructor
	public Location(int x , int y) {
		setSize(size, size);
		this.x = x ;
		this.y = y ;
	}
	
	//GETTER & SETTER
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public boolean isEnemy() {
		return isEnemy;
	}

	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Image getImage() {
		return image.getImage();
	}
	public boolean isBlock() {
		return isBlock;
	}

	public void setBlock(boolean isBlock) {
		this.isBlock = isBlock;
	}
	public void setImage(ImageIcon a){
		image = a ;
	}
	public boolean isfood() {
		return isfood;
	}

	public void setIsfood(boolean isfood) {
		this.isfood = isfood;
	}
	
	
	public Rectangle getRect(){
		rect = new Rectangle((int)x*size,(int)y*size, size, size);
		return rect;
	}
	
	

	
}
