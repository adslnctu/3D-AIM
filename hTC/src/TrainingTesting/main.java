/*

	從原始檔案中，切割出training data與testing data
	
*/
package TrainingTesting;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public class main {
	
	public static void main(String[] args) throws Exception   {
	  
	    Parameter parameter = new Parameter();
	    for(int index = 0; index < parameter.FOLDERS.length ; index++) {
	    	File HardwareFile = new File(parameter.Hardware_path+parameter.FOLDERS[index]); 
			File SoftwareFile = new File(parameter.Software_path+parameter.FOLDERS[index]);
	    	ArrayList<String> HardwareFileList = new ArrayList<String>(); 
	    	ArrayList<String> SoftwareFileList = new ArrayList<String>();
	    	
			if(HardwareFile.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = HardwareFile.list(); //宣告一個list
	            System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i=0; i < s.length; i++)
	            {
	            	HardwareFileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            	//System.out.println(i+": "+s[i]);
	            }
	        }
			
			if(SoftwareFile.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = SoftwareFile.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i=0; i < s.length; i++)
	            {
	            	SoftwareFileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	            	//System.out.println(i+": "+s[i]);
	            }
	        }
			
			for(int i = 0; i < HardwareFileList.size(); i++)
	        {
				System.out.println(i+": "+HardwareFileList.get(i));
				Parser parser = new Parser();
	        	String hardwareFileName = parameter.Hardware_path+parameter.FOLDERS[index] + "\\" + HardwareFileList.get(i);
	        	String softwareFileName = parameter.Software_path+parameter.FOLDERS[index] + "\\" + SoftwareFileList.get(i);
	        	parser.InitializeHardware(hardwareFileName, parameter.FOLDERS[index] + "\\" + HardwareFileList.get(i));
	        	parser.InitializeSoftware(softwareFileName, parameter.FOLDERS[index] + "\\" + SoftwareFileList.get(i));
	        }
	    }
	    System.out.println("end!\n"); 
	}
}
