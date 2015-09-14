/***************************************************
 *  
 * OPTICS source code
 * 
 ***************************************************/
package AIM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.util.regex.Pattern;

public class Optics {
		public int gpsPointCounter = 0;
		//private ClusterPair cpair=new ClusterPair();
		public  Map<String,Vector<DataPoint>> ta=new TreeMap<String,Vector<DataPoint>>();

		private static final double EARTH_RADIUS = 6378137; 
		
	    class ComparatorDp implements Comparator<DataPoint>
	    {
	        public int compare(DataPoint arg0, DataPoint arg1) 
	        {
	            double temp=arg0.getReachableDistance()-arg1.getReachableDistance();
	            int a = 0;
	            if (temp < 0) 
	                a = -1;
	            else if(temp==0)
	                a = 0;
	            else
	            	a = 1;
	            return a;
	        }
	    }

	    public void startAnalysis(List<DataPoint> dataPoints, int ObjectNum, double radius, ArrayList<Cluster> clusters) throws IOException 
	    {
	        int total = 0, temp = 0;
	        Integer in = 0;
	        boolean flag = false;

	    	List<DataPoint> dpList = new ArrayList<DataPoint>(); 
	        List<DataPoint> dpQue = new ArrayList<DataPoint>();  

	        int data_point_name=0;
	     	double total_lat = 0.0, total_lon = 0.0;
	     	int count = 0;       

	     	
	     	List<DataPoint> avg_ll = new ArrayList<DataPoint>();
	     	
	        while (total < dataPoints.size()) 
	        {
	        	Vector<DataPoint> vp = new Vector<DataPoint>();
	        	data_point_name++;

	        	//first find center points;
	            if (isContainedInList(dataPoints.get(total), dpList) == -1 ) 
	            {
	                List<DataPoint> tmpDpList = isKeyAndReturnObjects(dataPoints.get(total), dataPoints, radius, ObjectNum);
	                if(tmpDpList != null && tmpDpList.size() > 0)
	                {
	                    DataPoint newDataPoint=new DataPoint(dataPoints.get(total));
	                    dpQue.add(newDataPoint);  
	                }
	            }
	            
	            
	            
	            Cluster cluster = new Cluster();
	            int clusterFlag = 0;
	            while (!dpQue.isEmpty()) 
	            {
	            	
	            	clusterFlag = 1;
	                DataPoint tempDpfromQ = dpQue.remove(0);
	                DataPoint newDataPoint = new DataPoint(tempDpfromQ);
	                dpList.add(newDataPoint);
	                List<DataPoint> tempDpList = isKeyAndReturnObjects(tempDpfromQ, dataPoints, radius, ObjectNum);
	                cluster.gpsPoint.add(newDataPoint);
	                vp.add(newDataPoint);

	              	count++;
	         		
	                flag = true;
	                
	                //System.out.println(newDataPoint.getLongitude()+" "+newDataPoint.getLatitude()+": "+newDataPoint.getActivity());	                
	                
	                gpsPointCounter++;
	                if (tempDpList != null && tempDpList.size() > 0) {
	                    for (int i = 0; i < tempDpList.size(); i++) {
	                        DataPoint tempDpfromList = tempDpList.get(i);
	                        int indexInList = isContainedInList(tempDpfromList, dpList);
	                        int indexInQ = isContainedInList(tempDpfromList, dpQue); 
	                        if (indexInList == -1) {
	                            if (indexInQ > -1) {
	                                int index = -1;
	                                for (DataPoint dataPoint : dpQue) {
	                                    index++;
	                                    if (index == indexInQ) {
	                                        if (dataPoint.getReachableDistance() > tempDpfromList
	                                                .getReachableDistance()) {
	                                            dataPoint
	                                                    .setReachableDistance(tempDpfromList
	                                                            .getReachableDistance());
	                                        }
	                                    }
	                                }
	                            } else {
	                                dpQue.add(new DataPoint(tempDpfromList));
	                            }
	                        }
	                    }

	                    Collections.sort(dpQue, new ComparatorDp());
	                }
	            }
	            if(clusterFlag == 1)
	            	clusters.add(cluster);
	            	
	            //System.out.println("------------------------------------------------------------");
	            ta.put(in.toString(), vp);
	            total++;
	            
	        	if(flag)
	        	{
	        		in++;
	              	temp = in-1;

	              	double avg_lat = total_lat/count;
	              	double avg_lon = total_lon/count; 
	                double [] ll = {avg_lat, avg_lon};
	                DataPoint ll_dataPoint = new DataPoint(ll, Integer.toString(data_point_name)); 
	              	avg_ll.add(ll_dataPoint);

	              
	              	total_lat = 0.0;
	              	total_lon = 0.0;  
	              	flag = false;
	         	    count = 0;
	            }
	        }
	        System.out.println(gpsPointCounter);
	  	    return;
	    }

	     public void displayDataPoints(List<DataPoint> dps){
	         for(DataPoint dp: dps){
	             System.out.println(dp.getName()+":"+dp.getReachableDistance());
	         }
	     }

	    
	    private int isContainedInList(DataPoint dp, List<DataPoint> dpList) {
	        int index = -1;
	        for (DataPoint dataPoint : dpList) {
	            index++;
	            if (dataPoint.getName().equals(dp.getName())) {
	                return index;
	            }
	        }
	        return -1;
	    }

	   
	   private List<DataPoint> isKeyAndReturnObjects(DataPoint dataPoint,List<DataPoint> dataPoints,double radius,int ObjectNum){
	       List<DataPoint> arrivableObjects=new ArrayList<DataPoint>(); 
	       List<Double> distances=new ArrayList<Double>(); 
	       double coreDistance; 

	        for (int i = 0; i < dataPoints.size(); i++) {
	            DataPoint dp = dataPoints.get(i);
	            double distance = getDistance(dataPoint, dp);
	           // System.out.println(distance+"of"+dp.getDimensioin()[0]+"\n");
	            if (distance <= radius) {
	                distances.add(distance);
	                arrivableObjects.add(dp);
	            }
	        }

	       if(arrivableObjects.size()>=ObjectNum)
	       {
	           List<Double> newDistances=new ArrayList<Double>(distances);
	           Collections.sort(distances);
	           coreDistance=distances.get(ObjectNum-1);
	           
	           for(int j=0;j<arrivableObjects.size();j++)
	           {
	                if (coreDistance > newDistances.get(j)) 
	                {
	                    if(newDistances.get(j)==0){
	                        dataPoint.setReachableDistance(coreDistance);
	                    }
	                    arrivableObjects.get(j).setReachableDistance(coreDistance);
	                }else{
	                    arrivableObjects.get(j).setReachableDistance(newDistances.get(j));
	                }
	           }
	           return arrivableObjects;
	       }

	       return null;
	   }

   
   // Kilometer
   private double getDistance(DataPoint dp1,DataPoint dp2){
       double distance=0.0;
       double[] dim1=dp1.getDimensioin();
       double[] dim2=dp2.getDimensioin();
       double earth_radius=6378.137;  

       if(dim1.length==dim2.length){
       	double lat1=rad(dim1[0]);
       	double lat2=rad(dim2[0]);
       	double lon1=rad(dim1[1]);
       	double lon2=rad(dim2[1]);
          
           double a=lat1-lat2;
           double b=lon1-lon2;
           double s=2d * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2d),2d) + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin(b/2d),2d)));
              
           s = s * earth_radius;
           s = Math.round(s * 10000d) / 10000d;
           return s;
       }
       
       return distance;
   }
    
    private static double rad(double a)
    {
    	return a * Math.PI/180.0;
    }

    
}
