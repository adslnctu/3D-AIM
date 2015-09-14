/*

	比對software data和hardware data有無不一致的地方
	檔案個數，時間等等。
	
*/
package Hard_Soft_Consistent;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class main {
	
	public static void main(String[] args) throws Exception   {
	    System.out.println("start!\n");
	    Parameter parameter = new Parameter();
	    
	    for(int index = 0; index < parameter.FOLDERS.length; index++) {
	    
	    	Map HardwareFile =  new Hashtable();
	    	Map SoftwareFile =  new Hashtable();
	    	
	        File file = new File(parameter.Hardware_path+parameter.FOLDERS[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
		    ArrayList<String> fileList = new ArrayList<String>();
		    if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	                s[i] = s[i].substring(1, s[i].length());
	                //System.out.println(s[i]);
	                HardwareFile.put(s[i], 0);
	            }
	        }
		    
		    file = new File(parameter.Software_path+parameter.FOLDERS[index]);
		    if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	                s[i] = s[i].substring(1, s[i].length());
	                if(HardwareFile.get(s[i]) == null)
            		{
	                	System.out.println(s[i]);
            		}
	                else
	                	SoftwareFile.put(s[i], 0);
	            }
	        }
		    
		    System.out.println("---------------");
		    System.out.println();

		    
		    file = new File(parameter.Hardware_path+parameter.FOLDERS[index]); //讀取這個資料夾，要記得將此資料夾放置同個java file裡面
		    if(file.isDirectory()) //如果f讀到的是資料夾，就會執行
	        {
	        	//System.out.println("filename : " + file.getName()); //印出我們所讀到的資料夾
	            String []s = file.list(); //宣告一個list
	            //System.out.println("size : " + s.length); //印出資料夾裡的檔案個數
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //將檔名一一存到fileList動態陣列裡
	                s[i] = s[i].substring(1, s[i].length());
	                if(SoftwareFile.get(s[i]) == null)
            		{
	                	System.out.println(s[i]);
            		}
	                
	            }
	        }
		    
		    
	    }
	}
}
