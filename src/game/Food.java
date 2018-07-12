package game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Food {

	private int x , y ;
	public static ImageIcon foodImage ;
	private Rectangle rect;

	//CONSTRUCTOR
	public Food(int x , int y) {
		foodImage = new ImageIcon("Images//food.png");
		this.x = x ;
		this.y = y;
	}
	//GETTER & SETTER
	public int getX() {
		return x;
	}
	public Image getFoodImage() {
		return foodImage.getImage();
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

	public Rectangle getRect(){
		rect = new Rectangle(x*Location.size,y*Location.size, 10 , 10);
		return rect;
	}
	
}
