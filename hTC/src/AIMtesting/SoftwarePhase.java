package AIMtesting;

import java.io.FileReader;
import java.io.Reader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class SoftwarePhase {

	
	public void testing(String fileName, Profile profile, int fileNo, long elapsedTime) throws Exception {
		
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
        /* activity of testing data */
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
        	
        System.out.print("Label: "+activity+"\n");
        long stopTime = System.currentTimeMillis();
        elapsedTime += stopTime - startTime;
        
        
	}
}
