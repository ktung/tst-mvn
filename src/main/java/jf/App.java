package jf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class App {
	
	public int max(int a, int b) {
		return (a > b) ? a : b;
//		return a;
	}
	
    public static void main(String[] args) {
    	App app = new App();
    	
    	int myMax = 5;
    	String filename = "data.csv";
    	try {
			CSVReader reader = new CSVReader(new FileReader(filename));
			List<String[]> myEntries = reader.readAll();
			
			for (String[] entry : myEntries) {
				int nb = Integer.parseInt(entry[0]);
				System.out.println(String.format("Nombre lu : %d", nb));
				System.out.println(String.format("Nb max entre %d et %d est %d", myMax, nb, app.max(myMax, nb)));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
