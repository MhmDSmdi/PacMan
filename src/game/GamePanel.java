package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel  extends JPanel{

	private BelowPanel a ;
	GameFrame gameFrame;
	public GamePanel(GameFrame gf,BelowPanel bp) {
		gameFrame = gf ;
		a = bp ;
	}
	
	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
		
		///PRINT MAP
			for(int j = 0 ; j< gameFrame.getMap().getH() ; j++){
				for(int i = 0 ; i <gameFrame.getMap().getW() ; i++){
					Image a = gameFrame.getMap().map[j][i].getImage() ;
					arg0.drawImage(a,i*Location.size,j*Location.size,null);
					arg0.setColor(Color.CYAN);
				}
			}
		//PANELS
			arg0.drawImage(a.image.getImage(), 0, 500, null);
			if(gameFrame.getPac().getHealth() == 3)
				arg0.drawImage(a.h3.getImage(), 5, 510, null);
			else if(gameFrame.getPac().getHealth() == 2)
				arg0.drawImage(a.h2.getImage(), 5, 510, null);
			else if(gameFrame.getPac().getHealth() == 1)
				arg0.drawImage(a.h1.getImage(), 5, 510, null);
			
			arg0.setColor(Color.orange);
			arg0.setFont(new Font("arial",Font.ITALIC, 30));
			arg0.drawString((gameFrame.getFoods().getCount()+" "), 85, 540);
			if(gameFrame.getLevel() == 1){
				arg0.drawImage(new ImageIcon("Images//z.png").getImage(),123,523,null);
				arg0.drawImage(Food.foodImage.getImage(),135,520,null);
			}
			else{
				arg0.drawImage(new ImageIcon("Images//z.png").getImage(),140,523,null);
				arg0.drawImage(Food.foodImage.getImage(),151,520,null);
			}
			
			arg0.drawImage(a.ghost1.getImage(), 970, 520, null);
			arg0.drawImage(a.ghost2.getImage(), 950, 520, null);
			arg0.drawImage(a.ghost3.getImage(), 930, 520, null);
			arg0.drawImage(a.ghost4.getImage(), 910, 520, null);
			
			arg0.setColor(Color.orange);
			arg0.setFont(new Font("arial",Font.ITALIC, 30));
			arg0.drawString(gameFrame.getGifts().getCount()+"", 820, 540);
			arg0.drawImage(new ImageIcon("Images//z.png").getImage(),840,523,null);
			arg0.drawImage(a.gift.getImage(), 855, 520, null);
			
			
			if(Pacman.isMonster()){
				arg0.setColor(Color.pink);
				arg0.setFont(new Font("arial",Font.TRUETYPE_FONT, 30));
				arg0.drawString(gameFrame.getEnemies().getGiftTimer()+"s",780, 540);
			}
			
			arg0.setColor(Color.orange);
			arg0.setFont(new Font("arial",Font.ITALIC, 30));
			arg0.drawString("Player Name : "+gameFrame.getName(), 180, 540);
			arg0.drawString("Level : "+gameFrame.getLevel(), 640, 540);
			
		///PRINT FOODS
			for(int i= 0 ; i<gameFrame.getFoods().foods.size() ; i++){
				arg0.drawImage(Food.foodImage.getImage(),gameFrame.getFoods().foods.elementAt(i).getX()*Location.size,gameFrame.getFoods().foods.elementAt(i).getY()*Location.size,null);
			}
		///Print Gifts
			for(int i= 0 ; i<gameFrame.getGifts().gifts.size() ; i++){
				arg0.drawImage(Gift.image.getImage(),gameFrame.getGifts().gifts.elementAt(i).getX()*Location.size,gameFrame.getGifts().gifts.elementAt(i).getY()*Location.size,null);
			}
		//PRINT ENEMIES
			arg0.setColor(Color.RED);
			for(int i = 0 ; i < gameFrame.getEnemies().enemies.size() ; i++){
				arg0.drawImage(gameFrame.getEnemies().enemies.elementAt(i).getEnemyImage(),gameFrame.getEnemies().enemies.elementAt(i).getX(),gameFrame.getEnemies().enemies.elementAt(i).getY(),null);
			}
		////Print PacMan
			arg0.drawImage(gameFrame.getPac().getPacImage(),(int)gameFrame.getPac().getXP(),(int)gameFrame.getPac().getYP(),null);
			arg0.setColor(Color.CYAN);
			
	}
}
