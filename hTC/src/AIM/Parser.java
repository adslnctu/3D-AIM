package AIM;

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
	private double startY; // for giving location score
	private double startX; // for giving location score
	private int startHour; // for giving location score
	private int g_counter = 0; // for giving location score
	
	public Parser()
	{
		counter = 0;
		average = 0;
		power = 0;
		max = 0;
		min = 100;
		
	}
	
	public void buildProfile(String fileName, Profile profile, String version, int fileNo, long elapsedTime) throws FileNotFoundException
    {
		profile.flagGps = 0;
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
                	this.getAccelData(accel, version);
                if(gps.size() > 0) {
                	//System.out.println("GPS size:"+gps.size());
                	profile.flagGps = 1;
                	this.getGpsData(gps, Profile.trajectory);
                }
            };
            
            if(profile.flagGps == 1)
            	profile.trainingGps++;

        	long startTime = System.currentTimeMillis();
            double force = (average/counter); //針對每一個file所產生的平均加速度值
            double std = Math.sqrt((power/counter) - Math.pow(force,2)); //針對每一個file所產生的加速度值標準差
            Profile.std[fileNo] = std;
            
            System.out.println(activity+"\n"+std);
            /* build weighted table */
            if(activity.equals("Transportation"))
            {
            	Profile.transportationTotal++;
            	Profile.weightedTable[(int)(std * 10)][2]++; 
            }
            else if(activity.equals("Working"))
            {
            	Profile.workingTotal++;
            	Profile.weightedTable[(int)(std * 10)][0]++; 
            }
            else if(activity.equals("Dining"))
            {
            	Profile.diningTotal++;
            	Profile.weightedTable[(int)(std * 10)][1]++; 
            }
            else if(activity.equals("Sporting"))
            {
            	Profile.sportingTotal++;
            	Profile.weightedTable[(int)(std * 10)][4]++; 
            }
            else if(activity.equals("Shopping"))
            {
            	Profile.shoppingTotal++;
            	Profile.weightedTable[(int)(std * 10)][5]++; 
            }
            else if(activity.equals("Entertainment"))
            {
            	Profile.entertainmentTotal++;
            	Profile.weightedTable[(int)(std * 10)][3]++; 
            }
            else
            {
            	System.err.println("Weighted table error !"+" "+activity);
            }
            /* build weighted table */
            
            
            /* build time distribution of activity */
            int hourOfDay = Integer.valueOf(fileName.substring(fileName.indexOf(" ")+1, fileName.indexOf(" ")+3));
    		if(activity.equals("Transportation"))
			{
				if(Profile.tTimeDistribution.get(hourOfDay) != null)
					Profile.tTimeDistribution.put(hourOfDay, Profile.tTimeDistribution.get(hourOfDay)+1);
				else
					Profile.tTimeDistribution.put(hourOfDay, 1);
			}
			else if(activity.equals("Working"))
			{
				if(Profile.wTimeDistribution.get(hourOfDay) != null)
					Profile.wTimeDistribution.put(hourOfDay, Profile.wTimeDistribution.get(hourOfDay)+1);
				else
					Profile.wTimeDistribution.put(hourOfDay, 1);
			}
			else if(activity.equals("Dining"))
			{
				if(Profile.dTimeDistribution.get(hourOfDay) != null)
					Profile.dTimeDistribution.put(hourOfDay, Profile.dTimeDistribution.get(hourOfDay)+1);
				else
					Profile.dTimeDistribution.put(hourOfDay, 1);
			}
			else if(activity.equals("Shopping"))
			{
				if(Profile.shTimeDistribution.get(hourOfDay) != null)
					Profile.shTimeDistribution.put(hourOfDay, Profile.shTimeDistribution.get(hourOfDay)+1);
				else
					Profile.shTimeDistribution.put(hourOfDay, 1);
			}
			else if(activity.equals("Sporting"))
			{
				if(Profile.spTimeDistribution.get(hourOfDay) != null)
					Profile.spTimeDistribution.put(hourOfDay, Profile.spTimeDistribution.get(hourOfDay)+1);
				else
					Profile.spTimeDistribution.put(hourOfDay, 1);
			}
			else if(activity.equals("Entertainment"))
			{
				if(Profile.eTimeDistribution.get(hourOfDay) != null)
					Profile.eTimeDistribution.put(hourOfDay, Profile.eTimeDistribution.get(hourOfDay)+1);
				else
					Profile.eTimeDistribution.put(hourOfDay, 1);
			}
    		/* build time distribution of activity */
    	    long stopTime = System.currentTimeMillis();
    	    elapsedTime += stopTime - startTime;
            
//    		stayPointDetection(profile.stayPoint, profile.trajectory, profile);
//    		System.out.println("GPS points: "+profile.trajectory.size());
//    		System.out.println("[Stay Point]");
//    		for(int i = 0; i<profile.stayPoint.size(); i++) {
//    			System.out.println(profile.stayPoint.get(i).latitude+" "+profile.stayPoint.get(i).longitude);
//    			
//    		}
    			
    		
    		/* extract gps points */
    		for (int i = 0; i < Profile.trajectory.size(); i++) {
    			double[] gpsPoint={Profile.trajectory.get(i).latitude, Profile.trajectory.get(i).longitude};
    			String timestamp = Profile.trajectory.get(i).timestamp;
    			double speed = Profile.trajectory.get(i).speed;
    			if(speed > Profile.speed[fileNo])
    				Profile.speed[fileNo] = speed;
    				
    			Profile.dpoints.add(new DataPoint(gpsPoint, String.valueOf(Profile.gpsPointName), activity, timestamp, speed));
    			Profile.gpsPointName++;
    		}
    		/* extract gps points */
        }
        catch(Exception e)
        {
            System.err.println(fileName+ " is broken !");
        }
    }
	
	public double distance(double raw_lon1, double raw_lat1, double raw_lon2, double raw_lat2) 
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
	
	public void stayPointDetection(List<GPSData> stayPointSet, List<GPSData> trajectory, Profile profile)
	{

        
        
        // 在這個cluster的範圍內(100 m)
		int token = 0; 
		for(int i = 0, j; i < trajectory.size();) {
			j = i +1;
			token = 0;
			for(; j < trajectory.size(); j++) {
				double dist = distance(trajectory.get(i).longitude,trajectory.get(i).latitude,trajectory.get(j).longitude,trajectory.get(j).latitude);
				if(dist > profile.distance)
				{
					if(j-i==1)
						break;
						
					System.out.println("Dist > 1!!!!!!!!!!"+dist+" "+i+" "+j);
					System.out.println(trajectory.get(i).longitude+" "+trajectory.get(i).latitude);
					System.out.println(trajectory.get(j).longitude+" "+trajectory.get(j).latitude);
					double averageLon = 0;
					double averageLat = 0;
					double speed = 0;
					for(int k = i; k < j;k++) {
						averageLon += trajectory.get(k).longitude;
						averageLat += trajectory.get(k).latitude;
						if(trajectory.get(k).speed > speed)
							speed = trajectory.get(k).speed;
					}
					
					int counter = (j-i);
					System.out.println(counter);
					averageLon /= counter;
					averageLat /= counter;
				
					GPSData point = new GPSData();
					point.longitude = averageLon;
					point.latitude = averageLat;
					point.timestamp = trajectory.get(i).timestamp;
					point.speed = speed;
					stayPointSet.add(point);
					
					i=j;
					token = 1;
					break;
				}
				else if(j == trajectory.size()-1)
				{
					System.out.println(i+" "+j+"!!!!!!!!!!!total in distance");
					System.out.println(dist+" "+i+" "+j);
					double averageLon = 0;
					double averageLat = 0;
					double speed = 0;
					for(int k = i; k < trajectory.size();k++) {
						averageLon += trajectory.get(k).longitude;
						averageLat += trajectory.get(k).latitude;
						if(trajectory.get(k).speed > speed)
							speed = trajectory.get(k).speed;
					}
					int counter = (j-i)+1;
					System.out.println(counter);
					averageLon /= counter;
					averageLat /= counter;
				
					GPSData point = new GPSData();
					point.longitude = averageLon;
					point.latitude = averageLat;
					point.timestamp = trajectory.get(i).timestamp;
					point.speed = speed;
					stayPointSet.add(point);
					
					i=j+1;
					token = 1;
					break;
				}
			}
			if(token != 1)
				i=i+1;
			
		}
		return;
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
                	this.getAccelData(accel, version);
                if(gps.size() > 0)
            	{
                	noGPS = 0;
                	long startTime = System.currentTimeMillis();
                	this.getGpsData(gps, Profile.clusters, profile, fileNo);
                	long stopTime = System.currentTimeMillis();
                    elapsedTime += stopTime - startTime;
            	}
            };
            
            
            long startTime = System.currentTimeMillis();
	        if(noGPS == 0)
	        {
	        	System.out.println("Has GPS points!!!: "+activity);
	        	//if(!activity.equals("Transportation"))
	        		profile.gpsTotal++;
            	int index = -1, maxValue = 0;
	            for(int i = 0; i < 6; i++) {
	            	if(Profile.locationScore[fileNo][i] > maxValue)
	            	{
	            		index = i;
	            		maxValue = Profile.locationScore[fileNo][i];
	            	}
	            }
	            //System.out.println("!!!"+profile.locationScore[fileNo][0]+profile.locationScore[fileNo][1]+profile.locationScore[fileNo][2]+profile.locationScore[fileNo][3]+profile.locationScore[fileNo][4]+profile.locationScore[fileNo][5]);
	            
	            if(index != -1)
	            {
	            	if(activity.equals("Sporting") && index == 4)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//Profile.sportingGPSNoHit++;
		            }
		            else if(activity.equals("Transportation") && index == 2)
		            {
		            	profile.correct++;
		            	
		            	profile.gpsHit++;
		            	//Profile.transportationGPSNoHit++;
		            }
		            else if(activity.equals("Dining") && index == 1)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//profile.diningGPSNoHit++;
		            }
		            else if(activity.equals("Working") && index == 0)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//Profile.workingGPSNoHit++;
		            }
		            else if(activity.equals("Shopping") && index == 5)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            }
		            else if(activity.equals("Entertainment") && index == 3)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            }
	            }
	            
	            if(index == -1)
	        	{
	            	// 現在沒用public opinion
	        		//Map<String, Integer> regionCategory = new HashMap<String, Integer>();
	        		//HttpRequest httpRequest = new HttpRequest();	        		
	        		//Parameter parameter = new Parameter();
	        		//regionCategory = httpRequest.sendGet(startY,startX,parameter.radius*1000);
	        		
	        		if(Profile.tTimeDistribution.get(startHour) != null)
	        			Profile.locationScore[fileNo][2] = Profile.tTimeDistribution.get(startHour);
	        		if(Profile.dTimeDistribution.get(startHour) != null)
	        			Profile.locationScore[fileNo][1] = Profile.dTimeDistribution.get(startHour);
	        		if(Profile.wTimeDistribution.get(startHour) != null)
	        			Profile.locationScore[fileNo][0] = Profile.wTimeDistribution.get(startHour);       		
	        		if(Profile.shTimeDistribution.get(startHour) != null)
	        			Profile.locationScore[fileNo][5] = Profile.shTimeDistribution.get(startHour);
	        		if(Profile.spTimeDistribution.get(startHour) != null)
	        			Profile.locationScore[fileNo][4] = Profile.spTimeDistribution.get(startHour);
	        		if(Profile.eTimeDistribution.get(startHour) != null)
	        			Profile.locationScore[fileNo][3] = Profile.eTimeDistribution.get(startHour);
	        	
	        
	        		System.out.println("!!!"+Profile.locationScore[fileNo][0]+Profile.locationScore[fileNo][1]+Profile.locationScore[fileNo][2]+Profile.locationScore[fileNo][3]+Profile.locationScore[fileNo][4]+Profile.locationScore[fileNo][5]);
		            int max = 0, inferenceActivity = -1; 
		            for(int i = 0; i < 6; i++) {
		            	if(Profile.locationScore[fileNo][i] > max)
		            	{
		            		inferenceActivity = i;
		            		max = Profile.locationScore[fileNo][i];
		            	}
		            }
		            
		            if(activity.equals("Sporting") && inferenceActivity == 4)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//profile.sportingGPSNoHit++;
		            }
		            else if(activity.equals("Transportation") && inferenceActivity == 2)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//Profile.transportationGPSNoHit++;
		            }
		            else if(activity.equals("Dining") && inferenceActivity == 1)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//profile.diningGPSNoHit++;
		            }
		            else if(activity.equals("Working") && inferenceActivity == 0)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//Profile.workingGPSNoHit++;
		            }
		            else if(activity.equals("Shopping") && inferenceActivity == 5)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//Profile.shoppingGPSNoHit++;
		            }
		            else if(activity.equals("Entertainment") && inferenceActivity == 3)
		            {
		            	profile.correct++;
		            	profile.gpsHit++;
		            	//Profile.entertainmentHit++;
		            }
		            else
		            {
//		            	if(activity.equals("Transportation"))
//		            		Profile.transportationGPSNoHit++;
//		            	if(activity.equals("Entertainment"))
//		            			Profile.entertainmentHit++;
//		            	if(activity.equals("Shopping"))
//		            			Profile.shoppingGPSNoHit++;
//		            	if(activity.equals("Working"))
//		            		Profile.workingGPSNoHit++;
//		            	if(activity.equals("Sporting"))
//		            		profile.sportingGPSNoHit++;
//		            	if(activity.equals("Dining"))
//		            		profile.diningGPSNoHit++;
		            }
	        	} 
	        }
	        else
        	{
	        	startHour = Integer.valueOf(time);
//	        	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//	        	System.out.println(profile.tTimeDistribution.get(startHour));
//	        	System.out.println(profile.dTimeDistribution.get(startHour));
//	        	System.out.println(profile.wTimeDistribution.get(startHour));
//	        	System.out.println(profile.spTimeDistribution.get(startHour));
//	        	System.out.println(profile.shTimeDistribution.get(startHour));
//	        	System.out.println(profile.eTimeDistribution.get(startHour));
        		//Map<String, Integer> regionCategory = new HashMap<String, Integer>();
        		//HttpRequest httpRequest = new HttpRequest();
        		
        		Parameter parameter = new Parameter();
        		// 目前沒用foursquare
        		//regionCategory = httpRequest.sendGet(startY,startX,parameter.radius*1000);
        		
        		if(Profile.tTimeDistribution.get(startHour) != null)
        			Profile.locationScore[fileNo][2] = Profile.tTimeDistribution.get(startHour);
        		if(Profile.dTimeDistribution.get(startHour) != null)
        			Profile.locationScore[fileNo][1] = Profile.dTimeDistribution.get(startHour);
        		if(Profile.wTimeDistribution.get(startHour) != null)
        			Profile.locationScore[fileNo][0] = Profile.wTimeDistribution.get(startHour);       		
        		if(Profile.shTimeDistribution.get(startHour) != null)
        			Profile.locationScore[fileNo][5] = Profile.shTimeDistribution.get(startHour);
        		if(Profile.spTimeDistribution.get(startHour) != null)
        			Profile.locationScore[fileNo][4] = Profile.spTimeDistribution.get(startHour);
        		if(Profile.eTimeDistribution.get(startHour) != null)
        			Profile.locationScore[fileNo][3] = Profile.eTimeDistribution.get(startHour);
        	}
            
            
            double force = (average/counter); //針對每一個file所產生的平均加速度值
            double std = Math.sqrt((power/counter) - Math.pow(force,2)); //針對每一個file所產生的加速度值標準差
            System.out.println(activity+" "+std);
            int max = 0;
            int index = -1;
            for(int i = 0; i < 6; i++) {
            	System.out.print(Profile.weightedTable[(int)(std*10)][i]+ " ");
            	//下一行把留就好 其他刪掉
            	Profile.distributionMatrixScore[fileNo][i] = Profile.weightedTable[(int)(std*10)][i];
            	if(Profile.weightedTable[(int)(std*10)][i] > max)
            	{
            		max = Profile.weightedTable[(int)(std*10)][i];
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
		        		Profile.locationScore[fileNo][2] = clusters.get(j).transportation.get(hourOfDay);
		        	if(clusters.get(j).working.containsKey(hourOfDay))
		        		Profile.locationScore[fileNo][0] = clusters.get(j).working.get(hourOfDay);
		        	if(clusters.get(j).dining.containsKey(hourOfDay))
		        		Profile.locationScore[fileNo][1] = clusters.get(j).dining.get(hourOfDay);
		        	if(clusters.get(j).sporting.size() > 0)	
		        		Profile.locationScore[fileNo][4] = clusters.get(j).sporting.get(hourOfDay);
		        	if(clusters.get(j).shopping.size() > 0)	
		        		Profile.locationScore[fileNo][5] = clusters.get(j).shopping.get(hourOfDay);
		        	if(clusters.get(j).entertainment.size() > 0)	
		        		Profile.locationScore[fileNo][3] = clusters.get(j).entertainment.get(hourOfDay);
		        	
		    		

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
	
	 
	 public void InitializeSoftware(Reader reader, Map apps, Map inTheSameFile, int indexFile, Distribution distribution, long elapsedTime) throws Exception {
	        
			Parameter parameter = new Parameter();
			JSONParser jsonParser = new JSONParser();
	        JSONArray arr = (JSONArray) jsonParser.parse(reader);
	        Iterator iterator = arr.iterator();
	        String label = null;
	       
	        int app2 = 0;
	        int counterUnit = 0;
	        while (iterator.hasNext()) {
	        	counterUnit++;
	            JSONObject parse = (JSONObject) iterator.next();
	            JSONArray app = (JSONArray) parse.get("App");
	            
	            if(parse.get("lifelabel") == null)
	            	label = parse.get("lifelable").toString();
	            else
	            	label = parse.get("lifelabel").toString();
	            	
	            app2 = app.size();

	            long startTime = System.currentTimeMillis();
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
	            }
	            long stopTime = System.currentTimeMillis();
	            elapsedTime += stopTime - startTime;
	        }
	        System.out.println(label);
	        if(label.equals("Sporting"))
	        	distribution.activityDistribution[5]++;
	        else if(label.equals("Transportation"))
	        	distribution.activityDistribution[0]++;
	        else if(label.equals("Dining"))
	        	distribution.activityDistribution[3]++;
	        else if(label.equals("Working"))
	        	distribution.activityDistribution[1]++;
	        else if(label.equals("Shopping"))
	        	distribution.activityDistribution[4]++;
	        else if(label.equals("Entertainment"))
	        	distribution.activityDistribution[2]++;
	        else
	        	;
	        return;
	    }
}
