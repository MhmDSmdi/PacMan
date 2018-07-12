package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map extends JPanel {

	public Location[][] map;
	private Vector<Rectangle> blocks = new Vector<>();
	private File sourceMap;
	private ImageIcon block ;
	private ImageIcon road ;
	private int w , h ;
	private byte[] byteArray;
	private FileInputStream fi ;
	int as=0 ;
	public Map(int w  , int h , String fileName) {
		
		//this.setLayout(null);
		this.w = w ;
		this.h = h ;
		map = new Location[h][w];
		sourceMap = new File(fileName);
		byteArray = new byte[w+2];
		block = new ImageIcon("Images\\d1Big.png");
		road = new ImageIcon("Images\\d2Big.png");
		initMap();
	}
	
	private void initMap(){
		
		try {
			fi= new FileInputStream(sourceMap);
			for(int j = 0 ; j< h ; j++){
				fi.read(byteArray);
				for(int i = 0 ; i <w ; i++){
					map[j][i] = new Location(i ,j);
					if(byteArray[i] == 49) {
						map[j][i].setImage(block);
						map[j][i].setBlock(true);
						blocks.addElement(map[j][i].getRect());
					}
					else{
						map[j][i].setImage(road);
						map[j][i].setBlock(false);
					}
					
					map[j][i].setLocation( i * (Location.size), j * (Location.size) );
					this.add(map[j][i]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public Vector<Rectangle> getBlocks() {
		return blocks;
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

}
