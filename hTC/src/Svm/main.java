package Svm;
import java.io.IOException;



public class main {
	
	public static String[] imei = {
		//"353567051351832"
		//"353567051351956"
		"353567051352475"
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
		//"864690022758703"

	};
	
	public static void main(String[] args) throws Exception
	{
		Runtime runtime = Runtime.getRuntime();
	    // Run the garbage collector
	    runtime.gc();
	    // Calculate the used memory
	    long memory = runtime.totalMemory() - runtime.freeMemory();
	    System.out.println("Used memory is Mbytes: " + (double)memory/1048576);
		float cost = 1;
		Information inform = new Information();
		
		for(int i =0;i < 10;i++) { /* cost range */
			try {
				   String[] trainArgs = {"D:\\STAIM\\input\\libSVM\\Training\\"+imei[0]+".txt","D:\\STAIM\\input\\libSVM\\SVM Optimal\\"+imei[0]+".model"};//directory of training file  
				   svm_train.main(trainArgs, cost);
				   
				   //			   svm_train.main(trainArgs);
			       
			       
			    
			        String[] testArgs = {"D:\\STAIM\\input\\libSVM\\Testing\\"+imei[0]+".txt", "D:\\STAIM\\input\\libSVM\\SVM Optimal\\"+imei[0]+".model", "D:\\STAIM\\input\\libSVM\\default"+imei[0]+".result"};//directory of test file, model file, result file  
			    
					svm_predict.main(testArgs, inform, cost);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			cost+=1;
		}
		System.out.println("Best Accuracy: "+inform.O_ACCURACY);
		System.out.println("Best Cost: "+inform.O_COST);
		
				
		}
	
	

		 
}
