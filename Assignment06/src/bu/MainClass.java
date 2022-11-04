package bu;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
	public static void main(String[] args) {
		String path = "C:\\Users\\teddy\\CS102_Labs\\Assignment06\\happy.txt";
		String song = "";
		BufferedReader reader;
		Set<String> set = new HashSet<String>();
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		try {
			reader = new BufferedReader(new FileReader(path));
		
			String nextLine;
			while ((nextLine = reader.readLine()) !=null) {
			    song += " "+nextLine;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		song = song.replace("(", "");
		song = song.replace(")", "");
		song = song.replace(",", "");
		song = song.toLowerCase();
		String[] songArray = song.split(" ");
		for(String word: songArray) {
			set.add(word);
			if(hashMap.putIfAbsent(word, 1)!=null) {
				hashMap.replace(word, hashMap.get(word)+1);
			}
		}
		System.out.println("The amount of unique words is: "+set.size());
		System.out.println("The amount of times the word Happy is said is: "+hashMap.get("happy"));
	}
}
