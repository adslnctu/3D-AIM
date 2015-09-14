package OnlineTraining;

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
		
		/* hardware training for each user */
		
			/* initial block for each user*/
			profile[0] = new Profile();
			/* initial block for each user*/
			
			/* weighted table + time distribution + frequent region */
			File file = new File("/home/likekaito/public_html/htc_logdata_withLabel/"+args[0]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
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
			profile[0].numberOfFile = fileList.size();
			
			for(int i = 0; i < fileList.size(); i++) {
				Parser parser = new Parser();
	        	String fileName = "/home/likekaito/public_html/htc_logdata_withLabel/" +args[0]+"/"+ fileList.get(i);
	        	//System.out.println(i + ": "+fileName);
	        	
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

	    	    
	    	    profile[0].trajectory.clear(); // 每個activity(file)的trajectory加入到dpoint內
	    	    parser.buildProfile(fileName, profile[0], version, 0, elapsedTime);

			}
			
			
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
			
			
			/* stay point detection */
			int gps_i = 0, gps_j = 0, gpsNum = profile[0].dpoints.size(), token = 0;
			while(gps_i < gpsNum) {
				
				gps_j = gps_i + 1;
				token = 0;
				while(gps_j < gpsNum) {
					double dist = distance(profile[0].dpoints.get(gps_i).getLongitude(),profile[0].dpoints.get(gps_i).getLatitude(),profile[0].dpoints.get(gps_j).getLongitude(),profile[0].dpoints.get(gps_j).getLatitude());
					if(profile[0].dpoints.get(gps_i).getActivity().equals(profile[0].dpoints.get(gps_j).getActivity()))
					{
					
					
						if(dist > parameter.distanceThreshold)
						{
							
							String timestamp2 = profile[0].dpoints.get(gps_j).getTimestamp();
							String timestamp1 = profile[0].dpoints.get(gps_i).getTimestamp();
							
							Date date1=new Date(Long.parseLong(timestamp1));
							Date date2=new Date(Long.parseLong(timestamp2));
							
							long diff= date2.getTime() -date1.getTime();
							
							long diffMinutes = diff / (60 * 1000) % 60;
							long diffHours = diff / (60 * 60 * 1000) % 24;
							long diffDays = diff / (24 * 60 * 60 * 1000);
							diffMinutes = diffMinutes + diffHours * 60 + diffDays * 1440;
							if(diffMinutes > parameter.timeThreshold)
							{
				
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
										activity = profile[0].dpoints.get(gps_k).getActivity();
										activtiyList.add(activity);
										timestampList.add(profile[0].dpoints.get(gps_k).getTimestamp());
									}
									else
									{
										if(activity.equals(profile[0].dpoints.get(gps_k).getActivity()))
											;
										else
										{
											activity = profile[0].dpoints.get(gps_k).getActivity();
											activtiyList.add(activity);
											timestampList.add(profile[0].dpoints.get(gps_k).getTimestamp());
											
										}
									}
										
									averageLon += profile[0].dpoints.get(gps_k).getLongitude();
									averageLat += profile[0].dpoints.get(gps_k).getLatitude();
									if(profile[0].dpoints.get(gps_k).getSpeed() > speed)
										speed = profile[0].dpoints.get(gps_k).getSpeed();
								}
								
								int counter = (gps_j-gps_i+1);
								averageLon /= counter;
								averageLat /= counter;
								
								double[] gpsPoint={averageLat, averageLon};
				    			
								//System.out.println(">>>>"+activtiyList.size());
				    			for(int x = 0; x < activtiyList.size(); x++)
								{
				    				Date date = new Date(Long.parseLong(timestampList.get(x)));
				    				//System.out.println( activtiyList.get(x)+" "+date);
				    				profile[0].stayPointSet.add(new DataPoint(gpsPoint, String.valueOf(profile[0].gpsPointName2),  activtiyList.get(x), timestampList.get(x), speed));
					    			profile[0].gpsPointName2++;
									
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
						dist = distance(profile[0].dpoints.get(gps_i).getLongitude(),profile[0].dpoints.get(gps_i).getLatitude(),profile[0].dpoints.get(gps_j-1).getLongitude(),profile[0].dpoints.get(gps_j-1).getLatitude());
						if(dist < parameter.distanceThreshold)
						{
							
							String timestamp2 = profile[0].dpoints.get(gps_j-1).getTimestamp();
							String timestamp1 = profile[0].dpoints.get(gps_i).getTimestamp();
							
							Date date1=new Date(Long.parseLong(timestamp1));
							Date date2=new Date(Long.parseLong(timestamp2));
							
							long diff= date2.getTime() -date1.getTime();
							
							long diffMinutes = diff / (60 * 1000) % 60;
							long diffHours = diff / (60 * 60 * 1000) % 24;
							long diffDays = diff / (24 * 60 * 60 * 1000);
							diffMinutes = diffMinutes + diffHours * 60 + diffDays * 1440;
							if(diffMinutes > parameter.timeThreshold)
							{
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
										activity = profile[0].dpoints.get(gps_k).getActivity();
										activtiyList.add(activity);
										timestampList.add(profile[0].dpoints.get(gps_k).getTimestamp());
									}
									else
									{
										if(activity.equals(profile[0].dpoints.get(gps_k).getActivity()))
											;
										else
										{
											activity = profile[0].dpoints.get(gps_k).getActivity();
											activtiyList.add(activity);
											timestampList.add(profile[0].dpoints.get(gps_k).getTimestamp());
											
										}
									}
										
									averageLon += profile[0].dpoints.get(gps_k).getLongitude();
									averageLat += profile[0].dpoints.get(gps_k).getLatitude();
									if(profile[0].dpoints.get(gps_k).getSpeed() > speed)
										speed = profile[0].dpoints.get(gps_k).getSpeed();
								}
								
								int counter = (gps_j-gps_i);
								averageLon /= counter;
								averageLat /= counter;
								
								double[] gpsPoint={averageLat, averageLon};
				    			
								
				    			for(int x = 0; x < activtiyList.size(); x++)
								{
				    				Date date = new Date(Long.parseLong(timestampList.get(x)));
				    				//System.out.println( activtiyList.get(x)+" "+date);
				    				profile[0].stayPointSet.add(new DataPoint(gpsPoint, String.valueOf(profile[0].gpsPointName2),  activtiyList.get(x), timestampList.get(x), speed));
					    			profile[0].gpsPointName2++;
									
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
			
			profile[0].dpoints.clear();
			//System.out.println(profile[index].stayPointSet.size()+"~~~~~~~~~");
			
			/* OPTICS */
			Optics ca = new Optics();
    		ca.startAnalysis(profile[0].stayPointSet, parameter.mpt, parameter.radius, profile[0].clusters);
    		for(int j = 0; j < profile[0].clusters.size(); j++) {
    			
    			double lat = 0, lon = 0;
    			for(int k = 0; k < profile[0].clusters.get(j).gpsPoint.size(); k++)
    			{
    				
    				String timestamp = profile[0].clusters.get(j).gpsPoint.get(k).getTimestamp(); 
    				timestamp = timestamp.substring(0, timestamp.length()-3);
    				long hour = Long.valueOf(timestamp);
    				Calendar calendar = Calendar.getInstance();
    				calendar.setTimeInMillis(hour * 1000);
    				int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
    				//System.out.println(clusters.get(i).gpsPoint.get(j).getLongitude()+" "+clusters.get(i).gpsPoint.get(j).getLatitude()+" "+clusters.get(i).gpsPoint.get(j).getActivity()+" "+hourOfDay);
    				lat += profile[0].clusters.get(j).gpsPoint.get(k).getLatitude();
    				lon += profile[0].clusters.get(j).gpsPoint.get(k).getLongitude();
    				
    				
    				// 每一群內activity時間的分布
    				if(profile[0].clusters.get(j).gpsPoint.get(k).getActivity().equals("Working"))
    				{
    					if(profile[0].clusters.get(j).working.containsKey(hourOfDay))
    						profile[0].clusters.get(j).working.put(hourOfDay, profile[0].clusters.get(j).working.get(hourOfDay)+1);
    					else
    						profile[0].clusters.get(j).working.put(hourOfDay, 1);
    				}
    				else if(profile[0].clusters.get(j).gpsPoint.get(k).getActivity().equals("Dining"))
    				{
    					if(profile[0].clusters.get(j).dining.containsKey(hourOfDay))
    						profile[0].clusters.get(j).dining.put(hourOfDay, profile[0].clusters.get(j).dining.get(hourOfDay)+1);
    					else
    						profile[0].clusters.get(j).dining.put(hourOfDay, 1);
    				}
    				else if(profile[0].clusters.get(j).gpsPoint.get(k).getActivity().equals("Transportation"))
    				{
    					if(profile[0].clusters.get(j).transportation.containsKey(hourOfDay))
    						profile[0].clusters.get(j).transportation.put(hourOfDay, profile[0].clusters.get(j).transportation.get(hourOfDay)+1);
    					else
    						profile[0].clusters.get(j).transportation.put(hourOfDay, 1);
    				}
    				else if(profile[0].clusters.get(j).gpsPoint.get(k).getActivity().equals("Shopping"))
    				{
    					if(profile[0].clusters.get(j).shopping.containsKey(hourOfDay))
    						profile[0].clusters.get(j).shopping.put(hourOfDay, profile[0].clusters.get(j).shopping.get(hourOfDay)+1);
    					else
    						profile[0].clusters.get(j).shopping.put(hourOfDay, 1);
    				}
    				else if(profile[0].clusters.get(j).gpsPoint.get(k).getActivity().equals("Entertainment"))
    				{
    					if(profile[0].clusters.get(j).entertainment.containsKey(hourOfDay))
    						profile[0].clusters.get(j).entertainment.put(hourOfDay, profile[0].clusters.get(j).entertainment.get(hourOfDay)+1);
    					else
    						profile[0].clusters.get(j).entertainment.put(hourOfDay, 1);
    				}
    				else if(profile[0].clusters.get(j).gpsPoint.get(k).getActivity().equals("Sporting"))
    				{
    					if(profile[0].clusters.get(j).sporting.containsKey(hourOfDay))
    						profile[0].clusters.get(j).sporting.put(hourOfDay, profile[0].clusters.get(j).sporting.get(hourOfDay)+1);
    					else
    						profile[0].clusters.get(j).sporting.put(hourOfDay, 1);
    				}
    			}
    			
    			if(profile[0].clusters.get(j).gpsPoint.size() > 0)
    			{
    				profile[0].clusters.get(j).centralLat = lat / profile[0].clusters.get(j).gpsPoint.size();
    				profile[0].clusters.get(j).centralLon = lon / profile[0].clusters.get(j).gpsPoint.size();
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

		stopTime = System.currentTimeMillis();
		elapsedTime += stopTime - startTime;
		//System.out.println("[Execution time]: "+ elapsedTime);
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
		 File file2 = new File("/home/likekaito/public_html/htc_logdata_withLabel_software/"+args[0]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
	     ArrayList<String> fileList2 = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
	     if(file2.isDirectory()) //如果f讀到的是資料夾，就會執行
	     {
	        	//System.out.println("filename : " + file2.getName()); //印出我們所讀到的資料夾
	            String []s = file2.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList2.add(s[i]); //將檔名一一存到fileList動態陣列裡面
	            }
	     }
	        
	        
	     //每一個檔案去parse
	    int next = 0;
	    Parser parser = new Parser();
	    for(int i = 0; i < fileList2.size(); i++)
	    {
	    	String fileName = "/home/likekaito/public_html/htc_logdata_withLabel_software/"+args[0]+"/" + fileList2.get(i);

        	
        	parser.InitializeSoftware(new FileReader(fileName), apps, inTheSameFile, i, distribution, elapsedTime);
    		Iterator it = inTheSameFile.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                inTheSameFile.put(pairs.getKey(), 0);
                //System.out.println(pairs.getKey() + " = " + pairs.getValue());
                //it.remove(); // avoids a ConcurrentModificationException
            }
            
	    }
		
		
	    int totalActivities = 0;
	   
    	
    	
    	startTime =  System.currentTimeMillis();
    	for(int i = 0; i < 6; i++) {
    		if(distribution.activityDistribution[i] == 0)
    			distribution.activeActivities--;
    		
    		totalActivities += distribution.activityDistribution[i];
    	}
    	//System.out.println(totalActivities);
		
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
    	
    	//System.out.println(dtotal);
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
		Writer modelWriter = new FileWriter("/home/likekaito/public_html/htc_classifier/"+args[0]+".txt");			
		modelWriter.write(modelData);
		modelWriter.close();
		modelData = null;
		/* Data for AIM model */
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