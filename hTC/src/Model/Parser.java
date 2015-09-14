/*

	app的分數如果都一樣則預設猜transportation(293~299 第一個是transportation，score比他大才會被assign別的activity)
	
*/

package Model;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import parser.HttpRequest;

public class Parser {
	
	private int counter;
	private double average;
	private double power; // for 標準差
	private double max;
	private double min;
	
	public Parser()
	{
		counter = 0;
		average = 0;
		power = 0;
		max = 0;
		min = 100;
		
	}
	
	public void InitializeSoftware(Reader reader, AppUsage appUsage, CategoryUsage categoryUsage, Distribution distribution, Parameter parameter) throws Exception {
		
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        Iterator iterator = arr.iterator();
        
        Map sportingScore =  new Hashtable();
    	Map workingScore =  new Hashtable();
    	Map transportationScore =  new Hashtable();
    	Map diningScore =  new Hashtable();
    	Map entertainmentScore =  new Hashtable();
    	Map shoppingScore =  new Hashtable();
    	String label2 = null;
    	
        while (iterator.hasNext()) {
            JSONObject parse = (JSONObject) iterator.next();
            
            String timestamp = parse.get("time").toString();
            timestamp = timestamp.substring(0, timestamp.length()-3);
            
            JSONArray app = (JSONArray) parse.get("App");
            String label = parse.get("lifelable").toString();
            label2 = label;
            
            
            	
            // version 2 time is unix time
            


            for (int i = 0; i < app.size(); i++) {
                JSONObject obj = (JSONObject) app.get(i);
                String name;
                if(parameter.category == 0)
                	name = obj.get("name").toString();
                else
                {	
                	if(categoryUsage.mapping.containsKey(obj.get("name").toString()))
                	{
                		name = categoryUsage.mapping.get(obj.get("name").toString());
                	}
                	else
                	{
                		HttpRequest httpRequest = new HttpRequest();
                		name = httpRequest.sendGet(obj.get("name").toString());
                		categoryUsage.mapping.put(obj.get("name").toString(), name);
                	}
                	//System.out.println(name);
                }
                	
                if(parameter.category == 0)
                {     
	                for(int j = 0; j < appUsage.topK; j++) {
	                	if(appUsage.workingApp[j].equals(name))
	                	{
	                		// 該package name還會被計算過得分
	                		if(workingScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				workingScore.put(name,1);
	                			else
	                				workingScore.put(name, appUsage.topK-j);
	                		}
	                	}
	                	if(appUsage.sportingApp[j].equals(name))
	                	{
	                		if(sportingScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				sportingScore.put(name, 1);
	                			else
	                				sportingScore.put(name, appUsage.topK-j);
	                		}	
	                	}
	                	if(appUsage.transportationApp[j].equals(name))
	                	{
	                		if(transportationScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				transportationScore.put(name, 1);
	                			else
	                				transportationScore.put(name, appUsage.topK-j);
	                		}
	                	}
	                	if(appUsage.diningApp[j].equals(name))
	                	{
	                		if(diningScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				diningScore.put(name, 1);
	                			else
	                				diningScore.put(name, appUsage.topK-j);
	                		}
	                	}
	                	if(appUsage.entertainmentApp[j].equals(name))
	                	{
	                		if(entertainmentScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				entertainmentScore.put(name, 1);
	                			else
	                				entertainmentScore.put(name, appUsage.topK-j);
	                		}
	                	}
	                	if(appUsage.shoppingApp[j].equals(name))
	                	{
	                		if(shoppingScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				shoppingScore.put(name, 1);
	                			else
	                				shoppingScore.put(name, appUsage.topK-j);
	                		}
	                	}
	                } 
                }
                
                else
                {
                	
                	for(int j = 0; j < categoryUsage.topK; j++) {
	                	if(categoryUsage.workingApp[j].equals(name))
	                	{
	                		// 該package name還會被計算過得分
	                		if(workingScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				workingScore.put(name,1);
	                			else
	                				workingScore.put(name, categoryUsage.topK-j);
	                		}
	                	}
	                	if(categoryUsage.sportingApp[j].equals(name))
	                	{
	                		if(sportingScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				sportingScore.put(name, 1);
	                			else
	                				sportingScore.put(name, categoryUsage.topK-j);
	                		}	
	                	}
	                	if(categoryUsage.transportationApp[j].equals(name))
	                	{
	                		if(transportationScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				transportationScore.put(name, 1);
	                			else
	                				transportationScore.put(name, categoryUsage.topK-j);
	                		}
	                	}
	                	if(categoryUsage.diningApp[j].equals(name))
	                	{
	                		if(diningScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				diningScore.put(name, 1);
	                			else
	                				diningScore.put(name, categoryUsage.topK-j);
	                		}
	                	}
	                	if(categoryUsage.entertainmentApp[j].equals(name))
	                	{
	                		if(entertainmentScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				entertainmentScore.put(name, 1);
	                			else
	                				entertainmentScore.put(name, categoryUsage.topK-j);
	                		}
	                	}
	                	if(categoryUsage.shoppingApp[j].equals(name))
	                	{
	                		if(shoppingScore.get(name) == null)
	                		{
	                			if(parameter.G_W == 1)
	                				shoppingScore.put(name, 1);
	                			else
	                				shoppingScore.put(name, categoryUsage.topK-j);
	                		}
	                	}
	                }
                	
                	
                	
                }
                
                
            }
        }
        
        /* 開始計算各activity的得分，array內activity的順序按照SAIM model */
        int scoreArray[] = new int[6];
        for(int i = 0; i < scoreArray.length; i++) {
        	scoreArray[i] = 0;
        }
        
        
        Iterator it = transportationScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[0] += (int)pairs.getValue();
        }
        
   
        it = workingScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[1] += (int)pairs.getValue();
        }
        
        
        it = entertainmentScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[2] += (int)pairs.getValue();
        }
        

        it = diningScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[3] += (int)pairs.getValue();
        }
        
        int shScore = 0;
        it = shoppingScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[4] += (int)pairs.getValue();
        }
        
        int spScore = 0;
        it = sportingScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[5] += (int)pairs.getValue();
        }
        

        System.out.print("Label: "+label2+" ");
        
        int maxValueIndex = -1;
        int maxValue = 0;
        for(int i = 0; i < scoreArray.length ;i++) {
        	if(scoreArray[i] > maxValue)
        	{
        		maxValueIndex = i;
        		maxValue = scoreArray[i];
        	}
        }
        System.out.println(scoreArray[0]+" "+scoreArray[1]+" "+scoreArray[2]+" "+scoreArray[3]+" "+scoreArray[4]+" "+scoreArray[5]+" ");
        
        if(maxValueIndex == -1)
        {
        	distribution.unknow++;
        	//System.out.println(scoreArray[1]+" "+scoreArray[0]+" "+scoreArray[3]);
        }
        	
        
        if(label2.equals("Sporting"))
        {
        	distribution.sportingCounter++;
        	if(maxValueIndex == 5)
        	{
        		distribution.sportingHit++;
        		System.out.println("Sporting");
        	}
        		
        }
        else if(label2.equals("Working"))
        {
        	distribution.workingCounter++;
        	if(maxValueIndex == 1)
        	{
        		distribution.workingHit++;
        		System.out.println("Working");
        	}
        		
        }
        else if(label2.equals("Dining"))
        {
        	distribution.diningCounter++;
        	if(maxValueIndex == 3)
        	{
        		distribution.diningHit++;
        		System.out.println("Dining");
        	}
        		
        }
        else if(label2.equals("Transportation"))
        {
        	distribution.transportationCounter++;
        	if(maxValueIndex == 0)
        	{
        		distribution.transportationHit++;
        		System.out.println("Transportation");
        	}
       
        }
        else if(label2.equals("Entertainment"))
        {
        	distribution.entertainmentCounter++;
        	if(maxValueIndex == 2)
        	{
        		distribution.entertainmentHit++;
        		System.out.println("Entertainment");
        	}
        }
        	
        else if(label2.equals("Shopping"))
        {
        	distribution.shoppingCounter++;
        	if(maxValueIndex == 4)
        	{
        		distribution.shoppingHit++;
        		//System.out.println("Shopping");
        	}
        		
        }
        	
	}
	
	public void InitializeHardware(String filename, Confusion confusionMatrix, double ssh, String version,Distribution distribution)
    {
        try
        {
        	InitializeHardware(new FileReader(filename), confusionMatrix, ssh, version,distribution);
        }
        catch(Exception e)
        {
            System.err.println(filename+ " is broken !");
        }
    }
	
	public void InitializeHardware(Reader reader, Confusion confusionMatrix, double ssh, String version,Distribution distribution) throws IOException, ParseException
	{
		
		//System.out.println("processing");
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        String activity = null;
        Iterator iterator =arr.iterator();
        int iteratorCounter = 0;
        
        while (iterator.hasNext()) {
        	JSONObject parse = (JSONObject) iterator.next();
            JSONArray magne = (JSONArray) parse.get("Magne");
            JSONArray gyro = (JSONArray) parse.get("Gyro");
            JSONArray accel = (JSONArray) parse.get("Accel");
            String lifelable = (String) parse.get("lifelable");
            JSONArray proxymity = (JSONArray) parse.get("Proximity");
            JSONArray light = (JSONArray) parse.get("Light");
            JSONArray gps = (JSONArray) parse.get("GPS");
            JSONArray pressure = (JSONArray) parse.get("Pressure");
            String time = (String) parse.get("time");
            activity = lifelable;
            
            
            if(accel.size() > 0)
            	this.getAccelData(accel, version);
            if(gps.size() > 0)
        	{
            	distribution.gpsPoint += gps.size();
            	
        	}
            iteratorCounter++;
        }
        if(activity.equals("Shopping"))
        	distribution.shoppingCounter++;
        else if(activity.equals("Working"))
        	distribution.workingCounter++;
        else if(activity.equals("Sporting"))
        	distribution.sportingCounter++;
        else if(activity.equals("Dining"))
        	distribution.diningCounter++;
        else if(activity.equals("Transportation"))
        	distribution.transportationCounter++;
        else if(activity.equals("Entertainment"))
        	distribution.entertainmentCounter++;
        //System.out.println(iteratorCounter);
        double force = (average/counter); //針對每一個file所產生的平均加速度值
        double std = Math.sqrt((power/counter) - Math.pow(force,2)); //針對每一個file所產生的加速度值標準差
        System.out.println(max+","+std+","+activity);
        
        //System.out.println(activity);
//        System.out.println("MAX: "+ max);
//        System.out.println("AVG: "+ force+" "+average+" "+counter);
//        System.out.println("MIN: "+ min);
//        System.out.println("STD: "+ std);
        int guess = 0;
        // std > 1 is a threshold
        if(std > ssh)
        {
        	guess = 1;
        	
        }
         //max accel value > threshold is a threshold
//        if(max > ssh)
//        {
//        	guess = 1;
//        	
//        }
        	
//        if(activity.equals("Sporting") || activity.equals("Transportation") || activity.equals("Shopping"))
//        {
//        	confusionMatrix.P++;
//        	if(guess == 1)
//        		confusionMatrix.tp++;
//        	else
//        		confusionMatrix.fn++;
//        }
//        else if(activity.equals("Working") || activity.equals("Dining"))
//        {
//        	confusionMatrix.N++;
//        	if(guess == 1)
//        		confusionMatrix.fp++;
//        	else
//        		confusionMatrix.tn++;
//        }
//        else
//        	;
        

        if(activity.equals("Sporting"))
        {
        	confusionMatrix.P++;
        	if(guess == 1)
        		confusionMatrix.tp++;
        	else
        		confusionMatrix.fn++;
        }
        else
        {
        	confusionMatrix.N++;
        	if(guess == 1)
        		confusionMatrix.fp++;
        	else
        		confusionMatrix.tn++;
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
}
