package OnlineTesting;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class main {
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		
		long elapsedTime = 0;
		long startTime = 0;
	    long stopTime = 0;
	    
		int section = 0;
		Profile profile = new Profile();
		Parameter parameter = new Parameter();
		
		// load model
		startTime = System.currentTimeMillis();
		System.out.println(args[0]);
		try {
			//for (String line : Files.readAllLines(Paths.get("/home/likekaito/public_html/htc_classifier/"+args[0]+".txt"))) {
			for (String line : Files.readAllLines(Paths.get("D:\\STAIM\\input\\libSVM\\AIM\\"+parameter.imei[0]+".txt"))) {
				
				if(line.equals("[Threshold]"))
				{
					section = 1;
					continue;
				}
				else if(line.equals("[Speed]"))
				{
					section = 2;
					continue;
				}
				else if(line.equals("[SDDM]"))
				{
					section = 3;
					continue;
				}
				else if(line.equals("[Frequent Region]"))
				{
					section = 4;
					continue;
				}
				else if(line.equals("[Application List]"))
				{
					section = 5;
					if(profile.frIndex != -1)
						profile.clusters.add(profile.cluster);
	//				System.out.println(profile.clusters.size());
	//				for (int i = 0; i < profile.clusters.size(); i++) {
	//					for (Map.Entry<Integer, Integer> entry :  profile.clusters.get(i).dining.entrySet())
	//					{
	//					    System.out.println(entry.getKey() + "/" + entry.getValue());
	//					}
	//		        }
					continue;
				}
				else if(line.equals("[GATDM]"))
				{
					section = 6;
					continue;
				}
				else if(line.equals("[END]"))
					section = 7;
				
				if(section == 1)
					profile.threshold = Double.valueOf(line);
				else if(section == 2)
					;
				else if(section == 3)
				{
					String[] afterSplit = line.split(" ");
					for (int i = 0; i < afterSplit.length; i++) {
						int value = Integer.parseInt(afterSplit[i]);
						profile.weightedTable[profile.weightedTableIndex][i] = value;
					}
					profile.weightedTableIndex++;
				}
				else if(section == 4)
				{
					//System.out.println("!!!!");
					if(line.substring(0,2).equals("FR"))
					{
						if(!line.equals("FR 0"))
							profile.clusters.add(profile.cluster);
						
						profile.frIndex = 0;
						profile.cluster = new Cluster();
					}
					else
					{
						if(profile.frIndex == 0)
						{
							String[] afterSplit = line.split(",");
							//System.out.println(line);
							profile.cluster.centralLon = Double.valueOf(afterSplit[0]);
							profile.cluster.centralLat = Double.valueOf(afterSplit[1]);
							//System.out.println(profile.cluster.centralLon+" "+profile.cluster.centralLat);
							profile.frIndex++;
						}
						else if(profile.frIndex == 1)
						{
							
								if(line.substring(0,line.indexOf(":")).equals("Working"))
								{
									for( ; !line.equals(" "); ) {
										profile.cluster.working.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
										//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
										//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
										line = line.substring(line.indexOf(")")+1,line.length());
										//System.out.println(line);
									}
									continue;
								}
									//profile.cluster.working
								if(line.substring(0,line.indexOf(":")).equals("Dining"))
								{
									for( ; !line.equals(" "); ) {
										profile.cluster.dining.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
	
										//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
										//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
										line = line.substring(line.indexOf(")")+1,line.length());
										//System.out.println(line);
									}
									continue;
								}
								
								if(line.substring(0,line.indexOf(":")).equals("Transportation"))
								{
									for( ; !line.equals(" "); ) {
										profile.cluster.transportation.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
	
										//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
										//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
										line = line.substring(line.indexOf(")")+1,line.length());
										//System.out.println(line);
									}
									continue;
								}
								
								if(line.substring(0,line.indexOf(":")).equals("Sporting"))
								{
									for( ; !line.equals(" "); ) {
										profile.cluster.sporting.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
	
										//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
										//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
										line = line.substring(line.indexOf(")")+1,line.length());
										//System.out.println(line);
									}
									continue;
								}
								
								if(line.substring(0,line.indexOf(":")).equals("Shopping"))
								{
									for( ; !line.equals(" "); ) {
										profile.cluster.shopping.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
	
										//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
										//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
										line = line.substring(line.indexOf(")")+1,line.length());
										//System.out.println(line);
									}
									continue;
								}
								
								if(line.substring(0,line.indexOf(":")).equals("Entertainment"))
								{
									for( ; !line.equals(" "); ) {
										profile.cluster.entertainment.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
										//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
										//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
										line = line.substring(line.indexOf(")")+1,line.length());
										//System.out.println(line);
									}
									continue;
								}
						
						}
					}
				}
				if(section == 5)
				{
					//System.out.println(line.substring(0,line.indexOf(":")));
					if(line.substring(0,line.indexOf(":")).equals("Working App "))
					{
						line = line.substring(line.indexOf(":")+1, line.length());
						String[] afterSplit = line.split(",");
						for(int i = 0; i < 30; i++)
							profile.workingApp[i] = afterSplit[i];
					}
					
					if(line.substring(0,line.indexOf(":")).equals("Dining App "))
					{
						line = line.substring(line.indexOf(":")+1, line.length());
						String[] afterSplit = line.split(",");
						for(int i = 0; i < 30; i++)
							profile.diningApp[i] = afterSplit[i];
					
						continue;
					}
					
					
					if(line.substring(0,line.indexOf(":")).equals("Transportation App "))
					{
						
						line = line.substring(line.indexOf(":")+1, line.length());
						String[] afterSplit = line.split(",");
						for(int i = 0; i < 30; i++)
							profile.transportationApp[i] = afterSplit[i];
					
					}
					
					if(line.substring(0,line.indexOf(":")).equals("Sporting App "))
					{
						line = line.substring(line.indexOf(":")+1, line.length());
						String[] afterSplit = line.split(",");
						for(int i = 0; i < 30; i++)
							profile.sportingApp[i] = afterSplit[i];
						continue;
					}
					
					if(line.substring(0,line.indexOf(":")).equals("Shopping App "))
					{
						line = line.substring(line.indexOf(":")+1, line.length());
						String[] afterSplit = line.split(",");
						for(int i = 0; i < 30; i++)
							profile.shoppingApp[i] = afterSplit[i];
						continue;
					}
					
					if(line.substring(0,line.indexOf(":")).equals("EntertainmentApp App "))
					{
						line = line.substring(line.indexOf(":")+1, line.length());
						String[] afterSplit = line.split(",");
						for(int i = 0; i < 30; i++)
							profile.entertainmentApp[i] = afterSplit[i];
					
					}
				}
				if(section == 6)
				{
					if(line.substring(0,line.indexOf(":")).equals("Working"))
					{
						for( ; !line.equals(" "); ) {
							profile.wTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
							//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
							//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
							line = line.substring(line.indexOf(")")+1,line.length());
							//System.out.println(line);
						}
						continue;
					}
					
					if(line.substring(0,line.indexOf(":")).equals("Dining"))
					{
						for( ; !line.equals(" "); ) {
							profile.dTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
							//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
							//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
							line = line.substring(line.indexOf(")")+1,line.length());
							//System.out.println(line);
						}
						continue;
					}
					
					if(line.substring(0,line.indexOf(":")).equals("Transportation"))
					{
						for( ; !line.equals(" "); ) {
							profile.tTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
							//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
							//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
							line = line.substring(line.indexOf(")")+1,line.length());
							//System.out.println(line);
						}
						continue;
					}
					
					if(line.substring(0,line.indexOf(":")).equals("Entertainment"))
					{
						for( ; !line.equals(" "); ) {
							profile.eTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
							//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
							//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
							line = line.substring(line.indexOf(")")+1,line.length());
							//System.out.println(line);
						}
						continue;
					}
					
					if(line.substring(0,line.indexOf(":")).equals("Sporting"))
					{
						for( ; !line.equals(" "); ) {
							profile.spTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
							//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
							//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
							line = line.substring(line.indexOf(")")+1,line.length());
							//System.out.println(line);
						}
						continue;
					}
				
					if(line.substring(0,line.indexOf(":")).equals("Shopping"))
					{
						for( ; !line.equals(" "); ) {
							profile.shTimeDistribution.put(Integer.valueOf(line.substring(line.indexOf("(")+1,line.indexOf(","))), Integer.valueOf(line.substring(line.indexOf(",")+1,line.indexOf(")"))));
							//System.out.println(line.substring(line.indexOf("(")+1,line.indexOf(",")));
							//System.out.println(line.substring(line.indexOf(",")+1,line.indexOf(")")));
							line = line.substring(line.indexOf(")")+1,line.length());
							//System.out.println(line);
						}
						continue;
					}
				}
			}
		}
		catch(Exception e)
		{
			//System.out.println("dddd");
			int a = args[1].indexOf(" ", 0);
			int b = args[1].indexOf("-", a);
			int hour = Integer.valueOf(args[1].substring(a+1,b));
			if(hour>=7 && hour<10)	
				System.out.println("{\"Transportation\": 100.0}");
    		else if((hour>=10 && hour<12) || (hour>=13 && hour<17))
    			System.out.println("{\"Working\": 100.0}");
    		else if((hour>=12 && hour<13) || (hour>=17 && hour<20))
    			System.out.println("{\"Dining\": 100.0}");
    		else if(hour>=20 || hour<24)
    			System.out.println("{\"Entertainment\": 100.0}");
			
			return;
		}
		stopTime = System.currentTimeMillis();
		elapsedTime += stopTime - startTime;
		
		

		/* giving software score for each file */	
		
		Parser parser = new Parser();
	    String softwareFileName = args[1];     	
	    SoftwarePhase softwarePhase = new SoftwarePhase();
	    
	    softwarePhase.testing(softwareFileName, profile, 0, elapsedTime);
	    
		/* giving software score & testing */

		
		/* giving location & weighted table score for each file */
		parser = new Parser();
	    String hardwareFileName = args[2];    	
	    // §PÂ_  logger version
	    String category = "V[1-2]+";
	    Pattern pattern = Pattern.compile(category);
	    Matcher matcher = pattern.matcher(hardwareFileName);
	    String version = null;
	    boolean matchFound = matcher.find();
	    if(matchFound)
	    	version = matcher.group();
	    if(parameter.loggerVersion.equals("V2"))
	    	version = "V2";		    
	    int value = parser.testing(hardwareFileName, profile, version, 0, elapsedTime);


		
			
		double scoreForSoftware[] =  new double[6];
		double scoreForLocation[] =  new double[6];
		double scoreForDistributionMatrix[] =  new double[6];
		double scoreForTotal[] = new double[6];
		double totalSoftware = 0;
		double totalLocation = 0;
		double totalDistributionMatrix = 0;
		int total = 0, inference = -1;
			
//		System.out.println(profile.lable[0]);
//			
//		for(int j = 0; j < 6; j++)
//			System.out.print(profile.softwareScore[0][j]+" ");
//		System.out.println();
//		for(int j = 0; j < 6; j++)
//			System.out.print(profile.locationScore[0][j]+" ");
//		System.out.println();
//		for(int j = 0; j < 6; j++)
//			System.out.print(profile.distributionMatrixScore[0][j] +" ");			
//		System.out.print("\n"+profile.speed[0] +" ");
//			
//			System.out.println("\n"+profile.std[0] +" ");
			
			if(profile.speed[0] >= 40)
				inference = 2;
			else if(profile.std[0] >= 2.4)
				inference = 4;
			else
			{
				for(int j = 0; j < 6; j++) {
					totalSoftware += profile.softwareScore[0][j];
					totalLocation += profile.locationScore[0][j];
					totalDistributionMatrix += profile.distributionMatrixScore[0][j];
				}
				
				for(int j = 0; j < 6; j++) {
					if(totalSoftware != 0)
						scoreForSoftware[j] =  (double)profile.softwareScore[0][j] / totalSoftware;
					else
						scoreForSoftware[j] = 0;
					
					if(totalLocation != 0)
						scoreForLocation[j] =  (double)profile.locationScore[0][j] / totalLocation;
					else
						scoreForLocation[j] = 0;
					
					if(totalDistributionMatrix != 0)
						scoreForDistributionMatrix[j] =  (double)profile.distributionMatrixScore[0][j] / totalDistributionMatrix;
					else
						scoreForDistributionMatrix[j] = 0;

				}

				// sum score
				for(int j = 0; j < 6; j++) {
					
					scoreForTotal[j] += scoreForSoftware[j] + scoreForLocation[j] + scoreForDistributionMatrix[j];  
				}
//				for(int j = 0; j < 6; j++)
//					System.out.print(scoreForTotal[j] +" ");
//				System.out.println();
				
			//System.out.println();
			
		    startTime = System.currentTimeMillis();
			double maxValue = 0;
			for(int j = 0; j < 6; j++) {
				if(scoreForTotal[j] > maxValue)
				{
						inference = j;
						maxValue = scoreForTotal[j];
				}
			}
			String str  =  "{\"Dining\": 50.0, \"Transportation\": 100}";
			if(inference == 0)
				System.out.println("{\"Working\": 100.0}");
			else if(inference == 1)
				System.out.println("{\"Dining\": 100.0}");
			else if(inference == 2)
				System.out.println("{\"Transportation\": 100.0}");
			else if(inference == 3)
				System.out.println("{\"Entertainment\": 100.0}");
			else if(inference == 4)
				System.out.println("{\"Sporting\": 100.0}");
			else if(inference == 5)
				System.out.println("{\"Shopping\": 100.0}");
			else
			{
				int a = args[1].indexOf(" ", 0);
				int b = args[1].indexOf("-", a);
				int hour = Integer.valueOf(args[1].substring(a+1,b));
				if(hour>=7 && hour<10)	
					System.out.println("{\"Transportation\": 100.0}");
	    		else if((hour>=10 && hour<12) || (hour>=13 && hour<17))
	    			System.out.println("{\"Working\": 100.0}");
	    		else if((hour>=17 && hour<20) || (hour>=12 && hour<13))
	    			System.out.println("{\"Dining\": 100.0}");
	    		else if(hour>=20 && hour<24)
	    			System.out.println("{\"Entertainment\": 100.0}");
			}
			
			//System.out.println("\n===============================");
			
			
			

		}
	}


}
