package game;

import java.awt.event.ComponentEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CheckCollides extends JLabel implements Runnable {

	private GameFrame gf;
	private boolean isFinish = false ;
	public CheckCollides(GameFrame gf) {
		this.gf = gf ;
	}
	@Override
	public void run() {
	
		while (!isFinish){
			if(gf.getEnemies().enemies.size() == 0 || gf.getFoods().getCount()==0){
				
				gf.getB().dispatchEvent(new EndOfGame(this, Messages.END_OF_GAME, gf ,this));
				isFinish = true;
				
			}
			
			//Enemy Collide
			if(!Pacman.isMonster())
				for(int j = 0 ; j < gf.getEnemies().enemies.size() ; j++){
					if(gf.getPac().pacRect().intersects(gf.getEnemies().enemies.elementAt(j).enemyRect())){
						gf.getPac().reduceHealth();
						if(gf.getPac().getHealth() != 0){
							gf.getPac().setX(455);
							gf.getPac().setY(180);
						}
						else{
							System.out.println("Health : "+gf.getPac().getHealth());
							System.exit(0);
						}
					}
				}
			
			else if (Pacman.isMonster()){
				
				for(int j = 0 ; j < gf.getEnemies().enemies.size() ; j++){
					if(gf.getPac().pacRect().intersects(gf.getEnemies().enemies.elementAt(j).enemyRect())){
						try {
							Class c = Class.forName("game.BelowPanel");
							Method m = c.getMethod("set"+(gf.getEnemies().enemies.elementAt(j).getName()), ImageIcon.class);
							m.invoke(new BelowPanel(),BelowPanel.deadGhost);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (NoSuchMethodException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SecurityException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						gf.getEnemies().enemies.elementAt(j).setIsfinish(true);
						gf.getEnemies().enemies.removeElementAt(j);
						Enemies.numberOfEnemy--;
					}
				}
			}
			
			
		
			for(int i = 0 ; i < gf.getEnemies().enemies.size() ; i++){
				gf.getEnemies().getlocation()[i][0] = gf.getEnemies().enemies.elementAt(i).getiEn();
				gf.getEnemies().getlocation()[i][1] = gf.getEnemies().enemies.elementAt(i).getjEn();
			}
			//Foods Collide
			for(int i = 0 ; i < gf.getFoods().foods.size() ; i++)
				if(gf.getPac().pacRect().intersects(gf.getFoods().foods.elementAt(i).getRect())){
					gf.getFoods().foods.removeElementAt(i);
					gf.getFoods().eatFood();
				}
			
			//Gifts Collide
			for(int i = 0 ; i < gf.getGifts().gifts.size() ; i++)
				if(gf.getPac().pacRect().intersects(gf.getGifts().gifts.elementAt(i).getRect())){
					gf.getGifts().gifts.removeElementAt(i);
					gf.getPac().setMonster(true);
					gf.getGifts().setCount(gf.getGifts().getCount() - 1);
					gf.getEnemies().dispatchEvent(new ComponentEvent(this, Messages.GIFT_AFFECT));
				}
		}
	}
}