package mapEditor;

import java.awt.event.ComponentEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JPanel;

public class SampleMap extends JPanel{

	public static int element;
	private static final int Widht_Size = 50;
	private static final int HEIGHT_Size = 25;
	private int[][] map_File;
	private Location[][] map_Source;
	
	public SampleMap(){
		setSize(1000, 600);
		setLayout(null);
		setLocation(100, 0);
		map_Source = new Location[HEIGHT_Size][Widht_Size];
		map_File = new int[HEIGHT_Size][Widht_Size];
		initMap();
	}

	public static int getWidhtSize() {
		return Widht_Size;
	}

	public static int getHeightSize() {
		return HEIGHT_Size;
	}

	private void initMap() {
		
		for(int j = 0 ; j < HEIGHT_Size ; j ++){
			for(int i = 0 ; i < Widht_Size ; i++){
				map_Source[j][i] = new Location(this);
				map_Source[j][i].setxPos(i*20);
				map_Source[j][i].setyPos(j*20);
				map_Source[j][i].setI(i);
				map_Source[j][i].setJ(j);
				map_Source[j][i].setLocation(i*20, j*20);
				add(map_Source[j][i]);
			}
		}
		
	}
	
	public Location getLocation(int i , int j){
		return map_Source[j][i];
	}

	private void saveToFile(String name){
		
		
		for(int j = 0 ; j < HEIGHT_Size ; j++){
			for(int i = 0 ; i < Widht_Size ; i++){
				System.out.print(" "+map_File[j][i] + " ");
			}
			System.out.println(" ");
		}
	
		try {
			FileOutputStream fi = new FileOutputStream("Maps//"+name+".txt");
			DataOutputStream di = new DataOutputStream(fi);
			for(int j = 0 ; j < HEIGHT_Size ; j++){
				for(int i = 0 ; i < Widht_Size ; i++){
					if(map_File[j][i]== 1)di.writeBytes("1");
					else if(map_File[j][i]== 0)di.writeBytes("0");
				}
				di.writeBytes("\r\n");
			}
			di.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	protected void processComponentEvent(ComponentEvent arg0) {
	
		if(arg0.getID() == Events.CHANGE_ELEMENT){
			element = ((ChangeElement)arg0).getElement() ;
		}
		if(arg0.getID() == Events.WRITE_IN_FILE){
			int i = ((WriterInFile)arg0).getI();
			int j = ((WriterInFile)arg0).getJ();
			int e = ((WriterInFile)arg0).getElement();
			map_File[j][i] = e ;
		}
		if(arg0.getID() == Events.SUBMITED){
			String name = ((SubmitedFile)arg0).getName();
			saveToFile(name);
		}
		super.processComponentEvent(arg0);
	}
}
