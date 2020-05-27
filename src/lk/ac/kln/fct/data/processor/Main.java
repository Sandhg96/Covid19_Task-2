package lk.ac.kln.fct.data.processor;

import java.util.ArrayList;

import lk.ac.kln.fct.data.pojo.Record;

public class Main {
	private static final String FILE_PATH = "C:/Users/Sandun/eclipse-workspace/Task#2/src/covid-19-data.json";
	private static final String DATE = "18/05/2020";
	private static final int LIMIT = 1000;
	
	public static void main(String[] args) {
		DataProcessor processor = new DataProcessor();
		ArrayList<Record> record = new ArrayList<Record>();
		record = processor.getDataByDate(FILE_PATH, DATE);
		sortAndPrint(record);
	}
		
	public static void sortAndPrint(ArrayList<Record> records) {
		records.sort((record1, record2)-> Integer.compare(record2.getCases(), record1.getCases()));
		
		for(int i = 0; i < records.size(); i++) {
			if(records.get(i).getCases() >= LIMIT) {
				System.out.println(records.get(i).getCountriesAndTerritories() 
						+ " : " + records.get(i).getCases() + " : " + records.get(i).getDeaths());
			}
		}
	}
}
