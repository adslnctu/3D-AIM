/*

	���software data�Mhardware data���L���@�P���a��
	�ɮ׭ӼơA�ɶ������C
	
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
	    	
	        File file = new File(parameter.Hardware_path+parameter.FOLDERS[index]); //Ū���o�Ӹ�Ƨ��A�n�O�o�N����Ƨ���m�P��java file�̭�
		    ArrayList<String> fileList = new ArrayList<String>();
		    if(file.isDirectory()) //�p�GfŪ�쪺�O��Ƨ��A�N�|����
	        {
	        	//System.out.println("filename : " + file.getName()); //�L�X�ڭ̩�Ū�쪺��Ƨ�
	            String []s = file.list(); //�ŧi�@��list
	            //System.out.println("size : " + s.length); //�L�X��Ƨ��̪��ɮ׭Ӽ�
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //�N�ɦW�@�@�s��fileList�ʺA�}�C��
	                s[i] = s[i].substring(1, s[i].length());
	                //System.out.println(s[i]);
	                HardwareFile.put(s[i], 0);
	            }
	        }
		    
		    file = new File(parameter.Software_path+parameter.FOLDERS[index]);
		    if(file.isDirectory()) //�p�GfŪ�쪺�O��Ƨ��A�N�|����
	        {
	        	//System.out.println("filename : " + file.getName()); //�L�X�ڭ̩�Ū�쪺��Ƨ�
	            String []s = file.list(); //�ŧi�@��list
	            //System.out.println("size : " + s.length); //�L�X��Ƨ��̪��ɮ׭Ӽ�
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //�N�ɦW�@�@�s��fileList�ʺA�}�C��
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

		    
		    file = new File(parameter.Hardware_path+parameter.FOLDERS[index]); //Ū���o�Ӹ�Ƨ��A�n�O�o�N����Ƨ���m�P��java file�̭�
		    if(file.isDirectory()) //�p�GfŪ�쪺�O��Ƨ��A�N�|����
	        {
	        	//System.out.println("filename : " + file.getName()); //�L�X�ڭ̩�Ū�쪺��Ƨ�
	            String []s = file.list(); //�ŧi�@��list
	            //System.out.println("size : " + s.length); //�L�X��Ƨ��̪��ɮ׭Ӽ�
	            for(int i=0; i < s.length; i++)
	            {
	                //System.out.println(s[i]);
	                fileList.add(s[i]); //�N�ɦW�@�@�s��fileList�ʺA�}�C��
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
