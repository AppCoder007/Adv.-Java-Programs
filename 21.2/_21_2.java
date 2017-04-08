import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _21_2 {

	public static void main(String[] args) {
		try{
			
		    PrintWriter writer = new PrintWriter("WordsInOrder.txt", "UTF-8");
		    writer.println("Good morning. Have a good class. " + "Have a good visit. Have fun!");
		    writer.close();
		    
	
		   InputStream is = new FileInputStream("WordsInOrder.txt");
		        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		        String[] data;
		        String line = buf.readLine();
		        Set<String> set = new HashSet<>();
		        System.out.println("Before Sorting");
		        while (line != null) {
		        	 data = line.toString().toUpperCase().split(" ");
		        	 for (int i = 0; i < data.length; i++){
		        		 set.add(data[i]);
		        		 
		        		 System.out.print(data[i] +" ");
		        		 
		            }
		            break;
		        }
		        System.out.println();
		        TreeSet<String> treeSet  = new TreeSet<>(set);
		        System.out.println("After Sorting");
		        for(String element:treeSet){
		        System.out.print(element.toLowerCase() + " ");
		        }
		} catch (IOException e) {
		   // do something
		}
		
		
		
	}

}
