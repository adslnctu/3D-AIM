package Model;

public class Parameter {
	
	public static String[] FOLDERS={
		
		// version 1 (hardware)
		// 2498
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051351832",
		//10358
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051353556",
		//8681
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051353648",
		//GPS: 15598.0
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051354810",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051354935",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051351840",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051351956",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051352285",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051352392",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051352475",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051352525",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051353440",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051354752",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051354828",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051354943",
		//"D:\\STAIM\\input\\V1(from lalala)\\353567051355270",
		//"D:\\STAIM\\input\\V1(from lalala)\\354435050036417",
		//"D:\\STAIM\\input\\V1(from lalala)\\354435050195460",
		
//		// version 2 (hardware)
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051351832",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567050206540",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051351956",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051352475",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051353648",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051354810",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051354828",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051354901",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051354935",
//		"D:\\STAIM\\input\\V2(from lalala)\\353567051355254",
//		"D:\\STAIM\\input\\V2(from lalala)\\354435052172343",
//		"D:\\STAIM\\input\\V2(from lalala)\\355859056961972",
//		"D:\\STAIM\\input\\V2(from lalala)\\356440047806292"
		
		// Hardware_new
		//"D:\\STAIM\\input\\Hardware_new\\353567051351832"
		//"D:\\STAIM\\input\\Hardware_new\\353567050206540"
		//"D:\\STAIM\\input\\Hardware_new\\353567051351956"
		//"D:\\STAIM\\input\\Hardware_new\\353567051352475" 
		//"D:\\STAIM\\input\\Hardware_new\\353567051353648"
		//"D:\\STAIM\\input\\Hardware_new\\353567051354810"
		//"D:\\STAIM\\input\\Hardware_new\\353567051354828"
		//"D:\\STAIM\\input\\Hardware_new\\353567051354901"
		//"D:\\STAIM\\input\\Hardware_new\\353567051354935"
		//"D:\\STAIM\\input\\Hardware_new\\353567051355254"
		//"D:\\STAIM\\input\\Hardware_new\\354435052172343"
		//"D:\\STAIM\\input\\Hardware_new\\354833059525127"
		//"D:\\STAIM\\input\\Hardware_new\\355027051966921"
		//"D:\\STAIM\\input\\Hardware_new\\355027054515550"
		//"D:\\STAIM\\input\\Hardware_new\\355387051404228"
		//"D:\\STAIM\\input\\Hardware_new\\355859056961972"
		//"D:\\STAIM\\input\\Hardware_new\\356440047806292"
		//"D:\\STAIM\\input\\Hardware_new\\863360029004219"
		//"D:\\STAIM\\input\\Hardware_new\\863985028111613"
		//"D:\\STAIM\\input\\Hardware_new\\864690022758703"
		

		// Software_Testing
		
		//"D:\\STAIM\\input\\Software_Testing\\353567051351832"
		//"D:\\STAIM\\input\\Software_Testing\\353567051351956"
		//"D:\\STAIM\\input\\Software_Testing\\353567051352475" 
		//"D:\\STAIM\\input\\Software_Testing\\353567051353648"
		//"D:\\STAIM\\input\\Software_Testing\\353567051354810"
		//"D:\\STAIM\\input\\Software_Testing\\353567051354901"
		//"D:\\STAIM\\input\\Software_Testing\\353567051355254"
		//"D:\\STAIM\\input\\Software_Testing\\355027051966921"
		//"D:\\STAIM\\input\\Software_Testing\\355027054515550"
		//"D:\\STAIM\\input\\Software_Testing\\355387051404228"
		//"D:\\STAIM\\input\\Software_Testing\\355859056961972"
		//"D:\\STAIM\\input\\Software_Testing\\356440047806292"
		//"D:\\STAIM\\input\\Software_Testing\\863360029004219"
		//"D:\\STAIM\\input\\Software_Testing\\864690022758703"
		
		//D:\STAIM\input\cross_validation\0_20\Software_Training\353567051351832
		
		
	};
	
	// mean threshold setting
	public double[] sshMAX = {8,10,12};
	
	// std threshold setting
	public double[] sshSTD = {0.1};
	//public double[] sshSTD = {0.6};

	// hardware -> 1
	// software -> 2
	public int hard_soft = 1;
	
	// general score of selecting top k app -> 1
	// weighted score of selecting top k app -> 2
	public int G_W = 2;
	
	public String version = "V2";
	// lalala version 1 -> time is Date
	// lalala version 2 -> time is unix time
	
	// 0 -> package name
	// 1 -> category (不管是package name+category還是純category都選這個)
	public int category = 0;
	
	
	
}
