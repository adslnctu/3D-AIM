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
	

	// �վ㤻�ӰѼ� xx~xx%
	//public static String Software_path = "D:\\STAIM\\input\\cross_validation\\0_20\\Software_Training\\";
	//public static String Hardware_path = "D:\\STAIM\\input\\cross_validation\\0_20\\Hardware_Training\\";
	
	// ��l��ƪ����|
	public static String Software_path = "C:\\Users\\Lai\\Desktop\\new_data\\htc_logdata_withLabel_software\\";
	public static String Hardware_path = "C:\\Users\\Lai\\Desktop\\new_data\\htc_logdata_withLabel\\";
	
	// �N��l��Ƥ���training and testing data�����|
	public static String SoftwareTraining_path = "C:\\Users\\Lai\\Desktop\\new_data\\Software_Training\\";
	public static String HardwareTraining_path = "C:\\Users\\Lai\\Desktop\\new_data\\Hardware_Training\\";
	public static String SoftwareTesting_path = "C:\\Users\\Lai\\Desktop\\new_data\\Software_Testing\\";
	public static String HardwareTesting_path = "C:\\Users\\Lai\\Desktop\\new_data\\Hardware_Testing\\";
	
	
	// �H���D��training and testing data, e.g., 0.8 = 80% training data and 20% testing data
	public static double training = 0.8; 
	
	// �Ntraining data��cross validation, e.g.,  Floor = 0.8, Celling = 1 �N�O�N�Ҧ�training data��������20%��training data����X��
	public static double crossValidationCelling = 1;
	public static double crossValidationFloor = 0.8;
}
