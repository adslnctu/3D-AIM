
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	
	public static void main(String[] args) throws FileNotFoundException, Exception
	{
		Parameter parameter = new Parameter();
		
		System.out.println("start!\n");
		for(int j = 0; j < parameter.sshSTD.length; j++) {
			
			/* 每run不同的參數要重新初始化(因為是overall user所以寫在外面) */
			Confusion confusionMatrix = new Confusion();
			/* 每run不同的參數要重新初始化(因為是overall user所以寫在外面) */
			System.out.println("Max = " + parameter.sshSTD[j]);
			
			/* 每一個不同的user(directory) */
			for(int index = 0; index < parameter.FOLDERS.length ; index++) {
				/* 每run不同的user要重新初始化 */
				Distribution distribution = new Distribution();
				AppUsage appUsage = new AppUsage();
				CategoryUsage categoryUsage = new CategoryUsage();
				/* 每run不同的user要重新初始化 */
				
				
				File file = new File(parameter.FOLDERS[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
				ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
				
				if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
		        {
		        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
		            String []s = file.list(); //宣告一個list
		            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
		            for(int i=0; i < s.length; i++)
		            {
		                //System.out.println(s[i]);
		                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
		            }
		        }
				
				/* 每一個不同的activity(file) */
				for(int i = 0; i < fileList.size(); i++)
		        {
					Parser parser = new Parser();
		        	String fileName = parameter.FOLDERS[index] + "\\" + fileList.get(i);
		        	System.out.println(i + ": "+fileName);
		        	
		        	// htc logger version
		        	String category = "V[1-2]+";
		    		Pattern pattern = Pattern.compile(category);
		    	    Matcher matcher = pattern.matcher(fileName);
		    	    String version = null;
		    	    boolean matchFound = matcher.find();
		    	    if(matchFound)
		    	    	version = matcher.group();
		    	    if(parameter.version.equals("V2"))
		    	    	version = "V2";
		    	    	
		    	    if(parameter.hard_soft == 1)
		    	    // 之後改成判斷accel value有沒有超過threshold, 有就是sporting, 否則繼續用model判斷
		    	    	parser.InitializeHardware(fileName, confusionMatrix, parameter.sshSTD[j], version, distribution);
		        	
		    	    if(parameter.hard_soft == 2)
		    	    	parser.InitializeSoftware(new FileReader(fileName), appUsage, categoryUsage, distribution, parameter);

		        	/* 一個file裡面出現多次某個app最後只計算一次，以下是讀取新的file時做初始化 */
//		        	Iterator iterator = distribution.inTheSameFile.entrySet().iterator();
//	                while (iterator.hasNext()) {
//	                    Map.Entry pairs = (Map.Entry)iterator.next();
//	                    distribution.inTheSameFile.put(pairs.getKey(), 0);
//	                }
	                /* 一個file裡面出現多次某個app最後只計算一次，以下是讀取新的file時做初始化 */
		        }
				/* 每一個不同的activity(file) */
				
				if(parameter.hard_soft == 2)
				{
					if(distribution.transportationCounter != 0)
		        		System.out.println("Transportation: "+ distribution.transportationHit+" "+distribution.transportationCounter+" "+distribution.transportationHit/distribution.transportationCounter);
		        	else
		        		System.out.println("Transportation: No Data");
		        	
		        	if(distribution.workingCounter != 0)
		        		System.out.println("Working: "+ distribution.workingHit+" "+distribution.workingCounter+" "+distribution.workingHit/distribution.workingCounter);
		        	else
		        		System.out.println("Working: No Data");
		        	
		        	if(distribution.entertainmentCounter != 0)
		        		System.out.println("Entertainment: "+ distribution.entertainmentHit+" "+distribution.entertainmentCounter+" "+distribution.entertainmentHit/distribution.entertainmentCounter);
		        	else
		        		System.out.println("Entertainment: No Data");
		        	
		        	if(distribution.diningCounter != 0)
		        		System.out.println("Dining: "+ distribution.diningHit+" "+distribution.diningCounter+" "+distribution.diningHit/distribution.diningCounter);
		        	else
		        		System.out.println("Dining: No Data");
		        	
		        	if(distribution.shoppingCounter != 0)
		        		System.out.println("Shopping: "+ distribution.shoppingHit+" "+distribution.shoppingCounter+" "+distribution.shoppingHit/distribution.shoppingCounter);
		        	else
		        		System.out.println("Shopping: No Data");
		        	
		        	if(distribution.sportingCounter != 0)
		        		System.out.println("Sporting: "+ distribution.sportingHit+" "+distribution.sportingCounter+" "+distribution.sportingHit/distribution.sportingCounter);
		        	else
		        		System.out.println("Sporting: No Data");
		        	
		        	System.out.println("Unknow: "+distribution.unknow);
				}
				else
				{
					System.out.println("dining: "+ distribution.diningCounter);
	        		System.out.println("Sporting: "+ distribution.sportingCounter);
	        		System.out.println("working: "+ distribution.workingCounter);
	        		System.out.println("enter: "+ distribution.entertainmentCounter);
	        		
	        		
	        		System.out.println("shopping: "+ distribution.shoppingCounter);
	        		System.out.println("trans: "+ distribution.transportationCounter);
	        		System.out.println("GPS: "+ distribution.gpsPoint);

					
					
					
					
				}
			}
			/* 每一個不同的user(directory) */
			
			// confusion for accel value
			if(parameter.hard_soft == 1)
			{
        		

				System.out.println("TP: "+confusionMatrix.tp);
				System.out.println("FP: "+confusionMatrix.fp);
				System.out.println("TN: "+confusionMatrix.tn);
				System.out.println("FN: "+confusionMatrix.fn);
				System.out.println("P: "+confusionMatrix.P);
				System.out.println("N: "+confusionMatrix.N);
				
				double accuracy = (double)(confusionMatrix.tp+confusionMatrix.tn)/(double)(confusionMatrix.P+confusionMatrix.N);
				double hit = (double)confusionMatrix.tp/(double)(confusionMatrix.tp+confusionMatrix.fn);
				System.out.println("Accuracy: " + accuracy);
				System.out.println("Hit rate: " + hit);
				System.out.println();
				System.out.println();
			}
		}
		
		
		
		System.out.println("end!\n");
	}	
}
