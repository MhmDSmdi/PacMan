package game;

import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Enemies extends JLabel {

	private Map map;
	public Vector<Enemy> enemies = new Vector<>(4);
	private int[][] location = new int[4][2];
	public static int numberOfEnemy = 4 ;
	public int[][] getlocation() {
		return location;
	}

	private int giftTimer = 5 ;
	public Enemies(Map map , int level , Pacman pac) {
		
		this.map = map;
		
		enemies.addElement(new Enemy(new ImageIcon("Images//enemy1Right.png"),new ImageIcon("Images//enemy1Left.png"),map,pac, 20, 20,level,"Ghost1",location));
		enemies.addElement(new Enemy(new ImageIcon("Images//enemy2Right.png"),new ImageIcon("Images//enemy2Left.png"),map,pac, 960, 20,level,"Ghost2",location));
		enemies.addElement(new Enemy(new ImageIcon("Images//enemy3Right.png"),new ImageIcon("Images//enemy3Left.png"),map,pac, 20, 460 , level,"Ghost3",location));
		enemies.addElement(new Enemy(new ImageIcon("Images//enemy4Right.png"),new ImageIcon("Images//enemy4Left.png"),map,pac, 960, 460,level,"Ghost4",location));
	}
	
	public void starter(){
		for(int i = 0 ; i<4 ; i++)
			new Thread(enemies.elementAt(i)).start();
	}
	private void stoper(){
		for(int i = 0 ; i<enemies.size() ; i++)
			enemies.elementAt(i).dispatchEvent(new ComponentEvent(this, Messages.END_OF_GAME));
	}
	
	Timer waitForGiftAffect = new Timer(1000,(ActionEvent e) -> {
		if(giftTimer == 1){
			for(int i = 0 ; i < enemies.size() ; i++){
				enemies.elementAt(i).giftEffection = false ;
				enemies.elementAt(i).setFocused(false);
				if(enemies.elementAt(i).getImage().equals(Enemy.weakLeft)) enemies.elementAt(i).setImage(enemies.elementAt(i).enemyImageLeft);
				else if(enemies.elementAt(i).getImage().equals(Enemy.weakRight)) enemies.elementAt(i).setImage(enemies.elementAt(i).enemyImageRight);
			}
			Pacman.setMonster(false);
			giftTimer = 5 ;
		}
		if(Pacman.isMonster())giftTimer--;
	});
	
	public int getGiftTimer() {
		return giftTimer;
	}

	public void setGiftTimer(int giftTimer) {
		this.giftTimer = giftTimer;
	}

	@Override
	protected void processComponentEvent(ComponentEvent arg0) {
		if(arg0.getID() == Messages.GIFT_AFFECT){
			for(int i = 0 ; i < enemies.size() ; i++){
				enemies.elementAt(i).dispatchEvent(new ComponentEvent(this, Messages.GIFT_AFFECT));
			}
			waitForGiftAffect.start();
		}
		if(arg0.getID() == Messages.END_OF_GAME){
			stoper();
		}
		super.processComponentEvent(arg0);
	}

}
