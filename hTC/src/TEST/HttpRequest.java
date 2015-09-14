package TEST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HttpRequest {
	private final String USER_AGENT = "Mozilla/5.0";
	
	public HttpRequest()
	{}
	
	public Map<String, Integer> sendGet(double latitude, double longitude, double radius) throws Exception {
		Map<String, Integer> regionCategory = new HashMap<String, Integer>();
		//String url = "https://play.google.com/store/apps/details?id=com.coliferlab.picasatool.lictwo";
		String ll = String.valueOf(latitude)+","+String.valueOf(longitude);
		String str_radius = String.valueOf(radius);
		String url = "https://api.foursquare.com/v2/venues/search?client_id=ZLJUHSBPWYIQ1H33VLAL10YMF1AZJCIHH4ZQNBZGQBJJZ3MA&client_secret=F5GVS1KB3JMZV2MERIX0HKOTH5E4OFZXZYZ54SUHBCUQ0UFB&ll="+ll+"&v=20140806%20&m=foursquare&intent=browse&radius="+str_radius;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		//System.out.println("\nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);
		
		// app not found on google play
		if(responseCode == 404)
			return regionCategory;
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream(), "utf-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine+"\n");
		}
		in.close();
 
		
		JSONParser jsonParser = new JSONParser();
        JSONObject parse =  (JSONObject) jsonParser.parse(response.toString());
        
        int iteratorCounter = 0;
        
    
        JSONObject responseFS = (JSONObject) parse.get("response");
        JSONArray venues = (JSONArray) responseFS.get("venues");
       
        // 一個範圍內有很多category
        for (int i = 0; i < venues.size(); i++) {
            JSONObject object = (JSONObject) venues.get(i);
            JSONArray category = (JSONArray) object.get("categories");
            JSONObject object2 = (JSONObject) category.get(0);
            String name = object2.get("id").toString();
            AreaCategory areaCategory = new AreaCategory();
            int value = 0;
            //System.out.println(object.get("name").toString()+" "+areaCategory.categorySearch(name));
            if(regionCategory.containsKey(areaCategory.categorySearch(name)))
            {
            	value = regionCategory.get(areaCategory.categorySearch(name));
            	regionCategory.put(areaCategory.categorySearch(name), value+1);
            }
            else
            {
            	regionCategory.put(areaCategory.categorySearch(name),1);
            }
            	
        }

		return regionCategory;
	}
}
