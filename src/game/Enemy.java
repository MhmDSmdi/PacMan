package game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemy extends JPanel implements Runnable{

	public  ImageIcon enemyImageRight;
	public  ImageIcon enemyImageLeft;
	public static ImageIcon weakRight ;
	public static ImageIcon weakLeft ;
	private ImageIcon image;
	private int direction;
	private Map map;
	private Pacman pac;
	private boolean focused = false; 
	private int lastDirection = 5;
	public boolean isRight = false , giftEffection = false ;
	public static final int speed = 1;
	private Rectangle rect;
	private Random rnd = new Random();
	private int x  , y ;
	private int iEn , jEn ;
	private String name ;
	private int accuracy ;
	private boolean isfinish = false ;
	private int level;
	private int[][] enemiesLocation;
	
	//CONSTRUCTOR
	public Enemy(ImageIcon right,ImageIcon left,Map map,Pacman pac, int x , int y , int level , String name , int[][]l) {
		setSize(20,20);
		this.name = name ;
		this.level = level ;
		enemiesLocation = l;
		if(level == 2) accuracy = 10 ;
		else if(level == 3) accuracy = 15 ;
		enemyImageRight = right ;
		enemyImageLeft = left;
		image = right ;
		weakLeft = new ImageIcon("Images//weakLeft.png");
		weakRight = new ImageIcon("Images//weakRight.png");
		this.pac = pac ;
		this.x = x;
		this.y = y;
		this.map = map;
		setLocation(x, y);
	}

	
	//GETTER & SETTER
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public Image getImage() {
		return image.getImage();
	}
	public void setFocused(boolean focused) {
		this.focused = focused;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public int getY() {
		return y;
	}
	public ImageIcon getWeakRight() {
		return weakRight;
	}


	public ImageIcon getWeakLeft() {
		return weakLeft;
	}


	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public synchronized Image getEnemyImage() {
		return image.getImage();
	}
	public void setY(int y) {
		this.y = y;
	}
	public Rectangle enemyRect(){
		rect = new Rectangle((int)x,(int)y, 20, 20);
		return rect;
	}
	public int getiEn() {
		return iEn;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public int getjEn() {
		return jEn;
	}
	public boolean isGiftEffection() {
		return giftEffection;
	}
	public void setGiftEffection(boolean giftEffection) {
		this.giftEffection = giftEffection;
	}
	public boolean isFocused() {
		return focused;
	}
	public  Rectangle checkRectBlocks(int x , int y , int zoomx , int zoomy){
		rect = new Rectangle((int)x,(int)y,  zoomx,  zoomy);
		return rect;
	}
	
	public  boolean checkBlock(int deltax , int deltay){
		int flag = 0;
		for(int i = 0 ; i < map.getBlocks().size() ; i++){
			if(checkRectBlocks((int)(x+deltax),(int)(y+deltay) , 20, 20).intersects(map.getBlocks().elementAt(i))){
				flag++;
			}
		}
		if(flag == 0  ) return true;
		else return false ;
	}
	
	private synchronized int getRNDDirection(int i){
		int a = rnd.nextInt(4) + 1 ;
		if(a != direction) return a;
		else{
			while(a == direction && a == i) a = rnd.nextInt(4) + 1 ;
		}
		return a;
	}
	private synchronized boolean isfree(int x , int y){
		if (!focused) {
			int flag = 0;
			for (int i = 0; i < Enemies.numberOfEnemy; i++) {
				if (enemiesLocation[i][0] == x && enemiesLocation[i][1] == y) {
					flag++;
				}
			}
			if (flag == 0)
				return true;
			else
				return false;
		}
		else return true;
	}
	private boolean checkDivar(int x,int y,int k , int dir){

		int flag = 0 ;
		int xpac = (int) Math.ceil(pac.getXP()/20);
		int ypac = (int) Math.ceil(pac.getYP()/20);
		
		if(dir == Messages.RIGHT){
			for(int i = 1 ; i <= k ; i++){
				if(x+i<map.getW() && map.map[y][x+i].isBlock()){ 
					if(xpac>x+i)
					flag++;;
				}
			}
			if(flag == 0){
				return true;
			}
			else return false;
		}
		else if(dir == Messages.LEFT){
			for(int i = 1 ; i <= k ; i++){
				if(x-i>=0 && map.map[y][x-i].isBlock()) {
					if(xpac<x-i)
					flag++;;
				}
			}
			if(flag == 0) {
				return true;
			}
			else return false;

		}
		else if(dir == Messages.UP){
			for(int i = 1 ; i <= k ; i++){
				if(y-i>=0 && map.map[y-i][x].isBlock()){
					if(ypac<y-i)
					flag++;;
				}
			}
			if(flag == 0) {
				return true;
			}
			else return false;
			
		}
		else if(dir == Messages.DOWN){
			for(int i = 1 ; i <= k ; i++){
				if(y+i<map.getH() && map.map[y+i][x].isBlock()){
					if(ypac>y+i)
					flag++;;
				}
			}
			if(flag == 0) {
				return true;
			}
			else return false;
			
		}
		
		else return false;
	}
	private synchronized void checkDir(){
		
		int xpac = (int) Math.ceil(pac.getXP()/20);
		int ypac = (int) Math.ceil(pac.getYP()/20);
		
		int xen = (int) Math.ceil(x/20);
		int yen = (int) Math.ceil(y/20);

		
		int deltax = xpac - xen ;
		int deltay = ypac - yen ;
		
			if(deltay == 0 && deltax>0 && Math.abs(deltax)<accuracy && checkDivar(xen, yen, accuracy,Messages.RIGHT) && checkLocation()){
				direction = Messages.RIGHT;
				focused = true;
			}
			else if(deltay == 0 && deltax<0 && Math.abs(deltax)<accuracy && checkDivar(xen, yen, accuracy, Messages.LEFT) && checkLocation()){
				direction = Messages.LEFT;
				focused = true;
			}
			else if(deltax == 0 && deltay>0 && Math.abs(deltay)<accuracy && checkDivar(xen, yen, accuracy, Messages.DOWN) && checkLocation()){
				direction = Messages.DOWN;
				focused = true;
			}
			else if(deltax == 0 && deltay<0 && Math.abs(deltay)<accuracy && checkDivar(xen, yen, accuracy, Messages.UP) && checkLocation()){
				direction = Messages.UP;
				focused = true;
			}
			else{
				if(!isRight){
					focused = false;
					lastDirection = direction ;
					direction = getRNDDirection(-1);
					while(direction == lastDirection)  direction = getRNDDirection(-1);
					isRight = true;
				}
			}
	
	}


	public synchronized void move(){
	
		if(level ==1 && !isRight){
			lastDirection = direction ;
			direction = getRNDDirection(-1);
			while(direction == lastDirection)  direction = getRNDDirection(-1);
			isRight = true;
		}
		
		switch (direction) {
			case Messages.RIGHT:
				if(!giftEffection) image = enemyImageRight;
				else image = weakRight ;
				if(checkBlock(speed,0) && isfree(iEn + 1,jEn)) x += speed ;
				else {
					isRight = false;
					focused = false;
				}
				break;
		
			case Messages.LEFT:
				if(!giftEffection)image = enemyImageLeft;
				else image = weakLeft;
				
				if(checkBlock(-speed,0)&& isfree(iEn - 1,jEn)) x -= speed ;
				else {
					isRight = false;
					focused = false;
				}
				break;
			
			case Messages.UP:
				
				if(giftEffection){
					if(image.equals(enemyImageLeft)) image = weakLeft;
					else if(image.equals(enemyImageRight)) image = weakRight;
				}
				else{
					if(image.equals(weakLeft)) image = enemyImageLeft;
					else if(image.equals(weakRight)) image = enemyImageRight;
				}
				if(checkBlock(0,-speed)&& isfree(iEn,jEn - 1)) y -= speed ;
				else{
					isRight = false;
					focused = false;
				}
				break;
				
			case Messages.DOWN:
				if(giftEffection){
					if(image.equals(enemyImageLeft)) image = weakLeft;
					else if(image.equals(enemyImageRight)) image = weakRight;
				}
				else{
					if(image.equals(weakLeft)) image = enemyImageLeft;
					else if(image.equals(weakRight)) image = enemyImageRight;
				}
				if(checkBlock(0,speed)&& isfree(iEn,jEn+1) ) y += speed ;
				else{
					isRight = false;
					focused = false;
				}
				break;
		}
	}
	
	
	public synchronized void giftAffect(){
		int xpac = (int) Math.ceil(pac.getXP()/20);
		int ypac = (int) Math.ceil(pac.getYP()/20);
		
		int xen = (int) Math.ceil(x/20);
		int yen = (int) Math.ceil(y/20);

		int deltax = xpac - xen ;
		int deltay = ypac - yen ;
		
			
			if(deltay == 0 && deltax>0 && Math.abs(deltax)<accuracy && checkDivar(xen, yen, accuracy,Messages.RIGHT) && checkLocation()){
				direction = getRNDDirection(Messages.RIGHT);
			}
			else if(deltay == 0 && deltax<0 && Math.abs(deltax)<accuracy && checkDivar(xen, yen, accuracy, Messages.LEFT) && checkLocation()){
				direction =getRNDDirection(Messages.LEFT);
			}
			else if(deltax == 0 && deltay>0 && Math.abs(deltay)<accuracy && checkDivar(xen, yen, accuracy, Messages.DOWN) && checkLocation()){
				direction = getRNDDirection(Messages.DOWN);
			}
			else if(deltax == 0 && deltay<0 && Math.abs(deltay)<accuracy && checkDivar(xen, yen, accuracy, Messages.UP) && checkLocation()){
				direction = getRNDDirection(Messages.UP);;
			}
			else{
				if(!isRight){
					focused = false;
					lastDirection = direction ;
					direction = getRNDDirection(-1);
					while(direction == lastDirection)  direction = getRNDDirection(-1);
					isRight = true;
				}
			}
	}
	
	private boolean checkLocation(){
		int a = x % 20;
		int b = y % 20 ;
		if(a == 0 && b == 0) return true;
		else return false;
	}
	@Override
	public void run() {
		
		while(!isfinish){
			move();
			if(level != 1 && !giftEffection )checkDir();
			if(giftEffection) giftAffect();
			iEn = (int) Math.ceil(x/20);
			jEn = (int) Math.ceil(y/20);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	protected void processComponentEvent(ComponentEvent arg0) {
		
		if(arg0.getID() == Messages.CHANGE_DIR){
			lastDirection = direction ;
			direction = getRNDDirection(-1);
			Enemy a = ((ChageDIR)arg0).getA();
			while(direction == lastDirection || direction == a.getDirection())  direction = getRNDDirection(-1);
			isRight = true;
		}
		
		if(arg0.getID() == Messages.GIFT_AFFECT){
			giftEffection = true;
		}
		if(arg0.getID() == Messages.END_OF_GAME){
			isfinish = true;
		}
		super.processComponentEvent(arg0);
	}


	public boolean isIsfinish() {
		return isfinish;
	}


	public void setIsfinish(boolean isfinish) {
		this.isfinish = isfinish;
	}
	
	

}
