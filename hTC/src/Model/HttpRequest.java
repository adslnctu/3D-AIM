package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
public class HttpRequest {

	private final String USER_AGENT = "Mozilla/5.0";
			
	public HttpRequest()
	{}
	
	public String sendGet(String packageName) throws Exception {
		 
		//String url = "https://play.google.com/store/apps/details?id=com.coliferlab.picasatool.lictwo";
		String url = "https://play.google.com/store/apps/details?id=" + packageName;
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
			return "Built-in";
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream(), "utf-8"));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine+"\n");
		}
		in.close();
 
		//print result
		String category = "<span itemprop=\"genre\">.+</span>";
		Pattern pattern = Pattern.compile(category);
	    Matcher matcher = pattern.matcher(response.toString());
	    boolean matchFound = matcher.find();
	    if(matchFound)
	    {
	    	String groupStr = matcher.group();
	    	int start = groupStr.indexOf('>') +  1;
	    	int end = groupStr.indexOf('<', start);
	    	//System.out.println(groupStr.substring(start, end)
	    	return groupStr.substring(start, end);
	    	//System.out.println(groupStr);
	    }
	       
	    return "Built-in";
		//System.out.println(response.toString());
 
	}
}
