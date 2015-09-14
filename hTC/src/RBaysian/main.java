package RBaysian;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main 
{
	

	public static void main(String[] args) throws Exception
	{	
		Parameter parameter = new Parameter();
		Runtime runtime = Runtime.getRuntime();
	    // Run the garbage collector
	    runtime.gc();
	    // Calculate the used memory
	    long memory = runtime.totalMemory() - runtime.freeMemory();
	    double initial = (double)memory/1048576;
	    System.out.println("Used memory is Mbytes: " + (double)memory/1048576);
		
	    
		int totalFile = 0;
		
//		/* for learning curve */
//		for (String line : Files.readAllLines(Paths.get("D:\\STAIM\\input\\learning_curve\\training_data_no\\TEST_3\\60\\"+parameter.imei[0]+".txt"))) {
//			parameter.training_file_no[parameter.training_file_counter] = Integer.valueOf(line);
//			//System.out.println(parameter.training_file_no[parameter.training_file_counter]);
//			parameter.training_file_counter++;
//		}
//		parameter.training_file_counter = 0;
		/* for learning curve */
		
		System.out.println("Start!\n");
		for(int index = 0; index < parameter.hardwareTraining.length; index++) {
			File file = new File(parameter.hardwareTraining[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
			ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
			
			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i = 0; i < s.length; i++) {
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            }
	        }
			
			// 每一個不同的activity(file)
			totalFile = fileList.size();
			for(int i = 0; i < fileList.size(); i++) {
				Parser parser = new Parser();
	        	String fileName = parameter.hardwareTraining[index] + "\\" + fileList.get(i);
	        	System.out.println(i + ": "+fileName);
	        	
	        	// 判斷  logger version
	        	String category = "V[1-2]+";
	    		Pattern pattern = Pattern.compile(category);
	    	    Matcher matcher = pattern.matcher(fileName);
	    	    String version = null;
	    	    boolean matchFound = matcher.find();
	    	    if(matchFound)
	    	    	version = matcher.group();
	    	    if(parameter.loggerVersion.equals("V2"))
	    	    	version = "V2";
	    	    
	    	   // if(i == parameter.training_file_no[parameter.training_file_counter])
	    	    //{
	    	    	parser.hardware(fileName, version, i, parameter, 1);
	    	    	//parameter.training_file_counter++;
	    	    	//System.out.println(i);
	    	    //}
			}
			
			
			/* all app */
			file = new File(parameter.softwareStatistics[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
			fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
			
			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i = 0; i < s.length; i++) {
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            }
	        }
			
			for(int i = 0; i < fileList.size(); i++) {
				Parser parser = new Parser();
				String fileName = parameter.softwareStatistics[index] + "\\" + fileList.get(i);
	        	System.out.println(i + ": "+fileName);
				parser.softwareStatisitcs(fileName, parameter);
			}
			
//			System.out.println(parameter.appUsage.size());
//			for (Map.Entry<String, Integer> entry : parameter.appUsage.entrySet())
//			{
//			    System.out.println(entry.getKey());
//			}
			/* all app */
			
			file = new File(parameter.softwareTraining[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
			fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
			
			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i = 0; i < s.length; i++) {
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            }
	        }
			
			for(int i = 0; i < fileList.size(); i++) {
				for (Map.Entry<String, Integer> entry : parameter.appUsage.entrySet())
				{
					parameter.appUsage.put(entry.getKey(), 0);
					  //System.out.println(entry.getKey()+" "+entry.getValue());
				}
				Parser parser = new Parser();
				String fileName = parameter.softwareTraining[index] + "\\" + fileList.get(i);
	        	System.out.println(i + ": "+fileName);
	        	
	        	
				parser.softwareTraining(fileName, parameter, 1);
				
				if(parameter.format == 1)
					parameter.outputTraining[i] += parameter.motionDataTraining[i];
				int counter = 7;
				for (Map.Entry<String, Integer> entry : parameter.appUsage.entrySet())
				{
					if(parameter.format == 0)
						parameter.outputTraining[i] += " "+String.valueOf(entry.getValue());
					else
					{
						parameter.outputTraining[i] += " "+counter+":"+String.valueOf(entry.getValue());
						counter++;
					
					}
					
					//System.out.println(entry.getKey()+" "+entry.getValue());
				}
				//if(parameter.format == 0)
					//parameter.outputTraining[i] += parameter.motionDataTraining[i];
				//parameter.outputTraining[i] += parameter.motionDataTraining[i];
				//System.in.read();
			}
			
			
			
			
			
			file = new File(parameter.hardwareTesting[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
			fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
			
			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i = 0; i < s.length; i++) {
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            }
	        }
			
			// 每一個不同的activity(file)
			for(int i = 0; i < fileList.size(); i++) {
				Parser parser = new Parser();
	        	String fileName = parameter.hardwareTesting[index] + "\\" + fileList.get(i);
	        	System.out.println(i + ": "+fileName);
	        	
	        	// 判斷  logger version
	        	String category = "V[1-2]+";
	    		Pattern pattern = Pattern.compile(category);
	    	    Matcher matcher = pattern.matcher(fileName);
	    	    String version = null;
	    	    boolean matchFound = matcher.find();
	    	    if(matchFound)
	    	    	version = matcher.group();
	    	    if(parameter.loggerVersion.equals("V2"))
	    	    	version = "V2";
	    	    parser.hardware(fileName, version, i, parameter, 2);
			}
			
			
			
			
			
			
			
			file = new File(parameter.softwareTesting[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
			fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
			
			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i = 0; i < s.length; i++) {
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            }
	        }
			
			for(int i = 0; i < fileList.size(); i++) {
				for (Map.Entry<String, Integer> entry : parameter.appUsage.entrySet())
				{
					parameter.appUsage.put(entry.getKey(), 0);
					  //System.out.println(entry.getKey()+" "+entry.getValue());
				}
				Parser parser = new Parser();
				String fileName = parameter.softwareTesting[index] + "\\" + fileList.get(i);
	        	System.out.println(i + ": "+fileName);
				parser.softwareTraining(fileName, parameter, 1);
				if(parameter.format == 1)
					parameter.outputTesting[i] += parameter.motionDataTesting[i];
				int counter = 7;
				for (Map.Entry<String, Integer> entry : parameter.appUsage.entrySet())
				{
					if(parameter.format == 0)
						parameter.outputTesting[i] += " "+String.valueOf(entry.getValue());
					else
					{
						parameter.outputTesting[i] += " "+counter+":"+String.valueOf(entry.getValue())+" ";
						counter++;
					}
					
					//System.out.println(entry.getKey()+" "+entry.getValue());
				}
				//if(parameter.format == 0)
					//parameter.outputTesting[i] += parameter.motionDataTesting[i];
				//parameter.outputTesting[i] += parameter.motionDataTesting[i];
				//System.in.read();
			}
			
		}
		
		Writer writerTraining;
		Writer writerTesting;
		if(parameter.format == 0)
		{
			writerTraining = new FileWriter("D:\\STAIM\\input\\demo\\training\\"+parameter.uid[0]);
			writerTesting = new FileWriter("D:\\STAIM\\input\\demo\\testing\\"+parameter.uid[0]);
		}
		else
		{
			writerTraining = new FileWriter("D:\\STAIM\\input\\libSVM\\Training\\"+parameter.uid[0]);
			writerTesting = new FileWriter("D:\\STAIM\\input\\libSVM\\Testing\\"+parameter.uid[0]);

		}

		if(parameter.format == 0)
		{
			// r bayesian不用header
			//BAYSIAN
//			for(int i = 0; i < parameter.appUsage.size(); i++) {
//				writerTraining.write(i+" ");
//				writerTesting.write(i+" ");
//			}
//			writerTraining.write("Std Lon Lat Hour Minute Speed Act");
//			writerTesting.write("Std Lon Lat Hour Minute Speed Act");
//			writerTraining.write("\n");
//			writerTesting.write("\n");
			//BAYSIAN
		}
		
		
		for(int i = 0; i < totalFile; i++) {
//			if(parameter.training_file_no[parameter.training_file_counter] == i)
//			{
//				writerTraining.write(parameter.outputTraining[i]+"\n");
//				parameter.training_file_counter++;
//				System.out.println(i);
//			}
			writerTraining.write(parameter.outputTraining[i]+"\n");
			writerTesting.write(parameter.outputTesting[i]+"\n");
		}
		writerTraining.close();
		writerTesting.close();
		System.out.println(parameter.outputTraining[0].length() - parameter.outputTraining[0].replace(" ", "").length()+1);
		parameter.appUsage.clear();
		
		
		long startTime = 0, endTime = 0, totalTime = 0;
		float cost = 1;
		Information inform = new Information();
		startTime = System.currentTimeMillis();
		for(int i =0;i <1;i++) {
			try {
				//startTime = System.currentTimeMillis();
				  String[] trainArgs = {"D:\\STAIM\\input\\libSVM\\Training\\"+parameter.imei[0]+".txt","D:\\STAIM\\input\\libSVM\\SVM Optimal\\"+parameter.imei[0]+".model"};//directory of training file  
				   svm_train.main(trainArgs, cost);
				   //endTime = System.currentTimeMillis();
				
				   			   //vm_train.main(trainArgs);
			       
			       
			    
			       String[] testArgs = {"D:\\STAIM\\input\\libSVM\\Testing\\"+parameter.imei[0]+".txt", "D:\\STAIM\\input\\libSVM\\SVM Optimal\\"+parameter.imei[0]+".model", "D:\\STAIM\\input\\libSVM\\"+parameter.imei[0]+".result"};//directory of test file, model file, result file  
			    
					svm_predict.main(testArgs, inform, cost);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			cost+=1;
		}
		System.out.println("Best Accuracy: "+inform.O_ACCURACY);
		System.out.println("Best Cost: "+inform.O_COST);
		

		endTime = System.currentTimeMillis();
		runtime = Runtime.getRuntime();
	    // Run the garbage collector
	    runtime.gc();
	    // Calculate the used memory
	    memory = runtime.totalMemory() - runtime.freeMemory();
	    System.out.println("Total time: "+(endTime-startTime));
	    System.out.println("Used memory is Mbytes: " + (double)memory/1048576);
	}
}
