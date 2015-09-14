package parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import TEST.HttpRequest;

public class Parser {
	
	private int counter;
	private double average;
	private double power; // for 標準差
	private double max;
	private double min;
	private double startY;
	private double startX;
	private int startHour;
	private int g_counter = 0;
		
	public Parser()
	{
		counter = 0;
		average = 0;
		power = 0;
		max = 0;
		min = 100;
		
	}
	
	public void InitializeSoftware(Reader reader, Map apps, Map inTheSameFile, int indexFile, Distribution distribution) throws Exception {
        
		Parameter parameter = new Parameter();
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        Iterator iterator = arr.iterator();
        //List<SoftwareRow> result = new ArrayList();
        String label2 = null;
        int app2 = 0;
        int counterUnit = 0;
        while (iterator.hasNext()) {
        	counterUnit++;
            JSONObject parse = (JSONObject) iterator.next();
            JSONArray app = (JSONArray) parse.get("App");
            String label = parse.get("lifelable").toString();
            label2 = label;
            app2 = app.size();
            String timestamp = parse.get("time").toString();
            timestamp = timestamp.substring(0, timestamp.length()-3);
            //SoftwareRow row = new SoftwareRow(new TimeData(timestamp), new LifeLabel(label));
            
           
            for (int i = 0; i < app.size(); i++) {
                JSONObject obj = (JSONObject) app.get(i);
                String name = obj.get("name").toString();
                
                
                
                //這個APP之前已有出現
                if(apps.containsKey(name))
                {
                	//同一個FILE只計算一次
                	int inOrNot = (int)inTheSameFile.get(name);
                	if(inOrNot == 0)
                	{
                		int counter = (int)apps.get(name);
                		counter++;
                    	apps.put(name, counter);
                    	//同一個FILE只計算一次
                    	inTheSameFile.put(name, -1);
                    	for(int x = 0; x < distribution.counter; x++) {
                    		//找到該app
                    		if(distribution.appDistribution[x][0][0].equals(name))
                    		{
                    			int intValue = 0;
                    			if(label.equals("Transportation"))
                    			{
                    				intValue = Integer.parseInt(distribution.appDistribution[x][1][0]);
                    				intValue++;
                    				distribution.appDistribution[x][1][0] =  String.valueOf(intValue);
                    			}
                    			else if(label.equals("Working"))
                    			{
                    				intValue = Integer.parseInt(distribution.appDistribution[x][1][1]);
                    				intValue++;
                    				distribution.appDistribution[x][1][1] =  String.valueOf(intValue);
                    			}
                    			else if(label.equals("Entertainment"))
                    			{
                    				intValue = Integer.parseInt(distribution.appDistribution[x][1][2]);
                    				intValue++;
                    				distribution.appDistribution[x][1][2] =  String.valueOf(intValue);
                    			}	
                    			else if(label.equals("Dining"))
                    			{
                    				intValue = Integer.parseInt(distribution.appDistribution[x][1][3]);
                    				intValue++;
                    				distribution.appDistribution[x][1][3] =  String.valueOf(intValue);
                    			}
                    			else if(label.equals("Shopping"))	
                    			{
                    				intValue = Integer.parseInt(distribution.appDistribution[x][1][4]);
                    				intValue++;
                    				distribution.appDistribution[x][1][4] =  String.valueOf(intValue);
                    			}
                    			else if(label.equals("Sporting"))
                    			{
                    				intValue = Integer.parseInt(distribution.appDistribution[x][1][5]);
                    				intValue++;
                    				distribution.appDistribution[x][1][5] =  String.valueOf(intValue);
                    			}	
                    			
//                    			for(int y = 0; y < 6; y++)
//                    			{
//                    				if(distribution.appDistribution[x][1][y].equals(label))
//                    					break;
//
//                    				if(distribution.appDistribution[x][1][y].equals("0"))
//                    				{
//                    					
//                    					distribution.appDistribution[x][1][y] = label;
//                    					break;
//                    				}
//                    			
//                    			}
                    			break;
                    		}
                    	}
                	}
                }
               //這個APP之前沒有出現過
                else
                {
                	apps.put(name, 1);
                	inTheSameFile.put(name, -1);
                	distribution.appDistribution[distribution.counter][0][0] = name;
                	//distribution.appDistribution[distribution.counter][1][0] = label;
                	if(label.equals("Transportation"))
            		{
            			distribution.appDistribution[distribution.counter][1][0] =  String.valueOf(1);
            		}
            		else if(label.equals("Working"))
            		{
            			distribution.appDistribution[distribution.counter][1][1] =  String.valueOf(1);
            		}
            		else if(label.equals("Entertainment"))
            		{
            			distribution.appDistribution[distribution.counter][1][2] =  String.valueOf(1);
            		}	
            		else if(label.equals("Dining"))
            		{
            			distribution.appDistribution[distribution.counter][1][3] =  String.valueOf(1);
            		}
            		else if(label.equals("Shopping"))	
            		{
            			distribution.appDistribution[distribution.counter][1][4] =  String.valueOf(1);
            		}
            		else if(label.equals("Sporting"))
            		{
            		
            			distribution.appDistribution[distribution.counter][1][5] =  String.valueOf(1);
            		}	
                	distribution.counter++;
                	
                }

                //HttpRequest httpRequest = new HttpRequest();
                //String category = httpRequest.sendGet(name);
                //System.out.println(name+":" + category);
                //System.out.println(name+":");
                //row.add(name);
            }
            

            
           // Date date = new Date(Long.parseLong(timestamp)*1000L); // *1000 is to convert seconds to milliseconds
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); // the format of your date
            sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            //String formattedDate = sdf.format(date);
            //System.out.println(app.size()+ " "+formattedDate+"\n\n");
            //result.add(row);
            
        }
        //System.out.println(counterUnit);
        //System.out.println(label2);
        if(label2.equals("Sporting"))
        	distribution.activityDistribution[5]++;
        else if(label2.equals("Transportation"))
        	distribution.activityDistribution[0]++;
        else if(label2.equals("Dining"))
        	distribution.activityDistribution[3]++;
        else if(label2.equals("Working"))
        	distribution.activityDistribution[1]++;
        else if(label2.equals("Shopping"))
        	distribution.activityDistribution[4]++;
        else if(label2.equals("Entertainment"))
        	distribution.activityDistribution[2]++;
        return;
        
    }
	
	// FOR gps testing data invalid
	public int InitializeHardware(String filename, Result result, ArrayList<Cluster> clusters, TimeDistribution timeDistribution)
	{
		int inference = -100;
        try
        {
        	inference = InitializeHardware(new FileReader(filename), result, clusters, timeDistribution);
        	return inference;
        }
        catch(Exception e)
        {
        	// print format is broken
            System.err.println(filename+ " is broken !");
        }
        return -100;
		
	}
	
	
	public String InitializeHardware(String filename, Result result, List<GPSData> trajectory)
    {
		String activity = null;
        try
        {
        	activity = InitializeHardware(new FileReader(filename), result, trajectory);
        }
        catch(Exception e)
        {
        	// print format is broken
            System.err.println(filename+ " is broken !");
        }
        return activity;
    }
	
	
	// FOR gps testing data invalid
	public int InitializeHardware(Reader reader, Result result, ArrayList<Cluster> clusters, TimeDistribution timeDistribution ) throws Exception
	{
		
		Parameter parameter = new Parameter();
		//System.out.println("processing");
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        String activity = null;
        int inference = 0;
        int flag = 0;
        Iterator iterator = arr.iterator();
        int counter = 0;
        
        int score[] = new int[6];
        while (iterator.hasNext()) {
        	counter++;
        	JSONObject parse = (JSONObject) iterator.next();
        	String lifelable = (String) parse.get("lifelable");
        	JSONArray gps = (JSONArray) parse.get("GPS");
        	activity = lifelable;
        	if(gps.size() > 0)
        	{
        		flag = 1;
            	inference = this.getGpsData(gps, clusters);
            	if(inference != -1) 
            	{
            		score[inference]++;
            		
            	}
        	}
        }
        
        int index = -1, maxValue = 0;
        for(int i = 0; i < 6; i++) {
        	if(score[i] > maxValue)
        	{
        		index = i;
        		maxValue = score[i];
        	}
        }
        
        // 沒有gps information
        if(flag == 0)
        	return 0;
        
        
        if(index == 0 && activity.equals("Transportation"))
        	return 1;  
        else if(index == 1 && activity.equals("Working"))
        	return 1;
        else if(index == 2 && activity.equals("Dining"))
        	return 1;
        else if(index == 3 && activity.equals("Sporting"))
        	return 1;
        else if(index == 4 && activity.equals("Shopping"))
        	return 1;
        else if(index == 5 && activity.equals("Entertainment"))
        	return 1;
        else
        {
        	// cluster內沒資料，用過去使用者這個時間都在幹嘛來推斷
        	if(index == -1)
        	{
        		Map<String, Integer> regionCategory = new HashMap<String, Integer>();
        		HttpRequest httpRequest = new HttpRequest();
        		
        		regionCategory = httpRequest.sendGet(startY,startX,parameter.radius*1000);
        		int index2 = -1, maxValue2 = 0;
        		if(timeDistribution.tTimeDistribution.get(startHour)!=null && timeDistribution.tTimeDistribution.get(startHour) > maxValue2)
        		{
        			index2 = 0;
        			maxValue2 = timeDistribution.tTimeDistribution.get(startHour);
        			
        		}
        		if(timeDistribution.dTimeDistribution.get(startHour)!=null && timeDistribution.dTimeDistribution.get(startHour) > maxValue2)
        		{
        			index2 = 2;
        			maxValue2 = timeDistribution.dTimeDistribution.get(startHour);
        			
        		}
        		if(timeDistribution.wTimeDistribution.get(startHour)!=null && timeDistribution.wTimeDistribution.get(startHour) > maxValue2)
        		{
        			index2 = 1;
        			maxValue2 = timeDistribution.wTimeDistribution.get(startHour);
        			
        		}        		if(timeDistribution.tTimeDistribution.get(startHour)!=null && timeDistribution.tTimeDistribution.get(startHour) > maxValue2)
        		if(timeDistribution.shTimeDistribution.get(startHour)!=null && timeDistribution.shTimeDistribution.get(startHour) > maxValue2)
        		{
        			index2 = 4;
        			maxValue2 = timeDistribution.shTimeDistribution.get(startHour);
        			
        		}
        		if(timeDistribution.spTimeDistribution.get(startHour)!=null && timeDistribution.spTimeDistribution.get(startHour) > maxValue2)
        		{
        			index2 = 3;
        			maxValue2 = timeDistribution.spTimeDistribution.get(startHour);
        			
        		}
        		if(timeDistribution.eTimeDistribution.get(startHour)!=null && timeDistribution.eTimeDistribution.get(startHour) > maxValue2)
        		{
        			index2 = 5;
        			maxValue2 = timeDistribution.eTimeDistribution.get(startHour);
        			
        		}
        		
        		if(index2 == 0 && activity.equals("Transportation"))
                	return 1;  
                else if(index2 == 1 && activity.equals("Working"))
                	return 1;
                else if(index2 == 2 && activity.equals("Dining"))
                	return 1;
                else if(index2 == 3 && activity.equals("Sporting"))
                	return 1;
                else if(index2 == 4 && activity.equals("Shopping"))
                	return 1;
                else if(index2 == 5 && activity.equals("Entertainment"))
                	return 1;
        		
        		System.out.println(index2+" "+activity);
        		if(timeDistribution.dTimeDistribution.get(startHour)!=null)
        			System.out.println("d: " +timeDistribution.dTimeDistribution.get(startHour));
        		if(timeDistribution.wTimeDistribution.get(startHour)!=null)
        			System.out.println("w: " +timeDistribution.wTimeDistribution.get(startHour));
        		if(timeDistribution.tTimeDistribution.get(startHour)!=null)
        			System.out.println("t: " +timeDistribution.tTimeDistribution.get(startHour));
        		if(timeDistribution.shTimeDistribution.get(startHour)!=null)
        			System.out.println("sh: " +timeDistribution.shTimeDistribution.get(startHour));
        		if(timeDistribution.spTimeDistribution.get(startHour)!=null)
        			System.out.println("sp: " +timeDistribution.spTimeDistribution.get(startHour));
        		if(timeDistribution.eTimeDistribution.get(startHour)!=null)
        			System.out.println("e: " +timeDistribution.eTimeDistribution.get(startHour));
        		return -2;
        		
        	}
        		
        	// 猜錯
        	else
        	{
        		if(activity.equals("Transportation"))
        			System.out.println(score[index]+" "+score[0]); 
                else if(activity.equals("Working"))
                	System.out.println(score[index]+" "+score[1]);
                else if(activity.equals("Dining"))
                	System.out.println(score[index]+" "+score[2]);
                else if(activity.equals("Sporting"))
                	System.out.println(score[index]+" "+score[3]);
                else if(activity.equals("Shopping"))
                	System.out.println(score[index]+" "+score[4]);
                else if(activity.equals("Entertainment"))
                	System.out.println(score[index]+" "+score[5]);
        		
        		return -1;
        	}
        		
        }
        	
        

        
	}
	
	
	
	public String InitializeHardware(Reader reader, Result result, List<GPSData> trajectory) throws IOException, ParseException
	{
		
		Parameter parameter = new Parameter();
		//System.out.println("processing");
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        String activity = null;
        Iterator iterator = arr.iterator();
        int counter = 0;
        // 一個file內同時段activity只計算一次
        while (iterator.hasNext()) {
        	counter++;
        	JSONObject parse = (JSONObject) iterator.next();
            JSONArray magne = (JSONArray) parse.get("Magne");
            JSONArray gyro = (JSONArray) parse.get("Gyro");
            JSONArray accel = (JSONArray) parse.get("Accel");
            String lifelable = (String) parse.get("lifelable");
            JSONArray proxymity = (JSONArray) parse.get("Proximity");
            JSONArray light = (JSONArray) parse.get("Light");
            JSONArray gps = (JSONArray) parse.get("GPS");
            JSONArray pressure = (JSONArray) parse.get("Pressure");
            String time = (String) parse.get("Time");
            activity = lifelable;
            
            if(gps.size() > 0)
            	this.getGpsData(gps, trajectory);
            if(accel.size() > 0)
            	this.getAccelData(accel, result, lifelable);
            
        }
        
        if(parameter.hard_or_soft == 1)
        	return activity;
        
        double force = (average/counter); //針對每一個file所產生的平均加速度值
        double std = Math.sqrt((power/counter) - Math.pow(force,2)); //針對每一個file所產生的加速度值標準差
        //System.out.println(counter);
        //System.out.println(activity);
          System.out.println(max+","+std+","+activity);
//        System.out.println("MAX: "+ max);
//        System.out.println("AVG: "+ force+" "+average+" "+counter);
//        System.out.println("MIN: "+ min);
//        System.out.println("STD: "+ std);
        
        if(activity.equals("Sporting"))
        {
        	result.counterSporting++;
        	
        	result.setAvgSporting(force);
        	result.setStdSporting(std);
        	if(max > result.getMaxSporting())
        		result.setMaxSporting(max);
        	if(min < result.getMinSporting() && min > 0.0)
        		result.setMinSporting(min);
        }
        else if(activity.equals("Transportation"))
        {
        	result.counterTransportation++;
        	result.setAvgTransportation(force);
        	result.setStdTransportation(std);
        	if(max > result.getMaxTransportation())
        		result.setMaxTransportation(max);
        	if(min < result.getMinTransportation() && min > 0.0)
        		result.setMinTransportation(min);
        }
        else if(activity.equals("Dining"))
        {
        	result.counterDining++;
        	result.setAvgDining(force);
        	result.setStdDining(std);
        	if(max > result.getMaxDining())
        		result.setMaxDining(max);
        	if(min < result.getMinDining() && min > 0.0)
        		result.setMinDining(min);
        }
        else if(activity.equals("Working"))
        {
        	result.counterWorking++;
        	result.setAvgWorking(force);
        	result.setStdWorking(std);
        	if(max > result.getMaxWorking())
        		result.setMaxWorking(max);
        	if(min < result.getMinWorking() && min > 0.0)
        		result.setMinWorking(min);
        }
        else if(activity.equals("Shopping"))
        {
        	result.counterShopping++;
        	result.setAvgShopping(force);
        	result.setStdShopping(std);
        	if(max > result.getMaxShopping())
        		result.setMaxShopping(max);
        	if(min < result.getMinShopping() && min > 0.0)
        		result.setMinShopping(min);
        }
        else if(activity.equals("Entertainment"))
        {
        	result.counterEntertainment++;
        	result.setAvgEntertainment(force);
        	result.setStdEntertainment(std);
        	if(max > result.getMaxEntertainment())
        		result.setMaxEntertainment(max);
        	if(min < result.getMinEntertainment() && min > 0.0)
        		result.setMinEntertainment(min);
        }
        return activity;
	}
	
	 public void getAccelData(JSONArray array, Result result, String lifelable) 
	 {
		 	String duringOneSecond = null;
		 	List<Double> xAxis = new ArrayList<Double>();
		 	List<Double> yAxis = new ArrayList<Double>();
		 	List<Double> zAxis = new ArrayList<Double>();
		 	xAxis.clear();
        	yAxis.clear();
        	zAxis.clear();
		 	
	        for (int i = 0; i < array.size(); i++) {
	            JSONObject obj = (JSONObject) array.get(i);
	            double x = Double.parseDouble(obj.get("X").toString());
	            double y = Double.parseDouble(obj.get("Y").toString());
	            double z = Double.parseDouble(obj.get("Z").toString());
	            //double force = force(x, y, z);
	            String timestamp = obj.get("time").toString();
	            Parameter parameter = new Parameter();
	            if(parameter.version == 2)
	            	 timestamp = timestamp.substring(0, timestamp.length()-3);
	           
	            if(!timestamp.equals(duringOneSecond))
	            {
	            	duringOneSecond = timestamp;
	            	
	            	if(i != 0)
	            	{
	            		double avgX = 0; 
	            		double avgY = 0;
	            		double avgZ = 0;
	            		for(int j = 0; j < xAxis.size(); j++) {
	            			avgX += xAxis.get(j);
	            			avgY += yAxis.get(j);
	            			avgZ += zAxis.get(j);
	            		}
//	            		if(xAxis.size() == 0)
//	            		{
//	            			System.out.println(duringOneSecond);
//	            			xAxis.clear();
//			            	yAxis.clear();
//			            	zAxis.clear();
//		    	            
//		    	            xAxis.add(x);
//			            	yAxis.add(y);
//			            	zAxis.add(z);
//			            	continue;
//
//	            		}
	            		
	            		avgX /= xAxis.size();
	            		avgY /= yAxis.size();
	            		avgZ /= zAxis.size();
	            		double force = force(avgX, avgY, avgZ);
	   
	            		if(force > max)
	     	            {
	     	            	max = force;
	     	            }
	     	            	
	     	            if(force < min  && force > 0)
	     	            {
	     	            	min = force;
	     	            }
	     	            //System.out.print(counter + ": " + x + " " + y + " " + z + "\n");
	    	            average += force;
	    	            power += Math.pow(force,2);
	    	            
	    	            counter++;
	    	            
	    	            xAxis.clear();
		            	yAxis.clear();
		            	zAxis.clear();
	    	            
	    	            xAxis.add(x);
		            	yAxis.add(y);
		            	zAxis.add(z);
	            		
	            	}
	            	else
	            	{
	            		 xAxis.clear();
			            yAxis.clear();
			            zAxis.clear();
		    	            
		    	          xAxis.add(x);
			            yAxis.add(y);
			            zAxis.add(z);
	            		
	            	}
	            }
	            else
	            {
	            	xAxis.add(x);
	            	yAxis.add(y);
	            	zAxis.add(z);
	            }
	        }
	        
	        double avgX = 0; 
    		double avgY = 0;
    		double avgZ = 0;
    		for(int j = 0; j < xAxis.size(); j++) {
    			avgX += xAxis.get(j);
    			avgY += yAxis.get(j);
    			avgZ += zAxis.get(j);
    		}
    		avgX /= xAxis.size();
    		avgY /= yAxis.size();
    		avgZ /= zAxis.size();
    		double force = force(avgX, avgY, avgZ);
    		//System.out.println(force+" "+duringOneSecond);
    		if(force > max)
	            {
	            	max = force;
	            }
	            	
	            if(force < min  && force > 0)
	            {
	            	min = force;
	            }
	            //System.out.print(counter + ": " + x + " " + y + " " + z + "\n");
            average += force;
            power += Math.pow(force,2);
            
            counter++;
	        
	        
	 }
	 
	 // root of sum of square
	 public double force(double x, double y, double z)
	 {
		 double force = Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2);
		 force = Math.sqrt(force);
		 return force;
	 }
	 
	 
	 public int getGpsData(JSONArray array, ArrayList<Cluster> clusters) throws Exception
	 {
		 double centralX = 0, centralY = 0;
		 int hourOfDay = 0;
		 
		 Parameter parameter = new Parameter();
		 for (int i = 0; i < array.size(); i++) {
			 JSONObject obj = (JSONObject) array.get(i);
			 centralX += Double.parseDouble(obj.get("X").toString());
			 centralY += Double.parseDouble(obj.get("Y").toString());
			 
			 String timestamp = obj.get("time").toString();
			 timestamp = timestamp.substring(0, timestamp.length()-3);
			 long hour = Long.valueOf(timestamp);
			 Calendar calendar = Calendar.getInstance();
			 calendar.setTimeInMillis(hour * 1000);
			 hourOfDay += calendar.get(Calendar.HOUR_OF_DAY);
		 }
		 centralX /= array.size();
		 centralY /= array.size();
		 hourOfDay /= array.size();
		
		 if(g_counter == 0)
		 {
			 startX = centralX;
			 startY = centralY;
			 startHour = hourOfDay;
		 }
		 
		// 計算testing data的gps point有無落在 cluster內
		int score[] = new int[6];
		for(int j = 0; j < clusters.size(); j++) {
				double earth_radius=6378.137;  
		    	double lat1=rad(clusters.get(j).centralLat);
		    	double lat2=rad(centralY);
		        double lon1=rad(clusters.get(j).centralLon);
		        double lon2=rad(centralX);
		              
		        double a=lat1-lat2;
		        double b=lon1-lon2;
		        double s=2d * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2d),2d) + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(b/2d),2d)));
		                  
		        s = s * earth_radius;
		        s = Math.round(s * 10000d) / 10000d;
		        
		        
		        // 在這個cluster的範圍內(100 m)
		        if(s < parameter.radius)
		        {
		        	if(clusters.get(j).transportation.containsKey(hourOfDay))
		        		score[0] = clusters.get(j).transportation.get(hourOfDay);
		        	if(clusters.get(j).working.containsKey(hourOfDay))
		        		score[1] = clusters.get(j).working.get(hourOfDay);
		        	if(clusters.get(j).dining.containsKey(hourOfDay))
		        		score[2] = clusters.get(j).dining.get(hourOfDay);
		        	if(clusters.get(j).sporting.size() > 0)	
		        		score[3] = clusters.get(j).sporting.get(hourOfDay);
		        	if(clusters.get(j).shopping.size() > 0)	
		        		score[4] = clusters.get(j).shopping.get(hourOfDay);
		        	if(clusters.get(j).entertainment.size() > 0)	
		        		score[5] = clusters.get(j).entertainment.get(hourOfDay);
		        	
		        	int index = -1, maxValue = 0;
		        	for(int k = 0 ; k < 6 ; k++) {
		        		if(score[k] > maxValue)
		        			index = k;	
		        	}
		        		
		        	if(index == 0)
		        		return 0;
		        	if(index == 1)
		        		return 1;
		        	if(index == 2)
		        		return 2;
		        	if(index == 3)
		        		return 3;
		        	if(index == 4)
		        		return 4;
		        	if(index == 5)
		        		return 5;	
		        }
		}
		return -1;
	 }
	 
	 public void getGpsData(JSONArray array, List<GPSData> trajectory)
	 {
		 for (int i = 0; i < array.size(); i++) {
			 JSONObject obj = (JSONObject) array.get(i);
			 double x = Double.parseDouble(obj.get("X").toString());
			 double y = Double.parseDouble(obj.get("Y").toString());
			
			 GPSData point = new GPSData();
			 point.longitude = Double.parseDouble(obj.get("X").toString());
			 point.latitude = Double.parseDouble(obj.get("Y").toString());
			 point.timestamp = obj.get("time").toString();
			 point.speed = Double.parseDouble(obj.get("Speed").toString());
			 trajectory.add(point);
		 }
	 }
	 
	 public double rad(double a)
	 {
	    	return a * Math.PI/180.0;
	 }
	 
}
