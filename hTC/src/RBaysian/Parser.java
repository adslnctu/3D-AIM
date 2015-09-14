package RBaysian;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Parser {
	private int counter;
	private double average;
	private double power; // for 標準差
	private double max;
	private double min;
	private double centralY; 
	private double centralX; 
	private double speed;
	private int g_counter = 0; // for giving location score
	String minute, hour;
	
	public Parser()
	{
		speed = 0;
		counter = 0;
		average = 0;
		power = 0;
		max = 0;
		min = 100;
		
	}
	
	public void softwareStatisitcs(String fileName, Parameter parameter) throws IOException, ParseException
    {
		Reader reader = new FileReader(fileName);
		String activity = null;
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        Iterator iterator = arr.iterator();
        
		while (iterator.hasNext()) {
            JSONObject parse = (JSONObject) iterator.next();
            
            String timestamp = parse.get("time").toString();
            timestamp = timestamp.substring(0, timestamp.length()-3);
            
            JSONArray app = (JSONArray) parse.get("App");
            activity = parse.get("lifelable").toString();
            for (int i = 0; i < app.size(); i++) {
            	JSONObject obj = (JSONObject) app.get(i);
                String name = obj.get("name").toString();
                if(!parameter.appUsage.containsKey(name))
                	parameter.appUsage.put(name, 0);
            }
		}
    }
	
	public void softwareTraining(String fileName, Parameter parameter, int mode) throws IOException, ParseException
    {
		Reader reader = new FileReader(fileName);
		String activity = null;
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        Iterator iterator = arr.iterator();
        
		while (iterator.hasNext()) {
            JSONObject parse = (JSONObject) iterator.next();
            
            String timestamp = parse.get("time").toString();
            timestamp = timestamp.substring(0, timestamp.length()-3);
            
            JSONArray app = (JSONArray) parse.get("App");
            activity = parse.get("lifelable").toString();
            for (int i = 0; i < app.size(); i++) {
            	JSONObject obj = (JSONObject) app.get(i);
                String name = obj.get("name").toString();
                if(parameter.appUsage.get(name) == 0)
                	parameter.appUsage.put(name, 1);
            }
		}
    }
	
	public void hardware(String fileName, String version, int fileNo, Parameter parameter, int mode) throws FileNotFoundException
    {
		String data = null;
		Reader reader = new FileReader(fileName);
		String activity = null;
        try
        {
        	JSONParser jsonParser = new JSONParser();
            JSONArray arr = (JSONArray) jsonParser.parse(reader);
            
            Iterator iterator = arr.iterator();
            
            while (iterator.hasNext()) {
            	JSONObject parse = (JSONObject) iterator.next();
                JSONArray accel = (JSONArray) parse.get("Accel");
                activity = (String) parse.get("lifelable");
                JSONArray gps = (JSONArray) parse.get("GPS");

                if(accel.size() > 0)
                	this.getAccelData(accel, version);
                if(gps.size() > 0)
                	this.getGpsData(gps);
            }
        }
        catch(Exception e)
        {
        	
            System.err.println(fileName+ " is broken !");
        }
        
        
        /* build weighted table */
        double force = (average/counter); //針對每一個file所產生的平均加速度值
        double std = Math.sqrt((power/counter) - Math.pow(force,2)); //針對每一個file所產生的加速度值標準差
        centralY /= g_counter;
        centralX /= g_counter;
        centralY = Math.round(centralY*1000)/1000.0;	
        centralX = Math.round(centralX*1000)/1000.0;	
        System.out.println(activity+"\n"+std);
        if(g_counter != 0)
        	//System.out.println(centralX+" "+centralY);
        	;
        else
        {
        	//System.out.println("0 0");
        	centralX = 0;
        	centralY = 0;
        }
        	
        
        hour = fileName.substring(fileName.indexOf(" ")+1, fileName.indexOf("-",fileName.indexOf(" ")+1));
        minute = fileName.substring(fileName.indexOf(" ")+1, fileName.indexOf("_",fileName.indexOf(" ")+1));
        minute = minute.substring(minute.indexOf("-")+1, minute.indexOf("-",minute.indexOf("-")+1));
        //System.out.println(hour+" "+minute);
        //System.out.println(speed);
        
        if(activity.equals("Working"))
        	data = "1 ";
        else if(activity.equals("Dining"))
        	data = "2 ";
        else if(activity.equals("Transportation"))
        	data = "3 ";
        else if(activity.equals("Entertainment"))
        	data = "4 ";
        else if(activity.equals("Sporting"))
        	data = "5 ";
        else if(activity.equals("Shopping"))
        	data = "6 ";
        else
        	System.out.println("Error");
        
        
        if(parameter.format == 0)
        {
        	if(mode == 1)
        	{
        		if(centralX == 0 && centralY == 0)
            		parameter.outputTraining[fileNo] = activity + " " + String.valueOf(std) + " NA NA " + String.valueOf(hour) + " " + String.valueOf(minute)+ " " + String.valueOf(speed);

        		else
            		parameter.outputTraining[fileNo] = activity + " " + String.valueOf(std) + " " + String.valueOf(centralX) + " " + String.valueOf(centralY) + " " + String.valueOf(hour) + " " + String.valueOf(minute)+ " " + String.valueOf(speed);
        	}
        	else
        	{
        		if(centralX == 0 && centralY == 0)
        			parameter.outputTesting[fileNo] = activity + " " + String.valueOf(std) + " NA NA " + String.valueOf(hour) + " " + String.valueOf(minute)+ " " + String.valueOf(speed);

        		else
        			parameter.outputTesting[fileNo] = activity + " " + String.valueOf(std) + " " + String.valueOf(centralX) + " " + String.valueOf(centralY) + " " + String.valueOf(hour) + " " + String.valueOf(minute)+ " " + String.valueOf(speed);

        	}
        }
        else
        {
	        if(centralX == 0 && centralY == 0)
	        {
	        	if(fileNo == 381 || fileNo == 396)
	        		data += "4:" + String.valueOf(hour) + " 5:" + String.valueOf(minute) + " 6:" + String.valueOf(speed);
	        	else
	        		data += "1:" + String.valueOf(std) + " 4:" + String.valueOf(hour) + " 5:" + String.valueOf(minute) + " 6:" + String.valueOf(speed);
	        }
	        else
	        {
	        	if(fileNo == 381 || fileNo == 396)
	        		data += "2:" + String.valueOf(centralX) + " 3:" + String.valueOf(centralY) + " 4:" + String.valueOf(hour) + " 5:" + String.valueOf(minute) + " 6:" + String.valueOf(speed);
	        	else
	        		data += "1:" + String.valueOf(std) + " 2:" + String.valueOf(centralX) + " 3:" + String.valueOf(centralY) + " 4:" + String.valueOf(hour) + " 5:" + String.valueOf(minute) + " 6:" + String.valueOf(speed);
	        }
	        if(mode == 1)
	        	//parameter.outputTraining[fileNo] = data;
	        	parameter.motionDataTraining[fileNo] = data;
	        else
	        	//parameter.outputTesting[fileNo] = data;
	        	parameter.motionDataTesting[fileNo] = data;
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
	
	public void getGpsData(JSONArray array)
	 {
		 for (int i = 0; i < array.size(); i++) {
			 JSONObject obj = (JSONObject) array.get(i);
			 double x = Double.parseDouble(obj.get("X").toString());
			 double y = Double.parseDouble(obj.get("Y").toString());
			 double localSpeed = Double.parseDouble(obj.get("Speed").toString());
			 if(localSpeed > speed)
				 speed = localSpeed;
			 centralY += y;
			 centralX += x;
			 g_counter++;
			
		 }
	 }
}
