package game;

import java.util.Random;
import java.util.Vector;

public class Gifts {

	public Vector<Gift> gifts = new Vector<>();
	private Random rnd;
	private int count;
	
	public Gifts(Map map,int count) {
		this.count = count;
		rnd = new Random();
		
		for(int i = 1 ; i <= count ; i++){
			
			int x = rnd.nextInt(map.getW());
			int y = rnd.nextInt(map.getH());
			
			
			
			if(!map.map[y][x].isBlock() && !map.map[y][x].isfood()) {
				gifts.addElement(new Gift(x , y));
				map.map[y][x].setIsfood(true);
			}
			else{
				while(map.map[y][x].isBlock() || map.map[y][x].isfood() ){
					x = rnd.nextInt(map.getW());
					y = rnd.nextInt(map.getH());
				}
				gifts.addElement(new Gift(x , y));
				map.map[y][x].setIsfood(true);
			}
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
