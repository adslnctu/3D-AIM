package RBaysian;

import java.util.HashMap;
import java.util.Map;

public class Parameter {
	
	// 0 for bayesian, 1 for svm
	public static int format = 0;
	public int [] training_file_no = new int[700];
	public int training_file_counter = 0;
//	4
//	1
//	230
//	3
//	13
//	6
//	3
//	22
//	28


	public static String[] imei={
		//4
		"353567051351832"
		///1
		//"353567051351956",
		//230
		//"353567051352475",
		//3
		//"353567051353648",
		//13
		//"353567051354810",
		//6
		//"353567051354901",
		//3
		//"353567051355254",
		//22
		//"355027051966921",
		//28
		//"355027054515550",
		//3
		//"355387051404228",
		//"355859056961972",
		//2
		//"356440047806292",
		
		//"863360029004219", 
		//"864690022758703"
	}; 
	
	
	
	public static String[] hardwareTraining = {
		//"D:\\STAIM\\input\\Hardware_Training\\"+imei[0]
		"D:\\STAIM\\input\\learning_curve\\20\\Hardware_Training\\"+imei[0] 
		
		// 4026 GPS
		//"D:\\STAIM\\input\\Hardware_Training\\353567051351832"
		// 891 GPS
		//"D:\\STAIM\\input\\Hardware_Training\\353567051351956"
		// 67661 gps
		//"D:\\STAIM\\input\\Hardware_Training\\353567051352475" 
		// 1330, 
		//"D:\\STAIM\\input\\Hardware_Training\\353567051353648"
		// 4101 gps
		//"D:\\STAIM\\input\\Hardware_Training\\353567051354810"
		// 0 gps
		//"D:\\STAIM\\input\\Hardware_Training\\353567051354901"
		// 0 gps
		//"D:\\STAIM\\input\\Hardware_Training\\353567051355254"
		// 2287 gps
		//"D:\\STAIM\\input\\Hardware_Training\\355027051966921"
		// 550 gps,
		//"D:\\STAIM\\input\\Hardware_Training\\355027054515550"
		// 39 gps,
		//"D:\\STAIM\\input\\Hardware_Training\\355387051404228"
		// 0 GPS
		//"D:\\STAIM\\input\\Hardware_Training\\355859056961972"
		// 974 gps, 
		//"D:\\STAIM\\input\\Hardware_Training\\356440047806292"
		// 0 GPS
		//"D:\\STAIM\\input\\Hardware_Training\\863360029004219"
		// 3656 GPS,
		//"D:\\STAIM\\input\\Hardware_Training\\864690022758703"	
	};
	
	public static String[] hardwareTesting = {
		//"D:\\STAIM\\input\\Hardware_Testing\\"+imei[0]
		"D:\\STAIM\\input\\learning_curve\\20\\Hardware_Testing\\"+imei[0] 
		
		//"D:\\STAIM\\input\\Hardware_Testing\\353567051351956"
		//"D:\\STAIM\\input\\Hardware_Testing\\353567051352475" 
		//"D:\\STAIM\\input\\Hardware_Testing\\353567051353648"
		//"D:\\STAIM\\input\\Hardware_Testing\\353567051354810"
		//"D:\\STAIM\\input\\Hardware_Testing\\353567051354901"
		//"D:\\STAIM\\input\\Hardware_Testing\\353567051355254"
		//"D:\\STAIM\\input\\Hardware_Testing\\355027051966921",
		//"D:\\STAIM\\input\\Hardware_Testing\\355027054515550"
		//"D:\\STAIM\\input\\Hardware_Testing\\355387051404228"
		//"D:\\STAIM\\input\\Hardware_Testing\\355859056961972"
		//"D:\\STAIM\\input\\Hardware_Testing\\356440047806292"
		//"D:\\STAIM\\input\\Hardware_Testing\\863360029004219"
		//"D:\\STAIM\\input\\Hardware_Testing\\864690022758703"
	};
	
	public static String[] softwareTraining = {
	//"D:\\STAIM\\input\\Software_Training\\"+imei[0]
	"D:\\STAIM\\input\\learning_curve\\20\\Software_Training\\"+imei[0] 
		
		
		
	//"D:\\STAIM\\input\\Software_Training\\353567051351956"
	//"D:\\STAIM\\input\\Software_Training\\353567051352475" 
	//"D:\\STAIM\\input\\Software_Training\\353567051353648"
	//"D:\\STAIM\\input\\Software_Training\\353567051354810"
	//"D:\\STAIM\\input\\Software_Training\\353567051354901"
	//"D:\\STAIM\\input\\Software_Training\\353567051355254"
	//"D:\\STAIM\\input\\Software_Training\\355027051966921",
	//"D:\\STAIM\\input\\Software_Training\\355027054515550"
	//"D:\\STAIM\\input\\Software_Training\\355387051404228"
	//"D:\\STAIM\\input\\Software_Training\\355859056961972"
	//"D:\\STAIM\\input\\Software_Training\\356440047806292"
	//"D:\\STAIM\\input\\Software_Training\\863360029004219"
	//"D:\\STAIM\\input\\Software_Training\\864690022758703"		
	};
	
	public static String[] softwareTesting = {
		//"D:\\STAIM\\input\\Software_Testing\\"+imei[0]
		//"D:\\STAIM\\input\\learning_curve\\testing\\Software_Testing\\"+imei[0] 
		"D:\\STAIM\\input\\learning_curve\\20\\Software_Testing\\"+imei[0] 
		
		
		//"D:\\STAIM\\input\\Software_Testing\\353567051351956"
		//"D:\\STAIM\\input\\Software_Testing\\353567051352475" 
		//"D:\\STAIM\\input\\Software_Testing\\353567051353648"
		//"D:\\STAIM\\input\\Software_Testing\\353567051354810"
		//"D:\\STAIM\\input\\Software_Testing\\353567051354901"
		//"D:\\STAIM\\input\\Software_Testing\\353567051355254"
		//"D:\\STAIM\\input\\Software_Testing\\355027051966921",
		//"D:\\STAIM\\input\\Software_Testing\\355027054515550"
		//"D:\\STAIM\\input\\Software_Testing\\355387051404228"
		//"D:\\STAIM\\input\\Software_Testing\\355859056961972"
		//"D:\\STAIM\\input\\Software_Testing\\356440047806292"
		//"D:\\STAIM\\input\\Software_Testing\\863360029004219"
		//"D:\\STAIM\\input\\Software_Testing\\864690022758703"		
		};
	
	public static String[] softwareStatistics = {
		"D:\\STAIM\\input\\Software_new\\"+imei[0]
		
		
		//"D:\\STAIM\\input\\Software_new\\353567051351956"
		//"D:\\STAIM\\input\\Software_new\\353567051352475" 
		//"D:\\STAIM\\input\\Software_new\\353567051353648"
		//"D:\\STAIM\\input\\Software_new\\353567051354810"
		//"D:\\STAIM\\input\\Software_new\\353567051354901"
		//"D:\\STAIM\\input\\Software_new\\353567051355254"
		//"D:\\STAIM\\input\\Software_new\\355027051966921",
		//"D:\\STAIM\\input\\Software_new\\355027054515550"
		//"D:\\STAIM\\input\\Software_new\\355387051404228"
		//"D:\\STAIM\\input\\Software_new\\355859056961972"
		//"D:\\STAIM\\input\\Software_new\\356440047806292"
		//"D:\\STAIM\\input\\Software_new\\863360029004219"
		//"D:\\STAIM\\input\\Software_new\\864690022758703"		
	};
	
	public static String[] uid = {
		imei[0]+".txt"
		//"353567051351956.txt"
		//"353567051352475.txt" 
		//"353567051353648.txt"
		//"353567051354810.txt"
		//"353567051354901.txt"
		//"353567051355254.txt"
		//"355027051966921.txt",
		//"355027054515550.txt"
		//"355387051404228.txt"
		//"355859056961972.txt"
		//"356440047806292.txt"
		//"863360029004219.txt"
		//"864690022758703.txt"
		
	};
	
	public static String[] R_column = {
		//"353567051351832.txt" 91
		//"353567051351956.txt" 58
		//"353567051352475.txt" 168
		//"353567051353648.txt" 156
		//"353567051354810.txt" 134
		//"353567051354901.txt" 84
		//"353567051355254.txt" 81
		//"355027051966921.txt" 98
		//"355027054515550.txt" 116
		//"355387051404228.txt" 69
		//"355859056961972.txt" 52
		//"356440047806292.txt" 66
		//"863360029004219.txt" 70
		//"864690022758703.txt" 95
		
	};
	
	public Parameter()
	{
		for(int i = 0; i < 700;i++) {
			outputTraining[i] = "";
			outputTesting[i] = "";
		}
		
	}
	
	Map<String,Integer> appUsage = new HashMap<String,Integer>();
	public String loggerVersion = "V2";
	public String outputTraining[] = new String[700];
	public String outputTesting[] = new String[700];
	
	public String motionDataTraining[] = new String[700];
	public String motionDataTesting[] = new String[700];
	//public int totalFile = 0;
	
}
