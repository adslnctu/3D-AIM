/****************
* 主要用training data來產生app list而已
*
*
****************/
package parser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//https://api.foursquare.com/v2/venues/search?client_id=ZLJUHSBPWYIQ1H33VLAL10YMF1AZJCIHH4ZQNBZGQBJJZ3MA&client_secret=F5GVS1KB3JMZV2MERIX0HKOTH5E4OFZXZYZ54SUHBCUQ0UFB&ll=24.78751366,120.99711781&v=20140806%20&m=foursquare&intent=browse&radius=30&categoryId=4d4b7105d754a06372d81259
public class main {

	public static void main(String[] args) throws Exception   {
		Runtime runtime = Runtime.getRuntime();
 	    // Run the garbage collector
 	    runtime.gc();
 	    // Calculate the used memory
 	    long memory = runtime.totalMemory() - runtime.freeMemory();
 	   System.out.println("[Training phase] Used memory is Mbytes: " + (double)memory/1048576);
	    System.out.println("start!\n");
	    // time distribution for location classifier
	    //TimeDistribution  timeDistribution = new TimeDistribution();
		
	    /* calculate TFIDF */
	    Map<String,Double>  spTFIDF = new HashMap<String,Double>(); // TDIDF for sporting
	    Map<String,Double> tTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> shTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> dTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> wTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    Map<String,Double> eTFIDF = new HashMap<String,Double>(); // TDIDF for 
	    double spTFDenominator = 0;
	    double tTFDenominator = 0;
	    double shTFDenominator = 0;
	    double dTFDenominator = 0;
	    double wTFDenominator = 0;
	    double eTFDenominator = 0;
	    
	    
	    /* calculate TF IDF */
	    
	    Map apps = new Hashtable(); // for app usage
	    Map inTheSameFile = new Hashtable(); //一個file內出現同一個app多次只計算一次
	    //Result result = new Result();
	    Parameter parameter = new Parameter();
	    Distribution appDistribution = new Distribution();
	    // http://jackytung8085.blogspot.tw/2013/10/java.html
	    File file = new File(parameter.FOLDERS[0]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
        ArrayList<String> fileList = new ArrayList<String>(); //宣告一的動態陣列為String的型態，目的用來儲存檔名
        int GPSPointCounter = 0;
        //FileWriter fw = new FileWriter("C:\\Users\\Lai\\Desktop\\cor.txt");

        
        
        
        if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
        {
        	System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
            String []s = file.list(); //宣告一個list
            System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
            for(int i=0; i < s.length; i++)
            {
                //System.out.println(s[i]);
                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡面
            }
        }
        
        
        //每一個檔案去parse
        
        for(int i = 0; i < fileList.size(); i++)
        {
        	
        	String fileName = parameter.FOLDERS[0] + "\\" + fileList.get(i);
	    	//String fileName = "D:\\STAIM\\input\\353567051351832\\h2013-11-14 15-00-45_353567051351832.txt";
        	System.out.println(i + ": "+fileName);
        	Parser parser = new Parser();
        	if(parameter.hard_or_soft == 0)
        		//parser.InitializeHardware(fileName, result, trajectory);
        		;
        	else if( parameter.hard_or_soft == 1)
        	{
//        		GPSPointCounter = 0;
//        		trajectory.clear();
//        		String activity = parser.InitializeHardware(fileName, result, trajectory);
//        		int hourOfDay = Integer.valueOf(fileName.substring(fileName.indexOf(" ")+1, fileName.indexOf(" ")+3));
//        		//System.out.println(fileName.substring(fileName.indexOf(" ")+1, fileName.indexOf(" ")+3));
//        		System.out.println(activity);
//        		if(activity.equals("Transportation"))
//    				{
//    					if(timeDistribution.tTimeDistribution.get(hourOfDay) != null)
//    						timeDistribution.tTimeDistribution.put(hourOfDay, timeDistribution.tTimeDistribution.get(hourOfDay)+1);
//    					else
//    						timeDistribution.tTimeDistribution.put(hourOfDay, 1);
//    				}
//    				else if(activity.equals("Working"))
//    				{
//    					if(timeDistribution.wTimeDistribution.get(hourOfDay) != null)
//    						timeDistribution.wTimeDistribution.put(hourOfDay, timeDistribution.wTimeDistribution.get(hourOfDay)+1);
//    					else
//    						timeDistribution.wTimeDistribution.put(hourOfDay, 1);
//    				}
//    				else if(activity.equals("Dining"))
//    				{
//    					if(timeDistribution.dTimeDistribution.get(hourOfDay) != null)
//    						timeDistribution.dTimeDistribution.put(hourOfDay, timeDistribution.dTimeDistribution.get(hourOfDay)+1);
//    					else
//    						timeDistribution.dTimeDistribution.put(hourOfDay, 1);
//    				}
//    				else if(activity.equals("Shopping"))
//    				{
//    					if(timeDistribution.shTimeDistribution.get(hourOfDay) != null)
//    						timeDistribution.shTimeDistribution.put(hourOfDay, timeDistribution.shTimeDistribution.get(hourOfDay)+1);
//    					else
//    						timeDistribution.shTimeDistribution.put(hourOfDay, 1);
//    				}
//    				else if(activity.equals("Sporting"))
//    				{
//    					if(timeDistribution.spTimeDistribution.get(hourOfDay) != null)
//    						timeDistribution.spTimeDistribution.put(hourOfDay, timeDistribution.spTimeDistribution.get(hourOfDay)+1);
//    					else
//    						timeDistribution.spTimeDistribution.put(hourOfDay, 1);
//    				}
//    				else if(activity.equals("Entertainment"))
//    				{
//    					if(timeDistribution.eTimeDistribution.get(hourOfDay) != null)
//    						timeDistribution.eTimeDistribution.put(hourOfDay, timeDistribution.eTimeDistribution.get(hourOfDay)+1);
//    					else
//    						timeDistribution.eTimeDistribution.put(hourOfDay, 1);
//    				}
//        		
//        		//System.out.println("GPS points: "+trajectory.size());
//        		for (int j=0; j<trajectory.size(); j++) {
//        			double[] gpsPoint={trajectory.get(j).latitude,trajectory.get(j).longitude};
//        			String timestamp = trajectory.get(j).timestamp;
//        			double speed = trajectory.get(j).speed;
//        			
//        			
//        			dpoints.add(new DataPoint(gpsPoint, String.valueOf(parameter.gpsPointsName), activity, timestamp, speed));
//        			parameter.gpsPointsName++;
//        			//if(!activity.equals("Transportation") && trajectory.get(j).speed > 30)
//        			//System.out.println(trajectory.get(j).latitude+","+trajectory.get(j).longitude+" "+trajectory.get(j).timestamp+" "+trajectory.get(j).speed);
//        			GPSPointCounter++;
//        			
////        			if(activity.equals("Sporting"))
////        				fw.write(trajectory.get(j).latitude+","+trajectory.get(j).longitude+",1");
////        			else if(activity.equals("Transportation"))
////        				fw.write(trajectory.get(j).latitude+","+trajectory.get(j).longitude+",2");
////        			else if(activity.equals("Dining"))
////        				fw.write(trajectory.get(j).latitude+","+trajectory.get(j).longitude+",3");
////        			else if(activity.equals("Working"))
////        				fw.write(trajectory.get(j).latitude+","+trajectory.get(j).longitude+",4");
////        			else if(activity.equals("Shopping"))
////        				fw.write(trajectory.get(j).latitude+","+trajectory.get(j).longitude+",5");
////        			else if(activity.equals("Entertainment"))
////        				fw.write(trajectory.get(j).latitude+","+trajectory.get(j).longitude+",6");
////
////        			fw.write("\n");
//        		}
//        		//System.out.println(GPSPointCounter);
//        		
//        		//System.in.read();
        	}
        	else
        	{
        		parser.InitializeSoftware(new FileReader(fileName), apps, inTheSameFile, i, appDistribution);
        		Iterator it = inTheSameFile.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pairs = (Map.Entry)it.next();
                    inTheSameFile.put(pairs.getKey(), 0);
                    //System.out.println(pairs.getKey() + " = " + pairs.getValue());
                    //it.remove(); // avoids a ConcurrentModificationException
                }
        	}
        		
    	    //System.out.println(result.counterSporting+" "+result.counterTransportation+" "+result.counterDining+" "+result.counterWorking+" "+result.counterShopping+" "+result.counterEntertainment+"\n");
        }

        //accelerometer value
        if(parameter.hard_or_soft == 0)
        {
//	        System.out.println();
//	        System.out.println(result.counterSporting);
//	        System.out.println("Sporting MAX: " + result.getMaxSporting());
//	        if(result.counterSporting == 0) System.out.println("Sporting AVG: 0");
//	        else System.out.println("Sporting AVG: " + (result.getAvgSporting()/result.counterSporting));
//	        System.out.println("Sporting MIN: " + result.getMinSporting());
//	        if(result.counterSporting == 0) System.out.println("Sporting STD: 0");
//	        else System.out.println("Sporting STD: " + (result.getStdSporting()/result.counterSporting));
//	        System.out.println();
//	        
//	        
//	        System.out.println(result.counterTransportation);
//	        System.out.println("Transportation MAX: " + result.getMaxTransportation());
//	        if(result.counterTransportation == 0) System.out.println("Transportation AVG: 0");
//	        else System.out.println("Transportation AVG: " + (result.getAvgTransportation()/result.counterTransportation));
//	        System.out.println("Transportation MIN: " + result.getMinTransportation());
//	        if(result.counterTransportation == 0) System.out.println("Transportation STD: 0");
//	        else System.out.println("Transportation STD: " + (result.getStdTransportation()/result.counterTransportation));
//	        System.out.println();
//	        
//	        System.out.println(result.counterDining);
//	        System.out.println("Dining MAX: " + result.getMaxDining());
//	        if(result.counterDining == 0) System.out.println("Dining AVG: 0");
//	        else System.out.println("Dining AVG: " + (result.getAvgDining()/result.counterDining));
//	        System.out.println("Dining MIN: " + result.getMinDining());
//	        if(result.counterDining == 0) System.out.println("Dining STD: 0");
//	        else System.out.println("Dining STD: " + (result.getStdDining()/result.counterDining));
//	        System.out.println();
//	        
//	        System.out.println(result.counterWorking);
//	        System.out.println("Working MAX: " + result.getMaxWorking());
//	        if(result.counterWorking == 0) System.out.println("Working AVG: 0");
//	        else System.out.println("Working AVG: " + (result.getAvgWorking()/result.counterWorking));
//	        System.out.println("Working MIN: " + result.getMinWorking());
//	        if(result.counterWorking == 0) System.out.println("Working STD: 0");
//	        else System.out.println("Working STD: " + (result.getStdWorking()/result.counterWorking));
//	        System.out.println();
//	        
//	        System.out.println(result.counterShopping);
//	        System.out.println("Shopping MAX: " + result.getMaxShopping());
//	        if(result.counterShopping == 0) System.out.println("Shopping AVG: 0");
//	        else System.out.println("Shopping AVG: " + (result.getAvgShopping()/result.counterShopping));
//	        System.out.println("Shopping MIN: " + result.getMinShopping());
//	        if(result.counterShopping == 0) System.out.println("Shopping STD: 0");
//	        else System.out.println("Shopping STD: " + (result.getStdShopping()/result.counterShopping));
//	        System.out.println();
//	        
//	        System.out.println(result.counterEntertainment);
//	        System.out.println("Entertainment MAX: " + result.getMaxEntertainment());
//	        if(result.counterEntertainment == 0) System.out.println("Entertainment AVG: 0");
//	        else System.out.println("Entertainment AVG: " + (result.getAvgEntertainment()/result.counterEntertainment));
//	        System.out.println("Entertainment MIN: " + result.getMinEntertainment());
//	        if(result.counterEntertainment == 0) System.out.println("Entertainment STD: 0");
//	        else System.out.println("Entertainment STD: " + (result.getStdEntertainment()/result.counterEntertainment));
//        
        }
        else if (parameter.hard_or_soft == -1)
        {
        	
        	int totalActivities = 0;
        	System.out.println("\n\n\n\n\nSporting: "+appDistribution.activityDistribution[5]);
        	System.out.println("Transportation: "+appDistribution.activityDistribution[0]);
        	System.out.println("Dining: "+appDistribution.activityDistribution[3]);
        	System.out.println("Working: "+appDistribution.activityDistribution[1]);
        	System.out.println("Shopping: "+appDistribution.activityDistribution[4]);
        	System.out.println("Entertainment: "+appDistribution.activityDistribution[2]);
        	for(int i = 0; i < 6; i++) {
        		if(appDistribution.activityDistribution[i] == 0)
        			appDistribution.activeActivities--;
        		
        		totalActivities += appDistribution.activityDistribution[i];
        	}
        	System.out.println(totalActivities);
        	
        	/* 計算TF的分母 */
        	for(int i = 0; i < appDistribution.counter; i++) {
        		spTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][5]);
        		
        	    shTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][4]);
        	    dTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][3]);
        	    wTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][1]);
        	    eTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][2]);
        	    tTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][0]);
        	} 	
        	System.out.println(spTFDenominator+" "+tTFDenominator+" "+shTFDenominator+" "+dTFDenominator+" "+wTFDenominator+" "+eTFDenominator+" ");
        	
        	int dtotal = 0;
        	
        	if(parameter.SVM_BAYES != 0)
        		System.out.println("PACKAGE,LABEL");
        	

        	for(int i = 0; i < appDistribution.counter; i++) {
        		//if(parameter.SVM_BAYES == 0)
        			//System.out.print(appDistribution.appDistribution[i][0][0]+"("+(int)apps.get(appDistribution.appDistribution[i][0][0])+"): ");
        		
        		System.out.print(appDistribution.appDistribution[i][0][0]+"("+(int)apps.get(appDistribution.appDistribution[i][0][0])+"): ");  		
     
        		// (app name, tfidf value)
        		
        		
        		if(parameter.category == 1)
        		{
        			for(int j = 0; j < 6; j++) {
            			
        				if(j == 0 && Integer.parseInt(appDistribution.appDistribution[i][1][0]) > 0)
            			{
        					System.out.print("[Transportation]");
            			}	
        				else if(j == 1 && Integer.parseInt(appDistribution.appDistribution[i][1][1]) > 0)
        				{
        					System.out.print("[Working]");
            			}
        				else if(j == 2 && Integer.parseInt(appDistribution.appDistribution[i][1][2]) > 0)
        				{
        					System.out.print("[Entertainment]");
            			}
        				else if(j == 3 && Integer.parseInt(appDistribution.appDistribution[i][1][3]) > 0)
        				{
        					System.out.print("[Dining]");
            			}
        				else if(j == 4 && Integer.parseInt(appDistribution.appDistribution[i][1][4]) > 0)
        				{
        					System.out.print("[Shopping]");
            			}
        				else if(j == 5 && Integer.parseInt(appDistribution.appDistribution[i][1][5]) > 0)
        				{
        					System.out.print("[Sporting]");
            			}
        			
        			
        			}
        			System.out.println();
        			continue;
        		}
        		
        		
        		// calculate Denominator of IDF
        		double idfDenominator = 0;
        		double entropy = 0;
        		double de = (int)apps.get(appDistribution.appDistribution[i][0][0]);
        		for(int j = 0; j < 6; j++) {
        			double probability = 0;
        			if(j == 0 && Integer.parseInt(appDistribution.appDistribution[i][1][0]) > 0)
        			{
        				idfDenominator++;
        				probability = Double.parseDouble(appDistribution.appDistribution[i][1][0])/de;
        				entropy = entropy + probability*Math.log10(probability);
        				System.out.println(appDistribution.appDistribution[i][1][0]+" "+de+"!!!!");
        				
        			}	
        			else if(j == 1 && Integer.parseInt(appDistribution.appDistribution[i][1][1]) > 0)
        			{
        				idfDenominator++;
        				probability = Double.parseDouble(appDistribution.appDistribution[i][1][1])/de;
        				entropy = entropy + probability*Math.log10(probability);
        			}
        			else if(j == 2 && Integer.parseInt(appDistribution.appDistribution[i][1][2]) > 0)
        			{
        				idfDenominator++;
        				probability = Double.parseDouble(appDistribution.appDistribution[i][1][2])/de;
        				entropy = entropy + probability*Math.log10(probability);
        			}
        			else if(j == 3 && Integer.parseInt(appDistribution.appDistribution[i][1][3]) > 0)
        			{
        				idfDenominator++;
        				probability = Double.parseDouble(appDistribution.appDistribution[i][1][3])/de;
        				entropy = entropy + probability*Math.log10(probability);
        			}
        				
        			else if(j == 4 && Integer.parseInt(appDistribution.appDistribution[i][1][4]) > 0)
        			{
        				idfDenominator++;
        				probability = Double.parseDouble(appDistribution.appDistribution[i][1][4])/de;
        				entropy = entropy + probability*Math.log10(probability);
        			}
        			else if(j == 5 && Integer.parseInt(appDistribution.appDistribution[i][1][5]) > 0)
        			{
        				idfDenominator++;
        				probability = Double.parseDouble(appDistribution.appDistribution[i][1][5])/de;
        				entropy = entropy + probability*Math.log10(probability);
        			}	
        		}
        		entropy = 1+ entropy;
        		
        		for(int j = 0; j < 6; j++) {
        			if(j == 0)
        			{
        				if(tTFDenominator > 0 && idfDenominator > 0)
        				{
        					if(parameter.appChoice == 3)
        					{
        						tTFIDF.put(appDistribution.appDistribution[i][0][0], (Double.parseDouble(appDistribution.appDistribution[i][1][0])/tTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
        					}
        					else if(parameter.appChoice == 1)
        					{
        						// frequency
            					// 若在每個activities中都有出現則以此去掉system process
            					if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						tTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
            					else
            						tTFIDF.put(appDistribution.appDistribution[i][0][0], Double.parseDouble(appDistribution.appDistribution[i][1][0]));
        					}
        					else if(parameter.appChoice == 2)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						tTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        						else
        						{
        							//double propability = 0;
        							tTFIDF.put(appDistribution.appDistribution[i][0][0], entropy*(Double.parseDouble(appDistribution.appDistribution[i][1][0])/tTFDenominator));
        							
        						}
        					}
        				}
        				else
        					tTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        				
        				//System.out.print("[Transportation: "+appDistribution.appDistribution[i][1][0]+"]\t");
        				if(parameter.SVM_BAYES == 0)
        					System.out.print("[Transportation: "+tTFIDF.get(appDistribution.appDistribution[i][0][0])+"]");
        				else
        				{
        					if(Double.parseDouble(appDistribution.appDistribution[i][1][0]) > 0 && ((int)apps.get(appDistribution.appDistribution[i][0][0]) != totalActivities))
        						//System.out.println(appDistribution.appDistribution[i][0][0]+",Transportation");
        						System.out.println("1 1:"+i);
        				}
        					
        			}
        			else if(j == 1)
        			{
        				if(wTFDenominator > 0 && idfDenominator > 0)
        				{
        					if(parameter.appChoice == 3)
        					{
        						wTFIDF.put(appDistribution.appDistribution[i][0][0], (Double.parseDouble(appDistribution.appDistribution[i][1][1])/wTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
        					}
        					else if(parameter.appChoice == 1)
        					{
	        					if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
	        						wTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
	        					else
	        						wTFIDF.put(appDistribution.appDistribution[i][0][0], Double.parseDouble(appDistribution.appDistribution[i][1][1]));
        					}
        					else if(parameter.appChoice == 2)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						wTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        						else
        						{
        							//double propability = 0;
        							wTFIDF.put(appDistribution.appDistribution[i][0][0], entropy*(Double.parseDouble(appDistribution.appDistribution[i][1][1])/wTFDenominator));
        							
        						}
        					}
        				}
        					
        				else
        					wTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        				//System.out.print("[Working: "+appDistribution.appDistribution[i][1][1]+"]\t");
        				if(parameter.SVM_BAYES == 0)
        					System.out.print("[Working: "+wTFIDF.get(appDistribution.appDistribution[i][0][0])+"]");
        				else
        				{
        					if(Double.parseDouble(appDistribution.appDistribution[i][1][1]) > 0 && ((int)apps.get(appDistribution.appDistribution[i][0][0]) != totalActivities))
        						//System.out.println(appDistribution.appDistribution[i][0][0]+",Working");
        						System.out.println("2 1:"+i);
        				}
        					
        			}
        			else if(j == 2)
        			{
        				if(eTFDenominator > 0 && idfDenominator > 0)
        				{
        					
        					if(parameter.appChoice == 3)
        					{
        						eTFIDF.put(appDistribution.appDistribution[i][0][0], (Double.parseDouble(appDistribution.appDistribution[i][1][2])/eTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
        					}
        					else if(parameter.appChoice == 1)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						eTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
            					else
            						eTFIDF.put(appDistribution.appDistribution[i][0][0], Double.parseDouble(appDistribution.appDistribution[i][1][2]));
        					}
        					else if(parameter.appChoice == 2)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						eTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        						else
        						{
        							//double propability = 0;
        							eTFIDF.put(appDistribution.appDistribution[i][0][0], entropy*(Double.parseDouble(appDistribution.appDistribution[i][1][2])/eTFDenominator));
        							
        						}
        					}
        				}
        					
        				else
        					eTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        				//System.out.print("[Entertainment: "+appDistribution.appDistribution[i][1][2]+"]\t");
        				if(parameter.SVM_BAYES == 0)
        					System.out.print("[Entertainment: "+eTFIDF.get(appDistribution.appDistribution[i][0][0])+"]");
        				else
        				{
        					if(Double.parseDouble(appDistribution.appDistribution[i][1][2]) > 0 && ((int)apps.get(appDistribution.appDistribution[i][0][0]) != totalActivities))
        						//System.out.println(appDistribution.appDistribution[i][0][0]+",Entertainment");
        						System.out.println("3 1:"+i);
        				}
        					
        			}
        			else if(j == 3)
        			{
        				if(dTFDenominator > 0 && idfDenominator > 0)
        				{
        					if(parameter.appChoice == 3)
        					{
        						dTFIDF.put(appDistribution.appDistribution[i][0][0], (Double.parseDouble(appDistribution.appDistribution[i][1][3])/dTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
        					}
        					else if(parameter.appChoice == 1)
        					{
        						
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						dTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
            					else
            						dTFIDF.put(appDistribution.appDistribution[i][0][0], Double.parseDouble(appDistribution.appDistribution[i][1][3]));
        					}
        					else if(parameter.appChoice == 2)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						dTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        						else
        						{
        							//double propability = 0;
        							dTFIDF.put(appDistribution.appDistribution[i][0][0], entropy*(Double.parseDouble(appDistribution.appDistribution[i][1][3])/dTFDenominator));
        							
        						}
        					}
        					
        				}
        					
        				else
        					dTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        				//System.out.print("[Dining: "+appDistribution.appDistribution[i][1][3]+"]\t");
        				if(parameter.SVM_BAYES == 0)
        					System.out.print("[Dining: "+dTFIDF.get(appDistribution.appDistribution[i][0][0])+"]");
        				else
        				{
        					if(Double.parseDouble(appDistribution.appDistribution[i][1][3]) > 0 && ((int)apps.get(appDistribution.appDistribution[i][0][0]) != totalActivities))
        						//System.out.println(appDistribution.appDistribution[i][0][0]+",Dining");
        						System.out.println("4 1:"+i);
        				}
        					
        			}
        			else if(j == 4)
        			{
        				if(shTFDenominator > 0 && idfDenominator > 0)
        				{
        					if(parameter.appChoice == 3)
        					{
        						shTFIDF.put(appDistribution.appDistribution[i][0][0], (Double.parseDouble(appDistribution.appDistribution[i][1][4])/shTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
        					}
        					else if(parameter.appChoice == 1)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						shTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
            					else
            						shTFIDF.put(appDistribution.appDistribution[i][0][0], Double.parseDouble(appDistribution.appDistribution[i][1][4]));
        					}
        					else if(parameter.appChoice == 2)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						shTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        						else
        						{
        							//double propability = 0;
        							shTFIDF.put(appDistribution.appDistribution[i][0][0], entropy*(Double.parseDouble(appDistribution.appDistribution[i][1][4])/shTFDenominator));
        							
        						}
        					}
        					
        				}
        					
        				else
        					shTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        				//System.out.print("[Shopping: "+appDistribution.appDistribution[i][1][4]+"]\t");
        				if(parameter.SVM_BAYES == 0)
        					System.out.print("[Shopping: "+shTFIDF.get(appDistribution.appDistribution[i][0][0])+"]");
        				else
        				{
        					if(Double.parseDouble(appDistribution.appDistribution[i][1][4]) > 0 && ((int)apps.get(appDistribution.appDistribution[i][0][0]) != totalActivities))
        						//System.out.println(appDistribution.appDistribution[i][0][0]+",Shopping");
        					System.out.println("5 1:"+i);
        				}
        					
        			}
        				
        			else if(j == 5)
        			{
        				if(spTFDenominator > 0 && idfDenominator > 0)
        				{
        					if(parameter.appChoice == 3)
        					{
        						spTFIDF.put(appDistribution.appDistribution[i][0][0], (Double.parseDouble(appDistribution.appDistribution[i][1][5])/spTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
        					}
        					else if(parameter.appChoice == 1)
        					{
	        					//spTFIDF.put(appDistribution.appDistribution[i][0][0], (Double.parseDouble(appDistribution.appDistribution[i][1][5])/spTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
	        					if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
	        						spTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
	        					else
	        						spTFIDF.put(appDistribution.appDistribution[i][0][0], Double.parseDouble(appDistribution.appDistribution[i][1][5]));
        					}
        					else if(parameter.appChoice == 2)
        					{
        						if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
            						spTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        						else
        						{
        							//double propability = 0;
        							spTFIDF.put(appDistribution.appDistribution[i][0][0], entropy*(Double.parseDouble(appDistribution.appDistribution[i][1][5])/spTFDenominator));
        							
        						}
        					}
        				}
        					
        				else
        					spTFIDF.put(appDistribution.appDistribution[i][0][0], 0.0);
        				//System.out.println("[Sporting: "+appDistribution.appDistribution[i][1][5]+"]\t");
        				if(parameter.SVM_BAYES == 0)
        					System.out.println("[Sporting: "+spTFIDF.get(appDistribution.appDistribution[i][0][0])+"]");
        				else
        				{
        					if(Double.parseDouble(appDistribution.appDistribution[i][1][5]) > 0 && ((int)apps.get(appDistribution.appDistribution[i][0][0]) != totalActivities))
        						//System.out.println(appDistribution.appDistribution[i][0][0]+",Sporting");
        						System.out.println("6 1:"+i);
        				}
        					
        			}

//        			if(appDistribution.appDistribution[i][1][j] == "0")
//        			{
//        				System.out.println();
//        				break;
//        			}
//        			else
//        				System.out.print("["+appDistribution.appDistribution[i][1][j]+"] ");
        		}

        	}
        	
        	System.out.println(dtotal);
        	ValueComparator bvc;
        	TreeMap<String,Double> sorted_map = null;
        	int order = 1; //輸出從1~10個app
        	if(parameter.appChoice == 3)
        		System.out.println("TFIDF");
        	if(appDistribution.activityDistribution[3] > 0)
        	{
	        	bvc =  new ValueComparator(dTFIDF);
	            sorted_map = new TreeMap<String,Double>(bvc);
	            sorted_map.putAll(dTFIDF);
	
	            //System.out.println("results: "+sorted_map);
	          
	            System.out.print("public String[] diningApp = {");
	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
	            	
	            	// top K(K=11)
	            	if(order == parameter.topK)
	            		break;
	                double value = entry.getValue();
	                String key = entry.getKey();
	                //System.out.println(order+": "+key+" ("+value+")");
	                if(value == 0)
	                	System.out.print("null,");
	                else
	                	System.out.print(""+key+",");
	                order++;
	           }
	            System.out.println("};");
        	}
        	else
        	{
        		System.out.print("public String[] diningApp = {");
        		for(int i = 1; i < parameter.topK; i++)
        			System.out.print("null,");
        		System.out.println("};");
        	}

        	
        	if(appDistribution.activityDistribution[0] > 0)
        	{
	            bvc =  new ValueComparator(tTFIDF);
	            sorted_map = new TreeMap<String,Double>(bvc);
	            sorted_map.putAll(tTFIDF);
	
	            //System.out.println("results: "+sorted_map);
	            order = 1;
	         
	            System.out.print("public String[] transportationApp = {");
	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
	            	
	            	// top K(K=11)
	            	if(order == parameter.topK)
	            		break;
	                double value = entry.getValue();
	                String key = entry.getKey();
	                //System.out.println(order+": "+key+" ("+value+")");
	                if(value == 0)
	                	System.out.print("null,");
	                else
	                	System.out.print(""+key+",");
	                order++;
	           }
	           System.out.println("};");
        	}
        	else
        	{
        		System.out.print("public String[] transportationApp = {");
        		for(int i = 1; i < parameter.topK; i++)
        			System.out.print("null,");
        		System.out.println("};");
        	}
        	
        	
        	if(appDistribution.activityDistribution[5] > 0)
            {
	            bvc =  new ValueComparator(spTFIDF);
	            sorted_map = new TreeMap<String,Double>(bvc);
	            sorted_map.putAll(spTFIDF);
	
	            //System.out.println("results: "+sorted_map);
	            order = 1;
	      
	            System.out.print("public String[] sportingApp = {");
	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
	            	
	            	// top K(K=11)
	            	if(order == parameter.topK)
	            		break;
	                double value = entry.getValue();
	                String key = entry.getKey();
	                //System.out.println(order+": "+key+" ("+value+")");
	                if(value == 0)
	                	System.out.print("null,");
	                else
	                	System.out.print(""+key+",");
	                order++;
	           }
	            System.out.println("};");
            }
        	else
        	{
        		System.out.print("public String[] sportingApp = {");
        		for(int i = 1; i < parameter.topK; i++)
        			System.out.print("null,");
        		System.out.println("};");
        	}
            
            if(appDistribution.activityDistribution[1] > 0)
            {
	            bvc =  new ValueComparator(wTFIDF);
	            sorted_map = new TreeMap<String,Double>(bvc);
	            sorted_map.putAll(wTFIDF);
	
	            //System.out.println("results: "+sorted_map);
	            order = 1;
	          
	            System.out.print("public String[] workingApp = {");
	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
	            	
	            	// top K(K=11)
	            	if(order == parameter.topK)
	            		break;
	                double value = entry.getValue();
	                String key = entry.getKey();
	                //System.out.println(order+": "+key+" ("+value+")");
	                if(value == 0)
	                	System.out.print("null,");
	                else
	                	System.out.print(""+key+",");
	                order++;
	           }
	            System.out.println("};");
            }
            else
        	{
        		System.out.print("public String[] workingApp = {");
        		for(int i = 1; i < parameter.topK; i++)
        			System.out.print("null,");
        		System.out.println("};");
        	}
            
            if(appDistribution.activityDistribution[2] > 0)
            {
	            bvc =  new ValueComparator(eTFIDF);
	            sorted_map = new TreeMap<String,Double>(bvc);
	            sorted_map.putAll(eTFIDF);
	
	            //System.out.println("results: "+sorted_map);
	            order = 1;
	        
	            System.out.print("public String[] entertainmentApp = {");
	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
	            	
	            	// top K(K=11)
	            	if(order == parameter.topK)
	            		break;
	                double value = entry.getValue();
	                String key = entry.getKey();
	                //System.out.println(order+": "+key+" ("+value+")");
	                if(value == 0)
	                	System.out.print("null,");
	                else
	                	System.out.print(""+key+",");
	                order++;
	           }
	            System.out.println("};");
            }
            else
        	{
        		System.out.print("public String[] entertainmentApp = {");
        		for(int i = 1; i < parameter.topK; i++)
        			System.out.print("null,");
        		System.out.println("};");
        	}
	         
            if(appDistribution.activityDistribution[4] > 0)
            {
	            bvc =  new ValueComparator(shTFIDF);
	            sorted_map = new TreeMap<String,Double>(bvc);
	            sorted_map.putAll(shTFIDF);
	
	            //System.out.println("results: "+sorted_map);
	            order = 1;
	          
	            System.out.print("public String[] shoppingApp = {");
	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
	            	
	            	// top K(K=11)
	            	if(order == parameter.topK)
	            		break;
	                double value = entry.getValue();
	                String key = entry.getKey();
	                //System.out.println(order+": "+key+" ("+value+")");
	                if(value == 0)
	                	System.out.print("null,");
	                else
	                	System.out.print(""+key+",");
	                order++;
	           }
	            System.out.println("};");
            } 
            else
        	{
        		System.out.print("public String[] shoppingApp = {");
        		for(int i = 1; i < parameter.topK; i++)
        			System.out.print("null,");
        		System.out.println("};");
        	}
            sorted_map.clear();
        	// http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
    		//HttpRequest httpRequest = new HttpRequest();
        	
        }
        
//        else if (parameter.hard_or_soft == 1)
//        {
//        	//fw.flush();
//        	//fw.close();
//        	System.out.println("GPS points:" + dpoints.size());
//        	//for(int i = 0; i < dpoints.size(); i++)
//        		//System.out.println(i+": "+dpoints.get(i).getLongitude() +" "+dpoints.get(i).getLatitude());
//        	Optics ca=new Optics();
//        	
//        	
//        	// MinPt, Radius, cluster list
//        	// 學姊是用2 points, 100 m
//    		ca.startAnalysis(dpoints, parameter.mpt, parameter.radius, clusters);
//    		for(int i = 0; i < clusters.size(); i++) {
//    			double lat = 0, lon = 0;
//    			for(int j = 0; j < clusters.get(i).gpsPoint.size(); j++)
//    			{
//    				String timestamp = clusters.get(i).gpsPoint.get(j).getTimestamp(); 
//    				timestamp = timestamp.substring(0, timestamp.length()-3);
//    				long hour = Long.valueOf(timestamp);
//    				Calendar calendar = Calendar.getInstance();
//    				calendar.setTimeInMillis(hour * 1000);
//    				int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
//    				//System.out.println(clusters.get(i).gpsPoint.get(j).getLongitude()+" "+clusters.get(i).gpsPoint.get(j).getLatitude()+" "+clusters.get(i).gpsPoint.get(j).getActivity()+" "+hourOfDay);
//    				lat += clusters.get(i).gpsPoint.get(j).getLatitude();
//    				lon += clusters.get(i).gpsPoint.get(j).getLongitude();
//    				
//    				
//    				// 每一群內時間的分布
//    				if(clusters.get(i).gpsPoint.get(j).getActivity().equals("Working"))
//    				{
//    					if(clusters.get(i).working.containsKey(hourOfDay))
//    						clusters.get(i).working.put(hourOfDay, clusters.get(i).working.get(hourOfDay)+1);
//    					else
//    						clusters.get(i).working.put(hourOfDay, 1);
//    				}
//    				else if(clusters.get(i).gpsPoint.get(j).getActivity().equals("Dining"))
//    				{
//    					if(clusters.get(i).dining.containsKey(hourOfDay))
//    						clusters.get(i).dining.put(hourOfDay, clusters.get(i).dining.get(hourOfDay)+1);
//    					else
//    						clusters.get(i).dining.put(hourOfDay, 1);
//    				}
//    				else if(clusters.get(i).gpsPoint.get(j).getActivity().equals("Transportation"))
//    				{
//    					if(clusters.get(i).transportation.containsKey(hourOfDay))
//    						clusters.get(i).transportation.put(hourOfDay, clusters.get(i).transportation.get(hourOfDay)+1);
//    					else
//    						clusters.get(i).transportation.put(hourOfDay, 1);
//    				}
//    				else if(clusters.get(i).gpsPoint.get(j).getActivity().equals("Shopping"))
//    				{
//    					if(clusters.get(i).shopping.containsKey(hourOfDay))
//    						clusters.get(i).shopping.put(hourOfDay, clusters.get(i).shopping.get(hourOfDay)+1);
//    					else
//    						clusters.get(i).shopping.put(hourOfDay, 1);
//    				}
//    				else if(clusters.get(i).gpsPoint.get(j).getActivity().equals("Entertainment"))
//    				{
//    					if(clusters.get(i).entertainment.containsKey(hourOfDay))
//    						clusters.get(i).entertainment.put(hourOfDay, clusters.get(i).entertainment.get(hourOfDay)+1);
//    					else
//    						clusters.get(i).entertainment.put(hourOfDay, 1);
//    				}
//    				else if(clusters.get(i).gpsPoint.get(j).getActivity().equals("Sporting"))
//    				{
//    					if(clusters.get(i).sporting.containsKey(hourOfDay))
//    						clusters.get(i).sporting.put(hourOfDay, clusters.get(i).sporting.get(hourOfDay)+1);
//    					else
//    						clusters.get(i).sporting.put(hourOfDay, 1);
//    				}
//    			
//    			}
//    			
//    			if(clusters.get(i).gpsPoint.size() > 0)
//    			{
//    				clusters.get(i).centralLat = lat / clusters.get(i).gpsPoint.size();
//    				clusters.get(i).centralLon = lon / clusters.get(i).gpsPoint.size();
//    			}
//    			//System.out.println("=====================================================");
//    		}
//    		
//    		// 輸出群的中心點以及這個群的activity的時間分布
//    		for(int i = 0; i < clusters.size(); i++) {
//    			System.out.println(clusters.get(i).centralLon+" "+clusters.get(i).centralLat);
//    			if(clusters.get(i).working.size() > 0)
//    			{
//    				for (Map.Entry<Integer, Integer> entry : clusters.get(i).working.entrySet())
//    				    System.out.println("working "+ entry.getKey() + ": " + entry.getValue());
//    			
//    			}
//    			if(clusters.get(i).entertainment.size() > 0)
//    			{
//    				for (Map.Entry<Integer, Integer> entry : clusters.get(i).entertainment.entrySet())
//    				    System.out.println("entertainment "+ entry.getKey() + ": " + entry.getValue());
//    			}
//    			if(clusters.get(i).dining.size() > 0)
//    			{
//    				for (Map.Entry<Integer, Integer> entry : clusters.get(i).dining.entrySet())
//    				    System.out.println("dining "+ entry.getKey() + ": " + entry.getValue());
//    			}
//    			if(clusters.get(i).sporting.size() > 0)
//    			{
//    				for (Map.Entry<Integer, Integer> entry : clusters.get(i).sporting.entrySet())
//    				    System.out.println("sporting "+ entry.getKey() + ": " + entry.getValue());
//    			}
//    			if(clusters.get(i).transportation.size() > 0)
//    			{
//    				for (Map.Entry<Integer, Integer> entry : clusters.get(i).transportation.entrySet())
//    				    System.out.println("transportation "+ entry.getKey() + ": " + entry.getValue());
//    			}
//    			if(clusters.get(i).shopping.size() > 0)
//    			{
//    				for (Map.Entry<Integer, Integer> entry : clusters.get(i).shopping.entrySet())
//    				    System.out.println("shopping "+ entry.getKey() + ": " + entry.getValue());
//    			}
//    			System.out.println("=====================================================");
//    		}
//    		
//    		//以下為驗證的部分
//    		file = new File(parameter.trainingFOLDERS[0]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
//
//            if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
//            {
//                String []s = file.list(); //宣告一個list
//                fileList.clear();
//                for(int i=0; i < s.length; i++)
//                {
//                    //System.out.println(s[i]);
//                    fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡面
//                }
//            }
//            
//            double counterTotal = 0, counterCorrect = 0;
//            for(int i = 0; i < fileList.size(); i++)
//            {
//            	Parser parser = new Parser();
//            	String fileName = parameter.trainingFOLDERS[0] + "\\" + fileList.get(i);
//            	System.out.println(i + ": "+fileName);
//        	
//            	
//            	// 裡面有沒在region就用global來判斷的code
//        		int  a = parser.InitializeHardware(fileName, result, clusters, timeDistribution);
//        		System.out.println(a);
//        		if(a == 1 || a == -1 || a == -2)
//        			counterTotal++;
//        		if(a == 1)
//        			counterCorrect++;
//            }
//            System.out.println(counterCorrect+" "+counterTotal+"\nAccuracy: "+ counterCorrect/counterTotal);
//            for (Map.Entry<Integer, Integer> entry : timeDistribution.tTimeDistribution.entrySet())
//			    System.out.println("t "+ entry.getKey() + ": " + entry.getValue());
//            for (Map.Entry<Integer, Integer> entry : timeDistribution.dTimeDistribution.entrySet())
//			    System.out.println("d "+ entry.getKey() + ": " + entry.getValue());
//            for (Map.Entry<Integer, Integer> entry : timeDistribution.wTimeDistribution.entrySet())
//			    System.out.println("w "+ entry.getKey() + ": " + entry.getValue());
//            for (Map.Entry<Integer, Integer> entry : timeDistribution.spTimeDistribution.entrySet())
//			    System.out.println("sp "+ entry.getKey() + ": " + entry.getValue());
//            for (Map.Entry<Integer, Integer> entry : timeDistribution.shTimeDistribution.entrySet())
//			    System.out.println("sh "+ entry.getKey() + ": " + entry.getValue());
//            for (Map.Entry<Integer, Integer> entry : timeDistribution.eTimeDistribution.entrySet())
//			    System.out.println("e "+ entry.getKey() + ": " + entry.getValue());
//            
//
//
//        }
        
//        else if (parameter.hard_or_soft == -2)
//        {
//        	int totalActivities = 0;
//        	System.out.println("\n\n\n\n\nSporting: "+appDistribution.activityDistribution[5]);
//        	System.out.println("Transportation: "+appDistribution.activityDistribution[0]);
//        	System.out.println("Dining: "+appDistribution.activityDistribution[3]);
//        	System.out.println("Working: "+appDistribution.activityDistribution[1]);
//        	System.out.println("Shopping: "+appDistribution.activityDistribution[4]);
//        	System.out.println("Entertainment: "+appDistribution.activityDistribution[2]);
//        	for(int i = 0; i < 6; i++) {
//        		if(appDistribution.activityDistribution[i] == 0)
//        			appDistribution.activeActivities--;
//        		
//        		totalActivities += appDistribution.activityDistribution[i];
//        	}
//        	System.out.println(totalActivities);
//        	
//        	for(int i = 0; i < appDistribution.counter; i++) {
//        		spTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][5]);
//        		
//        	    shTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][4]);
//        	    dTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][3]);
//        	    wTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][1]);
//        	    eTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][2]);
//        	    tTFDenominator += Integer.parseInt(appDistribution.appDistribution[i][1][0]);
//        	} 	
//        	System.out.println(spTFDenominator+" "+tTFDenominator+" "+shTFDenominator+" "+dTFDenominator+" "+wTFDenominator+" "+eTFDenominator+" ");
//
//        	
//        	Map<String,Double> dCategory = new HashMap<String,Double>();
//        	Map<String,Double> spCategory = new HashMap<String,Double>();
//        	Map<String,Double> shCategory = new HashMap<String,Double>();
//        	Map<String,Double> tCategory = new HashMap<String,Double>();
//        	Map<String,Double> wCategory = new HashMap<String,Double>();
//        	Map<String,Double> eCategory = new HashMap<String,Double>();
//        	
//
//        	//eCategory.put("aaa",eCategory.get("aaa")+100);
//        	//System.out.println(eCategory.get("aaa"));
//        	
//        	for(int i = 0; i < appDistribution.counter; i++) {
//        		//if(parameter.SVM_BAYES == 0)
//        			//System.out.print(appDistribution.appDistribution[i][0][0]+"("+(int)apps.get(appDistribution.appDistribution[i][0][0])+"): ");
//        		HttpRequest httpRequest = new HttpRequest();
//        		String category = httpRequest.sendGet(appDistribution.appDistribution[i][0][0]);
//        		System.out.print(appDistribution.appDistribution[i][0][0]+"("+category+" "+ (int)apps.get(appDistribution.appDistribution[i][0][0])+"): ");  		
//     
//        		//if(((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities))
//        		
//        		
//        		
//        			for(int j = 0; j < 6; j++) {
//            			
//        				if(j == 0 && Integer.parseInt(appDistribution.appDistribution[i][1][0]) > 0)
//            			{
//        					double number = Double.parseDouble(appDistribution.appDistribution[i][1][0]);
//        					if((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities)
//        						number = 0;
//        					
//        					if(parameter.appChoice == 1 || parameter.appChoice == 3)
//        					{
//        						if(tCategory.containsKey(category))
//            						tCategory.put(category,tCategory.get(category)+number);
//            		        	else
//            		        		tCategory.put(category, number);	
//        					}
//        			
//        					System.out.print("[Transportation]");
//            			}	
//        				else if(j == 1 && Integer.parseInt(appDistribution.appDistribution[i][1][1]) > 0)
//        				{
//        					double number = Double.parseDouble(appDistribution.appDistribution[i][1][1]);
//        					if((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities)
//        						number = 0;
//        					if(parameter.appChoice == 1 || parameter.appChoice == 3)
//        					{
//	        					if(wCategory.containsKey(category))
//	        						wCategory.put(category,wCategory.get(category)+number);
//	        		        	else
//	        		        		wCategory.put(category, number);
//        					}
//        			
//        					System.out.print("[Working]");
//            			}
//        				else if(j == 2 && Integer.parseInt(appDistribution.appDistribution[i][1][2]) > 0)
//        				{
//        					double number = Double.parseDouble(appDistribution.appDistribution[i][1][2]);
//        					if((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities)
//        						number = 0;
//        					if(parameter.appChoice == 1 || parameter.appChoice == 3)
//        					{
//	        					if(eCategory.containsKey(category))
//	        						eCategory.put(category,eCategory.get(category)+number);
//	        		        	else
//	        		        		eCategory.put(category, number);
//        					}
//        				
//        					System.out.print("[Entertainment]");
//            			}
//        				else if(j == 3 && Integer.parseInt(appDistribution.appDistribution[i][1][3]) > 0)
//        				{
//        					double number = Double.parseDouble(appDistribution.appDistribution[i][1][3]);
//        					if((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities)
//        						number = 0;
//        					if(parameter.appChoice == 1 || parameter.appChoice == 3)
//        					{
//	        					if(dCategory.containsKey(category))
//	        						dCategory.put(category,dCategory.get(category)+number);
//	        		        	else
//	        		        		dCategory.put(category, number);
//        					}
//        			
//        					System.out.print("[Dining]"+number);
//            			}
//        				else if(j == 4 && Integer.parseInt(appDistribution.appDistribution[i][1][4]) > 0)
//        				{
//        					double number = Double.parseDouble(appDistribution.appDistribution[i][1][4]);
//        					if((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities)
//        						number = 0;
//        					if(parameter.appChoice == 1 || parameter.appChoice == 3)
//        					{
//	        					if(shCategory.containsKey(category))
//	        						shCategory.put(category,shCategory.get(category)+number);
//	        		        	else
//	        		        		shCategory.put(category, number);
//        					}
//        	
//        					System.out.print("[Shopping]");
//            			}
//        				else if(j == 5 && Integer.parseInt(appDistribution.appDistribution[i][1][5]) > 0)
//        				{
//        					double number = Double.parseDouble(appDistribution.appDistribution[i][1][5]);
//        					if((int)apps.get(appDistribution.appDistribution[i][0][0]) == totalActivities)
//        						number = 0;
//        					if(parameter.appChoice == 1 || parameter.appChoice == 3)
//        					{
//	        					if(spCategory.containsKey(category))
//	        						spCategory.put(category,spCategory.get(category)+number);
//	        		        	else
//	        		        		spCategory.put(category, number);
//        					}
//     
//        					System.out.print("[Sporting]");
//            			}
//        			}
//        			System.out.println();
//        			continue;
//        	}
//        	
//        	if(parameter.appChoice == 3)
//        	{
//	        	/* 計算idf分母，因為category會跨多個activity */
//	        	for (Map.Entry<String, Double> entry : tCategory.entrySet())
//	        	{
//	        		double idfDenominator = 1;
//	        	    //System.out.println(entry.getKey());
//	        		if(dCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(spCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(eCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(shCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(wCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		//System.out.println(entry.getKey()+": "+idfDenominator);
//	        		tCategory.put(entry.getKey(), (entry.getValue()/tTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
//	        	}
//	        	
//	        	for (Map.Entry<String, Double> entry : spCategory.entrySet())
//	        	{
//	        		double idfDenominator = 1;
//	        	    //System.out.println(entry.getKey());
//	        		if(dCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(eCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(shCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(wCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(tCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		spCategory.put(entry.getKey(), (entry.getValue()/spTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
//
//	        	}
//	
//	        	for (Map.Entry<String, Double> entry : dCategory.entrySet())
//	        	{
//	        		double idfDenominator = 1;
//	        	    //System.out.println(entry.getKey());
//	        		if(spCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(eCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(shCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(wCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(tCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		dCategory.put(entry.getKey(), (entry.getValue()/dTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
//
//	        	}
//	        	
//	        	for (Map.Entry<String, Double> entry : eCategory.entrySet())
//	        	{
//	        		double idfDenominator = 1;
//	        	    //System.out.println(entry.getKey());
//	        		if(dCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(spCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(shCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(wCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(tCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		eCategory.put(entry.getKey(), (entry.getValue()/eTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
//
//	        	}
//	        	
//	        	for (Map.Entry<String, Double> entry : shCategory.entrySet())
//	        	{
//	        		double idfDenominator = 1;
//	        	    //System.out.println(entry.getKey());
//	        		if(dCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(spCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(eCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(wCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(tCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		shCategory.put(entry.getKey(), (entry.getValue()/shTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
//
//	        	}
//	        	
//	        	for (Map.Entry<String, Double> entry : wCategory.entrySet())
//	        	{
//	        		double idfDenominator = 1;
//	        	    //System.out.println(entry.getKey());
//	        		if(dCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(spCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(eCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(shCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		if(tCategory.containsKey(entry.getKey()))
//	        			idfDenominator++;
//	        		wCategory.put(entry.getKey(), (entry.getValue()/wTFDenominator) * (Math.log(appDistribution.activeActivities/idfDenominator) / Math.log(appDistribution.activeActivities)));
//
//	        	}
//        	}
//        	
//        	
//        	ValueComparator bvc;
//        	TreeMap<String,Double> sorted_map;
//        	int order = 1; //輸出從1~10個app
//        	if(appDistribution.activityDistribution[3] > 0)
//        	{
//	        	bvc =  new ValueComparator(dCategory);
//	            sorted_map = new TreeMap<String,Double>(bvc);
//	            sorted_map.putAll(dCategory);
//	
//	            //System.out.println("results: "+sorted_map);
//	            System.out.print("//	public String[] diningApp = {");
//	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
//	            	
//	            	// top K(K=11)
//	            	if(order == parameter.topK)
//	            		break;
//	                double value = entry.getValue();
//	                String key = entry.getKey();
//	                //System.out.println(order+": "+key+" ("+value+")");
//	                if(value == 0)
//	                	System.out.print("null,");
//	                else
//	                	System.out.print(key+",");
//	                order++;
//	           }
//	            if(order != parameter.topK)
//	            {
//	            	while(true) {
//	            		System.out.print("null,");	
//	            		order++;
//	            		if(order == parameter.topK)
//		            		break;
//	            	}
//	            }
//	            System.out.println("};");
//        	}
//        	else
//        	{
//        		System.out.print("//	public String[] diningApp = {");
//        		for(int i = 1; i < parameter.topK; i++)
//        			System.out.print("null,");
//        		System.out.println("};");
//        	}
//
//        	
//        	if(appDistribution.activityDistribution[0] > 0)
//        	{
//	            bvc =  new ValueComparator(tCategory);
//	            sorted_map = new TreeMap<String,Double>(bvc);
//	            sorted_map.putAll(tCategory);
//	
//	            //System.out.println("results: "+sorted_map);
//	            order = 1;
//	         
//	            System.out.print("//	public String[] transportationApp = {");
//	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
//	            	
//	            	// top K(K=11)
//	            	if(order == parameter.topK)
//	            		break;
//	                double value = entry.getValue();
//	                String key = entry.getKey();
//	                //System.out.println(order+": "+key+" ("+value+")");
//	                if(value == 0)
//	                	System.out.print("null,");
//	                else
//	                	System.out.print(""+key+",");
//	                order++;
//	           }
//	            if(order != parameter.topK)
//	            {
//	            	while(true) {
//	            		System.out.print("null,");	
//	            		order++;
//	            		if(order == parameter.topK)
//		            		break;
//	            	}
//	            }
//	           System.out.println("};");
//        	}
//        	else
//        	{
//        		System.out.print("//	public String[] transportationApp = {");
//        		for(int i = 1; i < parameter.topK; i++)
//        			System.out.print("null,");
//        		System.out.println("};");
//        	}
//        	
//        	
//        	if(appDistribution.activityDistribution[5] > 0)
//            {
//	            bvc =  new ValueComparator(spCategory);
//	            sorted_map = new TreeMap<String,Double>(bvc);
//	            sorted_map.putAll(spCategory);
//	
//	            //System.out.println("results: "+sorted_map);
//	            order = 1;
//	      
//	            System.out.print("//	public String[] sportingApp = {");
//	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
//	            	
//	            	// top K(K=11)
//	            	if(order == parameter.topK)
//	            		break;
//	                double value = entry.getValue();
//	                String key = entry.getKey();
//	                //System.out.println(order+": "+key+" ("+value+")");
//	                if(value == 0)
//	                	System.out.print("null,");
//	                else
//	                	System.out.print(""+key+",");
//	                order++;
//	           }
//	            if(order != parameter.topK)
//	            {
//	            	while(true) {
//	            		System.out.print("null,");	
//	            		order++;
//	            		if(order == parameter.topK)
//		            		break;
//	            	}
//	            }
//	            System.out.println("};");
//            }
//        	else
//        	{
//        		System.out.print("//	public String[] sportingApp = {");
//        		for(int i = 1; i < parameter.topK; i++)
//        			System.out.print("null,");
//        		System.out.println("};");
//        	}
//            
//            if(appDistribution.activityDistribution[1] > 0)
//            {
//	            bvc =  new ValueComparator(wCategory);
//	            sorted_map = new TreeMap<String,Double>(bvc);
//	            sorted_map.putAll(wCategory);
//	
//	            //System.out.println("results: "+sorted_map);
//	            order = 1;
//	          
//	            System.out.print("//	public String[] workingApp = {");
//	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
//	            	
//	            	// top K(K=11)
//	            	if(order == parameter.topK)
//	            		break;
//	                double value = entry.getValue();
//	                String key = entry.getKey();
//	                //System.out.println(order+": "+key+" ("+value+")");
//	                if(value == 0)
//	                	System.out.print("null,");
//	                else
//	                	System.out.print(""+key+",");
//	                order++;
//	           }
//	            if(order != parameter.topK)
//	            {
//	            	while(true) {
//	            		System.out.print("null,");	
//	            		order++;
//	            		if(order == parameter.topK)
//		            		break;
//	            	}
//	            }
//	            System.out.println("};");
//            }
//            else
//        	{
//        		System.out.print("//	public String[] workingApp = {");
//        		for(int i = 1; i < parameter.topK; i++)
//        			System.out.print("null,");
//        		System.out.println("};");
//        	}
//            
//            if(appDistribution.activityDistribution[2] > 0)
//            {
//	            bvc =  new ValueComparator(eCategory);
//	            sorted_map = new TreeMap<String,Double>(bvc);
//	            sorted_map.putAll(eCategory);
//	
//	            //System.out.println("results: "+sorted_map);
//	            order = 1;
//	        
//	            System.out.print("//	public String[] entertainmentApp = {");
//	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
//	            	
//	            	// top K(K=11)
//	            	if(order == parameter.topK)
//	            		break;
//	                double value = entry.getValue();
//	                String key = entry.getKey();
//	                //System.out.println(order+": "+key+" ("+value+")");
//	                if(value == 0)
//	                	System.out.print("null,");
//	                else
//	                	System.out.print(""+key+",");
//	                order++;
//	           }
//	            if(order != parameter.topK)
//	            {
//	            	while(true) {
//	            		System.out.print("null,");	
//	            		order++;
//	            		if(order == parameter.topK)
//		            		break;
//	            	}
//	            }
//	            System.out.println("};");
//            }
//            else
//        	{
//        		System.out.print("//	public String[] entertainmentApp = {");
//        		for(int i = 1; i < parameter.topK; i++)
//        			System.out.print("null,");
//        		System.out.println("};");
//        	}
//	         
//            if(appDistribution.activityDistribution[4] > 0)
//            {
//	            bvc =  new ValueComparator(shCategory);
//	            sorted_map = new TreeMap<String,Double>(bvc);
//	            sorted_map.putAll(shCategory);
//	
//	            //System.out.println("results: "+sorted_map);
//	            order = 1;
//	          
//	            System.out.print("//	public String[] shoppingApp = {");
//	            for (Map.Entry<String, Double> entry : sorted_map.entrySet()) {
//	            	
//	            	// top K(K=11)
//	            	if(order == parameter.topK)
//	            		break;
//	                double value = entry.getValue();
//	                String key = entry.getKey();
//	                //System.out.println(order+": "+key+" ("+value+")");
//	                if(value == 0)
//	                	System.out.print("null,");
//	                else
//	                	System.out.print(""+key+",");
//	                order++;
//	           }
//	            if(order != parameter.topK)
//	            {
//	            	while(true) {
//	            		System.out.print("null,");	
//	            		order++;
//	            		if(order == parameter.topK)
//		            		break;
//	            	}
//	            }
//	            System.out.println("};");
//            } 
//            else
//        	{
//        		System.out.print("//	public String[] shoppingApp = {");
//        		for(int i = 1; i < parameter.topK; i++)
//        			System.out.print("null,");
//        		System.out.println("};");
//        	}
//        }

		    //String fileName = "D:\\STAIM\\input\\353567051351832\\h2013-09-06 14-02-47_353567051351832.txt";
		    //Parser parser = new Parser();
		    //parser.InitializeHardware(fileName);
       spTFIDF.clear();
	    tTFIDF.clear();
	    shTFIDF.clear(); 
	    dTFIDF.clear(); 
	   wTFIDF.clear(); 
	   eTFIDF.clear(); 
	   appDistribution = null;
	    apps.clear(); 
	    inTheSameFile.clear(); 
	    System.out.println("end!!!!!\n");
	    runtime = Runtime.getRuntime();
 	    // Run the garbage collector
 	    runtime.gc();
 	    // Calculate the used memory
 	   memory = runtime.totalMemory() - runtime.freeMemory();
 	   System.out.println("[Training phase] Used memory is Mbytes: " + (double)memory/1048576);
	}
	
	public static double rad(double a)
    {
    	return a * Math.PI/180.0;
    }
}


/* hashmap sorting */
class ValueComparator implements Comparator<String> {

    Map<String, Double> base;
    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }
    
    

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
