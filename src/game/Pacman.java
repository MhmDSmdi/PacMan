package game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Pacman extends JPanel implements KeyListener , Runnable{

	final static int pacSize = 20;
	private Map map;
	private double x = 455, y = 180;
	private int health = 3;
	private int speed = 1;
	private int direction = 0 , lastDirection = 0;
	private ImageIcon image;
	private static boolean monster = false;
	private ImageIcon leftImage = new ImageIcon("Images//pacLeft.png");
	private ImageIcon rightImage = new ImageIcon("Images//pacRight.png");
	private ImageIcon upImage = new ImageIcon("Images//pacUp.png");
	private ImageIcon downImage = new ImageIcon("Images//pacDown.png");
	public Rectangle rect ;
	
	public Pacman() {
		image = rightImage ; 
		setLocation((int)x,(int)y);
		setOpaque(false);
	}
	
	public void setMap(Map a){
		map = a ;
	}

	////GETTER SETTER
	public double getXP() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getYP() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Image getPacImage() {
		return image.getImage();
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getLastDirection() {
		return lastDirection;
	}
	public void setLastDirection(int lastDirection) {
		 this.lastDirection = lastDirection;
	}
	public Rectangle pacRect(){
		rect = new Rectangle((int)x,(int)y, 20, 20);
		return rect;
	}
	public Rectangle checkBlocks(int x , int y){
		rect = new Rectangle((int)x,(int)y, 20, 20);
		return rect;
	}
	
	public int getHealth() {
		return health;
	}

	public void reduceHealth() {
		this.health--;
	}
	public static boolean isMonster() {
		return monster;
	}

	public static void setMonster(boolean mo) {
		monster = mo;
	}
	
	
	public void move(){
		
		int i,j;
		switch (direction) {
		case Messages.RIGHT:
			if(checkDir(speed,0)) x += speed ;
			break;
	
		case Messages.LEFT:
			if(checkDir(-speed,0))  x -= speed ;
			break;
		
		case Messages.UP:
			if(checkDir(0,-speed)) y -= speed ;
			break;
			
		case Messages.DOWN:
			if(checkDir(0,speed))  y += speed ;
			break;
		
		}
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == arg0.VK_RIGHT){
			setImage(rightImage);
			if(Messages.RIGHT !=getDirection()) if(direction != 0) setLastDirection(getDirection());
			setDirection(Messages.RIGHT);
		}
		if(arg0.getKeyCode() == arg0.VK_LEFT){
			setImage(leftImage);
			if(Messages.LEFT != getDirection()) if(direction != 0)setLastDirection(getDirection());
			setDirection(Messages.LEFT);
		}
		if(arg0.getKeyCode() == arg0.VK_UP) {
			setImage(upImage);
			if(Messages.UP != getDirection()) if(direction != 0)setLastDirection(getDirection());
			setDirection(Messages.UP);
		}
		if(arg0.getKeyCode() == arg0.VK_DOWN){
			setImage(downImage);
			if(Messages.DOWN != getDirection()) if(direction != 0)setLastDirection(getDirection());
			setDirection(Messages.DOWN);
		}
	}

	private boolean checkDir(int deltax , int deltay){
		int flag = 0;
		for(int i = 0 ; i < map.getBlocks().size() ; i++){
			if(checkBlocks((int)(x+deltax),(int)(y+deltay)).intersects(map.getBlocks().elementAt(i))){
				flag++;
			}
		}
		if(flag == 0  ) return true;
		else return false ;
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while(true){
			
			move();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
