import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _21_8 {

	public static void main(String[] args) {
try{
			
		    PrintWriter writer = new PrintWriter("WordsInOrder.txt", "UTF-8");
		    writer.println("Good morning. Have a good class. " + "Have a good visit. Have fun! ");
		    writer.close();
		    
	
		   InputStream is = new FileInputStream("WordsInOrder.txt");
		        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		      //  String[] words;
		        String line = buf.readLine();
		        
		        Map<String, Integer> map = new TreeMap<>();
		        String[] words = line.split("[ \n\t\r.,;:!?(){}]");
		        
		        for(int i=0; i<words.length; i++){
		        	String key = words[i].toLowerCase();
		        	
		        	if (key.length() > 0){
		        		if (!map.containsKey(key)){
		        			map.put(key, 1);
		        		}
		        		else {
		        			int value = map.get(key);
		        			value++;
		        			map.put(key, value);
		        		}
		        	}
		        }
		        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		        for(Map.Entry<String, Integer> entry: entrySet)
		        	System.out.println(entry.getKey() + "\t" + entry.getValue());
}catch (IOException e) {
	   // do something
	}


	}

}
