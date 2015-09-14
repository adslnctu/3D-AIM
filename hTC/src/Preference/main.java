package Preference;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {
	
	
	
	public static String[] imei = {
		//"353567051351832"
		//"353567051351956"
		//"353567051352475"
		//"353567051353648"
		//"353567051354810"
		//"353567051354901"
		//"353567051355254"
		//"355027051966921"
		//"355027054515550"
		//"355387051404228"
		//"355859056961972"
		//"356440047806292"
		//"863360029004219"
		"864690022758703"

	};
	public static void main(String[] args) throws Exception
	{
		long startTime =  System.currentTimeMillis();
    	
		Runtime runtime = Runtime.getRuntime();
 	    // Run the garbage collector
 	    runtime.gc();
 	    // Calculate the used memory
 	    long memory = runtime.totalMemory() - runtime.freeMemory();
		 System.out.println("[Testing phase] Used memory is Mbytes: " + (double)memory/1048576);
		double factorMatrix[][] = {
				//{0.33,0.33,0.33},
				{1,0,0},
				{0,1,0},
				{0,0,1},
				//{0,0,0}
				//{0.1,0.8,0.1},
				//{0.1,0.8,0.1},
				//{0.1,0.1,0.8},
				//{0.2,0.4,0.4},
				//{0.4,0.2,0.4},
				//{0.4,0.4,0.2},
				//{0.33,0.33,0.33},
				
		};
		double theHighestCoefficient[] = new double [3];
		double theHighestScore = 0;
		double theHighestHit = 0;
		int index = 0;
//		for(int it = 0; it < 3; it++) {
		// brute force
		for(int it_a = 0; it_a <= 10; it_a++) {
			for(int it_b = 0; it_b <= 10; it_b++) {
				
				
				int dTotal = 0;
				int wTotal = 0;
				int tTotal = 0;
				int shTotal = 0;
				int spTotal = 0;
				int eTotal = 0;
				
				int dHit = 0;
				int wHit = 0;
				int tHit = 0;
				int shHit = 0;
				int spHit = 0;
				int eHit = 0;
				
				double a = 0, b = 0, c = 0;
				// brute force
				a = (double)it_a * 0.1;
				b = (double)it_b * 0.1;
				c = 1 - a - b;
				if(a+b>=1.1)
					break;
				// inference ability
//				if(it == 3)
//				{
//					double sum = 0;
//					sum = factorMatrix[3][0]+factorMatrix[3][1]+factorMatrix[3][2];
//					factorMatrix[3][0] = factorMatrix[3][0]/sum;
//					factorMatrix[3][1] = factorMatrix[3][1]/sum;
//					factorMatrix[3][2] = factorMatrix[3][2]/sum;
//				}
				
				//File reader = new File("D:\\STAIM\\input\\preference\\353567051351832\\score.txt");
				char[] buffer = new char[512];
				int lineCounter = 0;
				int unit = 0;
				int unitCounter = 0;
				int hit = 0;
				int totalFile = 0;
				String actual = null;
				String predict = null;
				
				
				double scoreForLocation[] = new double[6];
				double scoreForApp[] = new double[6];
				double scoreForMotion[] = new double[6];
				double scoreForTotal[] = new double[6];
				for (String line : Files.readAllLines(Paths.get("D:\\STAIM\\input\\preference\\"+imei[0]+"\\score.txt"))) {
				    //System.out.println(line);
					if(unitCounter == 5 && unit == 1)
				    {
						
						String[] splited = line.split("\\s+");
						for(int i =0; i < splited.length;i++) {
							scoreForMotion[i] = Double.valueOf(splited[i]);
							//System.out.print(scoreForMotion[i]+" ");
						}
							
						//System.out.println();
		//				for(int j = 0; j < 6; j++) {
		//				double max = 0;
		//				max = Math.max(scoreForApp[j]*a, scoreForLocation[j]*b);
		//				max = Math.max(max, scoreForMotion[j]*c);
		//				scoreForTotal[j] = max;
		//				//System.out.print(scoreForTotal[j]+ " ");
		//			}
						
						double sumOfLocation = 0, sumOfMotion = 0, sumOfSoftware = 0;
						double entropyApp = 0, entropyLocation = 0, entropyMotion = 0;;
						// calculate entropy
//						for(int i = 0; i < 6; i++) {
//							sumOfSoftware += scoreForApp[i];
//							sumOfMotion += scoreForMotion[i];
//							sumOfLocation += scoreForLocation[i];
//						}
//						if(sumOfLocation == 0)
//							entropyLocation = 0;
//						else
//						{
//							for(int i = 0; i < 6; i++) {
//								if(scoreForLocation[i]!=0)
//									entropyLocation+= scoreForLocation[i]*Math.log10(scoreForLocation[i]);
//							}
//							entropyLocation = 1+entropyLocation;
//						}
//						
//						if(sumOfMotion == 0)
//							entropyMotion = 0;
//						else
//						{
//							for(int i = 0; i < 6; i++) {
//								if(scoreForMotion[i]!=0)
//									entropyMotion+= scoreForMotion[i]*Math.log10(scoreForMotion[i]);
//							}
//							entropyMotion = 1+entropyMotion;
//						}
//						
//						if(sumOfSoftware == 0)
//							entropyApp = 0;
//						else
//						{
//							for(int i = 0; i < 6; i++) {
//								if(scoreForApp[i]!=0)
//									entropyApp+= scoreForApp[i]*Math.log10(scoreForApp[i]);
//							}
//							entropyApp = 1 + entropyApp;
//						}
//						a = entropyApp/(entropyApp+entropyLocation+entropyMotion);
//						b = entropyLocation/(entropyApp+entropyLocation+entropyMotion);
//						c = entropyMotion/(entropyApp+entropyLocation+entropyMotion);

						for(int i = 0; i < 6; i++) {
							//scoreForTotal[i] = factorMatrix[it][0] * scoreForApp[i] + factorMatrix[it][1]*scoreForLocation[i] +factorMatrix[it][2]*scoreForMotion[i];
							scoreForTotal[i] = a * scoreForApp[i] + b*scoreForLocation[i] +c*scoreForMotion[i];
	
							//System.out.print(scoreForTotal[i]+" ");
						}
						//System.out.println(entropyApp+" "+entropyLocation+" "+entropyMotion+" "+a+" "+b+" "+c);
						
						double maxValue = 0;
						int inference = -1;
						for(int j = 0; j < 6; j++) {
							if(scoreForTotal[j] > maxValue)
							{
								inference = j;
								maxValue = scoreForTotal[j];
							}
						}
		
						if(actual.equals("Working"))
							wTotal++;
						if(actual.equals("Dining"))
							dTotal++;
						if(actual.equals("Transportation"))
							tTotal++;
						if(actual.equals("Entertainment"))	
							eTotal++;
						if(actual.equals("Sporting"))
							spTotal++;
						if(actual.equals("Shopping"))
							shTotal++;
								
						//System.out.println("============");
						if(actual.equals("Working") && inference == 0)
						{
							wHit++;
							hit++;
							
						}	
						else if(actual.equals("Dining") && inference == 1)
						{
							dHit++;
							hit++;
							
						}
						else if(actual.equals("Transportation") && inference == 2)
						{
							tHit++;
							hit++;
							
						}
						else if(actual.equals("Entertainment") && inference == 3)
						{
							eHit++;
							hit++;
							
						}
						else if(actual.equals("Sporting") && inference == 4)
						{
							spHit++;
							hit++;
							
						}
						else if(actual.equals("Shopping") && inference == 5)
						{
							shHit++;
							hit++;
							
						}	
						else
						{
	//						for(int i = 0; i < 6;i++)
	//							System.out.print(scoreForApp[i]+" ");
	//						System.out.println();
	//						for(int i = 0; i < 6;i++)
	//							System.out.print(scoreForLocation[i]+" ");
	//						System.out.println();
	//						for(int i = 0; i < 6;i++)
	//							System.out.print(scoreForMotion[i]+" ");
	//						System.out.println();
	//						
	//						if(inference == 0)
	//							System.out.println(actual+" Working");
	//						if(inference == 1)
	//							System.out.println(actual+" Dining");
	//						if(inference == 2)
	//							System.out.println(actual+" Transportation");
	//						if(inference == 3)
	//							System.out.println(actual+" Entertainment");
	//						if(inference == 4)
	//							System.out.println(actual+" Sporting");
	//						if(inference == 5)
	//							System.out.println(actual+" Shopping");
						}
				    	unitCounter++;		    		
				    }
					
					if(unitCounter == 4 && unit == 1)
				    {
						
						String[] splited = line.split("\\s+");
						for(int i =0; i < splited.length;i++) {
							scoreForLocation[i] = Double.valueOf(splited[i]);
							//System.out.print(scoreForLocation[i]+" ");
						}
							
						//System.out.println();
				    	unitCounter++;		    		
				    }
					
					if(unitCounter == 3 && unit == 1)
				    {
						
						String[] splited = line.split("\\s+");
						for(int i =0; i < splited.length;i++) {
							scoreForApp[i] = Double.valueOf(splited[i]);
							//System.out.print(scoreForApp[i]+" ");
						}
							
						//System.out.println();
				    	unitCounter++;		    		
				    }
					
					if(unitCounter == 2 && unit == 1)
				    {
						double std = Double.valueOf(line);
						
				    	//System.out.println(std);
				    	unitCounter++;		    		
				    }
					
					if(unitCounter == 1 && unit == 1)
				    {
						double speed = Double.valueOf(line);
						
				    	//System.out.println(speed);
				    	unitCounter++;
				    	if(speed >=  40.0)
				    	{
				    		predict = "Transportation";
				    		if(predict.equals(actual))
				    			hit++;
				    		unit = 0;
				    	}
				    		
				    }
					
				    if(unitCounter == 0 && unit == 0)
				    {
				    	actual = line;
				    	
				    		//System.out.println(line);
				    	unitCounter++;
				    	unit = 1;
				    }
				    
				    if(line.equals("==============================="))
				    {
				    	totalFile++;
				    	unitCounter = 0;
				    	unit = 0;
				    	
				    }
				    lineCounter++;
				}
//				if(it != 3)
//					factorMatrix[3][it] = hit;
			//System.out.println((double)hit/(double)totalFile+" "+hit+" "+totalFile+" "+factorMatrix[it][0]+" "+factorMatrix[it][1]+" "+factorMatrix[it][2]);
				
				// brute force
				System.out.println((double)hit/(double)totalFile+" "+hit+" "+totalFile+" "+a+" "+b+" "+c);
				System.out.println("Working: " + wHit +" "+wTotal);
				System.out.println("Dining: "+ dHit +" "+dTotal);
				System.out.println("Transporation: "+ tHit +" "+tTotal);
				System.out.println("Enter: "+ eHit +" "+eTotal);
				System.out.println("Shopping: "+ shHit +" "+shTotal);
				System.out.println("Sporting: "+ spHit +" "+spTotal);
				System.out.println("============================================");
				if((double)hit/(double)totalFile > theHighestScore)
				{
					theHighestScore = (double)hit/(double)totalFile;
					theHighestCoefficient[0] = a;
					theHighestCoefficient[1] = b;
					theHighestCoefficient[2] = c;
					theHighestHit = hit;
				}
			}
		}
//		}
		// brute force
		System.out.println(theHighestScore+" "+theHighestHit+" "+theHighestCoefficient[0]+" "+theHighestCoefficient[1]+" "+theHighestCoefficient[2]);
		long stopTime =  System.currentTimeMillis();
    	long elapsedTime = stopTime - startTime;
    	System.out.println("Time: "+elapsedTime);
		runtime = Runtime.getRuntime();
 	    // Run the garbage collector
 	    runtime.gc();
 	    // Calculate the used memory
 	   memory = runtime.totalMemory() - runtime.freeMemory();
		 System.out.println("[Testing phase] Used memory is Mbytes: " + (double)memory/1048576);
	}
}
