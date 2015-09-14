package AIM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.instrument.Instrumentation;



public class main {
	
//	long startTime = System.currentTimeMillis();
//    long stopTime = System.currentTimeMillis();
//    long elapsedTime = stopTime - startTime;
//    System.out.println(elapsedTime);
	
	public static double rad(double a)
	 {
	    	return a * Math.PI/180.0;
	 }
	
	public static double distance(double raw_lon1, double raw_lat1, double raw_lon2, double raw_lat2) 
	{
		double lat1=rad(raw_lat1);
    	double lat2=rad(raw_lat2);
        double lon1=rad(raw_lon1);
        double lon2=rad(raw_lon2);
		double earth_radius=6378.137;  
        double a=lat1-lat2;
        double b=lon1-lon2;
        double s=2d * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2d),2d) + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(b/2d),2d)));
                  
        s = s * earth_radius;
        s = Math.round(s * 10000d) / 10000d;
        
		return s;
	}
	

	   
	public static void main(String[] args) throws Exception
	{

		
		/* program load進來時的memory */
		
	    String modelData = new String();
		/* initial block */
	    float trainingTime = 0;
	    double trainingMemory = 0;
	    long elapsedTime = 0;
		long startTime = 0;
	    long stopTime = 0;
	    Distribution distribution = new Distribution();
		Parameter parameter = new Parameter();	
		Profile profile[] = new Profile[1];
		/* initial block */
		
		System.out.println("Start!\n");
	
		/* hardware training for each user */
		for(int index = 0; index < parameter.hardwareTraining.length; index++) {
			
			/* initial block for each user*/
			profile[index] = new Profile();
			/* initial block for each user*/
			
			/* weighted table + time distribution + frequent region */
			File file = new File(parameter.hardwareTraining[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
			ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
			
			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list	            
	            for(int i = 0; i < s.length; i++) {
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            }
	        }
			
			// 每一個不同的activity(file)
			profile[index].numberOfFile = fileList.size();
			
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

	    	    
	    	    profile[index].trajectory.clear(); // 每個activity(file)的trajectory加入到dpoint內
	    	    parser.buildProfile(fileName, profile[index], version, i, elapsedTime);
	    	    /* for learning curve */
//	    	    Random ran = new Random();
//				int temp = ran.nextInt(10)+1;
//				double randomNumber = (double) temp * 0.1;
//				System.out.println("enough "+(fileList.size()-i)+" "+ Math.abs((fileList.size()*parameter.learningRatio - parameter.learningNumber)));
//				if(randomNumber <= parameter.learningRatio || fileList.size() - i < Math.abs((fileList.size()*parameter.learningRatio - parameter.learningNumber)))
//				{
//					parameter.learningCurveTraining[parameter.learningNumber] = i;
//					parameter.learningNumber++;
//					parser.buildProfile(fileName, profile[index], version, i, elapsedTime);
//				}
			}
			
//			/* for learning curve */
//			Writer learningCurveTrainingData = new FileWriter("D:\\STAIM\\input\\learning_curve\\training_data_no\\TEST_1\\20\\"+parameter.imei[0]+".txt");			
//			System.out.println("Learning:"+parameter.learningNumber);
//			for(int i = 0; i < parameter.learningNumber; i++) {
//				System.out.println(parameter.learningCurveTraining[i]+" ");
//				learningCurveTrainingData.write(parameter.learningCurveTraining[i]+System.getProperty( "line.separator" ));
//			}
//			learningCurveTrainingData.close();
			/* for learning curve */
			
			
			// AIM'model
			startTime = System.currentTimeMillis();
			modelData += "[Treshold]"+System.getProperty( "line.separator" )+"2.4"+System.getProperty( "line.separator" )+"[Speed]"+System.getProperty( "line.separator" )+"40"+System.getProperty( "line.separator" );
			modelData += "[SDDM]" + System.getProperty( "line.separator" );
			for(int i = 0; i < 24; i++) {
				for(int j = 0; j < 6; j++) {
					modelData += profile[0].weightedTable[i][j]+" ";
				}
				modelData += System.getProperty( "line.separator" );
			}
			
			System.out.println("GPS points:" + profile[index].dpoints.size());
			/* stay point detection */
			int gps_i = 0, gps_j = 0, gpsNum = profile[index].dpoints.size(), token = 0;
			while(gps_i < gpsNum) {
				
				gps_j = gps_i + 1;
				token = 0;
				while(gps_j < gpsNum) {
					double dist = distance(profile[index].dpoints.get(gps_i).getLongitude(),profile[index].dpoints.get(gps_i).getLatitude(),profile[index].dpoints.get(gps_j).getLongitude(),profile[index].dpoints.get(gps_j).getLatitude());
					if(profile[index].dpoints.get(gps_i).getActivity().equals(profile[index].dpoints.get(gps_j).getActivity()))
					{
					
					
						if(dist > parameter.distanceThreshold)
						{
							
							String timestamp2 = profile[index].dpoints.get(gps_j).getTimestamp();
							String timestamp1 = profile[index].dpoints.get(gps_i).getTimestamp();
							
							Date date1=new Date(Long.parseLong(timestamp1));
							Date date2=new Date(Long.parseLong(timestamp2));
							
							long diff= date2.getTime() -date1.getTime();
							
							long diffMinutes = diff / (60 * 1000) % 60;
							long diffHours = diff / (60 * 60 * 1000) % 24;
							long diffDays = diff / (24 * 60 * 60 * 1000);
							diffMinutes = diffMinutes + diffHours * 60 + diffDays * 1440;
							if(diffMinutes > parameter.timeThreshold)
							{
								System.out.println("[stay point]"+" "+gps_i+" "+gps_j);
								System.out.println(profile[index].dpoints.get(gps_i).getLongitude()+" "+profile[index].dpoints.get(gps_i).getLatitude());
								System.out.println(profile[index].dpoints.get(gps_j).getLongitude()+" "+profile[index].dpoints.get(gps_j).getLatitude());
								double averageLon = 0;
								double averageLat = 0;
								double speed = 0;
								String activity = "";
								
								ArrayList<String> activtiyList= new ArrayList<String>();
								ArrayList<String> timestampList= new ArrayList<String>();
								for(int gps_k = gps_i; gps_k <= gps_j; gps_k++) {
									//System.out.println(profile[index].dpoints.get(gps_k).getActivity());
									if(gps_k == gps_i)
									{
										activity = profile[index].dpoints.get(gps_k).getActivity();
										activtiyList.add(activity);
										timestampList.add(profile[index].dpoints.get(gps_k).getTimestamp());
									}
									else
									{
										if(activity.equals(profile[index].dpoints.get(gps_k).getActivity()))
											;
										else
										{
											activity = profile[index].dpoints.get(gps_k).getActivity();
											activtiyList.add(activity);
											timestampList.add(profile[index].dpoints.get(gps_k).getTimestamp());
											
										}
									}
										
									averageLon += profile[index].dpoints.get(gps_k).getLongitude();
									averageLat += profile[index].dpoints.get(gps_k).getLatitude();
									if(profile[index].dpoints.get(gps_k).getSpeed() > speed)
										speed = profile[index].dpoints.get(gps_k).getSpeed();
								}
								
								int counter = (gps_j-gps_i+1);
								averageLon /= counter;
								averageLat /= counter;
								
								double[] gpsPoint={averageLat, averageLon};
				    			
								System.out.println(">>>>"+activtiyList.size());
				    			for(int x = 0; x < activtiyList.size(); x++)
								{
				    				Date date = new Date(Long.parseLong(timestampList.get(x)));
				    				System.out.println( activtiyList.get(x)+" "+date);
				    				profile[index].stayPointSet.add(new DataPoint(gpsPoint, String.valueOf(profile[index].gpsPointName2),  activtiyList.get(x), timestampList.get(x), speed));
					    			profile[index].gpsPointName2++;
									
								}
				    			
				    			
								gps_i =gps_j;
								token=1;
								
							}
							break;
						}
						gps_j = gps_j +1;
					}
					else
					{
						dist = distance(profile[index].dpoints.get(gps_i).getLongitude(),profile[index].dpoints.get(gps_i).getLatitude(),profile[index].dpoints.get(gps_j-1).getLongitude(),profile[index].dpoints.get(gps_j-1).getLatitude());
						if(dist < parameter.distanceThreshold)
						{
							
							String timestamp2 = profile[index].dpoints.get(gps_j-1).getTimestamp();
							String timestamp1 = profile[index].dpoints.get(gps_i).getTimestamp();
							
							Date date1=new Date(Long.parseLong(timestamp1));
							Date date2=new Date(Long.parseLong(timestamp2));
							
							long diff= date2.getTime() -date1.getTime();
							
							long diffMinutes = diff / (60 * 1000) % 60;
							long diffHours = diff / (60 * 60 * 1000) % 24;
							long diffDays = diff / (24 * 60 * 60 * 1000);
							diffMinutes = diffMinutes + diffHours * 60 + diffDays * 1440;
							if(diffMinutes > parameter.timeThreshold)
							{
								System.out.println("[stay point]"+" "+gps_i+" "+(gps_j-1));
								System.out.println(profile[index].dpoints.get(gps_i).getLongitude()+" "+profile[index].dpoints.get(gps_i).getLatitude());
								System.out.println(profile[index].dpoints.get(gps_j-1).getLongitude()+" "+profile[index].dpoints.get(gps_j-1).getLatitude());
								double averageLon = 0;
								double averageLat = 0;
								double speed = 0;
								String activity = "";
								
								
								ArrayList<String> activtiyList= new ArrayList<String>();
								ArrayList<String> timestampList= new ArrayList<String>();
								for(int gps_k = gps_i; gps_k < gps_j; gps_k++) {
									//System.out.println(profile[index].dpoints.get(gps_k).getActivity());
									if(gps_k == gps_i)
									{
										activity = profile[index].dpoints.get(gps_k).getActivity();
										activtiyList.add(activity);
										timestampList.add(profile[index].dpoints.get(gps_k).getTimestamp());
									}
									else
									{
										if(activity.equals(profile[index].dpoints.get(gps_k).getActivity()))
											;
										else
										{
											activity = profile[index].dpoints.get(gps_k).getActivity();
											activtiyList.add(activity);
											timestampList.add(profile[index].dpoints.get(gps_k).getTimestamp());
											
										}
									}
										
									averageLon += profile[index].dpoints.get(gps_k).getLongitude();
									averageLat += profile[index].dpoints.get(gps_k).getLatitude();
									if(profile[index].dpoints.get(gps_k).getSpeed() > speed)
										speed = profile[index].dpoints.get(gps_k).getSpeed();
								}
								
								int counter = (gps_j-gps_i);
								averageLon /= counter;
								averageLat /= counter;
								
								double[] gpsPoint={averageLat, averageLon};
				    			
								System.out.println(">>>>"+activtiyList.size());
				    			for(int x = 0; x < activtiyList.size(); x++)
								{
				    				Date date = new Date(Long.parseLong(timestampList.get(x)));
				    				System.out.println( activtiyList.get(x)+" "+date);
				    				profile[index].stayPointSet.add(new DataPoint(gpsPoint, String.valueOf(profile[index].gpsPointName2),  activtiyList.get(x), timestampList.get(x), speed));
					    			profile[index].gpsPointName2++;
									
								}
								gps_i =gps_j;
								token=1;
							}
							else
							{
								gps_i = gps_j;
								token=1;
								break;
							}
							break;
						}
						else
						{
							gps_i = gps_j;
							token=1;
							break;
						}
					}
				}
				if(token!=1)
					gps_i = gps_i +1;
				
			}
			/* stay point detection */
			
			profile[index].dpoints.clear();
			//System.out.println(profile[index].stayPointSet.size()+"~~~~~~~~~");
			
			/* OPTICS */
			Optics ca = new Optics();
    		ca.startAnalysis(profile[index].stayPointSet, parameter.mpt, parameter.radius, profile[index].clusters);
    		for(int j = 0; j < profile[index].clusters.size(); j++) {
    			
    			double lat = 0, lon = 0;
    			for(int k = 0; k < profile[index].clusters.get(j).gpsPoint.size(); k++)
    			{
    				
    				String timestamp = profile[index].clusters.get(j).gpsPoint.get(k).getTimestamp(); 
    				timestamp = timestamp.substring(0, timestamp.length()-3);
    				long hour = Long.valueOf(timestamp);
    				Calendar calendar = Calendar.getInstance();
    				calendar.setTimeInMillis(hour * 1000);
    				int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    				//System.out.println(clusters.get(i).gpsPoint.get(j).getLongitude()+" "+clusters.get(i).gpsPoint.get(j).getLatitude()+" "+clusters.get(i).gpsPoint.get(j).getActivity()+" "+hourOfDay);
    				lat += profile[index].clusters.get(j).gpsPoint.get(k).getLatitude();
    				lon += profile[index].clusters.get(j).gpsPoint.get(k).getLongitude();
    				
    				
    				// 每一群內activity時間的分布
    				if(profile[index].clusters.get(j).gpsPoint.get(k).getActivity().equals("Working"))
    				{
    					if(profile[index].clusters.get(j).working.containsKey(hourOfDay))
    						profile[index].clusters.get(j).working.put(hourOfDay, profile[index].clusters.get(j).working.get(hourOfDay)+1);
    					else
    						profile[index].clusters.get(j).working.put(hourOfDay, 1);
    				}
    				else if(profile[index].clusters.get(j).gpsPoint.get(k).getActivity().equals("Dining"))
    				{
    					if(profile[index].clusters.get(j).dining.containsKey(hourOfDay))
    						profile[index].clusters.get(j).dining.put(hourOfDay, profile[index].clusters.get(j).dining.get(hourOfDay)+1);
    					else
    						profile[index].clusters.get(j).dining.put(hourOfDay, 1);
    				}
    				else if(profile[index].clusters.get(j).gpsPoint.get(k).getActivity().equals("Transportation"))
    				{
    					if(profile[index].clusters.get(j).transportation.containsKey(hourOfDay))
    						profile[index].clusters.get(j).transportation.put(hourOfDay, profile[index].clusters.get(j).transportation.get(hourOfDay)+1);
    					else
    						profile[index].clusters.get(j).transportation.put(hourOfDay, 1);
    				}
    				else if(profile[index].clusters.get(j).gpsPoint.get(k).getActivity().equals("Shopping"))
    				{
    					if(profile[index].clusters.get(j).shopping.containsKey(hourOfDay))
    						profile[index].clusters.get(j).shopping.put(hourOfDay, profile[index].clusters.get(j).shopping.get(hourOfDay)+1);
    					else
    						profile[index].clusters.get(j).shopping.put(hourOfDay, 1);
    				}
    				else if(profile[index].clusters.get(j).gpsPoint.get(k).getActivity().equals("Entertainment"))
    				{
    					if(profile[index].clusters.get(j).entertainment.containsKey(hourOfDay))
    						profile[index].clusters.get(j).entertainment.put(hourOfDay, profile[index].clusters.get(j).entertainment.get(hourOfDay)+1);
    					else
    						profile[index].clusters.get(j).entertainment.put(hourOfDay, 1);
    				}
    				else if(profile[index].clusters.get(j).gpsPoint.get(k).getActivity().equals("Sporting"))
    				{
    					if(profile[index].clusters.get(j).sporting.containsKey(hourOfDay))
    						profile[index].clusters.get(j).sporting.put(hourOfDay, profile[index].clusters.get(j).sporting.get(hourOfDay)+1);
    					else
    						profile[index].clusters.get(j).sporting.put(hourOfDay, 1);
    				}
    			}
    			
    			if(profile[index].clusters.get(j).gpsPoint.size() > 0)
    			{
    				profile[index].clusters.get(j).centralLat = lat / profile[index].clusters.get(j).gpsPoint.size();
    				profile[index].clusters.get(j).centralLon = lon / profile[index].clusters.get(j).gpsPoint.size();
    			}
    		}
    		/* OPTICS */
    		/* weighted table + time distribution + frequent region are ready */
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		// AIM model
    		// 輸出群的中心點以及這個群的activity的時間分布
    		modelData += "[Frequent Region]"+System.getProperty( "line.separator" );
    		for(int i = 0; i < profile[0].clusters.size(); i++) {
    			modelData += "FR "+i+System.getProperty( "line.separator" );
    			modelData += profile[0].clusters.get(i).centralLon+","+profile[0].clusters.get(i).centralLat+System.getProperty( "line.separator" );;
    			//System.out.println(profile.clusters.get(i).centralLon+" "+profile.clusters.get(i).centralLat);
    			if(profile[0].clusters.get(i).working.size() > 0)
    			{
    				modelData += "Working: ";
    				for (Map.Entry<Integer, Integer> entry : profile[0].clusters.get(i).working.entrySet())
    					modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
    					//System.out.println("working "+ entry.getKey() + ": " + entry.getValue());
    				modelData += System.getProperty( "line.separator" );
    			}
    			if(profile[0].clusters.get(i).entertainment.size() > 0)
    			{
    				modelData += "Entertainment: ";
    				for (Map.Entry<Integer, Integer> entry : profile[0].clusters.get(i).entertainment.entrySet())
    					modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
    					//System.out.println("entertainment "+ entry.getKey() + ": " + entry.getValue());
    				modelData += System.getProperty( "line.separator" );
    			}
    			if(profile[0].clusters.get(i).dining.size() > 0)
    			{
    				modelData += "Dining: ";
    				for (Map.Entry<Integer, Integer> entry : profile[0].clusters.get(i).dining.entrySet())
    					modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
    					//System.out.println("dining "+ entry.getKey() + ": " + entry.getValue());
    				modelData += System.getProperty( "line.separator" );
    			}
    			if(profile[0].clusters.get(i).sporting.size() > 0)
    			{
    				modelData += "Sporting: ";
    				for (Map.Entry<Integer, Integer> entry : profile[0].clusters.get(i).sporting.entrySet())
    					modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
    					//System.out.println("sporting "+ entry.getKey() + ": " + entry.getValue());
    				modelData += System.getProperty( "line.separator" );
    			}
    			if(profile[0].clusters.get(i).transportation.size() > 0)
    			{
    				modelData += "Transportation: ";
    				for (Map.Entry<Integer, Integer> entry : profile[0].clusters.get(i).transportation.entrySet())
    					modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
    					//System.out.println("transportation "+ entry.getKey() + ": " + entry.getValue());
    				modelData += System.getProperty( "line.separator" );
    			}
    			if(profile[0].clusters.get(i).shopping.size() > 0)
    			{
    				modelData += "Shopping: ";
    				for (Map.Entry<Integer, Integer> entry : profile[0].clusters.get(i).shopping.entrySet())
    					modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
    					//System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
    				modelData += System.getProperty( "line.separator" );
    			}
    		}
    		/* testing for optics */
		}
		stopTime = System.currentTimeMillis();
		elapsedTime += stopTime - startTime;
		System.out.println("[Execution time]: "+ elapsedTime);
		/* hardware training for each user */
		
		
		
		
		
		
		/* software training for each user */
		Map<String,Double>  spTFIDF = new HashMap<String,Double>(); // TDIDF for sporting
	    Map<String,Double> tTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> shTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> dTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> wTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> eTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    double spTFDenominator = 0;
	    double tTFDenominator = 0;
	    double shTFDenominator = 0;
	    double dTFDenominator = 0;
	    double wTFDenominator = 0;
	    double eTFDenominator = 0;
	    
	    
		Map apps = new Hashtable(); // for app usage
	    Map inTheSameFile = new Hashtable(); //一個file內出現同一個app多次只計算一次
		 File file = new File(parameter.softwareTrainingFromRaw[0]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
	     ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
	     if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	     {
	        	System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡面
	            }
	     }
	        
	        
	     //每一個檔案去parse
	    int next = 0;
	    Parser parser = new Parser();
	    for(int i = 0; i < fileList.size(); i++)
	    {
	    	String fileName = parameter.softwareTrainingFromRaw[0] + "\\" + fileList.get(i);
	    	//String fileName = "D:\\STAIM\\input\\353567051351832\\h2013-11-14 15-00-45_353567051351832.txt";
        	System.out.println(i + ": "+fileName);
        	
        	parser.InitializeSoftware(new FileReader(fileName), apps, inTheSameFile, i, distribution, elapsedTime);
    		Iterator it = inTheSameFile.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                inTheSameFile.put(pairs.getKey(), 0);
                //System.out.println(pairs.getKey() + " = " + pairs.getValue());
                //it.remove(); // avoids a ConcurrentModificationException
            }
            
        	/* for learning curve */
//        	if(i == parameter.learningCurveTraining[next])
//        	{
//        		next++;
//        		System.out.print(i+" ");
//	        	parser.InitializeSoftware(new FileReader(fileName), apps, inTheSameFile, i, distribution, elapsedTime);
//	    		Iterator it = inTheSameFile.entrySet().iterator();
//	            while (it.hasNext()) {
//	                Map.Entry pairs = (Map.Entry)it.next();
//	                inTheSameFile.put(pairs.getKey(), 0);
//	                //System.out.println(pairs.getKey() + " = " + pairs.getValue());
//	                //it.remove(); // avoids a ConcurrentModificationException
//	            }
//        	}
	    }
		
		
	    int totalActivities = 0;
	    System.out.println("[Execution time]: "+ elapsedTime);
    	System.out.println("\n\n\n\n\nSporting: "+distribution.activityDistribution[5]);
    	System.out.println("Transportation: "+distribution.activityDistribution[0]);
    	System.out.println("Dining: "+distribution.activityDistribution[3]);
    	System.out.println("Working: "+distribution.activityDistribution[1]);
    	System.out.println("Shopping: "+distribution.activityDistribution[4]);
    	System.out.println("Entertainment: "+distribution.activityDistribution[2]);
    	
    	
    	startTime =  System.currentTimeMillis();
    	for(int i = 0; i < 6; i++) {
    		if(distribution.activityDistribution[i] == 0)
    			distribution.activeActivities--;
    		
    		totalActivities += distribution.activityDistribution[i];
    	}
    	System.out.println(totalActivities);
		
    	/* 計算TF的分母 */
    	for(int i = 0; i < distribution.counter; i++) {
    		spTFDenominator += Integer.parseInt(distribution.appDistribution[i][1][5]);
    		
    	    shTFDenominator += Integer.parseInt(distribution.appDistribution[i][1][4]);
    	    dTFDenominator += Integer.parseInt(distribution.appDistribution[i][1][3]);
    	    wTFDenominator += Integer.parseInt(distribution.appDistribution[i][1][1]);
    	    eTFDenominator += Integer.parseInt(distribution.appDistribution[i][1][2]);
    	    tTFDenominator += Integer.parseInt(distribution.appDistribution[i][1][0]);
    	} 	
    	//System.out.println(spTFDenominator+" "+tTFDenominator+" "+shTFDenominator+" "+dTFDenominator+" "+wTFDenominator+" "+eTFDenominator+" ");
    	
    	int dtotal = 0;

    	for(int i = 0; i < distribution.counter; i++) {
    		//System.out.print(distribution.appDistribution[i][0][0]+"("+(int)apps.get(distribution.appDistribution[i][0][0])+"): ");  		


    		// calculate Denominator of IDF
    		double idfDenominator = 0;
    		double entropy = 0;
    		double de = (int)apps.get(distribution.appDistribution[i][0][0]);
    		for(int j = 0; j < 6; j++) {
    			double probability = 0;
    			if(j == 0 && Integer.parseInt(distribution.appDistribution[i][1][0]) > 0)
    			{
    				idfDenominator++;
    				probability = Double.parseDouble(distribution.appDistribution[i][1][0])/de;
    				entropy = entropy + probability*Math.log10(probability);
    				//System.out.println(distribution.appDistribution[i][1][0]+" "+de+"!!!!");
    				
    			}	
    			else if(j == 1 && Integer.parseInt(distribution.appDistribution[i][1][1]) > 0)
    			{
    				idfDenominator++;
    				probability = Double.parseDouble(distribution.appDistribution[i][1][1])/de;
    				entropy = entropy + probability*Math.log10(probability);
    			}
    			else if(j == 2 && Integer.parseInt(distribution.appDistribution[i][1][2]) > 0)
    			{
    				idfDenominator++;
    				probability = Double.parseDouble(distribution.appDistribution[i][1][2])/de;
    				entropy = entropy + probability*Math.log10(probability);
    			}
    			else if(j == 3 && Integer.parseInt(distribution.appDistribution[i][1][3]) > 0)
    			{
    				idfDenominator++;
    				probability = Double.parseDouble(distribution.appDistribution[i][1][3])/de;
    				entropy = entropy + probability*Math.log10(probability);
    			}
    				
    			else if(j == 4 && Integer.parseInt(distribution.appDistribution[i][1][4]) > 0)
    			{
    				idfDenominator++;
    				probability = Double.parseDouble(distribution.appDistribution[i][1][4])/de;
    				entropy = entropy + probability*Math.log10(probability);
    			}
    			else if(j == 5 && Integer.parseInt(distribution.appDistribution[i][1][5]) > 0)
    			{
    				idfDenominator++;
    				probability = Double.parseDouble(distribution.appDistribution[i][1][5])/de;
    				entropy = entropy + probability*Math.log10(probability);
    			}	
    		}
    		entropy = 1+ entropy;
    		
    		for(int j = 0; j < 6; j++) {
    			if(j == 0)
    			{
    				if(tTFDenominator > 0 && idfDenominator > 0)
    				{

    					tTFIDF.put(distribution.appDistribution[i][0][0], (Double.parseDouble(distribution.appDistribution[i][1][0])/tTFDenominator) * (Math.log(distribution.activeActivities/idfDenominator) / Math.log(distribution.activeActivities)));
    					
    				}
    				else
    					tTFIDF.put(distribution.appDistribution[i][0][0], 0.0);
    				
    				//System.out.print("[Transportation: "+appDistribution.appDistribution[i][1][0]+"]\t");

    				//System.out.print("[Transportation: "+tTFIDF.get(distribution.appDistribution[i][0][0])+"]");

    					
    			}
    			else if(j == 1)
    			{
    				if(wTFDenominator > 0 && idfDenominator > 0)
    				{
    					
    						wTFIDF.put(distribution.appDistribution[i][0][0], (Double.parseDouble(distribution.appDistribution[i][1][1])/wTFDenominator) * (Math.log(distribution.activeActivities/idfDenominator) / Math.log(distribution.activeActivities)));
    				
    					
    				}
    					
    				else
    					wTFIDF.put(distribution.appDistribution[i][0][0], 0.0);
    				//System.out.print("[Working: "+appDistribution.appDistribution[i][1][1]+"]\t");
    					//System.out.print("[Working: "+wTFIDF.get(distribution.appDistribution[i][0][0])+"]");
    
    					
    			}
    			else if(j == 2)
    			{
    				if(eTFDenominator > 0 && idfDenominator > 0)
    				{
    					
    				
    					eTFIDF.put(distribution.appDistribution[i][0][0], (Double.parseDouble(distribution.appDistribution[i][1][2])/eTFDenominator) * (Math.log(distribution.activeActivities/idfDenominator) / Math.log(distribution.activeActivities)));
    				
    					
    				}
    					
    				else
    					eTFIDF.put(distribution.appDistribution[i][0][0], 0.0);
    				//System.out.print("[Entertainment: "+appDistribution.appDistribution[i][1][2]+"]\t");
    					//System.out.print("[Entertainment: "+eTFIDF.get(distribution.appDistribution[i][0][0])+"]");

    					
    			}
    			else if(j == 3)
    			{
    				if(dTFDenominator > 0 && idfDenominator > 0)
    					dTFIDF.put(distribution.appDistribution[i][0][0], (Double.parseDouble(distribution.appDistribution[i][1][3])/dTFDenominator) * (Math.log(distribution.activeActivities/idfDenominator) / Math.log(distribution.activeActivities)));
    				else
    					dTFIDF.put(distribution.appDistribution[i][0][0], 0.0);
    				//System.out.print("[Dining: "+appDistribution.appDistribution[i][1][3]+"]\t");

    					//System.out.print("[Dining: "+dTFIDF.get(distribution.appDistribution[i][0][0])+"]");
    			}
    			else if(j == 4)
    			{
    				if(shTFDenominator > 0 && idfDenominator > 0)
   						shTFIDF.put(distribution.appDistribution[i][0][0], (Double.parseDouble(distribution.appDistribution[i][1][4])/shTFDenominator) * (Math.log(distribution.activeActivities/idfDenominator) / Math.log(distribution.activeActivities)));
    				else
    					shTFIDF.put(distribution.appDistribution[i][0][0], 0.0);
    				//System.out.print("[Shopping: "+appDistribution.appDistribution[i][1][4]+"]\t");

    					//System.out.print("[Shopping: "+shTFIDF.get(distribution.appDistribution[i][0][0])+"]");		
    			}
    				
    			else if(j == 5)
    			{
    				if(spTFDenominator > 0 && idfDenominator > 0)
    				{
    					
    						spTFIDF.put(distribution.appDistribution[i][0][0], (Double.parseDouble(distribution.appDistribution[i][1][5])/spTFDenominator) * (Math.log(distribution.activeActivities/idfDenominator) / Math.log(distribution.activeActivities)));
    			

    				}
    					
    				else
    					spTFIDF.put(distribution.appDistribution[i][0][0], 0.0);
    				//System.out.println("[Sporting: "+appDistribution.appDistribution[i][1][5]+"]\t");

    					//System.out.println("[Sporting: "+spTFIDF.get(distribution.appDistribution[i][0][0])+"]");
    			}
    		}
    	}
    	
    	System.out.println(dtotal);
    	ValueComparator bvc;
    	TreeMap<String,Double> sorted_map = null;
    	int order = 0; //輸出app

    	if(distribution.activityDistribution[3] > 0)
    	{
        	bvc =  new ValueComparator(dTFIDF);
            sorted_map = new TreeMap<String,Double>(bvc);
            sorted_map.putAll(dTFIDF);

            //System.out.println("results: "+sorted_map);
            //System.out.print("public String[] diningApp = {");
            
            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
            	
            	// top K(K=11)
            	if(order == profile[0].topk)
            		break;
                double value = entry.getValue();
                String key = entry.getKey();
                //System.out.println(order+": "+key+" ("+value+")");
                if(value == 0)
                	//System.out.print("null,");
                	profile[0].diningApp[order] = "null";
                else
                	//System.out.print(""+key+",");
                	profile[0].diningApp[order] = key;
                order++;
           }
            //System.out.println("};");
    	}
    	else
    	{
    		//System.out.print("public String[] diningApp = {");
    		for(int i = 0; i < profile[0].topk; i++)
    			//System.out.print("null,");
    			profile[0].diningApp[i] = "null";
    		//System.out.println("};");
    	}

    	
    	if(distribution.activityDistribution[0] > 0)
    	{
            bvc =  new ValueComparator(tTFIDF);
            sorted_map = new TreeMap<String,Double>(bvc);
            sorted_map.putAll(tTFIDF);

            //System.out.println("results: "+sorted_map);
            order = 0;
         
            //System.out.print("public String[] transportationApp = {");
            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
            	
            	// top K(K=11)
            	if(order == profile[0].topk)
            		break;
                double value = entry.getValue();
                String key = entry.getKey();
                //System.out.println(order+": "+key+" ("+value+")");
                if(value == 0)
                	//System.out.print("null,");
                	profile[0].transportationApp[order] = "null";
                else
                	//System.out.print(""+key+",");
                	profile[0].transportationApp[order] = key;
                order++;
           }
           //System.out.println("};");
    	}
    	else
    	{
    		//System.out.print("public String[] transportationApp = {");
    		for(int i = 0; i < profile[0].topk; i++)
    			//System.out.print("null,");
    			profile[0].transportationApp[i] = "null";
    		//System.out.println("};");
    	}
    	
    	
    	if(distribution.activityDistribution[5] > 0)
        {
            bvc =  new ValueComparator(spTFIDF);
            sorted_map = new TreeMap<String,Double>(bvc);
            sorted_map.putAll(spTFIDF);

            //System.out.println("results: "+sorted_map);
            order = 0;
      
           // System.out.print("public String[] sportingApp = {");
            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
            	
            	// top K(K=11)
            	if(order == profile[0].topk)
            		break;
                double value = entry.getValue();
                String key = entry.getKey();
                //System.out.println(order+": "+key+" ("+value+")");
                if(value == 0)
                	//System.out.print("null,");
                	profile[0].sportingApp[order] = "null";
                else
                	//System.out.print(""+key+",");
                	profile[0].sportingApp[order] = key;
                order++;
           }
            //System.out.println("};");
        }
    	else
    	{
    		//System.out.print("public String[] transportationApp = {");
    		for(int i = 0; i < profile[0].topk; i++)
    			//System.out.print("null,");
    			profile[0].sportingApp[i] = "null";
    		//System.out.println("};");
    	}
        
        if(distribution.activityDistribution[1] > 0)
        {
            bvc =  new ValueComparator(wTFIDF);
            sorted_map = new TreeMap<String,Double>(bvc);
            sorted_map.putAll(wTFIDF);

            //System.out.println("results: "+sorted_map);
            order = 0;
          
            //System.out.print("public String[] workingApp = {");
            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
            	
            	// top K(K=11)
            	if(order == profile[0].topk)
            		break;
                double value = entry.getValue();
                String key = entry.getKey();
                //System.out.println(order+": "+key+" ("+value+")");
                if(value == 0)
                	//System.out.print("null,");
                	profile[0].workingApp[order] = "null";
                else
                	//System.out.print(""+key+",");
                	profile[0].workingApp[order] = key;
                order++;
           }
            //System.out.println("};");
        }
        else
    	{
        	//System.out.print("public String[] transportationApp = {");
    		for(int i = 0; i < profile[0].topk; i++)
    			//System.out.print("null,");
    			profile[0].workingApp[i] = "null";
    		//System.out.println("};");
    	}
        
        if(distribution.activityDistribution[2] > 0)
        {
            bvc =  new ValueComparator(eTFIDF);
            sorted_map = new TreeMap<String,Double>(bvc);
            sorted_map.putAll(eTFIDF);

            //System.out.println("results: "+sorted_map);
            order = 0;
        
            //System.out.print("public String[] entertainmentApp = {");
            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
            	
            	// top K(K=11)
            	if(order == profile[0].topk)
            		break;
                double value = entry.getValue();
                String key = entry.getKey();
                //System.out.println(order+": "+key+" ("+value+")");
                if(value == 0)
                	//System.out.print("null,");
                	profile[0].entertainmentApp[order] = "null";
                else
                	//System.out.print(""+key+",");
                	profile[0].entertainmentApp[order] = key;
                order++;
           }
            //System.out.println("};");
        }
        else
    	{
        	//System.out.print("public String[] transportationApp = {");
    		for(int i = 0; i < profile[0].topk; i++)
    			//System.out.print("null,");
    			profile[0].entertainmentApp[i] = "null";
    		//System.out.println("};");
    	}
         
        if(distribution.activityDistribution[4] > 0)
        {
            bvc =  new ValueComparator(shTFIDF);
            sorted_map = new TreeMap<String,Double>(bvc);
            sorted_map.putAll(shTFIDF);

            //System.out.println("results: "+sorted_map);
            order = 0;
          //
            //System.out.print("public String[] shoppingApp = {");
            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
            	
            	// top K(K=11)
            	if(order == profile[0].topk)
            		break;
                double value = entry.getValue();
                String key = entry.getKey();
                //System.out.println(order+": "+key+" ("+value+")");
                if(value == 0)
                	//System.out.print("null,");
                	profile[0].shoppingApp[order] = "null";
                else
                	//System.out.print(""+key+",");
                	profile[0].shoppingApp[order] = key;
                order++;
           }
            //System.out.println("};");
        } 
        else
    	{
        	//System.out.print("public String[] transportationApp = {");
    		for(int i = 0; i < profile[0].topk; i++)
    			//System.out.print("null,");
    			profile[0].shoppingApp[i] = "null";
    		//System.out.println("};");
    	}
        sorted_map.clear();
    	
        spTFIDF.clear();
	    tTFIDF.clear();
	    shTFIDF.clear(); 
	    dTFIDF.clear(); 
	   wTFIDF.clear(); 
	   eTFIDF.clear(); 
	   distribution.appDistribution = null;
	    apps.clear(); 
	    inTheSameFile.clear();
    	
	    	
		/* already trained, directly extract from file */
//		for(int index = 0; index < parameter.softwareTraining.length; index++) {
//			int lineCounter = 0;
//			FileReader fr = new FileReader(parameter.softwareTraining[index]);
//			BufferedReader br = new BufferedReader(fr);		
//			while (br.ready()) {
//				String str = br.readLine();
//				int start = str.indexOf("{", 0);
//				int end = str.indexOf("}", 0);
//				if(start == -1 || end == -1)
//					continue;
//				str = str.substring(start+1, end-1);
//				String[] afterSplit = str.split(",");
//				for (int i = 0; i < afterSplit.length; i++) {
//				    if(lineCounter == 0)
//				    	profile[index].diningApp[i] = afterSplit[i];
//				    else if (lineCounter == 1)
//				    	profile[index].transportationApp[i] = afterSplit[i];
//				    else if (lineCounter == 2)
//				    	profile[index].sportingApp[i] = afterSplit[i];	
//				    else if (lineCounter == 3)
//				    	profile[index].workingApp[i] = afterSplit[i];		
//				    else if (lineCounter == 4)
//				    	profile[index].entertainmentApp[i] = afterSplit[i];			
//				    else if (lineCounter == 5)
//				    	profile[index].shoppingApp[i] = afterSplit[i];
//				}
//				//System.out.println();
//				lineCounter++;
//				if(lineCounter == 6)
//					break;
//			}
//			fr.close();
//		}
		/* software training for each user */
		/* already trained, directly extract from file */
		
		
		// AIM model
		modelData += "[Application List]"+ System.getProperty( "line.separator" );
		if(profile[0].workingApp[0].equals("null"))
			;
		else
		{
			modelData += "Working App :";
			//modelData += System.getProperty( "line.separator" );
			for(int i = 0; i < profile[0].topk;i++)
				modelData+= profile[0].workingApp[i]+",";
			modelData += System.getProperty( "line.separator" );
		}
		
		if(profile[0].diningApp[0].equals("null"))
			;
		else
		{
			modelData += "Dining App :";
			//modelData += System.getProperty( "line.separator" );
			for(int i = 0; i < profile[0].topk;i++)
				modelData+= profile[0].diningApp[i]+",";
			modelData += System.getProperty( "line.separator" );
		}
		
		if(profile[0].transportationApp[0].equals("null"))
			;
		else
		{
			modelData += "Transportation App :";
			//modelData += System.getProperty( "line.separator" );
			for(int i = 0; i < profile[0].topk;i++)
				modelData+= profile[0].transportationApp[i]+",";
			modelData += System.getProperty( "line.separator" );
		}
		
		if(profile[0].entertainmentApp[0].equals("null"))
			;
		else
		{
			modelData += "EntertainmentApp App :";
			//modelData += System.getProperty( "line.separator" );
			for(int i = 0; i < profile[0].topk;i++)
				modelData+= profile[0].entertainmentApp[i]+",";
			modelData += System.getProperty( "line.separator" );
		}
		
		if(profile[0].sportingApp[0].equals("null"))
			;
		else
		{
			modelData += "Sporting App :";
			//modelData += System.getProperty( "line.separator" );
			for(int i = 0; i < profile[0].topk;i++)
				modelData+= profile[0].sportingApp[i]+",";
			modelData += System.getProperty( "line.separator" );
		}
		
		if(profile[0].shoppingApp[0].equals("null"))
			;
		else
		{
			modelData += "Shopping App :";
			//modelData += System.getProperty( "line.separator" );
			for(int i = 0; i < profile[0].topk;i++)
				modelData+= profile[0].shoppingApp[i]+",";
			modelData += System.getProperty( "line.separator" );
		}
//		for(int i = 0; i<10;i++)
//			System.out.print(profile[0].entertainmentApp[i]+" ");
		/* software training for each user */
	

		/* Data for AIM model */
		modelData += "[GATDM]"+System.getProperty( "line.separator" );
		if(profile[0].wTimeDistribution.size() > 0)
		{
			modelData += "Working: ";
			for (Map.Entry<Integer, Integer> entry : profile[0].wTimeDistribution.entrySet())
				modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
				//System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
			modelData += System.getProperty( "line.separator" );
		}
		if(profile[0].dTimeDistribution.size() > 0)
		{
			modelData += "Dining: ";
			for (Map.Entry<Integer, Integer> entry : profile[0].dTimeDistribution.entrySet())
				modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
				//System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
			modelData += System.getProperty( "line.separator" );
		}
		if(profile[0].tTimeDistribution.size() > 0)
		{
			modelData += "Transportation: ";
			for (Map.Entry<Integer, Integer> entry : profile[0].tTimeDistribution.entrySet())
				modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
				//System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
			modelData += System.getProperty( "line.separator" );
		}
		if(profile[0].eTimeDistribution.size() > 0)
		{
			modelData += "Entertainment: ";
			for (Map.Entry<Integer, Integer> entry : profile[0].eTimeDistribution.entrySet())
				modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
				//System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
			modelData += System.getProperty( "line.separator" );
		}
		if(profile[0].spTimeDistribution.size() > 0)
		{
			modelData += "Sporting: ";
			for (Map.Entry<Integer, Integer> entry : profile[0].spTimeDistribution.entrySet())
				modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
				//System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
			modelData += System.getProperty( "line.separator" );
		}
		if(profile[0].shTimeDistribution.size() > 0)
		{
			modelData += "Shopping: ";
			for (Map.Entry<Integer, Integer> entry : profile[0].shTimeDistribution.entrySet())
				modelData += "("+entry.getKey()+","+ entry.getValue()+") ";
				//System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
			modelData += System.getProperty( "line.separator" );
		}
		modelData += "[END]";
		/* Data for AIM model */
		
		/* Data for AIM model */
		Writer modelWriter = new FileWriter(parameter.model_path[0]);			
		modelWriter.write(modelData);
		modelWriter.close();
		modelData = null;
		/* Data for AIM model */
		
		stopTime =  System.currentTimeMillis();
    	elapsedTime += stopTime - startTime;
		Runtime runtime = Runtime.getRuntime();
 	    // Run the garbage collector
 	    runtime.gc();
 	    
 	    profile[0] = null;
 	    // Calculate the used memory
 	   long memory = runtime.totalMemory() - runtime.freeMemory();
 	    System.out.println("[Training phase] Used Time is (ms): "+(float)elapsedTime);
		System.out.println("[Training phase] Used memory is Mbytes: " + (double)memory/1048576);
		trainingTime = (float)((float)elapsedTime/1000.0);
		trainingMemory = (double)memory/1048576;
		elapsedTime = 0;
		

    	
    	
    	
    	
    	
    	
    	
    	
		/* giving software score for each file */
		
//		for(int index = 0; index < parameter.softwareTesting.length; index++) {
//			file = new File(parameter.softwareTesting[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
//			fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
//			
//			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
//	        {
//	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
//	            String []s = file.list(); //宣告一個list
//	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
//	            for(int i = 0; i < s.length; i++) {
//	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
//	            }
//	        }
//			
//			for(int i = 0; i < fileList.size(); i++) {
//				parser = new Parser();
//	        	String fileName = parameter.softwareTesting[index] + "\\" + fileList.get(i);
//	        	System.out.println(i + ": "+fileName);
//	        	SoftwarePhase softwarePhase = new SoftwarePhase();
//	        	softwarePhase.testing(fileName, profile[index], distribution, i, elapsedTime);
//			}
//		}	
//		/* giving software score & testing */
//
//		
//		/* giving location & weighted table score for each file */
//		double counter = 0, correct = 0;
//		for(int index = 0; index < parameter.hardwareTesting.length; index++) {
//			file = new File(parameter.hardwareTesting[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
//			fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
//			
//			if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
//	        {
//	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
//	            String []s = file.list(); //宣告一個list
//	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
//	            for(int i = 0; i < s.length; i++) {
//	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
//	            }
//	        }
//			
//			// 每一個不同的activity(file)
//			for(int i = 0; i < fileList.size(); i++) {
//				parser = new Parser();
//	        	String fileName = parameter.hardwareTesting[index] + "\\" + fileList.get(i);
//	        	System.out.println(i + ": "+fileName);
//	        	
//	        	// 判斷  logger version
//	        	String category = "V[1-2]+";
//	    		Pattern pattern = Pattern.compile(category);
//	    	    Matcher matcher = pattern.matcher(fileName);
//	    	    String version = null;
//	    	    boolean matchFound = matcher.find();
//	    	    if(matchFound)
//	    	    	version = matcher.group();
//	    	    if(parameter.loggerVersion.equals("V2"))
//	    	    	version = "V2";		
//	    	    
//	    	    int value = parser.testing(fileName, profile[index], version, i, elapsedTime);
//
//	    	    if(value == 1)
//	    	    	correct++;
//	    	    counter++;
//			}
//			
//		}
//
////		// 只有hardware部分
//		System.out.println("Accuracy: " + correct/counter + " " + correct +" "+counter );
//		/* giving location & weighted table score for each file */
//		
//		
//		/* 把score輸出到file就不用每次重train得分  */
//		Writer writer = new FileWriter("D:\\STAIM\\input\\preference\\"+parameter.imei[0]+"\\score.txt");
//		int hit = 0;
//		for(int i = 0; i < profile[0].numberOfFile; i++) {
//			
//			double scoreForSoftware[] =  new double[6];
//			double scoreForLocation[] =  new double[6];
//			double scoreForDistributionMatrix[] =  new double[6];
//			double scoreForTotal[] = new double[6];
//			double totalSoftware = 0;
//			double totalLocation = 0;
//			double totalDistributionMatrix = 0;
//			int total = 0, inference = -1;
//			
//			System.out.println(profile[0].lable[i]);
//			writer.write(profile[0].lable[i]+"\n");
//			for(int j = 0; j < 6; j++)
//				System.out.print(profile[0].softwareScore[i][j]+" ");
//			System.out.println();
//			for(int j = 0; j < 6; j++)
//				System.out.print(profile[0].locationScore[i][j]+" ");
//			System.out.println();
//			for(int j = 0; j < 6; j++)
//				System.out.print(profile[0].distributionMatrixScore[i][j] +" ");
//			System.out.print("\n"+profile[0].speed[i] +" ");
//			writer.write(profile[0].speed[i]+"\n");
//			System.out.println("\n"+profile[0].std[i] +" ");
//			writer.write(profile[0].std[i]+"\n");
////			if(profile[0].speed[i] >= 40)
////				inference = 2;
////			else if(profile[0].std[i] >= 2.4)
////				inference = 4;
////			else
////			{
//				for(int j = 0; j < 6; j++) {
//					totalSoftware += profile[0].softwareScore[i][j];
//					totalLocation += profile[0].locationScore[i][j];
//					totalDistributionMatrix += profile[0].distributionMatrixScore[i][j];
//				}
//				
//				for(int j = 0; j < 6; j++) {
//					if(totalSoftware != 0)
//						scoreForSoftware[j] =  (double)profile[0].softwareScore[i][j] / totalSoftware;
//					else
//						scoreForSoftware[j] = 0;
//					
//					if(totalLocation != 0)
//						scoreForLocation[j] =  (double)profile[0].locationScore[i][j] / totalLocation;
//					else
//						scoreForLocation[j] = 0;
//					
//					if(totalDistributionMatrix != 0)
//						scoreForDistributionMatrix[j] =  (double)profile[0].distributionMatrixScore[i][j] / totalDistributionMatrix;
//					else
//						scoreForDistributionMatrix[j] = 0;
//
//				}
//				for(int j = 0; j < 6; j++)
//					writer.write(scoreForSoftware[j]+" ");
//				writer.write("\n");
//				for(int j = 0; j < 6; j++)
//					writer.write(scoreForLocation[j]+" ");
//				writer.write("\n");
//				for(int j = 0; j < 6; j++)
//					writer.write(scoreForDistributionMatrix[j] +" ");
//				writer.write("\n");
//				/* determined by sum of three factor*/
//				// sum score
//				for(int j = 0; j < 6; j++) {
//					scoreForTotal[j] = scoreForLocation[j];
//					//scoreForTotal[j] = scoreForDistributionMatrix[j];
//					//scoreForTotal[j] += scoreForSoftware[j];
//					//scoreForTotal[j] += scoreForSoftware[j] + scoreForLocation[j] + scoreForDistributionMatrix[j];  
//				}
//				for(int j = 0; j < 6; j++)
//					System.out.print(scoreForTotal[j] +" ");
//				System.out.println();
//				// max score
////				for(int j = 0; j < 6; j++) {
////					double max = 0;
////					max = Math.max(scoreForSoftware[j], scoreForLocation[j]);
////					max = Math.max(max, scoreForDistributionMatrix[j]);
////					scoreForTotal[j] = max;
////					System.out.print(scoreForTotal[j]+ " ");
////				}
//			System.out.println();
//			
//		    startTime = System.currentTimeMillis();
//			double maxValue = 0;
//			for(int j = 0; j < 6; j++) {
//				if(scoreForTotal[j] > maxValue)
//				{
//						inference = j;
//						maxValue = scoreForTotal[j];
//				}
//			}
//				
//			System.out.println(inference);
//			System.out.println("\n===============================");
//			writer.write("===============================\n");
//			try
//			{
//				
//				if(profile[0].lable[i].equals("Working") && inference == 0)
//				{
//					hit++;
//					profile[0].workingHit++;
//				}	
//				else if(profile[0].lable[i].equals("Dining") && inference == 1)
//				{
//					hit++;
//					profile[0].diningHit++;
//				}
//				else if(profile[0].lable[i].equals("Transportation") && inference == 2)
//				{
//					hit++;
//					profile[0].transportationHit++;
//				}
//				else if(profile[0].lable[i].equals("Entertainment") && inference == 3)
//				{
//					hit++;
//					profile[0].entertainmentHit++;
//				}
//				else if(profile[0].lable[i].equals("Sporting") && inference == 4)
//				{
//					hit++;
//					profile[0].sportingHit++;
//				}
//				else if(profile[0].lable[i].equals("Shopping") && inference == 5)
//				{
//					hit++;
//					profile[0].shoppingHit++;
//				}	
//			} catch(Exception e)
//			{
//				System.out.println(profile[0].lable[i]);
//			}
//			stopTime = System.currentTimeMillis();
//		    elapsedTime += stopTime - startTime;
//			
//			
//		}
//		writer.close();
//		
//		/* 把score輸出到file就不用每次重train得分  */
//		
//		
//		System.out.println("End!\n" + hit+" "+profile[0].numberOfFile+" "+(double)hit/profile[0].numberOfFile);
//		System.out.println("Dining : "+profile[0].diningHit+" "+profile[0].diningTotal);
//		System.out.println("Sporting : "+profile[0].sportingHit+" "+profile[0].sportingTotal);
//		System.out.println("Working : "+profile[0].workingHit+" "+profile[0].workingTotal);
//		System.out.println("Transportation : "+profile[0].transportationHit+" "+profile[0].transportationTotal);
//		System.out.println("Shopping : "+profile[0].shoppingHit+" "+profile[0].shoppingTotal);
//		System.out.println("Entertainment : "+profile[0].entertainmentHit+" "+profile[0].entertainmentTotal);
//		System.out.println("GPS : "+profile[0].gpsHit+" "+profile[0].gpsTotal);
//		 System.out.println("T GPS Miss Hit:"+profile[0].transportationGPSNoHit);
//		 System.out.println("D GPS Miss Hit:"+profile[0].diningGPSNoHit);
//		 System.out.println("W GPS Miss Hit:"+profile[0].workingGPSNoHit);
//		 System.out.println("Sh GPS Miss Hit:"+profile[0].shoppingGPSNoHit);
//		 System.out.println("Sp GPS Miss Hit:"+profile[0].sportingGPSNoHit);
//		 System.out.println("E GPS Miss Hit:"+profile[0].entertainmentGPSNoHit);
//
//		
//		runtime = Runtime.getRuntime();
// 	    // Run the garbage collector
// 	    runtime.gc();
// 	    // Calculate the used memory
// 	    memory = runtime.totalMemory() - runtime.freeMemory();
// 	    System.out.println("[Initial phase] Used memory is Mbytes:"+ initialMemory );
// 	   System.out.println("[Training phase] Used Time is (ms): "+trainingTime);
//		 System.out.println("[Training phase] Used memory is Mbytes: " + trainingMemory);
// 	   System.out.println("[Testing phase] Used Time is (ms): "+elapsedTime);
//		 System.out.println("[Testing phase] Used memory is Mbytes: " + (double)memory/1048576);
	}
}

/* hashmap sorting */
class ValueComparator implements Comparator<String> {

    Map<String, Double> base;
    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }
    
    

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}