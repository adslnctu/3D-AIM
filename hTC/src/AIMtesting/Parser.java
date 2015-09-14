package AIMtesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Scanner;
public class Parser {
	
	private int counter;
	private double average;
	private double power; // for 標準差
	private double max;
	private double min;
	private double startY; // center of location
	private double startX; // for giving location score
	private int startHour; // time
	private int g_counter = 0; // for giving location score
	
	public Parser()
	{
		counter = 0;
		average = 0;
		power = 0;
		max = 0;
		min = 100;
		
	}
	

	public int testing(String fileName, Profile profile, String version, int fileNo, long elapsedTime) throws FileNotFoundException
    {
		String time = fileName.substring(fileName.indexOf(" ")+1, fileName.indexOf("-",fileName.indexOf(" ")+1));
		 int noGPS = 1;
		Reader reader = new FileReader(fileName);
        try
        {
        	JSONParser jsonParser = new JSONParser();
            JSONArray arr = (JSONArray) jsonParser.parse(reader);
            String activity = null;
            Iterator iterator = arr.iterator();
           
            
            while (iterator.hasNext()) {
            	JSONObject parse = (JSONObject) iterator.next();
                JSONArray accel = (JSONArray) parse.get("Accel");
                if(parse.get("lifelabel") == null)
                	activity = parse.get("lifelable").toString();
                else
                	activity = parse.get("lifelabel").toString();
                JSONArray gps = (JSONArray) parse.get("GPS");

                if(accel.size() > 0)
                {
                	long startTime = System.currentTimeMillis();
                	this.getAccelData(accel, version);
                	long stopTime = System.currentTimeMillis();
                    elapsedTime += stopTime - startTime;
                
                }
                
                if(gps.size() > 0)
            	{
                	noGPS = 0;
                	long startTime = System.currentTimeMillis();
                	this.getGpsData(gps, profile.clusters, profile, fileNo);
                	long stopTime = System.currentTimeMillis();
                    elapsedTime += stopTime - startTime;
            	}
            };
            
            
            long startTime = System.currentTimeMillis();
	        if(noGPS == 0)
	        {
	        	
	        	System.out.println("Has GPS points!!!: "+activity);
	        	
            	int index = -1;
            	double maxValue = 0;
	            for(int i = 0; i < 6; i++) {
	            	if(profile.locationScore[fileNo][i] > maxValue)
	            	{
	            		index = i;
	            		maxValue = profile.locationScore[fileNo][i];
	            	}
	            }
	            //System.out.println("!!!"+profile.locationScore[fileNo][0]+profile.locationScore[fileNo][1]+profile.locationScore[fileNo][2]+profile.locationScore[fileNo][3]+profile.locationScore[fileNo][4]+profile.locationScore[fileNo][5]);
	           
	            profile.totalGps++;
	            if(index == -1)
	            {
	            	if(activity.equals("Transportation"))
	            		profile.publicOpinionUsed++;
	            }
	            
	            
	            /* public opinion */
	            if(index == -1 && profile.tTimeDistribution.get(startHour) == null
	            		       && profile.dTimeDistribution.get(startHour) == null
	            		       && profile.wTimeDistribution.get(startHour) == null
	            		       && profile.shTimeDistribution.get(startHour) == null
	            		       && profile.spTimeDistribution.get(startHour) == null
	            		       && profile.eTimeDistribution.get(startHour) == null )
	            {
	            	
	            	
	        		Map<String, Double> regionCategory = new HashMap<String, Double>();
	        		Map<String, Double> activityCategory = new HashMap<String, Double>();
	        		HttpRequest httpRequest = new HttpRequest();	        		
	        		Parameter parameter = new Parameter();
	        		regionCategory = httpRequest.sendGet(startY,startX,parameter.radius*1000);
		            System.out.println(startY+" "+ startX);
		            double totalVenue = 0;
		            for (Map.Entry<String, Double> entry : regionCategory.entrySet())
		            {
		                //System.out.println(entry.getKey() + ": " + entry.getValue());
		                totalVenue += entry.getValue();
		            }
		            
		            for (Map.Entry<String, Double> entry : regionCategory.entrySet())
		            {
		            	
		            	regionCategory.put(entry.getKey(), entry.getValue()/totalVenue * Math.log10(totalVenue/entry.getValue()));
		            	//System.out.println(entry.getKey() + ": " + entry.getValue());
		            }
		            
		            AreaCategory areaCategory = new AreaCategory();
		            
		            for (Map.Entry<String, Double> entry : regionCategory.entrySet())
		            {
		            	String activityString = areaCategory.activitySearch(entry.getKey());
		            	if(activityCategory.containsKey(activityString))
		            	{
		            		double value = activityCategory.get(activityString);
		            		activityCategory.put(activityString, value+entry.getValue());
		            	}
		            	else
		            	{
		            		activityCategory.put(activityString, entry.getValue());
		            		
		            	}
		            }
		            
		            // normalize
		            double temp = 0;
		            for (Map.Entry<String, Double> entry : activityCategory.entrySet())
		            	temp += entry.getValue();
		            for (Map.Entry<String, Double> entry : activityCategory.entrySet()) {
		            	 activityCategory.put(entry.getKey(), entry.getValue()/temp);
		            
		            }
		            
		            String publicOpinionInference = null;
		            double maxValue2= 0;
		            for (Map.Entry<String, Double> entry : activityCategory.entrySet())
		            {
		                System.out.println(entry.getKey() + ": " + entry.getValue());
		                if(entry.getKey().equals("Transportation"))
			        		profile.locationScore[fileNo][2] = entry.getValue();
		                if(entry.getKey().equals("Working"))
			        		profile.locationScore[fileNo][0] = entry.getValue();
		                if(entry.getKey().equals("Dining"))
			        		profile.locationScore[fileNo][1] = entry.getValue();
		                if(entry.getKey().equals("Sporting"))
			        		profile.locationScore[fileNo][4] = entry.getValue();
		                if(entry.getKey().equals("Shopping"))
			        		profile.locationScore[fileNo][5] = entry.getValue();
		                if(entry.getKey().equals("Entertainment"))
			        		profile.locationScore[fileNo][3] = entry.getValue();
		                if(entry.getValue() > maxValue2)
		                {
		                	maxValue2 = entry.getValue();
		                	publicOpinionInference = entry.getKey();
		                }
		            }
		            
	            }
	         
	            else
	            	;
	            
	            
	            
	            
	            
	            
	            
	            if(index == -1)
	        	{
	            	double temp2 = 0;
	            	
	            	if(profile.tTimeDistribution.get(startHour) != null)
	            		temp2 += profile.tTimeDistribution.get(startHour);
	            	if(profile.dTimeDistribution.get(startHour) != null)
	            		temp2 += profile.dTimeDistribution.get(startHour);
	            	if(profile.wTimeDistribution.get(startHour) != null)
	            		temp2 += profile.wTimeDistribution.get(startHour);
	            	if(profile.shTimeDistribution.get(startHour) != null)
	            		temp2 += profile.shTimeDistribution.get(startHour);
	            	if(profile.spTimeDistribution.get(startHour) != null)
	            		temp2 += profile.spTimeDistribution.get(startHour);
	            	if(profile.eTimeDistribution.get(startHour) != null)
	            		temp2 += profile.eTimeDistribution.get(startHour);
	            		
	        		if(profile.tTimeDistribution.get(startHour) != null)
	        			profile.locationScore[fileNo][2] += (double)profile.tTimeDistribution.get(startHour)/temp2;
	        		if(profile.dTimeDistribution.get(startHour) != null)
	        			profile.locationScore[fileNo][1] += (double)profile.dTimeDistribution.get(startHour)/temp2;
	        		if(profile.wTimeDistribution.get(startHour) != null)
	        			profile.locationScore[fileNo][0] += (double)profile.wTimeDistribution.get(startHour)/temp2;       		
	        		if(profile.shTimeDistribution.get(startHour) != null)
	        			profile.locationScore[fileNo][5] += (double)profile.shTimeDistribution.get(startHour)/temp2;
	        		if(profile.spTimeDistribution.get(startHour) != null)
	        			profile.locationScore[fileNo][4] += (double)profile.spTimeDistribution.get(startHour)/temp2;
	        		if(profile.eTimeDistribution.get(startHour) != null)
	        			profile.locationScore[fileNo][3] += (double)profile.eTimeDistribution.get(startHour)/temp2;
	        	
	        
	        		System.out.println(profile.locationScore[fileNo][0]+" "+profile.locationScore[fileNo][1]+" "+profile.locationScore[fileNo][2]+" "+profile.locationScore[fileNo][3]+" "+profile.locationScore[fileNo][4]+" "+profile.locationScore[fileNo][5]);
		            int inferenceActivity = -1;
		            double max = 0;
		            for(int i = 0; i < 6; i++) {
		            	if(profile.locationScore[fileNo][i] > max)
		            	{
		            		inferenceActivity = i;
		            		max = profile.locationScore[fileNo][i];
		            	}
		            }
		            
		            
	        	} 
	        }
	        else
        	{
	        	
	        	startHour = Integer.valueOf(time);

        		//Map<String, Integer> regionCategory = new HashMap<String, Integer>();
        		//HttpRequest httpRequest = new HttpRequest();
        		
        		Parameter parameter = new Parameter();
        		// 目前沒用foursquare
        		//regionCategory = httpRequest.sendGet(startY,startX,parameter.radius*1000);
        		
        		if(profile.tTimeDistribution.get(startHour) != null)
        			profile.locationScore[fileNo][2] = profile.tTimeDistribution.get(startHour);
        		if(profile.dTimeDistribution.get(startHour) != null)
        			profile.locationScore[fileNo][1] = profile.dTimeDistribution.get(startHour);
        		if(profile.wTimeDistribution.get(startHour) != null)
        			profile.locationScore[fileNo][0] = profile.wTimeDistribution.get(startHour);       		
        		if(profile.shTimeDistribution.get(startHour) != null)
        			profile.locationScore[fileNo][5] = profile.shTimeDistribution.get(startHour);
        		if(profile.spTimeDistribution.get(startHour) != null)
        			profile.locationScore[fileNo][4] = profile.spTimeDistribution.get(startHour);
        		if(profile.eTimeDistribution.get(startHour) != null)
        			profile.locationScore[fileNo][3] = profile.eTimeDistribution.get(startHour);
        	}
            
            
            double force = (average/counter); //針對每一個file所產生的平均加速度值
            double std = Math.sqrt((power/counter) - Math.pow(force,2)); //針對每一個file所產生的加速度值標準差
            System.out.println(activity+" "+std+" "+power+" "+force+" "+counter);
            profile.std[fileNo] = std;
            int max = 0;
            int index = -1;
            for(int i = 0; i < 6; i++) {
            	
            	
            	profile.distributionMatrixScore[fileNo][i] = profile.weightedTable[(int)(std*10)][i];
            	if(profile.weightedTable[(int)(std*10)][i] > max)
            	{
            		max = profile.weightedTable[(int)(std*10)][i];
            		index = i;
            	}
            }
            System.out.println();
            long stopTime = System.currentTimeMillis();
            elapsedTime += stopTime - startTime;
            //以下要刪掉
            
            if(index == 2 && activity.equals("Transportation"))
            {
            	return 1;
            }
            else if(index == 0 && activity.equals("Working"))
            {
            	return 1;
            }
            else if(index == 1 && activity.equals("Dining"))
            {
            	return 1;
            }
            else if(index == 4 && activity.equals("Sporting"))
            {
            	return 1;
            }
            else if(index == 5 && activity.equals("Shopping"))
            {
            	return 1;
            }
            else if(index == 3 && activity.equals("Entertainment"))
            {
            	return 1;
            }
            else if(index == -1)
            	return -1;
            else
            	return 0;
            	
            
        }
        catch(Exception e)
        {
            System.err.println(fileName+ " is broken !");
            return -1;
        }
    }
	
	public void getAccelData(JSONArray array, String version) 
	{
			
		String duringOneSecond = null;
		List<Double> xAxis = new ArrayList<Double>();
		List<Double> yAxis = new ArrayList<Double>();
		List<Double> zAxis = new ArrayList<Double>();
		 	
	    for (int i = 0; i < array.size(); i++) {
	    	JSONObject obj = (JSONObject) array.get(i);
	        double x = Double.parseDouble(obj.get("X").toString());
	        double y = Double.parseDouble(obj.get("Y").toString());
	        double z = Double.parseDouble(obj.get("Z").toString());
	        //double force = force(x, y, z);
	        String timestamp = obj.get("time").toString();

	        Parameter parameter = new Parameter();
	            
	        if(version.equals("V2"))
	        {
	        	timestamp = timestamp.substring(0, timestamp.length()-3);
	            	//System.out.println(version+" "+timestamp);
	        }
	            	 
	           
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
	 
	 public double force(double x, double y, double z)
	 {
		 double force = Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2);
		 force = Math.sqrt(force);
		 return force;
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
	 
	 // for testing data (giving location score)
	 public int getGpsData(JSONArray array, ArrayList<Cluster> clusters, Profile profile, int fileNo) throws Exception
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
		        		profile.locationScore[fileNo][2] = clusters.get(j).transportation.get(hourOfDay);
		        	if(clusters.get(j).working.containsKey(hourOfDay))
		        		profile.locationScore[fileNo][0] = clusters.get(j).working.get(hourOfDay);
		        	if(clusters.get(j).dining.containsKey(hourOfDay))
		        		profile.locationScore[fileNo][1] = clusters.get(j).dining.get(hourOfDay);
		        	if(clusters.get(j).sporting.size() > 0)	
		        		profile.locationScore[fileNo][4] = clusters.get(j).sporting.get(hourOfDay);
		        	if(clusters.get(j).shopping.size() > 0)	
		        		profile.locationScore[fileNo][5] = clusters.get(j).shopping.get(hourOfDay);
		        	if(clusters.get(j).entertainment.size() > 0)	
		        		profile.locationScore[fileNo][3] = clusters.get(j).entertainment.get(hourOfDay);
		        	
		    		

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
}
