package AIM;

import java.io.FileReader;
import java.io.Reader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class SoftwarePhase {

	
	public void testing(String fileName, Profile profile, Distribution distribution, int fileNo, long elapsedTime) throws Exception {
		
		Reader reader = new FileReader(fileName);
		JSONParser jsonParser = new JSONParser();
        JSONArray arr = (JSONArray) jsonParser.parse(reader);
        Iterator iterator = arr.iterator();
        
        Map sportingScore =  new Hashtable();
    	Map workingScore =  new Hashtable();
    	Map transportationScore =  new Hashtable();
    	Map diningScore =  new Hashtable();
    	Map entertainmentScore =  new Hashtable();
    	Map shoppingScore =  new Hashtable();
    	String activity = null;
    	
        while (iterator.hasNext()) {
            JSONObject parse = (JSONObject) iterator.next();
            
            String timestamp = parse.get("time").toString();
            timestamp = timestamp.substring(0, timestamp.length()-3);
            
            JSONArray app = (JSONArray) parse.get("App");
            if(parse.get("lifelabel") == null)
            	activity = parse.get("lifelable").toString();
            else
            	activity = parse.get("lifelabel").toString();
            
            
            // version 2 time is unix time
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < app.size(); i++) {
                JSONObject obj = (JSONObject) app.get(i);
                String name = obj.get("name").toString();
                for(int j = 0; j < profile.topk; j++) {
                	//System.out.println(profile.diningApp[j]);
                	if(profile.workingApp[j].equals(name))
	                {
	                		// 該package name還會被計算過得分
	                	if(workingScore.get(name) == null)
	                		//workingScore.put(name, profile.topk-j);
	                		workingScore.put(name, 1);
	                }
	                if(profile.sportingApp[j].equals(name))
	                {
	                	if(sportingScore.get(name) == null)	
	                		//sportingScore.put(name, profile.topk-j);
	                		sportingScore.put(name, 1);
	                }
	                if(profile.transportationApp[j].equals(name))
	                {
	                	if(transportationScore.get(name) == null)
	                		//transportationScore.put(name, profile.topk-j);
	                		transportationScore.put(name, 1);

	                }
	                if(profile.diningApp[j].equals(name))
	                {
	                	if(diningScore.get(name) == null)
	                		//diningScore.put(name, profile.topk-j);
	                		diningScore.put(name, 1);

	                }
	                if(profile.entertainmentApp[j].equals(name))
	                {
	                	if(entertainmentScore.get(name) == null)
	                		//entertainmentScore.put(name, profile.topk-j);
	                		entertainmentScore.put(name, 1);
	                }
	                if(profile.shoppingApp[j].equals(name))
	                {
	                	if(shoppingScore.get(name) == null)
	                		//shoppingScore.put(name, profile.topk-j);
	                		shoppingScore.put(name, 1);
	                }
                }  
            }
            long stopTime = System.currentTimeMillis();
            elapsedTime += stopTime - startTime;
        }
        profile.lable[fileNo] = activity;
        
        /* 開始計算各activity的得分，array內activity的順序按照SAIM model */
        long startTime = System.currentTimeMillis();
        int scoreArray[] = new int[6];
        for(int i = 0; i < scoreArray.length; i++) {
        	scoreArray[i] = 0;
        }
        
        Iterator it = transportationScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[2] += (int)pairs.getValue();
        }

        it = workingScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[0] += (int)pairs.getValue();
        }
        
        
        it = entertainmentScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[3] += (int)pairs.getValue();
        }
        

        it = diningScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[1] += (int)pairs.getValue();
        }
        
        int shScore = 0;
        it = shoppingScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[5] += (int)pairs.getValue();
        }
        
        int spScore = 0;
        it = sportingScore.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            scoreArray[4] += (int)pairs.getValue();
        }
        
        for(int i = 0; i < 6; i++)
        	profile.softwareScore[fileNo][i] =  scoreArray[i];
        	
        System.out.print("Label: "+activity+" ");
        long stopTime = System.currentTimeMillis();
        elapsedTime += stopTime - startTime;
        
        
        //這裡以下要刪掉 最後inference的地方用
        
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
        	
        
        if(activity.equals("Sporting"))
        {
        	distribution.sportingCounter++;
        	if(maxValueIndex == 4)
        	{
        		distribution.sportingHit++;
        		System.out.println("Sporting");
        	}
        		
        }
        else if(activity.equals("Working"))
        {
        	distribution.workingCounter++;
        	if(maxValueIndex == 0)
        	{
        		distribution.workingHit++;
        		System.out.println("Working");
        	}
        		
        }
        else if(activity.equals("Dining"))
        {
        	distribution.diningCounter++;
        	if(maxValueIndex == 1)
        	{
        		distribution.diningHit++;
        		System.out.println("Dining");
        	}
        		
        }
        else if(activity.equals("Transportation"))
        {
        	distribution.transportationCounter++;
        	if(maxValueIndex == 2)
        	{
        		distribution.transportationHit++;
        		System.out.println("Transportation");
        	}
       
        }
        else if(activity.equals("Entertainment"))
        {
        	distribution.entertainmentCounter++;
        	if(maxValueIndex == 3)
        	{
        		distribution.entertainmentHit++;
        		System.out.println("Entertainment");
        	}
        }
        	
        else if(activity.equals("Shopping"))
        {
        	distribution.shoppingCounter++;
        	if(maxValueIndex == 5)
        	{
        		distribution.shoppingHit++;
        		System.out.println("Shopping");
        	}	
        }	
	}
}
