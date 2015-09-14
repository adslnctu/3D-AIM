package AIMtesting;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class main {
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		long elapsedTime = 0;
		long startTime = 0;
	    long stopTime = 0;
	    
		int section = 0;
		Profile profile = new Profile();
		Parameter parameter = new Parameter();
		
		// load model
		startTime = System.currentTimeMillis();
		//for (String line : Files.readAllLines(Paths.get("D:\\STAIM\\input\\libSVM\\AIM\\"+args[0]+".txt"))) {
		for (String line : Files.readAllLines(Paths.get(parameter.model_path[0]))) {
			
			
			if(line.equals("[Threshold]"))
			{
				section = 1;
				continue;
			}
			else if(line.equals("[Speed]"))
			{
				section = 2;
				continue;
			}
			else if(line.equals("[SDDM]"))
			{
				section = 3;
				continue;
			}
			else if(line.equals("[Frequent Region]"))
			{
				section = 4;
				continue;
			}
			else if(line.equals("[Application List]"))
			{
				section = 5;
				if(profile.frIndex != -1)
					profile.clusters.add(profile.cluster);
//				System.out.println(profile.clusters.size());
//				for (int i = 0; i < profile.clusters.size(); i++) {
//					for (Map.Entry<Integer, Integer> entry :  profile.clusters.get(i).dining.entrySet())
//					{
//					    System.out.println(entry.getKey() + "/" + entry.getValue());
//					}
//		        }
				continue;
			}
			else if(line.equals("[GATDM]"))
			{
				section = 6;
				continue;
			}
			else if(line.equals("[END]"))
				section = 7;
			
			if(section == 1)
				profile.threshold = Double.valueOf(line);
			else if(section == 2)
				;
			else if(section == 3)
			{
				String[] afterSplit = line.split(" ");
				for (int i = 0; i < afterSplit.length; i++) {
					int value = Integer.parseInt(afterSplit[i]);
					profile.weightedTable[profile.weightedTableIndex][i] = value;
					
				}
				profile.weightedTableIndex++;
			}
			else if(section == 4)
			{
				//System.out.println("!!!!");
				if(line.substring(0,2).equals("FR"))
				{
					if(!line.equals("FR 0"))
						profile.clusters.add(profile.cluster);
					
					profile.frIndex = 0;
					profile.cluster = new Cluster();
				}
				else
				{
					if(profile.frIndex == 0)
					{
						String[] afterSplit = line.split(",");
						//System.out.println(line);
						profile.cluster.centralLon = Double.valueOf(afterSplit[0]);
						profile.cluster.centralLat = Double.valueOf(afterSplit[1]);
						//System.out.println(profile.cluster.centralLon+" "+profile.cluster.centralLat);
						profile.frIndex++;
					}
					else if(profile.frIndex == 1)
					{
						
							if(line.substring(0,line.indexOf(":")).equals("Working"))
							{
								for( ; !line.equals(" "); ) {
									profile.cluster.working.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
									System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
									System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
									line = line.substring(line.indexOf(")")+1,line.length());
									//System.out.println(line);
								}
								continue;
							}
								//profile.cluster.working
							if(line.substring(0,line.indexOf(":")).equals("Dining"))
							{
								for( ; !line.equals(" "); ) {
									profile.cluster.dining.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));

									System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
									System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
									line = line.substring(line.indexOf(")")+1,line.length());
									//System.out.println(line);
								}
								continue;
							}
							
							if(line.substring(0,line.indexOf(":")).equals("Transportation"))
							{
								for( ; !line.equals(" "); ) {
									profile.cluster.transportation.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));

									System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
									System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
									line = line.substring(line.indexOf(")")+1,line.length());
									//System.out.println(line);
								}
								continue;
							}
							
							if(line.substring(0,line.indexOf(":")).equals("Sporting"))
							{
								for( ; !line.equals(" "); ) {
									profile.cluster.sporting.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));

									System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
									System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
									line = line.substring(line.indexOf(")")+1,line.length());
									//System.out.println(line);
								}
								continue;
							}
							
							if(line.substring(0,line.indexOf(":")).equals("Shopping"))
							{
								for( ; !line.equals(" "); ) {
									profile.cluster.shopping.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));

									System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
									System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
									line = line.substring(line.indexOf(")")+1,line.length());
									//System.out.println(line);
								}
								continue;
							}
							
							if(line.substring(0,line.indexOf(":")).equals("Entertainment"))
							{
								for( ; !line.equals(" "); ) {
									profile.cluster.entertainment.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
									System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
									System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
									line = line.substring(line.indexOf(")")+1,line.length());
									//System.out.println(line);
								}
								continue;
							}
					
					}
				}
			}
			if(section == 5)
			{
				//System.out.println(line.substring(0,line.indexOf(":")));
				if(line.substring(0,line.indexOf(":")).equals("Working App "))
				{
					line = line.substring(line.indexOf(":")+1, line.length());
					String[] afterSplit = line.split(",");
					for(int i = 0; i < 30; i++)
						profile.workingApp[i] = afterSplit[i];
				}
				
				if(line.substring(0,line.indexOf(":")).equals("Dining App "))
				{
					line = line.substring(line.indexOf(":")+1, line.length());
					String[] afterSplit = line.split(",");
					for(int i = 0; i < 30; i++)
						profile.diningApp[i] = afterSplit[i];
				
					continue;
				}
				
				
				if(line.substring(0,line.indexOf(":")).equals("Transportation App "))
				{
					
					line = line.substring(line.indexOf(":")+1, line.length());
					String[] afterSplit = line.split(",");
					for(int i = 0; i < 30; i++)
						profile.transportationApp[i] = afterSplit[i];
				
				}
				
				if(line.substring(0,line.indexOf(":")).equals("Sporting App "))
				{
					line = line.substring(line.indexOf(":")+1, line.length());
					String[] afterSplit = line.split(",");
					for(int i = 0; i < 30; i++)
						profile.sportingApp[i] = afterSplit[i];
					continue;
				}
				
				if(line.substring(0,line.indexOf(":")).equals("Shopping App "))
				{
					line = line.substring(line.indexOf(":")+1, line.length());
					String[] afterSplit = line.split(",");
					for(int i = 0; i < 30; i++)
						profile.shoppingApp[i] = afterSplit[i];
					continue;
				}
				
				if(line.substring(0,line.indexOf(":")).equals("EntertainmentApp App "))
				{
					line = line.substring(line.indexOf(":")+1, line.length());
					String[] afterSplit = line.split(",");
					for(int i = 0; i < 30; i++)
						profile.entertainmentApp[i] = afterSplit[i];
				
				}
			}
			if(section == 6)
			{
				if(line.substring(0,line.indexOf(":")).equals("Working"))
				{
					for( ; !line.equals(" "); ) {
						profile.wTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
						//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
						//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
						line = line.substring(line.indexOf(")")+1,line.length());
						//System.out.println(line);
					}
					continue;
				}
				
				if(line.substring(0,line.indexOf(":")).equals("Dining"))
				{
					for( ; !line.equals(" "); ) {
						profile.dTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
						//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
						//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
						line = line.substring(line.indexOf(")")+1,line.length());
						//System.out.println(line);
					}
					continue;
				}
				
				if(line.substring(0,line.indexOf(":")).equals("Transportation"))
				{
					for( ; !line.equals(" "); ) {
						profile.tTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
						//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
						//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
						line = line.substring(line.indexOf(")")+1,line.length());
						//System.out.println(line);
					}
					continue;
				}
				
				if(line.substring(0,line.indexOf(":")).equals("Entertainment"))
				{
					for( ; !line.equals(" "); ) {
						profile.eTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
						//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
						//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
						line = line.substring(line.indexOf(")")+1,line.length());
						//System.out.println(line);
					}
					continue;
				}
				
				if(line.substring(0,line.indexOf(":")).equals("Sporting"))
				{
					for( ; !line.equals(" "); ) {
						profile.spTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
						//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
						//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
						line = line.substring(line.indexOf(")")+1,line.length());
						//System.out.println(line);
					}
					continue;
				}
			
				if(line.substring(0,line.indexOf(":")).equals("Shopping"))
				{
					for( ; !line.equals(" "); ) {
						profile.shTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
						//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
						//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
						line = line.substring(line.indexOf(")")+1,line.length());
						//System.out.println(line);
					}
					continue;
				}
			}
		}
		stopTime = System.currentTimeMillis();
		elapsedTime += stopTime - startTime;
		
		

		/* giving software score for each file */
		
			
		for(int index = 0; index < parameter.softwareTesting.length; index++) {
			File file = new File(parameter.softwareTesting[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
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
			profile.numberOfFile = fileList.size();
			for(int i = 0; i < fileList.size(); i++) {
				Parser parser = new Parser();
	        	String fileName = parameter.softwareTesting[index] + "\\" + fileList.get(i);
	        	System.out.println(i + ": "+fileName);
	        	SoftwarePhase softwarePhase = new SoftwarePhase();
	        	softwarePhase.testing(fileName, profile, i, elapsedTime);
			}
		}	
		/* giving software score & testing */

		
		/* giving location & weighted table score for each file */
		double counter = 0, correct = 0;
		for(int index = 0; index < parameter.hardwareTesting.length; index++) {
			File file = new File(parameter.hardwareTesting[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
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
			for(int i = 0; i < fileList.size(); i++) {
				Parser parser = new Parser();
	        	String fileName = parameter.hardwareTesting[index] + "\\" + fileList.get(i);
	        	System.out.println(i + ": "+fileName);
	        	int space = fileName.indexOf(" ");
	        	String dateString = fileName.substring(space-10, space);
	        	SimpleDateFormat dateStringFormat = new SimpleDateFormat( "yyyy-MM-dd" );
	    	    Date date = dateStringFormat.parse( dateString );

	    	    SimpleDateFormat date2DayFormat = new SimpleDateFormat( "u" );
	    	    //System.out.println( date2DayFormat.format( date ));
	        	if(Integer.parseInt(date2DayFormat.format( date ))==1)
	        		profile.mon++;
	        	if(Integer.parseInt(date2DayFormat.format( date ))==2)
	        		profile.tue++;
	        	if(Integer.parseInt(date2DayFormat.format( date ))==3)
	        		profile.wen++;
	        	if(Integer.parseInt(date2DayFormat.format( date ))==4)
	        		profile.thu++;
	        	if(Integer.parseInt(date2DayFormat.format( date ))==5)
	        		profile.fri++;
	        	if(Integer.parseInt(date2DayFormat.format( date ))==6)
	        		profile.sat++;
	        	if(Integer.parseInt(date2DayFormat.format( date ))==7)
	        		profile.sun++;
	    	    
	        	
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
	    	    
	    	    int value = parser.testing(fileName, profile, version, i, elapsedTime);

	    	    if(value == 1)
	    	    	correct++;
	    	    counter++;
			}
			
		}

//		// 只有hardware部分
		//System.out.println("Accuracy: " + correct/counter + " " + correct +" "+counter );
		/* giving location & weighted table score for each file */
		
		
//		int hit = 0;
//		for(int i = 0; i < profile.numberOfFile; i++) {
//			double scoreForSoftware[] =  new double[6];
//			double scoreForLocation[] =  new double[6];
//			double scoreForDistributionMatrix[] =  new double[6];
//			double scoreForTotal[] = new double[6];
//			double totalSoftware = 0;
//			double totalLocation = 0;
//			double totalDistributionMatrix = 0;
//			int total = 0, inference = -1;
//			if(profile.speed[i] >= 40)
//				inference = 2;
////			else if(profile[0].std[i] >= 2.4)
////				inference = 4;
//			else
//			{
//				for(int j = 0; j < 6; j++) {
//					totalSoftware += profile.softwareScore[i][j];
//					totalLocation += profile.locationScore[i][j];
//					totalDistributionMatrix += profile.distributionMatrixScore[i][j];
//				}
//				
//				for(int j = 0; j < 6; j++) {
//					if(totalSoftware != 0)
//						scoreForSoftware[j] =  (double)profile.softwareScore[i][j] / totalSoftware;
//					else
//						scoreForSoftware[j] = 0;
//					
//					if(totalLocation != 0)
//						scoreForLocation[j] =  (double)profile.locationScore[i][j] / totalLocation;
//					else
//						scoreForLocation[j] = 0;
//					
//					if(totalDistributionMatrix != 0)
//						scoreForDistributionMatrix[j] =  (double)profile.distributionMatrixScore[i][j] / totalDistributionMatrix;
//					else
//						scoreForDistributionMatrix[j] = 0;
//
//				}
//				
//				/* determined by sum of three factor*/
//				// sum score
//				for(int j = 0; j < 6; j++) {
//					//scoreForTotal[j] = scoreForLocation[j];
//					//scoreForTotal[j] = scoreForDistributionMatrix[j];
//					//scoreForTotal[j] += scoreForSoftware[j];
//					scoreForTotal[j] += scoreForSoftware[j] + scoreForLocation[j] + scoreForDistributionMatrix[j];  
//				}
//				// max score
////				for(int j = 0; j < 6; j++) {
////					double max = 0;
////					max = Math.max(scoreForSoftware[j], scoreForLocation[j]);
////					max = Math.max(max, scoreForDistributionMatrix[j]);
////					scoreForTotal[j] = max;
////					System.out.print(scoreForTotal[j]+ " ");
////				}
//			
//			
//		    
//			double maxValue = 0;
//			for(int j = 0; j < 6; j++) {
//				if(scoreForTotal[j] > maxValue)
//				{
//						inference = j;
//						maxValue = scoreForTotal[j];
//				}
//			}
//			if(inference == -1)
//				inference = 0;
//			
//			try
//			{
//				
//				if(profile.lable[i].equals("Working") && inference == 0)
//				{
//					hit++;
//					profile.workingHit++;
//				}	
//				else if(profile.lable[i].equals("Dining") && inference == 1)
//				{
//					hit++;
//					profile.diningHit++;
//				}
//				else if(profile.lable[i].equals("Transportation") && inference == 2)
//				{
//					hit++;
//					profile.transportationHit++;
//				}
//				else if(profile.lable[i].equals("Entertainment") && inference == 3)
//				{
//					hit++;
//					profile.entertainmentHit++;
//				}
//				else if(profile.lable[i].equals("Sporting") && inference == 4)
//				{
//					hit++;
//					profile.sportingHit++;
//				}
//				else if(profile.lable[i].equals("Shopping") && inference == 5)
//				{
//					hit++;
//					profile.shoppingHit++;
//				}	
//			} catch(Exception e)
//			{
//				System.out.println(profile.lable[i]);
//			}
//				
//				
//				
//			}
//		}

		
		/* BRUTE FORCE FOR COEFFICIENT*/
//		startTime = System.currentTimeMillis();
//		double theHighestCoefficient[] = new double [3];
//		double theHighestScore = 0;
//		double theHighestHit = 0;
//		for(int it_a = 0; it_a <= 10; it_a++) {
//			for(int it_b = 0; it_b <= 10; it_b++) {
//				int dTotal = 0;
//				int wTotal = 0;
//				int tTotal = 0;
//				int shTotal = 0;
//				int spTotal = 0;
//				int eTotal = 0;
//				
//				int dHit = 0;
//				int wHit = 0;
//				int tHit = 0;
//				int shHit = 0;
//				int spHit = 0;
//				int eHit = 0;
//				
//				double a = 0, b = 0, c = 0;
//				a = (double)it_a * 0.1;
//				b = (double)it_b * 0.1;
//				c = 1 - a - b;
//				if(a+b>=1.1)
//					break;
//				
//				int hit = 0;
//				for(int i = 0; i < profile.numberOfFile; i++) {
//					double scoreForSoftware[] =  new double[6];
//					double scoreForLocation[] =  new double[6];
//					double scoreForDistributionMatrix[] =  new double[6];
//					double scoreForTotal[] = new double[6];
//					double totalSoftware = 0;
//					double totalLocation = 0;
//					double totalDistributionMatrix = 0;
//					
//					for(int j = 0; j < 6; j++) {
//						totalSoftware += profile.softwareScore[i][j];
//						totalLocation += profile.locationScore[i][j];
//						totalDistributionMatrix += profile.distributionMatrixScore[i][j];
//					}
//					
//					for(int j = 0; j < 6; j++) {
//						if(totalSoftware != 0)
//							scoreForSoftware[j] =  (double)profile.softwareScore[i][j] / totalSoftware;
//						else
//							scoreForSoftware[j] = 0;
//						
//						if(totalLocation != 0)
//							scoreForLocation[j] =  (double)profile.locationScore[i][j] / totalLocation;
//						else
//							scoreForLocation[j] = 0;
//						
//						if(totalDistributionMatrix != 0)
//							scoreForDistributionMatrix[j] =  (double)profile.distributionMatrixScore[i][j] / totalDistributionMatrix;
//						else
//							scoreForDistributionMatrix[j] = 0;
//
//					}
//					
//					for(int j = 0; j < 6; j++) {
//						//scoreForTotal[j] = scoreForLocation[j];
//						//scoreForTotal[j] = scoreForDistributionMatrix[j];
//						//scoreForTotal[j] += scoreForSoftware[j];
//						scoreForTotal[j] += a*scoreForSoftware[j] + b*scoreForLocation[j] + c*scoreForDistributionMatrix[j];  
//					}
//					
//					double maxValue = 0;
//					int inference = -1;
//					for(int j = 0; j < 6; j++) {
//						if(scoreForTotal[j] > maxValue)
//						{
//							inference = j;
//							maxValue = scoreForTotal[j];
//						}
//					}
//	
//					if(profile.lable[i].equals("Working"))
//						wTotal++;
//					if(profile.lable[i].equals("Dining"))
//						dTotal++;
//					if(profile.lable[i].equals("Transportation"))
//						tTotal++;
//					if(profile.lable[i].equals("Entertainment"))	
//						eTotal++;
//					if(profile.lable[i].equals("Sporting"))
//						spTotal++;
//					if(profile.lable[i].equals("Shopping"))
//						shTotal++;
//							
//					//System.out.println("============");
//					if(profile.lable[i].equals("Working") && inference == 0)
//					{
//						wHit++;
//						hit++;
//						
//					}	
//					else if(profile.lable[i].equals("Dining") && inference == 1)
//					{
//						dHit++;
//						hit++;
//						
//					}
//					else if(profile.lable[i].equals("Transportation") && inference == 2)
//					{
//						tHit++;
//						hit++;
//						
//					}
//					else if(profile.lable[i].equals("Entertainment") && inference == 3)
//					{
//						eHit++;
//						hit++;
//						
//					}
//					else if(profile.lable[i].equals("Sporting") && inference == 4)
//					{
//						spHit++;
//						hit++;
//						
//					}
//					else if(profile.lable[i].equals("Shopping") && inference == 5)
//					{
//						shHit++;
//						hit++;
//						
//					}	
//					
//				
//
//				}		
//				if((double)hit/(double)profile.numberOfFile > theHighestScore)
//				{
//					theHighestScore = (double)hit/(double)profile.numberOfFile;
//					theHighestCoefficient[0] = a;
//					theHighestCoefficient[1] = b;
//					theHighestCoefficient[2] = c;
//					theHighestHit = hit;
//				}
//			}
//		}
//		stopTime = System.currentTimeMillis();
//		elapsedTime += stopTime - startTime;
//		System.out.println("[total]: "+profile.numberOfFile+" [hit]: "+theHighestHit+" [coefficient of software part]: "+theHighestCoefficient[0]+" [coefficient of spatial-temporal part]: "+theHighestCoefficient[1]+" [coefficient of motion part]: "+theHighestCoefficient[2]);

		
		
		/* 把score輸出到file就不用每次重train得分  */
		int hit = 0;
		Writer writer = new FileWriter("D:\\STAIM\\input\\preference\\"+parameter.imei[0]+".txt");
		for(int i = 0; i < profile.numberOfFile; i++) {
			
			double scoreForSoftware[] =  new double[6];
			double scoreForLocation[] =  new double[6];
			double scoreForDistributionMatrix[] =  new double[6];
			double scoreForTotal[] = new double[6];
			double totalSoftware = 0;
			double totalLocation = 0;
			double totalDistributionMatrix = 0;
			int total = 0, inference = -1;
			
			System.out.println(i+" "+profile.lable[i]);
			writer.write(profile.lable[i]+"\n");
			for(int j = 0; j < 6; j++)
				System.out.print(profile.softwareScore[i][j]+" ");
			System.out.println();
			for(int j = 0; j < 6; j++)
				System.out.print(profile.locationScore[i][j]+" ");
			System.out.println();
			for(int j = 0; j < 6; j++)
				System.out.print(profile.distributionMatrixScore[i][j] +" ");
			System.out.print("\n"+profile.speed[i] +" ");
			writer.write(profile.speed[i]+"\n");
			System.out.println("\n"+profile.std[i] +" ");
			writer.write(profile.std[i]+"\n");
			if(profile.speed[i] >= 40)
				inference = 2;
			else if(profile.std[i] >= 2.4)
				//inference = 4;
				profile.twoPointFour++;
			else
			{
				for(int j = 0; j < 6; j++) {
					totalSoftware += profile.softwareScore[i][j];
					totalLocation += profile.locationScore[i][j];
					totalDistributionMatrix += profile.distributionMatrixScore[i][j];
				}
				
				for(int j = 0; j < 6; j++) {
					if(totalSoftware != 0)
						scoreForSoftware[j] =  (double)profile.softwareScore[i][j] / totalSoftware;
					else
						scoreForSoftware[j] = 0;
					
					if(totalLocation != 0)
						scoreForLocation[j] =  (double)profile.locationScore[i][j] / totalLocation;
					else
						scoreForLocation[j] = 0;
					
					if(totalDistributionMatrix != 0)
						scoreForDistributionMatrix[j] =  (double)profile.distributionMatrixScore[i][j] / totalDistributionMatrix;
					else
						scoreForDistributionMatrix[j] = 0;

				}
				for(int j = 0; j < 6; j++)
					writer.write(scoreForSoftware[j]+" ");
				writer.write("\n");
				for(int j = 0; j < 6; j++)
					writer.write(scoreForLocation[j]+" ");
				writer.write("\n");
				for(int j = 0; j < 6; j++)
					writer.write(scoreForDistributionMatrix[j] +" ");
				writer.write("\n");
				/* determined by sum of three factor*/
				// sum score
				for(int j = 0; j < 6; j++) {
					//scoreForTotal[j] += scoreForLocation[j] + scoreForDistributionMatrix[j];
					//scoreForTotal[j] += scoreForSoftware[j];
					scoreForTotal[j] += scoreForSoftware[j] + scoreForLocation[j] + scoreForDistributionMatrix[j];  
				}
				for(int j = 0; j < 6; j++)
					System.out.print(scoreForTotal[j] +" ");
				System.out.println();
				// max score
//				for(int j = 0; j < 6; j++) {
//					double max = 0;
//					max = Math.max(scoreForSoftware[j], scoreForLocation[j]);
//					max = Math.max(max, scoreForDistributionMatrix[j]);
//					scoreForTotal[j] = max;
//					System.out.print(scoreForTotal[j]+ " ");
//				}
			System.out.println();
			
		    startTime = System.currentTimeMillis();
			double maxValue = 0;
			for(int j = 0; j < 6; j++) {
				if(scoreForTotal[j] > maxValue)
				{
						inference = j;
						maxValue = scoreForTotal[j];
				}
			}
			
			if(inference == 0)
				System.out.println("Working");
			if(inference == 1)
				System.out.println("Dining");
			if(inference == 2)
				System.out.println("Transportation");
			if(inference == 3)
				System.out.println("Entertainment");
			if(inference == 4)
				System.out.println("Sporting");
			if(inference == 5)
				System.out.println("Sporting");
			
			
			System.out.println("\n===============================");
			writer.write("===============================\n");
			try
			{
				if(profile.lable[i].equals("Working"))
						profile.workingTotal++;
				else if(profile.lable[i].equals("Dining"))
					profile.diningTotal++;
				else if(profile.lable[i].equals("Transportation"))
					profile.transportationTotal++;
				else if(profile.lable[i].equals("Entertainment"))
					profile.entertainmentTotal++;
				else if(profile.lable[i].equals("Sporting"))
					profile.sportingTotal++;
				else if(profile.lable[i].equals("Shopping"))
					profile.shoppingTotal++;
				
				/* threshold-based model */
				// calculate false positive
				// if(profile.lable[i].equals("Working") || profile.lable[i].equals("Dining") || profile.lable[i].equals("Transportation") || profile.lable[i].equals("Entertainment") || profile.lable[i].equals("Shopping"))
				// {
				//		if(inference == 4)
				//			false positive++
				// }
				
				
				
				/* testing data的activity是working，且用model推測出來的結果也是working */
				if(profile.lable[i].equals("Working") && inference == 0)
				{
					hit++;
					profile.workingHit++;
				}	
				/* testing data的activity是Dining，且用model推測出來的結果也是Dining */
				else if(profile.lable[i].equals("Dining") && inference == 1)
				{
					hit++;
					profile.diningHit++;
				}
				/* testing data的activity是Transportation，且用model推測出來的結果也是Transportation */
				else if(profile.lable[i].equals("Transportation") && inference == 2)
				{
					hit++;
					profile.transportationHit++;
				}
				/* testing data的activity是Entertainment，且用model推測出來的結果也是Entertainment */
				else if(profile.lable[i].equals("Entertainment") && inference == 3)
				{
					hit++;
					profile.entertainmentHit++;
				}
				/* testing data的activity是Sporting，且用model推測出來的結果也是Sporting */
				else if(profile.lable[i].equals("Sporting") && inference == 4)
				{
					hit++;
					profile.sportingHit++;
				}
				/* testing data的activity是Shopping，且用model推測出來的結果也是Shopping */
				else if(profile.lable[i].equals("Shopping") && inference == 5)
				{
					hit++;
					profile.shoppingHit++;
				}	
				
				
			} 
			catch(Exception e)
			{
				System.out.println(profile.lable[i]);
			}
			stopTime = System.currentTimeMillis();
		    elapsedTime += stopTime - startTime;
			
			
		}
		}
		writer.close();
		
		/* 把score輸出到file就不用每次重train得分  */
		
		profile = null;
		
		System.out.println("End!\n Accuracy: " + hit+" "+profile.numberOfFile+" "+(double)hit/profile.numberOfFile);
		System.out.println("Dining : "+profile.diningHit+" "+profile.diningTotal);
		System.out.println("Sporting : "+profile.sportingHit+" "+profile.sportingTotal);
		System.out.println("Working : "+profile.workingHit+" "+profile.workingTotal);
		System.out.println("Transportation : "+profile.transportationHit+" "+profile.transportationTotal);
		System.out.println("Shopping : "+profile.shoppingHit+" "+profile.shoppingTotal);
		System.out.println("Entertainment : "+profile.entertainmentHit+" "+profile.entertainmentTotal);
		Runtime runtime = Runtime.getRuntime();
 	    // Run the garbage collector
 	    runtime.gc();
 	    // Calculate the used memory
 	    long memory = runtime.totalMemory() - runtime.freeMemory();
 	   System.out.println("Used Time: "+elapsedTime);
 	    System.out.println("Used memory is Mbytes:"+(double)memory/1048576);
 	   System.out.println(profile.publicHit);
 	   System.out.println(profile.totalGps+" "+profile.publicOpinionUsed);
 
 	  
	}


}
