package jf;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.apache.commons.collections.bag.PredicatedBag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

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
			
			Vector<String> out = new Vector<String>();
			
			for (String[] entry : myEntries) {
				List<String>  list = Arrays.asList(entry);
				CollectionUtils.select(list, new MonPredicat(), out);
			}
			
			System.out.println("OUT"+ out);
			
			String[] filteredData = out.toArray(new String[0]);
			String filenameOut = "data-filtered.csv";
			CSVWriter writer = new CSVWriter(new FileWriter(filenameOut), '\t');
			writer.writeNext(filteredData);
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private static class MonPredicat implements Predicate<String> {

		@Override
		public boolean evaluate(String str) {
			int val = Integer.parseInt(str);
			return val < 50;
		}
    	
    }
}
