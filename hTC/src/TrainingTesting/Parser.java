package TrainingTesting;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Confusion;

public class Parser {
	
	int JSON_UNIT = 0;
	List<Integer> trainingIndex = new ArrayList<>();
	
	//採用隨機
	public void random(int range)
	{
		Random rd = new Random();   
	    Parameter parameter = new Parameter();
	    int numberOfTraining = (int) ((double)range * parameter.training);
	    System.out.println("Number of training data: " + numberOfTraining);
	    while(trainingIndex.size() < numberOfTraining) { //共產生幾個  
	    	int n = rd.nextInt(range); //產生0~range數字  
	        if(trainingIndex.contains(n))   
	        	continue;     //重複的不加入  
	        else  
	            trainingIndex.add(n);  
	        //System.out.println(n);
	    }  
	        
	    Collections.sort(trainingIndex);
	    Iterator<Integer> iterator = trainingIndex.iterator();
//	    while (iterator.hasNext()) {
//	    	System.out.println(iterator.next());
//	    }
		
	}
	
	// 採用5-fold cross validation
	public void crossValidation(int range)
	{
		Parameter parameter = new Parameter();
		System.out.println("Total Unit: "+range);
		int celling = (int)((double)range * parameter.crossValidationCelling);
		int floor = (int)((double)range * parameter.crossValidationFloor)+1;
		System.out.println(celling+" "+floor);
		
		// 其實是testing (line 119~122有換回來)
		for(int i = floor; i < celling; i++) {
			trainingIndex.add(i);  
		}
		if(floor == celling)
			trainingIndex.add(floor);
//		Iterator<Integer> iterator = trainingIndex.iterator();
//	    while (iterator.hasNext()) {
//	    	System.out.println(iterator.next());
//	    }
		
	}
	
	public void InitializeHardware(String hardwareFileName, String fileName)
    {
        try
        {
        	InitializeHardware(new FileReader(hardwareFileName), fileName);
        }
        catch(Exception e)
        {
            System.err.println("Hardware:" + hardwareFileName + " is broken !");
        }
    }
	
	
	public void InitializeHardware(Reader hardwareReader, String fileName) throws IOException, ParseException 
	{
		Parameter parameter = new Parameter();
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(hardwareReader);
        String activity = null;
        Iterator iterator = arr.iterator();
        int iteratorCounter = 0;
        
        JSON_UNIT = arr.size();
        System.out.println("JSON unit: "+arr.size());
        random(arr.size());
        //crossValidation(arr.size());
        JSONArray trainingMainArray = new JSONArray();
        JSONArray testingMainArray = new JSONArray();
        try{
	        while (iterator.hasNext()) {
	        	JSONObject parse = (JSONObject) iterator.next();
	            
	            JSONArray accel = (JSONArray) parse.get("Accel");
	            String lifelable = (String) parse.get("lifelabel");
	            JSONArray gps = (JSONArray) parse.get("GPS");
	            activity = lifelable;
	
	            JSONObject unitObj = new JSONObject();
	            unitObj.put("Accel", accel);
	            unitObj.put("GPS",gps);
	            unitObj.put("lifelabel", activity);
	            //random
	            if(trainingIndex.contains(iteratorCounter))
	            	trainingMainArray.add(unitObj);
	            else
	            	testingMainArray.add(unitObj);
	            // cross validation
//	            if(trainingIndex.contains(iteratorCounter))
//	            	testingMainArray.add(unitObj);
//	        	else
//	        		trainingMainArray.add(unitObj);
	            
	            iteratorCounter++;
	        }
	        System.out.println(parameter.HardwareTraining_path+fileName);
	        Writer writer = new FileWriter(parameter.HardwareTraining_path+fileName);
	        writer.write(trainingMainArray.toString());
	        writer.close();
	        
	        writer = new FileWriter(parameter.HardwareTesting_path+fileName);
	        writer.write(testingMainArray.toString());
	        writer.close();
        }
        catch(Exception e)
        {
        	System.err.println("????????????????????????????????????????");
        }
	}
	
	public void InitializeSoftware(String softwareFileName, String fileName)
    {
        try
        {
        	InitializeSoftware(new FileReader(softwareFileName), fileName);
        }
        catch(Exception e)
        {
            System.err.println("!Software:" + softwareFileName + " is broken !");
        }
    }
	
	public void InitializeSoftware(Reader softwareReader, String fileName) throws IOException, ParseException
	{
		Parameter parameter = new Parameter();
//		for(int i = 0; i< trainingIndex.size() ;i++)
//			System.out.println(trainingIndex.get(i));
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(softwareReader);
        Iterator iterator = arr.iterator();
        int iteratorCounter = 0;
        
        System.out.println(arr.size());
        
        JSONArray trainingMainArray = new JSONArray();
        JSONArray testingMainArray = new JSONArray();
        while (iterator.hasNext()) {
        	if(iteratorCounter == JSON_UNIT)
        		break;
        	
        	JSONObject parse = (JSONObject) iterator.next();
        	JSONArray app = (JSONArray) parse.get("App");
            String label = parse.get("lifelabel").toString();
            String time = parse.get("time").toString();
            
            JSONObject unitObj = new JSONObject();
            unitObj.put("lifelabel", label);
            unitObj.put("App", app);
            unitObj.put("time", time);
            //random
            if(trainingIndex.contains(iteratorCounter))
            	trainingMainArray.add(unitObj);
            else
            	testingMainArray.add(unitObj);
            
            //cross validation
//            if(trainingIndex.contains(iteratorCounter))
//            	testingMainArray.add(unitObj);
//            else
//            	trainingMainArray.add(unitObj);
            iteratorCounter++;
        }
        
        Writer writer = new FileWriter(parameter.SoftwareTraining_path+fileName);
        writer.write(trainingMainArray.toString());
        writer.close();
        
        writer = new FileWriter(parameter.SoftwareTesting_path+fileName);
        writer.write(testingMainArray.toString());
        writer.close();
	}
}
