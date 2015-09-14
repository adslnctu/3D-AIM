package TEST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class main {

	public static void main(String[] args) throws Exception{
		FileReader fw = new FileReader("C:\\Users\\Lai\\Desktop\\0f88f6d072713402b0a74911fcce9f29db143095.csv");
		BufferedReader br = new BufferedReader(fw); 
		String s; 
		int i = 0;
		while((s = br.readLine()) != null) { 
		System.out.println(s); 
	
		} 
		fw.close(); 
//		Map<String, Integer> regionCategory = new HashMap<String, Integer>();
//		HttpRequest httpRequest = new HttpRequest();
//		
//		regionCategory = httpRequest.sendGet(24.13831835,120.65353739,100);
//		for (Map.Entry<String, Integer> entry : regionCategory.entrySet())
//		{
//		    System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
//		System.out.println("end");
		// foursquare category
//		FileReader fw = new FileReader("C:\\Users\\Lai\\Desktop\\category.txt");
//		String line;
//		String prefix = "transport.put(\"";
//		String key = null;
//		String value = null;
//		int index = 0;
//		
//		BufferedReader br = new BufferedReader(fw);
//		while ((line=br.readLine())!=null) {
//			index++;
//			if(index % 3 == 1)
//	
//					value = line;
//				
//	
//				
//			if(index % 3 == 2)
//				key = line;
//			if(index % 3 == 0)
//			{
//				System.out.println(prefix+key+"\",\""+value+"\");");
//				key = null;
//				value = null;
//				
//			}
//		}
//		System.out.println(prefix+key+"\",\""+value+"\");");
	}
}
