package game;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Gift {

	static final ImageIcon image = new ImageIcon("Images//gift.png");
	private int x , y ;
	private Rectangle rect ;
	public Gift(int x , int y) {
		this.x = x ;
		this.y = y ;
	}

	public Rectangle getRect(){
		rect = new Rectangle(x*Location.size,y*Location.size, 25 , 25);
		return rect;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
