package TrainingTesting;


public class Parameter {
	
	public static String[] FOLDERS={
	
		//"353567051351832"
		//"353567051351956",
		//"353567051352475",
		//"353567051353648",
		//"353567051354810",
		//"353567051354901",
		//"353567051355254",
		//"355027051966921",
		//"355027054515550",
		//"355387051404228",
		//"355859056961972",
		//"356440047806292",
		//"863360029004219", 
		//"864690022758703"
		
		//"352241062477314",
		//"354855061711965",
		//"355387051404228",
		//"356063057559765",
		//"865312025215222"
	}; 
	

	// 調整六個參數 xx~xx%
	//public static String Software_path = "D:\\STAIM\\input\\cross_validation\\0_20\\Software_Training\\";
	//public static String Hardware_path = "D:\\STAIM\\input\\cross_validation\\0_20\\Hardware_Training\\";
	
	// 原始資料的路徑
	public static String Software_path = "C:\\Users\\Lai\\Desktop\\new_data\\htc_logdata_withLabel_software\\";
	public static String Hardware_path = "C:\\Users\\Lai\\Desktop\\new_data\\htc_logdata_withLabel\\";
	
	// 將原始資料切成training and testing data的路徑
	public static String SoftwareTraining_path = "C:\\Users\\Lai\\Desktop\\new_data\\Software_Training\\";
	public static String HardwareTraining_path = "C:\\Users\\Lai\\Desktop\\new_data\\Hardware_Training\\";
	public static String SoftwareTesting_path = "C:\\Users\\Lai\\Desktop\\new_data\\Software_Testing\\";
	public static String HardwareTesting_path = "C:\\Users\\Lai\\Desktop\\new_data\\Hardware_Testing\\";
	
	
	// 隨機挑選training and testing data, e.g., 0.8 = 80% training data and 20% testing data
	public static double training = 0.8; 
	
	// 將training data做cross validation, e.g.,  Floor = 0.8, Celling = 1 就是將所有training data之中的後20%的training data抽取出來
	public static double crossValidationCelling = 1;
	public static double crossValidationFloor = 0.8;
}
