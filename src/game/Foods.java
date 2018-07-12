package game;

import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;

public class Foods {

	public Vector<Food> foods = new Vector<>();
	private Map map;
	private Random rnd;
	private int count;
	
	//CONSTRUCTOR
	public Foods(int count , Map map) {
		
		this.map = map ;
		this.count = count;
		rnd = new Random();
		
		for(int i = 1 ; i <= count ; i++){
			
			int x = rnd.nextInt(map.getW());
			int y = rnd.nextInt(map.getH());
			if(!map.map[y][x].isBlock()) {
				foods.addElement(new Food(x , y));
				map.map[y][x].setIsfood(true);
			}
			else{
				while(map.map[y][x].isBlock()){
					x = rnd.nextInt(map.getW());
					y = rnd.nextInt(map.getH());
				}
				foods.addElement(new Food(x , y));
				map.map[y][x].setIsfood(true);
			}
		}
	}
	
	//GETTER & SETTER
	public void eatFood(){
		count--;
	}

	public int getCount() {
		return count;
	}

}
